package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
}
