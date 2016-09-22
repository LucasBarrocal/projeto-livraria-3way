package service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.inject.Inject;

import dao.ClienteDao;
import dao.UsuarioDao;
import model.Cliente;
import model.Usuario;

public class CadastroService implements Serializable{

	private static final long serialVersionUID = 1L;
	private Logger LOG = Logger.getGlobal();
	
	@Inject
	private ClienteDao clienteDao;
	
	@Inject
	private UsuarioDao usuarioDao;

	
	public void cadastrar(Usuario usuario){
		if(usuarioDao.existeUsuario(usuario.getLogin()) == false){
			usuarioDao.salvar(usuario);
		}
		else
			LOG.info("Já existe Usuário!");
	}
	
	
	public void alterarCadastro(Cliente cliente){
		clienteDao.alterar(cliente);
	}
	
	public Cliente recuperarInfo(String nome){
		Cliente cliente = new Cliente();
		cliente = clienteDao.consultar(nome);
		return cliente;
	}
	
}
