package BUS;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.NhanVienDAO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;

public class NhanVienBUS {
	private ArrayList<NhanVienDTO> listNhanVien;
	private NhanVienDAO nhanVienDAO = new NhanVienDAO();
	
	public NhanVienBUS() throws SQLException {
		listNhanVien = new ArrayList<NhanVienDTO>();
		listNhanVien = nhanVienDAO.getListNhanVien();
	}

	public ArrayList<NhanVienDTO> getListNhanVien() {
		return listNhanVien;
	}

	public void setListNhanVien(ArrayList<NhanVienDTO> listNhanVien) {
		this.listNhanVien = listNhanVien;
	}
	
	public boolean checkmanvStaff(String maNV) { 
		for(NhanVienDTO x : listNhanVien) {
			if(x.getMaNV() == maNV) {
				return true;
			}
		}
		return false;
	}
	
	public void addStaff(String maNV, String ho, String ten, String sdt,double luong) {
		NhanVienDTO nhanVien = new NhanVienDTO();
		nhanVien.setMaNV(maNV);
		nhanVien.setHo(ho);
		nhanVien.setTen(ten);
		nhanVien.setSdt(sdt);
		nhanVien.setLuong(luong);
		listNhanVien.add(nhanVien);
		nhanVienDAO.addNhanVienDAO(nhanVien);
	}
	
	public void fixStaff(String maNV, String ho, String ten, String sdt,double luong,int index) {
		NhanVienDTO nv = listNhanVien.get(index);
		nv.setMaNV(maNV);
		nv.setHo(ho);
		nv.setTen(ten);
		nv.setSdt(sdt);
		nv.setLuong(luong);
		nhanVienDAO.updateNhanVienDAO(nv);
	}

	
}
