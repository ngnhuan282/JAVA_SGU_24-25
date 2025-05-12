package BUS;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.List;
import com.mysql.cj.result.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date; 

import DAO.CTKMDAO;
import DAO.SanPhamDAO;
import DTO.CTKMDTO;
import DTO.SanPhamDTO;

public class CTKMBUS {
    private ArrayList<CTKMDTO> listKhuyenMai;
    private CTKMDAO khuyenMaiDAO = new CTKMDAO(); // ✅ BỔ SUNG BIẾN DAO

    public void docDSCTKM() {
        if (listKhuyenMai == null) {
            listKhuyenMai = new ArrayList<>();
        }
        listKhuyenMai = khuyenMaiDAO.docDSCTKM();
    }

    public ArrayList<CTKMDTO> getListKhuyenMai() {
        return listKhuyenMai;
    }

    public void setListKhuyenMai(ArrayList<CTKMDTO> listKhuyenMai) {
        this.listKhuyenMai = listKhuyenMai;
    }

    public boolean checkMaCTKMexist(String maCTKM) {
        for (CTKMDTO x : listKhuyenMai) {
            if (x.getMaCTKM().equalsIgnoreCase(maCTKM)) {
                return true;
            }
        }
        return false;
    }

    public boolean isNgayKTAfterNgayBD(java.util.Date ngayBD, java.util.Date ngayKT) {
        if (ngayBD == null || ngayKT == null) {
            return false;
        }
        return ngayKT.after(ngayBD);
    }

