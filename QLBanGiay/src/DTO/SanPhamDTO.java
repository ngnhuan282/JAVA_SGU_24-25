package DTO;

public class SanPhamDTO {
	private String maLoaiSP, tenSP, DonViTinh;
	private int maSP, soLuong, donGia, maNCC;
	
	public SanPhamDTO()
	{
		
	}
	
	
	
	public SanPhamDTO(String maLoaiSP, String tenSP, String donViTinh, int maSP, int soLuong, int donGia, int maNCC) {
		this.maLoaiSP = maLoaiSP;
		this.tenSP = tenSP;
		DonViTinh = donViTinh;
		this.maSP = maSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.maNCC = maNCC;
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

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public int getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(int maNCC) {
		this.maNCC = maNCC;
	}
	
	
	
}
