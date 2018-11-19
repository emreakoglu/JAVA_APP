package com.serv;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class Resimekle
 */
@WebServlet("/resimekle")
public class Resimekle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VERI_YOLU = "data";
	private static final int MAX_BELLEK_BOYUTU = 1024 * 1024 * 2;
	private static final int MAX_ISTEK_BOYUTU = 1024 * 1024; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public Resimekle() {
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
		/* 
		 * 
		 * 		BURALARA UPLOAD KOMUTLARI GELECEK  .. BELKÝDE BAÞKA BÝR SEVLET DOSYASINDA YAPARIM
		 * */
		Connection myConnec;
		PreparedStatement preStat;
		PreparedStatement preStat1;
		ResultSet result;
		PostgreBaglantisi mybag=new PostgreBaglantisi();
		myConnec=mybag.setConnection();
		int tutanak_id=0;
		try {
			preStat = myConnec.prepareStatement("SELECT tutanak_id FROM tutanak ORDER BY tutanak_id DESC LIMIT 1");
			result = preStat.executeQuery();
			while(result.next()){
				tutanak_id = result.getInt("tutanak_id"); // son tutanak id
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		int resim_tablosu_id = 0;
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(!isMultipart) {
			return ;
		}
		// Dosyayý yerleþtirmek için geçcici bir fabrika oluþturma
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// DOsyalarý doðrudan bu fabrikaya yazmak için bir eþik buyutu ayarla.Zaten bu deðeri yukarda verdik.
		factory.setSizeThreshold(MAX_BELLEK_BOYUTU);
		
		//dosyalarý geçici bir dizine aktarmalýyýz. Bu dizinin boyutu MaX_BELLEK_BOYUTU ndan fazla olmalý.
		// bunun için java nýn gecici dosya dizinini kullanýyoruz
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		//yüklenen dosyanýn saklanacaðý klasörü oluþturuyoruz
		String uploadFolder = getServletContext().getRealPath("")+ File.separator + VERI_YOLU;
		
		//Yeni Bir Dosya yükleyicisi Oluþturma
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		
		String [] yollar = new String[10];
		String filePath="";
		int sayac = 0;
		String k = Integer.toString(tutanak_id);
		String k1 ="C:\\Users\\Eens\\workspace-kepler\\KGM\\WebContent\\images\\"+k; //"C:\\Users\\Eens\\workspace-kepler\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\KGM\\uploadedFiles\\"+k;
		System.out.println(k1);
		File uploader = new File(k1);
		if (!uploader.exists()){
			uploader.mkdir();
		}
		try {
			// Ýsteði ayrýþtýrma
			List items = upload.parseRequest(request);
			Iterator iter = items.iterator();
			while(iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				
				if (!item.isFormField()) {
					try {
						String itemname = item.getName();
						//String fileName = new File(item.getName()).getName();
						filePath ="C:\\Users\\Eens\\workspace-kepler\\KGM\\WebContent\\images\\"+k+"\\"+itemname;//getServletContext().getRealPath("/")+"uploadedFiles\\"+k+"\\"+itemname;
						
						File uploadedFile = new File(filePath);
						//request.setAttribute("resim_yolu", filePath);
						// dosyayý kaydetmek
						yollar[sayac] = "images\\"+k+"\\"+itemname;
						item.write(uploadedFile);
						sayac++;  // ne kadar resim var ?
					}catch (Exception e) {
		                   e.printStackTrace();
		              }
				}
		}
		}catch (FileUploadException ex) {
            throw new ServletException(ex);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
		for (int j = 0 ; j<yollar.length;j++){
			if (yollar[j] == null){
				yollar[j-1] =null;
			}
		}
		sayac=10;
		for (int i=1;i<sayac+1;i++){
			System.out.println(i);
			System.out.println(yollar[i-1]);
		}
		try {
			preStat = myConnec.prepareStatement("INSERT INTO resim_tablosu(yol1,yol2,yol3,yol4,yol5,yol6,yol7,yol8,yol9,yol10) VALUES(?,?,?,?,?,?,?,?,?,?)");
			for (int i=1;i<sayac+1;i++){
				preStat.setString(i, yollar[i-1]);  // Bu yollar çekilen resimler olacak
			}
			preStat.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try {
			preStat = myConnec.prepareStatement("SELECT resim_tablosu_id FROM resim_tablosu ORDER BY resim_tablosu_id DESC LIMIT 1");
			result = preStat.executeQuery();
			while(result.next()){
				resim_tablosu_id = result.getInt("resim_tablosu_id"); // son resim_tablosu id
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println(tutanak_id + " "+resim_tablosu_id);
		try { 
			preStat = myConnec.prepareStatement("UPDATE tutanak SET resim_tablosu_id= ?  WHERE tutanak_id="+tutanak_id);
			preStat.setInt(1, resim_tablosu_id);  // son tutanaga son resim tablosu eklendi
			preStat.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/kisiekle.jsp").forward(request, response);
	}

}
