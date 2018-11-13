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
 * Servlet implementation class Tutanak_Incele
 */
@WebServlet("/tutanak_incele")
public class Tutanak_Incele extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tutanak_Incele() {
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
		String tut_id = request.getParameter("tutanak_id"); 
		int tutanak_id = Integer.parseInt(tut_id);
		session.setAttribute("tutanak_id", tutanak_id); // hangi tutanagi inceleyecekse ona karar verir
		String tur = request.getParameter("tur");
		System.out.println(tur);
		System.out.println(tutanak_id);
		Connection myConnec;
		PreparedStatement preStat;
		ResultSet result;
		PreparedStatement preStat1;
		ResultSet result1;
		PostgreBaglantisi mybag=new PostgreBaglantisi();
		myConnec=mybag.setConnection();
		ArrayList <Taraf> taraflar=new ArrayList();
		String aciklama="",tarih="";
		int resim_tablosu_id=0;
		String adi="",soyadi="",dogum_yeri="",baba_adi="",ikametkah="",tel_no="";
		try {
			preStat = myConnec.prepareStatement("SELECT resim_tablosu_id,aciklama,tarih FROM tutanak WHERE tutanak_id="+tutanak_id);
			result= preStat.executeQuery();
			while(result.next()) {
				aciklama = result.getString("aciklama");
				tarih = result.getString("tarih");
				resim_tablosu_id=result.getInt("resim_tablosu_id");
				System.out.println(aciklama+tarih);
			}
			Incele a = new Incele(tur,aciklama,tarih,tutanak_id);
			preStat1 = myConnec.prepareStatement("SELECT * FROM kisiler WHERE tutanak_id="+tutanak_id);
			result1 = preStat1.executeQuery();
			while (result1.next()){
				String adi_soyadi = result1.getString("ad_soyad");
				String[] str = adi_soyadi.split(" ");
				adi = str[0];
				soyadi=str[1];
				dogum_yeri = result1.getString("dogum_yeri");
				baba_adi = result1.getString("baba_adi");
				ikametkah = result1.getString("ikametkah_adresi");
				tel_no = result1.getString("tel_no");
				System.out.println(adi+soyadi+dogum_yeri+baba_adi+ikametkah+tel_no);
				Taraf t = new Taraf(adi,soyadi,baba_adi,dogum_yeri,ikametkah,tel_no);
				taraflar.add(t);
				}
			request.setAttribute("tutanagi", a);
			request.setAttribute("taraflar", taraflar);	
			System.out.println(resim_tablosu_id);
			String [] yollar_butun = new String [10];
			ArrayList <String> yollar = new ArrayList ();
			preStat = myConnec.prepareStatement("SELECT * FROM resim_tablosu WHERE resim_tablosu_id="+resim_tablosu_id);
			result = preStat.executeQuery();
			while(result.next()){
				for (int i =0;i<10;i++){
					yollar_butun[i] = result.getString("yol"+(i+1));
				}
			}
			System.out.println(yollar_butun[0]);
			for (int j = 0;j<10;j++){
				if (yollar_butun[j]!= null){
					yollar.add(yollar_butun[j]); // sadece dolu haneler yollara eklenecek
				}
			}
			System.out.println(yollar.toString());
			request.setAttribute("yollar", yollar);
			getServletContext().getRequestDispatcher("/Tutanak_Incele.jsp").forward(request, response);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

}
