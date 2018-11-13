<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" href="img/favicon.ico">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<title>Sistem Yoneticisi</title>
<script type="text/javascript">
	function gonder() {
		var unvan = document.getElementById("unvan").value;
		var id = document.getElementById("id").value;
		alert(unvan+" "+id);
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
			ADMIN
			<a href="log">Log Out</a></div>
					<div id="sol">
                    	<div class="renk"></div>
                        <div style="background-color:#fff; margin:8px; border-bottom:1px dashed #000; padding-bottom:5px;">
                        <div id="buttondiv"><a href="admin" class="button">Anasayfa</a></div>
                        
                        </div>
                        <div style="background-color:#fff; margin:8px; border-bottom:1px dashed #000; padding-bottom:5px;">
                        <div id="buttondiv"><a href="admin" class="button">Kullanıcılar</a></div>
                        <div id="buttondiv"><a href="kullanici_kayit.jsp" class="button">Yeni Kullanıcı Ekle</a></div>
                        <div id="buttondiv"><a href="yardim.jsp" class="button">Yardım Masası</a></div>
                        </div>
                    </div>
                    
                    
                    <div id="sag">
                    <div class="renk">
                      <div style="padding:5px; color:#FFF; font-family:'Arial'">Tüm Kullanıcılar</div></div>
                    <!-- ORTAALAN BAŞLANGIÇ !-->
<div style="padding:15px;">
<form action="unvandegis" method="post" id="form1">	
  <table width="100%" border="0" cellspacing="1" cellpadding="0">
  
    <tr>
      <td width="28%" height="30" align="center" valign="middle" bgcolor="#D7D7D7">Adı</td>
      <td width="29%" height="30" align="center" valign="middle" bgcolor="#D7D7D7">Soyadı</td>
      <td width="37%" height="30" align="center" valign="middle" bgcolor="#D7D7D7">Unvan</td>
    </tr>
    
    <c:forEach var="user" items="${allusers }">
    				
					<tr>
						<td class="sutun" align="center">${user.adi }</td>
						<td class="sutun" align="center">${user.soyadi }</td>
						<td class="sutun" align="center">
							<select name="unvan" id="unvan">
								<option selected>${user.unvan }</option>
								<option>Saha Gorevlisi</option>
								<option>Grup Amiri</option>
								<option>Sef</option>
								<option>Mudur</option>
							</select>
						
						</td>
						<td><input type="hidden" size="1" name="id" value="${user.kullanici_id}" id="id"></td>
						<td class="sil" align="center"><div id="buttondiv"><a class="button" href="sil?id=${user.kullanici_id }">KULLANICI SIL</a></div></td>
						<td class="sil" align="center"><div id="buttondiv"><a class="button" href="#" onclick="gonder()">DEGISIKLIKLERI KAYDET</a></div></td><!--  <input type="submit" class="button" value="Degisikligi Onayla" style="background-color:#49646e; border:1px solid #4a6368; border-radius:5px; text-align:center; margin-bottom:8px; color:#FFF; padding:10px;" >-->
					</tr>
				
	</c:forEach>
	
	<!--  <tr>
      <td height="25">&nbsp;</td>
      <td height="25">&nbsp;</td>
      <td height="25"><input type="submit" name="button" id="button" value="Degisiklikleri Kaydet" style="background-color:#49646e; border:1px solid #4a6368; border-radius:5px; text-align:center; margin-bottom:8px; color:#FFF; padding:10px;" /></td>
    </tr>-->
  </table>
  </form>	
</div>
<!-- ORTAALAN BİTİŞ !-->
                    </div>
			</div>
</body>
</html>