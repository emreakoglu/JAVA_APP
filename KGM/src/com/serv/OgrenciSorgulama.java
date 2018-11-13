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

/**
 * Servlet implementation class OgrenciSorgulama
 */
@WebServlet("/OgrenciSorgulama")
public class OgrenciSorgulama extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OgrenciSorgulama() {
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
		String ogrenci_id = request.getParameter("ogrenci_num");
		System.out.println(ogrenci_id);
		Connection myConnec;
		PreparedStatement preStat;
		ResultSet result;
		PostgreBaglantisi mybag=new PostgreBaglantisi();
		myConnec=mybag.setConnection();
		Ogrenci a = null;
		try {
			preStat = myConnec.prepareStatement("SELECT * FROM ogrenci WHERE ogrenci_id=\'"+ogrenci_id+"\'");
			result = preStat.executeQuery();
			while(result.next()) {
				String adi = result.getString("adi");
				String soyadi = result.getString("soyadi");
				String bolum = result.getString("bolum");
				String fakulte = result.getString("fakulte");
				a =new Ogrenci(adi,soyadi,bolum,fakulte);
			}
			request.setAttribute("ogrenci", a);
			getServletContext().getRequestDispatcher("/ogrenci_sorgula.jsp").forward(request, response);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

}
