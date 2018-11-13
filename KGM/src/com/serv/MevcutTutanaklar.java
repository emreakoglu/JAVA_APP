package com.serv;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MevcutTutanaklar
 */
@WebServlet("/mevcuttutanaklar")
public class MevcutTutanaklar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MevcutTutanaklar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Connection myConnec;
		PreparedStatement preStat;
		PreparedStatement preStat1;
		PreparedStatement preStat2;
		ResultSet result;
		ResultSet result1;
		ResultSet result2;
		PostgreBaglantisi mybag=new PostgreBaglantisi();
		myConnec=mybag.setConnection();
		ArrayList<TutanakExample> alltutanak=new ArrayList<TutanakExample>();
		String adi="",soyadi="",adi_soyadi="",kategori="";
		try {
			preStat = myConnec.prepareStatement("SELECT * FROM tutanak WHERE goruldu="+false);
			result=preStat.executeQuery();
			while (result.next()){
				int tutanak_id=result.getInt("tutanak_id");
				int  kategori_id = result.getInt("kategori_id");
				String adres=result.getString("adres");
				String aciklama=result.getString("aciklama");
				boolean onay=result.getBoolean("onay");
				int kullanici_id=result.getInt("kullanici_id");
				try {
					preStat1 = myConnec.prepareStatement("SELECT adi,soyadi FROM kullanici WHERE kullanici_id="+kullanici_id);
					result1=preStat1.executeQuery();
					while(result1.next()){
						adi = result1.getString("adi");
						soyadi = result1.getString("soyadi");
						adi_soyadi=adi+soyadi;
					}
				}catch (SQLException e){
					e.printStackTrace();
				}
				
				int resim_tablosu_id=result.getInt("resim_tablosu_id");
				String zaman = result.getString("tarih");
				try {
					preStat2 = myConnec.prepareStatement("SELECT kategori_adi FROM kategori WHERE kategori_id="+kategori_id);
					result2 = preStat2.executeQuery();
					while(result2.next()){
						kategori = result2.getString("kategori_adi");
					}	
				}catch (SQLException e){
						e.printStackTrace();
				}
				TutanakExample a=new TutanakExample(tutanak_id,kategori_id,adres,aciklama,onay,adi_soyadi,resim_tablosu_id,zaman,kategori);
				alltutanak.add(a);
			}
			request.setAttribute("alltutanak", alltutanak);
			getServletContext().getRequestDispatcher("/mevtutanak.jsp").forward(request, response);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

}
