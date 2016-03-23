<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="carrinho" scope="session" class="workshop.Carrinho"/>
<jsp:useBean id="cliente" scope="session" class="workshop.Cliente"/>
<jsp:useBean id="mensagem" scope="session" class="java.lang.String"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro</title>
<link href="css/estilo.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="mascara.html" %>

<h1>Confirme seus dados</h1>

<pre class="container">
${mensagem}
<div class="centered">
<form method="post" action="EditarCliente?acao=cadastrar">
<table>
<tr>
	<td>Nome:</td>
	<td><input type="text" name="nome"/></td>
</tr>
<tr>
	<td>Login:</td>
	<td><input type="text" name="login"/></td>
</tr>
<tr>
	<td>Senha:</td>
	<td><input type="password" name="senha1"/></td>
</tr>
<tr>
	<td>Repita senha:</td>
	<td><input type="password" name="senha2"/></td>
</tr>
<tr>
	<td>Endereço:</td>
	<td><input type="text" name="endereco" /></td> 
</tr>
<tr>
	<td>Cidade:</td>
	<td><input type="text" name="cidade"/></td>
</tr>
<tr>
	<td>Bairro:</td>
	<td><input type="text" name="bairro"/></td>
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
	<td colspan="2" align="center"><input type="submit" value="Confirmar"></td>
</tr>
</table>
</form>
</div>
</pre>

 <% request.getSession().setAttribute("cliente", null); %>
 <%@ include file="rodape.html" %>
</body>
</html>
