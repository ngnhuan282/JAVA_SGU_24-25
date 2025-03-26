package DTO;

public class KhachHangDTO {
	private int MaKH;
	private String ho, ten, sdt, diaChi;
	
	public KhachHangDTO() {
		
	}
	
	
	
	public KhachHangDTO(int maKH, String ho, String ten, String sdt, String diaChi) {
		MaKH = maKH;
		this.ho = ho;
		this.ten = ten;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}



	public int getMaKH() {
		return MaKH;
	}
	
	public void setMaKH(int maKH) {
		MaKH = maKH;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	
}
