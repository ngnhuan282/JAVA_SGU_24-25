package DTO;

public class SanPhamDTO {
	private String maSP, maLoaiSP, tenSP, DonViTinh;
	private int soLuong;
	private double donGia;
	
	public SanPhamDTO()
	{
		
	}
	
	
	public SanPhamDTO(String maSP, String tenSP, int soLuong, double donGia, String donViTinh, String maLoaiSP) {
		super();
		this.maSP = maSP;
		this.maLoaiSP = maLoaiSP;
		this.tenSP = tenSP;
		DonViTinh = donViTinh;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}


	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
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
	
	
