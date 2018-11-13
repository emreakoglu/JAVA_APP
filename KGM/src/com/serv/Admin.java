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
 * Servlet implementation class Admin
 */
@WebServlet("/admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
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
		ResultSet result;
		PostgreBaglantisi mybag=new PostgreBaglantisi();
		myConnec=mybag.setConnection();
		ArrayList <Kullanici> allusers=new ArrayList();
		HttpSession session =request.getSession();
		try {
			preStat = myConnec.prepareStatement("SELECT * FROM kullanici");
			result= preStat.executeQuery();
			while(result.next()){
				int kullanici_id = result.getInt("kullanici_id");
				session.setAttribute("id", kullanici_id);
				String adi = result.getString("adi");
				String soyadi = result.getString("soyadi");
				String unvan=result.getString("unvan");
				//System.out.println(unvan);
				String yetki = result.getString("yetki");
				String username=result.getString("username");
				String password=result.getString("password");
				Kullanici a = new Kullanici(kullanici_id,adi,soyadi,unvan,yetki,username,password);
				allusers.add(a);
			}
			request.setAttribute("allusers", allusers);
			getServletContext().getRequestDispatcher("/sistem.jsp").forward(request, response);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
