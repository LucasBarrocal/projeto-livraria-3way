<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="carrinho" scope="session" class="workshop.Carrinho"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/estilo.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="js/funcoes.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Carrinho</title>
</head>
<body>
<%@ include file="mascara.html" %>
<br/>
<center>
${mensagem}
<% request.getSession().removeAttribute("mensagem"); %>
	<table cellpadding="0" cellspacing="0" width="600px" ">
	<tr class="tr-superior">
		<td>Titulo</td>
		<td>Valor Unitário</td>
		<td>QTD</td>
		<td>Valor*QTD</td> 
		<td colspan="2">Ação</td>
	</tr>
	<c:forEach items="${carrinho.itens}" var="item">
		<tr>
			<td>${item.livro.titulo}</td>
			<td>${item.livro.preco}</td>
			<td>
			<form action="EditarCarrinho" name="form${item.livro.codigo}">
			<input type="hidden" name="codigo" value="${item.livro.codigo}"/>
			<input type="hidden" name="acao" value="alterar"/>
			<input size="3" name="qtd${item.livro.codigo}" value="${item.qtd}"/>
			</form>
			</td>
			<td>${item.valor}</td>
			
			<td>
			<a href="javascript:document.form${item.livro.codigo}.submit()"> alterar </a>
			</td>
			
			<td>
			<a href="EditarCarrinho?codigo=${item.livro.codigo}&acao=remover"> excluir </a>
			</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="2" bgcolor="#2e3436">&nbsp;</td>
			<td bgcolor="#ccc">Total:R$</td>
			<td bgcolor="#ccc">${carrinho.valorString}</td>
			<td colspan="2" bgcolor="#2e3436">&nbsp;</td>
		</tr>
	</table>
	<a href="FinalizarCompra">Finalizar Compra</a>
</center>

<%@ include file="rodape.html" %>
</body>
</html>