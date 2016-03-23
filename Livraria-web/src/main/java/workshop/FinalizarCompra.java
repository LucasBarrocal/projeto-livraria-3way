package workshop;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FinalizarCompra")
public class FinalizarCompra extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
		Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
		
		if(carrinho.getItens().size()==0 || cliente == null){
			String mensagem = "O carrinho esta vazio ou você não está logado!";
			request.getSession().setAttribute("mensagem",mensagem);
			response.sendRedirect("EditarCarrinho");
			return;
		}
		request.getSession().removeAttribute("carrinho");
		
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setItens(carrinho.getItens());
		pedido.setStatus("Pedido Registrado");
		
		PedidoDao dao = null;
		try{
			dao = new PedidoDao();
		} catch(SQLException e){
			e.printStackTrace();
		}
		dao.incluir(pedido);
		response.sendRedirect("fim.jsp");
	}

}
