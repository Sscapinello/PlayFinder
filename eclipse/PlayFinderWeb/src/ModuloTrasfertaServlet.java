

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.playfinder.model.Evento;
import it.playfinder.model.Modulo;
import it.playfinder.model.RuoloPartita;
import it.playfinder.model.Squadra;
import it.playfinder1.GestioneEvento;
import it.playfinder1.GestioneModulo;

/**
 * Servlet implementation class ModuloTrasfertaServlet
 */
@WebServlet("/moduloTrasferta")
public class ModuloTrasfertaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GestioneModulo gm = new GestioneModulo();
    GestioneEvento ge = new GestioneEvento();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModuloTrasfertaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Modulo m = null;
		String nomeModulo = request.getParameter("nomeModulo");
		String nomeSquadra = request.getParameter("nomeSquadra");
		String id = request.getParameter("idEvento");
		int idEvento = Integer.parseInt(id);
		Evento e = ge.eventoPerId(idEvento);
		m = gm.selezionaModulo(nomeModulo);
		Squadra casa = e.getSquadraTrasferta();
		casa.setModulo(m);
		ge.settaRuoloPartita(m, casa, nomeSquadra);
	}

}
