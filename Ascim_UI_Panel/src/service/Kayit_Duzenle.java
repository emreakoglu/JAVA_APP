package service;

import java.io.File;
import java.io.IOException;
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
 * Servlet implementation class Kayit_Duzenle
 */
@WebServlet("/kayit_duzenle")
@MultipartConfig
public class Kayit_Duzenle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String SAVE_DIR = "image";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kayit_Duzenle() {
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
			File eskiResim = new File(savePath + File.separator + tarif_no+".jpg");
			if (eskiResim.exists()) {
				eskiResim.delete();
			}
			filePart.write(savePath + File.separator + tarif_no+".jpg");
		}
		
		Connection myConnec;
		PreparedStatement preStat;
		ResultSet result;
		DBConnection mybag = new DBConnection();
		myConnec=mybag.setConnection();
		
		try {
			preStat = myConnec.prepareStatement("UPDATE tarifler SET adi = ?,tarifi = ?,malzemesi = ? WHERE id="+tarif_no);
			preStat.setString(1, tarif_ismi);
			preStat.setString(2, tarif);
			preStat.setString(3, malzemeler);
			preStat.executeUpdate();
			request.getRequestDispatcher("anasayfa.jsp").include(request, response);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

}
