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
@Table(name = "resposta")
public class RespostaModel {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "resposta_id")
	    private Integer respostaId;
	    @Size(max = 200)
	    @Column(name = "resposta_descricao")
	    private String respostaDescricao;
	    @JoinColumn(name = "aluno_aluno_id", referencedColumnName = "aluno_id")
	    @ManyToOne(optional = false)
	    private AlunoModel alunoModel;
	    @JoinColumn(name = "pergunta_pergunta_id", referencedColumnName = "pergunta_id")
	    @ManyToOne(optional = false)
	    private PerguntaModel perguntaModel;
	    
	    public RespostaModel() {
	    	
	    }
	    
	    
	    
		public Integer getRespostaId() {
			return respostaId;
		}


		public void setRespostaId(Integer respostaId) {
			this.respostaId = respostaId;
		}

		public String getRespostaDescricao() {
			return respostaDescricao;
		}

		public void setRespostaDescricao(String respostaDescricao) {
			this.respostaDescricao = respostaDescricao;
		}

		public AlunoModel getAlunoModel() {
			return alunoModel;
		}


		public void setAlunoModel(AlunoModel alunoModel) {
			this.alunoModel = alunoModel;
		}


		public PerguntaModel getPerguntaModel() {
			return perguntaModel;
		}


		public void setPerguntaModel(PerguntaModel perguntaModel) {
			this.perguntaModel = perguntaModel;
		}


		@Override
		public String toString() {
			return "RespostaModel [respostaId=" + respostaId + ", respostaDescricao=" + respostaDescricao
					+ ", alunoModel=" + alunoModel + ", perguntaModel=" + perguntaModel + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}
	    

}
