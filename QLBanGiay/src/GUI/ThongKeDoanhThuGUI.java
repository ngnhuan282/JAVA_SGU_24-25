package GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ThongKeDoanhThuGUI extends JPanel {
    private static final long serialVersionUID = 1L;

    public ThongKeDoanhThuGUI() {
        initComponents();
    }

    private void initComponents() {
        setBackground(Color.WHITE);
        setLayout(null);

        // Header: THỐNG KÊ DOANH THU
        JLabel lblHeader = new JLabel("THỐNG KÊ DOANH THU", SwingConstants.CENTER);
        lblHeader.setBounds(0, 10, 1228, 50);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 30));
        lblHeader.setForeground(new Color(255, 82, 82));
        add(lblHeader);

        // Panel hiển thị Tổng thu, Tổng chi, Lợi nhuận
        JPanel pSummary = new JPanel();
        pSummary.setBounds(20, 70, 1188, 100);
        pSummary.setBackground(Color.WHITE);
        pSummary.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        pSummary.setLayout(null);
        add(pSummary);

        JLabel lblTongThu = new JLabel("Tổng thu: 3,450,000,000đ");
        lblTongThu.setBounds(20, 30, 300, 40);
        lblTongThu.setFont(new Font("Arial", Font.PLAIN, 16));
        pSummary.add(lblTongThu);

        JLabel lblTongChi = new JLabel("Tổng chi: 2,990,000,000đ");
        lblTongChi.setBounds(420, 30, 300, 40);
        lblTongChi.setFont(new Font("Arial", Font.PLAIN, 16));
        pSummary.add(lblTongChi);

        JLabel lblLoiNhuan = new JLabel("Lợi nhuận: 460,000,000đ");
        lblLoiNhuan.setBounds(820, 30, 300, 40);
        lblLoiNhuan.setFont(new Font("Arial", Font.PLAIN, 16));
        pSummary.add(lblLoiNhuan);

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

        JLabel lblChartPlaceholder = new JLabel("Biểu đồ cột (Thống kê theo tháng)", SwingConstants.CENTER);
        lblChartPlaceholder.setBounds(0, 0, 1188, 200);
        lblChartPlaceholder.setFont(new Font("Arial", Font.PLAIN, 14));
        pChart.add(lblChartPlaceholder);

        // Bảng dữ liệu chi tiết
        String[] columnNames = {"Tháng", "Chi phí", "Doanh thu", "Lợi nhuận"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 460, 1188, 200);
        add(scrollPane);

        // Dữ liệu giả định cho bảng
        tableModel.addRow(new Object[]{"Tháng 1", "0đ", "0đ", "0đ"});
        tableModel.addRow(new Object[]{"Tháng 2", "0đ", "0đ", "0đ"});
        tableModel.addRow(new Object[]{"Tháng 3", "0đ", "0đ", "0đ"});
        tableModel.addRow(new Object[]{"Tháng 4", "346,000,000đ", "3,450,000,000đ", "38,500,000đ"});
        tableModel.addRow(new Object[]{"Tháng 5", "258,200,000đ", "2,990,000,000đ", "40,860,000đ"});
        tableModel.addRow(new Object[]{"Tháng 6", "0đ", "0đ", "0đ"});
    }
}