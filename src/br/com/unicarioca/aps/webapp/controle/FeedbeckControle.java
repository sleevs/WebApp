package br.com.unicarioca.aps.webapp.controle;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unicarioca.aps.webapp.business.ProfessorBusiness;
import br.com.unicarioca.aps.webapp.model.FeedbackModel;

/**
 * Servlet implementation class FeedbeckControle
 */
@WebServlet("/FeedbeckControle")
public class FeedbeckControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private ProfessorBusiness  professorBusiness;
	

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbeckControle() {
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
		
		
		String idProfessor = request.getParameter("id_professor");
		String idResposta = request.getParameter("id_resposta");
		String descricao = request.getParameter("fb_descricao");
		
		
	FeedbackModel fb  =professorBusiness.realizarFeedBack(Integer.valueOf(idResposta), Integer.valueOf(idProfessor), descricao);
	request.getSession().setAttribute("FEEDBACK", fb );
	response.sendRedirect("professor.jsp");
	
	}

}
