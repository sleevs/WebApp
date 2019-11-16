package br.com.unicarioca.aps.webapp.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "professor")
public class ProfessorModel {

	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "professor_id")
	    private Integer professorId;
	    @Size(max = 45)
	    @Column(name = "professor_disciplina")
	    private String professorDisciplina;
	    @Size(max = 45)
	    @Column(name = "professor_nome")
	    private String professorNome;
	  
	    
	    public ProfessorModel() {
	    	
	    }


		public Integer getProfessorId() {
			return professorId;
		}


		public void setProfessorId(Integer professorId) {
			this.professorId = professorId;
		}


		public String getProfessorDisciplina() {
			return professorDisciplina;
		}


		public void setProfessorDisciplina(String professorDisciplina) {
			this.professorDisciplina = professorDisciplina;
		}


		public String getProfessorNome() {
			return professorNome;
		}


		public void setProfessorNome(String professorNome) {
			this.professorNome = professorNome;
		}


		@Override
		public String toString() {
			return "ProfessorModel [professorId=" + professorId + ", professorDisciplina=" + professorDisciplina
					+ ", professorNome=" + professorNome + ", getProfessorId()=" + getProfessorId()
					+ ", getProfessorDisciplina()=" + getProfessorDisciplina() + ", getProfessorNome()="
					+ getProfessorNome() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
					+ super.toString() + "]";
		}



}
