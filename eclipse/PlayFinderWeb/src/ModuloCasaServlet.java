

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.playfinder.model.Evento;
import it.playfinder.model.Modulo;
import it.playfinder.model.RuoloPartita;
import it.playfinder.model.Squadra;
import it.playfinder1.GestioneEvento;
import it.playfinder1.GestioneModulo;

/**
 * Servlet implementation class ModuloCasaServlet
 */
@WebServlet("/moduloCasa")
public class ModuloCasaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GestioneModulo gm = new GestioneModulo();
    GestioneEvento ge = new GestioneEvento();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModuloCasaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeModulo = request.getParameter("nomeModulo");
		String nomeSquadra = request.getParameter("nomeSquadra");
		String id = request.getParameter("idEvento");
		int idEvento = Integer.parseInt(id);
		Evento e = ge.eventoPerId(idEvento);
		Modulo m = gm.selezionaModulo(nomeModulo);
		Squadra casa = e.getSquadraCasa();
		casa.setModulo(m);
		ge.settaRuoloPartita(m, casa, nomeSquadra);
		response.sendRedirect("evento.html?");
	}

}
