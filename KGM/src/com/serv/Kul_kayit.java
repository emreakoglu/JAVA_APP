package com.serv;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Kul_kayit
 */
@WebServlet("/kul_kayit")
public class Kul_kayit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kul_kayit() {
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
		String adi=request.getParameter("adi");
		String soyadi=request.getParameter("soyadi");
		String unvan=request.getParameter("unvan");
		String yetki=request.getParameter("yetki");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(adi+soyadi+unvan+yetki+username+password);
		Connection myConnec;
		PreparedStatement preStat;
		ResultSet result;
		PostgreBaglantisi mybag=new PostgreBaglantisi();
		myConnec=mybag.setConnection();
		try {
			preStat = myConnec.prepareStatement("INSERT INTO kullanici (adi,soyadi,unvan,yetki,username,password) VALUES(?,?,?,?,?,?)");
			preStat.setString(1, adi);
			preStat.setString(2, soyadi);
			preStat.setString(3, unvan);
			preStat.setString(4, yetki);
			preStat.setString(5, username);
			preStat.setString(6, password);
			preStat.executeUpdate();
			response.sendRedirect("admin");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
