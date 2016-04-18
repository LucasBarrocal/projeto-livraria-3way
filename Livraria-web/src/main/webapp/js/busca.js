function buscarProduto(titulo){
	var produtos=[    
	              {"livros" : ["BRANCA DE NEVE", "A BELA MOÇA", "O GUIA", "DR. OZZY", "PEQUENO IRMÃO"],
	              "filmes" : ["DEADPOOL", "GODZILLA", "LAGOA AZUL", "AMERICAN PIE", "HANNIBAL"],
	              "musicas": ["ZZ TOP", "BLACK SABBATH", "AC DC", "PRIMUS", "MOLEJO"],
	              "games": ["MIRRORS EDGE", "FIFA", "BATTLEFIELD", "UNDERTALE", "SUPERHOT"]}
	];

	var nome = titulo.value.toUpperCase();
	for(var i=0; i < produtos.length ; i++){
		for(var v=0; v < produtos[i].games.length; v++){
			if(produtos[i].games[v] == nome){
				window.alert("Temos "+ titulo.value +" em nosso estoque de jogos");
				
			}
		}
		for(var v=0; v < produtos[i].livros.length; v++){    
			if(produtos[i].livros[v] == nome){
				window.alert("Temos "+ titulo.value +" em nosso estoque de livros");
				
			}
		}
		for(var v=0; v < produtos[i].filmes.length; v++){
			if(produtos[i].filmes[v] == nome){
				window.alert("Temos "+ titulo.value +" em nosso estoque de filmes");
				
			}
		}
		for(var v=0; v < produtos[i].musicas.length; v++){ 
			if(produtos[i].musicas[v] == nome){
				window.alert("Temos "+ titulo.value +" em nosso estoque de músicas");
				
			} 
		}
    }
	if(titulo.value == ""){
		window.alert("Busca vazia!");
	}
	else{
		window.alert("Produto não encontrado!");
	}
     
  	
}