    public boolean themKhuyenMai(String maCTKM, Date ngayBD, Date ngayKT, String tenCTKM, String loaiKM, String maSPorHD, double phanTram) {
        try {
            CTKMDTO khuyenMai = new CTKMDTO(maCTKM, new java.sql.Date(ngayBD.getTime()), new java.sql.Date(ngayKT.getTime()), tenCTKM);
            khuyenMaiDAO.addkhuyenMaiDAO(khuyenMai);

            if (loaiKM.equals("Sản Phẩm")) {
                khuyenMaiDAO.addCTKM_SP(maCTKM, maSPorHD, phanTram);
            } else {
                khuyenMaiDAO.addCTKM_HD(maCTKM, maSPorHD, phanTram);
            }

            listKhuyenMai.add(khuyenMai);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void updateCTKM(CTKMDTO ctkm, String loaiCTKMCu, String loaiCTKM, String maSPorHD, double phanTramValue, String maSPorHDCu, int index) {
        listKhuyenMai.set(index, ctkm);
        khuyenMaiDAO.updateCTKMDAO(ctkm, loaiCTKMCu, loaiCTKM, maSPorHD, maSPorHDCu, phanTramValue);
    }

    public void deleteKhuyenMaiByIndex(int index) {
        try {
            String maCTKM = listKhuyenMai.get(index).getMaCTKM();
            khuyenMaiDAO.deleteKhuyenMaiDAO(maCTKM);
            listKhuyenMai.remove(index);
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi xóa chương trình khuyến mãi: " + e.getMessage());
        }
    }

    public ArrayList<CTKMDTO> searchKhuyenMai(String keyword, String loaiSearch) {
        return khuyenMaiDAO.searchKhuyenMai(keyword, loaiSearch);
    }
    
    public ArrayList<CTKMDTO> searchKhuyenMaiNangCao(String maCTKM, String maSPorHD) {
        ArrayList<CTKMDTO> resultList = new ArrayList<>();

        for (CTKMDTO ctkm : listKhuyenMai) {
            boolean matchMaCTKM = !maCTKM.isEmpty() && ctkm.getMaCTKM().equalsIgnoreCase(maCTKM);
            boolean matchMaSPorHD = false;

            if (!maSPorHD.isEmpty()) {
                String maSP = layMaSPorHD(ctkm.getMaCTKM());
                if (maSP != null && maSP.equalsIgnoreCase(maSPorHD)) {
                    matchMaSPorHD = true;
                }
            }

            if (!maCTKM.isEmpty() && !maSPorHD.isEmpty()) {
                if (matchMaCTKM && matchMaSPorHD) {
                    resultList.add(ctkm);
                }
            } else if (!maCTKM.isEmpty() || !maSPorHD.isEmpty()) {
                if (matchMaCTKM || matchMaSPorHD) {
                    resultList.add(ctkm);
                }
            }
        }

        return resultList;
    }
    
    public int[] ImportExcel(File file) throws Exception {
	    ArrayList<CTKMDTO> importedList = new ArrayList<>();
	    FileInputStream fis = new FileInputStream(file);
	    Workbook workbook = WorkbookFactory.create(fis);
	    Sheet sheet = (Sheet) workbook.getSheetAt(0);

	    int added = 0;
	    int updated = 0;

	    for (int i = 1; i <= ((XSSFSheet) sheet).getLastRowNum(); i++) {
	        Row row = (Row) ((XSSFSheet) sheet).getRow(i);
	        if (row == null) continue;

	        String maCTKM = ((XSSFRow) row).getCell(0).getStringCellValue();
	        String tenCTKM = ((XSSFRow) row).getCell(1).getStringCellValue();
	        Date ngayBD = (Date) ((XSSFRow) row).getCell(2).getDateCellValue();
	        Date ngayKT = (Date) ((XSSFRow) row).getCell(3).getDateCellValue();
	        String loaiKM = ((XSSFRow) row).getCell(4).getStringCellValue().trim();  // "Hóa Đơn" hoặc "Sản Phẩm"
	        String maSPorHD = ((XSSFRow) row).getCell(5).getStringCellValue();
	        
	        float phanTram = 0;
	        XSSFCell cellPhanTram = ((XSSFRow) row).getCell(6);
	        if (cellPhanTram != null) {
	            if (cellPhanTram.getCellType() == CellType.NUMERIC) {
	                phanTram = (float) cellPhanTram.getNumericCellValue();
	            } else if (cellPhanTram.getCellType() == CellType.STRING) {
	                try {
	                    phanTram = Float.parseFloat(cellPhanTram.getStringCellValue().replace("%", "").trim());
	                } catch (NumberFormatException e) {
	                    System.err.println("Lỗi đọc phần trăm ở dòng " + (i + 1));
	                }
	            }
	        }

	        CTKMDTO dto = new CTKMDTO(maCTKM, ngayBD, ngayKT, tenCTKM, phanTram);

	        if (checkMaCTKMexist(maCTKM)) {
	            // Cập nhật CTKM
	            int index = findIndex(maCTKM);
	            updateCTKM(dto, layLoaiKhuyenMai(maCTKM), loaiKM, maSPorHD, phanTram, layMaSPorHD(maCTKM), index);
	            updated++;
	        } else {
	            // Thêm mới CTKM + thêm dòng vào ctkm_sp hoặc ctkm_hd
	            themKhuyenMai(maCTKM, new java.sql.Date(ngayBD.getTime()), new java.sql.Date(ngayKT.getTime()), tenCTKM, loaiKM, maSPorHD, phanTram);
	            added++;
	        }
	    }

	    workbook.close();
	    fis.close();
	    return new int[]{added, updated};
	}
    

    public void xuatExcelCTKM() {
        XSSFWorkbook workbook = new XSSFWorkbook();  // Tạo workbook mới
        Sheet sheet = (Sheet) workbook.createSheet("CTKM");  // Tạo sheet mới

        // Tạo hàng tiêu đề cho bảng Excel
        Row headerRow = (Row) ((XSSFSheet) sheet).createRow(0);
        ((XSSFRow) headerRow).createCell(0).setCellValue("Mã CTKM");
        ((XSSFRow) headerRow).createCell(1).setCellValue("Tên CTKM");
        ((XSSFRow) headerRow).createCell(2).setCellValue("Ngày Bắt Đầu");
        ((XSSFRow) headerRow).createCell(3).setCellValue("Ngày Kết Thúc");
        ((XSSFRow) headerRow).createCell(4).setCellValue("Phần Trăm Giảm Giá");

        // Điền dữ liệu từ listKhuyenMai vào Excel
        for (int i = 0; i < listKhuyenMai.size(); i++) {
            CTKMDTO ctkm = listKhuyenMai.get(i);
            Row row = (Row) ((XSSFSheet) sheet).createRow(i + 1);  // Tạo một hàng mới cho mỗi chương trình khuyến mãi

            ((XSSFRow) row).createCell(0).setCellValue(ctkm.getMaCTKM());
            ((XSSFRow) row).createCell(1).setCellValue(ctkm.getTenCTKM());
            ((XSSFRow) row).createCell(2).setCellValue(ctkm.getNgayBD().toString());  // Chuyển ngày sang chuỗi
            ((XSSFRow) row).createCell(3).setCellValue(ctkm.getNgayKT().toString());  // Chuyển ngày sang chuỗi
            ((XSSFRow) row).createCell(4).setCellValue(ctkm.getPhanTramGiamGia());
        }

        // Tạo một file để lưu dữ liệu
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Lưu Excel");
        fileChooser.setSelectedFile(new File("CTKM.xlsx"));

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            FileOutputStream fos = null;
            try {
                // Lưu workbook vào file
                File file = fileChooser.getSelectedFile();
                fos = new FileOutputStream(file);
                workbook.write(fos);
                JOptionPane.showMessageDialog(null, "Xuất Excel thành công!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Lỗi khi xuất file Excel: " + e.getMessage(),
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (fos != null) fos.close();
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    
    public int findIndex(String maCTKM) {
        for (int i = 0; i < listKhuyenMai.size(); i++) {
            if (listKhuyenMai.get(i).getMaCTKM().equalsIgnoreCase(maCTKM)) {
                return i;  // Trả về chỉ số nếu tìm thấy
            }
        }
        return -1;  // Trả về -1 nếu không tìm thấy
    }




    public String layLoaiKhuyenMai(String maCTKM) {
        return khuyenMaiDAO.layLoaiKhuyenMai(maCTKM);
    }

    public String layMaSPorHD(String maCTKM) {
        return khuyenMaiDAO.layMaSPorHD(maCTKM);
    }

    public String layPhanTram(String maCTKM) {
        return khuyenMaiDAO.layPhanTram(maCTKM);
    }

    public String getMaCTKM() {
        return null;
    }

    public ArrayList<String> getListMaSP() throws SQLException {
        return khuyenMaiDAO.getListMaSP();
    }

    public ArrayList<String> getListMaHD() throws SQLException {
        return khuyenMaiDAO.getListMaHD();
    }
    public CTKMDTO getCTKM_HD(Date ngayLap) throws SQLException {
    	return khuyenMaiDAO.getCTKM_HD(ngayLap);
    }

	
}
