package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Mevcut_Tarifler
 */
@WebServlet("/mevcutTarifler")
public class Mevcut_Tarifler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mevcut_Tarifler() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			getServletContext().getRequestDispatcher("/hata.html").forward(request, response);
		}
		Connection myConnec;
		PreparedStatement preStat;
		ResultSet result;
		DBConnection mybag = new DBConnection();
		myConnec=mybag.setConnection();
		List<Tarif> tarifler = new ArrayList<Tarif>();
		try {
			preStat = myConnec.prepareStatement("SELECT * FROM tarifler ORDER BY id");
			result = preStat.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				String tarif_adi = result.getString("adi");
				String tarif_tarifi = result.getString("tarifi");
				String tarif_malzemesi = result.getString("malzemesi");
				Tarif tarif = new Tarif(id, tarif_adi, tarif_tarifi, tarif_malzemesi);
				tarifler.add(tarif);
			}
			request.setAttribute("tarifler", tarifler);
			getServletContext().getRequestDispatcher("/mevtarifler.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mybag.closeConnection();
		}
	}

}
