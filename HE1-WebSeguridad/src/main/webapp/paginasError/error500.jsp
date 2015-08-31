<%-- 
    Document   : error500
    Created on : 27/08/2015, 9:04:40
    Author     : sandra_collaguazo
--%>

<%@page language="java" isErrorPage="true"
	contentType="text/html;charset=UTF-8"%>
<HTML>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error 500</title>
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
		<strong>Ha ocurrido un <span style="color:red">Error</span> <%=request.getSession().getAttribute("causa") %><br /> <br /> Haga <a
			href="javascript:window.history.back();">CLICK AQU&Iacute;</a> para
			regresar a la p&aacute;gina de Inicio. <br /> <br /> Muchas
			Gracias.</strong>
	</div>
</BODY>
</HTML>