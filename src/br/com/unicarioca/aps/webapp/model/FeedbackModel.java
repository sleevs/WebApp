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
@Table(name = "feedback")
public class FeedbackModel {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "feedback_id")
	    private Integer feedbackId;	
	    @Size(max = 45)
	    @Column(name = "feedback_descricao")
	    private String feedbackDescricao;
	    @Size(max = 45)
	    @Column(name = "feedback_nivel")
	    private String feedbackNivel;
	    @JoinColumn(name = "professor_professor_id", referencedColumnName = "professor_id")
	    @ManyToOne(optional = false)
	    private ProfessorModel professorModel;
	    @JoinColumn(name = "resposta_resposta_id", referencedColumnName = "resposta_id")
	    @ManyToOne(optional = false)
	    private RespostaModel respostaModel;
	
	public FeedbackModel() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackDescricao() {
		return feedbackDescricao;
	}

	public void setFeedbackDescricao(String feedbackDescricao) {
		this.feedbackDescricao = feedbackDescricao;
	}

	public String getFeedbackNivel() {
		return feedbackNivel;
	}

	public void setFeedbackNivel(String feedbackNivel) {
		this.feedbackNivel = feedbackNivel;
	}

	public ProfessorModel getProfessorModel() {
		return professorModel;
	}

	public void setProfessorModel(ProfessorModel professorModel) {
		this.professorModel = professorModel;
	}

	public RespostaModel getRespostaModel() {
		return respostaModel;
	}

	public void setRespostaModel(RespostaModel respostaModel) {
		this.respostaModel = respostaModel;
	}
	
	
	

}
