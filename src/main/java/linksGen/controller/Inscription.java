package linksGen.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import linksGen.beans.User;
import linksGen.dao.UserDao;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		
		dispatcher = request.getRequestDispatcher("user/inscription.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		
		// verifier les champs
		

		// affectation a l'objet
        user.setCivilite( req.getParameter("user.civilite") );
        user.setNom( req.getParameter("user.nom") );
        user.setPrenom( req.getParameter("user.prenom") );
        user.setEmail( req.getParameter("user.email") );
        user.setPassword( req.getParameter("user.password") );

        //  voir si c'est Insert ou Update (si c'est insert id = null)
        
        // sauvegarde en bdd
    	UserDao userDao = new UserDao();
		userDao.addUser(user);
		
		req.setAttribute("user", user);
		
		RequestDispatcher dispatcher = null;
		
		dispatcher = req.getRequestDispatcher("user/inscription.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	
}
