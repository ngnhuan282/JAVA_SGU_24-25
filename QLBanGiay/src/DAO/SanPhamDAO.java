package DAO;

import DTO.SanPhamDTO;

public class SanPhamDAO {
	public SanPhamDAO()
	{
		
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
		sql += "MaSP=" + sp.getMaSP() + ", ";
		sql += "TenSP=" + sp.getTenSP() + ", ";
		sql += "SoLuong=" + sp.getSoLuong() + ", ";
		sql += "DonGia=" + sp.getDonGia() + ", ";
		sql += "DonViTinh=" + sp.getDonViTinh() + ", ";
		sql += "MaLoaiSP=" + sp.getMaLoaiSP() + ")";
		
		mysql.executeUpdate(sql);
		mysql.disConnect();
	}
	
	public void delete(String MaSP)
	{
		MySQLConnect mysql = new MySQLConnect();
		String sql = "DELETE FROM SanPham WHERE MaSP = " +MaSP;
		mysql.executeUpdate(sql);
		mysql.disConnect();
	}
	
}
