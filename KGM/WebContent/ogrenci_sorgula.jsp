<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Ogrenci Sorgulama Ekrani</title>
<link href="css/style.css" type="text/css" rel="stylesheet" />
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
                    <div id="sag">
                    <div class="renk"><div style="padding:5px; color:#FFF; font-family:'Arial'">Ogrenci Sorgulama Ekrani</div></div>
                    <!-- ORTAALAN BAŞLANGIÇ !-->
                    <table width="100%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td width="17%" height="30"><h4>Adı</h4></td>
    <td width="3%" height="30">:</td>
    <td width="80%" height="30">${ogrenci.adi }</td>
  </tr>
  <tr>
    <td height="30"><h4>Soyadı</h4></td>
    <td height="30">:</td>
    <td height="30">${ogrenci.soyadi }</td>
  </tr>
  <tr>
    <td height="30"><h4>Fakultesi</h4></td>
    <td height="30">:</td>
    <td height="30">${ogrenci.fakulte }</td>
  </tr>
  <tr>
    <td height="30"><h4>Bölümü</h4></td>
    <td height="30">:</td>
    <td height="30">${ogrenci.bolum }</td>
  </tr>
</table>
                    <br />
                    
                    
<br />
<br />
<br />
<br />
<br />
<br />
<div style="text-align:center;">
</div>
<br />
<br />
<br />
<br />
<br />
<br />
<!-- ORTAALAN BİTİŞ !-->
                    </div>
			</div>
	

</body>
</html>