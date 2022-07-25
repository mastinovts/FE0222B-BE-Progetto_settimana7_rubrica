package presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import business.RubricaEjbLocal;
import data.Contatto;
import data.NumTelefono;


public class CognomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	RubricaEjbLocal ejb;
    public CognomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String cognome = request.getParameter("cognome");

		List<Contatto> contatti = ejb.getContattoBySurname(cognome);
	
		out.println("<h1>CONTATTI</h1>");
		for (Contatto c : contatti) {
			out.println("<h2>" + c.getNome() + " " + c.getCognome() + "</h2>" + "<p><b>" + " --- email: " + "</b>"
					+ c.getEmail() + "</p>");
			for(NumTelefono n : c.getNumero()) {
				out.println("<p><b>" + " --- cell: " + "</b>" + n.getNumero() + "</p>");
			}

		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
