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

/**
 * Servlet implementation class Ara
 */
@WebServlet("/ara")
public class Ara extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ara() {
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
		System.out.println("buradayim");
		String kategori = request.getParameter("kategori");
		String aralik1 = request.getParameter("aralik1");
		String aralik2 = request.getParameter("aralik2");
		String duzenleyen = request.getParameter("duzenleyen");
		System.out.println(kategori+aralik1+aralik2+duzenleyen);
		String[] str = duzenleyen.split(" ");
		int kategori_id=0;
		int kullanici_id=0;
		Connection myConnec;
		PreparedStatement preStat;
		ResultSet result;
		PreparedStatement preStat1;
		ResultSet result1;
		PreparedStatement preStat2;
		ResultSet result2;
		PostgreBaglantisi mybag=new PostgreBaglantisi();
		myConnec=mybag.setConnection();
		ArrayList <TutanakExample> tutanaklar = new ArrayList<TutanakExample> ();
		try {
			if (!kategori.equals("Seciniz")){
				preStat1 = myConnec.prepareStatement("SELECT kategori_id FROM kategori WHERE kategori_adi=\'"+kategori+"\'");
				result1 = preStat1.executeQuery();
				while(result1.next()){
					kategori_id = result1.getInt("kategori_id"); // kategoriye göre sýralama yaparken kullncaðým
				}
			}
			System.out.println(kategori_id);
			if (!duzenleyen.equals("")){
				preStat1 = myConnec.prepareStatement("SELECT kullanici_id FROM kullanici WHERE adi=\'"+str[0]+"\' AND soyadi=\'"+str[1]+"\'");
				result1 = preStat1.executeQuery();
				while(result1.next()){
					kullanici_id = result1.getInt("kullanici_id"); // düzenleyene göre sýralama yaparken  kullanacaðým 
				}
			}	
		}catch(SQLException e){
			e.printStackTrace();
		}
		boolean exit = false;
		String adi="",soyadi="",ad_soyadi="";
		if (kategori.equals("Seciniz") && duzenleyen.equals("") && (aralik1.equals("") && aralik2.equals(""))){
			// arama sýrasý verilmemiþ.
			response.sendRedirect("mevcutlar");
		}
		if(!kategori.equals("Seciniz") && !duzenleyen.equals("") && (!aralik1.equals("") && !aralik2.equals(""))){
			// 3 ÞEYE GÖRE ARAMA YAP
			try {
				preStat = myConnec.prepareStatement("SELECT * FROM tutanak WHERE kategori_id="+kategori_id+" AND tarih BETWEEN \'"+aralik1+"\' AND \'"+aralik2+"\' AND kullanici_id="+kullanici_id);
				result = preStat.executeQuery();
				while(result.next()){
					int tutanak_id = result.getInt("tutanak_id");
					int kat_id = result.getInt("kategori_id");
					String adres = result.getString("adres");
					String aciklama = result.getString("aciklama");
					boolean onay = result.getBoolean("onay");
					int kul_id = result.getInt("kullanici_id");
					try {
						preStat2 = myConnec.prepareStatement("SELECT adi,soyadi FROM kullanici WHERE kullanici_id="+kul_id);
						result2 = preStat2.executeQuery();
						while (result2.next()){
							adi = result2.getString("adi");
							soyadi = result2.getString("soyadi");
							ad_soyadi = adi+soyadi;
						}
					}catch(SQLException e){
						e.printStackTrace();
					}
					int resim_tablosu_id = result.getInt("resim_tablosu_id");
					String tarih = result.getString("tarih");
					String kat = kategori ;
					TutanakExample a = new TutanakExample(tutanak_id,kat_id,adres,aciklama,onay,ad_soyadi,resim_tablosu_id,tarih,kat);
					tutanaklar.add(a);
				}
				request.setAttribute("alltutanak", tutanaklar);
				getServletContext().getRequestDispatcher("/tutanaklar.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!kategori.equals("Seciniz")){
			if (duzenleyen.equals("") && (aralik1.equals("") && aralik2.equals(""))){
				//sadece kategoriye gore sýrala
				try {
					preStat = myConnec.prepareStatement("SELECT * FROM tutanak WHERE kategori_id="+kategori_id);
					result = preStat.executeQuery();
					while(result.next()){
						int tutanak_id = result.getInt("tutanak_id");
						int kat_id = result.getInt("kategori_id");
						String adres = result.getString("adres");
						String aciklama = result.getString("aciklama");
						boolean onay = result.getBoolean("onay");
						int kul_id = result.getInt("kullanici_id");
						try {
							preStat2 = myConnec.prepareStatement("SELECT adi,soyadi FROM kullanici WHERE kullanici_id="+kul_id);
							result2 = preStat2.executeQuery();
							while (result2.next()){
								adi = result2.getString("adi");
								soyadi = result2.getString("soyadi");
								ad_soyadi = adi+soyadi;
							}
						}catch(SQLException e){
							e.printStackTrace();
						}
						int resim_tablosu_id = result.getInt("resim_tablosu_id");
						String tarih = result.getString("tarih");
						String kat = kategori ;
						TutanakExample a = new TutanakExample(tutanak_id,kat_id,adres,aciklama,onay,ad_soyadi,resim_tablosu_id,tarih,kat);
						tutanaklar.add(a);
					}
					request.setAttribute("alltutanak", tutanaklar);
					getServletContext().getRequestDispatcher("/tutanaklar.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ifi býrak
				
			}else if (!duzenleyen.equals("") && (aralik1.equals("") && aralik2.equals(""))){
				//kategori ve duzenleyene göre sýrala
				try {
					preStat = myConnec.prepareStatement("SELECT * FROM tutanak WHERE kategori_id="+kategori_id+" AND kullanici_id="+kullanici_id);
					result = preStat.executeQuery();
					while(result.next()){
						int tutanak_id = result.getInt("tutanak_id");
						int kat_id = result.getInt("kategori_id");
						String adres = result.getString("adres");
						String aciklama = result.getString("aciklama");
						boolean onay = result.getBoolean("onay");
						int kul_id = result.getInt("kullanici_id");
						try {
							preStat2 = myConnec.prepareStatement("SELECT adi,soyadi FROM kullanici WHERE kullanici_id="+kul_id);
							result2 = preStat2.executeQuery();
							while (result2.next()){
								adi = result2.getString("adi");
								soyadi = result2.getString("soyadi");
								ad_soyadi = adi+soyadi;
							}
						}catch(SQLException e){
							e.printStackTrace();
						}
						int resim_tablosu_id = result.getInt("resim_tablosu_id");
						String tarih = result.getString("tarih");
						String kat = kategori ;
						TutanakExample a = new TutanakExample(tutanak_id,kat_id,adres,aciklama,onay,ad_soyadi,resim_tablosu_id,tarih,kat);
						tutanaklar.add(a);
					}
					request.setAttribute("alltutanak", tutanaklar);
					getServletContext().getRequestDispatcher("/tutanaklar.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 // if break;
			}
			else if (duzenleyen.equals("") && (!aralik1.equals("") && !aralik2.equals(""))){
				// kategori ve tarih aralýðýna göre sýrala
				try {
					preStat = myConnec.prepareStatement("SELECT * FROM tutanak WHERE kategori_id="+kategori_id+" AND tarih BETWEEN \'"+aralik1+"\' AND \'"+aralik2+"\'");
					result = preStat.executeQuery();
					while(result.next()){
						int tutanak_id = result.getInt("tutanak_id");
						int kat_id = result.getInt("kategori_id");
						String adres = result.getString("adres");
						String aciklama = result.getString("aciklama");
						boolean onay = result.getBoolean("onay");
						int kul_id = result.getInt("kullanici_id");
						try {
							preStat2 = myConnec.prepareStatement("SELECT adi,soyadi FROM kullanici WHERE kullanici_id="+kul_id);
							result2 = preStat2.executeQuery();
							while (result2.next()){
								adi = result2.getString("adi");
								soyadi = result2.getString("soyadi");
								ad_soyadi = adi+soyadi;
							}
						}catch(SQLException e){
							e.printStackTrace();
						}
						int resim_tablosu_id = result.getInt("resim_tablosu_id");
						String tarih = result.getString("tarih");
						String kat = kategori ;
						TutanakExample a = new TutanakExample(tutanak_id,kat_id,adres,aciklama,onay,ad_soyadi,resim_tablosu_id,tarih,kat);
						tutanaklar.add(a);
					}
					request.setAttribute("alltutanak", tutanaklar);
					getServletContext().getRequestDispatcher("/tutanaklar.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// if break;
			}
		}
		if (!duzenleyen.equals("")){
			if (kategori.equals("Seciniz") && (aralik1.equals("") && aralik2.equals(""))){
				// sadece duzenleyene gore sýralama
				try {
					preStat = myConnec.prepareStatement("SELECT * FROM tutanak WHERE kullanici_id="+kullanici_id);
					result = preStat.executeQuery();
					while(result.next()){
						int tutanak_id = result.getInt("tutanak_id");
						int kat_id = result.getInt("kategori_id");
						String adres = result.getString("adres");
						String aciklama = result.getString("aciklama");
						boolean onay = result.getBoolean("onay");
						int kul_id = result.getInt("kullanici_id");
						try {
							preStat2 = myConnec.prepareStatement("SELECT adi,soyadi FROM kullanici WHERE kullanici_id="+kul_id);
							result2 = preStat2.executeQuery();
							while (result2.next()){
								adi = result2.getString("adi");
								soyadi = result2.getString("soyadi");
								ad_soyadi = adi+soyadi;
							}
						}catch(SQLException e){
							e.printStackTrace();
						}
						int resim_tablosu_id = result.getInt("resim_tablosu_id");
						String tarih = result.getString("tarih");
						String kat = "" ;
						try {
							preStat2 = myConnec.prepareStatement("SELECT kategori_adi FROM kategori WHERE kategori_id="+kat_id);
							result2 = preStat2.executeQuery();
							while (result2.next()){
								kat = result2.getString("kategori_adi");
							}
						}catch (SQLException e){
							e.printStackTrace();
						}
						
						TutanakExample a = new TutanakExample(tutanak_id,kat_id,adres,aciklama,onay,ad_soyadi,resim_tablosu_id,tarih,kat);
						tutanaklar.add(a);
					}
					request.setAttribute("alltutanak", tutanaklar);
					getServletContext().getRequestDispatcher("/tutanaklar.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// if break;
			}
			else if (kategori.equals("Seciniz") && (!aralik1.equals("") && !aralik2.equals(""))) {
				// duzenleyen ve tarihe gore
				try {
					preStat = myConnec.prepareStatement("SELECT * FROM tutanak WHERE kullanici_id="+kullanici_id+" AND tarih BETWEEN \'"+aralik1+"\' AND \'"+aralik2+"\'");
					result = preStat.executeQuery();
					while(result.next()){
						int tutanak_id = result.getInt("tutanak_id");
						int kat_id = result.getInt("kategori_id");
						String adres = result.getString("adres");
						String aciklama = result.getString("aciklama");
						boolean onay = result.getBoolean("onay");
						int kul_id = result.getInt("kullanici_id");
						try {
							preStat2 = myConnec.prepareStatement("SELECT adi,soyadi FROM kullanici WHERE kullanici_id="+kul_id);
							result2 = preStat2.executeQuery();
							while (result2.next()){
								adi = result2.getString("adi");
								soyadi = result2.getString("soyadi");
								ad_soyadi = adi+soyadi;
							}
						}catch(SQLException e){
							e.printStackTrace();
						}
						int resim_tablosu_id = result.getInt("resim_tablosu_id");
						String tarih = result.getString("tarih");
						String kat = "" ;
						try {
							preStat2 = myConnec.prepareStatement("SELECT kategori_adi FROM kategori WHERE kategori_id="+kat_id);
							result2 = preStat2.executeQuery();
							while (result2.next()){
								kat = result2.getString("kategori_adi");
							}
						}catch (SQLException e){
							e.printStackTrace();
						}
						TutanakExample a = new TutanakExample(tutanak_id,kat_id,adres,aciklama,onay,ad_soyadi,resim_tablosu_id,tarih,kat);
						tutanaklar.add(a);
					}
					request.setAttribute("alltutanak", tutanaklar);
					getServletContext().getRequestDispatcher("/tutanaklar.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// if break;
			}
		}
		if ((!aralik1.equals("") && !aralik2.equals(""))) {
			if (kategori.equals("Seciniz") && duzenleyen.equals("")){
				// sadece tarihe gore
				try {
					preStat = myConnec.prepareStatement("SELECT * FROM tutanak WHERE tarih BETWEEN \'"+aralik1+"\' AND \'"+aralik2+"\'");
					result = preStat.executeQuery();
					while(result.next()){
						int tutanak_id = result.getInt("tutanak_id");
						int kat_id = result.getInt("kategori_id");
						String adres = result.getString("adres");
						String aciklama = result.getString("aciklama");
						boolean onay = result.getBoolean("onay");
						int kul_id = result.getInt("kullanici_id");
						try {
							preStat2 = myConnec.prepareStatement("SELECT adi,soyadi FROM kullanici WHERE kullanici_id="+kul_id);
							result2 = preStat2.executeQuery();
							while (result2.next()){
								adi = result2.getString("adi");
								soyadi = result2.getString("soyadi");
								ad_soyadi = adi+soyadi;
							}
						}catch(SQLException e){
							e.printStackTrace();
						}
						String kat = "" ;
						try {
							preStat2 = myConnec.prepareStatement("SELECT kategori_adi FROM kategori WHERE kategori_id="+kat_id);
							result2 = preStat2.executeQuery();
							while (result2.next()){
								kat = result2.getString("kategori_adi");
							}
						}catch (SQLException e){
							e.printStackTrace();
						}
						int resim_tablosu_id = result.getInt("resim_tablosu_id");
						String tarih = result.getString("tarih");
						
						TutanakExample a = new TutanakExample(tutanak_id,kat_id,adres,aciklama,onay,ad_soyadi,resim_tablosu_id,tarih,kat);
						tutanaklar.add(a);
					}
					request.setAttribute("alltutanak", tutanaklar);
					getServletContext().getRequestDispatcher("/tutanaklar.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				// if break;
			}
		}
	}
}
