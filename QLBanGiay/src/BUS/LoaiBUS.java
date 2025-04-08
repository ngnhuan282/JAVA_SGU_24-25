package BUS;

import java.util.ArrayList;
import DAO.LoaiDAO;
import DTO.LoaiDTO;

public class LoaiBUS {
    private static ArrayList<LoaiDTO> dsloai;

    public LoaiBUS() {
        // Không khởi tạo sẵn dsloai trong constructor
    }

    public static ArrayList<LoaiDTO> getDsloai() {
        return dsloai;
    }

    public static void setDsloai(ArrayList<LoaiDTO> dsloai) {
        LoaiBUS.dsloai = dsloai;
    }

    public void docDSLoai() {
        if (dsloai == null) 
            dsloai = new ArrayList<>();
        
        LoaiDAO loaiDAO = new LoaiDAO();
        dsloai = loaiDAO.docDSLoai();
    }

    public void add(LoaiDTO loai) 
    {
        if (loai.getTenLoaiSP() == null || loai.getTenLoaiSP().trim().isEmpty()) 
            return; 
        
        if (dsloai == null) 
            dsloai = new ArrayList<>(); // Khởi tạo nếu chưa có
        
        LoaiDAO loaiDAO = new LoaiDAO();
        loaiDAO.add(loai);
        dsloai = loaiDAO.docDSLoai();
    }

    public void update(LoaiDTO loai) 
    {
        if (dsloai == null || dsloai.isEmpty()) 
            return; 
        
        for (int i = 0; i < dsloai.size(); i++) 
        {
            if (dsloai.get(i).getMaLoaiSP() == loai.getMaLoaiSP()) 
            {
                LoaiDAO loaiDAO = new LoaiDAO();
                loaiDAO.update(loai);
                dsloai.set(i, loai);
                return;
            }
        }
    }

    public void delete(int maLoaiSP) 
    {
        if (dsloai == null || dsloai.isEmpty()) 
            return; 
        
        for (int i = 0; i < dsloai.size(); i++) 
        {
            if (dsloai.get(i).getMaLoaiSP() == maLoaiSP)
            {
                LoaiDAO loaiDAO = new LoaiDAO();
                loaiDAO.delete(maLoaiSP);
                dsloai.remove(i);
                return;
            }
        }
    }
}