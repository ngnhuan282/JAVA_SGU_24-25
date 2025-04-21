package GUI;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
    public static void main(String[] args) {
        // Disable Log4j2 warnings

        String inputFilePath = "/Sample.xlsx"; // Resource path in GUI package
        // Absolute path for Output.xlsx in project root
        String outputFilePath = new File("/Output.xlsx").getAbsolutePath();

        try (InputStream is = ReadExcel.class.getResourceAsStream(inputFilePath);
             Workbook workbook = new XSSFWorkbook(is)) {

            // Lấy sheet đầu tiên
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter dataFormatter = new DataFormatter();

            // In dữ liệu từ file input
            System.out.println("Reading Sample.xlsx:");
            for (Row row : sheet) {
                for (Cell cell : row) {
                    String cellValue = dataFormatter.formatCellValue(cell);
                    System.out.print(cellValue + "\t");
                }
                System.out.println();
            }

            // Thêm cột mới "Trạng thái"
            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                headerRow = sheet.createRow(0);
            }
            Cell statusHeader = headerRow.createCell(headerRow.getLastCellNum());
            statusHeader.setCellValue("Trạng thái");

            // Thêm dữ liệu mẫu cho cột "Trạng thái"
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    row = sheet.createRow(i);
                }
                Cell statusCell = row.createCell(headerRow.getLastCellNum() - 1);
                statusCell.setCellValue("Hoạt động");
            }

            // Ghi vào file Output.xlsx
            try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
                workbook.write(fos);
                System.out.println("\nFile Output.xlsx đã được tạo tại: " + outputFilePath);
            } catch (IOException e) {
                System.err.println("Lỗi khi ghi file Output.xlsx: " + e.getMessage());
            }

        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file Sample.xlsx: " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("Không tìm thấy file Sample.xlsx trong package GUI");
        }
    }
}