package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.CTKMBUS;
import DTO.CTKMDTO;
import DTO.NhanVienDTO;

public class CTKMGUI extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTable tblCTKM;
    private JTextField txtMaCTKM;
    private JTextField txtNgayBD;
    private JTextField txtNgayKT;
    private JComboBox<String> cboxLoaiKM;
    private JComboBox<String> cboxMaSP;
    private JComboBox<String> cboxMaHD;
    private boolean isEditMode = false;
    private CTKMBUS ctkmBUS;

    public CTKMGUI() throws SQLException {
        setLayout(new BorderLayout());
        ctkmBUS = new CTKMBUS();
        tblCTKM = new JTable(tableModel);

        JPanel pMain = new JPanel(null);
        pMain.setPreferredSize(new Dimension(1248, 757));
        add(pMain);

        JPanel pHeaderMain = new JPanel(null);
        pHeaderMain.setBackground(Color.WHITE);
        pHeaderMain.setBounds(0, 0, 1248, 100);
        pMain.add(pHeaderMain);

        JPanel pLeftHeader = new JPanel(null);
        pLeftHeader.setBorder(new TitledBorder("Chức năng"));
        pLeftHeader.setBackground(Color.WHITE);
        pLeftHeader.setBounds(2, 0, 512, 100);
        pHeaderMain.add(pLeftHeader);

        Box box = Box.createHorizontalBox();
        box.setBounds(0, 0, 512, 100);
        pLeftHeader.add(box);

        JButton btnThem = createButton("Thêm", "/image/add48.png");
        JButton btnSua = createButton("Sửa", "/image/edit48.png");
        JButton btnXoa = createButton("Xóa", "/image/remove48.png");
        JButton btnNhapExcel = createButton("Nhập Excel", "/image/bill48.png");
        JButton btnXuatExcel = createButton("Xuất Excel", "/image/excel48.png");

        box.add(btnThem);
        box.add(btnSua);
        box.add(btnXoa);
        box.add(btnNhapExcel);
        box.add(btnXuatExcel);

        JComboBox<String> cboxSearch = new JComboBox<>(new String[]{"Mã CTKM", "Loại KM"});
        cboxSearch.setBounds(524, 30, 100, 28);
        pHeaderMain.add(cboxSearch);

        JTextField txtSearch = new JTextField();
        txtSearch.setBounds(643, 30, 237, 27);
        pHeaderMain.add(txtSearch);

        JButton btnSearch = new JButton(new ImageIcon(CTKMGUI.class.getResource("/image/search30.png")));
        btnSearch.setBounds(908, 22, 63, 39);
        pHeaderMain.add(btnSearch);

        JPanel panel = new JPanel(null);
        panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
        panel.setBackground(Color.WHITE);
        panel.setBounds(2, 110, 265, 655);
        pMain.add(panel);

        txtMaCTKM = createLabeledTextField(panel, "Mã CTKM", 41);
        txtNgayBD = createLabeledTextField(panel, "Ngày Bắt Đầu", 121);
        txtNgayKT = createLabeledTextField(panel, "Ngày Kết Thúc", 201);

        JLabel lbLoaiKM = new JLabel("Loại Khuyến Mãi");
        lbLoaiKM.setFont(new Font("Verdana", Font.BOLD, 12));
        lbLoaiKM.setBounds(10, 281, 120, 23);
        panel.add(lbLoaiKM);

        cboxLoaiKM = new JComboBox<>(new String[]{"Sản Phẩm", "Hóa Đơn"});
        cboxLoaiKM.setBounds(10, 306, 245, 32);
        panel.add(cboxLoaiKM);

        JLabel lbMaSPorHD = new JLabel("Mã SP/HD");
        lbMaSPorHD.setFont(new Font("Verdana", Font.BOLD, 12));
        lbMaSPorHD.setBounds(10, 361, 100, 23);
        panel.add(lbMaSPorHD);

        cboxMaSP = new JComboBox<>();
        cboxMaSP.setBounds(10, 386, 245, 32);
        panel.add(cboxMaSP);

        cboxMaHD = new JComboBox<>();
        cboxMaHD.setBounds(10, 386, 245, 32);
        panel.add(cboxMaHD);

        JButton btnEditMode = new JButton(new ImageIcon(CTKMGUI.class.getResource("/image/edit20.png")));
        btnEditMode.setBounds(445, 55, 47, 21);
        btnEditMode.setBorderPainted(false);
        btnEditMode.setFocusPainted(false);
        btnEditMode.setBackground(null);
        btnEditMode.addActionListener(e -> toggleEditMode());
        panel.add(btnEditMode);

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã CTKM", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Loại KM"});
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(277, 110, 969, 646);
        pMain.add(scrollPane);

        cboxLoaiKM.addActionListener(e -> switchMaBox());

        btnThem.addActionListener(e -> addCTKM());
        btnSua.addActionListener(e -> updateCTKM());
        btnXoa.addActionListener(e -> deleteCTKM());
        btnSearch.addActionListener(e -> searchCTKM());

        switchMaBox();
        loadData();
    }
    public void actionPerformed(ActionEvent e) 
    {
        String command = e.getActionCommand();
        switch (command) 
        {
            case "Thêm": addKhuyenMai(); break;
//            case "Sửa": updateKhuyenMai(); break;
//            case "Xóa": deleteKhuyenMai(); break;
//            case "Tìm kiếm": timKiem(); break;
        }
    }

    public void addKhuyenMai() {
        if (!isEditMode) {
            JOptionPane.showMessageDialog(this, "Vui lòng bật chế độ chỉnh sửa trước!", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String maKM = txtMaCTKM.getText().trim();
        String ngayBDStr = txtNgayBD.getText().trim();
        String ngayKTStr = txtNgayKT.getText().trim();

        if(maKM.isEmpty() || ngayBDStr.isEmpty() || ngayKTStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Định dạng ngày (ví dụ: dd/MM/yyyy)
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false); // không cho phép nhập sai định dạng
            
            java.util.Date utilDateBD = sdf.parse(ngayBDStr);
            java.util.Date utilDateKT = sdf.parse(ngayKTStr);

            java.sql.Date sqlDateBD = new java.sql.Date(utilDateBD.getTime());
            java.sql.Date sqlDateKT = new java.sql.Date(utilDateKT.getTime());

            CTKMDTO km = new CTKMDTO(maKM, sqlDateBD, sqlDateKT);
            ctkmBUS.addKhuyenMai(maKM, sqlDateBD, sqlDateKT);
            
            tableModel.addRow(new Object[]{maKM, sdf.format(utilDateBD), sdf.format(utilDateKT)});
            tblCTKM.setModel(tableModel);

            JOptionPane.showMessageDialog(this, "Thêm khuyến mãi thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            clearField();

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Ngày không hợp lệ! Vui lòng nhập theo định dạng dd/MM/yyyy", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void clearField() {
        txtMaCTKM.setText("");
        txtNgayBD.setText("");
        txtNgayKT.setText("");

    }

   
    

    private JButton createButton(String title, String iconPath) {
        JButton btn = new JButton(title, new ImageIcon(CTKMGUI.class.getResource(iconPath)));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn.setHorizontalTextPosition(SwingConstants.CENTER);
        btn.setFont(new Font("Arial", Font.PLAIN, 15));
        btn.setBackground(Color.WHITE);
        btn.setPreferredSize(new Dimension(120, 100));
        return btn;
    }

    private JTextField createLabeledTextField(JPanel panel, String labelText, int y) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Verdana", Font.BOLD, 12));
        label.setBounds(10, y, 200, 23);
        panel.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(10, y + 25, 245, 32);
        textField.setEditable(false);
        panel.add(textField);
        return textField;
    }

    private void toggleEditMode() {
        isEditMode = !isEditMode;
        txtMaCTKM.setEditable(isEditMode);
        txtNgayBD.setEditable(isEditMode);
        txtNgayKT.setEditable(isEditMode);
        cboxLoaiKM.setEnabled(isEditMode);
        cboxMaSP.setEnabled(isEditMode);
        cboxMaHD.setEnabled(isEditMode);
    }

    private void switchMaBox() {
        String selected = (String) cboxLoaiKM.getSelectedItem();
        boolean isSP = "Sản Phẩm".equals(selected);
        cboxMaSP.setVisible(isSP);
        cboxMaHD.setVisible(!isSP);
    }

    private void loadData() {
        ArrayList<CTKMDTO> list = ctkmBUS.getListKhuyenMai();
        tableModel.setRowCount(0);
        for (CTKMDTO dto : list) {
            tableModel.addRow(new Object[]{
                dto.getMaCTKM(),
                dto.getNgayBD(),
                dto.getNgayKT(),
            });
            tblCTKM.setModel(tableModel);
            tblCTKM.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblCTKM.getColumnModel().getColumn(1).setPreferredWidth(180);
            tblCTKM.getColumnModel().getColumn(2).setPreferredWidth(90);
            tblCTKM.getColumnModel().getColumn(3).setPreferredWidth(200);
        }
    }

    private void addCTKM() {
        // Logic thêm CTKM
    }

    private void updateCTKM() {
        // Logic cập nhật CTKM
    }

    private void deleteCTKM() {
        // Logic xóa CTKM
    }

    private void searchCTKM() {
        // Logic tìm kiếm CTKM
    }

    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame("Quản Lý Chương Trình Khuyến Mãi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 800);
        frame.add(new CTKMGUI());
        frame.setVisible(true);
    }
}
