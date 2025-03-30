package BUS;

import java.util.ArrayList;

import DTO.SanPhamDTO;

public class SanPhamBUS {
	private ArrayList<SanPhamDTO> dssp;
	
	public SanPhamBUS()
	{
		dssp = new ArrayList<>();
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
		dssp.add(sp);
	}
	
	public void deleteSP(String maSP)
	{
		for(SanPhamDTO sp : dssp)
		{
			if(sp.getMaSP().equals(maSP))
			{
				dssp.remove(sp);
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
