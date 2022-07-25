package presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import business.RubricaEjbLocal;
import data.Contatto;
import data.NumTelefono;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	RubricaEjbLocal ejb;
	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Long id = Long.parseLong(request.getParameter("idcont"));
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		
		Contatto cont = ejb.idcontatto(id);
		cont.setNome(nome);
		cont.setCognome(cognome);
		cont.setEmail(email);
		
        					
        if (request.getParameter("numero2").equals(""))  {
			
			cont.getNumero().get(0).setNumero(request.getParameter("numero1"));
			
			out.println("UPDATE CONTATTO EFFETTUATO");
			
		} else {
			cont.getNumero().get(0).setNumero(request.getParameter("numero1"));
			cont.getNumero().get(1).setNumero(request.getParameter("numero2"));
			out.println("UPDATE CONTATTO EFFETTUATO");
		}
			ejb.updateContatto(cont);

	}
}
