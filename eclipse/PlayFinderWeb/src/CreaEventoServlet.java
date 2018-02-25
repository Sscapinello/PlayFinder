

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.playfinder.model.Campo;
import it.playfinder.model.Evento;
import it.playfinder.model.Sport;
import it.playfinder.model.User;
import it.playfinder1.EsitoOperazione;
import it.playfinder1.GestioneAccount;
import it.playfinder1.GestioneCampo;
import it.playfinder1.GestioneEvento;

/**
 * Servlet implementation class CreaEventoServlet
 */
@WebServlet("/creaEvento")
public class CreaEventoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	GestioneEvento ge = new GestioneEvento();
	private ObjectMapper mapper = new ObjectMapper();
	GestioneAccount ga = new GestioneAccount();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaEventoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> sport = ge.elencoSport();
		ObjectMapper m = new ObjectMapper();
		response.setContentType("application/json");
		response.getWriter().append(m.writeValueAsString(sport));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("name");
		String password = request.getParameter("password");
		String startDateString = request.getParameter("data");
		String durata = request.getParameter("durata");
		int tempo = Integer.parseInt(durata);
		boolean privato = (request.getParameter("privato") != null);
		String citta = request.getParameter("citta");
		String regione = request.getParameter("regione");
		String via = request.getParameter("indirizzo");
		String nCivico = request.getParameter("civico"); 
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"); 
		String username = request.getParameter("username");
		String nomeSport = request.getParameter("nomeSport");
		User u = ga.userPerUsername(username);
		Sport s = ge.sportPerNome(nomeSport);
		Date startDate = new Date();
		try {
		    startDate = df.parse(startDateString);
		    String newDateString = df.format(startDate);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		GestioneCampo gc = new GestioneCampo();
		Campo c = gc.creaCampo(citta, regione, via, nCivico);
		if(privato == true) {
			Evento e = ge.creazioneEvento(nome, startDate, c, s, tempo, u, password);
		} else {
			Evento e = ge.creazioneEvento(nome, startDate, c, s, tempo, u);
		}
		response.sendRedirect("home.html");  

	}

}
