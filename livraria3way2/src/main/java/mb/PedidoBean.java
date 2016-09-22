package mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Transient;

import model.Carrinho;
import model.Cliente;
import model.ItemCarrinho;
import model.Pedido;
import service.CompraService;

@Named
@SessionScoped
public class PedidoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static final String LOGIN = "Login";
	private static final String VERIFICAR_PEDIDO = "VerificarPedido";
	private static final String VERIFICAR_ITENS = "VerificarItem";
	
	private Carrinho carrinho;
	private ItemCarrinho item;
	private List<Pedido> pedidos;
	private List<ItemCarrinho> itens;
		
	@Transient
	private double total;
	
	@Inject
	private LoginBean loginBean;
	
	@Inject
	private CompraService compraService;
		
	public String verificarPedido(){
		if(! loginBean.isAutenticado()){
			return LOGIN;
		}
		Cliente cliente = loginBean.getUsuario().getCliente();
		pedidos = compraService.localizarPedidosPorCodCliente(cliente.getCodigo());
		
		return VERIFICAR_PEDIDO;
	}
	
	public String verificarItens(int codPedido){
		total = 0;
		itens = compraService.obterItensPorCodPedido(codPedido);
		for(ItemCarrinho item : itens){
			total +=  item.getValor();
		}
		return VERIFICAR_ITENS;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public ItemCarrinho getItem() {
		return item;
	}

	public void setItem(ItemCarrinho item) {
		this.item = item;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<ItemCarrinho> getItens() {
		return itens;
	}

	public void setItens(List<ItemCarrinho> itens) {
		this.itens = itens;
	}

	

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
	
}
