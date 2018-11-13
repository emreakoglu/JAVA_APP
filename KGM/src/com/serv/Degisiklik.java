package com.serv;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class Degisiklik
 */
@WebServlet("/degisiklik")
public class Degisiklik extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Degisiklik() {
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
		int tutanak_id = (int) session.getAttribute("tutanak_id");  // tutanak_inceledeki tutanak_id 
		System.out.println(tutanak_id);
		String eylem = (String)request.getParameter("select");  // eyleme göre 
		System.out.println(eylem);
		Connection myConnec;
		PreparedStatement preStat;
		ResultSet result;
		PostgreBaglantisi mybag=new PostgreBaglantisi();
		myConnec=mybag.setConnection();
		ArrayList <Kullanici> allusers=new ArrayList();
		if (eylem.equals("Goruldu")) {
			try {
				preStat = myConnec.prepareStatement("UPDATE tutanak SET goruldu = ? WHERE tutanak_id="+tutanak_id);
				preStat.setBoolean(1, true);
				preStat.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}
			response.sendRedirect("mevcuttutanaklar");
		}
		else if (eylem.equals("Sefe Sevk Et")) {
			try {
				preStat = myConnec.prepareStatement("UPDATE tutanak SET goruldu = ? WHERE tutanak_id="+tutanak_id);
				preStat.setBoolean(1, true);
				preStat.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}
			request.setAttribute("yapilacak", 1);
			getServletContext().getRequestDispatcher("/goruldu.jsp").forward(request, response);
		}
		else if (eylem.equals("Duzeltme Iste")){
			try {
				preStat = myConnec.prepareStatement("UPDATE tutanak SET goruldu = ? WHERE tutanak_id="+tutanak_id);
				preStat.setBoolean(1, true);
				preStat.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}
			request.setAttribute("yapilacak", 0);
			getServletContext().getRequestDispatcher("/goruldu.jsp").forward(request, response);
		}
		
	}

}
