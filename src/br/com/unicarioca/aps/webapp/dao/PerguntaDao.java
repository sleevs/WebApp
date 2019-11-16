package br.com.unicarioca.aps.webapp.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.unicarioca.aps.webapp.model.PerguntaModel;


@Stateless
public class PerguntaDao {

	 @PersistenceContext(unitName = "ApsPU") 
	 private EntityManager em;
	 
	 protected EntityManager getEntityManager() { 
		 return em; }
	 
	
	 
	 
	public PerguntaModel criarPergunta(PerguntaModel p) {
	
		 em.persist(p);
		 em.flush();
		return em.find(PerguntaModel.class, p.getPerguntaId());
	}
	
	
	
	public PerguntaModel buscarPergunta(Integer p) {
		
		return em.find(PerguntaModel.class, p);
	}
	
	
public PerguntaModel buscarPerguntaPorIdAluno(Integer p) {
		
		return em.find(PerguntaModel.class, p);
	}


	public List<PerguntaModel> buscarPerguntaPorQuestionarioId(Integer p) {

		try {

			Query q = em.createQuery("SELECT p FROM PerguntaModel p WHERE p.questionarioModel.questionarioId = :valor",
					PerguntaModel.class).setParameter("valor", p);

			return q.getResultList();

		} catch (Exception e) {

		}
		return null;
	}
}
