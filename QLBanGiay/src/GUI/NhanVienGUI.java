package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;

public class NhanVienGUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int DEFAULT_WIDTH = 1200, DEFAULT_HEIGHT= 800;
	private String color = "#FF5252";
	private JTable table;
	private NhanVienBUS nhanVienBUS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVienGUI frame = new NhanVienGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public NhanVienGUI() throws SQLException
	{
		nhanVienBUS = new NhanVienBUS();
		initComponents();
	}
	/**
	 * Create the frame.
	 */
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
		pMain.setLayout(null);
		
		JPanel pHeaderMain = new JPanel();
		pHeaderMain.setBounds(0, 0, 1300, 100);
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
		lbInfo1.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/userIcon.png")));
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
		btnDangXuat.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/logoutIcon.png")));
		btnDangXuat.setOpaque(true);
		btnDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
		btnDangXuat.setForeground(Color.WHITE);
		btnDangXuat.setFont(new Font("Verdana", Font.BOLD, 14));
		btnDangXuat.setBorderPainted(false);
		btnDangXuat.setBackground(Color.decode(color));
		btnDangXuat.setBounds(0, 587, 200, 35);
		pNavItem.add(btnDangXuat);
		
		JButton btnTrangChuGUI = new JButton("TRANG CHỦ");
		btnTrangChuGUI.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/homeIcon.png")));
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
		btnNhanVienGUI.setBounds(0, 107, 200, 35);
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
		pLeftHeader.setBounds(0, 0, 539, 100);
		pHeaderMain.add(pLeftHeader);
		pLeftHeader.setLayout(null);
		
		/************* PHẦN CHỨC NĂNG ************/
		JButton btnThem = new JButton("THÊM");
		btnThem.setActionCommand("Thêm");
		btnThem.addActionListener(this);
		btnThem.setBackground(Color.WHITE);
		btnThem.setBorderPainted(false);
		btnThem.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/addIcon.png")));
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
		btnSua.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/editIcon.png")));
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
		btnXoa.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/deleteIcon.png")));
		btnXoa.setHorizontalTextPosition(SwingConstants.CENTER);
		btnXoa.setFont(new Font("Verdana", Font.BOLD, 14));
		btnXoa.setBackground(Color.WHITE);
		btnXoa.setBounds(187, 0, 93, 100);
		pLeftHeader.add(btnXoa);
		
		JButton btnXuatExcel = new JButton("XUẤT EXCEL");
		btnXuatExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnXuatExcel.setPreferredSize(new Dimension(120, 140));
		btnXuatExcel.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/excelIcon.png")));
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
		btnNhapExcel.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/sheetIcon.png")));
		btnNhapExcel.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNhapExcel.setFont(new Font("Verdana", Font.BOLD, 14));
		btnNhapExcel.setBorderPainted(false);
		btnNhapExcel.setBackground(Color.WHITE);
		
		/************* PHẦN HIỂN THỊ ************/
		table = new JTable();
		table.setFont(new Font("Verdana", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 100, 987, 700);
		scrollPane.setFont(new Font("Verdana", Font.PLAIN, 14));
		pMain.add(scrollPane, BorderLayout.CENTER);
		
	

		
//		JScrollPane scrollPane = new JScrollPane(table);
//		scrollPane.setFont(new Font("Verdana", Font.PLAIN, 14));
		pMain.add(scrollPane);

		scrollPane.setViewportView(table);
		fillTableWithSampleData();
	}
	
	//Hàm này để hiển thị table, demo xem trước
	private DefaultTableModel model;
	private void fillTableWithSampleData() {
		// Dữ liệu mẫu (ví dụ về sản phẩm)
		String[] columnNames = { "Mã Nhân Viên", "Họ NV", "Tên NV", "Số Điện Thoại", "Lương Tháng" };
		
		// Tạo DefaultTableModel với dữ liệu mẫu
		DefaultTableModel model = new DefaultTableModel(columnNames,0);
		
		for(NhanVienDTO x : nhanVienBUS.getListNhanVien()){
			Object[] row = {
					x.getMaNV() , 
					x.getHo(),
					x.getTen(),
					x.getSdt(),
					x.getLuong()
			};
			model.addRow(row);
		}
		
		// Gán model vào JTable
		table.setModel(model);
		 Font font = new Font("Verdana", Font.PLAIN, 14);
		table.setFont(font);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		switch (command) {
		case "Thêm":
			openAddStaffGUI();
			break;
		case "Sửa":
			openFixStaffGUI();
			break;
		case "Xóa":
			delStaffGUI();
			break;
		default:
			break;
		}
	}
	
	//Demoo thoi nka
	public void openAddStaffGUI() {
	    // Tạo cửa sổ JDialog cho việc thêm sản phẩm
	    JDialog addStaffDialog = new JDialog(this, "Thêm Nhân Viên", true); // true để cửa sổ phụ là modal
	    addStaffDialog.setBounds(100, 100, 550, 372);  // Kích thước cửa sổ
	    addStaffDialog.setLocationRelativeTo(this);
	    addStaffDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	    JPanel panelMain = new JPanel();
		panelMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		panelMain.setLayout(null);
		
		JLabel lbHeader = new JLabel("THÊM NHÂN VIÊN");
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
		
		JLabel lbMaNV = new JLabel("Mã nhân viên");
		lbMaNV.setFont(new Font("Arial", Font.PLAIN, 14));
		lbMaNV.setBounds(10, 21, 100, 23);
		panel.add(lbMaNV);
		
		JTextField txtMaNV = new JTextField();
		txtMaNV.setBounds(10, 46, 185, 32);
		txtMaNV.setColumns(10);
		panel.add(txtMaNV);
		
		JLabel lbHoNV = new JLabel("Họ nhân viên");
		lbHoNV.setFont(new Font("Arial", Font.PLAIN, 14));
		lbHoNV.setBounds(10, 101, 100, 23);
		panel.add(lbHoNV);
		
		JTextField txtHoNV = new JTextField();
		txtHoNV.setColumns(10);
		txtHoNV.setBounds(10, 126, 185, 32);
		panel.add(txtHoNV);
		
		JLabel lbTenNV = new JLabel("Tên Nhân Viên");
		lbTenNV.setFont(new Font("Arial", Font.PLAIN, 14));
		lbTenNV.setBounds(10, 181, 100, 23);
		panel.add(lbTenNV);
		
		JTextField txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(10, 206, 185, 32);
		panel.add(txtTenNV);
		
		JLabel lbSDTNV = new JLabel("Số điện thoại");
		lbSDTNV.setFont(new Font("Arial", Font.PLAIN, 14));
		lbSDTNV.setBounds(277, 21, 100, 23);
		panel.add(lbSDTNV);
		
		JTextField txtSDTNV = new JTextField();
		txtSDTNV.setColumns(10);
		txtSDTNV.setBounds(277, 46, 185, 32);
		panel.add(txtSDTNV);
		
		JLabel lbLuongThang = new JLabel("Lương tháng");
		lbLuongThang.setFont(new Font("Arial", Font.PLAIN, 14));
		lbLuongThang.setBounds(277, 101, 122, 23);
		panel.add(lbLuongThang);
		
		JTextField txtLuongThang = new JTextField();
		txtLuongThang.setColumns(10);
		txtLuongThang.setBounds(277, 126, 185, 32);
		panel.add(txtLuongThang);
		
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(50, 265, 109, 25);
		panel.add(btnThem);
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Arial", Font.BOLD, 14));
		btnThem.setBackground(Color.decode("#00C853"));
		btnThem.setOpaque(true);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(210, 265, 109, 25); // Điều chỉnh vị trí theo layout của bạn
		btnXoa.setFont(new Font("Arial", Font.BOLD, 14));
		btnXoa.setBackground(Color.decode("#FF5252"));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setOpaque(true);
		panel.add(btnXoa);
		
		JButton btnDong = new JButton("Đóng");
		btnDong.setOpaque(true);
		btnDong.setForeground(Color.WHITE);
		btnDong.setFont(new Font("Arial", Font.BOLD, 14));
		btnDong.setBackground(Color.decode("#E53935"));
		btnDong.setBounds(370, 265, 109, 25);
		panel.add(btnDong);
		
		panelMain.add(panel);
		addStaffDialog.getContentPane().add(panelMain);
		
		btnXoa.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        txtMaNV.setText("");
		        txtHoNV.setText("");
		        txtTenNV.setText("");
		        txtSDTNV.setText("");
		        txtLuongThang.setText("");

		        txtMaNV.requestFocus();
		    }
		});

		btnDong.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        addStaffDialog.dispose(); // Đóng cửa sổ sửa sản phẩm
		    }
		});
		
		btnThem.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        double luong = 0;
		    	try {
		    	    luong = Double.parseDouble(txtLuongThang.getText());
		    	} catch (NumberFormatException e1) {
		    	    JOptionPane.showMessageDialog(null, "Lương phải là số hợp lệ!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
		    	    return;
		    	}

				String maNV = txtMaNV.getText().trim();
		        String hoNV = txtHoNV.getText().trim();
		        String tenNV = txtTenNV.getText().trim();
		        String sdtNV = txtSDTNV.getText().trim();
		        String luongThang = txtLuongThang.getText().trim();
			        
		        if (maNV.isEmpty() || hoNV.isEmpty() || tenNV.isEmpty() || sdtNV.isEmpty() || luongThang.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ dữ liệu!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            return;
		        }
		        
		        if (!sdtNV.matches("\\d+")) {  // regex: chỉ chấp nhận số (0-9)
		            JOptionPane.showMessageDialog(null, "Số điện thoại chỉ được chứa số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        if(isDuplicateMaNV(maNV)) {
					JOptionPane.showMessageDialog(null, "Mã nhân viên đã tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
					return;
				}
		        if (isDuplicateSDT(sdtNV)) {
		            JOptionPane.showMessageDialog(null, "Số điện thoại đã tồn tại! Vui lòng nhập số khác.", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		       
		        
		    	nhanVienBUS.addStaff(txtMaNV.getText(), txtHoNV.getText(), txtTenNV.getText(), txtSDTNV.getText(), luong);
		    	txtMaNV.setText("");
				txtHoNV.setText("");
				txtTenNV.setText("");
				txtSDTNV.setText("");
				txtLuongThang.setText("");
				fillTableWithSampleData();
		       
		        JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        addStaffDialog.dispose();

		    }
		    //check maNhanVien co trung ko
		    private boolean isDuplicateMaNV(String maNV) {
		        for (int i = 0; i < table.getRowCount(); i++) {  // table là JTable chứa danh sách nhân viên
		            String existingMaNV = table.getValueAt(i, 0).toString();
		            if (maNV.equals(existingMaNV)) {
		            	txtMaNV.requestFocus();
		                return true;
		            }
		        }
		        return false;
		    }
		    private boolean isDuplicateSDT(String sdtNV) {
		        for (int i = 0; i < table.getRowCount(); i++) {  // table là JTable chứa danh sách nhân viên
		            String existingSDTNV = table.getValueAt(i, 3).toString();// Lấy giá trị từ cột Mã NV (cột 0)
		            if (sdtNV.equals(existingSDTNV)) {
		            	txtSDTNV.requestFocus();
		                return true;
		            }
		        }
		        return false;
		    }
		});


		
		addStaffDialog.setVisible(true);
	}
	public void openFixStaffGUI() {
		int selectedRow = table.getSelectedRow(); 
		if (selectedRow == -1) { 
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để sửa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
	        return;  // Dừng lại, không mở cửa sổ sửa
	    }
		
		JDialog fixStaffDialog = new JDialog(this, "Thêm Nhân Viên", true); // true để cửa sổ phụ là modal
	    fixStaffDialog.setBounds(100, 100, 550, 372);  // Kích thước cửa sổ
	    fixStaffDialog.setLocationRelativeTo(this);
	    fixStaffDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	    JPanel panelMain = new JPanel();
		panelMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		panelMain.setLayout(null);
		
		JLabel lbHeader = new JLabel("THÊM NHÂN VIÊN");
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
		
		JLabel lbMaNV = new JLabel("Mã nhân viên");
		lbMaNV.setFont(new Font("Arial", Font.PLAIN, 14));
		lbMaNV.setBounds(10, 21, 100, 23);
		panel.add(lbMaNV);
		
		JTextField txtMaNV = new JTextField();
		txtMaNV.setBounds(10, 46, 185, 32);
		txtMaNV.setColumns(10);
		panel.add(txtMaNV);
		
		JLabel lbHoNV = new JLabel("Họ nhân viên");
		lbHoNV.setFont(new Font("Arial", Font.PLAIN, 14));
		lbHoNV.setBounds(10, 101, 100, 23);
		panel.add(lbHoNV);
		
		JTextField txtHoNV = new JTextField();
		txtHoNV.setColumns(10);
		txtHoNV.setBounds(10, 126, 185, 32);
		panel.add(txtHoNV);
		
		JLabel lbTenNV = new JLabel("Tên Nhân Viên");
		lbTenNV.setFont(new Font("Arial", Font.PLAIN, 14));
		lbTenNV.setBounds(10, 181, 100, 23);
		panel.add(lbTenNV);
		
		JTextField txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(10, 206, 185, 32);
		panel.add(txtTenNV);
		
		JLabel lbSDTNV = new JLabel("Số điện thoại");
		lbSDTNV.setFont(new Font("Arial", Font.PLAIN, 14));
		lbSDTNV.setBounds(277, 21, 100, 23);
		panel.add(lbSDTNV);
		
		JTextField txtSDTNV = new JTextField();
		txtSDTNV.setColumns(10);
		txtSDTNV.setBounds(277, 46, 185, 32);
		panel.add(txtSDTNV);
		
		JLabel lbLuongThang = new JLabel("Lương tháng");
		lbLuongThang.setFont(new Font("Arial", Font.PLAIN, 14));
		lbLuongThang.setBounds(277, 101, 122, 23);
		panel.add(lbLuongThang);
		
		JTextField txtLuongThang = new JTextField();
		txtLuongThang.setColumns(10);
		txtLuongThang.setBounds(277, 126, 185, 32);
		panel.add(txtLuongThang);
		
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(50, 265, 109, 25);
		panel.add(btnSua);
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Arial", Font.BOLD, 14));
		btnSua.setBackground(Color.decode("#00C853"));
		btnSua.setOpaque(true);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(210, 265, 109, 25); // Điều chỉnh vị trí theo layout của bạn
		btnXoa.setFont(new Font("Arial", Font.BOLD, 14));
		btnXoa.setBackground(Color.decode("#FF5252"));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setOpaque(true);
		panel.add(btnXoa);
		
		JButton btnDong = new JButton("Đóng");
		btnDong.setOpaque(true);
		btnDong.setForeground(Color.WHITE);
		btnDong.setFont(new Font("Arial", Font.BOLD, 14));
		btnDong.setBackground(Color.decode("#E53935"));
		btnDong.setBounds(370, 265, 109, 25);
		panel.add(btnDong);
		
		panelMain.add(panel);
		fixStaffDialog.getContentPane().add(panelMain);
		
		btnXoa.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        txtMaNV.setText("");
		        txtHoNV.setText("");
		        txtTenNV.setText("");
		        txtSDTNV.setText("");
		        txtLuongThang.setText("");
		        txtMaNV.requestFocus();
		    }
		});
	    
		//Lay du lieu co san tu hang da chon
	    txtMaNV.setText(table.getValueAt(selectedRow, 0).toString());
	    txtHoNV.setText(table.getValueAt(selectedRow, 1).toString());
	    txtTenNV.setText(table.getValueAt(selectedRow, 2).toString());
	    txtSDTNV.setText(table.getValueAt(selectedRow, 3).toString());
	    txtLuongThang.setText(table.getValueAt(selectedRow, 4).toString());

	    String txtmaNVcu = txtMaNV.getText();
	    String txtsdtcu = txtSDTNV.getText();
		
	    
	    btnSua.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String maNV = txtMaNV.getText().trim();
	            String hoNV = txtHoNV.getText().trim();
	            String tenNV = txtTenNV.getText().trim();
	            String sdtNV = txtSDTNV.getText().trim();
	            String luongNV = txtLuongThang.getText().trim();
	            if (maNV.isEmpty() || hoNV.isEmpty() || tenNV.isEmpty() || sdtNV.isEmpty() || luongNV.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ dữ liệu!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            return;
		        }
	            if(!maNV.equals(txtmaNVcu)) {
	            	if (isDuplicateMaNV(maNV)) {
			            JOptionPane.showMessageDialog(null, "Mã nhân viên đã tồn tại! Vui lòng nhập mã khác.", "Lỗi", JOptionPane.ERROR_MESSAGE);
			            return;
			        }
	            }
	            if(!sdtNV.equals(txtsdtcu)) {
	            	 if (isDuplicateSDT(sdtNV)) {
	 		            JOptionPane.showMessageDialog(null, "Số điện thoại đã tồn tại! Vui lòng nhập số khác.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	 		            return;
	 		        }
	            }
	            if (!sdtNV.matches("\\d+")) {  // regex: chỉ chấp nhận số (0-9)
		            JOptionPane.showMessageDialog(null, "Số điện thoại chỉ được chứa số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            txtSDTNV.requestFocus();
		            return;
		        }
	            // Kiểm tra dữ liệu hợp lệ
	            if (maNV.isEmpty() || hoNV.isEmpty() || tenNV.isEmpty() || sdtNV.isEmpty() || luongNV.isEmpty()) {
	                JOptionPane.showMessageDialog(fixStaffDialog, "Vui lòng điền đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	                return;
	            }
	            
	            // Kiểm tra giá trị số
	            	double luong = 0;
			    	luong = Double.parseDouble(txtLuongThang.getText());
			  
	                // Cập nhật dữ liệu vào bảng
	        	    nhanVienBUS.fixStaff(txtMaNV.getText(),txtHoNV.getText(), txtTenNV.getText(), txtSDTNV.getText(), luong, selectedRow);
	        	    
	        		JOptionPane.showMessageDialog(null, "Sửa nhân viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        		fillTableWithSampleData();


	                fixStaffDialog.dispose();
	            
	        }
	        private boolean isDuplicateMaNV(String maNV) {
		        for (int i = 0; i < table.getRowCount(); i++) {  // table là JTable chứa danh sách nhân viên
		            String existingMaNV = table.getValueAt(i, 0).toString();
		            if (maNV.equals(existingMaNV)) {
		            	txtMaNV.requestFocus();
		                return true;
		            }
		        }
		        return false;
		    }
		    private boolean isDuplicateSDT(String sdtNV) {
		        for (int i = 0; i < table.getRowCount(); i++) {  // table là JTable chứa danh sách nhân viên
		            String existingSDTNV = table.getValueAt(i, 3).toString();// Lấy giá trị từ cột Mã NV (cột 0)
		            if (sdtNV.equals(existingSDTNV)) {
		            	txtSDTNV.requestFocus();
		                return true;
		            }
		        }
		        return false;
		    }
	    });

	    
		btnDong.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        fixStaffDialog.dispose(); // Đóng cửa sổ sửa sản phẩm
		    }
		});
		
	    
		fixStaffDialog.setVisible(true);
		
		
	}
	public void delStaffGUI() {
	    int selectedRow = table.getSelectedRow();
	    if (selectedRow == -1) {
	        JOptionPane.showMessageDialog(null, "Vui lòng chọn một nhân viên để xóa!", "Lỗi", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa nhân viên này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
	    if (confirm == JOptionPane.YES_OPTION) {
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.removeRow(selectedRow);

	        // Cập nhật bảng sau khi xóa
	        updateTableSort();
	        JOptionPane.showMessageDialog(null, "Xóa nhân viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
	private void updateTableSort() {
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
	    table.setRowSorter(sorter);

	    // Sắp xếp lại theo cột "Mã nhân viên" (cột 0) tăng dần
	    sorter.setSortKeys(List.of(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
	    sorter.sort();
	}


	


}
