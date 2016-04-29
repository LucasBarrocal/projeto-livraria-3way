<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/checkout.css" rel="stylesheet">
<title>Carrinho</title>
</head>
<body>
	<header> <nav class=" navbar navbar-primary navbar-static-top">
	<div class="navbar-header">
		<a class="navbar-brand" href="loghome.jsp">Arsenal Livraria</a>

		<button class="navbar-toggle" type="button"
			data-target="navbar-collapse" data-toggle="collapse">menu</button>
	</div>

	<ul class="nav navbar-nav collapse navbar-collapse navbar-right">
		<li><a href="#">Olá, ${cliente.nome }</a></li>
		<li><a href="#">Ajuda</a></li>
		<li><a href="Logout">Sair</a></li>
		<li><a href="#"></a></li>
	</ul>
	</nav>
	<style>
.navbar {
	margin: 0;
}
</style>
	</header>
	<c:if test="${carrinho.getItens().size() != 0 }">
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
						<c:forEach items="${carrinho.itens }" var="item">
						<tbody>
							<tr class="produto-item">
								<td class="produto-image"><a
									href="VerLivro?codigo=${item.livro.codigo}"> <img
										src="${item.livro.imagem }">
								</a></td>
								<td class="produto-nome"><a
									href="VerLivro?codigo=${item.livro.codigo}">${item.livro.titulo}</a>
									<div class="autor">
										<span class="autor-nome">${item.livro.autor}</span>
									</div></td>
								<td class="produto-preco"><span>R$
										${item.livro.preco }0</span></td>
								<td class="quantidade">
						
									<form action="EditarCarrinho" name="form${item.livro.codigo}">
											<a href="EditarCarrinho?codigo=${item.livro.codigo}&acao=adicionar"> + </a>
											<input type="hidden" name="codigo" value="${item.livro.codigo}" /> 
											<input type="hidden" name="acao" value="alterar" /> 
											<input size="2" name="qtd${item.livro.codigo}" value="${item.qtd}" disabled />
										<a href="EditarCarrinho?codigo=${item.livro.codigo}&acao=subtrair"> - </a>
									</form>
									
								</td>
								<td class="preco-total"><span>R$ ${item.valor2}</span></td>
								<td class="item-remove"><a
									href="EditarCarrinho?codigo=${item.livro.codigo}&acao=remover">
										<span class="icone-remove">X</span> <span
										class="hide item-remove-texto">Excluir Item</span>
								</a></td>
							</tr>
						</tbody>
						</c:forEach>
				</table>
			
			</div>
		</div>
		
	</div>
	
	<div class="container">
	<div class="forma-pagamento">	
		<div class="row">
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-body">
						<fieldset class="col-md-5">
							<legend>Forma de Pagamento</legend>
							
							<div class="radio opt-cartao">
								<label><input type="radio" name="optradio">Cartão de Crédido</label>
							</div>
							<div class="radio opt-boleto">
								<label><input type="radio" name="optradio">Boleto
									Bancário (10% desc.)</label>
							</div>
						</fieldset>
						
						<fieldset class="col-md-7">	
							<legend>Cartão de Crédito</legend>

							<div class="form-group">
								<label for="numero-cartao">Número - CVV</label> <input
									type="text" class="form-control" id="numero-cartao"
									name="numero-cartao">
							</div>

							<div class="form-group">
								<label for="bandeira-cartao">Bandeira</label> 
								<select name="bandeira-cartao" id="bandeira-cartao"
									class="form-control">
									<option value="master">MasterCard</option>
									<option value="visa">Visa</option>
									<option value="amex">American Express</option>
								</select>
							</div>

							<div class="form-group">
								<label for="validade-cartao">Validade</label> <input
									type="month" class="form-control" id="validade-cartao"
									name="validade-cartao">
							</div>
						</fieldset>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<table class="table total-compra">
					<tbody>
						<tr>
							<td>Total dos Produtos</td>
							<td>R$ ${carrinho.valorString2}</td>
						</tr>
						<tr>
							<td>Descontos</td>
							<td>R$ 0,00</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td>TOTAL:</td>
							<td>R$ ${carrinho.valorString2}</td>
						</tr>
					</tfoot>
				</table>
				<a href="Pesquisa" class="btn btn-primary">Continuar Comprando</a>
				<a href="FinalizarCompra" class="btn btn-success">Finalizar Compra</a>
			</div>
		</div>
	</div>
	</div>
</c:if>
<c:if test="${carrinho.getItens().size() == 0}">
	<div class="jumbotron">
		<div class="container">
			<h1>Carrinho Vazio</h1>
			<p>Adicione algum produto ao seu carrinho de compras para continuar!</p>
			<a href="Pesquisa" class="btn btn-primary">Continuar Comprando</a>
		</div>
	</div>
</c:if>	


<%@ include file="rodape.html"%>
</body>
</html>