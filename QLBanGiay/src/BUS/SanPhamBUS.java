package BUS;

import java.util.ArrayList;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;

public class SanPhamBUS {
	private static ArrayList<SanPhamDTO> dssp;
	
	public SanPhamBUS()
	{
		
	}
	
	public ArrayList<SanPhamDTO> getDssp() {
		return dssp;
	}
	
	public String validateSanPham(SanPhamDTO sp)
	{
		if(sp.getMaSP().isEmpty()) return "Vui lòng nhập mã sản phẩm";
		if(sp.getTenSP().isEmpty()) return "Vui lòng nhập tên sản phẩm";
		if(sp.getMaLoaiSP().isEmpty()) return "Vui lòng nhập mã loại sản phẩm";
		if(sp.getDonGia() <= 0) return "Đơn giá phải lớn hơn 0";
		if(sp.getSoLuong() <= 0) return "Số lượng phải lốn hôn 0";
		if(sp.getDonViTinh().isEmpty()) return "Vui lòng nhập đơn vị tính";
		
		if(!sp.getMaSP().matches("SP\\d{3}")) return "Mã SP phải có dạng SPxxx";
		
		return null;
	}
	
	public void listSP()
	{
		
	}
	
	public void addSP(SanPhamDTO sp)
	{	
		if(sp.getMaSP().isEmpty() || sp.getTenSP().isEmpty() || sp.getMaLoaiSP().isEmpty()
				|| sp.getDonViTinh().isEmpty())
		{
			System.out.println("Vui lòng nhập đầy đủ thông tin");
			return;
		}
		if(sp.getSoLuong() < 0)
		{
			System.out.println("Vui lòng nhập số lượng lớn hơn 0");
			return;
		}
		if(sp.getDonGia() < 0)
		{
			System.out.println("Vui lòng nhập đơn giá lớn hôn 0");
			return;
		}
		dssp.add(sp);
	}
	
	public void deleteSP(String maSP)
	{
		for(int i=0; i < dssp.size(); i++)
		{
			if(dssp.get(i).getMaSP().equals(maSP))
			{
				SanPhamDAO dao = new SanPhamDAO();
				dao.delete(maSP);
				dssp.remove(i);
			}
		}
	}
	
	public void updateSP(SanPhamDTO sp)
	{	
		for(int i=0; i < dssp.size(); i++)
		{
			dssp.set(i, sp);
		}
	}
}
