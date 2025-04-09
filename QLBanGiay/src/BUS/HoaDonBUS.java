package BUS;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;

public class HoaDonBUS {
	private ArrayList<HoaDonDTO> listHoaDon;
	private HoaDonDAO hoaDonDAO = new HoaDonDAO();
	
	public HoaDonBUS() throws SQLException {
		listHoaDon = new ArrayList<HoaDonDTO>();
		listHoaDon = hoaDonDAO.getListHoaDon();
	}

	public ArrayList<HoaDonDTO> getListHoaDon() {
		return listHoaDon;
	}

	public void setListHoaDon(ArrayList<HoaDonDTO> listHoaDon) {
		this.listHoaDon = listHoaDon;
	}
	
	public String getMaHD() {
		int size = listHoaDon.size() + 1;
		String maHD = "HD0" + size;
		while(checkDuplicateMaHD(maHD)) {
			size++;
			maHD = "HD0" + size;
		}
		return maHD;
	}
	
	public boolean checkDuplicateMaHD(String maHD) {
		for(HoaDonDTO x : listHoaDon) {
			if(x.getMaHD().equals(maHD))
				return true;
		}
		return false;
	}
	
	public void addHoaDon(String maHD, String maKH, String maNV, Date ngayLap, double tongTien) {
		HoaDonDTO hoaDon = new HoaDonDTO(maHD, maKH, maNV, ngayLap, tongTien);
		listHoaDon.add(hoaDon);
		hoaDonDAO.addHoaDon(hoaDon);
	}
	
	public void updateHoaDon(String maHD, String maKH, String maNV, Date ngayLap, double tongTien, int index) {
		HoaDonDTO hoaDon = listHoaDon.get(index);
		hoaDon.setMaHD(maHD);
		hoaDon.setMaKH(maKH);
		hoaDon.setMaNV(maNV);
		hoaDon.setNgayLap(ngayLap);
		hoaDon.setTongTien(tongTien);
		hoaDonDAO.updateHoaDon(hoaDon);
	}
	
	public void updateTongTien(String maHD, double tongTien, int index) {
		HoaDonDTO hoaDon = listHoaDon.get(index);
		hoaDon.setTongTien(tongTien);
		hoaDonDAO.updateTongTien(hoaDon);
	}
	
	public void deleteHoaDon(int index) {
		HoaDonDTO hoaDon = listHoaDon.get(index);
		listHoaDon.remove(index);
		hoaDonDAO.deleteHoaDon(hoaDon);
	}
}
