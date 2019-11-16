package br.com.unicarioca.aps.webapp.model;



import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "pergunta")
public class PerguntaModel {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "pergunta_id")
	    private Integer perguntaId;
	    @Size(max = 200)
	    @Column(name = "pergunta_descricao")
	    private String perguntaDescricao;
	    @JoinColumn(name = "questionario_questionario_id", referencedColumnName = "questionario_id")
	    @ManyToOne(optional = false)
	    private QuestionarioModel questionarioModel;
	    
	    
	    public PerguntaModel() {
	    	
	    }
	    
	    
		public Integer getPerguntaId() {
			return perguntaId;
		}
		public void setPerguntaId(Integer anuncioId) {
			this.perguntaId = anuncioId;
		}
		public String getPerguntaDescricao() {
			return perguntaDescricao;
		}
		public void setPerguntaDescricao(String perguntaDescricao) {
			this.perguntaDescricao = perguntaDescricao;
		}
		public QuestionarioModel getQuestionarioModel() {
			return questionarioModel;
		}
		public void setQuestionarioModel(QuestionarioModel questionarioModel) {
			this.questionarioModel = questionarioModel;
		}


		@Override
		public String toString() {
			return "PerguntaModel [anuncioId=" + perguntaId + ", perguntaDescricao=" + perguntaDescricao
					+ ", questionarioModel=" + questionarioModel + ", getAnuncioId()=" + getPerguntaId()
					+ ", getPerguntaDescricao()=" + getPerguntaDescricao() + ", getQuestionarioModel()="
					+ getQuestionarioModel() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
					+ ", toString()=" + super.toString() + "]";
		}
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
