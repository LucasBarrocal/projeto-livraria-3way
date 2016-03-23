<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<jsp:useBean id="livro" class="workshop.Livro" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/estilo.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<%@include file="masklog.html" %>
<br/>
<center>
<table cellpadding="0" cellspacing="0">
    
<tr>
        
<td rowspan="3">
             <img width="100" src="${livro.imagem}">
            </td>
            <td>${livro.titulo}</td>
        </tr>
        <tr>
        
<td>${livro.autor}</td>
        </tr>
        <tr>
        
<td>R$ ${livro.preco}</td>
       
</tr>
</table>
    <a href="EditarCarrinho?codigo=${livro.codigo}&acao=adicionar">Adicionar ao Carrinho de compras</a>
</center>

<%@include file="rodape.html" %>

</body>
</html>