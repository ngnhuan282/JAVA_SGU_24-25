package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.KhachHangDTO;

public class KhachHangDAO {
	
	private MySQLConnect connection;
	
	public KhachHangDAO() {
		connection = new MySQLConnect();
	}
	
	public static KhachHangDAO getKhachHangDAO() {
		return new KhachHangDAO();
	}
	
	public ArrayList<KhachHangDTO> getListKhachHang() throws SQLException {
		ArrayList<KhachHangDTO> listKhachHangDTO = new ArrayList<KhachHangDTO>();
		connection.getConnection();
		
		String sql = "SELECT * FROM khachhang";
		ResultSet rs = connection.executeQuery(sql);
		
		while(rs.next()) {
			int maKH = Integer.valueOf(rs.getString("MaKH"));
			String ho = rs.getString("Ho");
			String ten = rs.getString("Ten");
			String sdt = rs.getString("SDT");
			String diaChi = rs.getString("DiaChi");
			
			KhachHangDTO khachHang = new KhachHangDTO(maKH, ho, ten, sdt, diaChi);
			listKhachHangDTO.add(khachHang);
		}
		
		connection.disConnect();
		return listKhachHangDTO;
	}
	
	public void addKhachHangDAO(KhachHangDTO x) {
		String sql = "INSERT INTO khachhang(MaKH, Ho, Ten, SDT, DiaChi)"
				+ "VALUES('"+ x.getMaKH()+"', '"+ x.getHo() +"', '"+ x.getTen() +"', '" + x.getSdt() + "', '" + x.getDiaChi() + "')";
		connection.executeUpdate(sql);
	}
	
	public void updateKhachHangDAO(KhachHangDTO x) {
		String sql = "UPDATE khachhang"
				+ " SET"
				+ " Ho = '" + x.getHo() + "'"
				+ ", Ten = '" + x.getTen() + "'"
				+ ", DiaChi = '" + x.getDiaChi() + "'"
				+ ", SDT = '" + x.getSdt() + "'"
				+ " WHERE MaKH = '" + x.getMaKH() + "'";
		connection.executeUpdate(sql);
	}
	
	public void deleteKhachHangDAO(KhachHangDTO x) {
		String sql  = "DELETE FROM khachhang WHERE MaKH ='" + x.getMaKH() + "'";
		connection.executeUpdate(sql);
	}
}
