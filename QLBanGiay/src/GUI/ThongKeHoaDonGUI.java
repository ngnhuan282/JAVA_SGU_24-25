package GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ThongKeHoaDonGUI extends JPanel {
    private static final long serialVersionUID = 1L;

    public ThongKeHoaDonGUI() {
        initComponents();
    }

    private void initComponents() {
        setBackground(Color.WHITE);
        setLayout(null);

        // Header: THỐNG KÊ HÓA ĐƠN
        JLabel lblHeader = new JLabel("THỐNG KÊ HÓA ĐƠN", SwingConstants.CENTER);
        lblHeader.setBounds(0, 10, 1228, 50);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 30));
        lblHeader.setForeground(new Color(255, 82, 82));
        add(lblHeader);

        // Panel hiển thị Tổng số hóa đơn, Tổng giá trị, Số lượng sản phẩm
        JPanel pSummary = new JPanel();
        pSummary.setBounds(20, 70, 1188, 100);
        pSummary.setBackground(Color.WHITE);
        pSummary.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        pSummary.setLayout(null);
        add(pSummary);

        JLabel lblTongSoHoaDon = new JLabel("Tổng số hóa đơn: 1,250");
        lblTongSoHoaDon.setBounds(20, 30, 300, 40);
        lblTongSoHoaDon.setFont(new Font("Arial", Font.PLAIN, 16));
        pSummary.add(lblTongSoHoaDon);

        JLabel lblTongGiaTri = new JLabel("Tổng giá trị: 3,450,000,000đ");
        lblTongGiaTri.setBounds(420, 30, 300, 40);
        lblTongGiaTri.setFont(new Font("Arial", Font.PLAIN, 16));
        pSummary.add(lblTongGiaTri);

        JLabel lblSoLuongSanPham = new JLabel("Số lượng sản phẩm: 5,670");
        lblSoLuongSanPham.setBounds(820, 30, 300, 40);
        lblSoLuongSanPham.setFont(new Font("Arial", Font.PLAIN, 16));
        pSummary.add(lblSoLuongSanPham);

        // Panel lọc
        JPanel pFilter = new JPanel();
        pFilter.setBounds(20, 180, 1188, 60);
        pFilter.setBackground(Color.WHITE);
        pFilter.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        pFilter.setLayout(null);
        add(pFilter);

        // Lọc Từ ngày → Đến ngày
        JLabel lblTuNgay = new JLabel("Từ ngày:");
        lblTuNgay.setBounds(20, 15, 80, 30);
        lblTuNgay.setFont(new Font("Arial", Font.PLAIN, 14));
        pFilter.add(lblTuNgay);

        JTextField txtTuNgay = new JTextField();
        txtTuNgay.setBounds(100, 15, 120, 30);
        pFilter.add(txtTuNgay);

        JLabel lblDenNgay = new JLabel("Đến ngày:");
        lblDenNgay.setBounds(240, 15, 80, 30);
        lblDenNgay.setFont(new Font("Arial", Font.PLAIN, 14));
        pFilter.add(lblDenNgay);

        JTextField txtDenNgay = new JTextField();
        txtDenNgay.setBounds(320, 15, 120, 30);
        pFilter.add(txtDenNgay);

        // Lọc Theo tháng
        JLabel lblTheoNam = new JLabel("Chọn năm:");
        lblTheoNam.setBounds(460, 15, 80, 30);
        lblTheoNam.setFont(new Font("Arial", Font.PLAIN, 14));
        pFilter.add(lblTheoNam);

        String[] years = {"2023", "2022", "2021"};
        JComboBox<String> cboxNam = new JComboBox<>(years);
        cboxNam.setBounds(540, 15, 80, 30);
        pFilter.add(cboxNam);

        JButton btnXuatExcel = new JButton("Xuất Excel");
        btnXuatExcel.setBounds(1068, 15, 100, 30);
        btnXuatExcel.setFont(new Font("Arial", Font.PLAIN, 14));
        pFilter.add(btnXuatExcel);

        // Placeholder cho biểu đồ cột
        JPanel pChart = new JPanel();
        pChart.setBounds(20, 250, 1188, 200);
        pChart.setBackground(Color.WHITE);
        pChart.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        pChart.setLayout(null);
        add(pChart);

        JLabel lblChartPlaceholder = new JLabel("Biểu đồ cột (Thống kê hóa đơn theo tháng)", SwingConstants.CENTER);
        lblChartPlaceholder.setBounds(0, 0, 1188, 200);
        lblChartPlaceholder.setFont(new Font("Arial", Font.PLAIN, 14));
        pChart.add(lblChartPlaceholder);

        // Bảng dữ liệu chi tiết
        String[] columnNames = {"Tháng", "Số lượng hóa đơn", "Tổng giá trị", "Số lượng sản phẩm"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 460, 1188, 200);
        add(scrollPane);

        // Dữ liệu giả định cho bảng
        tableModel.addRow(new Object[]{"Tháng 1", "0", "0đ", "0"});
        tableModel.addRow(new Object[]{"Tháng 2", "0", "0đ", "0"});
        tableModel.addRow(new Object[]{"Tháng 3", "0", "0đ", "0"});
        tableModel.addRow(new Object[]{"Tháng 4", "250", "1,250,000,000đ", "1,500"});
        tableModel.addRow(new Object[]{"Tháng 5", "300", "1,500,000,000đ", "1,800"});
        tableModel.addRow(new Object[]{"Tháng 6", "0", "0đ", "0"});
    }
}