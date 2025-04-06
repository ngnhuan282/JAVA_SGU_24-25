package BUS;

import java.util.ArrayList;

import DAO.ChiTietSPDAO;
import DTO.ChiTietSPDTO;

public class ChiTietSPBUS {
	private static ArrayList<ChiTietSPDTO> dsCTSP;
	
	public ChiTietSPBUS()
	{
		
	}
	
	public void docDSCTSP(String maSP)
	{
		if(dsCTSP == null)
			dsCTSP = new ArrayList<ChiTietSPDTO>();
		ChiTietSPDAO dao = new ChiTietSPDAO();
		dao.docDSCTSP(maSP);
	}
	
	public void add(ChiTietSPDTO ctsp)
	{
		ChiTietSPDAO dao = new ChiTietSPDAO();
		dao.add(ctsp);
	}
	
	public void delete(String maSP)
	{
		ChiTietSPDAO dao = new ChiTietSPDAO();
		dao.delete(maSP);
	}
}
