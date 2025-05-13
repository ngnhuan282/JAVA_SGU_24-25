package BUS;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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

            // Chỉ thêm nếu ít nhất 1 trong 2 ô được nhập và có khớp
            if ((!maCTKM.isEmpty() || !maSPorHD.isEmpty()) && (matchMaCTKM || matchMaSPorHD)) {
                resultList.add(ctkm);
            }
        }

        return resultList;
    }

    
    public int[] ImportExcel(File file) 
    {
       CTKMDAO ctkmDAO = new CTKMDAO();
       int[] result = ctkmDAO.ImportExcel(file);
        docDSCTKM();
        return result;
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
