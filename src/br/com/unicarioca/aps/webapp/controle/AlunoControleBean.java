package br.com.unicarioca.aps.webapp.controle;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;

import br.com.unicarioca.aps.webapp.business.AlunoBusiness;
import br.com.unicarioca.aps.webapp.model.FeedbackModel;
import br.com.unicarioca.aps.webapp.model.RespostaModel;

public class AlunoControleBean {

	@EJB
	private AlunoBusiness alunoBusiness ;

	public AlunoBusiness getAlunoBusiness() {
		return alunoBusiness;
	}

	public void setAlunoBusiness(AlunoBusiness alunoBusiness) {
		this.alunoBusiness = alunoBusiness;
	}

	

	
	
	
	
}
