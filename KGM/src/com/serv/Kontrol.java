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

/**
 * Servlet implementation class Kontrol
 */
@WebServlet("/kontrol")
public class Kontrol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kontrol() {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Connection myConnec;
		PreparedStatement preStat;
		ResultSet result;
		PostgreBaglantisi mybag=new PostgreBaglantisi();
		myConnec=mybag.setConnection();
		String a1="",a2="",a="",unvan="";
		int id=0,sef_id=0;
		System.out.println(username);
		System.out.println(password);
		try {
			preStat = myConnec.prepareStatement("SELECT * FROM kullanici WHERE username=\'"+username+"\'");
			result=preStat.executeQuery();
			if (result!=null){
				while(result.next()){
					if (password.equals(result.getString("password"))){
						System.out.println("buradayim");
						a = result.getString("username");
						System.out.println(a);
						a1 = result.getString("adi");
						a2 = result.getString("soyadi");
						id=result.getInt("kullanici_id");
						session.setAttribute("adi", a1);
						session.setAttribute("soyadi", a2);
						session.setAttribute("id", id);
						if (username.equals("admin")){
							System.out.println("admin girisi onaylandi");
							response.sendRedirect("admin");
							break;
						}else {
						request.getRequestDispatcher("anasayfa.jsp").include(request, response);
						break;}
					}else{
						PrintWriter out=response.getWriter();
						out.println("<script language=\"javascript\">");
						out.println("alert(\"Parola Yanlis\");");
						out.println("</script>");
						request.getRequestDispatcher("login.html").include(request, response);
						out.close();
						
					}
				}
					
			}
			else {
				PrintWriter out=response.getWriter();
				out.println("<script language=\"javascript\">");
				out.println("alert(\"Kullanici Kayitli Degil Tekrar Giriniz\");");
				out.println("</script>");
				request.getRequestDispatcher("login.html").include(request, response);
				out.close();
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			mybag.closeConnection();
		}
	}

}
