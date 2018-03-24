

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.playfinder.model.Evento;
import it.playfinder1.GestioneEvento;

/**
 * Servlet implementation class GetEventoServlet
 */
@WebServlet("/getEvento")
public class GetEventoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    GestioneEvento ge = new GestioneEvento();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEventoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idEvento = request.getParameter("idEvento");
		int id = Integer.parseInt(idEvento);
		Evento e = ge.eventoPerId(id);
		ObjectMapper m = new ObjectMapper();
		response.setContentType("application/json");
		response.getWriter().append(m.writeValueAsString(e));
	}

}
