package br.com.unicarioca.aps.webapp.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.unicarioca.aps.webapp.model.AlunoModel;
import br.com.unicarioca.aps.webapp.model.PerguntaModel;
import br.com.unicarioca.aps.webapp.model.RespostaModel;


@Stateless
public class RespostaDao {

	 @PersistenceContext(unitName = "ApsPU") 
	 private EntityManager em;
	 
	 protected EntityManager getEntityManager() { 
		 return em; }
	 
	
	 public List<RespostaModel> buscarRespostaPorIdQuestionario(Integer quest) {
		 
		
		 try {
			 
			 
			 TypedQuery<RespostaModel> q = em.createNamedQuery("SELECT r FROM RespostaModel r WHERE  r.perguntaModel.questionarioModel = :valor" ,RespostaModel.class)
					 .setParameter("valor", quest);
			 return q.getResultList();
			 
		 }catch(Exception e) {
			 
		 }
		 return null ;
		 
	 }
	 
	 
	 
	 //`resposta_descricao`, `aluno_aluno_id`, `pergunta_pergunta_id`
	 public RespostaModel responder(String respostaDescricao , AlunoModel alunoId , PerguntaModel perguntaId) {
		RespostaModel r = new RespostaModel();
	
		r.setPerguntaModel(perguntaId);
		 r.setRespostaDescricao(respostaDescricao);
		r.setAlunoModel(alunoId);
		 em.persist(r);
		 
		 return em.find(RespostaModel.class,r.getRespostaId());
	 }
	 
	 
	 
	 public RespostaModel buscarResposta(Integer r) {
		 
		 return em.find(RespostaModel.class, r);
	 }

}
