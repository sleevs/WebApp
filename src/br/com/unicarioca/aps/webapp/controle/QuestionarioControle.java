package br.com.unicarioca.aps.webapp.controle;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unicarioca.aps.webapp.business.AlunoBusiness;
import br.com.unicarioca.aps.webapp.model.RespostaModel;

/**
 * Servlet implementation class QuestionarioControle
 */
@WebServlet("/QuestionarioControle")
public class QuestionarioControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@EJB
	AlunoBusiness alunoBusiness ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionarioControle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String resposta = request.getParameter("resposta_id");
		RespostaModel r = alunoBusiness.responderPergunta(resposta, 1, 1);
		request.getSession().setAttribute("RESPOSTA", r.toString() );
		response.sendRedirect("aluno.jsp");
	}
	

}
