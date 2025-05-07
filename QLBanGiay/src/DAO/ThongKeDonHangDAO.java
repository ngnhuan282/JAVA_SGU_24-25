package DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import DTO.ThongKeDoanhThuDTO;
import DTO.ThongKeDonHangDTO;

public class ThongKeDonHangDAO {
	private MySQLConnect connection;
	
	public ThongKeDonHangDAO() {
		connection = new MySQLConnect();
	}
	
	public ArrayList<ThongKeDonHangDTO> getListDonHang(Date tuNgay, Date denNgay){
		ArrayList<ThongKeDonHangDTO> listThongKe = new ArrayList<ThongKeDonHangDTO>();
        try {

            // Truy vấn tất cả các ngày trong khoảng từ ngày đến ngày
            String sql = "SELECT"
            		+ "    DATE_FORMAT(d.ngay, '%Y-%m-%d') AS ngay,"
            		+ "    COALESCE(SUM(hd.TongTien), 0) AS tongDoanhThu,"
            		+ "    COALESCE(COUNT(hd.MaHD), 0) AS tongDonHang "
            		+ "FROM ("
            		+ "    SELECT DATE_ADD('"+ tuNgay +"', INTERVAL n DAY) AS ngay"
            		+ "    FROM ("
            		+ "        SELECT a.N + b.N * 10 + c.N * 100 AS n"
            		+ "        FROM "
            		+ "            (SELECT 0 AS N UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 "
            		+ "             UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) a,"
            		+ "            (SELECT 0 AS N UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 "
            		+ "             UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) b,"
            		+ "            (SELECT 0 AS N UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 n"
            		+ "             UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) c"
            		+ "    ) numbers"
            		+ "    WHERE DATE_ADD('"+ tuNgay +"', INTERVAL n DAY) <= '"+ denNgay +"'"
            		+ ") d"
            		+ " LEFT JOIN HOADON hd ON DATE(hd.NgayLap) = d.ngay"
            		+ " GROUP BY d.ngay"
            		+ " ORDER BY d.ngay;";

            ResultSet rs = connection.executeQuery(sql);
            while (rs.next()) {
            	Date ngay = rs.getDate("Ngay");
                double tongDoanhThu = rs.getDouble("tongDoanhThu");
                int tongDonHang = rs.getInt("tongDonHang");
                
                ThongKeDonHangDTO thongKeDonHangDTO = new ThongKeDonHangDTO(ngay, tongDoanhThu, tongDonHang);
                listThongKe.add(thongKeDonHangDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listThongKe;
    }
}
