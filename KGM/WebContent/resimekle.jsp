<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Resim Ekleme</title>
<link href="bicim.css" type="text/css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
	<%Object id = session.getAttribute("id") ;
		if (id == null){
			response.sendRedirect("hata.html");
		}
		%>
	<div id="ortala">
	<div class="banner"></div>
</div>
        	<div id="ortala" >
        	<div class="command_bar">
			Merhaba ${adi } ${soyadi } Kullanici ID : ${id }
			<a href="log">Log Out</a></div>
					<div id="sol">
                    	<div class="renk"></div>
                        <div style="background-color:#fff; margin:8px; border-bottom:1px dashed #000; padding-bottom:5px;">
                        <div id="buttondiv"><a href="anasayfa.jsp" class="button">Anasayfa</a></div>
                        
                        </div>
                        <div style="background-color:#fff; margin:8px; border-bottom:1px dashed #000; padding-bottom:5px;">
                        <div id="buttondiv"><a href="olayekle.jsp" class="button">E-Tutanak Hazırlama</a></div>
                        <div id="buttondiv"><a href="mevcuttutanaklar" class="button">Mevcut Tutanaklar</a></div>
                        <div id="buttondiv"><a href="mevcutlar" class="button">Tutanak Arşivi</a></div>
                        </div>
                        
                        <div style="background-color:#fff; margin:8px;  padding-bottom:5px;">
                        <div id="buttondiv"><a href="kimlik.html" class="button">Kimlik Sorgulama</a></div>
                        </div>
                    
                    </div>
              <div id="sag">
                    <div class="renk"><div style="padding:5px; color:#FFF; font-family:'Arial'">GORSEL EKLEME</div></div>
                    <!-- ORTAALAN BAŞLANGIÇ !-->
				<div style="padding:15px;">
					<form action="resimekle" method="post" id="form1" class="form1" enctype="multipart/form-data">
					<table width="100%" border="0" cellspacing="0" cellpadding="2">  
						
						<tr>
							<td width="20%">&nbsp;</td>
						</tr>
						<tr>
							<br>Yuklenecek gorseli seciniz: <input name="file" type="file" id="file">
							<br>Yuklenecek gorseli seciniz: <input name="file" type="file" id="file">
 							<br>Yuklenecek gorseli seciniz: <input name="file" type="file" id="file">
 							<br>Yuklenecek gorseli seciniz: <input name="file" type="file" id="file">
 							<br>Yuklenecek gorseli seciniz: <input name="file" type="file" id="file">
 							<br>Yuklenecek gorseli seciniz: <input name="file" type="file" id="file">
 							<br>Yuklenecek gorseli seciniz: <input name="file" type="file" id="file">
 							<br>Yuklenecek gorseli seciniz: <input name="file" type="file" id="file">
 							<br>Yuklenecek gorseli seciniz: <input name="file" type="file" id="file">
 							<br>Yuklenecek gorseli seciniz: <input name="file" type="file" id="file">
							<td><input type="submit" name="button" id="button" value="Gorselleri Ekle" style="background-color:#49646e; border:1px solid #4a6368; border-radius:5px; text-align:center; margin-bottom:8px; color:#FFF; padding:10px;" /></td>
							<td><div id="buttondiv"><a href="anasayfa.jsp" class="button">Islemi Bitir</a></div></td>
						</tr>
					</table>
					</form>	
                    </div>
    			</div>	
    		</div>	
</body>
</html>