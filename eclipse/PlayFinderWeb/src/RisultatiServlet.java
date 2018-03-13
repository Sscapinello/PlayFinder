

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.playfinder.model.Evento;
import it.playfinder.model.User;
import it.playfinder.model.UserInEvento;
import it.playfinder1.GestioneAccount;
import it.playfinder1.GestioneEvento;

/**
 * Servlet implementation class RisultatiServlet
 */
@WebServlet("/risultati")
public class RisultatiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	GestioneEvento ge = new GestioneEvento();
	GestioneAccount ga = new GestioneAccount();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RisultatiServlet() {
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
		String username = request.getParameter("name");
		User u = ga.userPerUsername(username);
		List<Evento> eventi = ge.eventiDaAggiornare(u);
		ObjectMapper m = new ObjectMapper();
		response.setContentType("application/json");
		response.getWriter().append(m.writeValueAsString(eventi));
		
	}

}
