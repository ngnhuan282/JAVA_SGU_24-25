package DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

import DTO.CTKMDTO;

public class CTKMDAO {
	
	private MySQLConnect connection;
	
	public CTKMDAO() {
		connection = new MySQLConnect();
	}
	
	public static CTKMDAO getkhuyenMaiDAO() {
		return new CTKMDAO();
	}
	
	 public ArrayList<CTKMDTO> docDSCTKM() {
	        ArrayList<CTKMDTO> listCTKM = new ArrayList<>();
	        try {
	            connection.getConnection();
	            String sql = "SELECT * FROM ctkm";
	            ResultSet rs = connection.executeQuery(sql);
	            while (rs.next()) {
	                String maCTKM = rs.getString("MaCTKM");
	                Date ngayBD = rs.getDate("NgayBD");
	                Date ngayKT = rs.getDate("NgayKT");
	                String tenCTKM = rs.getString("TenCTKM");

	                CTKMDTO ctkm = new CTKMDTO(maCTKM, ngayBD, ngayKT, tenCTKM);
	                listCTKM.add(ctkm);
	            }
	            connection.disConnect();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return listCTKM;
	    }
	
	public CTKMDTO getCTKM_HD(Date ngayLapSQL) throws SQLException {
		String ngayLap = String.valueOf(ngayLapSQL);
		String sql = "SELECT ctkm.*, ctkm_hd.PhanTramGiamGia FROM ctkm"
				+ " JOIN ctkm_hd ON ctkm.MaCTKM = ctkm_hd.MaCTKM"
				+ " WHERE NgayBD <= '"+ ngayLap +"' AND NgayKT >= '"+ ngayLap +"'";
		ResultSet rs = connection.executeQuery(sql);
		
		if(rs.next()) {
			String maCTKM = rs.getString("MaCTKM");
			Date ngayBD = rs.getDate("NgayBD");
			Date ngayKT = rs.getDate("NgayKT");
			String tenCTKM =rs.getString("TenCTKM");
			float phanTramGiamGia = rs.getFloat("PhanTramGiamGia");
			
			return new CTKMDTO(maCTKM, ngayBD, ngayKT,tenCTKM, phanTramGiamGia);
		}
		
		return null;
		
	}
	

	
	
		
	
	
		
	

	
	
	public void addkhuyenMaiDAO(CTKMDTO x) {
		String sql = "INSERT INTO ctkm(MaCTKM, NgayBD, NgayKT, TenCTKM)"
				+ "VALUES('"+ x.getMaCTKM()+"', '"+ x.getNgayBD() +"', '"+ x.getNgayKT()+ "', '"+ x.getTenCTKM()+"')";
		
		connection.executeUpdate(sql);
	}
	public void addCTKM_SP(String maCTKM, String maSP, double phanTram) {
	    String sql = "INSERT INTO ctkm_sp VALUES('" + maCTKM + "', '" + maSP + "', " + phanTram + ")";
	    connection.executeUpdate(sql);
	}

	public void addCTKM_HD(String maCTKM, String maHD, double phanTram) {
	    String sql = "INSERT INTO ctkm_hd VALUES('" + maCTKM + "', '" + maHD + "', " + phanTram + ")";
	    connection.executeUpdate(sql);
	}

	public void updateCTKMDAO(CTKMDTO ctkm, String loaiCTKMCu, String loaiCTKM, String maSPorHD, String maSPorHDCu, double phanTramValue) {
	    String sqlUpdateCTKM = "UPDATE ctkm SET NgayBD = '" + new java.sql.Date(ctkm.getNgayBD().getTime()) + "', " +
	                           "NgayKT = '" + new java.sql.Date(ctkm.getNgayKT().getTime()) + "', " +
	                           "TenCTKM = '" + ctkm.getTenCTKM() + "' " +
	                           "WHERE MaCTKM = '" + ctkm.getMaCTKM() + "'";
	    connection.executeUpdate(sqlUpdateCTKM);

	    //neu loai KM thay doi
	    if (!loaiCTKMCu.equalsIgnoreCase(loaiCTKM)) {
	        if (loaiCTKMCu.equalsIgnoreCase("Sản Phẩm") && loaiCTKM.equalsIgnoreCase("Hóa Đơn")) {
	            String sqlDeleteSP = "DELETE FROM ctkm_sp WHERE MaCTKM = '" + ctkm.getMaCTKM() + "' AND MaSP = '" + maSPorHDCu + "'";
	            connection.executeUpdate(sqlDeleteSP);

	            String sqlInsertHD = "INSERT INTO ctkm_hd (MaCTKM, MaHD, PhanTramGiamGia) VALUES ('" + ctkm.getMaCTKM() + "', '" + maSPorHD + "', " + phanTramValue + ")";
	            connection.executeUpdate(sqlInsertHD);

	        } else if (loaiCTKMCu.equalsIgnoreCase("Hóa Đơn") && loaiCTKM.equalsIgnoreCase("Sản Phẩm")) {
	            String sqlDeleteHD = "DELETE FROM ctkm_hd WHERE MaCTKM = '" + ctkm.getMaCTKM() + "' AND MaHD = '" + maSPorHDCu + "'";
	            connection.executeUpdate(sqlDeleteHD);

	            String sqlInsertSP = "INSERT INTO ctkm_sp (MaCTKM, MaSP, PhanTramGiamGia) VALUES ('" + ctkm.getMaCTKM() + "', '" + maSPorHD + "', " + phanTramValue + ")";
	            connection.executeUpdate(sqlInsertSP);
	        }
	    } 
	    //neu loai KM ko thay doi
	    else {
	        if (loaiCTKM.equalsIgnoreCase("Sản Phẩm")) {
	        	String sqlUpdateSP = "UPDATE ctkm_sp SET MaSP = '" + maSPorHD + "', PhanTramGiamGia = " + phanTramValue +
	                     " WHERE MaCTKM = '" + ctkm.getMaCTKM() + "'";
	                connection.executeUpdate(sqlUpdateSP);
	            }
	         else if (loaiCTKM.equalsIgnoreCase("Hóa Đơn")) {
	        	 String sqlUpdateHD = "UPDATE ctkm_hd SET MaHD = '" + maSPorHD + "', PhanTramGiamGia = " + phanTramValue +
	                     " WHERE MaCTKM = '" + ctkm.getMaCTKM() + "'";
	                connection.executeUpdate(sqlUpdateHD);
	        }
	    }
	}
	
	
	public void deleteKhuyenMaiDAO(String maCTKM) {
		String sqlDeleteCTKM = "DELETE FROM ctkm WHERE MaCTKM = '" + maCTKM + "'";
		connection.executeUpdate(sqlDeleteCTKM);
		
		 String sqlDeleteSP = "DELETE FROM ctkm_sp WHERE MaCTKM = '" + maCTKM + "'";
		 connection.executeUpdate(sqlDeleteSP);

	        // Xóa bảng ctkm_hd
	        String sqlDeleteHD = "DELETE FROM ctkm_hd WHERE MaCTKM = '" + maCTKM + "'";
	        connection.executeUpdate(sqlDeleteHD);
	}
	
	public ArrayList<CTKMDTO> searchKhuyenMai(String keyword, String loaiSearch) {
	    ArrayList<CTKMDTO> result = new ArrayList<>();
	    try {
	        String sql = "";
	        
	        // Kiểm tra loại tìm kiếm và chuẩn bị câu lệnh SQL phù hợp
	        if (loaiSearch.equals("Mã CTKM")) {
	            sql = "SELECT * FROM ctkm WHERE MaCTKM LIKE '%" + keyword + "%'";
	        } else if (loaiSearch.equals("Tên CTKM")) {
	            sql = "SELECT * FROM ctkm WHERE TenCTKM LIKE '%" + keyword + "%'";
	        }

	        // Nếu sql rỗng, in ra thông báo lỗi và trả về kết quả rỗng
	        if (sql.isEmpty()) {
	            System.out.println("Câu lệnh SQL không hợp lệ.");
	            return result;
	        }

	        ResultSet rs = connection.executeQuery(sql);
	        if (rs != null) {
	            while (rs.next()) {
	                String maCTKM = rs.getString("MaCTKM");
	                Date ngayBD = rs.getDate("NgayBD");
	                Date ngayKT = rs.getDate("NgayKT");
	                String tenCTKM = rs.getString("TenCTKM");

	                CTKMDTO ctkm = new CTKMDTO(maCTKM, ngayBD, ngayKT, tenCTKM);
	                result.add(ctkm);
	            }
	            rs.close();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}



	public String layLoaiKhuyenMai(String maCTKM) {
	    try {
	        String sqlSP = "SELECT * FROM ctkm_sp WHERE MaCTKM = '" + maCTKM + "'";
	        ResultSet rsSP = connection.executeQuery(sqlSP);
	        if (rsSP.next()) {
	            rsSP.close();
	            return "Sản Phẩm";
	        }

	        String sqlHD = "SELECT * FROM ctkm_hd WHERE MaCTKM = '" + maCTKM + "'";
	        ResultSet rsHD = connection.executeQuery(sqlHD);
	        if (rsHD.next()) {
	            rsHD.close();
	            return "Hóa Đơn";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return ""; // Trường hợp không tìm thấy
	}
	public String layMaSPorHD(String maCTKM) {
	    try {
	        String sqlSP = "SELECT MaSP FROM ctkm_sp WHERE MaCTKM = '" + maCTKM + "'";
	        ResultSet rsSP = connection.executeQuery(sqlSP);
	        if (rsSP.next()) {
	            String maSP = rsSP.getString("MaSP");
	            rsSP.close();
	            return maSP;
	        }

	        String sqlHD = "SELECT MaHD FROM ctkm_hd WHERE MaCTKM = '" + maCTKM + "'";
	        ResultSet rsHD = connection.executeQuery(sqlHD);
	        if (rsHD.next()) {
	            String maHD = rsHD.getString("MaHD");
	            rsHD.close();
	            return maHD;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return "";
	}
	public String layPhanTram(String maCTKM) {
	    try {
	        String sqlSP = "SELECT PhanTramGiamGia FROM ctkm_sp WHERE MaCTKM = '" + maCTKM + "'";
	        ResultSet rsSP = connection.executeQuery(sqlSP);
	        if (rsSP.next()) {
	            String pt = rsSP.getString("PhanTramGiamGia");
	            rsSP.close();
	            return pt;
	        }

	        String sqlHD = "SELECT PhanTramGiamGia FROM ctkm_hd WHERE MaCTKM = '" + maCTKM + "'";
	        ResultSet rsHD = connection.executeQuery(sqlHD);
	        if (rsHD.next()) {
	            String pt = rsHD.getString("PhanTramGiamGia");
	            rsHD.close();
	            return pt;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return "";
	}




	
	// Thêm phương thức để lấy danh sách MaSP
		public ArrayList<String> getListMaSP() throws SQLException {
			ArrayList<String> listMaSP = new ArrayList<>();
			connection.getConnection();
			
			String sql = "SELECT MaSP FROM sanpham";
			ResultSet rs = connection.executeQuery(sql);
			
			while (rs.next()) {
				listMaSP.add(rs.getString("MaSP"));
			}
			
			rs.close();
			connection.disConnect();
			return listMaSP;
		}
		
		// Thêm phương thức để lấy danh sách MaHD
		public ArrayList<String> getListMaHD() throws SQLException {
			ArrayList<String> listMaHD = new ArrayList<>();
			connection.getConnection();
			
			String sql = "SELECT MaHD FROM hoadon";
			ResultSet rs = connection.executeQuery(sql);
			
			while (rs.next()) {
				listMaHD.add(rs.getString("MaHD"));
			}
			
			rs.close();
			connection.disConnect();
			return listMaHD;
		}
		
		public static void main(String[] args) throws SQLException {
			LocalDate now = LocalDate.now();
			Date ngayLap = Date.valueOf(now);
			CTKMDAO ctkmdao = new CTKMDAO();
			CTKMDTO ctkm = ctkmdao.getCTKM_HD(ngayLap);
			System.out.println(ctkm);
		}
}
