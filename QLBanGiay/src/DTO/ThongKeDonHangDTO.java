package DTO;

import java.util.Date;

public class ThongKeDonHangDTO {
	private Date ngay;
	private double tongDoanhThu;
	private int tongDonHang;
	
	public ThongKeDonHangDTO() {
		
	}

	public ThongKeDonHangDTO(Date ngay, double tongDoanhThu, int tongDonHang) {
		super();
		this.ngay = ngay;
		this.tongDoanhThu = tongDoanhThu;
		this.tongDonHang = tongDonHang;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public double getTongDoanhThu() {
		return tongDoanhThu;
	}

	public void setTongDoanhThu(double tongDoanhThu) {
		this.tongDoanhThu = tongDoanhThu;
	}

	public int getTongDonHang() {
		return tongDonHang;
	}

	public void setTongDonHang(int tongDonHang) {
		this.tongDonHang = tongDonHang;
	}
	
	
}
