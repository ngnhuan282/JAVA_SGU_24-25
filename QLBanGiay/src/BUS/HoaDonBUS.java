package BUS;

import java.util.ArrayList;

import DTO.HoaDonDTO;

public class HoaDonBUS {
	private ArrayList<HoaDonDTO> listHoaDon;
	
	public HoaDonBUS() {
		listHoaDon = new ArrayList<HoaDonDTO>();
	}

	public ArrayList<HoaDonDTO> getListHoaDon() {
		return listHoaDon;
	}

	public void setListHoaDon(ArrayList<HoaDonDTO> listHoaDon) {
		this.listHoaDon = listHoaDon;
	}
	
	public String getMaHD() {
		return "HD" + listHoaDon.size() + 1;
	}
	

}
