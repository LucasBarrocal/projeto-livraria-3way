package service;

import dao.UsuarioDao;
import model.Usuario;

public class LoginService {
	
	public Usuario autenticar(String login, String senha,boolean autenticar) {
		Usuario user = null;
		try {
			UsuarioDao dao = new UsuarioDao();
			user = new Usuario();
			user.setLogin(login);
			user.setSenha(senha);
			user = dao.autenticar(user);
			if(user != null){
				user.setAutenticacao(autenticar);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}
}
