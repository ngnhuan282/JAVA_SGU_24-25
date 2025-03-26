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
	
	public boolean checkCustomer(String maKh) { // trả về true nếu makh đã tồn tại
		for(KhachHangDTO x : listKhachHang) {
			if(x.getMaKH() == Integer.valueOf(maKh)) {
				return true;
			}
		}
		return false;
	}
	
	public void addCustomer(String maKh, String ho, String ten, String diaChi, String sdt) {
		KhachHangDTO khachHang = new KhachHangDTO();
		khachHang.setMaKH(Integer.valueOf(maKh));
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
