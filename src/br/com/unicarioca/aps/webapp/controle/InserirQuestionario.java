package br.com.unicarioca.aps.webapp.controle;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unicarioca.aps.webapp.business.ProfessorBusiness;
import br.com.unicarioca.aps.webapp.model.QuestionarioModel;

/**
 * Servlet implementation class InserirQuestionario
 */
@WebServlet("/InserirQuestionario")
public class InserirQuestionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@EJB
	private ProfessorBusiness  professorBusiness;
	
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserirQuestionario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String ID = request.getParameter("id_professor");
		List<QuestionarioModel> lista = professorBusiness.analisarRespostas(Integer.valueOf(ID));


		 System.out.println(" PROCESSAMENTO "+lista);
		
		request.getSession().setAttribute("MEUS_QUESTIONARIOS", lista.toString() );
		response.sendRedirect("professor.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String ID = request.getParameter("id_professor");
	
		QuestionarioModel q = professorBusiness.criarQuestionario(Integer.valueOf(ID));
		request.getSession().setAttribute("QUESTIONARIO", q );
			response.sendRedirect("professor.jsp");
	}

}
