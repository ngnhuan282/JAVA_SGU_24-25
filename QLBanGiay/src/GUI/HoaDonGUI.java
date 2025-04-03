package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.ChiTietHoaDonBUS;
import BUS.HoaDonBUS;
import DTO.ChiTietHDDTO;
import DTO.KhachHangDTO;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextField;

public class HoaDonGUI extends JFrame implements ActionListener{

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
	
	private HoaDonBUS hoaDonBUS;
	private ChiTietHoaDonBUS chiTietHoaDonBUS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDonGUI frame = new HoaDonGUI();
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
	public HoaDonGUI() {
		hoaDonBUS = new HoaDonBUS();
		chiTietHoaDonBUS = new ChiTietHoaDonBUS();
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
		btnSanPhamGUI.addActionListener(this);
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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 91, 539, 374);
		pHeaderMain.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBorder(new CompoundBorder());
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(0, 0, 539, 375);
		panel.add(jScrollPane);
		table.setBounds(0, 91, 539, 312);
		jScrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 464, 983, 286);
		pHeaderMain.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 997, 286);
		panel_1.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(538, 0, 470, 467);
		pHeaderMain.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin hóa đơn");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(153, 0, 201, 51);
		panel_3.add(lblNewLabel);
		
		txtMaHD = new JTextField();
		txtMaHD.setBounds(98, 50, 148, 31);
		panel_3.add(txtMaHD);
		txtMaHD.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn");
		lblNewLabel_1.setLabelFor(txtMaHD);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 49, 67, 31);
		panel_3.add(lblNewLabel_1);
		
		JLabel lbMaKH = new JLabel("Mã khách hàng");
		lbMaKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbMaKH.setBounds(10, 180, 93, 31);
		panel_3.add(lbMaKH);
		
		txtMaKH = new JTextField();
		lbMaKH.setLabelFor(txtMaKH);
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(98, 180, 148, 31);
		panel_3.add(txtMaKH);
		
		JButton btnOpenMaKHList = new JButton("...");
		btnOpenMaKHList.setBounds(256, 186, 21, 21);
		panel_3.add(btnOpenMaKHList);
		
		JLabel lblMaNV = new JLabel("Mã nhân viên");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaNV.setBounds(10, 118, 83, 31);
		panel_3.add(lblMaNV);
		
		txtMaNV = new JTextField();
		lblMaNV.setLabelFor(txtMaNV);
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(98, 118, 148, 31);
		panel_3.add(txtMaNV);
		
		JButton btnOpenMaNVList = new JButton("...");
		btnOpenMaNVList.setBounds(256, 124, 21, 21);
		panel_3.add(btnOpenMaNVList);
		btnOpenMaNVList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tạo JDialog để hiển thị danh sách
                JDialog dialog = new JDialog();
                dialog.setSize(300, 200);

                // Dữ liệu mẫu cho JList
                String[] employeeCodes = {"NV001", "NV002", "NV003", "NV004", "NV005"};
                JList<String> employeeList = new JList<>(employeeCodes);

                // Bắt sự kiện khi chọn mã nhân viên
                employeeList.addListSelectionListener(event -> {
                    if (!event.getValueIsAdjusting()) {
                        String selectedCode = employeeList.getSelectedValue();
               
                        dialog.dispose(); // Đóng JDialog sau khi chọn mã
                    }
                });

                // Đặt JScrollPane cho JList (nếu danh sách dài)
                dialog.add(new JScrollPane(employeeList));
                dialog.setLocationRelativeTo(null); // Canh giữa cửa sổ chính
                dialog.setVisible(true);
            }
        });

		
		JLabel lblMSnPhm = new JLabel("Mã sản phẩm");
		lblMSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMSnPhm.setBounds(10, 245, 93, 31);
		panel_3.add(lblMSnPhm);
		
		txtMaSP = new JTextField();
		lblMSnPhm.setLabelFor(txtMaSP);
		txtMaSP.setColumns(10);
		txtMaSP.setBounds(98, 245, 148, 31);
		panel_3.add(txtMaSP);
		
		JButton btnOpenMaSPList = new JButton("...");
		btnOpenMaSPList.setBounds(256, 251, 21, 21);
		panel_3.add(btnOpenMaSPList);
		
		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSoLuong.setBounds(10, 316, 93, 31);
		panel_3.add(lblSoLuong);
		
		txtSoLuong = new JTextField();
		lblSoLuong.setLabelFor(txtSoLuong);
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(98, 316, 148, 31);
		panel_3.add(txtSoLuong);
		
		btnComplete = new JButton("Hoàn tất hóa đơn");
		btnComplete.setBackground(Color.decode("#00C853"));
		btnComplete.setActionCommand("Hoàn tất hóa đơn");
		btnComplete.setBounds(10, 396, 154, 42);
		panel_3.add(btnComplete);
		
		btnAddProduct = new JButton("Thêm sản phẩm");
		btnAddProduct.setBounds(174, 396, 154, 42);
		btnAddProduct.setBackground(Color.decode("#FF5252"));
		btnAddProduct.setActionCommand("Thêm sản phẩm");
		panel_3.add(btnAddProduct);
		
		btnCancel = new JButton("Hủy");
		btnCancel.setBounds(338, 396, 103, 42);
		btnCancel.setBackground(Color.decode("#E53935"));
		btnCancel.setActionCommand("Hủy");
		panel_3.add(btnCancel);
		
		table.getTableHeader().setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
		
		openBillTable();
		openBillDetailTable();
	}
	
	private void openBillDetailTable() {
		String[] columnNameBillDetail = { "Mã hóa đơn", "Mã sản phẩm", "Số lương", "Đơn giá", "Thành tiền" };
		DefaultTableModel model1 = new DefaultTableModel(columnNameBillDetail, 0);
		
		for(ChiTietHDDTO x : chiTietHoaDonBUS.getListCTHD()) {
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
	
	private void openBillTable() {
		// Dữ liệu mẫu (ví dụ về sản phẩm)
		String[] columnNamesBill = { "Mã hóa đơn", "Mã khách hàng", "Mã nhân viên", "Ngày lập", "Tổng tiền" };

		// Tạo DefaultTableModel với dữ liệu mẫu
		DefaultTableModel model = new DefaultTableModel(columnNamesBill, 0);
//		for(KhachHangDTO x : khachHangBUS.getListKhachHang()) {
//			Object[] row = {
//					x.getMaKH(),
//					x.getHo(),
//					x.getTen(),
//					x.getSdt(),
//					x.getDiaChi(),
//			};
//			model.addRow(row);
//		}
//		
		

		// Gán model vào JTable

		table.setModel(model);
		 Font font = new Font("Verdana", Font.PLAIN, 14);
		table.setFont(font);
	}
	
	public void openAddBill() {
		txtMaHD.setText(hoaDonBUS.getMaHD());
		btnAddProduct.addActionListener(e -> {
			if(txtMaHD.getText().equals("") || txtMaKH.getText().equals("") || txtMaNV.getText().equals("") || txtMaSP.getText().equals("") || txtSoLuong.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin hóa đơn", "Thông báo", JOptionPane.WARNING_MESSAGE);
				return;
			}
			String maHD = txtMaHD.getText();
			String maKH = txtMaKH.getText();
			String maNV = txtMaNV.getText();
			String maSP = txtMaSP.getText();
			int soLuong = Integer.valueOf(txtSoLuong.getText());
			
			chiTietHoaDonBUS.addCTHD(maHD, maSP, soLuong, 0, 0);
			openBillDetailTable();
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		
		if(str.equals("Thêm")) {
			openAddBill();
		}
		
	}
}
