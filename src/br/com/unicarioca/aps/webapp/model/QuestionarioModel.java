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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "questionario")
public class QuestionarioModel {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "questionario_id")
	    private Integer questionarioId;	
	    @JoinColumn(name = "professor_professor_id", referencedColumnName = "professor_id")
	    @ManyToOne(optional = false)
	    private ProfessorModel professorModel;
	    
	    public QuestionarioModel() {
	    	
	    }
	    
	    
		public Integer getQuestionarioId() {
			return questionarioId;
		}
		public void setQuestionarioId(Integer questionarioId) {
			this.questionarioId = questionarioId;
		}
		public ProfessorModel getProfessorModel() {
			return professorModel;
		}
		public void setProfessorModel(ProfessorModel professorModel) {
			this.professorModel = professorModel;
		}


		@Override
		public String toString() {
			return "QuestionarioModel [questionarioId=" + questionarioId + ", professorModel=" + professorModel
					+ ", getQuestionarioId()=" + getQuestionarioId() + ", getProfessorModel()=" + getProfessorModel()
					+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
					+ "]";
		}
	    
	    
	    
	    

}
