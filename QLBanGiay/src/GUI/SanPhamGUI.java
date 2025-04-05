package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.SanPhamBUS;
import DTO.SanPhamDTO;
import java.awt.CardLayout;
import javax.swing.Box;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.BoxLayout;

public class SanPhamGUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int DEFAULT_WIDTH = 1450, DEFAULT_HEIGHT = 800;
    private String color = "#FF5252";
    private JLabel lbMaSP, lbTenSP, lbDonGia, lbDonViTinh, lbSoLuong, lbMaLoaiSP;
    private DefaultTableModel model;
//    private SanPhamBUS spBUS = new SanPhamBUS();
    private JTextField txtSearch;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SanPhamGUI frame = new SanPhamGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SanPhamGUI() {
        Object[] header = {"Mã Sản Phẩm", "Tên Sản Phẩm", "Loại", "Giá", "Số Lượng", "Đơn vị tính"};
        model = new DefaultTableModel(header, 0);
        initComponents();
        loadDataDemo(); 
    }
    
    private void loadDataDemo() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{"SP001", "Nike Air Force 1", "Nike", 2500000, 10, "Đôi"});
        model.addRow(new Object[]{"SP002", "Adidas Ultraboost", "Adidas", 2800000, 5, "Đôi"});
        model.addRow(new Object[]{"SP003", "Converse Chuck Taylor", "Converse", 1500000, 8, "Đôi"});
        model.addRow(new Object[]{"SP001", "Nike Air Force 1", "Nike", 2500000, 10, "Đôi"});
        model.addRow(new Object[]{"SP002", "Adidas Ultraboost", "Adidas", 2800000, 5, "Đôi"});
        model.addRow(new Object[]{"SP003", "Converse Chuck Taylor", "Converse", 1500000, 8, "Đôi"});
        model.addRow(new Object[]{"SP001", "Nike Air Force 1", "Nike", 2500000, 10, "Đôi"});
        model.addRow(new Object[]{"SP002", "Adidas Ultraboost", "Adidas", 2800000, 5, "Đôi"});
        model.addRow(new Object[]{"SP003", "Converse Chuck Taylor", "Converse", 1500000, 8, "Đôi"});
        model.addRow(new Object[]{"SP001", "Nike Air Force 1", "Nike", 2500000, 10, "Đôi"});
        model.addRow(new Object[]{"SP002", "Adidas Ultraboost", "Adidas", 2800000, 5, "Đôi"});
        model.addRow(new Object[]{"SP003", "Converse Chuck Taylor", "Converse", 1500000, 8, "Đôi"});
        model.addRow(new Object[]{"SP001", "Nike Air Force 1", "Nike", 2500000, 10, "Đôi"});
        model.addRow(new Object[]{"SP002", "Adidas Ultraboost", "Adidas", 2800000, 5, "Đôi"});
        model.addRow(new Object[]{"SP003", "Converse Chuck Taylor", "Converse", 1500000, 8, "Đôi"});
        model.addRow(new Object[]{"SP001", "Nike Air Force 1", "Nike", 2500000, 10, "Đôi"});
        model.addRow(new Object[]{"SP002", "Adidas Ultraboost", "Adidas", 2800000, 5, "Đôi"});
        model.addRow(new Object[]{"SP003", "Converse Chuck Taylor", "Converse", 1500000, 8, "Đôi"});
        model.addRow(new Object[]{"SP001", "Nike Air Force 1", "Nike", 2500000, 10, "Đôi"});
        model.addRow(new Object[]{"SP002", "Adidas Ultraboost", "Adidas", 2800000, 5, "Đôi"});
        model.addRow(new Object[]{"SP003", "Converse Chuck Taylor", "Converse", 1500000, 8, "Đôi"});
        model.addRow(new Object[]{"SP001", "Nike Air Force 1", "Nike", 2500000, 10, "Đôi"});
        model.addRow(new Object[]{"SP002", "Adidas Ultraboost", "Adidas", 2800000, 5, "Đôi"});
        model.addRow(new Object[]{"SP003", "Converse Chuck Taylor", "Converse", 1500000, 8, "Đôi"});
        model.addRow(new Object[]{"SP003", "Converse Chuck Taylor", "Converse", 1500000, 8, "Đôi"});
        model.addRow(new Object[]{"SP001", "Nike Air Force 1", "Nike", 2500000, 10, "Đôi"});
        model.addRow(new Object[]{"SP002", "Adidas Ultraboost", "Adidas", 2800000, 5, "Đôi"});
        model.addRow(new Object[]{"SP003", "Converse Chuck Taylor", "Converse", 1500000, 8, "Đôi"});
        model.addRow(new Object[]{"SP001", "Nike Air Force 1", "Nike", 2500000, 10, "Đôi"});
        model.addRow(new Object[]{"SP002", "Adidas Ultraboost", "Adidas", 2800000, 5, "Đôi"});
        model.addRow(new Object[]{"SP003", "Converse Chuck Taylor", "Converse", 1500000, 8, "Đôi"});
        model.addRow(new Object[]{"SP001", "Nike Air Force 1", "Nike", 2500000, 10, "Đôi"});
        model.addRow(new Object[]{"SP002", "Adidas Ultraboost", "Adidas", 2800000, 5, "Đôi"});
        model.addRow(new Object[]{"SP003", "Converse Chuck Taylor", "Converse", 1500000, 8, "Đôi"});
    }
