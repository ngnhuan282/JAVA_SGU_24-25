package BUS;

import java.util.ArrayList;

import DAO.ChiTietSPDAO;
import DTO.ChiTietSPDTO;

public class ChiTietSPBUS {
	private static ArrayList<ChiTietSPDTO> dsCTSP;
	
	public ChiTietSPBUS()
	{
		
	}
	
	public static ArrayList<ChiTietSPDTO> getDsCTSP() {
		return dsCTSP;
	}

	public static void setDsCTSP(ArrayList<ChiTietSPDTO> dsCTSP) {
		ChiTietSPBUS.dsCTSP = dsCTSP;
	}

	public void docDSCTSP(String maSP)
	{
		if(dsCTSP == null)
			dsCTSP = new ArrayList<ChiTietSPDTO>();
		ChiTietSPDAO dao = new ChiTietSPDAO();
		dsCTSP = dao.docDSCTSP(maSP);
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
