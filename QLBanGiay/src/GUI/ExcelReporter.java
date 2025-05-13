package GUI;

import java.awt.FileDialog;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReporter {

    /**
     * Hiển thị hộp thoại FileDialog để chọn file Excel (dùng cho nhập hoặc xuất).
     *
     * @param parentFrame JFrame cha để căn giữa hộp thoại
     * @param title Tiêu đề của hộp thoại
     * @param mode Chế độ của FileDialog (FileDialog.LOAD hoặc FileDialog.SAVE)
     * @param defaultFileName Tên tệp mặc định
     * @return File được chọn, hoặc null nếu người dùng hủy
     */
    private static File showFileDialog(JFrame parentFrame, String title, int mode, String defaultFileName) {
        FileDialog fd = new FileDialog(parentFrame, title, mode);
        fd.pack();
        fd.setSize(800, 600);
        fd.validate();
        Rectangle rect = parentFrame.getContentPane().getBounds();
        double width = fd.getBounds().getWidth();
        double height = fd.getBounds().getHeight();
        double x = rect.getCenterX() - (width / 2);
        double y = rect.getCenterY() - (height / 2);
        Point leftCorner = new Point();
        leftCorner.setLocation(x, y);
        fd.setLocation(leftCorner);
        fd.setFile(defaultFileName);
        fd.setVisible(true);

        String filePath = fd.getDirectory() + fd.getFile();
        if (filePath.equals("nullnull")) {
            return null;
        }
        return new File(filePath);
    }

    /**
     * Xuất dữ liệu từ JTable sang file Excel (.xlsx) với đường dẫn do người dùng chọn.
     *
     * @param table JTable chứa dữ liệu cần xuất
     * @throws IOException Nếu có lỗi khi ghi file
     */
    public static void exportJTableToExcel(JTable table) throws IOException {
        JFrame jf = new JFrame();
        File selectedFile = showFileDialog(jf, "Chọn đường dẫn lưu file Excel", FileDialog.SAVE, "export.xlsx");

        if (selectedFile == null) {
            return; // Người dùng hủy
        }

        String filePath = selectedFile.getAbsolutePath();
        if (!filePath.toLowerCase().endsWith(".xlsx")) {
            filePath += ".xlsx";
        }

        TableModel model = table.getModel();
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Sheet1");

            // Tạo hàng tiêu đề
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < model.getColumnCount(); i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(model.getColumnName(i));
            }

            // Tạo các hàng dữ liệu
            for (int i = 0; i < model.getRowCount(); i++) {
                Row row = sheet.createRow(i + 1);
                for (int j = 0; j < model.getColumnCount(); j++) {
                    Cell cell = row.createCell(j);
                    Object value = model.getValueAt(i, j);
                    cell.setCellValue(value != null ? value.toString() : "");
                }
            }

            // Tự động điều chỉnh kích thước cột
            for (int i = 0; i < model.getColumnCount(); i++) {
                sheet.autoSizeColumn(i);
            }

            // Ghi file
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
                JOptionPane.showMessageDialog(null, "Xuất file Excel thành công tại " + filePath,
                        "Thành công", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi xuất file Excel: " + e.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
            throw e;
        }
    }

    /**
     * Hiển thị hộp thoại để chọn file Excel nhập (.xlsx hoặc .xls).
     *
     * @param parentFrame JFrame cha để căn giữa hộp thoại
     * @return File được chọn, hoặc null nếu người dùng hủy hoặc file không hợp lệ
     */
    public static File selectExcelFileForImport(JFrame parentFrame) {
        File selectedFile = showFileDialog(parentFrame, "Chọn file Excel để nhập", FileDialog.LOAD, "import.xlsx");

        if (selectedFile == null) {
            return null; // Người dùng hủy
        }

        String filePath = selectedFile.getAbsolutePath();
        if (!filePath.toLowerCase().endsWith(".xlsx") && !filePath.toLowerCase().endsWith(".xls")) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn file Excel (.xlsx hoặc .xls)!", 
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return selectedFile;
    }
}