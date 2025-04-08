package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.LoaiBUS;
import DTO.LoaiDTO;

public class SanPhamGUI extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;
    private JTable tblDSSP;
    private JTextField txtSearch;
    private JTextField txtMaSP, txtTenSP, txtDonGia, txtSoLuong, txtDonViTinh, txtChatLieu, txtKieuDang;
    private JComboBox<String> cbLoaiSP;
    private JRadioButton rbDen, rbTrang, rbXam;
    private JSpinner spinKichThuoc;
    private JButton btnEditMode;
    private LoaiBUS loaiBUS;
    private boolean isEditMode = false; // Trạng thái chỉnh sửa

    public SanPhamGUI() {
        Object[] header = {"Mã Sản Phẩm", "Tên Sản Phẩm", "Loại", "Giá", "Số Lượng", "Đơn vị tính"};
        model = new DefaultTableModel(header, 0);
        loaiBUS = new LoaiBUS();
        loaiBUS.docDSLoai();
        initComponents();
        loadDataDemo();
        loadLoaiSPToComboBox();
    }

    public void loadDataDemo() {
        for (int i = 1; i <= 25; i++) {
            model.addRow(new Object[]{"SP" + i, "Sản phẩm " + i, "Loại " + i, 1000000 * i, 10, "Đôi"});
        }
    }

    public void loadLoaiSPToComboBox() {
        cbLoaiSP.removeAllItems();
        if (loaiBUS.getDsloai() != null) {
            for (LoaiDTO loai : loaiBUS.getDsloai()) {
                cbLoaiSP.addItem(loai.getTenLoaiSP());
            }
        }
    }

    public void initComponents() {
        setPreferredSize(new Dimension(1248, 757));
        setLayout(null);
        setBackground(Color.WHITE);

        // Header
        JPanel pHeaderMain = new JPanel();
        pHeaderMain.setBounds(0, 0, 1206, 100);
        pHeaderMain.setBackground(Color.WHITE);
        pHeaderMain.setLayout(null);
        add(pHeaderMain);

        JPanel pLeftHeader = new JPanel();
        pLeftHeader.setBorder(new TitledBorder(null, "Chức năng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pLeftHeader.setBackground(Color.WHITE);
        pLeftHeader.setBounds(2, 0, 512, 100);
        pHeaderMain.add(pLeftHeader);
        pLeftHeader.setLayout(null);

        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.setBorder(UIManager.getBorder("Button.border"));
        horizontalBox.setBounds(0, 0, 512, 111);
        pLeftHeader.add(horizontalBox);

        JButton btnThem = new JButton("Thêm");
        horizontalBox.add(btnThem);
        btnThem.setFocusPainted(false);
        btnThem.setActionCommand("Thêm");
        btnThem.addActionListener(this);
        btnThem.setBackground(Color.WHITE);
        btnThem.setBorderPainted(false);
        btnThem.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/add48.png")));
        btnThem.setFont(new Font("Arial", Font.PLAIN, 15));
        btnThem.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnThem.setHorizontalTextPosition(SwingConstants.CENTER);
        btnThem.setPreferredSize(new Dimension(120, 140));

        JButton btnSua = new JButton("Sửa");
        horizontalBox.add(btnSua);
        btnSua.setFocusPainted(false);
        btnSua.setActionCommand("Sửa");
        btnSua.addActionListener(this);
        btnSua.setBorderPainted(false);
        btnSua.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnSua.setPreferredSize(new Dimension(120, 140));
        btnSua.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/edit48.png")));
        btnSua.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSua.setFont(new Font("Arial", Font.PLAIN, 15));
        btnSua.setBackground(Color.WHITE);

        JButton btnXoa = new JButton("Xóa");
        horizontalBox.add(btnXoa);
        btnXoa.setFocusPainted(false);
        btnXoa.setActionCommand("Xóa");
        btnXoa.addActionListener(this);
        btnXoa.setBorderPainted(false);
        btnXoa.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnXoa.setPreferredSize(new Dimension(120, 140));
        btnXoa.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/remove48.png")));
        btnXoa.setHorizontalTextPosition(SwingConstants.CENTER);
        btnXoa.setFont(new Font("Arial", Font.PLAIN, 15));
        btnXoa.setBackground(Color.WHITE);

        JButton btnXuatExcel = new JButton("Xuất Excel");
        horizontalBox.add(btnXuatExcel);
        btnXuatExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnXuatExcel.setPreferredSize(new Dimension(120, 140));
        btnXuatExcel.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/excel48.png")));
        btnXuatExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnXuatExcel.setFont(new Font("Arial", Font.PLAIN, 15));
        btnXuatExcel.setBorderPainted(false);
        btnXuatExcel.setBackground(Color.WHITE);

        JButton btnNhapExcel = new JButton("Nhập Excel");
        horizontalBox.add(btnNhapExcel);
        btnNhapExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNhapExcel.setPreferredSize(new Dimension(120, 140));
        btnNhapExcel.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/bill48.png")));
        btnNhapExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNhapExcel.setFont(new Font("Arial", Font.PLAIN, 15));
        btnNhapExcel.setBorderPainted(false);
        btnNhapExcel.setBackground(Color.WHITE);

        txtSearch = new JTextField();
        txtSearch.setBounds(771, 31, 290, 27);
        pHeaderMain.add(txtSearch);
        txtSearch.setColumns(10);

        JComboBox<String> cboxSearch = new JComboBox<>();
        cboxSearch.setFont(new Font("Arial", Font.PLAIN, 14));
        cboxSearch.setBounds(682, 30, 79, 28);
        cboxSearch.setBackground(Color.WHITE);
        cboxSearch.setForeground(Color.BLACK);
        cboxSearch.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        pHeaderMain.add(cboxSearch);

        JButton btnSearch = new JButton("");
        btnSearch.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/search30.png")));
        btnSearch.setBounds(1071, 22, 66, 39);
        pHeaderMain.add(btnSearch);

        // Table
        tblDSSP = new JTable(model);
        tblDSSP.setBackground(Color.WHITE);
        tblDSSP.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
        tblDSSP.setFillsViewportHeight(true);
        tblDSSP.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSSP.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        JScrollPane scrollPane = new JScrollPane(tblDSSP);
        scrollPane.setBounds(591, 140, 613, 402);
        scrollPane.getVerticalScrollBar().setUI(new ModernScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new ModernScrollBarUI());
        add(scrollPane);

        // Form
        JPanel pInput = new JPanel();
        pInput.setBorder(UIManager.getBorder("TextField.border"));
        pInput.setBackground(Color.WHITE);
        pInput.setBounds(48, 140, 502, 402);
        add(pInput);
        pInput.setLayout(null);

        txtKieuDang = new JTextField();
        txtKieuDang.setFont(new Font("Arial", Font.PLAIN, 13));
        txtKieuDang.setColumns(10);
        txtKieuDang.setBounds(233, 357, 168, 19);
        txtKieuDang.setEditable(false); // Ban đầu không cho chỉnh sửa
        pInput.add(txtKieuDang);

        JLabel lbMaSP = new JLabel("Mã sản phẩm");
        lbMaSP.setFont(new Font("Arial", Font.PLAIN, 14));
        lbMaSP.setBounds(10, 65, 112, 17);
        pInput.add(lbMaSP);

        txtMaSP = new JTextField();
        txtMaSP.setFont(new Font("Arial", Font.PLAIN, 13));
        txtMaSP.setColumns(10);
        txtMaSP.setBounds(10, 91, 168, 19);
        txtMaSP.setEditable(false); // Ban đầu không cho chỉnh sửa
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
        txtTenSP.setEditable(false); // Ban đầu không cho chỉnh sửa
        pInput.add(txtTenSP);

        JLabel lbMauSac = new JLabel("Màu sắc");
        lbMauSac.setFont(new Font("Arial", Font.PLAIN, 14));
        lbMauSac.setBounds(233, 133, 112, 17);
        pInput.add(lbMauSac);

        rbDen = new JRadioButton("Đen");
        rbDen.setFont(new Font("Arial", Font.PLAIN, 13));
        rbDen.setBackground(Color.WHITE);
        rbDen.setBounds(228, 158, 62, 21);
        rbDen.setEnabled(false); // Ban đầu không cho chọn
        pInput.add(rbDen);

        rbTrang = new JRadioButton("Trắng");
        rbTrang.setFont(new Font("Arial", Font.PLAIN, 13));
        rbTrang.setBackground(Color.WHITE);
        rbTrang.setBounds(306, 158, 62, 21);
        rbTrang.setEnabled(false); // Ban đầu không cho chọn
        pInput.add(rbTrang);

        rbXam = new JRadioButton("Xám");
        rbXam.setFont(new Font("Arial", Font.PLAIN, 13));
        rbXam.setBackground(Color.WHITE);
        rbXam.setBounds(388, 158, 62, 21);
        rbXam.setEnabled(false); // Ban đầu không cho chọn
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
        txtDonGia.setEditable(false); // Ban đầu không cho chỉnh sửa
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
        cbLoaiSP.setEnabled(false); // Ban đầu không cho chọn
        pInput.add(cbLoaiSP);

        JLabel lbSoLuong = new JLabel("Số lượng");
        lbSoLuong.setFont(new Font("Arial", Font.PLAIN, 14));
        lbSoLuong.setBounds(10, 265, 112, 17);
        pInput.add(lbSoLuong);

        txtSoLuong = new JTextField();
        txtSoLuong.setFont(new Font("Arial", Font.PLAIN, 13));
        txtSoLuong.setColumns(10);
        txtSoLuong.setBounds(10, 291, 168, 19);
        txtSoLuong.setEditable(false); // Ban đầu không cho chỉnh sửa
        pInput.add(txtSoLuong);

        JLabel lbChatLieu = new JLabel("Chất liệu");
        lbChatLieu.setFont(new Font("Arial", Font.PLAIN, 14));
        lbChatLieu.setBounds(233, 265, 112, 17);
        pInput.add(lbChatLieu);

        txtChatLieu = new JTextField();
        txtChatLieu.setFont(new Font("Arial", Font.PLAIN, 13));
        txtChatLieu.setColumns(10);
        txtChatLieu.setBounds(233, 291, 168, 19);
        txtChatLieu.setEditable(false); // Ban đầu không cho chỉnh sửa
        pInput.add(txtChatLieu);

        JLabel lbDonViTinh = new JLabel("Đơn vị tính");
        lbDonViTinh.setFont(new Font("Arial", Font.PLAIN, 14));
        lbDonViTinh.setBounds(10, 331, 112, 17);
        pInput.add(lbDonViTinh);

        txtDonViTinh = new JTextField();
        txtDonViTinh.setFont(new Font("Arial", Font.PLAIN, 13));
        txtDonViTinh.setColumns(10);
        txtDonViTinh.setBounds(10, 357, 168, 19);
        txtDonViTinh.setEditable(false); // Ban đầu không cho chỉnh sửa
        pInput.add(txtDonViTinh);

        JLabel lbKieuDang = new JLabel("Kiểu dáng");
        lbKieuDang.setFont(new Font("Arial", Font.PLAIN, 14));
        lbKieuDang.setBounds(233, 331, 112, 17);
        pInput.add(lbKieuDang);

        JLabel lbHeaderSP = new JLabel("THÔNG TIN SẢN PHẨM");
        lbHeaderSP.setForeground(Color.WHITE);
        lbHeaderSP.setHorizontalAlignment(SwingConstants.CENTER);
        lbHeaderSP.setFont(new Font("Arial", Font.BOLD, 15));
        lbHeaderSP.setBackground(Color.decode("#FF5252"));
        lbHeaderSP.setOpaque(true);
        lbHeaderSP.setBounds(0, 0, 502, 45);
        pInput.add(lbHeaderSP);

        spinKichThuoc = new JSpinner(new SpinnerNumberModel(38, 38, 43, 1));
        spinKichThuoc.setFont(new Font("Arial", Font.PLAIN, 13));
        spinKichThuoc.setBounds(233, 224, 62, 20);
        spinKichThuoc.setEnabled(false); // Ban đầu không cho chỉnh sửa
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

        btnEditMode = new JButton("");
        btnEditMode.setIcon(new ImageIcon(SanPhamGUI.class.getResource("/image/edit20.png")));
        btnEditMode.setFont(new Font("Arial", Font.PLAIN, 13));
        btnEditMode.setBounds(445, 55, 47, 21);
        btnEditMode.setFocusPainted(false);
        btnEditMode.setBorderPainted(false);
        btnEditMode.setBackground(null);
        btnEditMode.addActionListener(e -> toggleEditMode());
        pInput.add(btnEditMode);

        tblDSSP.getSelectionModel().addListSelectionListener(e -> {
            int row = tblDSSP.getSelectedRow();
            if (row >= 0) {
                txtMaSP.setText(tblDSSP.getValueAt(row, 0).toString());
                txtTenSP.setText(tblDSSP.getValueAt(row, 1).toString());
                cbLoaiSP.setSelectedItem(tblDSSP.getValueAt(row, 2).toString());
                txtDonGia.setText(tblDSSP.getValueAt(row, 3).toString());
                txtSoLuong.setText(tblDSSP.getValueAt(row, 4).toString());
                txtDonViTinh.setText(tblDSSP.getValueAt(row, 5).toString());
                // Giả sử các trường khác (màu sắc, kích thước, chất liệu, kiểu dáng) chưa được lưu trong bảng
            }
        });
    }

    private void toggleEditMode() {
        isEditMode = !isEditMode; // Đổi trạng thái chỉnh sửa
        txtMaSP.setEditable(isEditMode);
        txtTenSP.setEditable(isEditMode);
        txtDonGia.setEditable(isEditMode);
        txtSoLuong.setEditable(isEditMode);
        txtDonViTinh.setEditable(isEditMode);
        txtChatLieu.setEditable(isEditMode);
        txtKieuDang.setEditable(isEditMode);
        cbLoaiSP.setEnabled(isEditMode);
        spinKichThuoc.setEnabled(isEditMode);
        rbDen.setEnabled(isEditMode);
        rbTrang.setEnabled(isEditMode);
        rbXam.setEnabled(isEditMode);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Thêm":
                addProduct();
                break;
            case "Sửa":
                updateProduct();
                break;
            case "Xóa":
                deleteProduct();
                break;
            default:
                break;
        }
    }

    public void addProduct() {
        // Implement logic here
    }

    public void updateProduct() {
        if (!isEditMode) {
            JOptionPane.showMessageDialog(this, "Vui lòng bật chế độ chỉnh sửa trước!", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int row = tblDSSP.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để sửa", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Cập nhật dữ liệu trong bảng demo
        model.setValueAt(txtMaSP.getText(), row, 0);
        model.setValueAt(txtTenSP.getText(), row, 1);
        model.setValueAt(cbLoaiSP.getSelectedItem(), row, 2);
        model.setValueAt(txtDonGia.getText(), row, 3);
        model.setValueAt(txtSoLuong.getText(), row, 4);
        model.setValueAt(txtDonViTinh.getText(), row, 5);
        JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        // TODO: Thêm logic lưu vào database nếu cần
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

    public void openLoaiSPDialog() {
        LoaiSPDialog dialog = new LoaiSPDialog(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
        loadLoaiSPToComboBox(); // Cập nhật lại combobox sau khi dialog đóng
    }

    private void updateLoaiSPComboBox(DefaultTableModel modelLoai) {
        cbLoaiSP.removeAllItems();
        for (int i = 0; i < modelLoai.getRowCount(); i++) {
            String tenLoai = modelLoai.getValueAt(i, 1).toString();
            cbLoaiSP.addItem(tenLoai);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test SanPhamGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1248, 757);
        frame.getContentPane().add(new SanPhamGUI());
        frame.setVisible(true);
    }
}