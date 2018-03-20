import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.playfinder.model.Evento;
import it.playfinder.model.RuoloPartita;
import it.playfinder.model.Squadra;
import it.playfinder1.GestioneEvento;

/**
 * Servlet implementation class PartecipaEventoServlet
 */
@WebServlet("/gioca")
public class GiocaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       GestioneEvento ge = new GestioneEvento();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiocaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idev");
        int idEvento = Integer.parseInt(id);
		Evento e = ge.eventoPerId(idEvento);
		ObjectMapper m = new ObjectMapper();
		response.setContentType("application/json");
		response.getWriter().append(m.writeValueAsString(e));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idRp = request.getParameter("rp");
		String id = request.getParameter("hdIdEvento");
		String ids =  request.getParameter("idCasa");
		String username = request.getParameter("username");
    	int idSquadra = Integer.parseInt(ids);
		int idR = Integer.parseInt(idRp);
        int idEvento = Integer.parseInt(id);
		Evento e = ge.eventoPerId(idEvento);
		RuoloPartita rp = ge.ruoloPartitaPerId(idR);
		Squadra s = ge.squadraPerId(idSquadra);
		ge.partecipaEvento(e, username, s, rp);
	}

}
