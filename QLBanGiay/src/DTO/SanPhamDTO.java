package DTO;

public class SanPhamDTO {
	private String maLoaiSP, tenSP, DonViTinh;
	private int maSP, soLuong;
	private double donGia;
	
	public SanPhamDTO()
	{
		
	}
	
	
	
	public SanPhamDTO(String maLoaiSP, String tenSP, String donViTinh, int maSP, int soLuong, double donGia) {
		this.maLoaiSP = maLoaiSP;
		this.tenSP = tenSP;
		DonViTinh = donViTinh;
		this.maSP = maSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public String getMaLoaiSP() {
		return maLoaiSP;
	}

	public void setMaLoaiSP(String maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getDonViTinh() {
		return DonViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		DonViTinh = donViTinh;
	}

	public int getMaSP() {
		return maSP;
	}

	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	
	
	
}