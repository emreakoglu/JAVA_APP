<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Tutanak Arsivi</title>
<link href="bicim.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="img/favicon.ico">
<link rel="shortcut icon" href="img/favicon.ico">
<link rel="stylesheet" href="css/example.css" />
  <link rel="stylesheet" href="css/pygments.css" />
  <link href="css/style.css" rel="stylesheet" type="text/css" />
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
                    
                    </div><!--  
                     <div class="sol">
              <div class="renk">
              <div style="padding:5px; color:#FFF; font-family:'Arial'">DETAYLI ARAMA</div></div>
              	<form action="ara" method="post" id="ara">
              		<table width="150" class="tablo" height="30%">
			<tr>
	    		 	<th colspan="2" align="center" scope="row">&nbsp;</th>
	   			</tr>
			<tr>
				<th width="140" align="left" scope="row">Kategori</th>
				<td>
					<select name="kategori">
						<option>Seciniz</option>
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
	    		 	<th colspan="2" align="center" scope="row">&nbsp;</th>
	   			</tr>
			<tr>
				<th width="140" align="left" scope="row">Tarih Araligi</th>
				<td><input type="text" name="aralik1" size="6">-<input type="text" name="aralik2" size="6"></td>
			</tr>
			<tr>
	    		 	<th colspan="2" align="center" scope="row">&nbsp;</th>
	   		</tr>
	   		<tr>
				<th width="140" align="left" scope="row">Duzenleyen</th>
				<td><input type="text" name="duzenleyen"></td>
			</tr>
			<tr>
				<th colspan="2" align="center" scope="row"><label>
		      		<div id="buttondiv"><a href="#" class="button" onclick="document.getElementById('ara').submit()">Tutanak Ara</a></div>
		    		</label></th>
	    	</tr>
	    	<tr>
	    		 	<th colspan="2" align="center" scope="row">&nbsp;</th>
	   		</tr>		
				 
		</table>
              	</form>
              </div>
                    -->
                    <div id="sag">
                    <div class="renk">
                    <div style="padding:5px; color:#FFF; font-family:'Arial'">ONAYLANAN MEVCUT TUTANAKLAR</div></div>
                    <!-- ORTAALAN BAŞLANGIÇ !-->
<div style="padding:15px;">

<table width="100%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td width="37%" height="30" align="center" valign="middle" bgcolor="#D7D7D7">Tutanak Kategorisi</td>
    <td width="35%" height="30" align="center" valign="middle" bgcolor="#D7D7D7">Düzenleyen</td>
    <td width="28%" height="30" align="center" valign="middle" bgcolor="#D7D7D7">Tarihi</td>
  </tr>
  <tr>
    	<c:forEach var="tutanak" items="${alltutanak }">
				<tr>
					<td style="background-color:#f7f7f7;">${tutanak.kategori } </td>
					<td style="background-color:#f7f7f7;">${tutanak.kullanici } </td>
					<td style="background-color:#f7f7f7;">${tutanak.tarih } </td>
					<td><div id="buttondiv"><a href="tutanak_incele?tutanak_id=${tutanak.tutanak_id }&tur=${tutanak.kategori}" class="button">Incele</a></div></td>
					</tr>
			</c:forEach>
</table>
</div>
<!-- ORTAALAN BİTİŞ !-->
                    </div>
                    <div id="sol-alt">
                    <div class="renk">
              <div style="padding:5px; color:#FFF; font-family:'Arial'">DETAYLI ARAMA</div></div>
              	<form action="ara" method="post" id="ara">
              		<table width="150" class="tablo" height="30%">
			<tr>
	    		 	<th colspan="2" align="center" scope="row">&nbsp;</th>
	   			</tr>
			<tr>
				<th width="140" align="left" scope="row">Kategori</th>
				<td>
					<select name="kategori">
						<option>Seciniz</option>
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
	    		 	<th colspan="2" align="center" scope="row">&nbsp;</th>
	   			</tr>
			<tr>
				<th width="140" align="left" scope="row">Tarih Araligi</th>
				<td><input type="text" name="aralik1" size="6">-<input type="text" name="aralik2" size="6"></td>
			</tr>
			<tr>
	    		 	<th colspan="2" align="center" scope="row">&nbsp;</th>
	   		</tr>
	   		<tr>
				<th width="140" align="left" scope="row">Duzenleyen</th>
				<td><input type="text" name="duzenleyen"></td>
			</tr>
			<tr>
				<th colspan="2" align="center" scope="row"><label>
		      		<div id="buttondiv"><a href="#" class="button" onclick="document.getElementById('ara').submit()">Tutanak Ara</a></div>
		    		</label></th>
	    	</tr>
	    	<tr>
	    		 	<th colspan="2" align="center" scope="row">&nbsp;</th>
	   		</tr>		
				 
		</table>
              	</form>
    </div><!-- sol-alt-bitti -->
			</div>
</body>
</html>