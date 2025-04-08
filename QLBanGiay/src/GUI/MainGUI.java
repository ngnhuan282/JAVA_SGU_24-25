package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class MainGUI extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int DEFAULT_WIDTH = 1450, DEFAULT_HEIGHT = 800;
    private String color = "#FF5252";
    private CardLayout cardLayout;
    private JPanel pContent;
    private JTextField txtSearch;
    private JButton btnThem, btnSua, btnXoa, btnXuatExcel, btnNhapExcel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainGUI frame = new MainGUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MainGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Hệ thống quản lý bán giày");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Navbar
        JPanel pNavbar = new JPanel();
        pNavbar.setBounds(5, 6, 230, 800);
        pNavbar.setPreferredSize(new Dimension(200, 800));
        pNavbar.setBackground(Color.decode(color));
        contentPane.add(pNavbar);
        pNavbar.setLayout(null);

        JPanel pAccount = new JPanel();
        pAccount.setBounds(0, 0, 230, 88);
        pAccount.setBackground(Color.decode(color));
        pNavbar.add(pAccount);
        pAccount.setLayout(null);

        JLabel lbInfo1 = new JLabel("Xin chào");
        lbInfo1.setIcon(new ImageIcon(MainGUI.class.getResource("/image/userIcon.png")));
        lbInfo1.setVerticalTextPosition(SwingConstants.BOTTOM);
        lbInfo1.setHorizontalTextPosition(SwingConstants.CENTER);
        lbInfo1.setForeground(Color.WHITE);
        lbInfo1.setBounds(16, 0, 200, 54);
        lbInfo1.setFont(new Font("Verdana", Font.BOLD, 14));
        lbInfo1.setHorizontalAlignment(SwingConstants.CENTER);
        pAccount.add(lbInfo1);

        JLabel lbInfo2 = new JLabel("Admin !");
        lbInfo2.setBounds(13, 49, 200, 33);
        lbInfo2.setForeground(Color.WHITE);
        lbInfo2.setFont(new Font("Verdana", Font.BOLD, 14));
        lbInfo2.setHorizontalAlignment(SwingConstants.CENTER);
        pAccount.add(lbInfo2);

        JPanel pNavItem = new JPanel();
        pNavItem.setBounds(0, 86, 230, 672);
        pNavItem.setBackground(Color.decode(color));
        pNavbar.add(pNavItem);
        pNavItem.setLayout(null);

        JButton btnDangXuat = new JButton("ĐĂNG XUẤT");
        btnDangXuat.setIcon(new ImageIcon(MainGUI.class.getResource("/image/logoutIcon.png")));
        btnDangXuat.setOpaque(true);
        btnDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
        btnDangXuat.setForeground(Color.WHITE);
        btnDangXuat.setFont(new Font("Verdana", Font.BOLD, 14));
        btnDangXuat.setBorderPainted(false);
        btnDangXuat.setBackground(Color.decode(color));
        btnDangXuat.setBounds(20, 600, 200, 35);
        pNavItem.add(btnDangXuat);

        JButton btnTrangChuGUI = new JButton("TRANG CHỦ");
        btnTrangChuGUI.setIcon(new ImageIcon(MainGUI.class.getResource("/image/homeIcon.png")));
        btnTrangChuGUI.setOpaque(true);
        btnTrangChuGUI.setHorizontalAlignment(SwingConstants.LEFT);
        btnTrangChuGUI.setForeground(Color.WHITE);
        btnTrangChuGUI.setFont(new Font("Verdana", Font.BOLD, 14));
        btnTrangChuGUI.setBorderPainted(false);
        btnTrangChuGUI.setBackground(Color.decode(color));
        btnTrangChuGUI.setBounds(20, 13, 200, 35);
        btnTrangChuGUI.addActionListener(this);
        pNavItem.add(btnTrangChuGUI);

        JButton btnSanPhamGUI = new JButton("SẢN PHẨM");
        btnSanPhamGUI.setIcon(new ImageIcon(MainGUI.class.getResource("/image/productIcon.png")));
        btnSanPhamGUI.setOpaque(true);
        btnSanPhamGUI.setHorizontalAlignment(SwingConstants.LEFT);
        btnSanPhamGUI.setForeground(Color.WHITE);
        btnSanPhamGUI.setFont(new Font("Verdana", Font.BOLD, 14));
        btnSanPhamGUI.setBorderPainted(false);
        btnSanPhamGUI.setBackground(Color.decode(color));
        btnSanPhamGUI.setBounds(20, 49, 200, 35);
        btnSanPhamGUI.addActionListener(this);
        pNavItem.add(btnSanPhamGUI);

        JButton btnNhaCungCapGUI = new JButton("NHÀ CUNG CẤP");
        btnNhaCungCapGUI.setIcon(new ImageIcon(MainGUI.class.getResource("/image/providerIcon.png")));
        btnNhaCungCapGUI.setOpaque(true);
        btnNhaCungCapGUI.setHorizontalAlignment(SwingConstants.LEFT);
        btnNhaCungCapGUI.setForeground(Color.WHITE);
        btnNhaCungCapGUI.setFont(new Font("Verdana", Font.BOLD, 14));
        btnNhaCungCapGUI.setBorderPainted(false);
        btnNhaCungCapGUI.setBackground(Color.decode(color));
        btnNhaCungCapGUI.setBounds(20, 85, 200, 35);
        btnNhaCungCapGUI.addActionListener(this);
        pNavItem.add(btnNhaCungCapGUI);

        JButton btnNhanVienGUI = new JButton("NHÂN VIÊN");
        btnNhanVienGUI.setIcon(new ImageIcon(MainGUI.class.getResource("/image/employeeIcon.png")));
        btnNhanVienGUI.setOpaque(true);
        btnNhanVienGUI.setHorizontalAlignment(SwingConstants.LEFT);
        btnNhanVienGUI.setForeground(Color.WHITE);
        btnNhanVienGUI.setFont(new Font("Verdana", Font.BOLD, 14));
        btnNhanVienGUI.setBorderPainted(false);
        btnNhanVienGUI.setBackground(Color.decode(color));
        btnNhanVienGUI.setBounds(20, 121, 200, 35);
        btnNhanVienGUI.addActionListener(this);
        pNavItem.add(btnNhanVienGUI);

        JButton btnKhachHangGUI = new JButton("KHÁCH HÀNG");
        btnKhachHangGUI.setIcon(new ImageIcon(MainGUI.class.getResource("/image/clientIcon.png")));
        btnKhachHangGUI.setOpaque(true);
        btnKhachHangGUI.setHorizontalAlignment(SwingConstants.LEFT);
        btnKhachHangGUI.setForeground(Color.WHITE);
        btnKhachHangGUI.setFont(new Font("Verdana", Font.BOLD, 14));
        btnKhachHangGUI.setBorderPainted(false);
        btnKhachHangGUI.setBackground(Color.decode(color));
        btnKhachHangGUI.setBounds(20, 157, 200, 35);
        btnKhachHangGUI.addActionListener(this);
        pNavItem.add(btnKhachHangGUI);

        JButton btnPhieuNhapGUI = new JButton("PHIẾU NHẬP");
        btnPhieuNhapGUI.setIcon(new ImageIcon(MainGUI.class.getResource("/image/phieuNhap.png")));
        btnPhieuNhapGUI.setOpaque(true);
        btnPhieuNhapGUI.setHorizontalAlignment(SwingConstants.LEFT);
        btnPhieuNhapGUI.setForeground(Color.WHITE);
        btnPhieuNhapGUI.setFont(new Font("Verdana", Font.BOLD, 14));
        btnPhieuNhapGUI.setBorderPainted(false);
        btnPhieuNhapGUI.setBackground(Color.decode(color));
        btnPhieuNhapGUI.setBounds(20, 193, 200, 35);
        btnPhieuNhapGUI.addActionListener(this);
        pNavItem.add(btnPhieuNhapGUI);

        JButton btnPhieuXuat = new JButton("PHIẾU XUẤT");
        btnPhieuXuat.setIcon(new ImageIcon(MainGUI.class.getResource("/image/phieuXuat.png")));
        btnPhieuXuat.setOpaque(true);
        btnPhieuXuat.setHorizontalAlignment(SwingConstants.LEFT);
        btnPhieuXuat.setForeground(Color.WHITE);
        btnPhieuXuat.setFont(new Font("Verdana", Font.BOLD, 14));
        btnPhieuXuat.setBorderPainted(false);
        btnPhieuXuat.setBackground(Color.decode(color));
        btnPhieuXuat.setBounds(20, 229, 200, 35);
        btnPhieuXuat.addActionListener(this);
        pNavItem.add(btnPhieuXuat);

        JButton btnKhuyenMaiGUI = new JButton("KHUYẾN MÃI");
        btnKhuyenMaiGUI.setIcon(new ImageIcon(MainGUI.class.getResource("/image/saleIcon.png")));
        btnKhuyenMaiGUI.setOpaque(true);
        btnKhuyenMaiGUI.setHorizontalAlignment(SwingConstants.LEFT);
        btnKhuyenMaiGUI.setForeground(Color.WHITE);
        btnKhuyenMaiGUI.setFont(new Font("Verdana", Font.BOLD, 14));
        btnKhuyenMaiGUI.setBorderPainted(false);
        btnKhuyenMaiGUI.setBackground(Color.decode(color));
        btnKhuyenMaiGUI.setBounds(20, 265, 200, 35);
        btnKhuyenMaiGUI.addActionListener(this);
        pNavItem.add(btnKhuyenMaiGUI);

        // Main content area
        JPanel pMain = new JPanel();
        pMain.setBackground(SystemColor.control);
        pMain.setBounds(233, 6, 1272, 757);
        contentPane.add(pMain);
        pMain.setLayout(null);

        JPanel pHeaderMain = new JPanel();
        pHeaderMain.setBounds(0, 0, 1206, 100);
        pHeaderMain.setBackground(Color.WHITE);
        pMain.add(pHeaderMain);
        pHeaderMain.setLayout(null);

        // Chức năng trong header
        JPanel pLeftHeader = new JPanel();
        pLeftHeader.setBorder(new TitledBorder(null, "Chức năng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pLeftHeader.setBackground(Color.WHITE);
        pLeftHeader.setBounds(2, 0, 512, 100);
        pHeaderMain.add(pLeftHeader);
        pLeftHeader.setLayout(null);

        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.setBorder(UIManager.getBorder("Button.border"));
        horizontalBox.setBounds(0, 0, 512, 111);
        pLeftHeader.add(horizontalBox);

        btnThem = new JButton("Thêm");
        horizontalBox.add(btnThem);
        btnThem.setFocusPainted(false);
        btnThem.setActionCommand("Thêm");
        btnThem.addActionListener(this);
        btnThem.setBackground(Color.WHITE);
        btnThem.setBorderPainted(false);
        btnThem.setIcon(new ImageIcon(MainGUI.class.getResource("/image/add48.png")));
        btnThem.setFont(new Font("Arial", Font.PLAIN, 15));
        btnThem.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnThem.setHorizontalTextPosition(SwingConstants.CENTER);
        btnThem.setPreferredSize(new Dimension(120, 140));

        btnSua = new JButton("Sửa");
        horizontalBox.add(btnSua);
        btnSua.setFocusPainted(false);
        btnSua.setActionCommand("Sửa");
        btnSua.addActionListener(this);
        btnSua.setBorderPainted(false);
        btnSua.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnSua.setPreferredSize(new Dimension(120, 140));
        btnSua.setIcon(new ImageIcon(MainGUI.class.getResource("/image/edit48.png")));
        btnSua.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSua.setFont(new Font("Arial", Font.PLAIN, 15));
        btnSua.setBackground(Color.WHITE);

        btnXoa = new JButton("Xóa");
        horizontalBox.add(btnXoa);
        btnXoa.setFocusPainted(false);
        btnXoa.setActionCommand("Xóa");
        btnXoa.addActionListener(this);
        btnXoa.setBorderPainted(false);
        btnXoa.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnXoa.setPreferredSize(new Dimension(120, 140));
        btnXoa.setIcon(new ImageIcon(MainGUI.class.getResource("/image/remove48.png")));
        btnXoa.setHorizontalTextPosition(SwingConstants.CENTER);
        btnXoa.setFont(new Font("Arial", Font.PLAIN, 15));
        btnXoa.setBackground(Color.WHITE);

        btnXuatExcel = new JButton("Xuất Excel");
        horizontalBox.add(btnXuatExcel);
        btnXuatExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnXuatExcel.setPreferredSize(new Dimension(120, 140));
        btnXuatExcel.setIcon(new ImageIcon(MainGUI.class.getResource("/image/excel48.png")));
        btnXuatExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnXuatExcel.setFont(new Font("Arial", Font.PLAIN, 15));
        btnXuatExcel.setBorderPainted(false);
        btnXuatExcel.setBackground(Color.WHITE);

        btnNhapExcel = new JButton("Nhập Excel");
        horizontalBox.add(btnNhapExcel);
        btnNhapExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNhapExcel.setPreferredSize(new Dimension(120, 140));
        btnNhapExcel.setIcon(new ImageIcon(MainGUI.class.getResource("/image/bill48.png")));
        btnNhapExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNhapExcel.setFont(new Font("Arial", Font.PLAIN, 15));
        btnNhapExcel.setBorderPainted(false);
        btnNhapExcel.setBackground(Color.WHITE);

        txtSearch = new JTextField();
        txtSearch.setBounds(771, 31, 290, 27);
        pHeaderMain.add(txtSearch);
        txtSearch.setColumns(10);

        JComboBox<String> cboxSearch = new JComboBox<>();
        cboxSearch.setFont(new Font("Arial", Font.PLAIN, 14));
        cboxSearch.setBounds(682, 30, 79, 28);
        cboxSearch.setBackground(Color.WHITE);
        cboxSearch.setForeground(Color.BLACK);
        cboxSearch.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        pHeaderMain.add(cboxSearch);

        JButton btnSearch = new JButton("");
        btnSearch.setIcon(new ImageIcon(MainGUI.class.getResource("/image/search30.png")));
        btnSearch.setBounds(1071, 22, 66, 39);
        pHeaderMain.add(btnSearch);

        // CardLayout for content
        cardLayout = new CardLayout();
        pContent = new JPanel(cardLayout);
        pContent.setBackground(Color.WHITE);
        pContent.setBounds(0, 103, 1248, 654);
        pMain.add(pContent);

        // Add panels to CardLayout
        pContent.add(new TrangChuGUI(), "TrangChu");
        pContent.add(new SanPhamGUI(), "SanPham");
        pContent.add(new NhaCungCapGUI(), "NhaCungCap");
        pContent.add(new NhanVienGUI(), "NhanVien");
        pContent.add(new KhachHangGUI(), "KhachHang");
        pContent.add(new PhieuNhapGUI(), "PhieuNhap");
        pContent.add(new PhieuXuatGUI(), "PhieuXuat");
        pContent.add(new KhuyenMaiGUI(), "KhuyenMai");

        // Default panel
        cardLayout.show(pContent, "TrangChu");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "TRANG CHỦ":
                cardLayout.show(pContent, "TrangChu");
                break;
            case "SẢN PHẨM":
                cardLayout.show(pContent, "SanPham");
                break;
            case "NHÀ CUNG CẤP":
                cardLayout.show(pContent, "NhaCungCap");
                break;
            case "NHÂN VIÊN":
                cardLayout.show(pContent, "NhanVien");
                break;
            case "KHÁCH HÀNG":
                cardLayout.show(pContent, "KhachHang");
                break;
            case "PHIẾU NHẬP":
                cardLayout.show(pContent, "PhieuNhap");
                break;
            case "PHIẾU XUẤT":
                cardLayout.show(pContent, "PhieuXuat");
                break;
            case "KHUYẾN MÃI":
                cardLayout.show(pContent, "KhuyenMai");
                break;
            case "ĐĂNG XUẤT":
                System.exit(0);
                break;
            case "Thêm":
                // Gọi phương thức thêm từ panel hiện tại (nếu cần)
                break;
            case "Sửa":
                // Gọi phương thức sửa từ panel hiện tại (nếu cần)
                break;
            case "Xóa":
                // Gọi phương thức xóa từ panel hiện tại (nếu cần)
                break;
        }
    }
    
 // Placeholder panels
    class TrangChuGUI extends JPanel {
        public TrangChuGUI() {
            setBackground(Color.WHITE);
            add(new JLabel("Đây là Trang Chủ", SwingConstants.CENTER));
        }
    }

    class NhaCungCapGUI extends JPanel {
        public NhaCungCapGUI() {
            setBackground(Color.WHITE);
            add(new JLabel("Đây là Nhà Cung Cấp", SwingConstants.CENTER));
        }
    }

    class NhanVienGUI extends JPanel {
        public NhanVienGUI() {
            setBackground(Color.WHITE);
            add(new JLabel("Đây là Nhân Viên", SwingConstants.CENTER));
        }
    }

    class KhachHangGUI extends JPanel {
        public KhachHangGUI() {
            setBackground(Color.WHITE);
            add(new JLabel("Đây là Khách Hàng", SwingConstants.CENTER));
        }
    }

    class PhieuNhapGUI extends JPanel {
        public PhieuNhapGUI() {
            setBackground(Color.WHITE);
            add(new JLabel("Đây là Phiếu Nhập", SwingConstants.CENTER));
        }
    }

    class PhieuXuatGUI extends JPanel {
        public PhieuXuatGUI() {
            setBackground(Color.WHITE);
            add(new JLabel("Đây là Phiếu Xuất", SwingConstants.CENTER));
        }
    }

    class KhuyenMaiGUI extends JPanel {
        public KhuyenMaiGUI() {
            setBackground(Color.WHITE);
            add(new JLabel("Đây là Khuyến Mãi", SwingConstants.CENTER));
        }
    }
}