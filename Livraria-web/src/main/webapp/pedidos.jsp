<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="pedidos" scope="session" class="java.util.ArrayList"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/estilo.css" rel="stylesheet" type="text/css">
<title>Pedidos</title>
</head>
<body>
<%@include file="masklog.html" %>
<form action="">
<center>
	<span class="titulo">
	Pedidos Realizados: <br/><br/><br/>
	</span>
	<table cellspacing="2" cellpadding="2">
		<tr class="tr-superior">
			<td>Data</td>
			<td>QTD</td>
			<td>Pedido</td>
			<td>Status</td>
		</tr>
	<c:forEach items="${pedidos}" var="pedido" >
	<c:forEach items="${pedido.itens}" var="item">
		<tr>
			<td>
				<c:out value="${pedido.dataPedidoString}"/>
			</td>
			<td align="center">
				<c:out value="${item.qtd}"/>
			</td>
			<td>
				<c:out value="${item.livro.titulo}"/>
			</td>
			<td>
				<c:out value="${pedido.status}"/>
			</td>
		</tr>
	</c:forEach>
	</c:forEach>
	</table>
</center>

</form>
<%@include file="rodape.html" %>

</body>
</html>