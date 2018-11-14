<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Toplu Tarif Aktarımı</title>
<link href="css/bicim.css" type="text/css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function kontrol() {
		var file = document.getElementById("file");
		if (file.files.length == 0) {
			alert("Lutfen Bir Dosya Seçin");
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

<div id="ortala">
	<div class="banner"></div>
</div>
	<div id=ortala>
		<div style=" width:300px; margin:auto;">
		 <form action="topluaktarim" method="post" onsubmit="return kontrol()" name="myForm" enctype="multipart/form-data">
			  <table width="100%" style="" border="0" cellspacing="1" cellpadding="0">
			    <tr>
			      <td height="30" align="center">Dosyayı Yükleyin</td>
		        </tr>
		         <tr>
					 <td height="30" align="center"><input name="file" type="file" id="file"/></td>
				 </tr>
		        <tr>
		 		 <tr>
					 <td height="30" align="center"></td>
				 </tr>
					<td height="30" align="center"><input onclick="kontrol" type="submit" name="button" id="button" class="btn" value="Aktarımı Başlat" /></td>
				</tr>
		      </table></form>
		  </div>
	</div>

</body>
</html>