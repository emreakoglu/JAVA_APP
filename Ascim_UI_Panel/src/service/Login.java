package service;

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
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Connection myConnec;
		PreparedStatement preStat;
		ResultSet result;
		DBConnection mybag = new DBConnection();
		myConnec=mybag.setConnection();
		String name = "",surname= "";
		try {
			preStat = myConnec.prepareStatement("SELECT * FROM kullanici WHERE username=\'"+username+"\'");
			result=preStat.executeQuery();
			if (result!=null){
				while(result.next()){
					if (password.equals(result.getString("password"))){
						System.out.println("buradayim");
						name = result.getString("name");
						surname = result.getString("surname");
						request.setAttribute("username", name);
						request.setAttribute("usersurname", surname);
						session.setAttribute("username", name);
						session.setAttribute("usersurname", surname);
						session.setAttribute("id", result.getInt("id"));
						request.getRequestDispatcher("anasayfa.jsp").include(request, response);
					
					}else{
						PrintWriter out=response.getWriter();
						out.println("<script language=\"javascript\">");
						out.println("alert(\"Parola Yanlis\");");
						out.println("</script>");
						request.getRequestDispatcher("index.jsp").include(request, response);
						out.close();
					}
				}
					
			}
			else {
				PrintWriter out=response.getWriter();
				out.println("<script language=\"javascript\">");
				out.println("alert(\"Kullanici Kayitli Degil Tekrar Giriniz\");");
				out.println("</script>");
				request.getRequestDispatcher("index.jsp").include(request, response);
				out.close();
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			mybag.closeConnection();
		}
	}

}
