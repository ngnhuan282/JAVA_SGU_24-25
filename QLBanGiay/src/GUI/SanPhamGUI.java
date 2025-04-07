package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.SanPhamBUS;

public class SanPhamGUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int DEFAULT_WIDTH = 1450, DEFAULT_HEIGHT = 800;
    private String color = "#FF5252";
    private DefaultTableModel model;
    private JTextField txtSearch;
    private JTable tblDSSP;
    private JTextField txtMaSP, txtTenSP, txtDonGia, txtSoLuong, txtDonViTinh, txtChatLieu, txtKieuDang;
    private JComboBox<String> cbLoaiSP;
    private JRadioButton rbDen, rbTrang, rbXam;
    private JSpinner spinKichThuoc;

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
        DefaultTableModel model = (DefaultTableModel) tblDSSP.getModel();
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
        pMain.setBounds(233, 6, 1272, 757);
        contentPane.add(pMain);
        pMain.setLayout(null);

        JPanel pHeaderMain = new JPanel();
        pHeaderMain.setBounds(0, 0, 1206, 100);
        pHeaderMain.setBackground(Color.WHITE);
        pHeaderMain.setLayout(null);
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
        pLeftHeader.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pLeftHeader.setBackground(Color.WHITE);
        pLeftHeader.setBounds(2, 0, 512, 100);
        pHeaderMain.add(pLeftHeader);
        pLeftHeader.setLayout(null);
        
        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.setBorder(UIManager.getBorder("Button.border"));
        horizontalBox.setBounds(0, 0, 512, 111);
        pLeftHeader.add(horizontalBox);
        
                JButton btnThem = new JButton("Thêm");
                horizontalBox.add(btnThem);
                btnThem.setFocusPainted(false);
                btnThem.setBorder(new LineBorder(new Color(0, 0, 0)));
                btnThem.setActionCommand("Thêm");
                btnThem.addActionListener(this);
                btnThem.setBackground(Color.WHITE);
                btnThem.setBorderPainted(false);
                btnThem.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/add48.png")));
                btnThem.setFont(new Font("Arial", Font.PLAIN, 15));
                btnThem.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnThem.setHorizontalTextPosition(SwingConstants.CENTER);
                btnThem.setPreferredSize(new Dimension(120, 140));
                
                        JButton btnSua = new JButton("Sửa");
                        horizontalBox.add(btnSua);
                        btnSua.setFocusPainted(false);
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
                        
                                JButton btnXoa = new JButton("Xóa");
                                horizontalBox.add(btnXoa);
                                btnXoa.setFocusPainted(false);
                                btnXoa.setActionCommand("Xóa");
                                btnXoa.addActionListener(this);
                                btnXoa.setBorderPainted(false);
                                btnXoa.setVerticalTextPosition(SwingConstants.BOTTOM);
                                btnXoa.setPreferredSize(new Dimension(120, 140));
                                btnXoa.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/remove48.png")));
                                btnXoa.setHorizontalTextPosition(SwingConstants.CENTER);
                                btnXoa.setFont(new Font("Arial", Font.PLAIN, 15));
                                btnXoa.setBackground(Color.WHITE);
                                
                                        JButton btnXuatExcel = new JButton("Xuất Excel");
                                        horizontalBox.add(btnXuatExcel);
                                        btnXuatExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
                                        btnXuatExcel.setPreferredSize(new Dimension(120, 140));
                                        btnXuatExcel.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/excel48.png")));
                                        btnXuatExcel.setHorizontalTextPosition(SwingConstants.CENTER);
                                        btnXuatExcel.setFont(new Font("Arial", Font.PLAIN, 15));
                                        btnXuatExcel.setBorderPainted(false);
                                        btnXuatExcel.setBackground(Color.WHITE);
                                        
                                                JButton btnNhapExcel = new JButton("Nhập Excel");
                                                horizontalBox.add(btnNhapExcel);
                                                btnNhapExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
                                                btnNhapExcel.setPreferredSize(new Dimension(120, 140));
                                                btnNhapExcel.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/bill48.png")));
                                                btnNhapExcel.setHorizontalTextPosition(SwingConstants.CENTER);
                                                btnNhapExcel.setFont(new Font("Arial", Font.PLAIN, 15));
                                                btnNhapExcel.setBorderPainted(false);
                                                btnNhapExcel.setBackground(Color.WHITE);
        
        txtSearch = new JTextField();
        txtSearch.setBounds(771, 31, 290, 27);
        pHeaderMain.add(txtSearch);
        txtSearch.setColumns(10);
        
        JComboBox cboxSearch = new JComboBox();
        cboxSearch.setFont(new Font("Arial", Font.PLAIN, 14));
        cboxSearch.setBounds(682, 30, 79, 28);
        cboxSearch.setBackground(Color.WHITE); // nền trắng
        cboxSearch.setForeground(Color.BLACK); // chữ đen cho dễ đọc
        cboxSearch.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // viền xám nhạt
        pHeaderMain.add(cboxSearch);
        
        JButton btnSearch = new JButton("");
        btnSearch.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/search30.png")));
        btnSearch.setBounds(1071, 22, 66, 39);
        pHeaderMain.add(btnSearch);
        
        JPanel pContent = new JPanel();
        pContent.setBackground(Color.white);
        pContent.setBounds(0, 103, 1248, 654); // Đặt bên dưới pHeaderMain
        pContent.setLayout(null);
        pMain.add(pContent); 
        
        
        /*************TABLE HIỂN THỊ***************/
        tblDSSP = new JTable(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "Lo\u1EA1i", "Gi\u00E1", "S\u1ED1 L\u01B0\u1EE3ng", "\u0110\u01A1n v\u1ECB t\u00EDnh"
        	}
        ));
        tblDSSP.setBackground(Color.WHITE);
        tblDSSP.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
        tblDSSP.setFillsViewportHeight(true);
        tblDSSP.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSSP.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        JScrollPane scrollPane = new JScrollPane(tblDSSP);
        scrollPane.setBounds(591, 40, 613, 402);
        scrollPane.getVerticalScrollBar().setUI(new ModernScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new ModernScrollBarUI());
        pContent.add(scrollPane);
        
       
        /*******************FORM SẢN PHẨM*********************/

        JPanel pInput = new JPanel();
        pInput.setBorder(UIManager.getBorder("TextField.border"));
        pInput.setBackground(Color.WHITE);
        pInput.setBounds(48, 40, 502, 402);
        pContent.add(pInput);
        pInput.setLayout(null);
        
        txtKieuDang = new JTextField();
        txtKieuDang.setFont(new Font("Arial", Font.PLAIN, 13));
        txtKieuDang.setColumns(10);
        txtKieuDang.setBounds(233, 357, 168, 19);
        pInput.add(txtKieuDang);
        
        JLabel lbMaSP = new JLabel("Mã sản phẩm");
        lbMaSP.setFont(new Font("Arial", Font.PLAIN, 14));
        lbMaSP.setBounds(10, 65, 112, 17);
        pInput.add(lbMaSP);
        
        txtMaSP = new JTextField();
        txtMaSP.setFont(new Font("Arial", Font.PLAIN, 13));
        txtMaSP.setColumns(10);
        txtMaSP.setBounds(10, 91, 168, 19);
        pInput.add(txtMaSP);
        
        JLabel lbLoaiSP = new JLabel("Loại sản phẩm");
        lbLoaiSP.setFont(new Font("Arial", Font.PLAIN, 14));
        lbLoaiSP.setBounds(233, 65, 112, 17);
        pInput.add(lbLoaiSP);
        
        JLabel lbTenSP = new JLabel("Tên sản phẩm");
        lbTenSP.setFont(new Font("Arial", Font.PLAIN, 14));
        lbTenSP.setBounds(10, 133, 112, 17);
        pInput.add(lbTenSP);
        
        txtTenSP = new JTextField();
        txtTenSP.setFont(new Font("Arial", Font.PLAIN, 13));
        txtTenSP.setColumns(10);
        txtTenSP.setBounds(10, 159, 168, 19);
        pInput.add(txtTenSP);
        
        JLabel lbMauSac = new JLabel("Màu sắc");
        lbMauSac.setFont(new Font("Arial", Font.PLAIN, 14));
        lbMauSac.setBounds(233, 133, 112, 17);
        pInput.add(lbMauSac);
        
      
        JRadioButton rbDen = new JRadioButton("Đen");
        rbDen.setFont(new Font("Arial", Font.PLAIN, 13));
        rbDen.setBackground(Color.WHITE);
        rbDen.setBounds(228, 158, 62, 21);
        pInput.add(rbDen);
        
        JRadioButton rbTrang = new JRadioButton("Trắng");
        rbTrang.setFont(new Font("Arial", Font.PLAIN, 13));
        rbTrang.setBackground(Color.WHITE);
        rbTrang.setBounds(306, 158, 62, 21);
        pInput.add(rbTrang);
        
        JRadioButton rbXam = new JRadioButton("Xám");
        rbXam.setFont(new Font("Arial", Font.PLAIN, 13));
        rbXam.setBackground(Color.WHITE);
        rbXam.setBounds(388, 158, 62, 21);
        pInput.add(rbXam);
        
        ButtonGroup bgMauSac = new ButtonGroup();
        bgMauSac.add(rbDen);  bgMauSac.add(rbTrang);  bgMauSac.add(rbXam);
        
        JLabel lbDonGia = new JLabel("Đơn giá");
        lbDonGia.setFont(new Font("Arial", Font.PLAIN, 14));
        lbDonGia.setBounds(10, 198, 112, 17);
        pInput.add(lbDonGia);
        
        txtDonGia = new JTextField();
        txtDonGia.setFont(new Font("Arial", Font.PLAIN, 13));
        txtDonGia.setColumns(10);
        txtDonGia.setBounds(10, 224, 168, 19);
        pInput.add(txtDonGia);
        
        JLabel lbKichThuoc = new JLabel("Kích thước");
        lbKichThuoc.setFont(new Font("Arial", Font.PLAIN, 14));
        lbKichThuoc.setBounds(233, 201, 112, 17);
        pInput.add(lbKichThuoc);
        
        JComboBox cbLoaiSP = new JComboBox();
        cbLoaiSP.setFont(new Font("Arial", Font.PLAIN, 13));
        cbLoaiSP.setBounds(233, 91, 133, 21);
        cbLoaiSP.setBackground(Color.WHITE); // nền trắng
        cbLoaiSP.setForeground(Color.BLACK); // chữ đen cho dễ đọc
        cbLoaiSP.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // viền xám nhạt
        pInput.add(cbLoaiSP);
        
        String[] listLoaiSP = {"Giày boots", "Giày sneakers", "Giày sandals"};
        for (String loai : listLoaiSP) 
            cbLoaiSP.addItem(loai);

        JLabel lbSoLuong = new JLabel("Số lượng");
        lbSoLuong.setFont(new Font("Arial", Font.PLAIN, 14));
        lbSoLuong.setBounds(10, 265, 112, 17);
        pInput.add(lbSoLuong);
        
        txtSoLuong = new JTextField();
        txtSoLuong.setFont(new Font("Arial", Font.PLAIN, 13));
        txtSoLuong.setColumns(10);
        txtSoLuong.setBounds(10, 291, 168, 19);
        pInput.add(txtSoLuong);
        
        JLabel lbChatLieu = new JLabel("Chất liệu");
        lbChatLieu.setFont(new Font("Arial", Font.PLAIN, 14));
        lbChatLieu.setBounds(233, 265, 112, 17);
        pInput.add(lbChatLieu);
        
        txtChatLieu = new JTextField();
        txtChatLieu.setFont(new Font("Arial", Font.PLAIN, 13));
        txtChatLieu.setColumns(10);
        txtChatLieu.setBounds(233, 291, 168, 19);
        pInput.add(txtChatLieu);
        
        JLabel lbDonViTinh = new JLabel("Đơn vị tính");
        lbDonViTinh.setFont(new Font("Arial", Font.PLAIN, 14));
        lbDonViTinh.setBounds(10, 331, 112, 17);
        pInput.add(lbDonViTinh);
        
        txtDonViTinh = new JTextField();
        txtDonViTinh.setFont(new Font("Arial", Font.PLAIN, 13));
        txtDonViTinh.setColumns(10);
        txtDonViTinh.setBounds(10, 357, 168, 19);
        pInput.add(txtDonViTinh);
        
        JLabel lbKieuDang = new JLabel("Kiểu dáng");
        lbKieuDang.setFont(new Font("Arial", Font.PLAIN, 14));
        lbKieuDang.setBounds(233, 331, 112, 17);
        pInput.add(lbKieuDang);
        
        JLabel lbHeaderSP = new JLabel("THÔNG TIN SẢN PHẨM");
        lbHeaderSP.setHorizontalAlignment(SwingConstants.CENTER);
        lbHeaderSP.setFont(new Font("Arial", Font.BOLD, 15));
        lbHeaderSP.setBackground(Color.decode("#00C853"));
        lbHeaderSP.setBounds(0, 10, 502, 45);
        pInput.add(lbHeaderSP);
        
        JSpinner spinKichThuoc = new JSpinner();
        spinKichThuoc.setModel(new SpinnerNumberModel(38, 38, 43, 1));
        spinKichThuoc.setFont(new Font("Arial", Font.PLAIN, 13));
        spinKichThuoc.setBounds(233, 224, 62, 20);
        pInput.add(spinKichThuoc);
        
        JButton btnLoaiSP = new JButton("");
        btnLoaiSP.setBorder(null);
        btnLoaiSP.setBackground(null);
        btnLoaiSP.setFocusPainted(false);
        btnLoaiSP.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/more30.png")));
        btnLoaiSP.setFont(new Font("Arial", Font.PLAIN, 13));
        btnLoaiSP.setBounds(331, 64, 47, 18);
        btnLoaiSP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				openLoaiSPDialog();
			}
		});
        pInput.add(btnLoaiSP);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Thêm":
            	addProduct();
                break;
            case "Sửa":
            	updateProduct();
                break;
            case "Xóa":
            	deleteProduct();
                break;
