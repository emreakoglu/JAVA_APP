package com.serv;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PhoneGap
 */
@WebServlet("/PhoneGap")
public class PhoneGap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhoneGap() {
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
		Connection myConnec;
		PreparedStatement preStat;
		PreparedStatement preStat1;
		PreparedStatement preStat2;
		ResultSet result;
		ResultSet result1;
		ResultSet result2;
		PostgreBaglantisi mybag=new PostgreBaglantisi();
		String kul_id = request.getParameter("kul_id");
		int id = Integer.parseInt(kul_id);
		String kategori = request.getParameter("kategori");
		int kat = Integer.parseInt(kategori);
		String adres = request.getParameter("adres");
		String adi_soyadi=request.getParameter("name");
		String dogum_yeri=request.getParameter("dogum_yeri");
		String baba=request.getParameter("babaadi");
		System.out.println(baba);
		String ikametkah=request.getParameter("ikametkah");
		String telefon=request.getParameter("telefon");
		String dogum_tarihi=request.getParameter("dogum_tarihi");
		Date tarih1 =new Date();
		java.sql.Date tarih = new java.sql.Date(tarih1.getTime());
		String aciklama = request.getParameter("aciklama");
		boolean onay = true;
		myConnec=mybag.setConnection();
		try {
			preStat = myConnec.prepareStatement("INSERT INTO tutanak(kategori_id,adres,aciklama,onay,kullanici_id,tarih) VALUES(?,?,?,?,?,?)");
			preStat.setInt(1, kat);
			preStat.setString(2, adres);
			preStat.setString(3, aciklama);
			preStat.setBoolean(4, onay);
			preStat.setInt(5, id);
			preStat.setDate(6, tarih);
			preStat.executeUpdate();
			preStat1 = myConnec.prepareStatement("INSERT INTO kisiler (ad_soyad,dogum_yeri,baba_adi,ikametkah_adresi,tel_no,kat_id,tutanak_id,dogum_tarihi) VALUES(?,?,?,?,?,?,?,?)");
			preStat.setString(1, adi_soyadi);
			preStat.setString(2, dogum_yeri);
			preStat.setString(3, baba);
			preStat.setString(4, ikametkah);
			preStat.setString(5, telefon);
			preStat.setInt(6, kat);
			preStat1.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

}
