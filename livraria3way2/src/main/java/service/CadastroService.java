package service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Logger;

import dao.ClienteDao;
import dao.UsuarioDao;
import model.Cliente;
import model.Usuario;

public class CadastroService implements Serializable{

	private static final long serialVersionUID = 1L;
	private Logger LOG = Logger.getGlobal();
	
	private ClienteDao clienteDao;
	private UsuarioDao usuarioDao;

	
	public void cadastrar(Usuario usuario){
		try{
			usuarioDao = new UsuarioDao();
			if(usuarioDao.existeUsuario(usuario.getLogin()) == false){
				usuarioDao.salvar(usuario);
			}
			else
				LOG.info("Já existe Usuário!");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	public void alterarCadastro(Cliente cliente){
		try{
			clienteDao = new ClienteDao();
			clienteDao.alterar(cliente);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public Cliente recuperarInfo(String nome){
		Cliente cliente = new Cliente();
		try{
			clienteDao = new ClienteDao();
			cliente = clienteDao.consultar(nome);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return cliente;
	}
	
}
