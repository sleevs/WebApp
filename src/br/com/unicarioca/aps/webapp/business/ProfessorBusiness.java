package br.com.unicarioca.aps.webapp.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.unicarioca.aps.webapp.dao.AlunoDao;
import br.com.unicarioca.aps.webapp.dao.FeedbackDao;
import br.com.unicarioca.aps.webapp.dao.PerguntaDao;
import br.com.unicarioca.aps.webapp.dao.ProfessorDao;
import br.com.unicarioca.aps.webapp.dao.QuestionarioDao;
import br.com.unicarioca.aps.webapp.dao.RespostaDao;
import br.com.unicarioca.aps.webapp.model.AlunoModel;
import br.com.unicarioca.aps.webapp.model.FeedbackModel;
import br.com.unicarioca.aps.webapp.model.PerguntaModel;
import br.com.unicarioca.aps.webapp.model.ProfessorModel;
import br.com.unicarioca.aps.webapp.model.QuestionarioModel;
import br.com.unicarioca.aps.webapp.model.RespostaModel;

/*
 * 
 * 
 * 
 * autor:jeison muniz
 * background: atividade superviosanada
 * escopo:
 * cenario: deverá permitir que o usuário 
 * professor escolha o questionário que os alunos
 * usarão, faça a análise das respostas dos alunos 
 *  e manter (CRUD) os questionários de propriedade
 *  deste professor. 
 * 
 * */



@Stateless
public class ProfessorBusiness {

	@EJB
	QuestionarioDao questionarioDao;
	@EJB
	ProfessorDao professorDao ;
	@EJB
	RespostaDao respostaDao ;
	@EJB
	AlunoDao alunoDao ;
	@EJB
	PerguntaDao perguntaDao ;
	@EJB
	FeedbackDao feedbackDao;
	
	
	/*autor: jeisom muniz
	 * background:
	 * escopo:
	 * cenario:criar  usuário professor
	 *  
	 */
	
	 public ProfessorModel criarContaProfessor(ProfessorModel id) {
		 return professorDao.criarRegistroProfessor(id);
	}
	
	 
	 /*autor: jeisom muniz
		 * background:
		 * escopo:
		 * cenario: permitir que o usuário professor
		 *  escolha o questionário que os alunos usarão,
		 */
		
		 public QuestionarioModel criarQuestionario(Integer id) {
			
			 
			 QuestionarioModel q = new QuestionarioModel();
			 q.setProfessorModel(professorDao.find(id));
			 
			 return questionarioDao.criarQuestionario(q);
		}
		 
		 
	 /*autor: jeisom muniz
	 * background:
	 * escopo:
	 * cenario: permitir que o usuario professor
	 *  escolha o questionario que os alunos usarão,
	 */
	
	 public QuestionarioModel escolherQuestionario(Integer id) {
		
	 
		 return questionarioDao.selecionarQuestionario(id);
	}
	
	
	/*autor: jeisom muniz
	 * background:
	 * escopo:
	 * cenario: permitir que o usuario professor
	 *  associe as perguntas ao questionario
	 */
	
	 public List<PerguntaModel> criarListaDePerguntas(List<PerguntaModel> lista , Integer questionarioId ) {
		 
		 List<PerguntaModel> listaDePerguntas = new ArrayList<>();
		 QuestionarioModel temp = questionarioDao.selecionarQuestionario(questionarioId) ;
		 for (PerguntaModel p : lista) {
			 
			 p.setQuestionarioModel(temp);
			 listaDePerguntas.add(perguntaDao.criarPergunta(p));
		 }
		 
		 return listaDePerguntas ;
	}
	
	 /*autor: jeisom muniz
		 * background:
		 * escopo:
		 * cenario: permitir que o usuario professor
		 *  associe as perguntas ao questionario
		 */
	
     public PerguntaModel criarPergunta(PerguntaModel p , Integer questionarioId ) {
	
	     QuestionarioModel temp = questionarioDao.selecionarQuestionario(questionarioId) ;
		 p.setQuestionarioModel(temp);
		
		 
		 return perguntaDao.criarPergunta(p) ;
	}
	 
	 /*autor: jeisom muniz
		 * background:
		 * escopo:
		 * cenario: questionarios de propriedade
          *  deste professor
		 */
		
		 public List<QuestionarioModel> analisarRespostas(Integer id) {
			 return questionarioDao.buscarQuestionarioPorIdProfessor(id);
		}
		
		 
		 /*autor: jeisom muniz
			 * background:
			 * escopo:
			 * cenario: analise das respostas dos alunos 
			 * a partir do id do Questionario
			 */
			
			 public List<RespostaModel> meusQuestionarios( Integer idQuestionario) {
				
				 return respostaDao.buscarRespostaPorIdQuestionario(idQuestionario) ;
			}
			 
			 
			 /*autor: jeisom muniz
				 * background:
				 * escopo:
				 * cenario: realizar feedback das respostas 
				 */
				
			 public FeedbackModel realizarFeedBack(Integer repostaId, Integer professorId ,String  feedbackDescricao) {
					
				 FeedbackModel feedbackModel = new FeedbackModel();
				 RespostaModel resposta = respostaDao.buscarResposta(repostaId);
				 ProfessorModel professor  = professorDao.find(professorId);
			
				 feedbackModel.setRespostaModel(resposta);
				 feedbackModel.setProfessorModel(professor);
				 feedbackModel.setFeedbackDescricao(feedbackDescricao);
				 
				 return feedbackDao.criarFeedback(feedbackModel) ;
			 }
			
	
			 
			 /*autor: jeisom muniz
				 * background:
				 * escopo:
				 * cenario: permitir que o usuário professor 
				 * escolha o questionário que os alunos usarão
				 */
				
				 public List<PerguntaModel> direcionarQuestionarios( Integer idQuestionario ) {
					
					
					
					 
					 return perguntaDao.buscarPerguntaPorQuestionarioId(idQuestionario);
				}
				 
				 
				 
				
}
