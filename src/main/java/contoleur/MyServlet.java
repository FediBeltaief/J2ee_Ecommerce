package contoleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.utilisateur;
import Dao.gestionUtilisateur;

@WebServlet("/")
public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * HttpSession session = request.getSession(); session.invalidate(); <% String
		 * id = (String) session.getAttribute("id"); if (id == null ||
		 * !id.equals("admin")) { response.sendRedirect("login.jsp"); } %>
		 */ request.getRequestDispatcher("login.jsp").forward(request, response);
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String action = request.getParameter("action");
		utilisateur user = new utilisateur();
		gestionUtilisateur gu = new gestionUtilisateur();
		if (action.equals("Login")) {
			String l = request.getParameter("Login");
			String p = request.getParameter("Password");
			if (l.equals("admin") && p.equals("admin")) {
				session.setAttribute("id", "admin");
				request.getRequestDispatcher("menu.jsp").forward(request, response);
			}
			user.setLogin(l);
			user.setPassword(p);

			String resultat = "Welcome, " + l;
			if (gu.exist(user)) {
				session.setAttribute("id", "user");
				request.setAttribute("resultat", resultat);
				request.getRequestDispatcher("productList.jsp").forward(request, response);
			} else {
				session.setAttribute("id", "invalid");
				request.getRequestDispatcher("login.jsp").forward(request, response);

			}
		} else if (action.equals("Register")) {
			String l = request.getParameter("Login");
			String p = request.getParameter("Password");

			user.setLogin(l);
			user.setPassword(p);
			gu.add(user);

			String resultat = "Registration successful!";
			request.setAttribute("resultat", resultat);
			session.setAttribute("id", "user");
			request.getRequestDispatcher("productList.jsp").forward(request, response);
		}
	}
}
