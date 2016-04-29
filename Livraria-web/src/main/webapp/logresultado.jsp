<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/estilo.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<title>Resultado</title>
</head>
<body>
<%@ include file="masklog.html" %>

        <div class="container painel-resultado">

        <!-- Page Heading -->
        
        <div class="row">
        <div class="col-md-3">
        <%@ include file="menu.html" %>
        </div>
            <div class="col-lg-9">
                <h1 class="page-header">Resultado
                    <small>Livros Disponíveis</small>
                </h1>
           
        <!-- /.row -->

        <!-- Project -->
        <c:forEach items="${livros }" var="livro">
        <div class="panel">
        <div class="row">
            <div class="col-md-3">
                <a href="VerLivro?codigo=${livro.codigo}">
                    <img class="thumbnail" src="${livro.imagem }" id="img-livro">
                </a>
            </div>
            <div class="col-md-9">
                <h3 class="titulo">${livro.titulo }</h3>
                <h4 class="pull-right preco">R$ ${livro.preco }0</h4>
                <h4>${livro.autor }</h4>
                <p class="descricao">${livro.descricao }</p>
            	<a class="btn btn-primary descricao" href="VerLivro?codigo=${livro.codigo}">Ver Produto <span class="glyphicon glyphicon-circle-arrow-left"></span></a>
            	<a class="btn btn-success" href="EditarCarrinho?codigo=${livro.codigo}&acao=adicionar">Adicionar ao Carrinho</a>
            	
            </div>
        </div>
        </div>
        </c:forEach>
        <!-- /.row -->

        <hr>
         </div>
        </div>
</div>
      
    
    
<%@ include file="rodape.html" %>    
</body>
</html>