//    public void loadData() {
//        model.setRowCount(0);
//        for (SanPhamDTO sp : spBUS.getDssp()) {
//            Object[] row = {sp.getMaSP(), sp.getTenSP(), sp.getMaLoaiSP(), sp.getDonGia(), sp.getSoLuong(), sp.getDonViTinh()};
//            model.addRow(row);
//        }
//    }
    
    public void initComponents() {
        setTitle("Hệ thống quản lý bán giày");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel pHeader = new JPanel();
        pHeader.setBounds(5, 5, 1500, 1);
        contentPane.add(pHeader);
        pHeader.setLayout(null);

        JPanel pMain = new JPanel();
        pMain.setBackground(SystemColor.control);
        pMain.setBounds(233, 6, 1272, 800);
        contentPane.add(pMain);
        pMain.setLayout(null);

        JPanel pHeaderMain = new JPanel();
        pHeaderMain.setBounds(0, 0, 1272, 748);
        pHeaderMain.setBackground(Color.WHITE);
        pMain.add(pHeaderMain);

        JPanel pNavbar = new JPanel();
        pNavbar.setBounds(5, 6, 230, 800);
        contentPane.add(pNavbar);
        pNavbar.setLayout(null);
        pNavbar.setPreferredSize(new Dimension(200, 800));
        pNavbar.setBackground(Color.decode(color));

        JPanel pAccount = new JPanel();
        pAccount.setBounds(0, 0, 230, 88);
        pNavbar.add(pAccount);
        pAccount.setBackground(Color.decode(color));
        pAccount.setLayout(null);

        JLabel lbInfo1 = new JLabel("Xin chào");
        lbInfo1.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/userIcon.png")));
        lbInfo1.setVerticalTextPosition(SwingConstants.BOTTOM);
        lbInfo1.setHorizontalTextPosition(SwingConstants.CENTER);
        lbInfo1.setForeground(Color.WHITE);
        lbInfo1.setBounds(16, 0, 200, 54);
        lbInfo1.setFont(new Font("Verdana", Font.BOLD, 14));
        lbInfo1.setHorizontalAlignment(SwingConstants.CENTER);
        pAccount.add(lbInfo1);

        JLabel lbInfo2 = new JLabel("Admin !");
        lbInfo2.setBounds(13, 49, 200, 33);
        pAccount.add(lbInfo2);
        lbInfo2.setForeground(Color.WHITE);
        lbInfo2.setFont(new Font("Verdana", Font.BOLD, 14));
        lbInfo2.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel pNavItem = new JPanel();
        pNavItem.setBounds(0, 86, 230, 672);
        pNavItem.setBackground(Color.decode(color));
        pNavbar.add(pNavItem);
        pNavItem.setLayout(null);

        JButton btnDangXuat = new JButton("ĐĂNG XUẤT");
        btnDangXuat.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/logoutIcon.png")));
        btnDangXuat.setOpaque(true);
        btnDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
        btnDangXuat.setForeground(Color.WHITE);
        btnDangXuat.setFont(new Font("Verdana", Font.BOLD, 14));
        btnDangXuat.setBorderPainted(false);
        btnDangXuat.setBackground(Color.decode(color));
        btnDangXuat.setBounds(20, 600, 200, 35);
        pNavItem.add(btnDangXuat);

        JButton btnTrangChuGUI = new JButton("TRANG CHỦ");
        btnTrangChuGUI.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnTrangChuGUI.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/homeIcon.png")));
        btnTrangChuGUI.setOpaque(true);
        btnTrangChuGUI.setHorizontalAlignment(SwingConstants.LEFT);
        btnTrangChuGUI.setForeground(Color.WHITE);
        btnTrangChuGUI.setFont(new Font("Verdana", Font.BOLD, 14));
        btnTrangChuGUI.setBorderPainted(false);
        btnTrangChuGUI.setBackground(Color.decode(color));
        btnTrangChuGUI.setBounds(20, 13, 200, 35);
        pNavItem.add(btnTrangChuGUI);

        JButton btnSanPhamGUI = new JButton("SẢN PHẨM");
        btnSanPhamGUI.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/productIcon.png")));
        btnSanPhamGUI.setOpaque(true);
        btnSanPhamGUI.setHorizontalAlignment(SwingConstants.LEFT);
        btnSanPhamGUI.setForeground(Color.WHITE);
        btnSanPhamGUI.setFont(new Font("Verdana", Font.BOLD, 14));
        btnSanPhamGUI.setBorderPainted(false);
        btnSanPhamGUI.setBackground(Color.decode(color));
        btnSanPhamGUI.setBounds(20, 49, 200, 35);
        pNavItem.add(btnSanPhamGUI);

        JButton btnNhaCungCapGUI = new JButton("NHÀ CUNG CẤP");
        btnNhaCungCapGUI.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/providerIcon.png")));
        btnNhaCungCapGUI.setOpaque(true);
        btnNhaCungCapGUI.setHorizontalAlignment(SwingConstants.LEFT);
        btnNhaCungCapGUI.setForeground(Color.WHITE);
        btnNhaCungCapGUI.setFont(new Font("Verdana", Font.BOLD, 14));
        btnNhaCungCapGUI.setBorderPainted(false);
        btnNhaCungCapGUI.setBackground(Color.decode(color));
        btnNhaCungCapGUI.setBounds(20, 85, 200, 35);
        pNavItem.add(btnNhaCungCapGUI);

        JButton btnNhanVienGUI = new JButton("NHÂN VIÊN");
        btnNhanVienGUI.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/employeeIcon.png")));
        btnNhanVienGUI.setOpaque(true);
        btnNhanVienGUI.setHorizontalAlignment(SwingConstants.LEFT);
        btnNhanVienGUI.setForeground(Color.WHITE);
        btnNhanVienGUI.setFont(new Font("Verdana", Font.BOLD, 14));
        btnNhanVienGUI.setBorderPainted(false);
        btnNhanVienGUI.setBackground(Color.decode(color));
        btnNhanVienGUI.setBounds(20, 121, 200, 35);
        pNavItem.add(btnNhanVienGUI);

        JButton btnKhachHangGUI = new JButton("KHÁCH HÀNG");
        btnKhachHangGUI.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/clientIcon.png")));
        btnKhachHangGUI.setOpaque(true);
        btnKhachHangGUI.setHorizontalAlignment(SwingConstants.LEFT);
        btnKhachHangGUI.setForeground(Color.WHITE);
        btnKhachHangGUI.setFont(new Font("Verdana", Font.BOLD, 14));
        btnKhachHangGUI.setBorderPainted(false);
        btnKhachHangGUI.setBackground(Color.decode(color));
        btnKhachHangGUI.setBounds(20, 157, 200, 35);
        pNavItem.add(btnKhachHangGUI);

        JButton btnPhieuNhapGUI = new JButton("PHIẾU NHẬP");
        btnPhieuNhapGUI.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/phieuNhap.png")));
        btnPhieuNhapGUI.setOpaque(true);
        btnPhieuNhapGUI.setHorizontalAlignment(SwingConstants.LEFT);
        btnPhieuNhapGUI.setForeground(Color.WHITE);
        btnPhieuNhapGUI.setFont(new Font("Verdana", Font.BOLD, 14));
        btnPhieuNhapGUI.setBorderPainted(false);
        btnPhieuNhapGUI.setBackground(Color.decode(color));
        btnPhieuNhapGUI.setBounds(20, 193, 200, 35);
        pNavItem.add(btnPhieuNhapGUI);

        JButton btnPhieuXuat = new JButton("PHIẾU XUẤT");
        btnPhieuXuat.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/phieuXuat.png")));
        btnPhieuXuat.setOpaque(true);
        btnPhieuXuat.setHorizontalAlignment(SwingConstants.LEFT);
        btnPhieuXuat.setForeground(Color.WHITE);
        btnPhieuXuat.setFont(new Font("Verdana", Font.BOLD, 14));
        btnPhieuXuat.setBorderPainted(false);
        btnPhieuXuat.setBackground(Color.decode(color));
        btnPhieuXuat.setBounds(20, 229, 200, 35);
        pNavItem.add(btnPhieuXuat);

        JButton btnKhuyenMaiGUI = new JButton("KHUYẾN MÃI");
        btnKhuyenMaiGUI.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/saleIcon.png")));
        btnKhuyenMaiGUI.setOpaque(true);
        btnKhuyenMaiGUI.setHorizontalAlignment(SwingConstants.LEFT);
        btnKhuyenMaiGUI.setForeground(Color.WHITE);
        btnKhuyenMaiGUI.setFont(new Font("Verdana", Font.BOLD, 14));
        btnKhuyenMaiGUI.setBorderPainted(false);
        btnKhuyenMaiGUI.setBackground(Color.decode(color));
        btnKhuyenMaiGUI.setBounds(20, 265, 200, 35);
        pNavItem.add(btnKhuyenMaiGUI);

        pHeaderMain.setPreferredSize(new Dimension(DEFAULT_WIDTH, 100));
        pHeaderMain.setLayout(null);

        JPanel pLeftHeader = new JPanel();
        pLeftHeader.setBackground(Color.WHITE);
        pLeftHeader.setBounds(2, 0, 512, 100);
        pHeaderMain.add(pLeftHeader);
        pLeftHeader.setLayout(null);

        JButton btnThem = new JButton("Thêm");
        btnThem.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnThem.setActionCommand("Thêm");
        btnThem.addActionListener(this);
        btnThem.setBackground(SystemColor.text);
        btnThem.setBorderPainted(false);
        btnThem.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/add48.png")));
        btnThem.setFont(new Font("Arial", Font.PLAIN, 15));
        btnThem.setBounds(0, 0, 84, 100);
        btnThem.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnThem.setHorizontalTextPosition(SwingConstants.CENTER);
        btnThem.setPreferredSize(new Dimension(120, 140));
        pLeftHeader.add(btnThem);

        JButton btnSua = new JButton("Sửa");
        btnSua.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        btnSua.setActionCommand("Sửa");
        btnSua.addActionListener(this);
        btnSua.setBorderPainted(false);
        btnSua.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnSua.setPreferredSize(new Dimension(120, 140));
        btnSua.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/edit48.png")));
        btnSua.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSua.setFont(new Font("Arial", Font.PLAIN, 15));
        btnSua.setBackground(Color.WHITE);
        btnSua.setBounds(70, 0, 93, 100);
        pLeftHeader.add(btnSua);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.setActionCommand("Xóa");
        btnXoa.addActionListener(this);
        btnXoa.setBorderPainted(false);
        btnXoa.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnXoa.setPreferredSize(new Dimension(120, 140));
        btnXoa.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/remove48.png")));
        btnXoa.setHorizontalTextPosition(SwingConstants.CENTER);
        btnXoa.setFont(new Font("Arial", Font.PLAIN, 15));
        btnXoa.setBackground(Color.WHITE);
        btnXoa.setBounds(140, 0, 84, 100);
        pLeftHeader.add(btnXoa);

        JButton btnXuatExcel = new JButton("Xuất Excel");
        btnXuatExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnXuatExcel.setPreferredSize(new Dimension(120, 140));
        btnXuatExcel.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/excel48.png")));
        btnXuatExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnXuatExcel.setFont(new Font("Arial", Font.PLAIN, 15));
        btnXuatExcel.setBorderPainted(false);
        btnXuatExcel.setBackground(Color.WHITE);
        btnXuatExcel.setBounds(220, 0, 108, 100);
        pLeftHeader.add(btnXuatExcel);

        JButton btnNhapExcel = new JButton("Nhập Excel");
        btnNhapExcel.setBounds(327, 0, 114, 100);
        pLeftHeader.add(btnNhapExcel);
        btnNhapExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNhapExcel.setPreferredSize(new Dimension(120, 140));
        btnNhapExcel.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/bill48.png")));
        btnNhapExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNhapExcel.setFont(new Font("Arial", Font.PLAIN, 15));
        btnNhapExcel.setBorderPainted(false);
        btnNhapExcel.setBackground(Color.WHITE);
        
        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.setBorder(UIManager.getBorder("Button.border"));
        horizontalBox.setBounds(0, 0, 512, 100);
        pLeftHeader.add(horizontalBox);
        
        txtSearch = new JTextField();
        txtSearch.setBounds(771, 31, 290, 41);
        pHeaderMain.add(txtSearch);
        txtSearch.setColumns(10);
        
        JComboBox cboxSearch = new JComboBox();
        cboxSearch.setBounds(656, 33, 77, 37);
        pHeaderMain.add(cboxSearch);
        
        JButton btnSearch = new JButton("");
        btnSearch.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/seach48.png")));
        btnSearch.setBounds(1078, 29, 66, 41);
        pHeaderMain.add(btnSearch);
        
        JPanel pContent = new JPanel();
        pContent.setBackground(SystemColor.text);
        pContent.setBounds(2, 101, 1204, 655);
        pHeaderMain.add(pContent);
        pContent.setLayout(null);
        
        table = new JTable(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "Lo\u1EA1i", "Gi\u00E1", "S\u1ED1 L\u01B0\u1EE3ng", "\u0110\u01A1n v\u1ECB t\u00EDnh"
        	}
        ));
        table.setBackground(SystemColor.text);
        table.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
        table.setFillsViewportHeight(true);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(305, 270, 745, 363);
        pContent.add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Thêm":
                openProductDialog(false);
                break;
            case "Sửa":
            	openProductDialog(true);
                break;
            case "Xóa":
            	deleteProduct();
                break;
            default:
                break;
        }
    }

    public void openProductDialog(boolean isEditMode) {
        JDialog productDialog = new JDialog(this, isEditMode ? "Sửa Sản Phẩm" : "Thêm Sản Phẩm", true);
        productDialog.setBounds(100, 100, 459, 582); // Kích thước giống FormThemSP
        productDialog.setLocationRelativeTo(this);

        JPanel panelMain = new JPanel();
        panelMain.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelMain.setLayout(null);
        productDialog.getContentPane().add(panelMain);

        // Header
        JLabel lbHeader = new JLabel(isEditMode ? "SỬA SẢN PHẨM" : "THÊM SẢN PHẨM");
        lbHeader.setBounds(5, 5, 453, 31);
        lbHeader.setForeground(Color.WHITE);
        lbHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lbHeader.setFont(new Font("Arial", Font.BOLD, 20));
        lbHeader.setBackground(Color.decode("#FF5252"));
        lbHeader.setOpaque(true);
        panelMain.add(lbHeader);

        // Panel chứa các trường
        JPanel panel = new JPanel();
        panel.setBounds(5, 31, 440, 514);
        panel.setLayout(null);
        panelMain.add(panel);

        // Các trường từ FormThemSP
        JLabel lbMaSP = new JLabel("Mã sản phẩm");
        lbMaSP.setFont(new Font("Arial", Font.PLAIN, 14));
        lbMaSP.setBounds(10, 21, 100, 23);
        panel.add(lbMaSP);

        JTextField txtMaSP = new JTextField();
        txtMaSP.setBounds(10, 46, 185, 32);
        panel.add(txtMaSP);

        JLabel lbTenSP = new JLabel("Tên sản phẩm");
        lbTenSP.setFont(new Font("Arial", Font.PLAIN, 14));
        lbTenSP.setBounds(10, 101, 100, 23);
        panel.add(lbTenSP);

        JTextField txtTenSP = new JTextField();
        txtTenSP.setBounds(10, 126, 185, 32);
        panel.add(txtTenSP);

        JLabel lbDonGia = new JLabel("Đơn giá");
        lbDonGia.setFont(new Font("Arial", Font.PLAIN, 14));
        lbDonGia.setBounds(10, 181, 100, 23);
        panel.add(lbDonGia);

        JTextField txtDonGia = new JTextField();
        txtDonGia.setBounds(10, 206, 185, 32);
        panel.add(txtDonGia);

        JLabel lbDonViTinh = new JLabel("Đơn vị tính");
        lbDonViTinh.setFont(new Font("Arial", Font.PLAIN, 14));
        lbDonViTinh.setBounds(10, 248, 100, 23);
        panel.add(lbDonViTinh);

        JTextField txtDonViTinh = new JTextField("Đôi"); // Mặc định là "Đôi"
        txtDonViTinh.setBounds(10, 273, 185, 32);
        panel.add(txtDonViTinh);

        JLabel lbSoLuong = new JLabel("Số lượng");
        lbSoLuong.setFont(new Font("Arial", Font.PLAIN, 14));
        lbSoLuong.setBounds(10, 328, 122, 23);
        panel.add(lbSoLuong);

        JTextField txtSoLuong = new JTextField();
        txtSoLuong.setBounds(10, 353, 185, 32);
        panel.add(txtSoLuong);

        JLabel lbChatLieu = new JLabel("Chất liệu");
        lbChatLieu.setFont(new Font("Arial", Font.PLAIN, 14));
        lbChatLieu.setBounds(234, 248, 122, 23);
        panel.add(lbChatLieu);

        JTextField txtChatLieu = new JTextField();
        txtChatLieu.setBounds(234, 273, 185, 32);
        panel.add(txtChatLieu);

        JLabel lbKichThuoc = new JLabel("Kích thước");
        lbKichThuoc.setFont(new Font("Arial", Font.PLAIN, 14));
        lbKichThuoc.setBounds(234, 181, 122, 23);
        panel.add(lbKichThuoc);

        JComboBox<String> cboxKichThuoc = new JComboBox<>(new String[]{"39", "40", "41", "42", "43"});
        cboxKichThuoc.setFont(new Font("Arial", Font.PLAIN, 12));
        cboxKichThuoc.setBounds(234, 206, 100, 30);
        panel.add(cboxKichThuoc);

        JLabel lbKieuDang = new JLabel("Kiểu dáng");
        lbKieuDang.setFont(new Font("Arial", Font.PLAIN, 14));
        lbKieuDang.setBounds(234, 328, 122, 23);
        panel.add(lbKieuDang);

        JTextField txtKieuDang = new JTextField();
        txtKieuDang.setBounds(234, 353, 185, 32);
        panel.add(txtKieuDang);

        JLabel lbMoTa = new JLabel("Mô tả");
        lbMoTa.setHorizontalAlignment(SwingConstants.CENTER);
        lbMoTa.setFont(new Font("Arial", Font.PLAIN, 14));
        lbMoTa.setBounds(144, 395, 122, 23);
        panel.add(lbMoTa);

        JTextField taMoTa = new JTextField(); // Có thể thay bằng JTextArea nếu cần
        taMoTa.setBounds(10, 416, 409, 51);
        panel.add(taMoTa);

        JLabel lbMauSac = new JLabel("Màu sắc");
        lbMauSac.setFont(new Font("Arial", Font.PLAIN, 14));
        lbMauSac.setBounds(234, 101, 100, 23);
        panel.add(lbMauSac);

        JRadioButton rbDen = new JRadioButton("Đen");
        rbDen.setFont(new Font("Arial", Font.PLAIN, 13));
        rbDen.setBounds(229, 131, 50, 21);
        panel.add(rbDen);

        JRadioButton rbTrang = new JRadioButton("Trắng");
        rbTrang.setFont(new Font("Arial", Font.PLAIN, 13));
        rbTrang.setBounds(281, 131, 64, 21);
        panel.add(rbTrang);

        JRadioButton rbXam = new JRadioButton("Xám");
        rbXam.setFont(new Font("Arial", Font.PLAIN, 13));
        rbXam.setBounds(348, 131, 55, 21);
        panel.add(rbXam);

        ButtonGroup bgMauSac = new ButtonGroup();
        bgMauSac.add(rbDen);
        bgMauSac.add(rbTrang);
        bgMauSac.add(rbXam);

        JLabel lbMaLoaiSP = new JLabel("Mã loại sản phẩm");
        lbMaLoaiSP.setFont(new Font("Arial", Font.PLAIN, 14));
        lbMaLoaiSP.setBounds(234, 21, 122, 23);
        panel.add(lbMaLoaiSP);

        JTextField txtMaLoaiSP = new JTextField();
        txtMaLoaiSP.setBounds(234, 46, 185, 32);
        panel.add(txtMaLoaiSP);

        // Các nút hành động
        JButton btnAction = new JButton(isEditMode ? "Cập nhật" : "Thêm");
        btnAction.setBounds(20, 479, 109, 25);
        btnAction.setForeground(Color.WHITE);
        btnAction.setFont(new Font("Arial", Font.BOLD, 14));
        btnAction.setBackground(Color.decode("#00C853"));
        btnAction.setOpaque(true);
        panel.add(btnAction);

        JButton btnXoaSP = new JButton("Xóa");
        btnXoaSP.setOpaque(true);
        btnXoaSP.setForeground(Color.WHITE);
        btnXoaSP.setFont(new Font("Arial", Font.BOLD, 14));
        btnXoaSP.setBackground(Color.ORANGE);
        btnXoaSP.setBounds(157, 479, 109, 25);
        panel.add(btnXoaSP);// Chỉ hiển thị khi ở chế độ sửa

        JButton btnDong = new JButton("Đóng");
        btnDong.setOpaque(true);
        btnDong.setForeground(Color.WHITE);
        btnDong.setFont(new Font("Arial", Font.BOLD, 14));
        btnDong.setBackground(Color.decode("#E53935"));
        btnDong.setBounds(291, 479, 109, 25);
        panel.add(btnDong);

        
        /*****ĐỔ DỮ LIỆU VÀO TEXTFIELD NẾU LÀ SỬA******/
        if(isEditMode == true)
        {
        	 int i = table.getSelectedRow();
             if(i >= 0)
             {
             	txtMaSP.setText(table.getValueAt(i, 0).toString());
             	txtTenSP.setText(table.getValueAt(i, 1).toString());
             	txtMaLoaiSP.setText(table.getValueAt(i, 2).toString());
             	txtDonGia.setText(table.getValueAt(i, 3).toString());
             	txtSoLuong.setText(table.getValueAt(i, 4).toString());
             	txtDonViTinh.setText(table.getValueAt(i, 5).toString());
             }
             else
             {
            	 JOptionPane.showMessageDialog(productDialog, "Vui lòng chọn một sản phẩm để sửa !");
            	 productDialog.dispose();
            	 return;
             }
        }
       
        /***XỬ LÝ SỰ KIỆN THÊM / SỬA***/
        btnAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String maSP= txtMaSP.getText();
					String tenSP = txtTenSP.getText();
					String soLuongText = txtSoLuong.getText();
					String donGiaText = txtDonGia.getText();
					String maLoaiSP = txtMaLoaiSP.getText();
					String donViTinh = txtDonViTinh.getText();
					String kieuDang = txtKieuDang.getText();
					String chatLieu = txtChatLieu.getText();
					String kichThuoc = cboxKichThuoc.getSelectedItem().toString();
					String mauSac = bgMauSac.getSelection().toString();
					
					int soLuong = Integer.parseInt(soLuongText);
					double donGia = Double.parseDouble(donGiaText);
					
					SanPhamDTO sp = new SanPhamDTO(maLoaiSP, tenSP, soLuong, donGia, donViTinh, maSP);
					
					if(isEditMode)
					{	
						SanPhamBUS spBUS = new SanPhamBUS();
						//Cập nhật vào spBUS
						spBUS.updateSP(sp);
						
						//Set lại model
						int i = table.getSelectedRow();
						model.setValueAt(maSP, i, 0);
						model.setValueAt(tenSP, i, 1);
						model.setValueAt(maLoaiSP, i, 2);
						model.setValueAt(donGia, i, 3);
						model.setValueAt(soLuong, i, 4);
						model.setValueAt(donViTinh, i, 5);
						JOptionPane.showMessageDialog(productDialog, "Cập nhật sản phẩm thành công",
								"Thành công", JOptionPane.INFORMATION_MESSAGE);
					}
					else //Nếu là thêm
					{	
						SanPhamBUS spBUS = new SanPhamBUS();
						spBUS.addSP(sp);
						Object [] row = {maSP, tenSP, maLoaiSP, donGia, soLuong, donViTinh};
						model.addRow(row);
						table.setModel(model);
						JOptionPane.showMessageDialog(productDialog, "Thêm sản phẩm thành công",
														"Thành công", JOptionPane.INFORMATION_MESSAGE);
					}
					productDialog.dispose();
				} catch (NumberFormatException ex) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(productDialog, "Vui lòng nhập định dạng số cho Số lượng, Đơn giá !",
													"Lỗi", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
        
        btnDong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				productDialog.dispose();
			}
		});
        productDialog.setVisible(true);
    }
    
    
    public void deleteProduct()
    {
    	int i = table.getSelectedRow();
    	if(i >= 0)
    	{
    		String maSP = table.getValueAt(i, 0).toString();
    		String tenSP = table.getValueAt(i, 1).toString();
    		System.out.println("Deleting MaSP: " + maSP + ", TenSP: " + tenSP); // Debug
    		int confirm = JOptionPane.showConfirmDialog(this, 
    				"Bạn có chắc muốn xóa sản phẩm " +tenSP + " có mã " +maSP + " không?",
    				"Xác nhận xóa", JOptionPane.YES_NO_OPTION);
    		
    		if(confirm == JOptionPane.YES_OPTION)
    		{
    			try {
    				SanPhamBUS spBUS = new SanPhamBUS();
    				//Xóa sp trong spBUS
					spBUS.deleteSP(maSP);
					
					//Xóa sp khỏi model
					model.removeRow(i);
					
					JOptionPane.showMessageDialog(this, "Xóa sản phẩm " +tenSP + "có mã " +maSP +"thành công",
							"Thành công", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, "Lỗi xóa sản phẩm" +e.getMessage(), 
							"Lỗi", JOptionPane.ERROR_MESSAGE);
				}
    		}
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để xóa", 
    										"Lỗi", JOptionPane.ERROR_MESSAGE);
    	}
    }
}