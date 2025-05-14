package DAO;


import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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

	        String sqlDeleteHD = "DELETE FROM ctkm_hd WHERE MaCTKM = '" + maCTKM + "'";
	        connection.executeUpdate(sqlDeleteHD);
	}
	
	public ArrayList<CTKMDTO> searchKhuyenMai(String keyword, String loaiSearch) {
	    ArrayList<CTKMDTO> result = new ArrayList<>();
	    try {
	        String sql = "";
	        
	        if (loaiSearch.equals("Mã CTKM")) {
	            sql = "SELECT * FROM ctkm WHERE MaCTKM LIKE '%" + keyword + "%'";
	        } else if (loaiSearch.equals("Tên CTKM")) {
	            sql = "SELECT * FROM ctkm WHERE TenCTKM LIKE '%" + keyword + "%'";
	        }

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
	public int[] ImportExcel(File file) {
	    int addedRows = 0;
	    int updatedRows = 0;

	    try {
	        FileInputStream in = new FileInputStream(file);
	        XSSFWorkbook workbook = new XSSFWorkbook(in);
	        XSSFSheet sheet = workbook.getSheetAt(0);
	        Row row;

	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	            row = sheet.getRow(i);
	            if (row == null) continue;

	            String maCTKM = row.getCell(0).getStringCellValue().trim(); 
	            String tenKM = row.getCell(1).getStringCellValue().trim();

	            Cell cellNgayBD = row.getCell(2);
	            Cell cellNgayKT = row.getCell(3);

	            java.sql.Date ngayBD = null;
	            java.sql.Date ngayKT = null;
	            

	            if (cellNgayBD != null) {
	                if (cellNgayBD.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cellNgayBD)) {
	                    ngayBD = new java.sql.Date(cellNgayBD.getDateCellValue().getTime());
	                } else if (cellNgayBD.getCellType() == CellType.STRING) {
	                    java.util.Date date = sdf.parse(cellNgayBD.getStringCellValue().trim());
	                    ngayBD = new java.sql.Date(date.getTime());
	                }
	            }

	            if (cellNgayKT != null) {
	                if (cellNgayKT.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cellNgayKT)) {
	                    ngayKT = new java.sql.Date(cellNgayKT.getDateCellValue().getTime());
	                } else if (cellNgayKT.getCellType() == CellType.STRING) {
	                    java.util.Date date = sdf.parse(cellNgayKT.getStringCellValue().trim());
	                    ngayKT = new java.sql.Date(date.getTime());
	                }
	            }

	            String loaiKM = row.getCell(4).getStringCellValue().trim();
	            String maSporHD = row.getCell(5).getStringCellValue().trim();
	            
	            double phanTramGiamGia = getPhanTramGiamGia(row.getCell(6));

	            String ctkm = loaiKM.equalsIgnoreCase("SP") ? "ctkm_sp" : "ctkm_hd";
	            String maField = loaiKM.equalsIgnoreCase("SP") ? "MaSP" : "MaHD";

	            String sqlCheck = "SELECT * FROM " + ctkm + " WHERE MaCTKM = '" + maCTKM + "'";  
	            ResultSet rs = connection.executeQuery(sqlCheck);

	            if (!rs.next()) {
	                String sqlInsert = "INSERT INTO " + ctkm + " (MaCTKM, TenCTKM,NgayBD,NgayKT, " + maField + ") VALUES (";
	                sqlInsert += "'" + maCTKM + "', ";  
	                sqlInsert += "'" + new java.sql.Date(ngayBD.getTime()) + "', ";
	                sqlInsert += "'" + new java.sql.Date(ngayKT.getTime()) + "', ";
	                sqlInsert += "'" + tenKM + "', ";
	                sqlInsert += "'" + phanTramGiamGia + "', ";
	                sqlInsert += "'" + maSporHD + "')";
	                connection.executeUpdate(sqlInsert);
	                addedRows++;
	            } else {
	                String sqlUpdate = "UPDATE " + ctkm + " SET ";      
	                sqlUpdate += "NgayBD = '" + new java.sql.Date(ngayBD.getTime()) + "', ";  
	                sqlUpdate += "NgayKT = '" + new java.sql.Date(ngayKT.getTime()) + "', ";
	                sqlUpdate += "TenCTKM = '" + tenKM + "', ";
	                sqlUpdate += "PhanTramGiamGia = " + phanTramGiamGia + ", ";
	                sqlUpdate += maField + " = '" + maSporHD + "' ";  
	                sqlUpdate += "WHERE MaCTKM = '" + maCTKM + "'";  
	                connection.executeUpdate(sqlUpdate);
	                updatedRows++;
	            }
	        }

	        workbook.close();
	        in.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Lỗi khi nhập Excel CTKM: " + e.getMessage());
	    }

	    return new int[]{addedRows, updatedRows};
	}

	public double getPhanTramGiamGia(Cell cell) {
	    double phanTramGiamGia = 0.0;
	    
	    if (cell.getCellType() == CellType.NUMERIC) {
	        phanTramGiamGia = cell.getNumericCellValue(); 
	    } else if (cell.getCellType() == CellType.STRING) {
	        try {
	            phanTramGiamGia = Double.parseDouble(cell.getStringCellValue());
	        } catch (NumberFormatException e) {
	            System.out.println("Lỗi chuyển đổi chuỗi thành số: " + e.getMessage());
	        }
	    }
	    
	    return phanTramGiamGia;
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

	    return "";
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
