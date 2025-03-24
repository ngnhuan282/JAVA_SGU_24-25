package DTO;

public class ChiTietSPDTO {
	private int maSP;
	private String mauSac, kichCo, chatLieu, kieuDang, moTa;
	private String maHangSX;
	
	public ChiTietSPDTO()
	{
		
	}

	public ChiTietSPDTO(int maSP, String mauSac, String kichCo, String chatLieu, String kieuDang, String moTa,
			String maHangSX) {
		this.maSP = maSP;
		this.mauSac = mauSac;
		this.kichCo = kichCo;
		this.chatLieu = chatLieu;
		this.kieuDang = kieuDang;
		this.moTa = moTa;
		this.maHangSX = maHangSX;
	}

	public int getMaSP() {
		return maSP;
	}

	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	public String getKichCo() {
		return kichCo;
	}

	public void setKichCo(String kichCo) {
		this.kichCo = kichCo;
	}

	public String getChatLieu() {
		return chatLieu;
	}

	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}

	public String getKieuDang() {
		return kieuDang;
	}

	public void setKieuDang(String kieuDang) {
		this.kieuDang = kieuDang;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getMaHangSX() {
		return maHangSX;
	}

	public void setMaHangSX(String maHangSX) {
		this.maHangSX = maHangSX;
	}
	
	
}
