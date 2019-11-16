package br.com.unicarioca.aps.webapp.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.unicarioca.aps.webapp.model.ProfessorModel;
import br.com.unicarioca.aps.webapp.model.QuestionarioModel;
import br.com.unicarioca.aps.webapp.model.RespostaModel;

@Stateless
public class QuestionarioDao {


	 @PersistenceContext(unitName = "ApsPU") 
	 private EntityManager em;
	 
	 protected EntityManager getEntityManager() { 
		 return em; }
	 
	 public QuestionarioDao() { 
		
	 }
	
	
	
	public QuestionarioModel criarQuestionario(QuestionarioModel q){
	
		
		em.persist(q);
		em.flush();
		return em.find(QuestionarioModel.class, q.getQuestionarioId()) ;
	}
	
	
       public QuestionarioModel selecionarQuestionario(Integer q){
		
		return em.find(QuestionarioModel.class, q) ;
	}
       
       
       public List<QuestionarioModel> buscarQuestionarioPorIdProfessor(Integer quest) {
  		
    	   try {
  			 
  			 Query q = em.createQuery("SELECT r FROM QuestionarioModel r WHERE r.professorModel.professorId = :valor" ,QuestionarioModel.class)
  					 .setParameter("valor", quest);
  			 return (List<QuestionarioModel>) q.getResultList();
  			 
  		 }catch(Exception e) {
  			 
  		 }
  		 return null ;
  		 
  	 }

}
