<%-- 
    Document   : sessionExpired
    Created on : 27/08/2015, 8:44:23
    Author     : sandra_collaguazo
--%>

<%@page language="java" contentType="text/html;charset=UTF-8"%>
<HTML>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sesion expirada</title>
    </head>
<BODY>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<div align="center">
<!--	<img src="img/calaveraError.png" />-->
	<br /><br />
		<strong><span style="color:red">SU SESI&Oacute;N HA EXPIRADO :(</span><br /> <br /> Haga <a
			href="<%=request.getContextPath()%>/faces/login.xhtml">CLICK AQUI</a> para ir a la p&aacute;gina de ingreso
			al sistema. <br /> <br /> Muchas Gracias.</strong>
	</div>
</BODY>
</HTML>
