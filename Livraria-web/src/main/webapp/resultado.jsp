<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Livros</title>
<link href="css/estilo.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
<%@ include file="mascara.html" %>
<%@ include file="menu.html" %>
<div class="container pesquisa">
<center>
  <span class="titulo">
    Resultado da Pesquisa:
  </span>
  <br/><br/><br/>
  <table class="table table-hover" width="600px">
  
<thead>
 <tr> 
<th>Titulo</th>
  
<th>Autor</th>
  
<th>Preço</th>
  </tr>
</thead>
    <c:forEach items="${livros}" var="livro">
      <tr onclick="document.location.href='VerLivro?codigo=${livro.codigo}'" 
style="cursor:pointer" onmouseover="this.style.background='#ccc'" 
onmouseout="this.style.background='#fff'">
         <td align="center"><img width="30" src="${livro.imagem}" /></td>
         <td>${livro.titulo}</td>
         <td>${livro.autor}</td>
         <td>R$ ${livro.preco}</td>
      </tr>
    </c:forEach>
  </table>
  </center>
</div>
<%@ include file="rodape.html" %>
</body>
</html>