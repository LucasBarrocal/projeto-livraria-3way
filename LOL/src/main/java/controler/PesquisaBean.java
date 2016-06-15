package controler;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import DAO.LivroDao;
import service.Livro;

@Named
@SessionScoped
public class PesquisaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String titulo;
	private Livro livro;
	private ArrayList<Livro> livros= new ArrayList<Livro>();
	
	public String pesquisar(){
		
		if(titulo==null){
			titulo = "";
		}
		System.out.println("Pesquisa: "+titulo);

		try{
			LivroDao dao = new LivroDao();
			List<Livro> array = dao.consultar(titulo);
			int tamanho = array.size();
			if(tamanho>0){
				
				livros.addAll(array);
				System.out.println(livros.toString());
				
			}
			else{
				System.out.println(titulo + "- Esta vindo vazio!");
			}
		}
		catch(SQLException e){
				e.printStackTrace();
			}
		
		return "Resultado";
		}
	
	public String verLivro(Integer codigo){
		
		//int codigo;
		try{
			//codigo = Integer.parseInt(codigo);
		}catch(NumberFormatException e){
			codigo = 0;
		}
		try{
			LivroDao dao = new LivroDao();
			livro = dao.consultar(codigo);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return "Livro";
	}
	
	public ArrayList<Livro> getLivros() {
		return livros;
	}


	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	

}
