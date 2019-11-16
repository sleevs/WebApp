package br.com.unicarioca.aps.webapp.dao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.unicarioca.aps.webapp.model.ProfessorModel;
import br.com.unicarioca.aps.webapp.model.QuestionarioModel;

@Stateless
public class ProfessorDao  extends AbstractFacade<ProfessorModel> {


	 
	 @PersistenceContext(unitName = "ApsPU") 
	 private EntityManager em;
	 
	 protected EntityManager getEntityManager() { 
		 return em; }
	 
	 public ProfessorDao() { 
		 super(ProfessorModel.class);
	 }
	
	
	
	 public ProfessorModel criarRegistroProfessor(ProfessorModel p){
			
			
			em.persist(p);
			em.flush();
			return em.find(ProfessorModel.class, p.getProfessorId()) ;
		}
}
