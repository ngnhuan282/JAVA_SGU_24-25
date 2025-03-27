package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
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
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class NhaCungCapGUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	private int DEFAULT_WIDTH = 1200, DEFAULT_HEIGHT= 800;
	private String color = "#FF5252";
	private JTable table;
	private ArrayList<NCC> listNCC = new ArrayList<>();


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhaCungCapGUI frame = new NhaCungCapGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public NhaCungCapGUI()
	{
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
		pMain.setBounds(205, 6, 979, 755);
		contentPane.add(pMain);
		pMain.setLayout(null);
		
		JPanel pHeaderMain = new JPanel();
		pHeaderMain.setBounds(0, 0, 980, 100);
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
		lbInfo1.setIcon(new ImageIcon(NhaCungCapGUI.class.getResource("/image/userIcon.png")));
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
		btnDangXuat.setIcon(new ImageIcon(NhaCungCapGUI.class.getResource("/image/logoutIcon.png")));
		btnDangXuat.setOpaque(true);
		btnDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
		btnDangXuat.setForeground(Color.WHITE);
		btnDangXuat.setFont(new Font("Verdana", Font.BOLD, 14));
		btnDangXuat.setBorderPainted(false);
		btnDangXuat.setBackground(Color.decode(color));
		btnDangXuat.setBounds(0, 587, 200, 35);
		pNavItem.add(btnDangXuat);
		
		JButton btnTrangChuGUI = new JButton("TRANG CHỦ");
		btnTrangChuGUI.setIcon(new ImageIcon(NhaCungCapGUI.class.getResource("/image/homeIcon.png")));
		btnTrangChuGUI.setOpaque(true);
		btnTrangChuGUI.setHorizontalAlignment(SwingConstants.LEFT);
		btnTrangChuGUI.setForeground(Color.WHITE);
		btnTrangChuGUI.setFont(new Font("Verdana", Font.BOLD, 14));
		btnTrangChuGUI.setBorderPainted(false);
		btnTrangChuGUI.setBackground(Color.decode(color));
		btnTrangChuGUI.setBounds(0, 0, 200, 35);
		pNavItem.add(btnTrangChuGUI);
		
		JButton btnSanPhamGUI = new JButton("SẢN PHẨM");
		btnSanPhamGUI.setIcon(new ImageIcon(NhaCungCapGUI.class.getResource("/image/productIcon.png")));
		btnSanPhamGUI.setOpaque(true);
		btnSanPhamGUI.setHorizontalAlignment(SwingConstants.LEFT);
		btnSanPhamGUI.setForeground(Color.WHITE);
		btnSanPhamGUI.setFont(new Font("Verdana", Font.BOLD, 14));
		btnSanPhamGUI.setBorderPainted(false);
		btnSanPhamGUI.setBackground(Color.decode(color));
		btnSanPhamGUI.setBounds(0, 38, 200, 35);
		pNavItem.add(btnSanPhamGUI);
		
		JButton btnNhaCungCapGUI = new JButton("NHÀ CUNG CẤP");
		btnNhaCungCapGUI.setIcon(new ImageIcon(NhaCungCapGUI.class.getResource("/image/providerIcon.png")));
		btnNhaCungCapGUI.setOpaque(true);
		btnNhaCungCapGUI.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhaCungCapGUI.setForeground(Color.WHITE);
		btnNhaCungCapGUI.setFont(new Font("Verdana", Font.BOLD, 14));
		btnNhaCungCapGUI.setBorderPainted(false);
		btnNhaCungCapGUI.setBackground(Color.decode(color));
		btnNhaCungCapGUI.setBounds(0, 72, 200, 35);
		pNavItem.add(btnNhaCungCapGUI);
		
		JButton btnNhanVienGUI = new JButton("NHÂN VIÊN");
		btnNhanVienGUI.setIcon(new ImageIcon(NhaCungCapGUI.class.getResource("/image/employeeIcon.png")));
		btnNhanVienGUI.setOpaque(true);
		btnNhanVienGUI.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVienGUI.setForeground(Color.WHITE);
		btnNhanVienGUI.setFont(new Font("Verdana", Font.BOLD, 14));
		btnNhanVienGUI.setBorderPainted(false);
		btnNhanVienGUI.setBackground(Color.decode(color));
		btnNhanVienGUI.setBounds(0, 107, 200, 35);
		pNavItem.add(btnNhanVienGUI);
		
		JButton btnKhachHangGUI = new JButton("KHÁCH HÀNG");
		btnKhachHangGUI.setIcon(new ImageIcon(NhaCungCapGUI.class.getResource("/image/clientIcon.png")));
		btnKhachHangGUI.setOpaque(true);
		btnKhachHangGUI.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHangGUI.setForeground(Color.WHITE);
		btnKhachHangGUI.setFont(new Font("Verdana", Font.BOLD, 14));
		btnKhachHangGUI.setBorderPainted(false);
		btnKhachHangGUI.setBackground(Color.decode(color));
		btnKhachHangGUI.setBounds(0, 141, 200, 35);
		pNavItem.add(btnKhachHangGUI);
		
		JButton btnPhieuNhapGUI = new JButton("PHIẾU NHẬP");
		btnPhieuNhapGUI.setIcon(new ImageIcon(NhaCungCapGUI.class.getResource("/image/phieuNhap.png")));
		btnPhieuNhapGUI.setOpaque(true);
		btnPhieuNhapGUI.setHorizontalAlignment(SwingConstants.LEFT);
		btnPhieuNhapGUI.setForeground(Color.WHITE);
		btnPhieuNhapGUI.setFont(new Font("Verdana", Font.BOLD, 14));
		btnPhieuNhapGUI.setBorderPainted(false);
		btnPhieuNhapGUI.setBackground(Color.decode(color));
		btnPhieuNhapGUI.setBounds(0, 173, 200, 35);
		pNavItem.add(btnPhieuNhapGUI);
		
		JButton btnPhieuXuat = new JButton("PHIẾU XUẤT");
		btnPhieuXuat.setIcon(new ImageIcon(NhaCungCapGUI.class.getResource("/image/phieuXuat.png")));
		btnPhieuXuat.setOpaque(true);
		btnPhieuXuat.setHorizontalAlignment(SwingConstants.LEFT);
		btnPhieuXuat.setForeground(Color.WHITE);
		btnPhieuXuat.setFont(new Font("Verdana", Font.BOLD, 14));
		btnPhieuXuat.setBorderPainted(false);
		btnPhieuXuat.setBackground(Color.decode(color));
		btnPhieuXuat.setBounds(0, 207, 200, 35);
		pNavItem.add(btnPhieuXuat);
		
		JButton btnKhuyenMaiGUI = new JButton("KHUYẾN MÃI");
		btnKhuyenMaiGUI.setIcon(new ImageIcon(NhaCungCapGUI.class.getResource("/image/saleIcon.png")));
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
		btnThem.setIcon(new ImageIcon(NhaCungCapGUI.class.getResource("/image/addIcon.png")));
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
		btnSua.setIcon(new ImageIcon(NhaCungCapGUI.class.getResource("/image/editIcon.png")));
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
		btnXoa.setIcon(new ImageIcon(NhaCungCapGUI.class.getResource("/image/deleteIcon.png")));
		btnXoa.setHorizontalTextPosition(SwingConstants.CENTER);
		btnXoa.setFont(new Font("Verdana", Font.BOLD, 14));
		btnXoa.setBackground(Color.WHITE);
		btnXoa.setBounds(187, 0, 93, 100);
		pLeftHeader.add(btnXoa);
		
		JButton btnXuatExcel = new JButton("XUẤT EXCEL");
		btnXuatExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnXuatExcel.setPreferredSize(new Dimension(120, 140));
		btnXuatExcel.setIcon(new ImageIcon(NhaCungCapGUI.class.getResource("/image/excelIcon.png")));
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
		btnNhapExcel.setIcon(new ImageIcon(NhaCungCapGUI.class.getResource("/image/sheetIcon.png")));
		btnNhapExcel.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNhapExcel.setFont(new Font("Verdana", Font.BOLD, 14));
		btnNhapExcel.setBorderPainted(false);
		btnNhapExcel.setBackground(Color.WHITE);
		
		JPanel PanelTable = new JPanel();
		PanelTable.setBounds(10, 111, 959, 633);
		pMain.add(PanelTable);
		PanelTable.setLayout(null);
		
		//khoi tao table voi cac header cot co san
		String[] columnNames = { "Mã NCC", "Tên Nhà Cung Cấp", "Số Điện Thoại", "Địa Chỉ" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		table = new JTable(model);
		table.setFont(new Font("Verdana", Font.PLAIN, 12));
		table.setGridColor(new Color(200, 200, 200));
		table.getTableHeader().setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
		
		table.setRowHeight(23);
		table.getTableHeader().setPreferredSize(new Dimension(0, 23));
		table.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 12));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(270);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(350);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 939, 611);
		scrollPane.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(220, 220, 220))); //do dai vien tren duoi trai phai
		
		
		//test du lieu co san 
		NCC ncc1 = new NCC("A", "Công ty A", "0123456789", "HCM");
		NCC ncc2 = new NCC("B", "Công ty B", "0123456789", "HCM");
		NCC ncc3 = new NCC("C", "Công ty C", "0123456789", "HCM");
		NCC ncc4 = new NCC("D", "Công ty D", "0123456789", "HCM");
		NCC ncc5 = new NCC("E", "Công ty E", "0123456789", "HCM");
		NCC ncc6 = new NCC("F", "Công ty F", "0123456789", "HCM");
		NCC ncc7 = new NCC("G", "Công ty G", "0123456789", "HCM");
		listNCC.add(ncc1);
		listNCC.add(ncc2);
		listNCC.add(ncc3);
		listNCC.add(ncc4);
		listNCC.add(ncc5); 
		listNCC.add(ncc6);
		listNCC.add(ncc7);
		/////////////////////
		
		ListNCC();
		
		PanelTable.add(scrollPane);
	}
	
	public class NCC{ //can co class NCC de tao duoc array
		public String maNCC;
		public String tenNCC;
		public String SDT;
		public String diaChi;
		
		public NCC(String maNCC,String tenNCC, String SDT,String diaChi) {
			this.maNCC=maNCC;
			this.tenNCC=tenNCC;
			this.SDT=SDT;
			this.diaChi=diaChi;
		}
		
		 	public String getMaNCC() { 
			 return this.maNCC; 
			 }

		    public String getTenNCC() { 
		    	return this.tenNCC; 
		    }
		    public String getSDT() {
		    	return this.SDT; 
		    }
		    public String getDiaChi() { 
		    	return this.diaChi; 
		    }
		   

			public void setMaNCC(String maNCC) {
				this.maNCC = maNCC;
			}

			public void setTenNCC(String tenNCC) {
				this.tenNCC = tenNCC;
			}

			public void setSDT(String sDT) {
				SDT = sDT;
			}

			public void setDiaChi(String diaChi) {
				this.diaChi = diaChi;
			}
	}
	
	
	public void ListNCC(){//set array list

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		for(NCC ncc : listNCC)
			model.addRow(new Object[] {ncc.getMaNCC(), ncc.getTenNCC(), ncc.getSDT(), ncc.getDiaChi()});
	}
	
