package BUS;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date; 

import DAO.CTKMDAO;
import DTO.CTKMDTO;

public class CTKMBUS {
	private ArrayList<CTKMDTO> listKhuyenMai;
	private CTKMDAO khuyenMaiDAO = new CTKMDAO();
	
	public CTKMBUS() throws SQLException {
		listKhuyenMai = new ArrayList<CTKMDTO>();
		
		listKhuyenMai = khuyenMaiDAO.getListkhuyenMai();
	}

	public ArrayList<CTKMDTO> getListKhuyenMai() {
		return listKhuyenMai;
	}

	public void setListKhuyenMai(ArrayList<CTKMDTO> listKhuyenMai) {
		this.listKhuyenMai = listKhuyenMai;
	}
	
	public boolean checkKhuyenMaiExist(String maCTKM) {
		for(CTKMDTO x : listKhuyenMai) {
			if(x.getMaCTKM().equals(maCTKM)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public void addKhuyenMai(String maCTKM, Date ngayBD, Date ngayKT, String tenCTKM) {
		CTKMDTO khuyenMai = new CTKMDTO();
		khuyenMai.setMaCTKM(maCTKM);
		khuyenMai.setNgayBD(ngayBD);
		khuyenMai.setNgayKT(ngayKT);
		khuyenMai.setTenCTKM(tenCTKM);
		listKhuyenMai.add(khuyenMai);
		khuyenMaiDAO.addkhuyenMaiDAO(khuyenMai);
	}
	
	public void updateKhuyenMai(Date ngayBD, Date ngayKT,String tenCTKM, int index) {
		CTKMDTO khuyenMai = listKhuyenMai.get(index);
		khuyenMai.setNgayBD(ngayBD);
		khuyenMai.setNgayKT(ngayKT);
		khuyenMai.setTenCTKM(tenCTKM);
		khuyenMaiDAO.updatekhuyenMaiDAO(khuyenMai);
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

	public String getMaCTKM() {
		// TODO Auto-generated method stub
		return null;
	}
}	
