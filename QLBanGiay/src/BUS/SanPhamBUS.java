package BUS;

import java.util.ArrayList;

import DAO.SanPhamDAO;
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
	
	public void deleteSP(int idSP)
	{
		for(SanPhamDTO sp : dssp)
		{
			if(sp.getMaSP() == idSP)
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
