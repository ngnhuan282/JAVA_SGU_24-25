package BUS;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;

public class KhachHangBUS {
	private ArrayList<KhachHangDTO> listKhachHang;
	private KhachHangDAO khachHangDAO = new KhachHangDAO();
	
	public KhachHangBUS() throws SQLException {
		listKhachHang = new ArrayList<KhachHangDTO>();
		
		listKhachHang = khachHangDAO.getListKhachHang();
	}

	public ArrayList<KhachHangDTO> getListKhachHang() {
		return listKhachHang;
	}

	public void setListKhachHang(ArrayList<KhachHangDTO> listKhachHang) {
		this.listKhachHang = listKhachHang;
	}
	
	public boolean checkCustomerExist(String maKh) { // trả về true nếu makh đã tồn tại
		for(KhachHangDTO x : listKhachHang) {
			if(x.getMaKH().equals(maKh)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkRegexId(String maKh) {
		String regex = "KH\\d{3,6}$";
		if(maKh.matches(regex))
			return true;
		return false;
	}
	
	public boolean checkRegexSdt(String sdt) {
		String regex = "^(01|02|03|04|05|06|07|08|09)\\d{8,9}$";
		String regex2 = "^\\+\\d{1,3}\\d{4,14}(?:x\\d+)?$";
		if(sdt.matches(regex) || sdt.matches(regex2))
			return true;
		return false;
	}
	
	public boolean checkRegexHo(String ho) {
		String regex = "^[^\\d]*$";
		if(ho.matches(regex)) {
			return true;
		}
		return false;
	}
	
	public boolean checkRegexTen(String ten) {
		String regex = "^[^\\d]*$";
		if(ten.matches(regex)) {
			return true;
		}
		return false;
	}
	
	public void addCustomer(String maKh, String ho, String ten, String diaChi, String sdt) {
		KhachHangDTO khachHang = new KhachHangDTO();
		khachHang.setMaKH(maKh);
		khachHang.setHo(ho);
		khachHang.setTen(ten);
		khachHang.setDiaChi(diaChi);
		khachHang.setSdt(sdt);
		listKhachHang.add(khachHang);
		khachHangDAO.addKhachHangDAO(khachHang);
	}
	
	public void updateCustomer(String ho, String ten, String diaChi, String sdt, int index) {
		KhachHangDTO khachHang = listKhachHang.get(index);
		khachHang.setHo(ho);
		khachHang.setTen(ten);
		khachHang.setDiaChi(diaChi);
		khachHang.setSdt(sdt);
		khachHangDAO.updateKhachHangDAO(khachHang);
	}
	
	public void deleteCustomer(int index) {
		KhachHangDTO khachHang = listKhachHang.get(index);
		listKhachHang.remove(index);
		khachHangDAO.deleteKhachHangDAO(khachHang);
	}
}	
