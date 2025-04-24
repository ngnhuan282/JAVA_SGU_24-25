package DTO;

import java.sql.Date;

public class CTKMDTO {
	private String maCTKM;
	private Date ngayBD;
	private Date ngayKT;
	private String tenCTKM;
	public CTKMDTO() {
		
	}
	
	
	public CTKMDTO(String maCTKM, Date ngayBD, Date ngayKT, String tenCTKM) {
		this.maCTKM = maCTKM;
		this.ngayBD = ngayBD;
		this.ngayKT = ngayKT;
		this.tenCTKM = tenCTKM;
	}


	public String getTenCTKM() {
		return tenCTKM;
	}


	public void setTenCTKM(String tenCTKM) {
		this.tenCTKM = tenCTKM;
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




















