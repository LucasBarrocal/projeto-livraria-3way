function buscarProduto(titulo){
	var livros = ["Branca de Neve", "A Bela Moça", "O Guia", "Dr. Ozzy", "Pequeno Irmão"];
	var filmes = ["Deadpool", "Godzilla", "As Tranças da Vovó Careca", "Loucademia de Polícia"];
	var musicas= ["ZZ Top", "Black Sabbath", "Lorranna Santos"];
	var games= ["Mario Kart", "Fifa 17", "Battlefield 4", "Undertale", "SuperHot"];
	if(titulo.value == ""){
		alert("Busca Vazia! Procure entre nossas seleções de LIVROS, FILMES, GAMES e MÚSICAS! ");
	}
	else if(titulo.value=="livros" || titulo.value=="livro"||titulo.value=="Livros"||titulo.value=="Livro"){
		window.alert(livros);
	}
	else if(titulo.value=="filmes" || titulo.value=="filme"||titulo.value=="Filmes"||titulo.value=="Filme"){
		window.alert(filmes);
	}
	else if(titulo.value=="musicas" || titulo.value=="músicas"||titulo.value=="musica"||titulo.value=="música"){
		window.alert(musicas);
	}
	else if(titulo.value=="games" || titulo.value=="jogos"||titulo.value=="Games"||titulo.value=="Jogos"){
		window.alert(games);
	}
	else{
		window.alert("Procure entre nossas seleções de LIVROS, FILMES e MÚSICAS!");
	}
}