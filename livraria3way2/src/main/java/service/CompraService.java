package service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

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
	
	@Inject
	private LivroDao livroDao;
	
	@Inject
	private PedidoDao pedidoDao;

	public ItemCarrinho novoItemCarrinho(int codigo){
		ItemCarrinho item = null;
		Livro livro = livroDao.consultar(codigo);
		item = new ItemCarrinho();
		item.setLivro(livro);
		return item;
	}
	
	public boolean efetivarPedido(Cliente cliente, Carrinho car, EnumTipoPagamento pag,String cartao){
		
		Pedido pedido = new Pedido();
		Date dataPedido = new Date(pedido.getDataPedido().getTime());
		pedido.setCliente(cliente);
		pedido.setDataPedido(dataPedido);
		pedido.setItens(car.getItens());
		pedido.setStatus("Pedido Registrado");
		pedido.setValorTotal(car.getValor());
		pedido.setPagamento(pag);
		pedido.setTipoCartao(cartao);
		pedidoDao.salvar(pedido);
		return true;
	}
	
	public List<Pedido> localizarPedidosPorCodCliente(int codCliente){
		
		return pedidoDao.listar(codCliente);
	}
	
	public List<ItemCarrinho> obterItensPorCodPedido(int codPedido){
		List<ItemCarrinho> itens = null;
		itens = pedidoDao.listarItem(codPedido);
		return itens;
	}
}
