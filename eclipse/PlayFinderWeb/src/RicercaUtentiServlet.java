

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.playfinder.model.User;
import it.playfinder1.GestioneAccount;

/**
 * Servlet implementation class RicercaUtentiServlet
 */
@WebServlet("/RicercaUtenti")
public class RicercaUtentiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    GestioneAccount ga = new GestioneAccount();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RicercaUtentiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> utenti = new ArrayList();
		utenti = ga.listaUtenti();
		ObjectMapper m = new ObjectMapper();
		response.setContentType("application/json");
		response.getWriter().append(m.writeValueAsString(utenti));
	}

}
