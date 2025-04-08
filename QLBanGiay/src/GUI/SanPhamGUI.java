package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SanPhamGUI extends JPanel {
    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;
    private JTable tblDSSP;
    private JTextField txtMaSP, txtTenSP, txtDonGia, txtSoLuong, txtDonViTinh, txtChatLieu, txtKieuDang;
    private JComboBox<String> cbLoaiSP;
    private JRadioButton rbDen, rbTrang, rbXam;
    private JSpinner spinKichThuoc;

    public SanPhamGUI() {
        Object[] header = {"Mã Sản Phẩm", "Tên Sản Phẩm", "Loại", "Giá", "Số Lượng", "Đơn vị tính"};
        model = new DefaultTableModel(header, 0);
        initComponents();
        loadDataDemo();
    }

    private void loadDataDemo() {
        for (int i = 1; i <= 25; i++) {
            model.addRow(new Object[]{"SP" + i, "Sản phẩm " + i, "Loại " + i, 1000000 * i, 10, "Đôi"});
        }
    }

    private void initComponents() {
        setPreferredSize(new Dimension(1248, 654));
        setLayout(null);
        setBackground(Color.WHITE);

        // Table
        tblDSSP = new JTable(model);
        tblDSSP.setBackground(Color.WHITE);
        tblDSSP.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
        tblDSSP.setFillsViewportHeight(true);
        tblDSSP.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSSP.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        JScrollPane scrollPane = new JScrollPane(tblDSSP);
        scrollPane.setBounds(591, 40, 613, 402); // Điều chỉnh y từ 140 thành 40
        scrollPane.getVerticalScrollBar().setUI(new ModernScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new ModernScrollBarUI());
        add(scrollPane);

        // Form
        JPanel pInput = new JPanel();
        pInput.setBorder(UIManager.getBorder("TextField.border"));
        pInput.setBackground(Color.WHITE);
        pInput.setBounds(48, 40, 502, 402); // Điều chỉnh y từ 140 thành 40
        add(pInput);
        pInput.setLayout(null);

        txtKieuDang = new JTextField();
        txtKieuDang.setFont(new Font("Arial", Font.PLAIN, 13));
        txtKieuDang.setColumns(10);
        txtKieuDang.setBounds(233, 357, 168, 19);
        pInput.add(txtKieuDang);

        JLabel lbMaSP = new JLabel("Mã sản phẩm");
        lbMaSP.setFont(new Font("Arial", Font.PLAIN, 14));
        lbMaSP.setBounds(10, 65, 112, 17);
        pInput.add(lbMaSP);

        txtMaSP = new JTextField();
        txtMaSP.setFont(new Font("Arial", Font.PLAIN, 13));
        txtMaSP.setColumns(10);
        txtMaSP.setBounds(10, 91, 168, 19);
        pInput.add(txtMaSP);

        JLabel lbLoaiSP = new JLabel("Loại sản phẩm");
        lbLoaiSP.setFont(new Font("Arial", Font.PLAIN, 14));
        lbLoaiSP.setBounds(233, 65, 112, 17);
        pInput.add(lbLoaiSP);

        JLabel lbTenSP = new JLabel("Tên sản phẩm");
        lbTenSP.setFont(new Font("Arial", Font.PLAIN, 14));
        lbTenSP.setBounds(10, 133, 112, 17);
        pInput.add(lbTenSP);

        txtTenSP = new JTextField();
        txtTenSP.setFont(new Font("Arial", Font.PLAIN, 13));
        txtTenSP.setColumns(10);
        txtTenSP.setBounds(10, 159, 168, 19);
        pInput.add(txtTenSP);

        JLabel lbMauSac = new JLabel("Màu sắc");
        lbMauSac.setFont(new Font("Arial", Font.PLAIN, 14));
        lbMauSac.setBounds(233, 133, 112, 17);
        pInput.add(lbMauSac);

        rbDen = new JRadioButton("Đen");
        rbDen.setFont(new Font("Arial", Font.PLAIN, 13));
        rbDen.setBackground(Color.WHITE);
        rbDen.setBounds(228, 158, 62, 21);
        pInput.add(rbDen);

        rbTrang = new JRadioButton("Trắng");
        rbTrang.setFont(new Font("Arial", Font.PLAIN, 13));
        rbTrang.setBackground(Color.WHITE);
        rbTrang.setBounds(306, 158, 62, 21);
        pInput.add(rbTrang);

        rbXam = new JRadioButton("Xám");
        rbXam.setFont(new Font("Arial", Font.PLAIN, 13));
        rbXam.setBackground(Color.WHITE);
        rbXam.setBounds(388, 158, 62, 21);
        pInput.add(rbXam);

        ButtonGroup bgMauSac = new ButtonGroup();
        bgMauSac.add(rbDen);
        bgMauSac.add(rbTrang);
        bgMauSac.add(rbXam);

        JLabel lbDonGia = new JLabel("Đơn giá");
        lbDonGia.setFont(new Font("Arial", Font.PLAIN, 14));
        lbDonGia.setBounds(10, 198, 112, 17);
        pInput.add(lbDonGia);

        txtDonGia = new JTextField();
        txtDonGia.setFont(new Font("Arial", Font.PLAIN, 13));
        txtDonGia.setColumns(10);
        txtDonGia.setBounds(10, 224, 168, 19);
        pInput.add(txtDonGia);

        JLabel lbKichThuoc = new JLabel("Kích thước");
        lbKichThuoc.setFont(new Font("Arial", Font.PLAIN, 14));
        lbKichThuoc.setBounds(233, 201, 112, 17);
        pInput.add(lbKichThuoc);

        cbLoaiSP = new JComboBox<>();
        cbLoaiSP.setFont(new Font("Arial", Font.PLAIN, 13));
        cbLoaiSP.setBounds(233, 91, 133, 21);
        cbLoaiSP.setBackground(Color.WHITE);
        cbLoaiSP.setForeground(Color.BLACK);
        cbLoaiSP.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        pInput.add(cbLoaiSP);

        String[] listLoaiSP = {"Giày boots", "Giày sneakers", "Giày sandals"};
        for (String loai : listLoaiSP) {
            cbLoaiSP.addItem(loai);
        }

        JLabel lbSoLuong = new JLabel("Số lượng");
        lbSoLuong.setFont(new Font("Arial", Font.PLAIN, 14));
        lbSoLuong.setBounds(10, 265, 112, 17);
        pInput.add(lbSoLuong);

        txtSoLuong = new JTextField();
        txtSoLuong.setFont(new Font("Arial", Font.PLAIN, 13));
        txtSoLuong.setColumns(10);
        txtSoLuong.setBounds(10, 291, 168, 19);
        pInput.add(txtSoLuong);

        JLabel lbChatLieu = new JLabel("Chất liệu");
        lbChatLieu.setFont(new Font("Arial", Font.PLAIN, 14));
        lbChatLieu.setBounds(233, 265, 112, 17);
        pInput.add(lbChatLieu);

        txtChatLieu = new JTextField();
        txtChatLieu.setFont(new Font("Arial", Font.PLAIN, 13));
        txtChatLieu.setColumns(10);
        txtChatLieu.setBounds(233, 291, 168, 19);
        pInput.add(txtChatLieu);

        JLabel lbDonViTinh = new JLabel("Đơn vị tính");
        lbDonViTinh.setFont(new Font("Arial", Font.PLAIN, 14));
        lbDonViTinh.setBounds(10, 331, 112, 17);
        pInput.add(lbDonViTinh);

        txtDonViTinh = new JTextField();
        txtDonViTinh.setFont(new Font("Arial", Font.PLAIN, 13));
        txtDonViTinh.setColumns(10);
        txtDonViTinh.setBounds(10, 357, 168, 19);
        pInput.add(txtDonViTinh);

        JLabel lbKieuDang = new JLabel("Kiểu dáng");
        lbKieuDang.setFont(new Font("Arial", Font.PLAIN, 14));
        lbKieuDang.setBounds(233, 331, 112, 17);
        pInput.add(lbKieuDang);

        JLabel lbHeaderSP = new JLabel("THÔNG TIN SẢN PHẨM");
        lbHeaderSP.setHorizontalAlignment(SwingConstants.CENTER);
        lbHeaderSP.setFont(new Font("Arial", Font.BOLD, 15));
        lbHeaderSP.setBackground(Color.decode("#00C853"));
        lbHeaderSP.setOpaque(true);
        lbHeaderSP.setBounds(0, 0, 502, 45);
        pInput.add(lbHeaderSP);

        spinKichThuoc = new JSpinner(new SpinnerNumberModel(38, 38, 43, 1));
        spinKichThuoc.setFont(new Font("Arial", Font.PLAIN, 13));
        spinKichThuoc.setBounds(233, 224, 62, 20);
        pInput.add(spinKichThuoc);

        JButton btnLoaiSP = new JButton("");
        btnLoaiSP.setBorder(null);
        btnLoaiSP.setBackground(null);
        btnLoaiSP.setFocusPainted(false);
        btnLoaiSP.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/more30.png")));
        btnLoaiSP.setFont(new Font("Arial", Font.PLAIN, 13));
        btnLoaiSP.setBounds(331, 64, 47, 18);
        btnLoaiSP.addActionListener(e -> openLoaiSPDialog());
        pInput.add(btnLoaiSP);
    }

    public void addProduct() {
        // Implement logic here
    }

    public void updateProduct() {
        // Implement logic here
    }

    public void deleteProduct() {
        int i = tblDSSP.getSelectedRow();
        if (i >= 0) {
            String maSP = tblDSSP.getValueAt(i, 0).toString();
            String tenSP = tblDSSP.getValueAt(i, 1).toString();
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Bạn có chắc muốn xóa sản phẩm " + tenSP + " có mã " + maSP + " không?",
                    "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                model.removeRow(i);
                JOptionPane.showMessageDialog(this, "Xóa sản phẩm " + tenSP + " thành công",
                        "Thành công", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để xóa",
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openLoaiSPDialog() {
        JDialog dialog = new JDialog(SwingUtilities.getWindowAncestor(this), "Quản lý loại sản phẩm");
        dialog.setSize(500, 400);
        dialog.setLocationRelativeTo(null);
        dialog.getContentPane().setLayout(null);

        JLabel lbTitle = new JLabel("QUẢN LÝ LOẠI SẢN PHẨM", SwingConstants.CENTER);
        lbTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lbTitle.setBounds(0, 10, 500, 30);
        dialog.getContentPane().add(lbTitle);

        DefaultTableModel modelLoai = new DefaultTableModel(new String[]{"Mã loại", "Tên loại"}, 0);
        JTable tblLoai = new JTable(modelLoai);
        tblLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        tblLoai.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        JScrollPane scrollLoai = new JScrollPane(tblLoai);
        scrollLoai.setBounds(10, 50, 480, 200);
        dialog.getContentPane().add(scrollLoai);

        JLabel lbMaLoai = new JLabel("Mã loại:");
        lbMaLoai.setFont(new Font("Arial", Font.PLAIN, 14));
        lbMaLoai.setBounds(10, 260, 80, 25);
        dialog.getContentPane().add(lbMaLoai);

        JTextField txtMaLoai = new JTextField();
        txtMaLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        txtMaLoai.setBounds(90, 260, 100, 25);
        txtMaLoai.setEditable(false);
        dialog.getContentPane().add(txtMaLoai);

        JLabel lbTenLoai = new JLabel("Tên loại:");
        lbTenLoai.setFont(new Font("Arial", Font.PLAIN, 14));
        lbTenLoai.setBounds(210, 260, 71, 25);
        dialog.getContentPane().add(lbTenLoai);

        JTextField txtTenLoai = new JTextField();
        txtTenLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        txtTenLoai.setBounds(280, 260, 200, 25);
        dialog.getContentPane().add(txtTenLoai);

        JButton btnThemLoai = new JButton("Thêm", new ImageIcon(getClass().getResource("/image/add20.png")));
        btnThemLoai.setForeground(Color.WHITE);
        btnThemLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        btnThemLoai.setBackground(Color.decode("#4CAF50"));
        btnThemLoai.setBounds(56, 300, 120, 30);
        dialog.getContentPane().add(btnThemLoai);

        JButton btnSuaLoai = new JButton("Cập nhật", new ImageIcon(getClass().getResource("/image/edit20.png")));
        btnSuaLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        btnSuaLoai.setForeground(Color.WHITE);
        btnSuaLoai.setBackground(Color.decode("#7986CB"));
        btnSuaLoai.setBounds(199, 300, 120, 30);
        dialog.getContentPane().add(btnSuaLoai);

        JButton btnXoaLoai = new JButton("Xóa", new ImageIcon(getClass().getResource("/image/remove20.png")));
        btnXoaLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        btnXoaLoai.setForeground(Color.WHITE);
        btnXoaLoai.setBackground(Color.decode("#FF7043"));
        btnXoaLoai.setBounds(338, 300, 120, 30);
        dialog.getContentPane().add(btnXoaLoai);

        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test SanPhamGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1248, 654);
        frame.getContentPane().add(new SanPhamGUI());
        frame.setVisible(true);
    }
}