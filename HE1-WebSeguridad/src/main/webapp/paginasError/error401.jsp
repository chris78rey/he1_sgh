<%-- 
    Document   : error401
    Created on : 27/08/2015, 8:06:14
    Author     : sandra_collaguazo
--%>

<%@page language="java" isErrorPage="true"
	contentType="text/html;charset=UTF-8"%>
<HTML>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error 401</title>
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
		<strong>Usted no tiene <span style="color:red">PERMISO (error 401)</span><br /> <br />para ingresar a
			esta secci&oacute;n del Sistema <br /> <br /> Haga <a
			href="<%=request.getContextPath()%>/inicio.xhtml">CLICK AQU&Iacute;</a> para
			regresar a la p&aacute;gina de inicio. <br /> <br /> Muchas
			Gracias.</strong>
	</div>
</BODY>
</HTML>


