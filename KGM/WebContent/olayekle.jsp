<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Olay Ekle</title>
<link href="bicim.css" type="text/css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="img/favicon.ico">
<script type="text/javascript">
	function gonder(){
		document.getElementById("gorsel").value = 1;
		document.getElementById("form1").submit();
	}
</script>
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
                    <!-- ORTAALAN BAŞLANGIÇ !-->

                    
                    <div id="sag">
                    <div class="renk"><div style="padding:5px; color:#FFF; font-family:'Arial'">E-TUTANAK HAZIRLAMA EKRANI</div></div>
                    <!-- ORTAALAN BAŞLANGIÇ !-->
<div style="padding:15px;">
<form action="tutanak" method="post" id="form1" class="form1">
<table width="100%" border="0" cellspacing="0" cellpadding="2">
  <tr>
    <td width="20%">Kategori</td>
    <td width="3%">:</td>
    <td colspan="2"><label for="select"></label>
      <select name=kategori id="kategori">
       				 <option value="0" selected="selected">Seçiniz</option>
        			<option>Trafik Kurali Ihlali</option>
					<option>Kavga</option>
					<option>Trafik kazasi</option>
					<option>Izinsiz Gosteri</option>
					<option>Hirsizlik</option>
					<option>Hiz Sinirini Asma</option>
					<option>Izinsiz Giris</option>
      </select></td>
    </tr>
  <tr>
    <td height="25">Olayın Adres</td>
    <td height="25">:</td>
    <td height="25" style="border-right:1px solid #000;">
    <td height="25"><textarea name="adres" rows="5" cols="25" id="adres"></textarea></td>
  </tr>
</table>



<table width="100%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td>Açıklama</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>
      <textarea name="aciklama" rows="7" id="aciklama" style="width:320px;"></textarea>
   </td>
   <td><input type="hidden" value="0" id="gorsel" name="gorsel"></td>
    <td valign="top"> <div id="buttondiv"><a href="#" onclick="gonder()" class="button">Onay Ver ve Görsel Ekle</a></div>
<div id="buttondiv"><a href="#" class="button" onclick="document.getElementById('form1').submit()">Sadece Onaya Gönder</a></div>
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