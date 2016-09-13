package service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import dao.LivroDao;
import dao.PedidoDao;
import model.Carrinho;
import model.Cliente;
import model.EnumTipoPagamento;
import model.ItemCarrinho;
import model.Livro;
import model.Pedido;

public class CompraService implements Serializable{

	private static final long serialVersionUID = 1L;

	public ItemCarrinho novoItemCarrinho(int codigo){
		ItemCarrinho item = null;
		try{
			LivroDao dao = new LivroDao();
			Livro livro = dao.consultar(codigo);
			item = new ItemCarrinho();
			item.setLivro(livro);
			//item.setCodigo(codigo);
		} catch(SQLException e1){
			e1.printStackTrace();
		}
		return item;
	}
	
	public boolean efetivarPedido(Cliente cliente, Carrinho car, EnumTipoPagamento pag,String cartao){
		
		try{
			Pedido pedido = new Pedido();
			Date dataPedido = new Date(pedido.getDataPedido().getTime());
			pedido.setCliente(cliente);
			pedido.setDataPedido(dataPedido);
			pedido.setItens(car.getItens());
			pedido.setStatus("Pedido Registrado");
			pedido.setValorTotal(car.getValor());
			pedido.setPagamento(pag);
			pedido.setTipoCartao(cartao);
			PedidoDao dao = new PedidoDao();
			dao.salvar(pedido);
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Pedido> localizarPedidosPorCodCliente(int codCliente){
		PedidoDao dao = null;
		try{
			dao = new PedidoDao();
		} catch(Exception e){
			e.printStackTrace();
		}
		return dao.listar(codCliente);
	}
	
	public List<ItemCarrinho> obterItensPorCodPedido(int codPedido){
		List<ItemCarrinho> itens = null;
		try{
			PedidoDao dao = new PedidoDao();
			itens = dao.listarItem(codPedido);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return itens;
	}
}
