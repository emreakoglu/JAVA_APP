<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Mevcut Tarifler</title>
<link href="css/bicim.css" type="text/css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/sorttable.js"></script>

<style>
table { border: 0px solid black; word-wrap:break-word;
              table-layout:fixed;
              
}
</style>
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
	Tum Tarifler
	<br>
	<br>
	<br>
	<table style="width: 90%" id="myTable" class="sortable">
		<tr>
			<td width="10%" align="center" valign="middle" bgcolor="#D7D7D7">Tarif Numarasi</td>
			<td width="15%" align="center" valign="middle" bgcolor="#D7D7D7">Tarif Adi</td>
			<td width="38%" align="center" valign="middle" bgcolor="#D7D7D7">Tarif Yapilisi</td>
			<td width="37%" align="center" valign="middle" bgcolor="#D7D7D7">Tarif Malzemesi</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<c:forEach var="tarif" items="${tarifler }">
				<tr>
					<td width="10%" style="background-color:#f7f7f7;">${tarif.id } </td>
					<td width="15%" style="background-color:#f7f7f7;">${tarif.adi } </td>
					<td width="36%" style="background-color:#f7f7f7;">${tarif.tarifi } </td>
					<td width="35% "style="background-color:#f7f7f7;">${tarif.malzemesi } </td>
					<td style="float: left;"><a href="sil?tarif_id=${tarif.id }" class="btn">Sil</a></td>
					<td style="float: left;"><a href="duzenle?tarif_id=${tarif.id }" class="btn">Duzenle</a></td>
					
				</tr>
			
			</c:forEach>
		</tr>
		
	</table>
	
	<a href="anasayfa.jsp" class="btn" style="width:320px;">Tarif Ekleme Sayfasi</a>
	
	

</body>
</html>