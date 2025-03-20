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
import javax.swing.JButton;

public class FormThemSP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelMain;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField textField;
	private JTextField txtDonViTinh;
	private JTextField txtMaLoaiSP;
	private JTextField txtSoLuong;

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
		setBounds(100, 100, 550, 372);
		panelMain = new JPanel();
		panelMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(panelMain);
		panelMain.setLayout(null);
		
		JLabel lbHeader = new JLabel("THÊM SẢN  PHẨM");
		lbHeader.setBounds(5, 5, 531, 31);
		lbHeader.setForeground(Color.WHITE);
		lbHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lbHeader.setFont(new Font("Arial", Font.BOLD, 20));

		lbHeader.setBackground(Color.decode("#FF5252"));
		lbHeader.setOpaque(true);
		panelMain.add(lbHeader);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 29, 559, 300);
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 206, 185, 32);
		panel.add(textField);
		
		JLabel lbDonViTinh = new JLabel("Đơn vị tính");
		lbDonViTinh.setFont(new Font("Arial", Font.PLAIN, 14));
		lbDonViTinh.setBounds(277, 21, 100, 23);
		panel.add(lbDonViTinh);
		
		txtDonViTinh = new JTextField();
		txtDonViTinh.setColumns(10);
		txtDonViTinh.setBounds(277, 46, 185, 32);
		panel.add(txtDonViTinh);
		
		JLabel lbMaLoaiSP = new JLabel("Mã loại sản phẩm");
		lbMaLoaiSP.setFont(new Font("Arial", Font.PLAIN, 14));
		lbMaLoaiSP.setBounds(277, 101, 122, 23);
		panel.add(lbMaLoaiSP);
		
		txtMaLoaiSP = new JTextField();
		txtMaLoaiSP.setColumns(10);
		txtMaLoaiSP.setBounds(277, 126, 185, 32);
		panel.add(txtMaLoaiSP);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(277, 206, 185, 32);
		panel.add(txtSoLuong);
		
		JLabel lbSoLuong = new JLabel("Số lượng");
		lbSoLuong.setFont(new Font("Arial", Font.PLAIN, 14));
		lbSoLuong.setBounds(277, 181, 122, 23);
		panel.add(lbSoLuong);
		
		JButton btnThemSP = new JButton("Thêm");
		btnThemSP.setBounds(134, 265, 109, 25);
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
		btnDong.setBounds(290, 265, 109, 25);
		panel.add(btnDong);
	}
}