//            case "ThemLoai":
//            	addCategory();
//            	break;
//            case "SuaLoai":
//            	updateCategory();
//            	break;
//            case "XoaLoai":
//            	deleteCategory();
//            	break;
            default:
                break;
        }
    }
    
    
    
    
    public void updateCategory()
    {
    	
    }
    
    public void deleteCategory()
    {
    	
    }
	public void addProduct()
    {
    	
    }
    
    public void updateProduct()
    {
    	
    }
    
    
    public void resetForm()
    {
    	txtMaSP.setText("");
    	txtTenSP.setText("");
    	txtDonGia.setText("");
    	txtSoLuong.setText("");
    	txtDonViTinh.setText("");
    	txtChatLieu.setText("");
    	txtKieuDang.setText("");
    	rbDen.setSelected(false);
    	rbTrang.setSelected(false);
    	rbXam.setSelected(false);
    	spinKichThuoc.setValue(38);
    	cbLoaiSP.setSelectedIndex(0);
    }
    
    public void deleteProduct()
    {
    	int i = tblDSSP.getSelectedRow();
    	if(i >= 0)
    	{
    		String maSP = tblDSSP.getValueAt(i, 0).toString();
    		String tenSP = tblDSSP.getValueAt(i, 1).toString();
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
    
    
    private void openLoaiSPDialog() {
        JDialog dialog = new JDialog(this, "Quản lý loại sản phẩm", true);
        dialog.setSize(500, 400);
        dialog.setLocationRelativeTo(null);
        dialog.getContentPane().setLayout(null);
        
        // Tiêu đề
        JLabel lbTitle = new JLabel("QUẢN LÝ LOẠI SẢN PHẨM", SwingConstants.CENTER);
        lbTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lbTitle.setBounds(0, 10, 500, 30);
        dialog.getContentPane().add(lbTitle);

        // Bảng hiển thị danh sách loại sản phẩm
        DefaultTableModel modelLoai = new DefaultTableModel(new String[]{"Mã loại", "Tên loại"}, 0);
        JTable tblLoai = new JTable(modelLoai);
        tblLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        tblLoai.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        JScrollPane scrollLoai = new JScrollPane(tblLoai);
        scrollLoai.setBounds(10, 50, 480, 200);
        dialog.getContentPane().add(scrollLoai);

        // Form nhập liệu
        JLabel lbMaLoai = new JLabel("Mã loại:");
        lbMaLoai.setFont(new Font("Arial", Font.PLAIN, 14));
        lbMaLoai.setBounds(10, 260, 80, 25);
        dialog.getContentPane().add(lbMaLoai);

        JTextField txtMaLoai = new JTextField();
        txtMaLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        txtMaLoai.setBounds(90, 260, 100, 25);
        txtMaLoai.setEditable(false);
        dialog.getContentPane().add(txtMaLoai);

        JLabel lbTenLoai = new JLabel("Tên loại:");
        lbTenLoai.setFont(new Font("Arial", Font.PLAIN, 14));
        lbTenLoai.setBounds(210, 260, 71, 25);
        dialog.getContentPane().add(lbTenLoai);

        JTextField txtTenLoai = new JTextField();
        txtTenLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        txtTenLoai.setBounds(280, 260, 200, 25);
        dialog.getContentPane().add(txtTenLoai);

        // Nút thêm/sửa/xóa
        JButton btnThemLoai = new JButton("Thêm", new ImageIcon(LoaiSanPhamGUI.class.getResource("/image/add20.png")));
        btnThemLoai.setForeground(Color.WHITE);
        btnThemLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        btnThemLoai.setActionCommand("ThemLoai");
        btnThemLoai.addActionListener(this);
        btnThemLoai.setBounds(56, 300, 120, 30);
        btnThemLoai.setBackground(Color.decode("#4CAF50"));
        dialog.getContentPane().add(btnThemLoai);
        
        ImageIcon addIcon = new ImageIcon(getClass().getResource("/image/add20.png"));
        JButton btnSuaLoai = new JButton("Cập nhật", new ImageIcon(LoaiSanPhamGUI.class.getResource("/image/edit20.png")));
        btnSuaLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        btnSuaLoai.setActionCommand("SuaLoai");
        btnSuaLoai.addActionListener(this);
        btnSuaLoai.setBounds(199, 300, 120, 30);
        btnSuaLoai.setForeground(Color.WHITE);
        btnSuaLoai.setBackground(Color.decode("#7986CB"));
        dialog.getContentPane().add(btnSuaLoai);
        
        ImageIcon removeIcon = new ImageIcon(getClass().getResource("/image/remove20.png"));
        JButton btnXoaLoai = new JButton("Xóa", removeIcon);
        btnXoaLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        btnXoaLoai.setActionCommand("XoaLoai");
        btnXoaLoai.addActionListener(this);
        btnXoaLoai.setBounds(338, 300, 120, 30);
        btnXoaLoai.setForeground(Color.WHITE);
        btnXoaLoai.setBackground(Color.decode("#FF7043"));
        dialog.getContentPane().add(btnXoaLoai);

        dialog.setVisible(true);
        
        /**********XỬ LÝ SỰ KIỆN CHO THÊM/SỬA/XÓA***********/
        btnThemLoai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tenLoai = txtTenLoai.getText();
				if(tenLoai.isEmpty())
				{
					
				}
			}
		});
    }
    
    
    
    
}