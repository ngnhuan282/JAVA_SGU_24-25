package BUS;

import java.util.ArrayList;

import DTO.ChiTietHDDTO;

public class ChiTietHoaDonBUS {
	private ArrayList<ChiTietHDDTO> listCTHD;
	
	public ChiTietHoaDonBUS() {
		listCTHD = new ArrayList<ChiTietHDDTO>();
	}

	public ArrayList<ChiTietHDDTO> getListCTHD() {
		return listCTHD;
	}

	public void setListCTHD(ArrayList<ChiTietHDDTO> listCTHD) {
		this.listCTHD = listCTHD;
	}
	
	public void addCTHD(String maHD, String maSP, int soLuong, double donGia, double thanhTien) {
		ChiTietHDDTO chiTietHDDTO = new ChiTietHDDTO(maHD, maSP, maSP, donGia, thanhTien);
		listCTHD.add(chiTietHDDTO);
	}
}
