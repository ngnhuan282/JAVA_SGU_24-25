package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import DTO.SanPhamDTO;

public class SanPhamDAO {
	
	public SanPhamDAO()
	{
		
	}
	
	public ArrayList<SanPhamDTO> list()
	{	
		ArrayList<SanPhamDTO> dssp = new ArrayList<>();
		try {
			
			MySQLConnect mysql = new MySQLConnect();
			String sql = "SELECT * FROM SanPham";
			ResultSet rs = mysql.executeQuery(sql);
			while(rs.next())
			{
				String maSP = rs.getString("MaSP");
				String tenSP = rs.getString("TenSP");
				int soLuong = rs.getInt("SoLuong");
				double donGia = rs.getDouble("DonGia");
				String donViTinh = rs.getString("DonViTinh");
				String maLoaiSP = rs.getString("MaLoaiSP");
				
				SanPhamDTO sp = new SanPhamDTO(maSP, tenSP, soLuong, donGia, donViTinh, maLoaiSP);
				dssp.add(sp);
			}
			rs.close();
			mysql.disConnect();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dssp;
	}
	
	public void add(SanPhamDTO sp)
	{
		MySQLConnect mysql = new MySQLConnect();
		String sql = "INSERT INTO SanPham VALUES(";
		sql += "'" +sp.getMaSP() + "'";
		sql += "'" +sp.getTenSP() + "'";
		sql += "'" +sp.getSoLuong() + "'";
		sql += "'" +sp.getDonGia() + "'";
		sql += "'" +sp.getDonViTinh() + "'";
		sql += "'" +sp.getMaLoaiSP() + ")";
		
		mysql.executeUpdate(sql);
		mysql.disConnect();
	}
	
	public void update(SanPhamDTO sp)
	{
		MySQLConnect mysql = new MySQLConnect();
		String sql = "UPDATE SanPham SET ";
		sql += "MaSP='" + sp.getMaSP() + "', ";
		sql += "TenSP='" + sp.getTenSP() + "', ";
		sql += "SoLuong='" + sp.getSoLuong() + "', ";
		sql += "DonGia='" + sp.getDonGia() + "', ";
		sql += "DonViTinh='" + sp.getDonViTinh() + "', ";
		sql += "MaLoaiSP='" + sp.getMaLoaiSP() + ")";
		
		mysql.executeUpdate(sql);
		mysql.disConnect();
	}
	
	public void delete(String MaSP)
	{
		MySQLConnect mysql = new MySQLConnect();
		String sql = "DELETE FROM SanPham WHERE MaSP ='" +MaSP + "'";
		mysql.executeUpdate(sql);
		mysql.disConnect();
	}
	
}
