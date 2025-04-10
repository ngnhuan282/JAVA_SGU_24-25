package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.NhaCungCapDTO;

public class NhaCungCapDAO {

	public ArrayList<NhaCungCapDTO> xuatDSNCC(){
		ArrayList<NhaCungCapDTO> listNCC = new ArrayList<>();
		try {
			MySQLConnect mysql = new MySQLConnect();
			String sql = "SELECT * FROM nhacc";
			ResultSet rs = mysql.executeQuery(sql);
			while(rs.next()) {
				NhaCungCapDTO ncc = new NhaCungCapDTO();
				ncc.setMaNCC(rs.getString("MaNCC"));
				ncc.setTenNCC(rs.getString("TenNCC"));
				ncc.setDiaChi(rs.getString("DiaChi"));
				ncc.setSDT(rs.getString("SDT"));
				listNCC.add(ncc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listNCC;
	}
	
	
	public void them(NhaCungCapDTO ncc) {
		try {
			MySQLConnect mysql = new MySQLConnect();
			String sql = "INSERT INTO nhacc VALUES(";
			sql += "'" +ncc.getMaNCC()+"',";
			sql += "'" +ncc.getTenNCC()+"',";
			sql += "'" +ncc.getDiaChi()+"',";
			sql += "'" +ncc.getSDT()+"')";
			System.out.println("SQL INSERT: " + sql); 
			mysql.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sua(NhaCungCapDTO ncc,String maNCC) {
		try {
			MySQLConnect mysql = new MySQLConnect();
			String sql = "UPDATE nhacc SET ";
			sql += "MaNCC= '"+ncc.getMaNCC()+"', ";
			sql += "TenNCC= '"+ncc.getTenNCC()+"', ";
			sql += "DiaChi= '"+ncc.getDiaChi()+"', ";
			sql += "SDT= '"+ncc.getSDT()+"'";
			sql += " WHERE MaNCC='"+maNCC+"'";
			System.out.println("SQL UPDATE: " + sql); 
			mysql.executeUpdate(sql);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void xoa(String maNCC) {
		try {
			MySQLConnect mysql = new MySQLConnect();
			String sql = "DELETE FROM nhacc WHERE MaNCC='"+maNCC+"'";
			mysql.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
}


