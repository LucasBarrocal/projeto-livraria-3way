package util;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu-livraria3way2")
	private EntityManager em;
	
	@Produces
	public EntityManager createEntityManager(){
		System.out.println("EntityManagerProducer.createEntityManager()"+em);
		return em;
	}
	
	public void closeEntityManager(@Disposes EntityManager manager){
		System.out.println("EntityManagerProducer.closeEntityManager()");
		if(manager.isOpen()){
			manager.close();
		}
	}
}
