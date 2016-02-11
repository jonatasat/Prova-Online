package br.unisul.servlet;
import br.unisul.DAO.AlunoDAO;
import br.unisul.javabean.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlunoManager
 */
@WebServlet("/AlunoManager")
public class AlunoManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlunoManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Aluno> result2 = AlunoDAO.consultarNome("Jonatas");
		for(Aluno aluno: (List<Aluno>) result2){
			AlunoDAO.deletar(aluno);
		}
		
		Aluno a = new Aluno();
		a.setNome("Jonatas");
		
		AlunoDAO.salvar(a);
		
		List<Aluno> result = AlunoDAO.listar();
		for(Aluno list: (List<Aluno>) result){
			System.out.println("Matricula: "+ list.getMatricula()+ " Nome: "+ list.getNome());
		}
	}

}
