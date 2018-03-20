

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.playfinder1.GestioneAccount;

/**
 * Servlet implementation class VittorieServlet
 */
@WebServlet("/vittorie")
public class VittorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	GestioneAccount ga = new GestioneAccount();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VittorieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		int percentuale = ga.percentualeVittoria(username);
		ObjectMapper m = new ObjectMapper();
		response.setContentType("application/json");
		response.getWriter().append(m.writeValueAsString(percentuale));
	}

}
