package tp2.example.tp2;

import java.io.*;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import tp2.example.tp2.model.EmployeeSB;
import tp2.example.tp2.model.EmployesEntity;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    Utilisateur utilisateur;
    private static final String LOGIN_VALID = "admin";
    private static final String MOT_DE_PASSE_VALIDE = "porgrav";
    private static final String EROOR_MESSAGE ="INFOS INVALIDES !";
    @EJB // important because we don't need to do try catch and put new ...
    private EmployeeSB esb;

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        utilisateur= new Utilisateur();
        utilisateur.setLoginSaisi(request.getParameter("champLogin"));
        utilisateur.setPrenomSaisi(request.getParameter("champPrenom"));
        utilisateur.setMotDePasseSaisi(request.getParameter("champMotDePasse"));

        request.setAttribute("utilisateur",utilisateur);

        if(verificationOfConnexionsInfos(utilisateur)){
            List<EmployesEntity> allEmployees = esb.getEmployees();
            request.setAttribute( "allEmployees", allEmployees);
            forwardRequest(request, "bienvenue.jsp", response);
        }else {
            request.setAttribute("errorMessage", EROOR_MESSAGE);
            forwardRequest(request, "index.jsp", response);
        }
    }

    private static void forwardRequest(HttpServletRequest request, String s, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(s).forward(request, response);
    }

    public boolean verificationOfConnexionsInfos(Utilisateur utilisateur) {
        return (utilisateur.getLoginSaisi().equals(LOGIN_VALID) && utilisateur.getMotDePasseSaisi().equals(MOT_DE_PASSE_VALIDE));
    }

    public void destroy() {}
}