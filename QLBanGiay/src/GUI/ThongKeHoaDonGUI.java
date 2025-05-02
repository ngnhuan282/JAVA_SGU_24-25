package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DAO.ThongKeDAO;

public class ThongKeHoaDonGUI extends JPanel {
    private static final long serialVersionUID = 1L;
    private ThongKeDAO thongKeDAO;
    private JLabel lblTongSoHoaDon, lblTongGiaTri, lblSoLuongSanPham;
    private JTextField txtTuNgay, txtDenNgay;
    private JComboBox<String> cboxNam, cboxLoaiThongKe;
    private DefaultTableModel tableModel;
    private JTable table;

    public ThongKeHoaDonGUI() {
        thongKeDAO = new ThongKeDAO();
        initComponents();
        loadSummaryData();
        loadTableData();
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

        lblTongSoHoaDon = new JLabel("Tổng số hóa đơn: 0");
        lblTongSoHoaDon.setBounds(20, 30, 300, 40);
        lblTongSoHoaDon.setFont(new Font("Arial", Font.PLAIN, 16));
        pSummary.add(lblTongSoHoaDon);

        lblTongGiaTri = new JLabel("Tổng giá trị: 0đ");
        lblTongGiaTri.setBounds(420, 30, 300, 40);
        lblTongGiaTri.setFont(new Font("Arial", Font.PLAIN, 16));
        pSummary.add(lblTongGiaTri);

        lblSoLuongSanPham = new JLabel("Số lượng sản phẩm: 0");
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

        txtTuNgay = new JTextField();
        txtTuNgay.setBounds(100, 15, 120, 30);
        pFilter.add(txtTuNgay);

        JLabel lblDenNgay = new JLabel("Đến ngày:");
        lblDenNgay.setBounds(240, 15, 80, 30);
        lblDenNgay.setFont(new Font("Arial", Font.PLAIN, 14));
        pFilter.add(lblDenNgay);

        txtDenNgay = new JTextField();
        txtDenNgay.setBounds(320, 15, 120, 30);
        pFilter.add(txtDenNgay);

        // Lọc Theo năm
        JLabel lblTheoNam = new JLabel("Chọn năm:");
        lblTheoNam.setBounds(460, 15, 80, 30);
        lblTheoNam.setFont(new Font("Arial", Font.PLAIN, 14));
        pFilter.add(lblTheoNam);

        String[] years = {"2025", "2024", "2023", "2022", "2021"};
        cboxNam = new JComboBox<>(years);
        cboxNam.setBounds(540, 15, 80, 30);
        pFilter.add(cboxNam);

        // Chọn loại thống kê
        JLabel lblLoaiThongKe = new JLabel("Loại thống kê:");
        lblLoaiThongKe.setBounds(640, 15, 100, 30);
        lblLoaiThongKe.setFont(new Font("Arial", Font.PLAIN, 14));
        pFilter.add(lblLoaiThongKe);

        String[] loaiThongKe = {"Theo tháng", "Theo khách hàng", "Theo nhân viên", "Theo sản phẩm"};
        cboxLoaiThongKe = new JComboBox<>(loaiThongKe);
        cboxLoaiThongKe.setBounds(740, 15, 150, 30);
        pFilter.add(cboxLoaiThongKe);

        JButton btnFilter = new JButton("Lọc");
        btnFilter.setBounds(960, 15, 100, 30);
        btnFilter.setFont(new Font("Arial", Font.PLAIN, 14));
        pFilter.add(btnFilter);

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
        String[] columnNames = {"Tháng/Mã", "Số lượng hóa đơn/Tên", "Tổng giá trị", "Số lượng sản phẩm"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 460, 1188, 200);
        add(scrollPane);

        // Sự kiện nút Lọc
        btnFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadTableData();
                loadSummaryData();
            }
        });

        // Sự kiện nút Xuất Excel
        btnXuatExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportToExcel();
            }
        });
    }

    private void loadSummaryData() {
        String startDate = txtTuNgay.getText().trim().isEmpty() ? null : txtTuNgay.getText();
        String endDate = txtDenNgay.getText().trim().isEmpty() ? null : txtDenNgay.getText();

        String summary = thongKeDAO.statisticSummary(startDate, endDate);
        if (!summary.isEmpty()) {
            String[] parts = summary.split("_");
            DecimalFormat df = new DecimalFormat("#,###");
            lblTongSoHoaDon.setText("Tổng số hóa đơn: " + parts[0]);
            lblTongGiaTri.setText("Tổng giá trị: " + df.format(Long.parseLong(parts[1])) + "đ");
            lblSoLuongSanPham.setText("Số lượng sản phẩm: " + parts[2]);
        }
    }

    private void loadTableData() {
        String startDate = txtTuNgay.getText().trim().isEmpty() ? null : txtTuNgay.getText();
        String endDate = txtDenNgay.getText().trim().isEmpty() ? null : txtDenNgay.getText();
        String year = (String) cboxNam.getSelectedItem();
        String loaiThongKe = (String) cboxLoaiThongKe.getSelectedItem();

        // Xóa dữ liệu cũ
        tableModel.setRowCount(0);

        DecimalFormat df = new DecimalFormat("#,###");
        if (loaiThongKe.equals("Theo tháng")) {
            // Cập nhật tiêu đề cột
            tableModel.setColumnIdentifiers(new String[]{"Tháng", "Số lượng hóa đơn", "Tổng giá trị", "Số lượng sản phẩm"});
            ArrayList<String> data = thongKeDAO.statisticByMonth(Integer.parseInt(year));
            for (String row : data) {
                String[] parts = row.split("_");
                tableModel.addRow(new Object[]{
                    "Tháng " + parts[0],
                    parts[1],
                    df.format(Long.parseLong(parts[2])) + "đ",
                    parts[3]
                });
            }
        } else {
            // Cập nhật tiêu đề cột
            tableModel.setColumnIdentifiers(new String[]{"Mã", "Tên", "Tổng giá trị", "Số lượng sản phẩm"});
            ArrayList<String> data = new ArrayList<>();
            switch (loaiThongKe) {
                case "Theo khách hàng":
                    data = thongKeDAO.statisticByCustomerByDateRange(startDate, endDate);
                    break;
                case "Theo nhân viên":
                    data = thongKeDAO.statisticByEmployeeByDateRange(startDate, endDate);
                    break;
                case "Theo sản phẩm":
                    data = thongKeDAO.statisticByProductByDateRange(startDate, endDate);
                    break;
            }
            for (String row : data) {
                String[] parts = row.split("_");
                tableModel.addRow(new Object[]{
                    parts[0],
                    parts[1],
                    df.format(Long.parseLong(parts[2])) + "đ",
                    "-"
                });
            }
        }
    }

    private void exportToExcel() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Thống Kê Hóa Đơn");

        // Tạo hàng tiêu đề
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(tableModel.getColumnName(i));
        }

        // Thêm dữ liệu
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(tableModel.getValueAt(i, j).toString());
            }
        }

        // Ghi file
        try (FileOutputStream fileOut = new FileOutputStream("ThongKeHoaDon.xlsx")) {
            workbook.write(fileOut);
            JOptionPane.showMessageDialog(this, "Xuất Excel thành công!");
            workbook.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi xuất Excel: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}