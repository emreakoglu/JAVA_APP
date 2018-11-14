package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class TopluAktarım
 */
@WebServlet("/topluaktarim")
@MultipartConfig
public class TopluAktarim extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopluAktarim() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			getServletContext().getRequestDispatcher("/hata.html").forward(request, response);
		}
		Part filePart = request.getPart("file");
		
		Connection myConnec;
		PreparedStatement preStat;
		ResultSet result;
		DBConnection mybag = new DBConnection();
		myConnec=mybag.setConnection();
		
		InputStream fileContent = filePart.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(fileContent,StandardCharsets.UTF_8));
		
		String line;
		while ((line = br.readLine()) != null) {
			String[] tarifs = line.split("&");
			System.out.println(tarifs[0]);
			try {
				preStat = myConnec.prepareStatement("INSERT INTO tarifler (id,adi,tarifi,malzemesi) VALUES(?,?,?,?)");
				preStat.setInt(1, Integer.parseInt(tarifs[0]));
				preStat.setString(2, tarifs[1]);
				preStat.setString(3, tarifs[2]);
				preStat.setString(4, tarifs[3]);
				preStat.executeUpdate();
				
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		getServletContext().getRequestDispatcher("/anasayfa.jsp").forward(request, response);
	}

}
