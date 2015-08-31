<%-- 
    Document   : error404
    Created on : 27/08/2015, 8:20:19
    Author     : sandra_collaguazo
--%>

<%@page language="java" isErrorPage="true"
	contentType="text/html;charset=UTF-8"%>
<HTML>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error 403</title>
    </head>
<BODY>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<div align="center">
	<br />
		<strong>Usted no tiene <span style="color:red">PERMISO (error 403)</span><br /> <br />para ingresar a
			esta secci&oacute;n del Sistema <br /> <br /> Haga <a
			href="<%=request.getContextPath()%>">CLICK AQU&Iacute;</a> para
			regresar a la p&aacute;gina de ingreso. <br /> <br /> Muchas
			Gracias.</strong>
	</div>
</BODY>
</HTML>