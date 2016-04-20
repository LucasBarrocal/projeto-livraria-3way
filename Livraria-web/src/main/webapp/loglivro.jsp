<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<jsp:useBean id="livro" class="workshop.Livro" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/estilo.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${livro.titulo}</title>
</head>
<body>
<%@include file="mascara.html" %>
<br/>
<div class="container">
<div class="row">
        <div class="col-md-3">
        <%@ include file="menu.html" %>
        </div>
            <div class="col-lg-9">
<div class="row">
<div class="panel panel-default">
	<div class="panel-heading">
		<h2 class="panel-title">${livro.titulo}</h2>
	</div>
	<div class="panel-body">
	<div class="col-md-3">
		<img src="${livro.imagem }" class="img-thumbnail img-responsive" id="img-livro">
	</div>
	<div class="col-md-9">
		<dl>
			<dt class="titulo">Nome do Produto</dt>
			<dd class="descricao">${livro.titulo}</dd>
			
			<dt class="titulo">Autor</dt>
			<dd class="descricao">${livro.autor }</dd>
			
			<dt class="titulo">Preço: </dt>
			<dd class="descricao">R$ ${livro.preco }0</dd>
			
			<dt class="titulo">SIPNOSE</dt>
			<dd class="descricao">${livro.descricao }</dd>
		</dl>
	</div>
	</div>
</div>
    <a class="btn btn-success" href="EditarCarrinho?codigo=${livro.codigo}&acao=adicionar">Adicionar ao Carrinho de compras</a>
</div>
</div>
</div>
</div>
<%@include file="rodape.html" %>

</body>
</html>