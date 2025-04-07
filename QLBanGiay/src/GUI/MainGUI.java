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

public class MainGUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int DEFAULT_WIDTH = 1450, DEFAULT_HEIGHT = 800;
    private String color = "#FF5252";
    private DefaultTableModel model;
    private JComboBox<String> cbLoaiSP;
    private JRadioButton rbDen, rbTrang, rbXam;
    private JSpinner spinKichThuoc;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainGUI frame = new MainGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainGUI() {
        Object[] header = {"Mã Sản Phẩm", "Tên Sản Phẩm", "Loại", "Giá", "Số Lượng", "Đơn vị tính"};
        model = new DefaultTableModel(header, 0);
        initComponents();
        loadDataDemo(); 
    }
    
    private void loadDataDemo() {
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
        lbInfo1.setIcon(new ImageIcon(MainGUI.class.getResource("/image/userIcon.png")));
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
        btnDangXuat.setIcon(new ImageIcon(MainGUI.class.getResource("/image/logoutIcon.png")));
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
        btnTrangChuGUI.setIcon(new ImageIcon(MainGUI.class.getResource("/image/homeIcon.png")));
        btnTrangChuGUI.setOpaque(true);
        btnTrangChuGUI.setHorizontalAlignment(SwingConstants.LEFT);
        btnTrangChuGUI.setForeground(Color.WHITE);
        btnTrangChuGUI.setFont(new Font("Verdana", Font.BOLD, 14));
        btnTrangChuGUI.setBorderPainted(false);
        btnTrangChuGUI.setBackground(Color.decode(color));
        btnTrangChuGUI.setBounds(20, 13, 200, 35);
        pNavItem.add(btnTrangChuGUI);

        JButton btnSanPhamGUI = new JButton("SẢN PHẨM");
        btnSanPhamGUI.setIcon(new ImageIcon(MainGUI.class.getResource("/image/productIcon.png")));
        btnSanPhamGUI.setOpaque(true);
        btnSanPhamGUI.setHorizontalAlignment(SwingConstants.LEFT);
        btnSanPhamGUI.setForeground(Color.WHITE);
        btnSanPhamGUI.setFont(new Font("Verdana", Font.BOLD, 14));
        btnSanPhamGUI.setBorderPainted(false);
        btnSanPhamGUI.setBackground(Color.decode(color));
        btnSanPhamGUI.setBounds(20, 49, 200, 35);
        pNavItem.add(btnSanPhamGUI);

        JButton btnNhaCungCapGUI = new JButton("NHÀ CUNG CẤP");
        btnNhaCungCapGUI.setIcon(new ImageIcon(MainGUI.class.getResource("/image/providerIcon.png")));
        btnNhaCungCapGUI.setOpaque(true);
        btnNhaCungCapGUI.setHorizontalAlignment(SwingConstants.LEFT);
        btnNhaCungCapGUI.setForeground(Color.WHITE);
        btnNhaCungCapGUI.setFont(new Font("Verdana", Font.BOLD, 14));
        btnNhaCungCapGUI.setBorderPainted(false);
        btnNhaCungCapGUI.setBackground(Color.decode(color));
        btnNhaCungCapGUI.setBounds(20, 85, 200, 35);
        pNavItem.add(btnNhaCungCapGUI);

        JButton btnNhanVienGUI = new JButton("NHÂN VIÊN");
        btnNhanVienGUI.setIcon(new ImageIcon(MainGUI.class.getResource("/image/employeeIcon.png")));
        btnNhanVienGUI.setOpaque(true);
        btnNhanVienGUI.setHorizontalAlignment(SwingConstants.LEFT);
        btnNhanVienGUI.setForeground(Color.WHITE);
        btnNhanVienGUI.setFont(new Font("Verdana", Font.BOLD, 14));
        btnNhanVienGUI.setBorderPainted(false);
        btnNhanVienGUI.setBackground(Color.decode(color));
        btnNhanVienGUI.setBounds(20, 121, 200, 35);
        pNavItem.add(btnNhanVienGUI);

        JButton btnKhachHangGUI = new JButton("KHÁCH HÀNG");
        btnKhachHangGUI.setIcon(new ImageIcon(MainGUI.class.getResource("/image/clientIcon.png")));
        btnKhachHangGUI.setOpaque(true);
        btnKhachHangGUI.setHorizontalAlignment(SwingConstants.LEFT);
        btnKhachHangGUI.setForeground(Color.WHITE);
        btnKhachHangGUI.setFont(new Font("Verdana", Font.BOLD, 14));
        btnKhachHangGUI.setBorderPainted(false);
        btnKhachHangGUI.setBackground(Color.decode(color));
        btnKhachHangGUI.setBounds(20, 157, 200, 35);
        pNavItem.add(btnKhachHangGUI);

        JButton btnPhieuNhapGUI = new JButton("PHIẾU NHẬP");
        btnPhieuNhapGUI.setIcon(new ImageIcon(MainGUI.class.getResource("/image/phieuNhap.png")));
        btnPhieuNhapGUI.setOpaque(true);
        btnPhieuNhapGUI.setHorizontalAlignment(SwingConstants.LEFT);
        btnPhieuNhapGUI.setForeground(Color.WHITE);
        btnPhieuNhapGUI.setFont(new Font("Verdana", Font.BOLD, 14));
        btnPhieuNhapGUI.setBorderPainted(false);
        btnPhieuNhapGUI.setBackground(Color.decode(color));
        btnPhieuNhapGUI.setBounds(20, 193, 200, 35);
        pNavItem.add(btnPhieuNhapGUI);

        JButton btnPhieuXuat = new JButton("PHIẾU XUẤT");
        btnPhieuXuat.setIcon(new ImageIcon(MainGUI.class.getResource("/image/phieuXuat.png")));
        btnPhieuXuat.setOpaque(true);
        btnPhieuXuat.setHorizontalAlignment(SwingConstants.LEFT);
        btnPhieuXuat.setForeground(Color.WHITE);
        btnPhieuXuat.setFont(new Font("Verdana", Font.BOLD, 14));
        btnPhieuXuat.setBorderPainted(false);
        btnPhieuXuat.setBackground(Color.decode(color));
        btnPhieuXuat.setBounds(20, 229, 200, 35);
        pNavItem.add(btnPhieuXuat);

        JButton btnKhuyenMaiGUI = new JButton("KHUYẾN MÃI");
        btnKhuyenMaiGUI.setIcon(new ImageIcon(MainGUI.class.getResource("/image/saleIcon.png")));
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
        
        JPanel pContent = new JPanel();
        pContent.setBackground(Color.white);
        pContent.setBounds(0, 103, 1248, 654); // Đặt bên dưới pHeaderMain
        pContent.setLayout(null);
        pMain.add(pContent);
        
    
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


    
   
    
    
  
    
    
}