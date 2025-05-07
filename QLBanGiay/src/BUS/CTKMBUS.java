package BUS;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date; 

import DAO.CTKMDAO;
import DAO.SanPhamDAO;
import DTO.CTKMDTO;
import DTO.SanPhamDTO;

public class CTKMBUS {
    private ArrayList<CTKMDTO> listKhuyenMai;
    private CTKMDAO khuyenMaiDAO = new CTKMDAO(); // ✅ BỔ SUNG BIẾN DAO

<<<<<<< HEAD
    public void docDSCTKM() {
        if (listKhuyenMai == null) {
            listKhuyenMai = new ArrayList<>();
=======
	public ArrayList<CTKMDTO> getListKhuyenMai() {
		return listKhuyenMai;
	}

	public void setListKhuyenMai(ArrayList<CTKMDTO> listKhuyenMai) {
		this.listKhuyenMai = listKhuyenMai;
	}
	
	public boolean checkMaCTKMexist(String maCTKM) {
		for(CTKMDTO x : listKhuyenMai) {
			if(x.getMaCTKM().equalsIgnoreCase(maCTKM)) {
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

	
	
	
	public boolean themKhuyenMai(String maCTKM, Date ngayBD, Date ngayKT, String tenCTKM, String loaiKM, String maSPorHD, float phanTram) {
	    try {
	        CTKMDTO khuyenMai = new CTKMDTO(maCTKM, new java.sql.Date(ngayBD.getTime()), new java.sql.Date(ngayKT.getTime()), tenCTKM, phanTram);
	        khuyenMaiDAO.addkhuyenMaiDAO(khuyenMai);

	        if (loaiKM.equals("Sản Phẩm")) {
	        	khuyenMaiDAO.addCTKM_SP(maCTKM, maSPorHD, phanTram);
	        } else {
	        	khuyenMaiDAO.addCTKM_HD(maCTKM, maSPorHD, phanTram);
	        }

	        listKhuyenMai.add(khuyenMai); // cập nhật list trong BUS
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public void updateCTKM(CTKMDTO ctkm, String loaiCTKMCu, String loaiCTKM, String maSPorHD, double phanTramValue,String maSPorHDCu, int index) {
	    // Cập nhật thông tin của chương trình khuyến mãi trong danh sách
		listKhuyenMai.set(index, ctkm);

	    // Gọi DAO để cập nhật vào cơ sở dữ liệu
		khuyenMaiDAO.updateCTKMDAO(ctkm,loaiCTKMCu,loaiCTKM,maSPorHD,maSPorHDCu,phanTramValue);
	}




	
	public void deleteKhuyenMai(int index) {
		CTKMDTO khuyenMai = listKhuyenMai.get(index);
		listKhuyenMai.remove(index);
		khuyenMaiDAO.deletekhuyenMaiDAO(khuyenMai);
	}
	
	public ArrayList<CTKMDTO> searchKhuyenMai(String key, String keyword) {
		ArrayList<CTKMDTO> result = new ArrayList<CTKMDTO>();
		
		for(CTKMDTO x : listKhuyenMai) {
			if(key.equals("Mã chương trình khuyến mãi") && keyword.equals(x.getMaCTKM()))
				result.add(x);
		}
		return result;
	}

	
	 // Thêm phương thức để lấy danh sách MaSP
    public ArrayList<String> getListMaSP() throws SQLException {
        if (khuyenMaiDAO == null) {
            throw new IllegalStateException("CTKMDAO chưa được khởi tạo!");
>>>>>>> 71dc5ef386b31b110de73ddde7dd6901ae790032
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
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
}
=======
>>>>>>> Stashed changes
=======
<<<<<<< HEAD
}
=======
>>>>>>> Stashed changes
    
    public CTKMDTO getCTKM_HD(Date ngayLap) throws SQLException {
    	return khuyenMaiDAO.getCTKM_HD(ngayLap);
    }
    
}	
>>>>>>> 71dc5ef386b31b110de73ddde7dd6901ae790032
