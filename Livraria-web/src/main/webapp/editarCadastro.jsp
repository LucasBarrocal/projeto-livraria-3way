<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="carrinho" scope="session" class="workshop.Carrinho"/>
<jsp:useBean id="cliente" scope="session" class="workshop.Cliente"/>
<jsp:useBean id="mensagem" scope="session" class="java.lang.String"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar Cadastro</title>
<link href="css/estilo.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="masklog.html" %>
<span class="titulo">
Confirme seus dados
</span>
<pre>
${mensagem}
<form method="post" action="EditarCliente?acao=alterar">
<table cellpadding="0" cellspacing="0" align="center">

<tr>
	<td>Login:</td>
	<td><input type="text" name="login" /></td>
</tr>
<tr>
	<td>Senha:</td>
	<td><input type="password" name="senha1"/></td>
</tr>
<tr>
	<td>Endereço:</td>
	<td><input type="text" name="endereco"/></td> 
</tr>
<tr>
	<td>Cidade:</td>
	<td><input type="text" name="cidade" /></td>
</tr>
<tr>
	<td>Bairro:</td>
	<td><input type="text" name="bairro" /></td>
</tr>
<tr>
	<td>Estado:</td>
	<td><input type="text" name="estado" /></td>
</tr>
<tr>
	<td>CEP:</td>
	<td><input type="text" name="cep" /></td>
</tr>
<tr>
	<td colspan="2" align ="center"><input type="submit" value="Confirmar" onclick=""></td>
</tr>

</table>
</form>
</pre>
<c:if test="${cliente.autenticacao }">
	<c:if test="${carrinho.emptyCarrinho }">
		<a href="FinalizarCompra">Finalizar a compra</a>
	</c:if>
	<a href="VerificarPedidos">Vericar Pedidos</a>
</c:if>
<%@include file="rodape.html" %>

</body>

</html>