<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/estilo.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<title>Resultado</title>
</head>
<body>
  
<c:forEach items="${livros}" var="livro">
<div class="row">
   <div class="col-md-4">
                        <div class="thumbnail">
                            <img src="${livro.imagem}" id="img-livro">
                            <div class="caption">
                                <h4 class="pull-right">R$ ${livro.preco}</h4>
                                <h4><a href="VerLivro?codigo=${livro.codigo}">${livro.titulo}</a>
                                </h4>
                                <h4> ${livro.autor}</h4>
                            </div>
                           
                        </div>
                    </div>
                    </div>
    </c:forEach>
    
    
    
</body>
</html>