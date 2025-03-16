package GUI;

import javax.swing.*;
import java.awt.*;

public class Navbar extends JPanel {
    private String color = "#FF7043"; // Màu của Navbar

    public Navbar() {
        setLayout(null);
        setPreferredSize(new Dimension(200, 800)); // Kích thước Navbar
        setBackground(Color.decode(color)); // Đặt màu nền của Navbar

        // Tạo phần thông tin tài khoản
        JPanel pAccount = new JPanel();
        pAccount.setBounds(0, 0, 200, 67);
        add(pAccount);
        pAccount.setBackground(Color.decode(color));
        pAccount.setLayout(null);

        JLabel lbInfo1 = new JLabel("Xin chào");
        lbInfo1.setForeground(Color.WHITE);
        lbInfo1.setBounds(0, 0, 200, 33);
        lbInfo1.setFont(new Font("Verdana", Font.BOLD, 14));
        lbInfo1.setHorizontalAlignment(SwingConstants.CENTER);
        pAccount.add(lbInfo1);

        JLabel lbInfo2 = new JLabel("Admin!");
        lbInfo2.setForeground(Color.WHITE);
        lbInfo2.setBounds(0, 24, 200, 33);
        lbInfo2.setFont(new Font("Verdana", Font.BOLD, 14));
        lbInfo2.setHorizontalAlignment(SwingConstants.CENTER);
        pAccount.add(lbInfo2);

        // Tạo phần các button điều hướng
        JPanel pNavItem = new JPanel();
        pNavItem.setBounds(0, 66, 200, 734);
        pNavItem.setBackground(Color.decode(color));
        add(pNavItem);
        pNavItem.setLayout(null);

        // Các button điều hướng
        JButton btnTrangChuGUI = createNavButton("TRANG CHỦ", 0);
        pNavItem.add(btnTrangChuGUI);

        JButton btnSanPhamGUI = createNavButton("SẢN PHẨM", 38);
        pNavItem.add(btnSanPhamGUI);

        JButton btnNhaCungCapGUI = createNavButton("NHÀ CUNG CẤP", 72);
        pNavItem.add(btnNhaCungCapGUI);

        JButton btnNhanVienGUI = createNavButton("NHÂN VIÊN", 107);
        pNavItem.add(btnNhanVienGUI);

        JButton btnKhachHangGUI = createNavButton("KHÁCH HÀNG", 141);
        pNavItem.add(btnKhachHangGUI);

        JButton btnPhieuNhapGUI = createNavButton("PHIẾU NHẬP", 173);
        pNavItem.add(btnPhieuNhapGUI);

        JButton btnPhieuXuat = createNavButton("PHIẾU XUẤT", 207);
        pNavItem.add(btnPhieuXuat);

        JButton btnKhuyenMaiGUI = createNavButton("KHUYẾN MÃI", 242);
        pNavItem.add(btnKhuyenMaiGUI);
    }

    // Hàm để tạo các nút điều hướng
    private JButton createNavButton(String text, int yPosition) {
        JButton button = new JButton(text);
        button.setOpaque(true);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Verdana", Font.BOLD, 14));
        button.setBorderPainted(false);
        button.setBackground(new Color(255, 112, 67));
        button.setBounds(0, yPosition, 200, 35); // Đặt vị trí và kích thước cho các button
        return button;
    }
}
