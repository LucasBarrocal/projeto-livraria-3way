package workshop;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditarCarrinho")
public class EditarCarrinho extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String cod = request.getParameter("codigo");
		String acao = request.getParameter("acao");
		Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
		if(carrinho == null){
			carrinho = new Carrinho();
		}
		int codigo;
		try{
			codigo = Integer.parseInt(cod);
		}
		catch(NumberFormatException e){
			codigo = 0;
		}
		LivroDao dao = null;
		try{
			dao = new LivroDao();
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
		Livro livro = dao.consultar(codigo);
		ItemCarrinho item = new ItemCarrinho();
		item.setLivro(livro);
		if("adicionar".equals(acao)){
			carrinho.adicionar(item);
		}
		if("remover".equals(acao)){
			carrinho.remover(item);
		}
		if("alterar".equals(acao)){
			String val = request.getParameter("qtd"+codigo);
			int valor;
			try{
				valor = Integer.parseInt(val);
			}
			catch(NumberFormatException e){
				valor = 0;
			}
			item.setQtd(valor);
			carrinho.altera(item);
		}
		request.getSession().setAttribute("carrinho", carrinho);
		Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
		RequestDispatcher rd;
		if(cliente == null){
			rd = request.getRequestDispatcher("carrinho.jsp");
		}
		else{
			rd = request.getRequestDispatcher("logcarrinho.jsp");
		}
		rd.forward(request, response);
	}

}
