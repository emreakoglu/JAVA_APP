package com.serv;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Tutanak
 */
@WebServlet("/tutanak")
public class Tutanak extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tutanak() {
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
		String gorsel = request.getParameter("gorsel");
		System.out.println(gorsel); // gorsel 1 ise resimekleye gidilecek 
		String kategori = request.getParameter("kategori");
		System.out.println(kategori);
		HashMap <String,Integer> i = new HashMap();
		i.put("Trafik Kurali Ihlali", 1);  // buraya daha sonra diðer olaylarý da ekleyeceðim
		i.put("Kavga", 2);
		i.put("Trafik kazasi", 3);
		i.put("Izinsiz Gosteri", 4);
		i.put("Hirsizlik", 5);
		i.put("Hiz Sinirini Asma", 6);
		i.put("Izinsiz Giris", 7);
		int kat = i.get(kategori);
		String adres = request.getParameter("adres");
		//String tarih2 = request.getParameter("zaman");
		Date tarih1 =new Date();
		java.sql.Date tarih = new java.sql.Date(tarih1.getTime());
		String aciklama = request.getParameter("aciklama");
		boolean onay = true;
		HttpSession session = request.getSession();
		session.setAttribute("kat_id", kat);
		int id = (int) session.getAttribute("id");  // kullanici idsi
		Connection myConnec;
		PreparedStatement preStat;
		PreparedStatement preStat1;
		ResultSet result;
		ResultSet result1;		
		PostgreBaglantisi mybag=new PostgreBaglantisi();
		myConnec=mybag.setConnection();
		try {
			preStat = myConnec.prepareStatement("INSERT INTO tutanak(kategori_id,adres,aciklama,onay,kullanici_id,tarih) VALUES(?,?,?,?,?,?)");
			preStat.setInt(1, kat);
			preStat.setString(2, adres);
			preStat.setString(3, aciklama);
			preStat.setBoolean(4, onay);
			preStat.setInt(5, id);
			/*preStat.executeUpdate();
			preStat1 = myConnec.prepareStatement("SELECT resim_tablosu_id FROM resim_tablosu ORDER BY resim_tablosu_id DESC LIMIT 1 ");
			result = preStat1.executeQuery();
			int a=0;
			while(result.next()){
				a = result.getInt("resim_tablosu_id");
				a=a+1;
				 // Resim Tablosunun son elemanýný tutanaðýn id si olur.
						// resim_tablosu_id= tutanak_id  (Keþke resim_tablosu_id de serial olsaydý :( )
			}*/
			//preStat.setInt(6, 0);
			preStat.setDate(6, tarih);
			preStat.executeUpdate();
			if (gorsel.equals("1")){
				request.getRequestDispatcher("resimekle.jsp").include(request, response);
			}else {
				request.getRequestDispatcher("kisiekle.jsp").include(request, response);  //þimdi olayýn kiþilerini teker teker ekle
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
