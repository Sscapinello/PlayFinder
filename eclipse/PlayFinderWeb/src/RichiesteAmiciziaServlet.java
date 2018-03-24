

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.playfinder.model.Amicizia;
import it.playfinder.model.User;
import it.playfinder1.GestioneAccount;

/**
 * Servlet implementation class RichiesteAmiciziaServlet
 */
@WebServlet("/richiesteAmicizia")
public class RichiesteAmiciziaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GestioneAccount ga = new GestioneAccount();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RichiesteAmiciziaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		User utente = ga.userPerUsername(username);
		List<Amicizia> richieste = new ArrayList();
		List<Amicizia> amici = utente.getAmici();
		for(Amicizia richiesta : amici) {
			if(!richiesta.isAccettata()) {
				richieste.add(richiesta);
			}
		}
		ObjectMapper m = new ObjectMapper();
		response.setContentType("application/json");
		response.getWriter().append(m.writeValueAsString(richieste));
	}

}
