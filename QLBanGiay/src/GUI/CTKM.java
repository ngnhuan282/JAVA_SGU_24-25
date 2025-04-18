package GUI;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

public class CTKM extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtMaCTKM;
    private JSpinner dateStart, dateEnd;
    private JButton btnAdd, btnEdit, btnDelete, btnSearch;
    private JTextField txtSearch;

    public CTKM() {
        setLayout(new BorderLayout());

        // Bảng hiển thị CTKM
        String[] columns = {"Mã CTKM", "Ngày Bắt Đầu", "Ngày Kết Thúc"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Form nhập liệu
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Thông tin CTKM"));
        formPanel.add(new JLabel("Mã CTKM:"));
        txtMaCTKM = new JTextField(10);
        txtMaCTKM.setEditable(false);
        formPanel.add(txtMaCTKM);
        formPanel.add(new JLabel("Ngày Bắt Đầu:"));
        SpinnerDateModel startModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        dateStart = new JSpinner(startModel);
        dateStart.setEditor(new JSpinner.DateEditor(dateStart, "dd/MM/yyyy"));
        formPanel.add(dateStart);
        formPanel.add(new JLabel("Ngày Kết Thúc:"));
        SpinnerDateModel endModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        dateEnd = new JSpinner(endModel);
        dateEnd.setEditor(new JSpinner.DateEditor(dateEnd, "dd/MM/yyyy"));
        formPanel.add(dateEnd);

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
        loadData();

        // Sự kiện
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.getSelectedRow();
                txtMaCTKM.setText(tableModel.getValueAt(row, 0).toString());
                dateStart.setValue(tableModel.getValueAt(row, 1));
                dateEnd.setValue(tableModel.getValueAt(row, 2));
            }
        });

        btnAdd.addActionListener(e -> addCTKM());
        btnEdit.addActionListener(e -> editCTKM());
        btnDelete.addActionListener(e -> deleteCTKM());
        btnSearch.addActionListener(e -> searchCTKM());
    }

    private void loadData() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuanLyBanGiay", "root", "")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CTKM");
            tableModel.setRowCount(0);
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getInt("MaCTKM"),
                        rs.getDate("NgayBD"),
                        rs.getDate("NgayKT")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addCTKM() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuanLyBanGiay", "root", "")) {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO CTKM (NgayBD, NgayKT) VALUES (?, ?)");
            pstmt.setDate(1, new java.sql.Date(((Date) dateStart.getValue()).getTime()));
            pstmt.setDate(2, new java.sql.Date(((Date) dateEnd.getValue()).getTime()));
            pstmt.executeUpdate();
            loadData();
            JOptionPane.showMessageDialog(this, "Thêm CTKM thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void editCTKM() {
        // Cập nhật CTKM
    }

    private void deleteCTKM() {
        // Xóa CTKM
    }

    private void searchCTKM() {
        // Tìm kiếm CTKM
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Quản lý CTKM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new CTKM());
        frame.setVisible(true);
    }
}