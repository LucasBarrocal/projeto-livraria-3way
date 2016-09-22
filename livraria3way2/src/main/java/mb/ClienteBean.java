package mb;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import model.Cliente;
import model.Usuario;
import service.CadastroService;

@Named
@SessionScoped
public class ClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Logger LOG = Logger.getGlobal();
	private String nome,login,senha,endereco,bairro,cidade,estado,cep;
	private Cliente cliente;
	private Usuario usuario;
	
	@Inject
	private CadastroService service;
	
	@Inject
	private LoginBean loginBean;
	
	public void cadastrar(){

		cliente = new Cliente();
		usuario = new Usuario();
		
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		cliente.setNome(nome);
		cliente.setBairro("alterar");
		cliente.setCidade("alterar");
		cliente.setEndereco("alterar");
		cliente.setEstado("alterar");
		cliente.setCep("alterar");
				
		usuario.setCliente(cliente);
		service.cadastrar(usuario);
	
	}
	
	public void alterarCadastro(){
		
		FacesMessage msg = null;
		
		if(cliente == null){
			cliente = service.recuperarInfo(loginBean.getUsuario().getNome());
		}

		cliente.setEndereco(endereco);
		cliente.setBairro(bairro);
		cliente.setCidade(cidade);
		cliente.setCep(cep);
		cliente.setEstado(estado);
		
		service.alterarCadastro(cliente);
		
		msg = new FacesMessage("Cadastro alterado com Sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		LOG.info("Cadastro alterado com sucesso");
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public CadastroService getService() {
		return service;
	}

	public void setService(CadastroService service) {
		this.service = service;
	}
	
	
}
