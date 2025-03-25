package BUS;

import java.util.ArrayList;

import DTO.KhachHangDTO;

public class KhachHangBUS {
	private ArrayList<KhachHangDTO> listKhachHang;
	
	public KhachHangBUS() {
		listKhachHang = new ArrayList<KhachHangDTO>();
	}

	public ArrayList<KhachHangDTO> getListKhachHang() {
		return listKhachHang;
	}

	public void setListKhachHang(ArrayList<KhachHangDTO> listKhachHang) {
		this.listKhachHang = listKhachHang;
	}
	
	public void addCustomer(String maKh, String ho, String ten, String diaChi, String sdt) {
		KhachHangDTO khachHang = new KhachHangDTO();
		khachHang.setMaKH(Integer.valueOf(maKh));
		khachHang.setHo(ho);
		khachHang.setTen(ten);
		khachHang.setDiaChi(diaChi);
		khachHang.setSdt(sdt);
		listKhachHang.add(khachHang);
	}
	
	public void updateCustomer(String maKh, String ho, String ten, String diaChi, String sdt, int index) {
		KhachHangDTO khachHang = listKhachHang.get(index);
		khachHang.setMaKH(Integer.valueOf(maKh));
		khachHang.setHo(ho);
		khachHang.setTen(ten);
		khachHang.setDiaChi(diaChi);
		khachHang.setSdt(sdt);
	}
	
	public void deleteCustomer(int index) {
		listKhachHang.remove(index);
	}
}	
