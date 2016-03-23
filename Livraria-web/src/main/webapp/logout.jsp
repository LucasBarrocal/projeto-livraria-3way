<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="mensagem" scope="session" class="java.lang.String"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/estilo.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logout</title>
</head>
<body>
<%@ include file="mascara.html" %>
<center>
<% request.getSession().setAttribute("cliente", null); %>
	<h1>Até mais, e obrigado pelos peixes!</h1>
	<a href="home.jsp">Inicio</a>
</center>
<%@ include file="rodape.html" %>
</body>
</html>