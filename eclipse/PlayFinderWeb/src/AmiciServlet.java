

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
 * Servlet implementation class AmiciServlet
 */
@WebServlet("/amici")
public class AmiciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    GestioneAccount ga = new GestioneAccount();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AmiciServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		User utente = ga.userPerUsername(username);
		List<Amicizia> amici = utente.getAmicoDi();
		ObjectMapper m = new ObjectMapper();
		response.setContentType("application/json");
		response.getWriter().append(m.writeValueAsString(amici));	}

}
