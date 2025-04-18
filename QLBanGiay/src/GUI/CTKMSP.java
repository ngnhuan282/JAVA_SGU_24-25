package GUI;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CTKMSP extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private JComboBox<String> cbMaCTKM, cbMaSP;
    private JTextField txtPhanTramGiam;
    private JButton btnAdd, btnEdit, btnDelete, btnSearch;
    private JTextField txtSearch;

    public CTKMSP() {
        setLayout(new BorderLayout());

        // Bảng hiển thị CTKM_SP
        String[] columns = {"Mã CTKM", "Mã SP", "Tên SP", "Phần trăm Giảm"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Form nhập liệu
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Thông tin CTKM Sản phẩm"));
        formPanel.add(new JLabel("Mã CTKM:"));
        cbMaCTKM = new JComboBox<>();
        formPanel.add(cbMaCTKM);
        formPanel.add(new JLabel("Mã Sản phẩm:"));
        cbMaSP = new JComboBox<>();
        formPanel.add(cbMaSP);
        formPanel.add(new JLabel("Phần trăm Giảm:"));
        txtPhanTramGiam = new JTextField(10);
        formPanel.add(txtPhanTramGiam);

        // Nút chức năng
        btnAdd = new JButton("Thêm");
        btnEdit = new JButton("Sửa");
        btnDelete = new JButton("Xóa");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnDelete);
        formPanel.add(buttonPanel);

        // Tìm kiếm
        JPanel searchPanel = new JPanel();
        searchPanel.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
        txtSearch = new JTextField(20);
        btnSearch = new JButton("Tìm kiếm");
        searchPanel.add(txtSearch);
        searchPanel.add(btnSearch);

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(formPanel, BorderLayout.CENTER);
        southPanel.add(searchPanel, BorderLayout.SOUTH);
        add(southPanel, BorderLayout.SOUTH);

        // Tải dữ liệu
        loadComboBoxData();
        loadData();

        // Sự kiện
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.getSelectedRow();
                cbMaCTKM.setSelectedItem(tableModel.getValueAt(row, 0).toString());
                cbMaSP.setSelectedItem(tableModel.getValueAt(row, 1).toString());
                txtPhanTramGiam.setText(tableModel.getValueAt(row, 3).toString());
            }
        });

        btnAdd.addActionListener(e -> addCTKMSP());
        btnEdit.addActionListener(e -> editCTKMSP());
        btnDelete.addActionListener(e -> deleteCTKMSP());
        btnSearch.addActionListener(e -> searchCTKMSP());
    }

    private void loadComboBoxData() {
        // Tải danh sách Mã CTKM
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuanLyBanGiay", "root", "")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MaCTKM FROM CTKM");
            while (rs.next()) {
                cbMaCTKM.addItem(rs.getString("MaCTKM"));
            }

            // Tải danh sách Mã SP và Tên SP
            rs = stmt.executeQuery("SELECT MaSP, TenSP FROM SANPHAM");
            while (rs.next()) {
                cbMaSP.addItem(rs.getString("MaSP") + " - " + rs.getString("TenSP"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuanLyBanGiay", "root", "")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                "SELECT c.MaCTKM, c.MaSP, s.TenSP, c.PhanTramGiamGia " +
                "FROM CTKM_SP c JOIN SANPHAM s ON c.MaSP = s.MaSP"
            );
            tableModel.setRowCount(0);
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getInt("MaCTKM"),
                    rs.getString("MaSP"),
                    rs.getString("TenSP"),
                    rs.getDouble("PhanTramGiamGia")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addCTKMSP() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuanLyBanGiay", "root", "")) {
            String maCTKM = cbMaCTKM.getSelectedItem().toString();
            String maSP = cbMaSP.getSelectedItem().toString().split(" - ")[0];
            double phanTramGiam = Double.parseDouble(txtPhanTramGiam.getText());

            if (phanTramGiam < 0 || phanTramGiam > 100) {
                JOptionPane.showMessageDialog(this, "Phần trăm giảm giá phải từ 0 đến 100!");
                return;
            }

            PreparedStatement pstmt = conn.prepareStatement(
                "INSERT INTO CTKM_SP (MaCTKM, MaSP, PhanTramGiamGia) VALUES (?, ?, ?)"
            );
            pstmt.setInt(1, Integer.parseInt(maCTKM));
            pstmt.setString(2, maSP);
            pstmt.setDouble(3, phanTramGiam);
            pstmt.executeUpdate();
            loadData();
            JOptionPane.showMessageDialog(this, "Thêm CTKM Sản phẩm thành công!");
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm CTKM Sản phẩm!");
        }
    }

    private void editCTKMSP() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuanLyBanGiay", "root", "")) {
            String maCTKM = cbMaCTKM.getSelectedItem().toString();
            String maSP = cbMaSP.getSelectedItem().toString().split(" - ")[0];
            double phanTramGiam = Double.parseDouble(txtPhanTramGiam.getText());

            if (phanTramGiam < 0 || phanTramGiam > 100) {
                JOptionPane.showMessageDialog(this, "Phần trăm giảm giá phải từ 0 đến 100!");
                return;
            }

            PreparedStatement pstmt = conn.prepareStatement(
                "UPDATE CTKM_SP SET PhanTramGiamGia = ? WHERE MaCTKM = ? AND MaSP = ?"
            );
            pstmt.setDouble(1, phanTramGiam);
            pstmt.setInt(2, Integer.parseInt(maCTKM));
            pstmt.setString(3, maSP);
            pstmt.executeUpdate();
            loadData();
            JOptionPane.showMessageDialog(this, "Sửa CTKM Sản phẩm thành công!");
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi sửa CTKM Sản phẩm!");
        }
    }

    private void deleteCTKMSP() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một CTKM Sản phẩm để xóa!");
            return;
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuanLyBanGiay", "root", "")) {
            String maCTKM = tableModel.getValueAt(row, 0).toString();
            String maSP = tableModel.getValueAt(row, 1).toString();

            PreparedStatement pstmt = conn.prepareStatement(
                "DELETE FROM CTKM_SP WHERE MaCTKM = ? AND MaSP = ?"
            );
            pstmt.setInt(1, Integer.parseInt(maCTKM));
            pstmt.setString(2, maSP);
            pstmt.executeUpdate();
            loadData();
            JOptionPane.showMessageDialog(this, "Xóa CTKM Sản phẩm thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi xóa CTKM Sản phẩm!");
        }
    }

    private void searchCTKMSP() {
        String searchText = txtSearch.getText().trim();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuanLyBanGiay", "root", "")) {
            PreparedStatement pstmt = conn.prepareStatement(
                "SELECT c.MaCTKM, c.MaSP, s.TenSP, c.PhanTramGiamGia " +
                "FROM CTKM_SP c JOIN SANPHAM s ON c.MaSP = s.MaSP " +
                "WHERE c.MaCTKM LIKE ? OR c.MaSP LIKE ?"
            );
            pstmt.setString(1, "%" + searchText + "%");
            pstmt.setString(2, "%" + searchText + "%");
            ResultSet rs = pstmt.executeQuery();
            tableModel.setRowCount(0);
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getInt("MaCTKM"),
                    rs.getString("MaSP"),
                    rs.getString("TenSP"),
                    rs.getDouble("PhanTramGiamGia")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Quản lý CTKM Sản phẩm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new CTKMSP());
        frame.setVisible(true);
    }
}