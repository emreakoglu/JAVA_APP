<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Kullanici Kayit</title>
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
			ADMIN
			<a href="log">Log Out</a></div>
					<div id="sol">
                    	<div class="renk"></div>
                        <div style="background-color:#fff; margin:8px; border-bottom:1px dashed #000; padding-bottom:5px;">
                        <div id="buttondiv"><a href="sistem.jsp" class="button">Anasayfa</a></div>
                        
                        </div>
                        <div style="background-color:#fff; margin:8px; border-bottom:1px dashed #000; padding-bottom:5px;">
                        <div id="buttondiv"><a href="sistem.jsp" class="button">Kullanıcılar</a></div>
                        <div id="buttondiv"><a href="kullanici_kayit.jsp" class="button">Yeni Kullanıcı Ekle</a></div>
                        <div id="buttondiv"><a href="yardim.jsp" class="button">Yardım Masası</a></div>
                        </div>
                        
                        
                    
                    </div>
                    
                    <div id="sag">
                    <div class="renk">
                      <div style="padding:5px; color:#FFF; font-family:'Arial'">Yeni Kullanıcı Ekleme</div></div>
                    <!-- ORTAALAN BAŞLANGIÇ !-->
<div style="padding:15px;">
<form action="kul_kayit" method="post">
  <table width="80%" border="0" align="center" cellpadding="0" cellspacing="1">
    <tr>
      <td width="25%" height="25">Ad</td>
      <td width="5%" height="25">:</td>
      <td width="70%" height="25"><label for="textfield"></label>
        <input type="text" name="adi" id="soyadi" /></td>
    </tr>
    <tr>
      <td height="25">Soyad</td>
      <td height="25">:</td>
      <td height="25"><input type="text" name="soyadi" id="soyadi" /></td>
    </tr>
    <tr>
      <td height="25">Ünvan</td>
      <td height="25">:</td>
      <td height="25"><span style="background-color:#f7f7f7;">
        <select name="unvan">
          <option>Saha Görevlisi</option>
          <option>Grup Amiri</option>
          <option>Şef</option>
          <option>Müdür</option>
          <option selected="selected">Seçiniz</option>
          <option>Sistem Yöneticisi</option>
        </select>
      </span></td>
    </tr>
    <tr>
      <td height="25">Username</td>
      <td height="25">:</td>
      <td height="25"><input type="text" name="username" id="username" /></td>
    </tr>
    <tr>
      <td height="25">Şifre</td>
      <td height="25">:</td>
      <td height="25"><input type="password" name="password" id="password" /></td>
    </tr>
     <tr>
      <td height="42" colspan="3"><input name="checkbox" type="checkbox" id="checkbox" />
        <label for="checkbox">İlk girişte şifre değişikliliği talep et</label></td>
      </tr>
    <tr>
      <td height="25">&nbsp;</td>
      <td height="25">&nbsp;</td>
      <td height="25"><input type="submit" name="button" id="button" value="Kullanıcıyı Ekle" style="background-color:#49646e; border:1px solid #4a6368; border-radius:5px; text-align:center; margin-bottom:8px; color:#FFF; padding:10px;" /></td>
    </tr>
  </table>
</form>
</div>
<!-- ORTAALAN BİTİŞ !-->
                    </div>
			</div>
		
	
</body>
</html>