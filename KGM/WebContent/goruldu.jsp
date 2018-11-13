<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mevcut Tutanaklar</title>
<script type="text/javascript">
	function goruldu(){
		var yap = document.getElementById("yapilacak").value;
		if (yap == 1){
			alert('Tutanak Ilgili Sefe Sevk Edildi');
		}else {
			alert('Tutanak icin duzeltme istegi gonderildi');
		}
		window.location="mevcuttutanaklar";
	}
</script>
</head>
<body onload="goruldu()">
	<input type="hidden" value="${yapilacak }"  id="yapilacak">
</body>
</html>