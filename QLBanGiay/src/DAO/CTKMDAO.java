package DAO;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.CTKMDTO;

public class CTKMDAO {
	
	private MySQLConnect connection;
	
	public CTKMDAO() {
		connection = new MySQLConnect();
	}
	
	public static CTKMDAO getkhuyenMaiDAO() {
		return new CTKMDAO();
	}
	
	public ArrayList<CTKMDTO> getListkhuyenMai() throws SQLException {
		ArrayList<CTKMDTO> listkhuyenMaiDTO = new ArrayList<CTKMDTO>();
		connection.getConnection();
		
		String sql = "SELECT * FROM ctkm";
		ResultSet rs = connection.executeQuery(sql);
		
		while(rs.next()) {
			String maCTKM = rs.getString("MaCTKM");
			Date ngayBD = rs.getDate("NgayBD");
			Date ngayKT = rs.getDate("NgayKT");
			
			CTKMDTO khuyenMai = new CTKMDTO(maCTKM, ngayBD, ngayKT);
			listkhuyenMaiDTO.add(khuyenMai);
		}
		
		connection.disConnect();
		return listkhuyenMaiDTO;
	}
	
	public void addkhuyenMaiDAO(CTKMDTO x) {
		String sql = "INSERT INTO khuyenMai(MaCTKM, NgayBD, NgayKT, HinhThuc)"
				+ "VALUES('"+ x.getMaCTKM()+"', '"+ x.getNgayBD() +"', '"+ x.getNgayKT()+"')";
		connection.executeUpdate(sql);
	}
	
	public void updatekhuyenMaiDAO(CTKMDTO x) {
		String sql = "UPDATE khuyenMai"
				+ " SET"
				+ " NgayBT = '" + x.getNgayBD() + "'"
				+ ", NgayKT = '" + x.getNgayKT() + "'"
				+ " WHERE MaCTKM = '" + x.getMaCTKM() + "'";
		connection.executeUpdate(sql);
		connection.disConnect();
	}
	
	public void deletekhuyenMaiDAO(CTKMDTO x) {
		String sql  = "DELETE FROM khuyenMai WHERE MaCTKM ='" + x.getMaCTKM() + "'";
		connection.executeUpdate(sql);
		connection.disConnect();
	}
}
