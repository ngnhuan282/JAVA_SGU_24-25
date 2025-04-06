package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.ChiTietSPDTO;

public class ChiTietSPDAO {
	MySQLConnect mysql = new MySQLConnect();
	
	public ChiTietSPDAO()
	{
		
	}
	
	public ArrayList<ChiTietSPDTO> docDSCTSP(String maSP)
	{	
		ArrayList<ChiTietSPDTO> dsCTSP = new ArrayList<ChiTietSPDTO>();
		try {
			String sql = "SELECT * FROM ChiTietSP WHERE MaSP= ";
			sql += "'" + maSP + "'";
			ResultSet rs = mysql.executeQuery(sql);
			while(rs.next())
			{
				String mauSac = rs.getString("MauSac");
				int kichThuoc = rs.getInt("KichThuoc");
				String chatLieu = rs.getString("ChatLieu");
				String kieuDang = rs.getString("KieuDang");		
				ChiTietSPDTO ctsp = new ChiTietSPDTO(maSP, mauSac, kichThuoc, chatLieu, kieuDang);
				dsCTSP.add(ctsp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsCTSP;
	}
	
	public void add(ChiTietSPDTO ctsp)
	{
		try {
			String sql = "INSERT INTO ChiTietSP VALUES (";
			sql += "'" +ctsp.getMaSP() +"', ";
			sql += "'" +ctsp.getMauSac() +"', ";
			sql += "'" +ctsp.getKichThuoc() +"', ";
			sql += "'" +ctsp.getChatLieu() +"', ";
			sql += "'" +ctsp.getKieuDang() +"')";
			mysql.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void delete(String maSP)
	{
		try {
			String sql = "DELETE FROM ChiTietSP WHERE MaSP= ";
			sql += "'" + maSP + "'";
			mysql.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
