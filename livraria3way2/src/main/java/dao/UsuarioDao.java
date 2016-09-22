package dao;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import model.Usuario;

public class UsuarioDao implements Dao<Usuario, String> {
	
	@Inject
	private EntityManager em;
		
	@Override
	public Usuario consultar(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Usuario Serializable) {
		// TODO Auto-generated method stub
		
	}
	public boolean existeUsuario(String login){
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> q = cb.createQuery(Usuario.class);
		Root<Usuario> root = q.from(Usuario.class);
		q.select(root).where(cb.like(root.get("login"),login));
		TypedQuery<Usuario> query = em.createQuery(q);
		try{
			query.getSingleResult();
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	@Transactional
	public void salvar(Usuario usuario) {
		em.persist(usuario);	
	}

	@Override
	public void remover(Usuario Serializable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario autenticar(Usuario user) {
		Query qry = em.createQuery("SELECT c FROM Usuario c " 
				+ "WHERE c.login = :p1 AND c.senha = :p2 ", Usuario.class);
		
		qry.setParameter("p1",user.getLogin());
		qry.setParameter("p2",user.getSenha());
		
		user = (Usuario) qry.getSingleResult();
		user.setAutenticacao(true);
		return user;
	}

}
