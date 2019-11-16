package br.com.unicarioca.aps.webapp.controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unicarioca.aps.webapp.dao.ProfessorDao;

/**
 * Servlet implementation class Professor2Controle
 */
@WebServlet("/ProfessorControle")
public class ProfessorControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	
	
	  @EJB ProfessorDao professorDao ;
	 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorControle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 PrintWriter out = response.getWriter();
		 out.println(" get " + professorDao.findAll() ); 
		/*
		 * System.out.println(professorDao.findAll());
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		 PrintWriter out = response.getWriter();
		 out.println(" post " + professorDao.findAll() ); 
	}

}
