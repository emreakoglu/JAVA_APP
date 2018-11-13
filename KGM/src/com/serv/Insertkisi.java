package com.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class InsertTutanak
 */
@WebServlet("/insertkisi")
public class Insertkisi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insertkisi() {
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
		String adi_soyadi=request.getParameter("name");
		String dogum_yeri=request.getParameter("dogum_yeri");
		String baba=request.getParameter("babaadi");
		System.out.println(baba);
		String ikametkah=request.getParameter("ikametkah");
		String telefon=request.getParameter("telefon");
		String dogum_tarihi=request.getParameter("dogum_tarihi");
		System.out.println(adi_soyadi+dogum_yeri+baba+ikametkah+telefon);
		int kategori = (int) session.getAttribute("kat_id");  // sayfada dolasan olayýn kategorisi
		Connection myConnec;
		PreparedStatement preStat;
		PreparedStatement preStat1;
		ResultSet result;
		PostgreBaglantisi mybag=new PostgreBaglantisi();
		myConnec=mybag.setConnection();
		PrintWriter out=response.getWriter();
		try {
			preStat = myConnec.prepareStatement("INSERT INTO kisiler (ad_soyad,dogum_yeri,baba_adi,ikametkah_adresi,tel_no,kat_id,tutanak_id,dogum_tarihi) VALUES(?,?,?,?,?,?,?,?)");
			preStat.setString(1, adi_soyadi);
			preStat.setString(2, dogum_yeri);
			preStat.setString(3, baba);
			preStat.setString(4, ikametkah);
			preStat.setString(5, telefon);
			preStat.setInt(6, kategori);
			preStat1= myConnec.prepareStatement("SELECT tutanak_id FROM tutanak ORDER BY tutanak_id DESC LIMIT 1 ");
			result = preStat1.executeQuery();
			int a=0;
			while(result.next()){
				a = result.getInt("tutanak_id");  // kisiler tablosuyla son tutanak tablosu iliþkilendirildi
			}
			preStat.setInt(7, a);
			preStat.setString(8, dogum_tarihi);
			preStat.executeUpdate();
			request.getRequestDispatcher("kisiekle.jsp").include(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
