package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.table.DefaultTableModel;

import BUS.KhachHangBUS;
import BUS.SanPhamBUS;
import DTO.KhachHangDTO;

import java.awt.Panel;
import javax.swing.JTree;
import java.awt.List;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;

public class KhachHangGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int DEFAULT_WIDTH = 1200, DEFAULT_HEIGHT= 800;
	private String color = "#FF5252";
	private JTable table;
	private JTable table_1;
	private KhachHangBUS khachHangBUS;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHangGUI frame = new KhachHangGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KhachHangGUI() {
		khachHangBUS = new KhachHangBUS();
		initComponents();
	}
	
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
		pMain.setBounds(205, 6, 1300, 800);
		contentPane.add(pMain);
		pMain.setLayout(new BoxLayout(pMain, BoxLayout.X_AXIS));
		
		JPanel pHeaderMain = new JPanel();
		pHeaderMain.setBackground(Color.WHITE);
		pMain.add(pHeaderMain);
		
		JPanel pNavbar = new JPanel();
		pNavbar.setBounds(5, 6, 200, 800);
		contentPane.add(pNavbar);
		pNavbar.setLayout(null);
		pNavbar.setPreferredSize(new Dimension(200, 800));
		pNavbar.setBackground(Color.decode(color));
		
		JPanel pAccount = new JPanel();
		pAccount.setBounds(0, 0, 200, 88);
		pNavbar.add(pAccount);
		pAccount.setBackground(Color.decode(color));
		pAccount.setLayout(null);
		
        /************* PHẦN HIỂN THỊ THÔNG TIN TÀI KHOẢN ************/
		JLabel lbInfo1 = new JLabel("Xin chào");
		lbInfo1.setIcon(new ImageIcon(KhachHangGUI.class.getResource("/image/userIcon.png")));
		lbInfo1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lbInfo1.setHorizontalTextPosition(SwingConstants.CENTER);
		lbInfo1.setForeground(Color.WHITE);
		lbInfo1.setBounds(0, 0, 200, 54);
		lbInfo1.setFont(new Font("Verdana", Font.BOLD, 14));
		lbInfo1.setHorizontalAlignment(SwingConstants.CENTER);
		pAccount.add(lbInfo1);
		
		JLabel lbInfo2 = new JLabel("Admin !");
		lbInfo2.setBounds(0, 55, 200, 33);
		pAccount.add(lbInfo2);
		lbInfo2.setForeground(Color.WHITE);
		lbInfo2.setFont(new Font("Verdana", Font.BOLD, 14));
		lbInfo2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel pNavItem = new JPanel();
		pNavItem.setBounds(0, 87, 200, 713);
		pNavItem.setBackground(Color.decode(color));
		pNavbar.add(pNavItem);
		pNavItem.setLayout(null);
		
		/************* NAVBAR ************/
		JButton btnDangXuat = new JButton("ĐĂNG XUẤT");
		btnDangXuat.setIcon(new ImageIcon(KhachHangGUI.class.getResource("/image/logoutIcon.png")));
		btnDangXuat.setOpaque(true);
		btnDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
		btnDangXuat.setForeground(Color.WHITE);
		btnDangXuat.setFont(new Font("Verdana", Font.BOLD, 14));
		btnDangXuat.setBorderPainted(false);
		btnDangXuat.setBackground(Color.decode(color));
		btnDangXuat.setBounds(0, 587, 200, 35);
		pNavItem.add(btnDangXuat);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 10, 10);
		pNavItem.add(panel_2);
		
		JButton btnTrangChuGUI = new JButton("TRANG CHỦ");
		btnTrangChuGUI.setIcon(new ImageIcon(KhachHangGUI.class.getResource("/image/homeIcon.png")));
		btnTrangChuGUI.setOpaque(true);
		btnTrangChuGUI.setHorizontalAlignment(SwingConstants.LEFT);
		btnTrangChuGUI.setForeground(Color.WHITE);
		btnTrangChuGUI.setFont(new Font("Verdana", Font.BOLD, 14));
		btnTrangChuGUI.setBorderPainted(false);
		btnTrangChuGUI.setBackground(Color.decode(color));
		btnTrangChuGUI.setBounds(0, 0, 200, 35);
		pNavItem.add(btnTrangChuGUI);
		
		JButton btnSanPhamGUI = new JButton("SẢN PHẨM");
		btnSanPhamGUI.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/productIcon.png")));
		btnSanPhamGUI.setOpaque(true);
		btnSanPhamGUI.setHorizontalAlignment(SwingConstants.LEFT);
		btnSanPhamGUI.setForeground(Color.WHITE);
		btnSanPhamGUI.setFont(new Font("Verdana", Font.BOLD, 14));
		btnSanPhamGUI.setBorderPainted(false);
		btnSanPhamGUI.setBackground(Color.decode(color));
		btnSanPhamGUI.setBounds(0, 38, 200, 35);
		pNavItem.add(btnSanPhamGUI);
		
		JButton btnNhaCungCapGUI = new JButton("NHÀ CUNG CẤP");
		btnNhaCungCapGUI.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/providerIcon.png")));
		btnNhaCungCapGUI.setOpaque(true);
		btnNhaCungCapGUI.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhaCungCapGUI.setForeground(Color.WHITE);
		btnNhaCungCapGUI.setFont(new Font("Verdana", Font.BOLD, 14));
		btnNhaCungCapGUI.setBorderPainted(false);
		btnNhaCungCapGUI.setBackground(Color.decode(color));
		btnNhaCungCapGUI.setBounds(0, 72, 200, 35);
		pNavItem.add(btnNhaCungCapGUI);
		
		JButton btnNhanVienGUI = new JButton("NHÂN VIÊN");
		btnNhanVienGUI.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/employeeIcon.png")));
		btnNhanVienGUI.setOpaque(true);
		btnNhanVienGUI.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVienGUI.setForeground(Color.WHITE);
		btnNhanVienGUI.setFont(new Font("Verdana", Font.BOLD, 14));
		btnNhanVienGUI.setBorderPainted(false);
		btnNhanVienGUI.setBackground(Color.decode(color));
		btnNhanVienGUI.setBounds(0, 104, 200, 35);
		pNavItem.add(btnNhanVienGUI);
		
		JButton btnKhachHangGUI = new JButton("KHÁCH HÀNG");
		btnKhachHangGUI.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/clientIcon.png")));
		btnKhachHangGUI.setOpaque(true);
		btnKhachHangGUI.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHangGUI.setForeground(Color.WHITE);
		btnKhachHangGUI.setFont(new Font("Verdana", Font.BOLD, 14));
		btnKhachHangGUI.setBorderPainted(false);
		btnKhachHangGUI.setBackground(Color.decode(color));
		btnKhachHangGUI.setBounds(0, 141, 200, 35);
		pNavItem.add(btnKhachHangGUI);
		
		JButton btnPhieuNhapGUI = new JButton("PHIẾU NHẬP");
		btnPhieuNhapGUI.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/phieuNhap.png")));
		btnPhieuNhapGUI.setOpaque(true);
		btnPhieuNhapGUI.setHorizontalAlignment(SwingConstants.LEFT);
		btnPhieuNhapGUI.setForeground(Color.WHITE);
		btnPhieuNhapGUI.setFont(new Font("Verdana", Font.BOLD, 14));
		btnPhieuNhapGUI.setBorderPainted(false);
		btnPhieuNhapGUI.setBackground(Color.decode(color));
		btnPhieuNhapGUI.setBounds(0, 173, 200, 35);
		pNavItem.add(btnPhieuNhapGUI);
		
		JButton btnPhieuXuat = new JButton("PHIẾU XUẤT");
		btnPhieuXuat.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/phieuXuat.png")));
		btnPhieuXuat.setOpaque(true);
		btnPhieuXuat.setHorizontalAlignment(SwingConstants.LEFT);
		btnPhieuXuat.setForeground(Color.WHITE);
		btnPhieuXuat.setFont(new Font("Verdana", Font.BOLD, 14));
		btnPhieuXuat.setBorderPainted(false);
		btnPhieuXuat.setBackground(Color.decode(color));
		btnPhieuXuat.setBounds(0, 207, 200, 35);
		pNavItem.add(btnPhieuXuat);
		
		JButton btnKhuyenMaiGUI = new JButton("KHUYẾN MÃI");
		btnKhuyenMaiGUI.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/saleIcon.png")));
		btnKhuyenMaiGUI.setOpaque(true);
		btnKhuyenMaiGUI.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhuyenMaiGUI.setForeground(Color.WHITE);
		btnKhuyenMaiGUI.setFont(new Font("Verdana", Font.BOLD, 14));
		btnKhuyenMaiGUI.setBorderPainted(false);
		btnKhuyenMaiGUI.setBackground(Color.decode(color));
		btnKhuyenMaiGUI.setBounds(0, 242, 200, 35);
		pNavItem.add(btnKhuyenMaiGUI);
		
		
		/************* PHẦN HEADER ************/
		pHeaderMain.setPreferredSize(new Dimension(DEFAULT_WIDTH, 100));
		pHeaderMain.setLayout(null);
		
		JPanel pLeftHeader = new JPanel();
		pLeftHeader.setBackground(Color.WHITE);
		pLeftHeader.setBounds(0, 0, 539, 90);
		pHeaderMain.add(pLeftHeader);
		pLeftHeader.setLayout(null);
		
		/************* PHẦN CHỨC NĂNG ************/
		JButton btnThem = new JButton("THÊM");
		btnThem.setActionCommand("Thêm");
		btnThem.setBackground(Color.WHITE);
		btnThem.addActionListener(this);
		btnThem.setBorderPainted(false);
		btnThem.setIcon(new ImageIcon(KhachHangGUI.class.getResource("/image/addIcon.png")));
		btnThem.setFont(new Font("Verdana", Font.BOLD, 14));
		btnThem.setBounds(0, 0, 93, 100);
		btnThem.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnThem.setHorizontalTextPosition(SwingConstants.CENTER);
		btnThem.setPreferredSize(new Dimension(120, 140));
		pLeftHeader.add(btnThem);
		
		JButton btnSua = new JButton("SỬA");
		btnSua.setActionCommand("Sửa");
		btnSua.addActionListener(this);
		btnSua.setBorderPainted(false);
		btnSua.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSua.setPreferredSize(new Dimension(120, 140));
		btnSua.setIcon(new ImageIcon(KhachHangGUI.class.getResource("/image/editIcon.png")));
		btnSua.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSua.setFont(new Font("Verdana", Font.BOLD, 14));
		btnSua.setBackground(Color.WHITE);
		btnSua.setBounds(94, 0, 93, 100);
		pLeftHeader.add(btnSua);
		
		JButton btnXoa = new JButton("XÓA");
		btnXoa.setActionCommand("Xóa");
		btnXoa.addActionListener(this);
		btnXoa.setBorderPainted(false);
		btnXoa.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnXoa.setPreferredSize(new Dimension(120, 140));
		btnXoa.setIcon(new ImageIcon(KhachHangGUI.class.getResource("/image/deleteIcon.png")));
		btnXoa.setHorizontalTextPosition(SwingConstants.CENTER);
		btnXoa.setFont(new Font("Verdana", Font.BOLD, 14));
		btnXoa.setBackground(Color.WHITE);
		btnXoa.setBounds(185, 0, 93, 100);
		pLeftHeader.add(btnXoa);
		
		JButton btnXuatExcel = new JButton("XUẤT EXCEL");
		btnXuatExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnXuatExcel.setPreferredSize(new Dimension(120, 140));
		btnXuatExcel.setIcon(new ImageIcon(KhachHangGUI.class.getResource("/image/excelIcon.png")));
		btnXuatExcel.setHorizontalTextPosition(SwingConstants.CENTER);
		btnXuatExcel.setFont(new Font("Verdana", Font.BOLD, 14));
		btnXuatExcel.setBorderPainted(false);
		btnXuatExcel.setBackground(Color.WHITE);
		btnXuatExcel.setBounds(279, 0, 137, 100);
		pLeftHeader.add(btnXuatExcel);
		 
		JButton btnNhapExcel = new JButton("NHẬP EXCEL");
		btnNhapExcel.setBounds(405, 0, 137, 100);
		pLeftHeader.add(btnNhapExcel);
		btnNhapExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNhapExcel.setPreferredSize(new Dimension(120, 140));
		btnNhapExcel.setIcon(new ImageIcon(KhachHangGUI.class.getResource("/image/sheetIcon.png")));
		btnNhapExcel.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNhapExcel.setFont(new Font("Verdana", Font.BOLD, 14));
		btnNhapExcel.setBorderPainted(false);
		btnNhapExcel.setBackground(Color.WHITE);
		
		table = new JTable();
		table.setFont(new Font("Verdana", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(table);
		pHeaderMain.add(scrollPane);
		scrollPane.setBounds(0, 92, 987, 672);
		scrollPane.setFont(new Font("Verdana", Font.PLAIN, 14));

		scrollPane.setViewportView(table);
		fillTableWithSampleData();
		
	}
	private void fillTableWithSampleData() {
		// Dữ liệu mẫu (ví dụ về sản phẩm)
		String[] columnNames = { "Mã KH", "Họ", "Tên", "Số điện thoại", "Địa chỉ" };
		

		// Tạo DefaultTableModel với dữ liệu mẫu
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		
		for(KhachHangDTO x : khachHangBUS.getListKhachHang()) {
			Object[] row = {
					x.getMaKH(),
					x.getHo(),
					x.getTen(),
					x.getDiaChi(),
					x.getSdt(),
			};
			model.addRow(row);
		}
		
		

		// Gán model vào JTable
		table.setModel(model);
		 Font font = new Font("Verdana", Font.PLAIN, 14);
		table.setFont(font);
	}
	
	public void openAddCustomerGUI() {
		JDialog addCutomerDialog = new JDialog(this, "Thêm Sản Phẩm", false); // true để cửa sổ phụ là modal
		addCutomerDialog.setBounds(100, 100, 550, 372);  // Kích thước cửa sổ
		addCutomerDialog.setLocationRelativeTo(this);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    JPanel panelMain = new JPanel();
		panelMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(panelMain);
		panelMain.setLayout(null);
		
		JLabel lbHeader = new JLabel("THÊM KHÁCH HÀNG");
		lbHeader.setBounds(5, 5, 531, 31);
		lbHeader.setForeground(Color.WHITE);
		lbHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lbHeader.setFont(new Font("Arial", Font.BOLD, 20));

		lbHeader.setBackground(Color.decode("#FF5252"));
		lbHeader.setOpaque(true);
		panelMain.add(lbHeader);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 29, 559, 300);
		panel.setLayout(null);
		
		JLabel lbMaKH = new JLabel("Mã khách hàng");
		lbMaKH.setFont(new Font("Arial", Font.PLAIN, 14));
		lbMaKH.setBounds(10, 21, 100, 23);
		panel.add(lbMaKH);
		
		JTextField txtMaKH = new JTextField();
		txtMaKH.setBounds(10, 46, 185, 32);
		txtMaKH.setColumns(10);
		panel.add(txtMaKH);
		
		JLabel lbHo = new JLabel("Họ");
		lbHo.setFont(new Font("Arial", Font.PLAIN, 14));
		lbHo.setBounds(10, 101, 100, 23);
		panel.add(lbHo);
		
		JTextField txtHo = new JTextField();
		txtHo.setColumns(10);
		txtHo.setBounds(10, 126, 185, 32);
		panel.add(txtHo);
		
		JLabel lbTen = new JLabel("Tên");
		lbTen.setFont(new Font("Arial", Font.PLAIN, 14));
		lbTen.setBounds(10, 181, 100, 23);
		panel.add(lbTen);
		
		JTextField txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(10, 206, 185, 32);
		panel.add(txtTen);
		
		JLabel lbSDT = new JLabel("Số điện thoại");
		lbSDT.setFont(new Font("Arial", Font.PLAIN, 14));
		lbSDT.setBounds(277, 21, 100, 23);
		panel.add(lbSDT);
		
		JTextField txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(277, 46, 185, 32);
		panel.add(txtSDT);
		
		JLabel lbDiaChi = new JLabel("Địa chỉ");
		lbDiaChi.setFont(new Font("Arial", Font.PLAIN, 14));
		lbDiaChi.setBounds(277, 101, 122, 23);
		panel.add(lbDiaChi);
		
		JTextField txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(277, 126, 185, 32);
		panel.add(txtDiaChi);
		
		
		JButton btnThemKH = new JButton("Thêm");
		btnThemKH.setBounds(134, 265, 109, 25);
		panel.add(btnThemKH);
		btnThemKH.setForeground(Color.WHITE);
		btnThemKH.setFont(new Font("Arial", Font.BOLD, 14));
		btnThemKH.setBackground(Color.decode("#00C853"));
		btnThemKH.setOpaque(true);
		btnThemKH.addActionListener(e -> {
			khachHangBUS.addCustomer(txtMaKH.getText(), txtHo.getText(), txtTen.getText(), txtDiaChi.getText(), txtSDT.getText());
			txtMaKH.setText("");
			txtHo.setText("");
			txtTen.setText("");
			txtDiaChi.setText("");
			txtSDT.setText("");
			fillTableWithSampleData();
		});
		
		JButton btnDong = new JButton("Đóng");
		btnDong.setOpaque(true);
		btnDong.setForeground(Color.WHITE);
		btnDong.setFont(new Font("Arial", Font.BOLD, 14));
		btnDong.setBackground(Color.decode("#E53935"));
		btnDong.setBounds(290, 265, 109, 25);
		panel.add(btnDong);
		btnDong.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        addCutomerDialog.dispose();
		    }
		});
		
		panelMain.add(panel);
		
		addCutomerDialog.getContentPane().add(panelMain);
		addCutomerDialog.setVisible(true);
	}
	
	public void updateCustomerGUI() {
		int selectedRow = table.getSelectedRow();
		 System.out.println("Hàng được chọn: " + selectedRow); 
		if (selectedRow == -1) { 
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để sửa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
	        return;  // Dừng lại, không mở cửa sổ sửa
	    }
		
		JDialog updateCustomerDialog = new JDialog(this, "Thêm Sản Phẩm", true); // true để cửa sổ phụ là modal
		updateCustomerDialog.setBounds(100, 100, 550, 372);  // Kích thước cửa sổ
		updateCustomerDialog.setLocationRelativeTo(this);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    JPanel panelMain = new JPanel();
		panelMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(panelMain);
		panelMain.setLayout(null);
		
		JLabel lbHeader = new JLabel("SỬA THÔNG TIN KHÁCH HÀNG");
		lbHeader.setBounds(5, 5, 531, 31);
		lbHeader.setForeground(Color.WHITE);
		lbHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lbHeader.setFont(new Font("Arial", Font.BOLD, 20));

		lbHeader.setBackground(Color.decode("#FF5252"));
		lbHeader.setOpaque(true);
		panelMain.add(lbHeader);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 29, 559, 300);
		panel.setLayout(null);
		
		JLabel lbMaKH = new JLabel("Mã khách hàng");
		lbMaKH.setFont(new Font("Arial", Font.PLAIN, 14));
		lbMaKH.setBounds(10, 21, 100, 23);
		panel.add(lbMaKH);
		
		JTextField txtMaKH = new JTextField();
		txtMaKH.setBounds(10, 46, 185, 32);
		txtMaKH.setColumns(10);
		txtMaKH.setText(table.getValueAt(selectedRow, 0).toString());
		panel.add(txtMaKH);
		
		JLabel lbHo = new JLabel("Họ");
		lbHo.setFont(new Font("Arial", Font.PLAIN, 14));
		lbHo.setBounds(10, 101, 100, 23);
		panel.add(lbHo);
		
		JTextField txtHo = new JTextField();
		txtHo.setColumns(10);
		txtHo.setBounds(10, 126, 185, 32);
		txtHo.setText(table.getValueAt(selectedRow, 1).toString());
		panel.add(txtHo);
		
		JLabel lbTen = new JLabel("Tên");
		lbTen.setFont(new Font("Arial", Font.PLAIN, 14));
		lbTen.setBounds(10, 181, 100, 23);
		panel.add(lbTen);
		
		JTextField txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(10, 206, 185, 32);
		txtTen.setText(table.getValueAt(selectedRow, 2).toString());
		panel.add(txtTen);
		
		JLabel lbSDT = new JLabel("Số điện thoại");
		lbSDT.setFont(new Font("Arial", Font.PLAIN, 14));
		lbSDT.setBounds(277, 21, 100, 23);
		panel.add(lbSDT);
		
		JTextField txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(277, 46, 185, 32);
		txtSDT.setText(table.getValueAt(selectedRow, 3).toString());
		panel.add(txtSDT);
		
		JLabel lbDiaChi = new JLabel("Địa chỉ");
		lbDiaChi.setFont(new Font("Arial", Font.PLAIN, 14));
		lbDiaChi.setBounds(277, 101, 122, 23);
		panel.add(lbDiaChi);
		
		JTextField txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(277, 126, 185, 32);
		txtDiaChi.setText(table.getValueAt(selectedRow, 4).toString());
		panel.add(txtDiaChi);
		
		
		JButton btnSuaKH = new JButton("SửaKH");
		btnSuaKH.setBounds(134, 265, 109, 25);
		panel.add(btnSuaKH);
		btnSuaKH.setForeground(Color.WHITE);
		btnSuaKH.setFont(new Font("Arial", Font.BOLD, 14));
		btnSuaKH.setBackground(Color.decode("#00C853"));
		btnSuaKH.setOpaque(true);
		
		JButton btnDong = new JButton("Đóng");
		btnDong.setOpaque(true);
		btnDong.setForeground(Color.WHITE);
		btnDong.setFont(new Font("Arial", Font.BOLD, 14));
		btnDong.setBackground(Color.decode("#E53935"));
		btnDong.setBounds(290, 265, 109, 25);
		panel.add(btnDong);
		
		panelMain.add(panel);
		
		btnSuaKH.addActionListener(e -> {
			khachHangBUS.updateCustomer(txtMaKH.getText(), txtHo.getText(), txtTen.getText(), txtDiaChi.getText(), txtSDT.getText(), selectedRow);
			updateCustomerDialog.dispose();
			fillTableWithSampleData();
		});
		
		btnDong.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	updateCustomerDialog.dispose();
		    }
		});
		
		updateCustomerDialog.getContentPane().add(panelMain);
		updateCustomerDialog.setVisible(true);
		
	}
	
	public void deleteCustomerGUI() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow == -1) { 
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
	        return;  // Dừng lại, không mở cửa sổ sửa
	    }
		khachHangBUS.deleteCustomer(selectedRow);
		fillTableWithSampleData();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		
		if(str.equals("Thêm")) {
			openAddCustomerGUI();
			revalidate();
			repaint();
			initComponents();
		}
		else if(str.equals("Sửa")) {
			updateCustomerGUI();
			revalidate();
			repaint();
			initComponents();
		}
		else if(str.equals("Xóa")) {
			System.out.println("xóa");
			deleteCustomerGUI();
			revalidate();
			repaint();
			initComponents();
		}
		
	}
}
