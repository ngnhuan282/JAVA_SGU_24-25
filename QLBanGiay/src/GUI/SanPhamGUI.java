package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import BUS.SanPhamBUS;
import DTO.SanPhamDTO;

public class SanPhamGUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int DEFAULT_WIDTH = 1200, DEFAULT_HEIGHT = 800;
    private String color = "#FF5252";
    private JTable table;
    private DefaultTableModel model;
    private SanPhamBUS spBUS = new SanPhamBUS();

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
        Object[] header = {"Mã Sản Phẩm", "Tên Sản Phẩm", "Loại", "Giá", "Số Lượng"};
        model = new DefaultTableModel(header, 0);
        table = new JTable(model);
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

        pHeaderMain.setPreferredSize(new Dimension(DEFAULT_WIDTH, 100));
        pHeaderMain.setLayout(null);

        JPanel pLeftHeader = new JPanel();
        pLeftHeader.setBackground(Color.WHITE);
        pLeftHeader.setBounds(0, 0, 539, 100);
        pHeaderMain.add(pLeftHeader);
        pLeftHeader.setLayout(null);

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

        // Gắn table vào scrollPane ngay từ đầu
        table.setFont(new Font("Verdana", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 100, 987, 700);
        pMain.add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Thêm":
                openAddProductGUI();
                break;
            case "Sửa":
                break;
            default:
                break;
        }
    }

    public void openAddProductGUI() {
        JDialog addProductDialog = new JDialog(this, "Thêm Sản Phẩm", true);
        addProductDialog.setBounds(100, 100, 550, 372);
        addProductDialog.setLocationRelativeTo(this);

        JPanel panelMain = new JPanel();
        panelMain.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelMain.setLayout(null);

        JLabel lbHeader = new JLabel("THÊM SẢN PHẨM");
        lbHeader.setBounds(5, 5, 531, 31);
        lbHeader.setForeground(Color.WHITE);
        lbHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lbHeader.setFont(new Font("Arial", Font.BOLD, 20));
        lbHeader.setBackground(Color.decode("#FF5252"));
        lbHeader.setOpaque(true);
        panelMain.add(lbHeader);

        JPanel panel = new JPanel();
        panel.setBounds(5, 36, 531, 300);
        panel.setLayout(null);

        JLabel lbMaSP = new JLabel("Mã sản phẩm");
        lbMaSP.setFont(new Font("Arial", Font.PLAIN, 14));
        lbMaSP.setBounds(10, 21, 100, 23);
        panel.add(lbMaSP);

        JTextField txtMaSP = new JTextField();
        txtMaSP.setBounds(10, 46, 185, 32);
        panel.add(txtMaSP);

        JLabel lbTenSP = new JLabel("Tên sản phẩm");
        lbTenSP.setFont(new Font("Arial", Font.PLAIN, 14));
        lbTenSP.setBounds(10, 101, 100, 23);
        panel.add(lbTenSP);

        JTextField txtTenSP = new JTextField();
        txtTenSP.setBounds(10, 126, 185, 32);
        panel.add(txtTenSP);

        JLabel lbDonGia = new JLabel("Đơn giá");
        lbDonGia.setFont(new Font("Arial", Font.PLAIN, 14));
        lbDonGia.setBounds(10, 181, 100, 23);
        panel.add(lbDonGia);

        JTextField txtDonGia = new JTextField();
        txtDonGia.setBounds(10, 206, 185, 32);
        panel.add(txtDonGia);

        JLabel lbDonViTinh = new JLabel("Đơn vị tính");
        lbDonViTinh.setFont(new Font("Arial", Font.PLAIN, 14));
        lbDonViTinh.setBounds(277, 21, 100, 23);
        panel.add(lbDonViTinh);

        JTextField txtDonViTinh = new JTextField();
        txtDonViTinh.setBounds(277, 46, 185, 32);
        panel.add(txtDonViTinh);

        JLabel lbMaLoaiSP = new JLabel("Mã loại sản phẩm");
        lbMaLoaiSP.setFont(new Font("Arial", Font.PLAIN, 14));
        lbMaLoaiSP.setBounds(277, 101, 122, 23);
        panel.add(lbMaLoaiSP);

        JTextField txtMaLoaiSP = new JTextField();
        txtMaLoaiSP.setBounds(277, 126, 185, 32);
        panel.add(txtMaLoaiSP);

        JLabel lbSoLuong = new JLabel("Số lượng");
        lbSoLuong.setFont(new Font("Arial", Font.PLAIN, 14));
        lbSoLuong.setBounds(277, 181, 122, 23);
        panel.add(lbSoLuong);

        JTextField txtSoLuong = new JTextField();
        txtSoLuong.setBounds(277, 206, 185, 32);
        panel.add(txtSoLuong);

        JButton btnThemSP = new JButton("Thêm");
        btnThemSP.setBounds(134, 265, 109, 25);
        btnThemSP.setForeground(Color.WHITE);
        btnThemSP.setFont(new Font("Arial", Font.BOLD, 14));
        btnThemSP.setBackground(Color.decode("#00C853"));
        btnThemSP.setOpaque(true);
        panel.add(btnThemSP);

        JButton btnDong = new JButton("Đóng");
        btnDong.setOpaque(true);
        btnDong.setForeground(Color.WHITE);
        btnDong.setFont(new Font("Arial", Font.BOLD, 14));
        btnDong.setBackground(Color.decode("#E53935"));
        btnDong.setBounds(290, 265, 109, 25);
        panel.add(btnDong);

        panelMain.add(panel);
        addProductDialog.getContentPane().add(panelMain);

        btnThemSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String maSPText = txtMaSP.getText().trim();
                    String tenSP = txtTenSP.getText().trim();
                    String soLuongText = txtSoLuong.getText().trim();
                    String donGiaText = txtDonGia.getText().trim();
                    String donViTinh = txtDonViTinh.getText().trim();
                    String maLoaiSP = txtMaLoaiSP.getText().trim();

                    if (maSPText.isEmpty() || tenSP.isEmpty() || soLuongText.isEmpty() ||
                        donGiaText.isEmpty() || donViTinh.isEmpty() || maLoaiSP.isEmpty()) {
                        JOptionPane.showMessageDialog(addProductDialog,
                            "Vui lòng điền đầy đủ tất cả các thông tin",
                            "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    int maSP = Integer.parseInt(maSPText);
                    int soLuong = Integer.parseInt(soLuongText);
                    double donGia = Double.parseDouble(donGiaText);
//
//                    if (maSP <= 0) {
//                        JOptionPane.showMessageDialog(addProductDialog,
//                            "Mã sản phẩm phải lớn hơn 0!",
//                            "Lỗi", JOptionPane.ERROR_MESSAGE);
//                        return;
//                    }
//                    if (soLuong < 0) {
//                        JOptionPane.showMessageDialog(addProductDialog,
//                            "Số lượng không được âm!",
//                            "Lỗi", JOptionPane.ERROR_MESSAGE);
//                        return;
//                    }
//                    if (donGia <= 0) {
//                        JOptionPane.showMessageDialog(addProductDialog,
//                            "Đơn giá phải lớn hơn 0!",
//                            "Lỗi", JOptionPane.ERROR_MESSAGE);
//                        return;
//                    }

                    SanPhamDTO sp = new SanPhamDTO(maLoaiSP, tenSP, donViTinh, maSP, soLuong, donGia);
                    spBUS.addSP(sp);

                    Object[] row = {maSP, tenSP, maLoaiSP, donGia, soLuong};
                    model.addRow(row); // Thêm dòng mới vào model

                    JOptionPane.showMessageDialog(addProductDialog,
                        "Thêm sản phẩm thành công!",
                        "Thành công", JOptionPane.INFORMATION_MESSAGE);

                    txtMaSP.setText("");
                    txtTenSP.setText("");
                    txtSoLuong.setText("");
                    txtDonGia.setText("");
                    txtDonViTinh.setText("");
                    txtMaLoaiSP.setText("");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(addProductDialog,
                        "Vui lòng nhập đúng định dạng số cho Mã SP, Số lượng và Đơn giá!",
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(addProductDialog,
                        "Đã xảy ra lỗi: " + ex.getMessage(),
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnDong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProductDialog.dispose();
            }
        });

        addProductDialog.setVisible(true);
    }
}