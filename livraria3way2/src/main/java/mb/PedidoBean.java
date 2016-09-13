package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.Transient;

import model.Carrinho;
import model.Cliente;
import model.ItemCarrinho;
import model.Pedido;
import service.CompraService;

@ManagedBean(name="pedidoBean")
@SessionScoped
public class PedidoBean {
	
	private static final String LOGIN = "Login";
	private static final String VERIFICAR_PEDIDO = "VerificarPedido";
	private static final String VERIFICAR_ITENS = "VerificarItem";
	
	private Carrinho carrinho;
	private ItemCarrinho item;
	private List<Pedido> pedidos;
	private List<ItemCarrinho> itens;
		
	@Transient
	private double total;
	
	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	
	private CompraService compraService;
	
	@PostConstruct
	private void init(){
		compraService = new CompraService();
	}
	
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
