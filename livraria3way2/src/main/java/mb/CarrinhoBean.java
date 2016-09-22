package mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import model.Carrinho;
import model.EnumTipoPagamento;
import model.ItemCarrinho;
import model.Usuario;
import service.CompraService;

@Named
@SessionScoped
public class CarrinhoBean implements Serializable {
	
	private Carrinho carrinho;
	private EnumTipoPagamento pagamento;
	private String cartao;
	private static final String CARRINHO = "Carrinho";
	
	@Inject
	private CompraService compraService;
	
	@Inject
	private LoginBean loginBean;
	
	
	private Carrinho getInstanciaCarrinho(){
		if(carrinho == null){
			carrinho = new Carrinho();
		}
		return carrinho;
	}
	
	public String adicionarLivroCarrinho(int codigo){
		ItemCarrinho item;
		item = compraService.novoItemCarrinho(codigo);
		getInstanciaCarrinho().adicionar(item);
		return CARRINHO;
	}
	
	public void adicionar(int codigo){
		carrinho.adicionar(codigo);
	}
	
	public void retirar(int codigo){
		carrinho.subtrair(codigo);
	}
	
	public void remover(int codigo){
		carrinho.remover(codigo);
	}
	
	public boolean finalizarCompra(){
		FacesMessage mensagem = null;
		Usuario user = loginBean.getUsuario();
		if(user == null || ! user.isAutenticacao()){
			mensagem = new FacesMessage("Faça seu login antes de concluir a compra");
			mensagem.setSeverity(FacesMessage.SEVERITY_WARN);
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			return false;
		}
		return compraService.efetivarPedido(user.getCliente(), carrinho, pagamento.CARTAO, cartao);
	}
	
	
	public boolean getCarrinhoVazio(){
		if(getInstanciaCarrinho().getItens().size() == 0)
			return false;
		return true;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public EnumTipoPagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(EnumTipoPagamento pagamento) {
		this.pagamento = pagamento;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}
	
	
	
}
