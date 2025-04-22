package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DTO.NhanVienDTO;

public class NhanVienDAO {
	private MySQLConnect connection;
	
	public NhanVienDAO() {
		connection = new MySQLConnect();
	}
	public static NhanVienDAO getNhanVienDAO() {
		return new NhanVienDAO();
	}
	public ArrayList<NhanVienDTO> getListNhanVien() throws SQLException {
		ArrayList<NhanVienDTO> listNhanVienDTO = new ArrayList<NhanVienDTO>();
		connection.getConnection();
		
		String sql = "SELECT * FROM nhanvien";
		ResultSet rs = connection.executeQuery(sql);
		
		while(rs.next()) {
			String maNV = rs.getString("MaNV");
			String ho = rs.getString("Ho");
			String ten = rs.getString("Ten");
			String sdt = rs.getString("SDT");
			Double luong = Double.valueOf(rs.getString("LuongThang"));
			
			NhanVienDTO nhanVien = new NhanVienDTO(maNV, ho, ten, sdt, luong);
			listNhanVienDTO.add(nhanVien);
		}
		
		connection.disConnect();
		return listNhanVienDTO;
	}
	
	public void addNhanVienDAO(NhanVienDTO x) {
		String sql = "INSERT INTO nhanvien(MaNV, Ho, Ten, SDT, LuongThang)"
				+ "VALUES('"+ x.getMaNV()+"', '"+ x.getHo() +"', '"+ x.getTen() +"', '" + x.getSdt() + "', '" + x.getLuong() + "')";
		connection.executeUpdate(sql);
	}
	
	public void updateNhanVienDAO(NhanVienDTO x) {
		String sql = "UPDATE nhanvien"
				+ " SET"
				+ " Ho = '" + x.getHo() + "'"
				+ ", Ten = '" + x.getTen() + "'"
				+ ", SDT = '" + x.getSdt() + "'"
				+ " WHERE LuongThang = '" + x.getLuong() + "'";
					
		connection.executeUpdate(sql);
	}
	
	public void deleteNhanVienDAO(NhanVienDTO x) {
		String sql  = "DELETE FROM nhanvien WHERE MaNV ='" + x.getMaNV() + "'";
		connection.executeUpdate(sql);
	}
	
	public void ImportExcel(File file)
	{
		try {
			FileInputStream in = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(in);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Row row;
			for(int i=1; i <= sheet.getLastRowNum(); i++)
			{
				row = sheet.getRow(i);
				String maNV = row.getCell(0).getStringCellValue();
				String ho = row.getCell(1).getStringCellValue();
				String ten = row.getCell(2).getStringCellValue();
				String sdt = null;
				if (row.getCell(3).getCellType() == org.apache.poi.ss.usermodel.CellType.NUMERIC) 
	                sdt = String.format("%.0f", row.getCell(3).getNumericCellValue());
	            else 
	                sdt = row.getCell(3).getStringCellValue();
				double luong = (double) row.getCell(4).getNumericCellValue();
				
				String sqlCheck = "SELECT * FROM NhanVien WHERE MaNV= '" + maNV + "'";
				ResultSet rs = connection.executeQuery(sqlCheck);
				if(!rs.next())
				{
					String sql = "INSERT INTO NhanVien VALUES (";
					sql += "'" + maNV + "', ";
					sql += "'" + ho + "', ";
					sql += "'" + ten + "', ";
					sql += "'" + sdt + "', ";
					sql += "'" + luong + "')";
					System.out.println(sql);
					connection.executeUpdate(sql);
				}
				else
				{
					String sql = "UPDATE NhanVien SET ";
					sql += "Ho='" + ho + "', ";
					sql += "Ten='" + ten + "', ";
					sql += "SDT='" + sdt + "', ";
					sql += "Luong='" + luong + "' ";
					sql += "WHERE MaNV='" + maNV + "'";
					System.out.println(sql);
					connection.executeUpdate(sql);
				}
			}
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
