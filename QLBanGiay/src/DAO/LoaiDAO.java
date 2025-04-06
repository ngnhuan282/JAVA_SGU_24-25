package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.LoaiDTO;

public class LoaiDAO {
	
	public LoaiDAO()
	{
		
	}
	
	public ArrayList<LoaiDTO> docDSLoai()
	{	
		ArrayList<LoaiDTO> dsloai = new ArrayList<LoaiDTO>();
		try {
			MySQLConnect mysql = new MySQLConnect();
			String sql = "SELECT * FROM PhanLoai";
			ResultSet rs = mysql.executeQuery(sql);
			while(rs.next())
			{
				String maLoai = rs.getString(0);
				String tenLoai = rs.getString(1);
				LoaiDTO loai = new LoaiDTO(maLoai, tenLoai);
				dsloai.add(loai);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsloai;
	}
	
	public void add(LoaiDTO loai)
	{
		try {
			MySQLConnect mysql = new MySQLConnect();
			String sql = "INSERT INTO PhanLoai VALUES(";
			sql += "'" + loai.getMaLoaiSP() + "', ";
			sql += "'" + loai.getTenLoaiSP() + "')";
			mysql.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
