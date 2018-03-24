

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.playfinder.model.Amicizia;
import it.playfinder1.GestioneAccount;

/**
 * Servlet implementation class AccettaAmiciziaServlet
 */
@WebServlet("/accettaAmicizia")
public class AccettaAmiciziaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GestioneAccount ga = new GestioneAccount();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccettaAmiciziaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accettata = request.getParameter("accettata");
		String id = request.getParameter("amicizia");
		int idAmicizia = Integer.parseInt(id);
		Amicizia amicizia = ga.amiciziaPerId(idAmicizia);
		if(accettata.equals("si")) {
			ga.accettaAmicizia(amicizia);
		}else {
			ga.rimuoviAmicizia(amicizia);
		}
	}

}
