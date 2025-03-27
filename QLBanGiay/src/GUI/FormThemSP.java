package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FormThemSP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelMain;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtDonGia;
	private JTextField txtDonViTinh;
	private JTextField txtSoLuong;
	private JTextField txtChatLieu;
	private JTextField txtKieuDang;
	private JTextField taMoTa;
	private JTextField txtMaLoaiSP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormThemSP frame = new FormThemSP();
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
	public FormThemSP() {
		setTitle("Thêm sản phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 582);
		panelMain = new JPanel();
		panelMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(panelMain);
		panelMain.setLayout(null);
		
		JLabel lbHeader = new JLabel("THÊM SẢN  PHẨM");
		lbHeader.setBounds(5, 5, 453, 31);
		lbHeader.setForeground(Color.WHITE);
		lbHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lbHeader.setFont(new Font("Arial", Font.BOLD, 20));

		lbHeader.setBackground(Color.decode("#FF5252"));
		lbHeader.setOpaque(true);
		panelMain.add(lbHeader);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 31, 440, 514);
		panelMain.add(panel);
		panel.setLayout(null);
		
		JLabel lbMaSP = new JLabel("Mã sản phẩm");
		lbMaSP.setFont(new Font("Arial", Font.PLAIN, 14));
		lbMaSP.setBounds(10, 21, 100, 23);
		panel.add(lbMaSP);
		
		txtMaSP = new JTextField();
		txtMaSP.setBounds(10, 46, 185, 32);
		panel.add(txtMaSP);
		txtMaSP.setColumns(10);
		
		JLabel lbTenSP = new JLabel("Tên sản phẩm");
		lbTenSP.setFont(new Font("Arial", Font.PLAIN, 14));
		lbTenSP.setBounds(10, 101, 100, 23);
		panel.add(lbTenSP);
		
		txtTenSP = new JTextField();
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(10, 126, 185, 32);
		panel.add(txtTenSP);
		
		JLabel lbDonGia = new JLabel("Đơn giá");
		lbDonGia.setFont(new Font("Arial", Font.PLAIN, 14));
		lbDonGia.setBounds(10, 181, 100, 23);
		panel.add(lbDonGia);
		
		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(10, 206, 185, 32);
		panel.add(txtDonGia);
		
		JButton btnThemSP = new JButton("Thêm");
		btnThemSP.setBounds(20, 479, 109, 25);
		panel.add(btnThemSP);
		btnThemSP.setForeground(Color.WHITE);
		btnThemSP.setFont(new Font("Arial", Font.BOLD, 14));
		btnThemSP.setBackground(Color.decode("#00C853"));
		btnThemSP.setOpaque(true);
		
		JButton btnDong = new JButton("Đóng");
		btnDong.setOpaque(true);
		btnDong.setForeground(Color.WHITE);
		btnDong.setFont(new Font("Arial", Font.BOLD, 14));
		btnDong.setBackground(Color.decode("#E53935"));
		btnDong.setBounds(291, 479, 109, 25);
		panel.add(btnDong);
		
		JLabel lbDonViTinh = new JLabel("Đơn vị tính");
		lbDonViTinh.setFont(new Font("Arial", Font.PLAIN, 14));
		lbDonViTinh.setBounds(10, 248, 100, 23);
		panel.add(lbDonViTinh);
		
		txtDonViTinh = new JTextField();
		txtDonViTinh.setColumns(10);
		txtDonViTinh.setBounds(10, 273, 185, 32);
		panel.add(txtDonViTinh);
		
		JLabel lbSoLuong = new JLabel("Số lượng");
		lbSoLuong.setFont(new Font("Arial", Font.PLAIN, 14));
		lbSoLuong.setBounds(10, 328, 122, 23);
		panel.add(lbSoLuong);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(10, 353, 185, 32);
		panel.add(txtSoLuong);
		
		JLabel lbChatLieu = new JLabel("Chất liệu");
		lbChatLieu.setFont(new Font("Arial", Font.PLAIN, 14));
		lbChatLieu.setBounds(234, 248, 122, 23);
		panel.add(lbChatLieu);
		
		txtChatLieu = new JTextField();
		txtChatLieu.setColumns(10);
		txtChatLieu.setBounds(234, 273, 185, 32);
		panel.add(txtChatLieu);
		
		JLabel lbKichThuoc = new JLabel("Kích thước");
		lbKichThuoc.setFont(new Font("Arial", Font.PLAIN, 14));
		lbKichThuoc.setBounds(234, 181, 122, 23);
		panel.add(lbKichThuoc);
		
		txtKieuDang = new JTextField();
		txtKieuDang.setColumns(10);
		txtKieuDang.setBounds(234, 353, 185, 32);
		panel.add(txtKieuDang);
		
		JLabel lbKieuDang = new JLabel("Kiểu dáng");
		lbKieuDang.setFont(new Font("Arial", Font.PLAIN, 14));
		lbKieuDang.setBounds(234, 328, 122, 23);
		panel.add(lbKieuDang);
		
		JLabel lbMoTa = new JLabel("Mô tả");
		lbMoTa.setHorizontalAlignment(SwingConstants.CENTER);
		lbMoTa.setFont(new Font("Arial", Font.PLAIN, 14));
		lbMoTa.setBounds(144, 395, 122, 23);
		panel.add(lbMoTa);
		
		taMoTa = new JTextField();
		taMoTa.setColumns(10);
		taMoTa.setBounds(10, 416, 409, 51);
		panel.add(taMoTa);
		
		JLabel lbMauSac = new JLabel("Màu sắc");
		lbMauSac.setFont(new Font("Arial", Font.PLAIN, 14));
		lbMauSac.setBounds(234, 101, 100, 23);
		panel.add(lbMauSac);
		
		JLabel lbMaLoaiSP = new JLabel("Mã loại sản phẩm");
		lbMaLoaiSP.setFont(new Font("Arial", Font.PLAIN, 14));
		lbMaLoaiSP.setBounds(234, 21, 122, 23);
		panel.add(lbMaLoaiSP);
		
		txtMaLoaiSP = new JTextField();
		txtMaLoaiSP.setColumns(10);
		txtMaLoaiSP.setBounds(234, 46, 185, 32);
		panel.add(txtMaLoaiSP);
		
		JButton btnXoaSP = new JButton("Xóa");
		btnXoaSP.setOpaque(true);
		btnXoaSP.setForeground(Color.WHITE);
		btnXoaSP.setFont(new Font("Arial", Font.BOLD, 14));
		btnXoaSP.setBackground(Color.ORANGE);
		btnXoaSP.setBounds(157, 479, 109, 25);
		panel.add(btnXoaSP);
		
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
		bgMauSac.add(rbDen); bgMauSac.add(rbTrang); bgMauSac.add(rbXam);
		
		JComboBox cboxKichThuoc = new JComboBox();
		cboxKichThuoc.setModel(new DefaultComboBoxModel(new String[] {"39", "40", "41", "42", "43"}));
		cboxKichThuoc.setFont(new Font("Arial", Font.PLAIN, 12));
		cboxKichThuoc.setBounds(234, 208, 100, 30);
		panel.add(cboxKichThuoc);
	}
}
