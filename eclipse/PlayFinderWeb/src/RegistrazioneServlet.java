

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.playfinder1.EsitoOperazione;
import it.playfinder1.GestioneAccount;

/**
 * Servlet implementation class RegistrazioneServlet
 */
@WebServlet("/registrazione")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestioneAccount ga = new GestioneAccount();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrazioneServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPostt(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("first_name");
		String surname = request.getParameter("last_name");
		String anni = request.getParameter("eta");
		String region = request.getParameter("regione");
		String city = request.getParameter("citta");
		String username = request.getParameter("user_name");
		String password = request.getParameter("user_password");
		String cpassword = request.getParameter("confirm_password");
		String email = request.getParameter("email");
		String phone = request.getParameter("contact_no");
		int eta = Integer.parseInt(anni);
		EsitoOperazione eo = new EsitoOperazione();
		if (cpassword.equals(password)) {
		eo = ga.registrazione(email, username, password, name, surname,
				city, eta, region, phone);
		response.sendRedirect("http://www.google.com");  
		} else {
			eo.setSuccess(false);
		}
	}

}

	


