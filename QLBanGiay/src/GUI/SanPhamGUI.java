package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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
import javax.swing.table.TableColumnModel;

import BUS.ChiTietSPBUS;
import BUS.LoaiBUS;
import BUS.SanPhamBUS;
import DTO.ChiTietSPDTO;
import DTO.LoaiDTO;
import DTO.SanPhamDTO;

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
    private SanPhamBUS spBUS;
    private ChiTietSPBUS ctspBUS;
    private boolean isEditMode = false;

    public SanPhamGUI() {
        Object[] header = {"Mã SP", "Tên SP", "Loại", "Giá", "Số lượng", "ĐVT", "Màu sắc", "Kích thước", "Chất liệu", "Kiểu dáng"};
        model = new DefaultTableModel(header, 0);
        loaiBUS = new LoaiBUS();
        spBUS = new SanPhamBUS();
        ctspBUS = new ChiTietSPBUS();
        loaiBUS.docDSLoai();
        spBUS.docDSSP();
        initComponents();
        loadDataToTable();
        loadLoaiSPToComboBox();
    }

    private void loadDataToTable() {
        model.setRowCount(0); // Xóa dữ liệu cũ trong bảng
        for (SanPhamDTO sp : spBUS.getDssp()) {
            // Lấy danh sách chi tiết sản phẩm
            ctspBUS.docDSCTSP(sp.getMaSP());
            ArrayList<ChiTietSPDTO> dsCTSP = ChiTietSPBUS.getDsCTSP();

            // Tìm tên loại sản phẩm
            String tenLoaiSP = "";
            for (LoaiDTO loai : LoaiBUS.getDsloai()) {
                if (loai.getMaLoaiSP() == sp.getMaLoaiSP()) {
                    tenLoaiSP = loai.getTenLoaiSP();
                    break;
                }
            }

            // Kiểm tra dsCTSP
            if (dsCTSP == null || dsCTSP.isEmpty()) {
                System.out.println("Không có chi tiết cho sản phẩm: " + sp.getMaSP());
                model.addRow(new Object[]{
                    sp.getMaSP(), sp.getTenSP(), tenLoaiSP, sp.getDonGia(), sp.getSoLuong(), sp.getDonViTinh(),
                    "", "", "", ""
                });
            } else {
                ChiTietSPDTO ctsp = dsCTSP.get(0); // Lấy chi tiết đầu tiên
                System.out.println("Chi tiết sản phẩm " + sp.getMaSP() + ": " + ctsp.getMauSac() + ", " + ctsp.getKichThuoc() + ", " + ctsp.getChatLieu() + ", " + ctsp.getKieuDang());
                model.addRow(new Object[]{
                    sp.getMaSP(), sp.getTenSP(), tenLoaiSP, sp.getDonGia(), sp.getSoLuong(), sp.getDonViTinh(),
                    ctsp.getMauSac(), ctsp.getKichThuoc(), ctsp.getChatLieu(), ctsp.getKieuDang()
                });
            }
        }
    }

    private void loadLoaiSPToComboBox() {
        cbLoaiSP.removeAllItems();
        if (LoaiBUS.getDsloai() != null) {
            for (LoaiDTO loai : LoaiBUS.getDsloai()) {
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

        JButton btnThem = new JButton("Thêm", new ImageIcon(SanPhamGUI.class.getResource("/image/add48.png")));
        btnThem.setFocusPainted(false);
        btnThem.setActionCommand("Thêm");
        btnThem.addActionListener(this);
        btnThem.setBackground(Color.WHITE);
        btnThem.setBorderPainted(false);
        btnThem.setFont(new Font("Arial", Font.PLAIN, 15));
        btnThem.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnThem.setHorizontalTextPosition(SwingConstants.CENTER);
        btnThem.setPreferredSize(new Dimension(120, 140));
        horizontalBox.add(btnThem);

        JButton btnSua = new JButton("Sửa", new ImageIcon(SanPhamGUI.class.getResource("/image/edit48.png")));
        btnSua.setFocusPainted(false);
        btnSua.setActionCommand("Sửa");
        btnSua.addActionListener(this);
        btnSua.setBorderPainted(false);
        btnSua.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnSua.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSua.setFont(new Font("Arial", Font.PLAIN, 15));
        btnSua.setBackground(Color.WHITE);
        btnSua.setPreferredSize(new Dimension(120, 140));
        horizontalBox.add(btnSua);

        JButton btnXoa = new JButton("Xóa", new ImageIcon(SanPhamGUI.class.getResource("/image/remove48.png")));
        btnXoa.setFocusPainted(false);
        btnXoa.setActionCommand("Xóa");
        btnXoa.addActionListener(this);
        btnXoa.setBorderPainted(false);
        btnXoa.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnXoa.setHorizontalTextPosition(SwingConstants.CENTER);
        btnXoa.setFont(new Font("Arial", Font.PLAIN, 15));
        btnXoa.setBackground(Color.WHITE);
        btnXoa.setPreferredSize(new Dimension(120, 140));
        horizontalBox.add(btnXoa);

        JButton btnXuatExcel = new JButton("Xuất Excel", new ImageIcon(SanPhamGUI.class.getResource("/image/excel48.png")));
        btnXuatExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnXuatExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnXuatExcel.setFont(new Font("Arial", Font.PLAIN, 15));
        btnXuatExcel.setBorderPainted(false);
        btnXuatExcel.setBackground(Color.WHITE);
        btnXuatExcel.setPreferredSize(new Dimension(120, 140));
        horizontalBox.add(btnXuatExcel);

        JButton btnNhapExcel = new JButton("Nhập Excel", new ImageIcon(SanPhamGUI.class.getResource("/image/bill48.png")));
        btnNhapExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNhapExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNhapExcel.setFont(new Font("Arial", Font.PLAIN, 15));
        btnNhapExcel.setBorderPainted(false);
        btnNhapExcel.setBackground(Color.WHITE);
        btnNhapExcel.setPreferredSize(new Dimension(120, 140));
        horizontalBox.add(btnNhapExcel);

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

        JButton btnSearch = new JButton("", new ImageIcon(SanPhamGUI.class.getResource("/image/search30.png")));
        btnSearch.setBounds(1071, 22, 66, 39);
        pHeaderMain.add(btnSearch);

        // Form
        JPanel pInput = new JPanel();
        pInput.setBorder(UIManager.getBorder("TextField.border"));
        pInput.setBackground(Color.WHITE);
        pInput.setBounds(349, 110, 497, 382);
        add(pInput);
        pInput.setLayout(null);

        JLabel lbHeaderSP = new JLabel("THÔNG TIN SẢN PHẨM");
        lbHeaderSP.setForeground(Color.WHITE);
        lbHeaderSP.setHorizontalAlignment(SwingConstants.CENTER);
        lbHeaderSP.setFont(new Font("Arial", Font.BOLD, 15));
        lbHeaderSP.setBackground(Color.decode("#FF5252"));
        lbHeaderSP.setOpaque(true);
        lbHeaderSP.setBounds(0, 0, 497, 45);
        pInput.add(lbHeaderSP);

        JLabel lbMaSP = new JLabel("Mã sản phẩm");
        lbMaSP.setFont(new Font("Arial", Font.PLAIN, 14));
        lbMaSP.setBounds(10, 65, 112, 17);
        pInput.add(lbMaSP);

        txtMaSP = new JTextField();
        txtMaSP.setFont(new Font("Arial", Font.PLAIN, 13));
        txtMaSP.setBounds(10, 91, 168, 19);
        txtMaSP.setEditable(false);
        pInput.add(txtMaSP);

        JLabel lbLoaiSP = new JLabel("Loại sản phẩm");
        lbLoaiSP.setFont(new Font("Arial", Font.PLAIN, 14));
        lbLoaiSP.setBounds(233, 65, 112, 17);
        pInput.add(lbLoaiSP);

        cbLoaiSP = new JComboBox<>();
        cbLoaiSP.setFont(new Font("Arial", Font.PLAIN, 13));
        cbLoaiSP.setBounds(233, 91, 133, 21);
        cbLoaiSP.setBackground(Color.WHITE);
        cbLoaiSP.setForeground(Color.BLACK);
        cbLoaiSP.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        cbLoaiSP.setEnabled(false);
        pInput.add(cbLoaiSP);

        JButton btnLoaiSP = new JButton("", new ImageIcon(SanPhamGUI.class.getResource("/image/more30.png")));
        btnLoaiSP.setBorder(null);
        btnLoaiSP.setBackground(null);
        btnLoaiSP.setFocusPainted(false);
        btnLoaiSP.setBounds(331, 64, 47, 18);
        btnLoaiSP.addActionListener(e -> openLoaiSPDialog());
        pInput.add(btnLoaiSP);

        JLabel lbTenSP = new JLabel("Tên sản phẩm");
        lbTenSP.setFont(new Font("Arial", Font.PLAIN, 14));
        lbTenSP.setBounds(10, 133, 112, 17);
        pInput.add(lbTenSP);

        txtTenSP = new JTextField();
        txtTenSP.setFont(new Font("Arial", Font.PLAIN, 13));
        txtTenSP.setBounds(10, 159, 168, 19);
        txtTenSP.setEditable(false);
        pInput.add(txtTenSP);

        JLabel lbMauSac = new JLabel("Màu sắc");
        lbMauSac.setFont(new Font("Arial", Font.PLAIN, 14));
        lbMauSac.setBounds(233, 133, 112, 17);
        pInput.add(lbMauSac);

        rbDen = new JRadioButton("Đen");
        rbDen.setFont(new Font("Arial", Font.PLAIN, 13));
        rbDen.setBackground(Color.WHITE);
        rbDen.setBounds(228, 158, 62, 21);
        rbDen.setEnabled(false);
        pInput.add(rbDen);

        rbTrang = new JRadioButton("Trắng");
        rbTrang.setFont(new Font("Arial", Font.PLAIN, 13));
        rbTrang.setBackground(Color.WHITE);
        rbTrang.setBounds(306, 158, 62, 21);
        rbTrang.setEnabled(false);
        pInput.add(rbTrang);

        rbXam = new JRadioButton("Xám");
        rbXam.setFont(new Font("Arial", Font.PLAIN, 13));
        rbXam.setBackground(Color.WHITE);
        rbXam.setBounds(388, 158, 62, 21);
        rbXam.setEnabled(false);
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
        txtDonGia.setBounds(10, 224, 168, 19);
        txtDonGia.setEditable(false);
        pInput.add(txtDonGia);

        JLabel lbKichThuoc = new JLabel("Kích thước");
        lbKichThuoc.setFont(new Font("Arial", Font.PLAIN, 14));
        lbKichThuoc.setBounds(233, 201, 112, 17);
        pInput.add(lbKichThuoc);

        spinKichThuoc = new JSpinner(new SpinnerNumberModel(38, 38, 43, 1));
        spinKichThuoc.setFont(new Font("Arial", Font.PLAIN, 13));
        spinKichThuoc.setBounds(233, 224, 62, 20);
        spinKichThuoc.setEnabled(false);
        pInput.add(spinKichThuoc);

        JLabel lbSoLuong = new JLabel("Số lượng");
        lbSoLuong.setFont(new Font("Arial", Font.PLAIN, 14));
        lbSoLuong.setBounds(10, 265, 112, 17);
        pInput.add(lbSoLuong);

        txtSoLuong = new JTextField();
        txtSoLuong.setFont(new Font("Arial", Font.PLAIN, 13));
        txtSoLuong.setBounds(10, 291, 168, 19);
        txtSoLuong.setEditable(false);
        pInput.add(txtSoLuong);

        JLabel lbChatLieu = new JLabel("Chất liệu");
        lbChatLieu.setFont(new Font("Arial", Font.PLAIN, 14));
        lbChatLieu.setBounds(233, 265, 112, 17);
        pInput.add(lbChatLieu);

        txtChatLieu = new JTextField();
        txtChatLieu.setFont(new Font("Arial", Font.PLAIN, 13));
        txtChatLieu.setBounds(233, 291, 168, 19);
        txtChatLieu.setEditable(false);
        pInput.add(txtChatLieu);

        JLabel lbDonViTinh = new JLabel("Đơn vị tính");
        lbDonViTinh.setFont(new Font("Arial", Font.PLAIN, 14));
        lbDonViTinh.setBounds(10, 331, 112, 17);
        pInput.add(lbDonViTinh);

        txtDonViTinh = new JTextField();
        txtDonViTinh.setFont(new Font("Arial", Font.PLAIN, 13));
        txtDonViTinh.setBounds(10, 357, 168, 19);
        txtDonViTinh.setEditable(false);
        pInput.add(txtDonViTinh);

        JLabel lbKieuDang = new JLabel("Kiểu dáng");
        lbKieuDang.setFont(new Font("Arial", Font.PLAIN, 14));
        lbKieuDang.setBounds(233, 331, 112, 17);
        pInput.add(lbKieuDang);

        txtKieuDang = new JTextField();
        txtKieuDang.setFont(new Font("Arial", Font.PLAIN, 13));
        txtKieuDang.setBounds(233, 357, 168, 19);
        txtKieuDang.setEditable(false);
        pInput.add(txtKieuDang);

        btnEditMode = new JButton("", new ImageIcon(SanPhamGUI.class.getResource("/image/edit20.png")));
        btnEditMode.setFont(new Font("Arial", Font.PLAIN, 13));
        btnEditMode.setBounds(445, 55, 47, 21);
        btnEditMode.setFocusPainted(false);
        btnEditMode.setBorderPainted(false);
        btnEditMode.setBackground(null);
        btnEditMode.addActionListener(e -> toggleEditMode());
        pInput.add(btnEditMode);

        // Table
        tblDSSP = new JTable(model);
        tblDSSP.setBackground(Color.WHITE);
        tblDSSP.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
        tblDSSP.setFillsViewportHeight(true);
        tblDSSP.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSSP.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        JScrollPane scrollPane = new JScrollPane(tblDSSP);
        scrollPane.setBounds(145, 515, 964, 232);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUI(new ModernScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new ModernScrollBarUI());
        add(scrollPane);

        // Tối ưu chiều rộng cột
        TableColumnModel columnModel = tblDSSP.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);  // Mã SP
        columnModel.getColumn(1).setPreferredWidth(150); // Tên SP
        columnModel.getColumn(2).setPreferredWidth(100); // Loại
        columnModel.getColumn(3).setPreferredWidth(100); // Giá
        columnModel.getColumn(4).setPreferredWidth(80);  // Số lượng
        columnModel.getColumn(5).setPreferredWidth(80);  // ĐVT
        columnModel.getColumn(6).setPreferredWidth(100); // Màu sắc
        columnModel.getColumn(7).setPreferredWidth(80);  // Kích thước
        columnModel.getColumn(8).setPreferredWidth(100); // Chất liệu
        columnModel.getColumn(9).setPreferredWidth(150); // Kiểu dáng

        tblDSSP.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tblDSSPMouseClicked();
            }
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
    }

    public void tblDSSPMouseClicked() {
        int i = tblDSSP.getSelectedRow();
        if (i >= 0) {
            txtMaSP.setText(tblDSSP.getValueAt(i, 0).toString());
            txtTenSP.setText(tblDSSP.getValueAt(i, 1).toString());
            cbLoaiSP.setSelectedItem(tblDSSP.getValueAt(i, 2).toString());
            txtDonGia.setText(tblDSSP.getValueAt(i, 3).toString());
            txtSoLuong.setText(tblDSSP.getValueAt(i, 4).toString());
            txtDonViTinh.setText(tblDSSP.getValueAt(i, 5).toString());
            String mauSac = tblDSSP.getValueAt(i, 6).toString();
            if (mauSac.equals("Đen")) rbDen.setSelected(true);
            else if (mauSac.equals("Trắng")) rbTrang.setSelected(true);
            else if (mauSac.equals("Xám")) rbXam.setSelected(true);
            else {
                rbDen.setSelected(false);
                rbTrang.setSelected(false);
                rbXam.setSelected(false);
            }
            spinKichThuoc.setValue(tblDSSP.getValueAt(i, 7) != null && !tblDSSP.getValueAt(i, 7).toString().isEmpty() 
                ? Integer.parseInt(tblDSSP.getValueAt(i, 7).toString()) : 38);
            txtChatLieu.setText(tblDSSP.getValueAt(i, 8).toString());
            txtKieuDang.setText(tblDSSP.getValueAt(i, 9).toString());
        }
    }

    public void toggleEditMode() {
        isEditMode = !isEditMode;
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
            case "Thêm": addProduct(); break;
            case "Sửa": updateProduct(); break;
            case "Xóa": deleteProduct(); break;
        }
    }

    public void addProduct() {
        if (!isEditMode) {
            JOptionPane.showMessageDialog(this, "Vui lòng bật chế độ chỉnh sửa trước!", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String maSP = txtMaSP.getText().trim();
        String tenSP = txtTenSP.getText().trim();
        int selectedIndex = cbLoaiSP.getSelectedIndex();
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại sản phẩm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int maLoaiSP = loaiBUS.getDsloai().get(selectedIndex).getMaLoaiSP();
        String donGiaStr = txtDonGia.getText().trim();
        String soLuongStr = txtSoLuong.getText().trim();
        String donViTinh = txtDonViTinh.getText().trim();
        String mauSac = rbDen.isSelected() ? "Đen" : rbTrang.isSelected() ? "Trắng" : rbXam.isSelected() ? "Xám" : "";
        int kichThuoc = (int) spinKichThuoc.getValue();
        String chatLieu = txtChatLieu.getText().trim();
        String kieuDang = txtKieuDang.getText().trim();

        try {
            double donGia = Double.parseDouble(donGiaStr);
            int soLuong = Integer.parseInt(soLuongStr);

            SanPhamDTO sp = new SanPhamDTO(maSP, tenSP, soLuong, donGia, donViTinh, maLoaiSP);
            String validateMsg = spBUS.validateSanPham(sp);
            if (validateMsg != null) {
                JOptionPane.showMessageDialog(this, validateMsg, "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (spBUS.checkMaSP(maSP)) {
                JOptionPane.showMessageDialog(this, "Mã sản phẩm đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            spBUS.addSP(sp);
            if (!mauSac.isEmpty() || kichThuoc != 38 || !chatLieu.isEmpty() || !kieuDang.isEmpty()) {
                ChiTietSPDTO ctsp = new ChiTietSPDTO(maSP, mauSac, kichThuoc, chatLieu, kieuDang);
                ctspBUS.add(ctsp);
            }
            model.addRow(new Object[]{maSP, tenSP, cbLoaiSP.getSelectedItem().toString(), donGia, soLuong, donViTinh, mauSac, kichThuoc, chatLieu, kieuDang});
            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            clearForm();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Đơn giá và số lượng phải là số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm sản phẩm: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateProduct() {
        if (!isEditMode) {
            JOptionPane.showMessageDialog(this, "Vui lòng bật chế độ chỉnh sửa trước!", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int row = tblDSSP.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để sửa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String maSP = txtMaSP.getText().trim();
        String tenSP = txtTenSP.getText().trim();
        int selectedIndex = cbLoaiSP.getSelectedIndex();
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại sản phẩm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int maLoaiSP = LoaiBUS.getDsloai().get(selectedIndex).getMaLoaiSP();
        String donGiaStr = txtDonGia.getText().trim();
        String soLuongStr = txtSoLuong.getText().trim();
        String donViTinh = txtDonViTinh.getText().trim();
        String mauSac = rbDen.isSelected() ? "Đen" : rbTrang.isSelected() ? "Trắng" : rbXam.isSelected() ? "Xám" : "";
        int kichThuoc = (int) spinKichThuoc.getValue();
        String chatLieu = txtChatLieu.getText().trim();
        String kieuDang = txtKieuDang.getText().trim();

        try {
            double donGia = Double.parseDouble(donGiaStr);
            int soLuong = Integer.parseInt(soLuongStr);

            SanPhamDTO sp = new SanPhamDTO(maSP, tenSP, soLuong, donGia, donViTinh, maLoaiSP);
            String validateMsg = spBUS.validateSanPham(sp);
            if (validateMsg != null) {
                JOptionPane.showMessageDialog(this, validateMsg, "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            spBUS.updateSP(sp);
            ctspBUS.delete(maSP); // Xóa chi tiết cũ
            if (!mauSac.isEmpty() || kichThuoc != 38 || !chatLieu.isEmpty() || !kieuDang.isEmpty()) {
                ChiTietSPDTO ctsp = new ChiTietSPDTO(maSP, mauSac, kichThuoc, chatLieu, kieuDang);
                ctspBUS.add(ctsp);
            }
            model.setValueAt(maSP, row, 0);
            model.setValueAt(tenSP, row, 1);
            model.setValueAt(cbLoaiSP.getSelectedItem().toString(), row, 2);
            model.setValueAt(donGia, row, 3);
            model.setValueAt(soLuong, row, 4);
            model.setValueAt(donViTinh, row, 5);
            model.setValueAt(mauSac, row, 6);
            model.setValueAt(kichThuoc, row, 7);
            model.setValueAt(chatLieu, row, 8);
            model.setValueAt(kieuDang, row, 9);
            JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Đơn giá và số lượng phải là số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật sản phẩm: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
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
                spBUS.deleteSP(maSP);
                ctspBUS.delete(maSP);
                model.removeRow(i);
                JOptionPane.showMessageDialog(this, "Xóa sản phẩm " + tenSP + " thành công",
                        "Thành công", JOptionPane.INFORMATION_MESSAGE);
                clearForm();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để xóa",
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void openLoaiSPDialog() {
        LoaiSPDialog dialog = new LoaiSPDialog(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
        loadLoaiSPToComboBox();
    }

    public void clearForm() {
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtDonGia.setText("");
        txtSoLuong.setText("");
        txtDonViTinh.setText("");
        txtChatLieu.setText("");
        txtKieuDang.setText("");
        rbDen.setSelected(false);
        rbTrang.setSelected(false);
        rbXam.setSelected(false);
        spinKichThuoc.setValue(38);
        cbLoaiSP.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test SanPhamGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1248, 757);
        frame.getContentPane().add(new SanPhamGUI());
        frame.setVisible(true);
    }
}