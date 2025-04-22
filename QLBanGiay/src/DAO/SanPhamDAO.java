package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import DTO.SanPhamDTO;

public class SanPhamDAO {
	private MySQLConnect mysql = new MySQLConnect();
	
	public SanPhamDAO()
	{
		
	}
	
	public ArrayList<SanPhamDTO> docDSSP()
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
				int maLoaiSP = rs.getInt("MaLoaiSP");
				String chatLieu = rs.getString("ChatLieu");
				String kieuDang = rs.getString("KieuDang");
				String mauSac = rs.getString("MauSac");
				int kichThuoc = rs.getInt("KichThuoc");
				
				SanPhamDTO sp = new SanPhamDTO(maSP, tenSP, soLuong, donGia, donViTinh, maLoaiSP,
											mauSac, kichThuoc, chatLieu, kieuDang);
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
		String sql = "INSERT INTO SanPham VALUES(";
		sql += "'" + sp.getMaSP() + "', ";
        sql += "'" + sp.getTenSP() + "', ";
        sql += "'" + sp.getSoLuong() + "', ";
        sql += "'" + sp.getDonGia() + "', ";  
        sql += "'" + sp.getDonViTinh() + "', ";
        sql += "'" + sp.getMaLoaiSP() + "', ";
        sql += "'" + sp.getMauSac() + "', ";
        sql += "'" + sp.getKichThuoc() + "', "; 
        sql += "'" + sp.getChatLieu() + "', ";
        sql += "'" + sp.getKieuDang() + "')";
		
		mysql.executeUpdate(sql);
		mysql.disConnect();
	}
	
	public void update(SanPhamDTO sp)
	{
		String sql = "UPDATE SanPham SET ";
		sql += "MaSP='" + sp.getMaSP() + "', ";
		sql += "TenSP='" + sp.getTenSP() + "', ";
		sql += "SoLuong='" + sp.getSoLuong() + "', ";
		sql += "DonGia='" + sp.getDonGia() + "', ";
		sql += "DonViTinh='" + sp.getDonViTinh() + "', ";
		sql += "MaLoaiSP='" + sp.getMaLoaiSP() + "', ";
		sql += "ChatLieu='" + sp.getChatLieu() + "', ";
		sql += "MauSac='" + sp.getMauSac() + "', ";
		sql += "KieuDang='" + sp.getKieuDang() + "', ";
		sql += "KichThuoc='" + sp.getKichThuoc() + "',";
		sql += "WHERE MaSP= '" + sp.getMaSP() + "'";
		mysql.executeUpdate(sql);
		mysql.disConnect();
	}
	
	public void delete(String MaSP)
	{
		String sql = "DELETE FROM SanPham WHERE MaSP = '" +MaSP + "'";
		mysql.executeUpdate(sql);
		mysql.disConnect();
	}
	
	//Phieu nhapppppppppp
	public void capNhapSoLuong(String maSP, int soLuong) {
		String sql = "UPDATE sanpham SET SoLuong ="+soLuong+" WHERE MaSP = '"+maSP+"'";
		mysql.executeUpdate(sql);
		mysql.disConnect();
	}
	
}
