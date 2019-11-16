package br.com.unicarioca.aps.webapp.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.unicarioca.aps.webapp.business.AlunoBusiness;
import br.com.unicarioca.aps.webapp.business.ProfessorBusiness;
import br.com.unicarioca.aps.webapp.dao.ProfessorDao;
import br.com.unicarioca.aps.webapp.model.FeedbackModel;
import br.com.unicarioca.aps.webapp.model.PerguntaModel;
import br.com.unicarioca.aps.webapp.model.ProfessorModel;
import br.com.unicarioca.aps.webapp.model.QuestionarioModel;
import br.com.unicarioca.aps.webapp.model.RespostaModel;

@WebService
public class ProfessorWebService {

	@EJB
	AlunoBusiness alunoBusiness;
	
	@EJB
	ProfessorDao professorDao;
	@EJB
	ProfessorBusiness professorBusiness ;
	
	
	@WebMethod
	public List<ProfessorModel> listar(){
		return professorDao.findAll();
	}
	
	
	@WebMethod
	public ProfessorModel criarProfessor(ProfessorModel p){
		return professorBusiness.criarContaProfessor(p);
	}
	
	@WebMethod
	 public QuestionarioModel criarQuestionario(Integer id) {
		
		 
		 
		 return professorBusiness.criarQuestionario(id);
	}
	
	
	@WebMethod
	public ProfessorModel selecionarQuestionario(ProfessorModel p){
		return professorBusiness.criarContaProfessor(p);
	}
	
	
	@WebMethod
	public List<PerguntaModel> criarPerguntas(List<PerguntaModel> p , Integer questionario){
		return professorBusiness.criarListaDePerguntas(p, questionario);
	}
	
	@WebMethod
	public PerguntaModel criarPergunta(PerguntaModel p , Integer questionario){
		return professorBusiness.criarPergunta(p, questionario);
	}
	
	
	@WebMethod
	 public List<QuestionarioModel> analisarRespostas(Integer id) {
		 return professorBusiness.analisarRespostas(id);
	}
	
	@WebMethod
	 public List<RespostaModel> questionariosAluno( Integer idQuestionario) {
		
		 return professorBusiness.meusQuestionarios(idQuestionario);
	}
	
	@WebMethod
	 public RespostaModel responderPergunta( String descricao , Integer a , Integer id) {
			
		 return alunoBusiness.responderPergunta(descricao, a, id);
	}
	
	
	@WebMethod
	 public FeedbackModel realizarFeedBack(Integer repostaId, Integer professorId ,String  feedbackDescricao) {
		
		 
		 
		 return professorBusiness.realizarFeedBack(repostaId, professorId, feedbackDescricao);
	 }
	
	
	@WebMethod
	 public List<FeedbackModel> meusFeedBack( Integer a ) {
		
		 return alunoBusiness.meusFeedBack(a);
	}
	

}
