<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Sifre Degistirme</title>
<link href="css/bicim.css" type="text/css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function kontrol() {
		var password = document.forms["myForm"]["password"].value;
		var password_again = document.forms["myForm"]["password_again"].value;
		if (password_again == null || password == null || password_again =="" || password =="") {
			alert("Lutfen Gerekli Alanları Doldurun");
			
			window.location.reload();
			return false;
		}
		else if (password != password_again) {
			alert("Lutfen Sifreyi Dogrulayın");
			window.location.reload();
			return false;
		}
		else if(password.length > 8 ){
			alert ("Sifre en cok 8 basamakli olmali");
			window.location.reload();
			return false;
		}
	}
</script>
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
		<div id="ortala" >
					<div style=" width:300px; margin:auto;">
                    <form action="sifre_degis" method="post" onsubmit="return kontrol()" name="myForm">
					  <table width="100%" border="0" cellspacing="1" cellpadding="0">
					    <tr>
					      <td height="30">Yeni Şifre:</td>
				        </tr>
					    <tr>
					      <td height="30"><input name="password" type="password" class="text" id="password" /></td>
				        </tr>
				         <tr>
					      <td height="30">Yeni Şifre Tekrar:</td>
				        </tr>
					    <tr>
					      <td height="30"><input name="password_again" type="password" class="text" id="password_again" /></td>
				        </tr>
					    <tr>
					      <td height="30" align="center"><input onclick="kontrol" type="submit" name="button" id="button" value="Degistir" /></td>
				        </tr>
				      </table></form>
					</div>
</div>
	

</body>
</html>