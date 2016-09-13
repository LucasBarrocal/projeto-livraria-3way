package service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import dao.LivroDao;
import model.Livro;

public class CatalogoService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Logger LOG = Logger.getLogger(CatalogoService.class.getName());
	private Livro livro;
	private List<Livro> livros = new ArrayList<Livro>();
	
	public List<Livro> consultar(String titulo) {
		
		if(titulo == null){
			titulo = "";
		}
		LOG.info("Pesquisa: "+titulo);
		LivroDao dao;
		try {
			dao = new LivroDao();
			livros = dao.consultar(titulo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		if(livros.size() <= 0){
			System.out.println("Livro não localizado");
		}
		return livros;
	}
	
	public Livro verLivro(Integer codigo){
		LivroDao dao;
		try {
			dao = new LivroDao();
			livro = dao.consultar(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return livro;
	}
	
	public void cadastroLivro(Livro livro){
		LivroDao dao;
		try {
			dao = new LivroDao();
			dao.salvar(livro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
