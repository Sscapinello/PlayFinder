

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.playfinder1.GestioneEvento;

/**
 * Servlet implementation class AggiornaRisultatoServlet
 */
@WebServlet("/aggiornaRisultato")
public class AggiornaRisultatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       GestioneEvento ge = new GestioneEvento();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiornaRisultatoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String casa = request.getParameter("rCasa");
		String trasferta = request.getParameter("rTrasferta");
		String id = request.getParameter("idEvento");
		int idEvento = Integer.parseInt(id);
		int rCasa = Integer.parseInt(casa);
		int rTrasferta = Integer.parseInt(trasferta);
		ge.settaRisultato(idEvento, rCasa, rTrasferta);
		
	}

}
