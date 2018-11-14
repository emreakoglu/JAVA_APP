<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>
<link href="css/bicim.css" type="text/css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function kontrol() {
		var username = document.forms["myForm"]["username"].value;
		var password = document.forms["myForm"]["password"].value;
		if (username == null || password == null || username =="" || password =="") {
			alert("Lutfen Gerekli Alanları Doldurun");
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
	<div id="ortala">
	<div class="banner"></div>
</div>
		
        	<div id="ortala" >
					<div style=" width:300px; margin:auto;">
                    <form action="login" method="post" onsubmit="return kontrol()" name="myForm">
					  <table width="100%" border="0" cellspacing="1" cellpadding="0">
					    <tr>
					      <td height="30">Kullanıcı Adı :</td>
				        </tr>
					    <tr>
					      <td height="30"><label for="textfield"></label>
				          <input name="username" type="text" class="text" id="username" /></td>
				        </tr>
					    <tr>
					      <td height="30">Şifre:</td>
				        </tr>
					    <tr>
					      <td height="30"><input name="password" type="password" class="text" id="password" /></td>
				        </tr>
					    <tr>
					      <td height="30" align="center"><input type="submit" value="GİRİŞ" /></td>
				        </tr>
				      </table></form>
					</div>
</div>
	

</body>
</html>