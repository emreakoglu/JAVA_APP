<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Kisi Ekleme</title>
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
                        <div id="buttondiv"><a href="olayekle.jsp" class="button">E-Tutanak Hazirlama</a></div>
                        <div id="buttondiv"><a href="mevcuttutanaklar" class="button">Mevcut Tutanaklar</a></div>
                        <div id="buttondiv"><a href="mevcutlar" class="button">Tutanak Arsivi</a></div>
                        </div>
                        
                        <div style="background-color:#fff; margin:8px;  padding-bottom:5px;">
                        <div id="buttondiv"><a href="kimlik.html" class="button">Kimlik Sorgulama</a></div>
                        </div>
                    
                    </div>
                    
                    <div id="sag">
                    <div class="renk"></div>
<div style="padding:15px;">
<form action="insertkisi" id="form1" class="form1">
<table width="100%" border="0" cellspacing="0" cellpadding="2">
  <tr>
    <td height="25">Adi Soyadi</td>
    <td height="25">:</td>
    <td height="25" style="border-right:1px solid #000;"><label for="textfield"></label>
      <input type="text" name="name" id="name" /></td>
  </tr>
  <tr>
    <td height="25">Baba Adi</td>
    <td height="25">:</td>
    <td height="25" style="border-right:1px solid #000;"><input type="text" name="babaadi" /></td>
    
  </tr>
  <tr>
    <td height="25">Dogum Tarihi</td>
    <td height="25">:</td>
    <td height="25" style="border-right:1px solid #000;"><input type="text" name="dogum_tarihi" id="dogum_tarihi" /></td>
    
  </tr>
  <tr>
    <td height="25">Dogum Yeri</td>
    <td height="25">:</td>
    <td height="25" style="border-right:1px solid #000;"><input type="text" name="dogum_yeri" id="dogum_yeri" /></td>
   
  </tr>
  <tr>
    <td height="25">Ikametkah Adresi</td>
    <td height="25">:</td>
    <td height="25" style="border-right:1px solid #000;"><textarea name="ikametkah" rows="5" id="textfield12"></textarea></td>
    
  </tr>
  <tr>
    <td height="25">Telefon Numarasi</td>
    <td height="25">:</td>
    <td height="25" style="border-right:1px solid #000;"><input type="text" name="telefon" id="telefon" /></td>
    
  </tr>
</table>



<table width="100%" border="0" cellspacing="1" cellpadding="0">
  <tr>
   <td>
<div id="buttondiv"><a href="#" class="button" onclick="document.getElementById('form1').submit()">Tarafi Ekle</a></div>
<div id="buttondiv"><a href="anasayfa.jsp" class="button">Tutanagi Bitir</a></div>
</td>
  </tr>
</table>
</form>
</div>
<!-- ORTAALAN BİTİŞ !-->
                    </div>
			</div>
		
</body>
</html>