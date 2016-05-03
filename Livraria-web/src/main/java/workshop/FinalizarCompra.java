package workshop;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

@WebServlet("/FinalizarCompra")
public class FinalizarCompra extends HttpServlet{
	
	private String mensagem;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
		Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
		
		if(cliente == null){
			request.setAttribute("mensagem", mensagem);
			response.sendRedirect("login.jsp");
			return;
		}
		request.getSession().removeAttribute("carrinho");
		mensagem = "";
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setItens(carrinho.getItens());
		String pgto = request.getParameter("optradio");
		System.out.println(pgto);
		if(pgto == "cartao"){
			pedido.setPagamento("Cartão");
		}else if(pgto == "boleto"){
			pedido.setPagamento("Boleto");
		}
		
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
