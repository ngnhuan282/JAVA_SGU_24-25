package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.AlphaComposite;
import javax.swing.*;

public class ThongKeGUI extends JPanel {
    private static final long serialVersionUID = 1L;

    public ThongKeGUI() {
        initComponents();
    }

    private void initComponents() {
        setPreferredSize(new Dimension(1248, 757));
        setLayout(null);
        setBackground(Color.WHITE);

        // TabbedPane để chuyển đổi giữa các trang
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(10, 10, 1228, 737);
        tabbedPane.setFont(new Font("Arial", Font.PLAIN, 16));
        add(tabbedPane);

        // Tab 1: Tổng quan
        JPanel pTongQuan = new JPanel();
        pTongQuan.setBackground(Color.WHITE);
        pTongQuan.setLayout(null);
        tabbedPane.addTab("Tổng quan", pTongQuan);

        // Tab 2: Thống kê chi tiết (Placeholder, sẽ chuyển sang GUI khác)
        JPanel pThongKeChiTiet = new JPanel();
        pThongKeChiTiet.setBackground(Color.WHITE);
        pThongKeChiTiet.setLayout(null);
        JLabel lblThongKe = new JLabel("Chuyển sang trang Thống kê chi tiết (Có thể tích hợp GUI khác)");
        lblThongKe.setBounds(10, 10, 1200, 30);
        lblThongKe.setFont(new Font("Arial", Font.PLAIN, 14));
        pThongKeChiTiet.add(lblThongKe);
        tabbedPane.addTab("Thống kê chi tiết", pThongKeChiTiet);

        // Header: TỔNG QUAN (riêng cho tab Tổng quan)
        JLabel lblHeader = new JLabel("TỔNG QUAN", SwingConstants.CENTER);
        lblHeader.setBounds(0, 10, 1228, 50);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 30));
        lblHeader.setForeground(new Color(255, 82, 82)); // Màu đỏ tương tự navbar
        pTongQuan.add(lblHeader);

        // 4 Panel trang trí trong Tab Tổng quan
        // Panel 1: Sản phẩm
        JPanel pSanPham = createDecorativePanel("Sản phẩm trong kho", "14", "/image/productTK100.png");
        pSanPham.setBounds(20, 70, 580, 280);
        pTongQuan.add(pSanPham);

        // Panel 2: Khách hàng
        JPanel pKhachHang = createDecorativePanel("Khách hàng trực tiếp", "18", "/image/clientIcon.png");
        pKhachHang.setBounds(620, 70, 580, 280);
        pTongQuan.add(pKhachHang);

        // Panel 3: Nhân viên
        JPanel pNhanVien = createDecorativePanel("Nhân viên đang hoạt động", "5", "/image/employeeIcon.png");
        pNhanVien.setBounds(20, 370, 580, 280);
        pTongQuan.add(pNhanVien);

        // Panel 4: Doanh thu
        JPanel pDoanhThu = createDecorativePanel("Doanh thu tháng này", "26.580.000đ", "/image/chart20.png");
        pDoanhThu.setBounds(620, 370, 580, 280);
        pTongQuan.add(pDoanhThu);
    }

    // Phương thức tạo panel trang trí
    private JPanel createDecorativePanel(String title, String value, String iconPath) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panel.setLayout(null);

        // Icon (ẩn phía dưới nội dung)
        ImageIcon originalIcon = new ImageIcon(ThongKeGUI.class.getResource(iconPath));
        ImageIcon fadedIcon = createFadedIcon(originalIcon, 0.5f); // Làm mờ icon với opacity 0.3
        JLabel lblIcon = new JLabel(fadedIcon);
        lblIcon.setBounds(400, 120, 150, 150); // Đặt icon ở góc phải dưới
        panel.add(lblIcon);

        // Tiêu đề
        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setBounds(20, 20, 540, 40);
        panel.add(lblTitle);

        // Giá trị
        JLabel lblValue = new JLabel(value);
        lblValue.setFont(new Font("Arial", Font.PLAIN, 36));
        lblValue.setForeground(new Color(255, 82, 82)); // Màu đỏ
        lblValue.setBounds(20, 70, 540, 50);
        panel.add(lblValue);

        return panel;
    }

    // Phương thức làm mờ icon
    private ImageIcon createFadedIcon(ImageIcon originalIcon, float opacity) {
        // Chuyển ImageIcon thành BufferedImage
        BufferedImage image = new BufferedImage(
            originalIcon.getIconWidth(),
            originalIcon.getIconHeight(),
            BufferedImage.TYPE_INT_ARGB
        );
        Graphics2D g2d = image.createGraphics();
        originalIcon.paintIcon(null, g2d, 0, 0);

        // Áp dụng độ trong suốt (opacity)
        BufferedImage fadedImage = new BufferedImage(
            originalIcon.getIconWidth(),
            originalIcon.getIconHeight(),
            BufferedImage.TYPE_INT_ARGB
        );
        g2d = fadedImage.createGraphics();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        return new ImageIcon(fadedImage);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test ThongKeGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1248, 757);
        frame.getContentPane().add(new ThongKeGUI());
        frame.setVisible(true);
    }
}