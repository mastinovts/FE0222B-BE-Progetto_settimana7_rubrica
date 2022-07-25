package presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
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

public class RubricaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	RubricaEjbLocal ejb;
	public RubricaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		List<Contatto> contatti = ejb.visualizzaContatti();
		out.println("<h1>CONTATTI</h1>");
		for (Contatto c : contatti) {
			out.println("<h2>" + c.getNome() + " " + c.getCognome() + "</h2>" + "<p><b>" + " --- email: " + "</b>"
					+ c.getEmail() + "</p>");
			for(NumTelefono n : c.getNumero()) {
				out.println("<p><b>" + " --- cell: " + "</b>" + n.getNumero() + "</p>");
			}

		}
		ejb.visualizzaContatti();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		Contatto cont = new Contatto();
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		cont.setNome(nome);
		cont.setCognome(cognome);
		cont.setEmail(email);

		NumTelefono numero1 = new NumTelefono();
		NumTelefono numero2 = new NumTelefono();

		ArrayList<NumTelefono> numeri = new ArrayList<NumTelefono>();
		String numero2_param = request.getParameter("numero2");
			
		if(numero2_param.equals("")) {
			numero1.setNumero(request.getParameter("numero1"));	
			numero1.setContatto(cont);			
			numeri.add(numero1);		
			cont.setNumero(numeri);
			out.println(cont.getNome() + " " + cont.getCognome() + " --- " + cont.getEmail() + " --- cell: "
					+ numero1.getNumero());
						
		}else {
			numero1.setNumero(request.getParameter("numero1"));
			numero2.setNumero(request.getParameter("numero2"));
			numero1.setContatto(cont);
			numero2.setContatto(cont);
			numeri.add(numero1);
			numeri.add(numero2);
			cont.setNumero(numeri);
			
			out.println(cont.getNome() + " " + cont.getCognome() + " --- " + cont.getEmail() + " --- cell 1: " + numero1.getNumero() 
			+ " --- cell 2: " + numero2.getNumero());
		}
		
		ejb.inserisciContatto(cont);
	}

}
