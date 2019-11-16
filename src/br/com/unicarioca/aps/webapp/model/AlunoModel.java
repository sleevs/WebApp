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
@Table(name = "aluno")
public class AlunoModel {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "aluno_id")
	    private Integer alunoId;
	    @Size(max = 45)
	    @Column(name = "aluno_nome")
	    private String alunoNome;
	    
	    
	    public AlunoModel() {
	    	
	    }


		public Integer getAlunoId() {
			return alunoId;
		}


		public void setAlunoId(Integer alunoId) {
			this.alunoId = alunoId;
		}


		public String getPerguntaNome() {
			return alunoNome;
		}


		public void setPerguntaNome(String alunoNome) {
			this.alunoNome = alunoNome;
		}


		@Override
		public String toString() {
			return "AlunoModel [alunoId=" + alunoId + ", alunoNome=" + alunoNome + ", getAlunoId()="
					+ getAlunoId() + ", getPerguntaNome()=" + getPerguntaNome() + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}

	    
}
