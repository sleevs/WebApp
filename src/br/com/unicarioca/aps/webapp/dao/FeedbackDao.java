package br.com.unicarioca.aps.webapp.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.unicarioca.aps.webapp.model.FeedbackModel;
import br.com.unicarioca.aps.webapp.model.PerguntaModel;
import br.com.unicarioca.aps.webapp.model.QuestionarioModel;
import br.com.unicarioca.aps.webapp.model.RespostaModel;

@Stateless
public class FeedbackDao {

	 @PersistenceContext(unitName = "ApsPU") 
	 private EntityManager em;
	 
	 protected EntityManager getEntityManager() { 
		 return em; }
	 
	 public FeedbackDao() { 
		
	 }
	 
	 
	 
	 
	 public FeedbackModel criarFeedback(FeedbackModel f) {
	
		 em.persist(f);
		 em.flush();
		 
		 return em.find(FeedbackModel.class, f.getFeedbackId()) ;
	 }
	 
	 
	 
	  public List<FeedbackModel> selecionarFeedbackPorIdAluno(Integer alunoId) {
	  		 
	   		
	  		 try {
	  			 
	  			//SELECT vp FROM VendaPedido vp WHERE vp.vendaVendaId.servicoServicoId.servicoId = :id 
	  			Query q = em.createQuery("SELECT r FROM FeedbackModel r WHERE r.respostaModel.alunoModel.alunoId = :valor" ,FeedbackModel.class)
	  					 .setParameter("valor", alunoId);
	  			 return (List<FeedbackModel>) q.getResultList();
	  			 
	  		 }catch(Exception e) {
	  			 
	  		 }
	  		 return null ;
	  		 
	  	 }
}
