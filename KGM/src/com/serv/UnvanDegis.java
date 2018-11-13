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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UnvanDegis
 */
@WebServlet("/unvandegis")
public class UnvanDegis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnvanDegis() {
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
		HttpSession session=request.getSession();
		String unvan = request.getParameter("unvan");
		System.out.println("Gelen unvan degeri "+unvan);
		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);
		System.out.println("Gelen id degeri "+id);
		Connection myConnec;
		PreparedStatement preStat;
		ResultSet result;
		PostgreBaglantisi mybag=new PostgreBaglantisi();
		myConnec=mybag.setConnection();
		try {
			preStat = myConnec.prepareStatement("UPDATE kullanici SET unvan=? WHERE kullanici_id="+id);
			preStat.setString(1, unvan);
			preStat.executeUpdate();
			response.sendRedirect("admin");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
