package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QLBanGiayGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int DEFAULT_WIDTH = 1300, DEFAULT_HEIGHT= 800;
	private String color = "#FF7043";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLBanGiayGUI frame = new QLBanGiayGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public QLBanGiayGUI()
	{
		initComponents();
	}
	
	/**
	 * Create the frame.
	 */
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pHeader = new JPanel();
		contentPane.add(pHeader, BorderLayout.NORTH);
		pHeader.setLayout(null);
		
		JPanel pMain = new JPanel();
		contentPane.add(pMain, BorderLayout.CENTER);
		pMain.setLayout(new BorderLayout(0, 0));
		
		JPanel pHeaderMain = new JPanel();
		pMain.add(pHeaderMain, BorderLayout.NORTH);
		
		JPanel pNavbar = new JPanel();
		contentPane.add(pNavbar, BorderLayout.WEST);
		pNavbar.setLayout(null);
		pNavbar.setPreferredSize(new Dimension(200, 800));
		pNavbar.setBackground(Color.decode(color));
		
		JPanel pAccount = new JPanel();
		pAccount.setBounds(0, 0, 200, 67);
		pNavbar.add(pAccount);
		pAccount.setBackground(Color.decode(color));
		pAccount.setLayout(null);
		JLabel lbInfo1 = new JLabel("Xin chào");
		lbInfo1.setForeground(Color.WHITE);
		lbInfo1.setBounds(0, 0, 200, 33);
		lbInfo1.setFont(new Font("Verdana", Font.BOLD, 14));
		lbInfo1.setHorizontalAlignment(SwingConstants.CENTER);
		pAccount.add(lbInfo1);
		
		JLabel lbInfo2 = new JLabel("Admin !");
		lbInfo2.setForeground(Color.WHITE);
		lbInfo2.setBounds(0, 24, 200, 33);
		lbInfo2.setFont(new Font("Verdana", Font.BOLD, 14));
		lbInfo2.setHorizontalAlignment(SwingConstants.CENTER);
		pAccount.add(lbInfo2);
		
		JPanel pNavItem = new JPanel();
		pNavItem.setBounds(0, 66, 200, 734);
		pNavItem.setBackground(Color.decode(color));
		pNavbar.add(pNavItem);
		pNavItem.setLayout(null);
		
		JButton btnSanPhamGUI = new JButton("SẢN PHẨM");
		btnSanPhamGUI.setForeground(Color.WHITE);
		btnSanPhamGUI.setHorizontalAlignment(SwingConstants.LEFT);
		btnSanPhamGUI.setFont(new Font("Verdana", Font.BOLD, 14));
		btnSanPhamGUI.setBounds(0, 0, 200, 35);
		btnSanPhamGUI.setBackground(Color.decode(color));
		btnSanPhamGUI.setOpaque(true);
		btnSanPhamGUI.setBorderPainted(false);
		pNavItem.add(btnSanPhamGUI);
		
		JButton btnNhaCungCapGUI = new JButton("NHÀ CUNG CẤP");
		btnNhaCungCapGUI.setForeground(Color.WHITE);
		btnNhaCungCapGUI.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhaCungCapGUI.setFont(new Font("Verdana", Font.BOLD, 14));
		btnNhaCungCapGUI.setBounds(0, 34, 200, 35);
		btnNhaCungCapGUI.setBackground(Color.decode(color));
		btnNhaCungCapGUI.setOpaque(true);
		btnNhaCungCapGUI.setBorderPainted(false);
		pNavItem.add(btnNhaCungCapGUI);
		
		JButton btnNhanVienGUI = new JButton("NHÂN VIÊN");
		btnNhanVienGUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNhanVienGUI.setOpaque(true);
		btnNhanVienGUI.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVienGUI.setForeground(Color.WHITE);
		btnNhanVienGUI.setFont(new Font("Verdana", Font.BOLD, 14));
		btnNhanVienGUI.setBorderPainted(false);
		btnNhanVienGUI.setBackground(new Color(255, 112, 67));
		btnNhanVienGUI.setBounds(0, 69, 200, 35);
		pNavItem.add(btnNhanVienGUI);
		
		JButton btnKhachHangGUI = new JButton("KHÁCH HÀNG");
		btnKhachHangGUI.setOpaque(true);
		btnKhachHangGUI.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHangGUI.setForeground(Color.WHITE);
		btnKhachHangGUI.setFont(new Font("Verdana", Font.BOLD, 14));
		btnKhachHangGUI.setBorderPainted(false);
		btnKhachHangGUI.setBackground(new Color(255, 112, 67));
		btnKhachHangGUI.setBounds(0, 103, 200, 35);
		pNavItem.add(btnKhachHangGUI);
		
		JButton btnPhieuNhapGUI = new JButton("PHIẾU NHẬP");
		btnPhieuNhapGUI.setOpaque(true);
		btnPhieuNhapGUI.setHorizontalAlignment(SwingConstants.LEFT);
		btnPhieuNhapGUI.setForeground(Color.WHITE);
		btnPhieuNhapGUI.setFont(new Font("Verdana", Font.BOLD, 14));
		btnPhieuNhapGUI.setBorderPainted(false);
		btnPhieuNhapGUI.setBackground(new Color(255, 112, 67));
		btnPhieuNhapGUI.setBounds(0, 135, 200, 35);
		pNavItem.add(btnPhieuNhapGUI);
		
		JButton btnPhieuXuat = new JButton("PHIẾU XUẤT");
		btnPhieuXuat.setOpaque(true);
		btnPhieuXuat.setHorizontalAlignment(SwingConstants.LEFT);
		btnPhieuXuat.setForeground(Color.WHITE);
		btnPhieuXuat.setFont(new Font("Verdana", Font.BOLD, 14));
		btnPhieuXuat.setBorderPainted(false);
		btnPhieuXuat.setBackground(new Color(255, 112, 67));
		btnPhieuXuat.setBounds(0, 169, 200, 35);
		pNavItem.add(btnPhieuXuat);
		
		JButton btnKhuyenMaiGUI = new JButton("KHUYẾN MÃI");
		btnKhuyenMaiGUI.setOpaque(true);
		btnKhuyenMaiGUI.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhuyenMaiGUI.setForeground(Color.WHITE);
		btnKhuyenMaiGUI.setFont(new Font("Verdana", Font.BOLD, 14));
		btnKhuyenMaiGUI.setBorderPainted(false);
		btnKhuyenMaiGUI.setBackground(new Color(255, 112, 67));
		btnKhuyenMaiGUI.setBounds(0, 204, 200, 35);
		pNavItem.add(btnKhuyenMaiGUI);
		
		JButton btnDangXuat = new JButton("ĐĂNG XUẤT");
		btnDangXuat.setOpaque(true);
		btnDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
		btnDangXuat.setForeground(Color.WHITE);
		btnDangXuat.setFont(new Font("Verdana", Font.BOLD, 14));
		btnDangXuat.setBorderPainted(false);
		btnDangXuat.setBackground(new Color(255, 112, 67));
		btnDangXuat.setBounds(0, 587, 200, 35);
		pNavItem.add(btnDangXuat);
		
		pHeaderMain.setPreferredSize(new Dimension(DEFAULT_WIDTH, 100));
		
	}

}
