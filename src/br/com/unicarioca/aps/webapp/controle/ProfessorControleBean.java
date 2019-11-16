package br.com.unicarioca.aps.webapp.controle;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;

import br.com.unicarioca.aps.webapp.business.ProfessorBusiness;
import br.com.unicarioca.aps.webapp.model.FeedbackModel;
import br.com.unicarioca.aps.webapp.model.PerguntaModel;
import br.com.unicarioca.aps.webapp.model.ProfessorModel;
import br.com.unicarioca.aps.webapp.model.QuestionarioModel;
import br.com.unicarioca.aps.webapp.model.RespostaModel;

public class ProfessorControleBean {

	@EJB
	private ProfessorBusiness  professorBusiness;
	
	

	
	
	
	public ProfessorModel criarProfessor(ProfessorModel p){
		return professorBusiness.criarContaProfessor(p);
	}
	

	 public QuestionarioModel criarQuestionario(Integer id) {
		
		 
		 
		 return professorBusiness.criarQuestionario(id);
	}
	
	
	
	public ProfessorModel selecionarQuestionario(ProfessorModel p){
		return professorBusiness.criarContaProfessor(p);
	}
	
	
	
	public List<PerguntaModel> criarPerguntas(List<PerguntaModel> p , Integer questionario){
		return professorBusiness.criarListaDePerguntas(p, questionario);
	}
	
	
	public PerguntaModel criarPergunta(PerguntaModel p , Integer questionario){
		return professorBusiness.criarPergunta(p, questionario);
	}
	
	
	
	 public List<QuestionarioModel> analisarRespostas(Integer id) {
		 return professorBusiness.analisarRespostas(id);
	}
	
	
	 public List<RespostaModel> questionariosAluno( Integer idQuestionario) {
		
		 return professorBusiness.meusQuestionarios(idQuestionario);
	}
	 
	 
		
		
		 public FeedbackModel realizarFeedBack(Integer repostaId, Integer professorId ,String  feedbackDescricao) {
			
			 
			 
			 return professorBusiness.realizarFeedBack(repostaId, professorId, feedbackDescricao);
		 }
		
	

}
