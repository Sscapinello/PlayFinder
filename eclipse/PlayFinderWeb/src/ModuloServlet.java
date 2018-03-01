

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
import it.playfinder.model.Modulo;
import it.playfinder.model.Squadra;
import it.playfinder.model.User;
import it.playfinder.model.UserInEvento;
import it.playfinder1.GestioneAccount;
import it.playfinder1.GestioneEvento;

/**
 * Servlet implementation class ModuloServlet
 */
@WebServlet("/moduli")
public class ModuloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       GestioneAccount ga = new GestioneAccount();
       GestioneEvento ge = new GestioneEvento();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModuloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Evento e = null;
		String username = request.getParameter("username");
		String id = request.getParameter("hdIdEvento");
		int idEvento = Integer.parseInt(id);
		UserInEvento u = null;
		u = u.partecipa(username, idEvento);
		e = ge.eventoPerId(idEvento);
		List<Modulo> moduli =ge.selezionaModulo(e);
		List<String> nomeModuli = new ArrayList();
		for(Modulo m : moduli) {
			nomeModuli.add(m.getNome());
		}
		ObjectMapper m = new ObjectMapper();
		response.setContentType("application/json");
		response.getWriter().append(m.writeValueAsString(nomeModuli));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
