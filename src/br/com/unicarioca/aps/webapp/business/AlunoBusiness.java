package br.com.unicarioca.aps.webapp.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.unicarioca.aps.webapp.dao.AlunoDao;
import br.com.unicarioca.aps.webapp.dao.FeedbackDao;
import br.com.unicarioca.aps.webapp.dao.PerguntaDao;
import br.com.unicarioca.aps.webapp.dao.RespostaDao;
import br.com.unicarioca.aps.webapp.model.AlunoModel;
import br.com.unicarioca.aps.webapp.model.FeedbackModel;
import br.com.unicarioca.aps.webapp.model.PerguntaModel;
import br.com.unicarioca.aps.webapp.model.QuestionarioModel;
import br.com.unicarioca.aps.webapp.model.RespostaModel;



/*
 * 
 * 
 * 
 * autor:jeison muniz
 * background: atividade superviosanada
 * escopo:
 * cenario:  Para o usu�rio aluno, ap�s
 * receber o identificador do question�rio
   permitir� responder as quest�es do question�rio 
    e receber o feedback de cada resposta.
 * 
 * */


@Stateless
public class AlunoBusiness {

	
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
	 * cenario: Para o usu�rio aluno, ap�s
     * receber o identificador do question�rio
     * permitir� responder as quest�es do question�rio 
	 */
	
	 public RespostaModel responderPergunta( String descricao , Integer a , Integer id) {
		
		 PerguntaModel pergunta = perguntaDao.buscarPergunta(id);
		 AlunoModel aluno = alunoDao.buscarAluno(a);
		 return respostaDao.responder(descricao, aluno, pergunta); 
	}
	 
	 
	     /*autor: jeisom muniz
		 * background:
		 * escopo:
		 * cenario: Para o usu�rio aluno, ap�s
	     * receber o identificador do question�rio
	     * permitir� responder as quest�es do question�rio 
		 */
		
		 public List<FeedbackModel> meusFeedBack( Integer a ) {
			
			 return feedbackDao.selecionarFeedbackPorIdAluno(a);
		}
		 
		 
		 /*autor: jeisom muniz
			 * background:
			 * escopo:
			 * cenario: permitir que o usu�rio professor 
			 * escolha o question�rio que os alunos usar�o
			 */
		 public List<PerguntaModel> meuQuestionario(Integer idAluno) {
		
			 
			 return null; 
		}
		 
		 
		 
		
}
