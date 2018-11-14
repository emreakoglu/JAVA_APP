package service;

import java.io.File;
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
 * Servlet implementation class Sil
 */
@WebServlet("/sil")
public class Sil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "image";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sil() {
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
		
		String tarif_no = request.getParameter("tarif_id");
		int tarif_id = Integer.parseInt(tarif_no);
		File deletePhoto = new File(savePath + File.separator + tarif_no+".jpg");
		if (deletePhoto.exists()) {
			deletePhoto.delete();
		}
		Connection myConnec;
		PreparedStatement preStat;
		ResultSet result;
		DBConnection mybag = new DBConnection();
		myConnec=mybag.setConnection();
		try {
			preStat = myConnec.prepareStatement("DELETE FROM tarifler WHERE id="+tarif_id);
			preStat.executeUpdate();
			response.sendRedirect("mevcutTarifler");
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

}
