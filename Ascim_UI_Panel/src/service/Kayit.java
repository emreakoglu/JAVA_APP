package service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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
 * Servlet implementation class Kayit
 */
@WebServlet("/kayit")
@MultipartConfig
public class Kayit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String SAVE_DIR = "image";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kayit() {
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
		
		String appPath = request.getServletContext().getRealPath("");
		String savePath = appPath + File.separator + SAVE_DIR;
		
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		
		String tarif_no = request.getParameter("tarif_no");
		String tarif_ismi = request.getParameter("tarif_ismi");
		String malzemeler = request.getParameter("malzemeler");
		String tarif = request.getParameter("tarif");
		
		final Part filePart = request.getPart("foto");
		if (filePart.getContentType().equals("image/jpeg")) {
			filePart.write(savePath + File.separator + tarif_no+".jpg");
		}
		
		Connection myConnec;
		PreparedStatement preStat;
		ResultSet result;
		DBConnection mybag = new DBConnection();
		myConnec=mybag.setConnection();
		
		try {
			preStat = myConnec.prepareStatement("INSERT INTO tarifler (id,adi,tarifi,malzemesi) VALUES(?,?,?,?)");
			preStat.setInt(1, Integer.parseInt(tarif_no));
			preStat.setString(2, tarif_ismi);
			preStat.setString(3, tarif);
			preStat.setString(4, malzemeler);
			preStat.executeUpdate();
			request.getRequestDispatcher("anasayfa.jsp").include(request, response);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

}
