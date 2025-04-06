package BUS;

import java.util.ArrayList;

import DAO.LoaiDAO;
import DTO.LoaiDTO;

public class LoaiBUS {
	private static ArrayList<LoaiDTO> dsloai;
	
	public LoaiBUS()
	{
		
	}
	
	public void docDSLoai()
	{
		if(dsloai == null)
			dsloai = new ArrayList<LoaiDTO>();
		LoaiDAO loaiDAO = new LoaiDAO();
		dsloai = loaiDAO.docDSLoai();
	}
	
	public void add(LoaiDTO loai)
	{
		for(LoaiDTO x : dsloai)
		{
			if(x.equals(loai.getMaLoaiSP()))
				return;
			LoaiDAO loaiDAO = new LoaiDAO();
			loaiDAO.add(loai);
			dsloai.add(loai);
		}
	}
	
	public void update(LoaiDTO loai)
	{
		for(int i=0; i < dsloai.size(); i++)
		{
			if(dsloai.get(i).equals(loai.getMaLoaiSP()))
			{
				LoaiDAO loaiDAO = new LoaiDAO();
				loaiDAO.update(loai);
				dsloai.set(i, loai);
				return;
			}
		}
	}
}
