package mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Carrinho;
import model.Cliente;
import model.EnumTipoPagamento;
import model.ItemCarrinho;
import model.Usuario;
import service.CompraService;

@ManagedBean(name="carrinhoBean")
@SessionScoped
public class CarrinhoBean implements Serializable {
	
	private Carrinho carrinho;
	private EnumTipoPagamento pagamento;
	private String cartao;
	private CompraService compraService;
	private static final String CARRINHO = "Carrinho";
	
	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	@PostConstruct
	private void init(){
		compraService = new CompraService();
	}
	
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