//Main eventtttttttttttttttt
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if(command.equals("Thêm"))
			openAddNCCGUI();
		else if(command.equals("Sửa")) 
			openEditNCCGUI();
		else if(command.equals("Xóa"))
			deleteNCC();
	}
	
	
	public void deleteNCC() {
		int selectedRow = table.getSelectedRow();
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn một nhà cung cấp để xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        return;
		}
		
		int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa nhà cung cấp này?","Xác nhận",JOptionPane.YES_NO_OPTION);
		if(confirm == JOptionPane.YES_OPTION)
		{
			String maNCC = table.getValueAt(selectedRow, 0).toString();
		
			listNCC.removeIf(ncc -> ncc.getMaNCC().equals(maNCC));
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			
			for(NCC ncc : listNCC)
				model.addRow(new Object[] {ncc.getMaNCC(), ncc.getTenNCC(), ncc.getSDT(), ncc.getDiaChi()});
		}
	}
	
	
	public void openAddNCCGUI() {
		
	    JDialog addNCCDialog = new JDialog(this, "Thêm Nhà Cung Cấp", true); 
	    addNCCDialog.setBounds(100, 100, 550, 372);
	    addNCCDialog.setLocationRelativeTo(this);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    addNCCDialog.setSize(366,427);
	    addNCCDialog.setLocationRelativeTo(this);
    	
    	JPanel MainPanel = new JPanel();
    	MainPanel.setBounds(10, 11, 597, 454);
    	getContentPane().add(MainPanel);
    	MainPanel.setLayout(null);
    	
    	JPanel TitlePanel = new JPanel();
    	TitlePanel.setBounds(0, 0, 350, 51);
    	TitlePanel.setBackground(Color.decode(color));
    	MainPanel.add(TitlePanel);
    	TitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15)); // tu dong canh giua
    	
    	JLabel lbAdd = new JLabel("THÊM NHÀ CUNG CẤP\r\n");
    	lbAdd.setForeground(Color.WHITE);
    	lbAdd.setFont(new Font("Verdana", Font.BOLD, 14));
    	TitlePanel.add(lbAdd);
    	
    	JLabel lbMaNCC = new JLabel("Mã Nhà Cung Cấp");
    	lbMaNCC.setFont(new Font("Verdana", Font.BOLD, 12));
    	lbMaNCC.setBounds(30, 62, 132, 23);
    	MainPanel.add(lbMaNCC);
    	
    	JTextField txtMaNCC = new JTextField();
    	txtMaNCC.setBounds(30, 87, 290, 33);
    	MainPanel.add(txtMaNCC);
    	txtMaNCC.setColumns(10);
    	
    	JLabel lbTenNCC = new JLabel("Tên Nhà Cung Cấp");
    	lbTenNCC.setFont(new Font("Verdana", Font.BOLD, 12));
    	lbTenNCC.setBounds(30, 131, 132, 14);
    	MainPanel.add(lbTenNCC);
    	
    	JTextField txtTenNCC = new JTextField();
    	txtTenNCC.setColumns(10);
    	txtTenNCC.setBounds(30, 156, 290, 33);
    	MainPanel.add(txtTenNCC);
    	
    	JLabel lbSDT = new JLabel("Số Điện Thoại");
    	lbSDT.setFont(new Font("Verdana", Font.BOLD, 12));
    	lbSDT.setBounds(30, 200, 132, 14);
    	MainPanel.add(lbSDT);
    	
    	JTextField txtSDT = new JTextField();
    	txtSDT.setColumns(10);
    	txtSDT.setBounds(30, 225, 290, 33);
    	MainPanel.add(txtSDT);
    	
    	JLabel lbDiaChi = new JLabel("Địa Chỉ");
    	lbDiaChi.setFont(new Font("Verdana", Font.BOLD, 12));
    	lbDiaChi.setBounds(30, 269, 132, 14);
    	MainPanel.add(lbDiaChi);
    	
    	JTextField txtDiaChi = new JTextField();
    	txtDiaChi.setColumns(10);
    	txtDiaChi.setBounds(30, 294, 290, 33);
    	MainPanel.add(txtDiaChi);
    	
    	JButton btnAdd = new JButton("Thêm");
    	btnAdd.setFont(new Font("Verdana", Font.BOLD, 12));
    	btnAdd.setBounds(30, 338, 138, 33);
    	btnAdd.setBackground(new Color(51, 204, 102));
    	btnAdd.setOpaque(true);
    	btnAdd.setBorderPainted(false);
    	btnAdd.setForeground(Color.WHITE);    	
    	MainPanel.add(btnAdd);
    	
    	JButton btnCancel = new JButton("Hủy");
    	btnCancel.setFont(new Font("Verdana", Font.BOLD, 12));
    	btnCancel.setBounds(175, 338, 145, 33);
    	btnCancel.setOpaque(true);
    	btnCancel.setBorderPainted(false);
    	btnCancel.setBackground(new Color(225,20,60));
    	btnCancel.setForeground(Color.WHITE);
    	MainPanel.add(btnCancel);
    	
    	
    	//nut huy
    	btnCancel.addActionListener(e -> addNCCDialog.dispose());
    	
    	//Su Kien Them dialog
    	btnAdd.addActionListener(e -> {
	
				String maNCC = txtMaNCC.getText().trim();
				String tenNCC = txtTenNCC.getText().trim();
				String sdt = txtSDT.getText().trim();
				String diaChi = txtDiaChi.getText().trim();
				
				if (maNCC.isEmpty() || tenNCC.isEmpty() || sdt.isEmpty() || diaChi.isEmpty()) {
		             JOptionPane.showMessageDialog(addNCCDialog, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		             return;
		            }
				if (isDuplicateNCC(maNCC)) {
					 JOptionPane.showMessageDialog(addNCCDialog, "Mã nhà cung cấp đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
					 return;
				}
				
				listNCC.add(new NCC(maNCC,tenNCC,sdt,diaChi));
				
				
				ListNCC();
				
				addNCCDialog.dispose();
			
			
		});
    	addNCCDialog.getContentPane().add(MainPanel);
    	addNCCDialog.setVisible(true);
	}

	
	public boolean isDuplicateNCC(String maNCC) {
		for(NCC ncc : listNCC) 
			if(ncc.getMaNCC().equals(maNCC))
				return true;
		return false;
	}
	
	
	
	public void openEditNCCGUI() {
		//lay dong dc selected
		int selectedRow = table.getSelectedRow();
		if(selectedRow == -1)
		{
			JOptionPane.showMessageDialog(null,"Vui lòng chọn một nhà cung cấp để sửa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return;
		}			
		
		String maNCC =table.getValueAt(selectedRow, 0).toString();
		String tenNCC =table.getValueAt(selectedRow, 1).toString();
		String sdt =table.getValueAt(selectedRow, 2).toString();
		String diaChi =table.getValueAt(selectedRow, 3).toString();
		
		//////
	    JDialog editNCCDialog = new JDialog(this, "Sửa Thông Tin Nhà Cung Cấp", true); 
	    editNCCDialog.setBounds(100, 100, 550, 372);
	    editNCCDialog.setLocationRelativeTo(this);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    editNCCDialog.setSize(366,427);
	    editNCCDialog.setLocationRelativeTo(this);
    	
    	JPanel MainPanel = new JPanel();
    	MainPanel.setBounds(10, 11, 597, 454);
    	getContentPane().add(MainPanel);
    	MainPanel.setLayout(null);
    	
    	JPanel TitlePanel = new JPanel();
    	TitlePanel.setBounds(0, 0, 350, 51);
    	TitlePanel.setBackground(Color.decode(color));
    	MainPanel.add(TitlePanel);
    	TitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
    	
    	JLabel lbAdd = new JLabel("SỬA THÔNG TIN\r\n");
    	lbAdd.setForeground(Color.WHITE);
    	lbAdd.setFont(new Font("Verdana", Font.BOLD, 14));
    	TitlePanel.add(lbAdd);
    	
    	JLabel lbMaNCC = new JLabel("Mã Nhà Cung Cấp");
    	lbMaNCC.setFont(new Font("Verdana", Font.BOLD, 12));
    	lbMaNCC.setBounds(30, 62, 132, 23);
    	MainPanel.add(lbMaNCC);
    	
    	JTextField txtMaNCC = new JTextField(maNCC);
    	txtMaNCC.setBounds(30, 87, 290, 33);
    	MainPanel.add(txtMaNCC);
    	txtMaNCC.setColumns(10);
    	
    	JLabel lbTenNCC = new JLabel("Tên Nhà Cung Cấp");
    	lbTenNCC.setFont(new Font("Verdana", Font.BOLD, 12));
    	lbTenNCC.setBounds(30, 131, 132, 14);
    	MainPanel.add(lbTenNCC);
    	
    	JTextField txtTen = new JTextField(tenNCC);
    	txtTen.setColumns(10);
    	txtTen.setBounds(30, 156, 290, 33);
    	MainPanel.add(txtTen);
    	
    	JLabel lbSDT = new JLabel("Số Điện Thoại");
    	lbSDT.setFont(new Font("Verdana", Font.BOLD, 12));
    	lbSDT.setBounds(30, 200, 132, 14);
    	MainPanel.add(lbSDT);
    	
    	JTextField txtSDT = new JTextField(sdt);
    	txtSDT.setColumns(10);
    	txtSDT.setBounds(30, 225, 290, 33);	
    	MainPanel.add(txtSDT);
    	
    	JLabel lbDiaChi = new JLabel("Địa Chỉ");
    	lbDiaChi.setFont(new Font("Verdana", Font.BOLD, 12));
    	lbDiaChi.setBounds(30, 269, 132, 14);
    	MainPanel.add(lbDiaChi);
    	
    	JTextField txtDiaChi = new JTextField(diaChi);
    	txtDiaChi.setColumns(10);
    	txtDiaChi.setBounds(30, 294, 290, 33);
    	MainPanel.add(txtDiaChi);
    	
    	JButton btnEdit = new JButton("Sửa");
    	btnEdit.setFont(new Font("Verdana", Font.BOLD, 12));
    	btnEdit.setBounds(30, 338, 138, 33);
    	btnEdit.setBackground(new Color(51, 204, 102));
    	btnEdit.setOpaque(true);
    	btnEdit.setBorderPainted(false);
    	btnEdit.setForeground(Color.WHITE);
    	MainPanel.add(btnEdit);
    	
    	JButton btnCancel = new JButton("Hủy");
    	btnCancel.setFont(new Font("Verdana", Font.BOLD, 12));
    	btnCancel.setBounds(175, 338, 145, 33);
    	btnCancel.setOpaque(true);
    	btnCancel.setBorderPainted(false);
    	btnCancel.setBackground(new Color(225,20,60));
    	btnCancel.setForeground(Color.WHITE);
    	MainPanel.add(btnCancel);
    	
    	 // Sự kiện nút Hủy
        btnCancel.addActionListener(e -> editNCCDialog.dispose());
    	
   
    	//su kiem sua
    	btnEdit.addActionListener(e -> {
    		String newMaNCC = txtMaNCC.getText().trim();
			String newTenNCC = txtTen.getText().trim();
			String newSDT = txtSDT.getText().trim();
			String newDiaChi = txtDiaChi.getText().trim();
			
			 if (newMaNCC.isEmpty() || newTenNCC.isEmpty() || newSDT.isEmpty() || newDiaChi.isEmpty()) {
		            JOptionPane.showMessageDialog(editNCCDialog, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
			
			
			//luu thay doi
			for(NCC ncc : listNCC)
			{
				if(ncc.getMaNCC().equals(newMaNCC)&&!ncc.getMaNCC().equals(maNCC))
				{		
					JOptionPane.showMessageDialog(editNCCDialog,"Đã tồn tại mã nhà cung cấp này trong danh sách!" ,  "Lỗi", JOptionPane.ERROR_MESSAGE);
					return;
				}	
			}
			
			for(NCC ncc : listNCC) {
				if(ncc.getMaNCC().equals(maNCC)) {
					ncc.setMaNCC(newMaNCC);
					ncc.setTenNCC(newTenNCC);
					ncc.setSDT(newSDT);
					ncc.setDiaChi(newDiaChi);
					break;
				}
			}	
			
			ListNCC();
			
			editNCCDialog.dispose();
		});
    	
    	
    	
    	editNCCDialog.getContentPane().add(MainPanel);
    	editNCCDialog.setVisible(true);
	}
}
