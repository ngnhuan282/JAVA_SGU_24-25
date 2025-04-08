package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import BUS.LoaiBUS;
import DTO.LoaiDTO;

public class LoaiSPDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    private DefaultTableModel modelLoai;
    private JTable tblLoai;
    private JTextField txtMaLoai, txtTenLoai;
    private LoaiBUS loaiBUS;
    private JButton btnEditMode;
    private boolean isEditMode = false;

    public LoaiSPDialog(Window window) {
        super(window, "Quản lý loại sản phẩm");
        loaiBUS = new LoaiBUS();
        initComponents();
        loaiBUS.docDSLoai(); // Đọc danh sách ngay khi mở GUI
        loadDataToTable();    // Hiển thị dữ liệu lên bảng
        setSize(500, 400);
        setLocationRelativeTo(window);
        setModal(true);
    }

    public void initComponents() {
        getContentPane().setLayout(null);

        JLabel lbTitle = new JLabel("QUẢN LÝ LOẠI SẢN PHẨM", SwingConstants.CENTER);
        lbTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lbTitle.setBounds(0, 0, 486, 40);
        getContentPane().add(lbTitle);

        modelLoai = new DefaultTableModel(new String[]{"Mã loại", "Tên loại"}, 0);
        tblLoai = new JTable(modelLoai);
        tblLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        tblLoai.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        JScrollPane scrollLoai = new JScrollPane(tblLoai);
        scrollLoai.setBounds(10, 50, 480, 200);
        getContentPane().add(scrollLoai);

        JLabel lbMaLoai = new JLabel("Mã loại:");
        lbMaLoai.setFont(new Font("Arial", Font.PLAIN, 14));
        lbMaLoai.setBounds(10, 260, 80, 25);
        getContentPane().add(lbMaLoai);

        txtMaLoai = new JTextField();
        txtMaLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        txtMaLoai.setBounds(90, 260, 100, 25);
        txtMaLoai.setEditable(false);
        getContentPane().add(txtMaLoai);

        JLabel lbTenLoai = new JLabel("Tên loại:");
        lbTenLoai.setFont(new Font("Arial", Font.PLAIN, 14));
        lbTenLoai.setBounds(210, 260, 71, 25);
        getContentPane().add(lbTenLoai);

        txtTenLoai = new JTextField();
        txtTenLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        txtTenLoai.setBounds(280, 260, 200, 25);
        txtTenLoai.setEditable(false);
        getContentPane().add(txtTenLoai);

        JButton btnThemLoai = new JButton("Thêm", new ImageIcon(getClass().getResource("/image/add20.png")));
        btnThemLoai.setForeground(Color.WHITE);
        btnThemLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        btnThemLoai.setBackground(Color.decode("#4CAF50"));
        btnThemLoai.setBounds(56, 300, 120, 30);
        btnThemLoai.addActionListener(e -> themLoai());
        getContentPane().add(btnThemLoai);

        JButton btnSuaLoai = new JButton("Cập nhật", new ImageIcon(getClass().getResource("/image/edit20.png")));
        btnSuaLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        btnSuaLoai.setForeground(Color.WHITE);
        btnSuaLoai.setBackground(Color.decode("#7986CB"));
        btnSuaLoai.setBounds(199, 300, 120, 30);
        btnSuaLoai.addActionListener(e -> suaLoai());
        getContentPane().add(btnSuaLoai);

        JButton btnXoaLoai = new JButton("Xóa", new ImageIcon(getClass().getResource("/image/remove20.png")));
        btnXoaLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        btnXoaLoai.setForeground(Color.WHITE);
        btnXoaLoai.setBackground(Color.decode("#FF7043"));
        btnXoaLoai.setBounds(338, 300, 120, 30);
        btnXoaLoai.addActionListener(e -> xoaLoai());
        getContentPane().add(btnXoaLoai);

        btnEditMode = new JButton("");
        btnEditMode.setIcon(new ImageIcon(getClass().getResource("/image/editMode20.png")));
        btnEditMode.setBounds(434, 10, 46, 21);
        btnEditMode.setFocusPainted(false);
        btnEditMode.setBorderPainted(false);
        btnEditMode.setBackground(null);
        btnEditMode.addActionListener(e -> toggleEditMode());
        getContentPane().add(btnEditMode);

        tblLoai.getSelectionModel().addListSelectionListener(e -> {
            int row = tblLoai.getSelectedRow();
            if (row >= 0) {
                txtMaLoai.setText(tblLoai.getValueAt(row, 0).toString());
                txtTenLoai.setText(tblLoai.getValueAt(row, 1).toString());
            }
        });
    }

    private void toggleEditMode() {
        isEditMode = !isEditMode;
        txtTenLoai.setEditable(isEditMode);
    }

    private void loadDataToTable() {
        modelLoai.setRowCount(0);
        if (loaiBUS.getDsloai() != null) {
            for (LoaiDTO loai : loaiBUS.getDsloai()) {
                modelLoai.addRow(new Object[]{loai.getMaLoaiSP(), loai.getTenLoaiSP()});
            }
        }
    }

    public void themLoai() 
    {
        String tenLoai = txtTenLoai.getText().trim();
        int maLoai = loaiBUS.getNextID();
        LoaiDTO loai = new LoaiDTO(maLoai, tenLoai); 
        if (loaiBUS.add(loai)) 
        {
            loadDataToTable();
            txtMaLoai.setText("");
            txtTenLoai.setText("");
            JOptionPane.showMessageDialog(this, "Thêm loại SP thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        } 
        else 
            JOptionPane.showMessageDialog(this, "Thêm thất bại! Tên loại không hợp lệ hoặc đã tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        
    }

    public void suaLoai() {
        if (!isEditMode) {
            JOptionPane.showMessageDialog(this, "Vui lòng bật chế độ sửa!", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int row = tblLoai.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại để sửa!", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int maLoai = Integer.parseInt(txtMaLoai.getText().trim());
        String tenLoai = txtTenLoai.getText().trim();
        LoaiDTO loai = new LoaiDTO(maLoai, tenLoai);
        if (loaiBUS.update(loai)) {
            loadDataToTable();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại! Tên loại không hợp lệ hoặc đã tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void xoaLoai() {
        int row = tblLoai.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại để xóa!", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int maLoai = Integer.parseInt(txtMaLoai.getText().trim());
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa loại '" + txtTenLoai.getText() + "' không?",
                "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (loaiBUS.delete(maLoai)) {
                loadDataToTable();
                txtMaLoai.setText("");
                txtTenLoai.setText("");
                JOptionPane.showMessageDialog(this, "Xóa thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại! Không tìm thấy loại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public DefaultTableModel getModelLoai() {
        return modelLoai;
    }
}