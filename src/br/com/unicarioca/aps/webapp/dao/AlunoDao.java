package br.com.unicarioca.aps.webapp.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.unicarioca.aps.webapp.model.AlunoModel;
import br.com.unicarioca.aps.webapp.model.RespostaModel;

@Stateless
public class AlunoDao {

	 @PersistenceContext(unitName = "ApsPU") 
	 private EntityManager em;
	 
	 protected EntityManager getEntityManager() { 
		 return em; }
	 
	 public AlunoDao() { 
		
	 }
	
	 

	 
	 public AlunoModel buscarAluno(Integer id) {
		 
		 return  em.find(AlunoModel.class, id); 
	 }

}
