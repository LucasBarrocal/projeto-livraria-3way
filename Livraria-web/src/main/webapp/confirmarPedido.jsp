<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/reset.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/checkout.css" rel="stylesheet">
<title>Confirmar Pedidos</title>
</head>
<body>
	<header> <nav class=" navbar navbar-primary navbar-static-top">
	<div class="navbar-header">
		<a class="navbar-brand" href="loghome.jsp">Arsenal Livraria</a>

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
			<h1>Ótima Escolha</h1>
			<p>Obrigado por comprar na Arsenal Livraria! Por favor, confirme
				seus dados antes de efetivar a compra!</p>
		</div>
	</div>
	<div class="container cart">
		<div class="row">
			<div class="col-sm-12">
			<c:forEach items="${carrinho.itens }" var="item">
				<table class="table cart-items">
					<thead>
						<tr>
							<th class="produto">Produto</th>
							<th class="produto-preco">Preço</th>
							<th class="quantidade">Quantidade</th>
							<th class="preco-total">Total</th>
							<th class="item-remove"></th>
						</tr>
					</thead>
					<tbody>
						<tr class="produto-item">
							<td class="produto-image">
								<a href="VerLivro?codigo=${item.livro.codigo}">
									<img src="${item.livro.imagem }">
								</a>
							</td>
							<td class="produto-nome">
								<a href="VerLivro?codigo=${item.livro.codigo}">${item.livro.titulo}</a>
								<div class="autor">
									<span class="autor-nome">${item.livro.autor}</span>
								</div>
							</td>
							<td class="produto-preco">
								<span>R$ ${item.livro.preco }0</span>
							</td>
							<td class="quantidade">
								<form action="EditarCarrinho" name="form${item.livro.codigo}">
									<input type="hidden" name="codigo" value="${item.livro.codigo}" />
									<input type="hidden" name="acao" value="alterar" /> 
									<input size="3" name="qtd${item.livro.codigo}" value="${item.qtd}" />
								</form>
							</td>
							<td class="preco-total">
								<span>R$ ${item.valor}0</span>
							</td>
							<td class="item-remove">
								<a href="EditarCarrinho?codigo=${item.livro.codigo}&acao=remover">
									<i class="icon icon-remove item-remove-icon"></i>
									<span class="hide item-remove-texto">Excluir Item</span>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
			</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>