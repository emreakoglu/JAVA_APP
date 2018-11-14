<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Tarif Duzenle</title>
<link href="css/bicim.css" type="text/css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%Object id = session.getAttribute("id") ;
		if (id == null){
			response.sendRedirect("hata.html");
		}
		%>

<div id="ortala" >
        	<div class="command_bar">
			<a href="logout">Log Out</a></div></div>
	Kullanici  ${username }  ${usersurname }  
	<br>
	<br>
	<br>
	
	<form action="kayit_duzenle" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Yemek No :</td>
				<td><input type="text" name="tarif_no" size="35" value="${tarif_id}"/></td>
			</tr>
			<tr>
				<td>Yemek adi :</td>
				<td><input type="text" name="tarif_ismi" size="35" value="${tarif_adi }"/></td>
			</tr>
			<tr></tr>
			<tr>
				<td>Yemek Tarifi :</td>
				<td><textarea name="tarif" cols="80" rows="6">${tarif_tarifi }</textarea></td>
			</tr>
		 	<tr>
				<td>Yemek Malzemesi : </td>
				<td><textarea name="malzemeler" cols="80" rows="6" >${tarif_malzemesi }</textarea></td>
			</tr>
			<tr>
				<td>Tarif Fotosu :</td>
				<td><input name="foto" type="file" id="foto"/></td>
			</tr>
		</table>
		<br>
		<br>
		<button type="submit" class="btn" style="width:320px;">Kaydet</button>
	</form>
	<br>
	<br>
	<a href="mevcutTarifler" class="btn" style="width:320px;">Tarif Arsivi</a>

</body>
</html>