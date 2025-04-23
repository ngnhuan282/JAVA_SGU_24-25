package DTO;

import java.sql.Date;

public class CTKMDTO {
	private String maCTKM;
	private Date ngayBD;
	private Date ngayKT;
	
	public CTKMDTO() {
		
	}
	
	
	public CTKMDTO(String maCTKM, Date ngayBD, Date ngayKT) {
		this.maCTKM = maCTKM;
		this.ngayBD = ngayBD;
		this.ngayKT = ngayKT;
	}


	public String getMaCTKM() {
		return maCTKM;
	}


	public void setMaCTKM(String maCTKM) {
		this.maCTKM = maCTKM;
	}


	public Date getNgayBD() {
		return ngayBD;
	}


	public void setNgayBD(Date ngayBD) {
		this.ngayBD = ngayBD;
	}


	public Date getNgayKT() {
		return ngayKT;
	}


	public void setNgayKT(Date ngayKT) {
		this.ngayKT = ngayKT;
	}






	
}




















