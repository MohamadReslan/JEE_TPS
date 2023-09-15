package com.example.tp1;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    Utilisateur utilisateur;
    private static final String LOGIN_VALID = "admin";
    private static final String MOT_DE_PASSE_VALIDE = "porgrav";
    private static final String EROOR_MESSAGE ="INFOS INVALIDES !";

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        utilisateur= new Utilisateur();

       utilisateur.setLoginSaisi(request.getParameter("champLogin"));
       utilisateur.setPrenomSaisi(request.getParameter("champPrenom"));
       utilisateur.setMotDePasseSaisi(request.getParameter("champMotDePasse"));

       request.setAttribute("utilisateur",utilisateur);

       if(verificationOfConnexionsInfos(utilisateur)){
           request.getRequestDispatcher("bienvenue.jsp").forward(request,response);
       }else {
           request.setAttribute("errorMessage",EROOR_MESSAGE);
           request.getRequestDispatcher("index.jsp").forward(request,response);
       }
    }

    public boolean verificationOfConnexionsInfos(Utilisateur utilisateur) {
        return (utilisateur.getLoginSaisi().equals(LOGIN_VALID) && utilisateur.getMotDePasseSaisi().equals(MOT_DE_PASSE_VALIDE));
    }

    public void destroy() {}
}