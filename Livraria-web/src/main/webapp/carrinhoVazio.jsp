<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/checkout.css" rel="stylesheet">
<title>Confirmar Pedidos</title>
</head>
<body>
	<header> <nav class=" navbar navbar-primary navbar-static-top">
	<div class="navbar-header">
		<a class="navbar-brand" href="home.jsp">Arsenal Livraria</a>

		<button class="navbar-toggle" type="button"
			data-target="navbar-collapse" data-toggle="collapse">menu</button>
	</div>

	<ul class="nav navbar-nav collapse navbar-collapse navbar-right">
		<li><a href="#">Olá, Cliente</a></li>
		<li><a href="#">Carrinho</a></li>
		<li><a href="#">Sair</a></li>
		<li><a href="#"></a></li>
	</ul>
	</nav>
	<style>
.navbar {
	margin: 0;
}
</style>
	</header>
	<div class="jumbotron">
		<div class="container">
			<h1>Carrinho Vazio!</h1>
			<p>Adicione algum produto ao seu carrinho de compras para continuar!</p>
		</div>
	</div>

	

<% request.getSession().setAttribute("cliente", null); %>

<%@ include file="rodape.html"%>
</body>
</html>