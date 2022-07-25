package presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import business.RubricaEjbLocal;
import data.Contatto;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	RubricaEjbLocal ejb;
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Long id = Long.parseLong(request.getParameter("id"));
		Contatto cont = new Contatto();
		cont.setId(id);
		
		try {
			ejb.deleteContatto(cont);
			out.println("CONTATTO ELIMINATO");
		} catch (Exception e) {
			out.println("Nessun contatto registrato con l'ID inserito");
			}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
