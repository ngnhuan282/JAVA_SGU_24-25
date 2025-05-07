package BUS;

import java.util.ArrayList;
import java.util.Date;

import DAO.ThongKeDonHangDAO;
import DTO.ThongKeDonHangDTO;

public class ThongKeHoaDonBUS {
	private ThongKeDonHangDAO thongKeDAO;
	
	public ThongKeHoaDonBUS() {
		thongKeDAO = new ThongKeDonHangDAO();
	}
	
	public ArrayList<ThongKeDonHangDTO> getListThongKe(Date tuNgay, Date denNgay){
		return thongKeDAO.getListDonHang(tuNgay, denNgay);
	}
}
