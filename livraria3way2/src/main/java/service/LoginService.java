package service;

import java.io.Serializable;

import javax.inject.Inject;

import dao.UsuarioDao;
import model.Usuario;

public class LoginService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioDao usuarioDao;
	
	public Usuario autenticar(String login, String senha,boolean autenticar) {
		Usuario user = null;
		try {
			user = new Usuario();
			user.setLogin(login);
			user.setSenha(senha);
			user = usuarioDao.autenticar(user);
			if(user != null){
				user.setAutenticacao(autenticar);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
