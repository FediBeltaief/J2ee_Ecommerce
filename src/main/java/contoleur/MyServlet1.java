package contoleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Dao.gestionUtilisateur;
import Dao.gestionProduit;
import modele.produit;
import modele.utilisateur;
@WebServlet("*.dao")
public class MyServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id"); 
		if (id != null && !id.equals("user")) 
		{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		String action = servletPath.substring(1, servletPath.length() - 4);

		gestionProduit gprod = new gestionProduit();
		gestionUtilisateur gu = new gestionUtilisateur();

		switch (action) {
			case "add":
				String id = request.getParameter("id");
				String nom = request.getParameter("nom");
				float prix = Float.parseFloat(request.getParameter("prix"));
				String four = request.getParameter("four");
				String desc= request.getParameter("description");
				String img= request.getParameter("img");

				produit prod = new produit(id, nom, prix, four,desc,img);
				gprod.save(prod);
				request.setAttribute("resultat", "Product added successfully.");
				break;
			case "update":
				String idUpdate = request.getParameter("id");
				String nomUpdate = request.getParameter("nom");
				float prixUpdate = Float.parseFloat(request.getParameter("prix"));
				String fourUpdate = request.getParameter("four");
				String descUpdate= request.getParameter("description");
				String imgUpdate= request.getParameter("img");
				
				produit prodUpdate = new produit(idUpdate, nomUpdate, prixUpdate, fourUpdate,descUpdate,imgUpdate);
				gprod.updateProduit(prodUpdate);
				request.setAttribute("resultat", "Product updated successfully.");
				break;
			case "delete":
				String idDelete = request.getParameter("id");
				gprod.deleteProduit(idDelete);
				request.setAttribute("resultat", "Product deleted successfully.");
				break;
			case "updateuser":
				String idUser = request.getParameter("login");
				String passUser = request.getParameter("password");
				utilisateur uti=new utilisateur(idUser,passUser);
				gu.update(uti);
				request.setAttribute("resultat", "User updated successfully.");
				break;
			case "deleteuser":
				String idUserDelete = request.getParameter("login");
				gu.delete(idUserDelete);
				request.setAttribute("resultat", "User deleted successfully.");
				break;
			default:
				break;
		}

		request.getRequestDispatcher("produit.jsp").forward(request, response);
	}
}
