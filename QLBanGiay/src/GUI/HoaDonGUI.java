package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BUS.ChiTietHoaDonBUS;
import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
import BUS.NhanVienBUS;
import BUS.SanPhamBUS;
import DTO.ChiTietHDDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.SanPhamDTO;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.metal.MetalScrollBarUI;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextField;

public class HoaDonGUI extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int DEFAULT_WIDTH = 1200, DEFAULT_HEIGHT= 800;
	private String color = "#FF5252";
	private JTable table;
	private JTable table_1;
	private JTextField txtMaHD;
	private JTextField txtMaKH;
	private JTextField txtMaNV;
	private JTextField txtMaSP;
	private JTextField txtSoLuong;
	private JButton btnComplete;
	private JButton btnAddProduct;
	private JButton btnCancel;
	private JButton btnUpdateBillDetail;
	
	private HoaDonBUS hoaDonBUS;
	private ChiTietHoaDonBUS chiTietHoaDonBUS;
	private JTextField txtSearch;
	private ArrayList<ChiTietHDDTO> listTemp;
	private SanPhamBUS sanPhamBUS;
	private NhanVienBUS nhanVienBUS;
	private KhachHangBUS khachHangBUS;
	private boolean update = false;
	private int selectedRowHoaDon = -1;
	private int selectedRowCTHD = -1;
	private int k = 0;
	private int h = 0;
	private double donGia;
	private double thanhTien;
	private double tongTien = 0;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		JFrame frame = new JFrame("Hóa đơn");
		frame.setTitle("Hệ thống quản lý bán giày");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1248, 757);
		frame.getContentPane().add(new HoaDonGUI());
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public HoaDonGUI() throws SQLException {
		hoaDonBUS = new HoaDonBUS();
		chiTietHoaDonBUS = new ChiTietHoaDonBUS();
		sanPhamBUS = new SanPhamBUS();
		nhanVienBUS = new NhanVienBUS();
		khachHangBUS = new KhachHangBUS();
		listTemp = new ArrayList<ChiTietHDDTO>();
		initComponents();
	}
	
	public void initComponents() {
//		setPreferredSize(new Dimension(1248, 757));
//		setLayout(null);
//		setBackground(Color.white);
//		setTitle("Hệ thống quản lý bán giày");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
//		setLocationRelativeTo(null);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JPanel pMain = new JPanel();
//		pMain.setBounds(205, 6, 1300, 800);
//		contentPane.add(pMain);
//		pMain.setLayout(new BoxLayout(pMain, BoxLayout.X_AXIS));
		
		JPanel pHeaderMain = new JPanel();
		pHeaderMain.setBounds(0, 0, 1206, 100);
		pHeaderMain.setBackground(Color.WHITE);
		add(pHeaderMain);
		
//		JPanel pNavbar = new JPanel();
//		pNavbar.setBounds(5, 6, 200, 800);
//		contentPane.add(pNavbar);
//		pNavbar.setLayout(null);
//		pNavbar.setPreferredSize(new Dimension(200, 800));
//		pNavbar.setBackground(Color.decode(color));
		
//		JPanel pAccount = new JPanel();
//		pAccount.setBounds(0, 0, 200, 88);
////		pNavbar.add(pAccount);
//		pAccount.setBackground(Color.decode(color));
//		pAccount.setLayout(null);
		
        /************* PHẦN HIỂN THỊ THÔNG TIN TÀI KHOẢN ************/
//		JLabel lbInfo1 = new JLabel("Xin chào");
//		lbInfo1.setIcon(new ImageIcon(KhachHangGUI.class.getResource("/image/userIcon.png")));
//		lbInfo1.setVerticalTextPosition(SwingConstants.BOTTOM);
//		lbInfo1.setHorizontalTextPosition(SwingConstants.CENTER);
//		lbInfo1.setForeground(Color.WHITE);
//		lbInfo1.setBounds(0, 0, 200, 54);
//		lbInfo1.setFont(new Font("Verdana", Font.BOLD, 14));
//		lbInfo1.setHorizontalAlignment(SwingConstants.CENTER);
//		pAccount.add(lbInfo1);
//		
//		JLabel lbInfo2 = new JLabel("Admin !");
//		lbInfo2.setBounds(0, 55, 200, 33);
//		pAccount.add(lbInfo2);
//		lbInfo2.setForeground(Color.WHITE);
//		lbInfo2.setFont(new Font("Verdana", Font.BOLD, 14));
//		lbInfo2.setHorizontalAlignment(SwingConstants.CENTER);
//		
//		JPanel pNavItem = new JPanel();
//		pNavItem.setBounds(0, 87, 200, 713);
//		pNavItem.setBackground(Color.decode(color));
//		pNavbar.add(pNavItem);
//		pNavItem.setLayout(null);
//		
//		/************* NAVBAR ************/
//		JButton btnDangXuat = new JButton("ĐĂNG XUẤT");
//		btnDangXuat.setIcon(new ImageIcon(KhachHangGUI.class.getResource("/image/logoutIcon.png")));
//		btnDangXuat.setOpaque(true);
//		btnDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
//		btnDangXuat.setForeground(Color.WHITE);
//		btnDangXuat.setFont(new Font("Verdana", Font.BOLD, 14));
//		btnDangXuat.setBorderPainted(false);
//		btnDangXuat.setBackground(Color.decode(color));
//		btnDangXuat.setBounds(0, 587, 200, 35);
//		pNavItem.add(btnDangXuat);
//		
//		JPanel panel_2 = new JPanel();
//		panel_2.setBounds(0, 0, 10, 10);
//		pNavItem.add(panel_2);
//		
//		JButton btnTrangChuGUI = new JButton("TRANG CHỦ");
//		btnTrangChuGUI.setIcon(new ImageIcon(KhachHangGUI.class.getResource("/image/homeIcon.png")));
//		btnTrangChuGUI.setOpaque(true);
//		btnTrangChuGUI.setHorizontalAlignment(SwingConstants.LEFT);
//		btnTrangChuGUI.setForeground(Color.WHITE);
//		btnTrangChuGUI.setFont(new Font("Verdana", Font.BOLD, 14));
//		btnTrangChuGUI.setBorderPainted(false);
//		btnTrangChuGUI.setBackground(Color.decode(color));
//		btnTrangChuGUI.setBounds(0, 0, 200, 35);
//		pNavItem.add(btnTrangChuGUI);
//		
//		JButton btnSanPhamGUI = new JButton("SẢN PHẨM");
//		btnSanPhamGUI.addActionListener(this);
//		btnSanPhamGUI.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/productIcon.png")));
//		btnSanPhamGUI.setOpaque(true);
//		btnSanPhamGUI.setHorizontalAlignment(SwingConstants.LEFT);
//		btnSanPhamGUI.setForeground(Color.WHITE);
//		btnSanPhamGUI.setFont(new Font("Verdana", Font.BOLD, 14));
//		btnSanPhamGUI.setBorderPainted(false);
//		btnSanPhamGUI.setBackground(Color.decode(color));
//		btnSanPhamGUI.setBounds(0, 38, 200, 35);
//		pNavItem.add(btnSanPhamGUI);
//		
//		JButton btnNhaCungCapGUI = new JButton("NHÀ CUNG CẤP");
//		btnNhaCungCapGUI.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/providerIcon.png")));
//		btnNhaCungCapGUI.setOpaque(true);
//		btnNhaCungCapGUI.setHorizontalAlignment(SwingConstants.LEFT);
//		btnNhaCungCapGUI.setForeground(Color.WHITE);
//		btnNhaCungCapGUI.setFont(new Font("Verdana", Font.BOLD, 14));
//		btnNhaCungCapGUI.setBorderPainted(false);
//		btnNhaCungCapGUI.setBackground(Color.decode(color));
//		btnNhaCungCapGUI.setBounds(0, 72, 200, 35);
//		pNavItem.add(btnNhaCungCapGUI);
//		
//		JButton btnNhanVienGUI = new JButton("NHÂN VIÊN");
//		btnNhanVienGUI.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/employeeIcon.png")));
//		btnNhanVienGUI.setOpaque(true);
//		btnNhanVienGUI.setHorizontalAlignment(SwingConstants.LEFT);
//		btnNhanVienGUI.setForeground(Color.WHITE);
//		btnNhanVienGUI.setFont(new Font("Verdana", Font.BOLD, 14));
//		btnNhanVienGUI.setBorderPainted(false);
//		btnNhanVienGUI.setBackground(Color.decode(color));
//		btnNhanVienGUI.setBounds(0, 104, 200, 35);
//		pNavItem.add(btnNhanVienGUI);
//		
//		JButton btnKhachHangGUI = new JButton("KHÁCH HÀNG");
//		btnKhachHangGUI.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/clientIcon.png")));
//		btnKhachHangGUI.setOpaque(true);
//		btnKhachHangGUI.setHorizontalAlignment(SwingConstants.LEFT);
//		btnKhachHangGUI.setForeground(Color.WHITE);
//		btnKhachHangGUI.setFont(new Font("Verdana", Font.BOLD, 14));
//		btnKhachHangGUI.setBorderPainted(false);
//		btnKhachHangGUI.setBackground(Color.decode(color));
//		btnKhachHangGUI.setBounds(0, 141, 200, 35);
//		pNavItem.add(btnKhachHangGUI);
//		
//		JButton btnPhieuNhapGUI = new JButton("PHIẾU NHẬP");
//		btnPhieuNhapGUI.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/phieuNhap.png")));
//		btnPhieuNhapGUI.setOpaque(true);
//		btnPhieuNhapGUI.setHorizontalAlignment(SwingConstants.LEFT);
//		btnPhieuNhapGUI.setForeground(Color.WHITE);
//		btnPhieuNhapGUI.setFont(new Font("Verdana", Font.BOLD, 14));
//		btnPhieuNhapGUI.setBorderPainted(false);
//		btnPhieuNhapGUI.setBackground(Color.decode(color));
//		btnPhieuNhapGUI.setBounds(0, 173, 200, 35);
//		pNavItem.add(btnPhieuNhapGUI);
//		
//		JButton btnPhieuXuat = new JButton("PHIẾU XUẤT");
//		btnPhieuXuat.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/phieuXuat.png")));
//		btnPhieuXuat.setOpaque(true);
//		btnPhieuXuat.setHorizontalAlignment(SwingConstants.LEFT);
//		btnPhieuXuat.setForeground(Color.WHITE);
//		btnPhieuXuat.setFont(new Font("Verdana", Font.BOLD, 14));
//		btnPhieuXuat.setBorderPainted(false);
//		btnPhieuXuat.setBackground(Color.decode(color));
//		btnPhieuXuat.setBounds(0, 207, 200, 35);
//		pNavItem.add(btnPhieuXuat);
//		
//		JButton btnKhuyenMaiGUI = new JButton("KHUYẾN MÃI");
//		btnKhuyenMaiGUI.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/saleIcon.png")));
//		btnKhuyenMaiGUI.setOpaque(true);
//		btnKhuyenMaiGUI.setHorizontalAlignment(SwingConstants.LEFT);
//		btnKhuyenMaiGUI.setForeground(Color.WHITE);
//		btnKhuyenMaiGUI.setFont(new Font("Verdana", Font.BOLD, 14));
//		btnKhuyenMaiGUI.setBorderPainted(false);
//		btnKhuyenMaiGUI.setBackground(Color.decode(color));
//		btnKhuyenMaiGUI.setBounds(0, 242, 200, 35);
//		pNavItem.add(btnKhuyenMaiGUI);
		
		
		/************* PHẦN HEADER ************/
		pHeaderMain.setPreferredSize(new Dimension(1245, 815));
		pHeaderMain.setLayout(null);
		
		JPanel pLeftHeader = new JPanel();
		 pLeftHeader.setBorder(new TitledBorder(null, "Chức năng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pLeftHeader.setBackground(Color.WHITE);
		pLeftHeader.setBounds(0, 0, 542, 90);
		pHeaderMain.add(pLeftHeader);
		pLeftHeader.setLayout(null);
		
		/************* PHẦN CHỨC NĂNG ************/
		Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.setBorder(UIManager.getBorder("Button.border"));
        horizontalBox.setBounds(0, 0, 512, 111);
        pLeftHeader.add(horizontalBox);
		
        JButton btnThem = new JButton("Thêm");
        horizontalBox.add(btnThem);
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
                                        txtSearch.setBounds(694, 31, 243, 39);
                                        pHeaderMain.add(txtSearch);
                                        txtSearch.setColumns(10);
                                        
                                        JButton btnLamMoi = new JButton("Làm mới");
                                        btnLamMoi.setBackground(Color.WHITE);
                                        btnLamMoi.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/reload30.png")));
                                        btnLamMoi.setFont(new Font("Arial", Font.PLAIN, 13));
                                        btnLamMoi.setBounds(1023, 30, 126, 39);
                                        btnLamMoi.setActionCommand("Reload");
                                        btnLamMoi.addActionListener(e -> {
                                        	btnLamMoi.setVisible(false);
                                        	openBillTable();
                                        });
                                        btnLamMoi.setVisible(false);
                                        pHeaderMain.add(btnLamMoi);
                                        
                                        String[] keysearch = {"Mã hóa đơn", "Mã khách hàng", "Mã nhân viên", "Ngày lập"};
                                        JComboBox<String> cboxSearch = new JComboBox<String>(keysearch);
                                        cboxSearch.setFont(new Font("Arial", Font.PLAIN, 14));
                                        cboxSearch.setBounds(552, 29, 132, 41);
                                        cboxSearch.setBackground(Color.WHITE); // nền trắng
                                        cboxSearch.setForeground(Color.BLACK); // chữ đen cho dễ đọc
                                        cboxSearch.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // viền xám nhạt
                                        pHeaderMain.add(cboxSearch);
                                        
                                        JButton btnSearch = new JButton("");
                                        btnSearch.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/search30.png")));
                                        btnSearch.setBounds(947, 31, 66, 39);
                                        btnSearch.addActionListener(e -> {
                                        	String key = cboxSearch.getSelectedItem().toString();
                                        	String keyword = txtSearch.getText();
                                        	ArrayList<HoaDonDTO> result = hoaDonBUS.search(key, keyword);
                                        	if(result.isEmpty()) {
                                        		JOptionPane.showMessageDialog(this, "Không có kết quả phù hợp", "Thông báo", JOptionPane.WARNING_MESSAGE);
                                    			return;
                                        	}
                                        	
                                        	txtSearch.setText("");
                                        	btnLamMoi.setVisible(true);
                                        	openBillTable(result);
                                        	
                                        });
                                        pHeaderMain.add(btnSearch);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 91, 732, 374);
		pHeaderMain.add(panel);
		panel.setLayout(null);
		
//        scrollPane.getVerticalScrollBar().setUI(new MetalScrollBarUI());
//        scrollPane.getHorizontalScrollBar().setUI(new MetalScrollBarUI());
		
		table =  new JTable();
		table.setFillsViewportHeight(true);
		table.setBackground(Color.WHITE);
		table.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
		
		table.setFont(new Font("Verdana", Font.PLAIN, 12));
  		table.setGridColor(new Color(200, 200, 200));
  		table.getTableHeader().setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
  		
  		table.setRowHeight(23);
  		table.getTableHeader().setPreferredSize(new Dimension(0, 23));
  		table.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 12));	
		
		table.setFont(new Font("Arial", Font.PLAIN, 13));
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(0, 0, 732, 375);
		panel.add(jScrollPane);
		table.setBounds(0, 91, 539, 312);
		jScrollPane.setViewportView(table);
		jScrollPane.getHorizontalScrollBar().setUI(new ModernScrollBarUI());
		jScrollPane.getVerticalScrollBar().setUI(new ModernScrollBarUI());
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 464, 1177, 286);
		pHeaderMain.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1177, 286);
		panel_1.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setBorder(UIManager.getBorder("Table.scrollPaneBorderr"));
		table_1.setBackground(Color.WHITE);
		table_1.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
		table_1.setFillsViewportHeight(true);
		table_1.setFont(new Font("Arial", Font.PLAIN, 13));
		
		table_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		table_1.setGridColor(new Color(200, 200, 200));
		table_1.getTableHeader().setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
  		
		table_1.setRowHeight(23);
		table_1.getTableHeader().setPreferredSize(new Dimension(0, 23));
		table_1.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 12));	
		scrollPane.setViewportView(table_1);
		scrollPane.getHorizontalScrollBar().setUI(new ModernScrollBarUI());
		scrollPane.getVerticalScrollBar().setUI(new ModernScrollBarUI());
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(732, 91, 445, 374);
		pHeaderMain.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin hóa đơn");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(108, 0, 201, 51);
		panel_3.add(lblNewLabel);
		
		txtMaHD = new JTextField();
		txtMaHD.setBounds(148, 61, 148, 31);
		panel_3.add(txtMaHD);
		txtMaHD.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn");
		lblNewLabel_1.setLabelFor(txtMaHD);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(20, 60, 83, 31);
		panel_3.add(lblNewLabel_1);
		
		JLabel lbMaKH = new JLabel("Mã khách hàng");
		lbMaKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbMaKH.setBounds(20, 142, 103, 31);
		panel_3.add(lbMaKH);
		
		txtMaKH = new JTextField();
		lbMaKH.setLabelFor(txtMaKH);
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(148, 143, 148, 31);
		panel_3.add(txtMaKH);
		
		JButton btnOpenMaKHList = new JButton("...");
		
		btnOpenMaKHList.setBounds(308, 148, 21, 21);
		panel_3.add(btnOpenMaKHList);
		btnOpenMaKHList.addActionListener(e -> {
			JDialog dialog = new JDialog();
			dialog.setTitle("Khách hàng");
			String[] colunms = {"Mã khách hàng", "Họ", "Tên", "SĐT"};
			
			JTable tableMaKH = new JTable();
			JScrollPane jScrollPaneMaKH = new JScrollPane(tableMaKH);
			
			DefaultTableModel modelMaKHList = new DefaultTableModel(colunms, 0);
			for(KhachHangDTO x : khachHangBUS.getListKhachHang()) {
				Object[] row = {
						x.getMaKH(),
						x.getHo(),
						x.getTen(),
						x.getSdt()
				};
				modelMaKHList.addRow(row);	
			}
			tableMaKH.setModel(modelMaKHList);
			
			 dialog.getContentPane().add(jScrollPaneMaKH);
             dialog.setBounds(1200, 285, 350, 200);
             dialog.setVisible(true);
             
             tableMaKH.addMouseListener(new java.awt.event.MouseAdapter() {
            	 public void mouseClicked(MouseEvent e) {
            		 int selectedRow = tableMaKH.getSelectedRow();
            		 
            		 String maKH = (String) tableMaKH.getValueAt(selectedRow, 0);
            		 txtMaKH.setText(maKH);
            		 dialog.dispose();
            	 }
             });
		});
		
		JLabel lblMaNV = new JLabel("Mã nhân viên");
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaNV.setBounds(20, 101, 93, 31);
		panel_3.add(lblMaNV);
		
		txtMaNV = new JTextField();
		lblMaNV.setLabelFor(txtMaNV);
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(148, 102, 148, 31);
		panel_3.add(txtMaNV);
		
		JButton btnOpenMaNVList = new JButton("...");
		btnOpenMaNVList.setBounds(308, 107, 21, 21);
		panel_3.add(btnOpenMaNVList);
		btnOpenMaNVList.addActionListener(e -> {
			JDialog dialog = new JDialog();
			dialog.setTitle("Nhân Viên");
			String[] colunms = {"Mã nhân viên", "Họ", "Tên", "SĐT"};
			
			JTable tableMaNV = new JTable();
			JScrollPane jScrollPaneMaNV = new JScrollPane(tableMaNV);
			
			DefaultTableModel modelMaNVList = new DefaultTableModel(colunms, 0);
			for(NhanVienDTO x : nhanVienBUS.getListNhanVien()) {
				Object[] row = {
						x.getMaNV(),
						x.getHo(),
						x.getTen(),
						x.getSdt()
				};
				modelMaNVList.addRow(row);	
			}
			tableMaNV.setModel(modelMaNVList);
			
			 dialog.getContentPane().add(jScrollPaneMaNV);
             dialog.setBounds(1200, 240, 350, 200);
             dialog.setVisible(true);
             
             tableMaNV.addMouseListener(new java.awt.event.MouseAdapter() {
            	 public void mouseClicked(MouseEvent e) {
            		 int selectedRow = tableMaNV.getSelectedRow();
            		 
            		 String maNV = (String) tableMaNV.getValueAt(selectedRow, 0);
            		 txtMaNV.setText(maNV);
            		 dialog.dispose();
            	 }
             });
		});

		
		JLabel lblMSnPhm = new JLabel("Mã sản phẩm");
		lblMSnPhm.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMSnPhm.setBounds(20, 183, 93, 31);
		panel_3.add(lblMSnPhm);
		
		txtMaSP = new JTextField();
		lblMSnPhm.setLabelFor(txtMaSP);
		txtMaSP.setColumns(10);
		txtMaSP.setBounds(148, 184, 148, 31);
		panel_3.add(txtMaSP);
		
		JButton btnOpenMaSPList = new JButton("...");
		btnOpenMaSPList.addActionListener(e -> {
			JDialog dialog = new JDialog();
			dialog.setTitle("Sản phẩm");
			String[] colunms = {"Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Mã loại SP"};
			
			JTable tableMaSP = new JTable();
			JScrollPane jScrollPaneMaSP = new JScrollPane(tableMaSP);
			sanPhamBUS.docDSSP();
			DefaultTableModel modelMaSpList = new DefaultTableModel(colunms, 0);
			for(SanPhamDTO x : sanPhamBUS.getDssp()) {
				Object[] row = {
						x.getMaSP(),
						x.getTenSP(),
						x.getDonGia(),
						x.getMaLoaiSP()
				};
				modelMaSpList.addRow(row);
			}
			tableMaSP.setModel(modelMaSpList);
			
			 dialog.getContentPane().add(jScrollPaneMaSP);
             dialog.setBounds(1200, 330, 350, 200);
             dialog.setVisible(true);
             
             tableMaSP.addMouseListener(new java.awt.event.MouseAdapter() {
            	 public void mouseClicked(MouseEvent e) {
            		 int selectedRow = tableMaSP.getSelectedRow();
            		 
            		 String maSP = (String) tableMaSP.getValueAt(selectedRow, 0);
            		 donGia = Double.valueOf(tableMaSP.getValueAt(selectedRow, 2).toString());
            		 txtMaSP.setText(maSP);
            		 dialog.dispose();
            	 }
             });
		});
		btnOpenMaSPList.setBounds(308, 189, 21, 21);
		panel_3.add(btnOpenMaSPList);
		
		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSoLuong.setBounds(20, 224, 93, 31);
		panel_3.add(lblSoLuong);
		
		txtSoLuong = new JTextField();
		lblSoLuong.setLabelFor(txtSoLuong);
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(148, 225, 148, 31);
		panel_3.add(txtSoLuong);
		
		btnComplete = new JButton("Hoàn tất hóa đơn");
		btnComplete.setBackground(Color.WHITE);
		btnComplete.setActionCommand("Hoàn tất hóa đơn");
		btnComplete.setBounds(10, 287, 154, 42);
		panel_3.add(btnComplete);
		
		btnAddProduct = new JButton("Thêm sản phẩm");
		btnAddProduct.setBounds(175, 287, 154, 42);
		btnAddProduct.setBackground(Color.WHITE);
		btnAddProduct.setActionCommand("Thêm sản phẩm");
		panel_3.add(btnAddProduct);
		
		
		btnCancel = new JButton("Hủy");
		btnCancel.setBounds(332, 287, 103, 42);
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setActionCommand("Hủy");
		panel_3.add(btnCancel);
		
		btnUpdateBillDetail = new JButton("Sửa hóa đơn");
		 btnUpdateBillDetail.setBackground(Color.WHITE);
		 btnUpdateBillDetail.setBounds(175, 287, 154, 42);
		 btnUpdateBillDetail.addActionListener(e -> {
			 	if(txtMaHD.getText().equals("") || txtMaKH.getText().equals("") || txtMaNV.getText().equals("") || txtMaSP.getText().equals("") || txtSoLuong.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin hóa đơn", "Thông báo", JOptionPane.WARNING_MESSAGE);
					return;
				}
			 	
			 	String maHD = txtMaHD.getText();
				String maKH = txtMaKH.getText();
				String maNV = txtMaNV.getText();
				String maSP = txtMaSP.getText();
				int soLuong = Integer.valueOf(txtSoLuong.getText());
				
				ChiTietHDDTO chiTietHDDTO = listTemp.get(h);
				chiTietHDDTO.setMaHD(maHD);
				chiTietHDDTO.setMaSP(maSP);
				chiTietHDDTO.setSoLuong(soLuong);
				thanhTien = soLuong * donGia;
				chiTietHDDTO.setDonGia(donGia);
				chiTietHDDTO.setThanhTien(thanhTien);
				chiTietHoaDonBUS.deleteCTHDByIndex(k);
//				chiTietHoaDonBUS.addCTHD(maHD, maSP, soLuong, donGia, thanhTien);
				selectedRowCTHD = table_1.getSelectedRow();
				k = 0;
				donGia = 0;
				thanhTien = 0;
				 btnAddProduct.setVisible(true);
				 btnUpdateBillDetail.setVisible(false);
				 txtMaNV.setEditable(false);
				 txtMaSP.setText("");
				 txtSoLuong.setText("");
				 JOptionPane.showMessageDialog(this, "Sửa hóa đơn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				 openBillDetailTable();
			 
		 });
		 btnUpdateBillDetail.setVisible(false);
		 panel_3.add(btnUpdateBillDetail);
		
		table.getTableHeader().setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
		
		openBillTable();
		openBillDetailTable();
		
		btnAddProduct.addActionListener(e -> {
			if(txtMaHD.getText().equals("") || txtMaKH.getText().equals("") || txtMaNV.getText().equals("") || txtMaSP.getText().equals("") || txtSoLuong.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin hóa đơn", "Thông báo", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(chiTietHoaDonBUS.checkDulicate(txtMaHD.getText(), txtMaSP.getText())) {
				JOptionPane.showMessageDialog(this, "Vui lòng không thêm sản phẩm giống nhau vào một hóa đơn", "Thông báo", JOptionPane.WARNING_MESSAGE);
				txtSoLuong.setText("");
				txtMaSP.setText("");
				return;
			}
			String maHD = txtMaHD.getText();
			String maKH = txtMaKH.getText();
			String maNV = txtMaNV.getText();
			String maSP = txtMaSP.getText();
			int soLuong = Integer.valueOf(txtSoLuong.getText());
			thanhTien = donGia * soLuong;
			
//			chiTietHoaDonBUS.addCTHD(maHD, maSP, soLuong, donGia, thanhTien);
			listTemp.add(new ChiTietHDDTO(maHD, maSP, soLuong, donGia, thanhTien));
			donGia = 0;
			thanhTien = 0;
			JOptionPane.showMessageDialog(this, "Thêm sản phẩm vào hóa đơn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			txtSoLuong.setText("");
			txtMaSP.setText("");
			txtMaHD.setEditable(false);
			txtMaKH.setEditable(false);
			txtMaNV.setEditable(false);
			openBillDetailTable();
		});
		
		
		btnComplete.addActionListener(e -> {
			if(txtMaHD.getText().equals("") || txtMaKH.getText().equals("") || txtMaNV.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Bạn chưa thêm sản phẩm vào hóa đơn", "Thông báo", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(listTemp.size() == 0) {
				JOptionPane.showMessageDialog(this, "Bạn cần thêm sản phẩm vào hóa đơn trước khi hoàn tất", "Thông báo", JOptionPane.WARNING_MESSAGE);
				return;
			}
			LocalDate now = LocalDate.now();
			Date ngayLap = Date.valueOf(now);
			if(!update) {
				for(ChiTietHDDTO x : listTemp) {
					tongTien += x.getThanhTien();
				}
				hoaDonBUS.addHoaDon(txtMaHD.getText(), txtMaKH.getText(), txtMaNV.getText(), ngayLap, tongTien);
				for(ChiTietHDDTO x : listTemp) {
					chiTietHoaDonBUS.addCTHD(x.getMaHD(), x.getMaSP(), x.getSoLuong(), x.getDonGia(), x.getThanhTien());
				}
			}
			else {
				int selectedRow = table.getSelectedRow();
				System.out.println(selectedRowCTHD);
//				if(selectedRowCTHD == -1) {
//					// có nghĩa là đang thêm 1 sản phẩm vào hóa đơn nữa
//					System.out.println("Theem");
//					for(ChiTietHDDTO x : listTemp) {
//						tongTien += x.getThanhTien();
//					}
//					ChiTietHDDTO x = listTemp.get(listTemp.size() - 1);
//					chiTietHoaDonBUS.addCTHD(x.getMaHD(), x.getMaSP(), x.getSoLuong(), x.getDonGia(), x.getThanhTien());
//					hoaDonBUS.updateHoaDon(txtMaHD.getText(), txtMaKH.getText(), txtMaNV.getText(), ngayLap, tongTien, selectedRow);
//					
//				}
//				if (selectedRowCTHD != -1){//Có nghĩa là đang sửa 1 chi tiết hóa đơn
//					System.out.println("Suawr");
//					for(ChiTietHDDTO x : listTemp) {
//						tongTien += x.getThanhTien();
//					}
//					hoaDonBUS.updateHoaDon(txtMaHD.getText(), txtMaKH.getText(), txtMaNV.getText(), ngayLap, tongTien, selectedRow);
//				}
				
				for(ChiTietHDDTO x : listTemp) {
					tongTien += x.getThanhTien();
					if(chiTietHoaDonBUS.checkDulicateMaSP(x.getMaSP()))
						continue;
					chiTietHoaDonBUS.addCTHD(x.getMaHD(), x.getMaSP(), x.getSoLuong(), x.getDonGia(), x.getThanhTien());
				}
				hoaDonBUS.updateHoaDon(txtMaHD.getText(), txtMaKH.getText(), txtMaNV.getText(), ngayLap, tongTien, selectedRow);
				update = false;
				txtMaHD.setEditable(true);
				txtMaKH.setEditable(true);
				txtMaNV.setEditable(true);
			}
			tongTien = 0;
			txtMaHD.setEditable(true);
			txtMaKH.setEditable(true);
			txtMaNV.setEditable(true);
			txtMaHD.setText("");
			txtMaSP.setText("");
			txtMaNV.setText("");
			txtMaKH.setText("");
			txtSoLuong.setText("");
			txtMaSP.setText("");
			listTemp.clear();
			
			openBillDetailTable();
			openBillTable();
			JOptionPane.showMessageDialog(this, "Nhập hóa đơn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		});
		
		btnCancel.addActionListener(e -> {
			if(listTemp.size() == 0) {
				txtMaHD.setText("");
				txtMaSP.setText("");
				txtMaNV.setText("");
				txtMaKH.setText("");
				txtSoLuong.setText("");
				txtMaSP.setText("");
			}
			else {
				int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn hủy hóa đơn này?", "Thông báo", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					listTemp.clear();
					txtMaHD.setText("");
					txtMaSP.setText("");
					txtMaNV.setText("");
					txtMaKH.setText("");
					txtSoLuong.setText("");
					txtMaSP.setText("");
					txtMaHD.setEditable(true);
					txtMaKH.setEditable(true);
					txtMaNV.setEditable(true);
					update = false;
					openBillDetailTable();
				}
			}
		});
		
		table_1.addMouseListener(new java.awt.event.MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				k = 0;
				h = 0;
				 selectedRowCTHD = table_1.getSelectedRow();
				 ChiTietHDDTO chiTietHDDTO;
				 if(selectedRowCTHD != -1) {
					 if(hoaDonBUS.getListHoaDon().size() != 0)
						 txtMaNV.setText(table.getValueAt(selectedRowHoaDon, 2).toString());
					 txtMaSP.setText(table_1.getValueAt(selectedRowCTHD, 1).toString());
					 txtSoLuong.setText(table_1.getValueAt(selectedRowCTHD, 2).toString());
					 chiTietHDDTO = new ChiTietHDDTO(txtMaHD.getText(), txtMaSP.getText(), Integer.valueOf(txtSoLuong.getText()), Double.valueOf(table_1.getValueAt(selectedRowCTHD, 3).toString()), Double.valueOf(table_1.getValueAt(selectedRowCTHD, 4).toString()));
					 for(ChiTietHDDTO x : listTemp) {
						 if(x.equals(chiTietHDDTO)) {
							 break;
						 }
						 h++;
						 System.out.println(h);
					 }
					 
					 for(ChiTietHDDTO x : chiTietHoaDonBUS.getListCTHD()) {
						 if(x.equals(chiTietHDDTO)) {
							 break;
						 }
						 k++;
					 }
					 donGia = Double.valueOf(table_1.getValueAt(selectedRowCTHD, 3).toString());
					 btnAddProduct.setVisible(false);
					 btnUpdateBillDetail.setVisible(true);
				 }
				 
			 }
		});
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				update = false;
//				txtMaKH.setEditable(true);
//				txtMaNV.setEditable(true);
//				txtMaHD.setEditable(true);
			}
		});
	}
	
	private void openBillDetailTable() {
		String[] columnNameBillDetail = { "Mã hóa đơn", "Mã sản phẩm", "Số lưọng", "Đơn giá", "Thành tiền" };
		DefaultTableModel model1 = new DefaultTableModel(columnNameBillDetail, 0);
		
		for(ChiTietHDDTO x : listTemp) {
			Object[] row = {
					x.getMaHD(),
					x.getMaSP(),
					x.getSoLuong(),
					x.getDonGia(),
					x.getThanhTien()
			};
			model1.addRow(row);
		}
		
		table_1.setModel(model1);

	}
	
	private void openBillTable(ArrayList<HoaDonDTO> result) {
		// Dữ liệu mẫu (ví dụ về sản phẩm)
		String[] columnNamesBill = { "Mã hóa đơn", "Mã khách hàng", "Tên khách hàng", "Mã nhân viên", "Ngày lập", "Tổng tiền" };

		// Tạo DefaultTableModel với dữ liệu mẫu
		DefaultTableModel model = new DefaultTableModel(columnNamesBill, 0);
		for(HoaDonDTO x : result) {
			Object[] row = {
					x.getMaHD(),
					x.getMaKH(),
					x.getMaNV(),
					x.getNgayLap(),
					x.getTongTien()
			};
			model.addRow(row);
		}
		

		// Gán model vào JTable

		table.setModel(model);
		 Font font = new Font("Verdana", Font.PLAIN, 14);
		table.setFont(font);
	}
	
	private void openBillTable() {
		// Dữ liệu mẫu (ví dụ về sản phẩm)
		String[] columnNamesBill = { "Mã hóa đơn", "Mã khách hàng", "Mã nhân viên", "Ngày lập", "Tổng tiền" };

		// Tạo DefaultTableModel với dữ liệu mẫu
		DefaultTableModel model = new DefaultTableModel(columnNamesBill, 0);
		for(HoaDonDTO x : hoaDonBUS.getListHoaDon()) {
			Object[] row = {
					x.getMaHD(),
					x.getMaKH(),
					x.getMaNV(),
					x.getNgayLap(),
					x.getTongTien()
			};
			model.addRow(row);
		}
		

		// Gán model vào JTable

		table.setModel(model);
		 Font font = new Font("Verdana", Font.PLAIN, 14);
		table.setFont(font);
	}
	
	public void openAddBill() {
		if(listTemp.size() != 0) {
			JOptionPane.showMessageDialog(this, "Bạn cần hoàn tất hóa đơn này trước khi thêm hóa đơn mới", "Thông báo", JOptionPane.WARNING_MESSAGE);
			return;
		}
		txtMaKH.setText("");
		txtMaNV.setText("");
		txtMaSP.setText("");
		txtSoLuong.setText("");
		txtMaKH.setEditable(true);
		txtMaNV.setEditable(true);
		txtMaSP.setEditable(true);
		txtMaHD.setText(hoaDonBUS.getMaHD());
	}
	
	public void openUpdateBill() {
		listTemp.clear();
		selectedRowHoaDon = table.getSelectedRow();
		if(hoaDonBUS.getListHoaDon().size() == 0) {
			JOptionPane.showMessageDialog(this, "Không có hóa đơn để sửa", "Thông báo", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(selectedRowHoaDon == -1 ) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn để sửa", "Thông báo", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String maHD = (String) table.getValueAt(selectedRowHoaDon, 0);
		String maKH = (String) table.getValueAt(selectedRowHoaDon, 1);
		for(ChiTietHDDTO x : chiTietHoaDonBUS.getListCTHD()) {
			if(x.getMaHD().equals(maHD)) {
				listTemp.add(new ChiTietHDDTO(x.getMaHD(), x.getMaSP(), x.getSoLuong(), x.getDonGia(), x.getThanhTien()));
			}
		}
		txtMaHD.setText(maHD);
		txtMaKH.setText(maKH);
		txtMaHD.setEditable(false);
		txtMaKH.setEditable(false);
		update = true;
		openBillDetailTable();
		
	}
	
	public void openDeleteBill() {
		if(hoaDonBUS.getListHoaDon().size() == 0) {
			JOptionPane.showMessageDialog(this, "Không có hóa đơn để xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(selectedRowHoaDon == -1 ) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn để sửa", "Thông báo", JOptionPane.WARNING_MESSAGE);
			return;
		}
		selectedRowHoaDon = table.getSelectedRow();
		selectedRowCTHD = table_1.getSelectedRow();
		if(selectedRowHoaDon != -1 && selectedRowCTHD == -1) {
			System.out.println("Hết");
			String maHD = (String) table.getValueAt(selectedRowHoaDon, 0);
			chiTietHoaDonBUS.deleteCTHD(maHD);
			hoaDonBUS.deleteHoaDon(selectedRowHoaDon);
			listTemp.clear();
			openBillDetailTable();
			openBillTable();
			JOptionPane.showMessageDialog(this, "Xóa hóa đơn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(selectedRowCTHD != -1) {
			System.out.println("chưa");
			chiTietHoaDonBUS.deleteCTHDByIndex(k);
			listTemp.remove(h);
			tongTien = 0;
			for(ChiTietHDDTO x : listTemp) {
				tongTien += x.getThanhTien();
			}
			listTemp.clear();
			update = false;
			hoaDonBUS.updateTongTien((String) table_1.getValueAt(selectedRowCTHD, 0), tongTien, selectedRowHoaDon);
			openBillDetailTable();
			openBillTable();
			JOptionPane.showMessageDialog(this, "Xóa hóa đơn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
		txtMaHD.setEditable(true);
		txtMaKH.setEditable(true);
		txtMaNV.setEditable(true);
		txtMaHD.setText("");
		txtMaSP.setText("");
		txtMaNV.setText("");
		txtMaKH.setText("");
		txtSoLuong.setText("");
		txtMaSP.setText("");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		
		if(str.equals("Thêm")) {
			openAddBill();
		}
		else if(str.equals("Sửa")) {
			if(!update) {
				openUpdateBill();
			}else {
				System.out.println("Ok");
				return;
			}
		}
		else if(str.equals("Xóa")) {
			openDeleteBill();
		}
	}
}
