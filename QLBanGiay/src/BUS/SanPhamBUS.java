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

	public void listSP()
	{
		
	}
	
	public void addSP(SanPhamDTO sp)
	{
		dssp.add(sp);
	}
	
	public void deleteSP(String idSP)
	{
		for(SanPhamDTO sp : dssp)
		{
			
		}
	}
}
