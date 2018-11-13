<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Tutanak Inceleme</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="img/favicon.ico">
<link rel="stylesheet" href="css/example.css" />
  <link rel="stylesheet" href="css/pygments.css" />
  <link rel="stylesheet" href="css/slideshow.css" />
  <script src="js/jquery-1.11.1.min.js"></script>
  <script src="js/slideshow.js"></script>
</head>
<body>
	
	
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
                    
                    <div id="sag">
                    <div class="renk">
                      <div style="padding:5px; color:#FFF; font-family:'Arial'">${tutanagi.tarih } tarihli Olay Tutanağı</div></div>
                    <!-- ORTAALAN BAŞLANGIÇ !-->
<div style="padding:15px;"><div style="text-align:right">${tutanagi.tarih }</div>
<b>Olay Türü :</b> ${tutanagi.tur }<br />
<br />

<table width="100%" border="0" cellspacing="5" cellpadding="0" style=" font-size:11px;">
 <tr>
    <td width="17%" height="25">&nbsp;</td>
    <td width="2%" height="25">&nbsp;</td>
    <td width="32%" height="25">&nbsp;</td>
    <td height="25" colspan="4" align="center"><b>Gerçekleştirmek istediğiniz<br />
 işlemi seçiniz</b>
      <form id="degisiklik" method="post" action="degisiklik">
        <div id="buttondiv" style="float:right; width:30px;"><a href="#" onclick="document.getElementById('degisiklik').submit()" class="button">OK</a></div>
        <select name="select" id="select" style="float:right; padding:5px;">
          <option selected>Seçiniz</option>
          <option>Goruldu</option>
          <option>Sefe Sevk Et</option>
          <option>Duzeltme Iste</option>
        </select>
       
        </form>        <br /></td>
    </tr>
  	<tr>
		<td><strong>Taraflar</strong></td>
	</tr>
		<tr>
			<c:forEach var="taraf" items="${taraflar }">	
				<table width="200" class="tablo" height="100" border="0">
					<tr>
						 <td width="17%" height="25">Adı</td>
						 <td width="2%" height="25">:</td>
						 <td width="32%" height="25">${taraf.adi }</td>
						 <td width="11%" height="25">&nbsp;</td>
					</tr>
					<tr>
						<td width="17%" height="25">Soyadı</td>
						 <td width="2%" height="25">:</td>
						 <td width="32%" height="25">${taraf.soyadi }</td>
						 <td width="11%" height="25">&nbsp;</td>
					</tr>
					<tr>
						<td width="17%" height="25">Baba Adı</td>
						 <td width="2%" height="25">:</td>
						 <td width="32%" height="25">${taraf.baba_adi }</td>
						 <td width="11%" height="25">&nbsp;</td>
					</tr>
					<tr>
						<td width="17%" height="25">Dogum Yeri</td>
						 <td width="2%" height="25">:</td>
						 <td width="32%" height="25">${taraf.dogum_yeri }</td>
						 <td width="11%" height="25">&nbsp;</td>
					</tr>
					<tr>
						<td width="17%" height="25">İkametkah Adresi</td>
						 <td width="2%" height="25">:</td>
						 <td width="32%" height="25">${taraf.ikametkah }</td>
						 <td width="11%" height="25">&nbsp;</td>
					</tr>
					<tr>
						<td width="17%" height="25">Telefon Numarası</td>
						 <td width="2%" height="25">:</td>
						 <td width="32%" height="25">${taraf.tel_no }</td>
						 <td width="11%" height="25">&nbsp;</td>
					</tr>
				</table>
			</c:forEach></tr>	
  	<tr>
   	 	<td height="25" colspan="7"><strong><u>Olay Açıklaması : </u></strong><br />
     	 <br />${tutanagi.aciklama }<br />
     	 <br />
	 </td>
  	</tr>
  	           
</table>


</div>
<!-- ORTAALAN BİTİŞ !-->
<table>
	<tr>
        <td height="25">&nbsp;</td>
      </tr>
  	<tr>
        <td height="25">&nbsp;</td>
      </tr>
  	<tr>
        <td height="25">&nbsp;</td>
      </tr> 
	<tr>
        <td height="25">&nbsp;</td>
      </tr> 
      <tr>
        <td height="25">&nbsp;</td>
      </tr> 
</table>
<div id="container">
    <div id="example" class="align-obj" align="center">

      <div class="slideshow" data-transition="crossfade" data-loop="true" data-skip="false">
        <ul class="carousel">
        	<c:forEach var="resim" items="${yollar }">
        		<li class="slide">
        			<img src="${resim }" alt="" width="350" height="220" />
        		</li>
        	</c:forEach>
        </ul>
      </div>

    </div>
  </div>
                    </div>
                    
			</div>	
			
<script>
  $(function() {
      // Create slideshow instances
      var $s = $('.slideshow').slides();

      // Access an instance API
      var api = $s.eq(0).data('slides');

      // Transition select
      $('select[name=transition]').on('change', function() {
        api.redraw( this.value );
      });
    });
</script>
</body>
</html>