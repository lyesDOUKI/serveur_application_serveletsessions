package com.ceri.servketsessions;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AgeCodePostalServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        //verifier la presence de la session
        //recuperation du nom
        String nom = request.getParameter("nom");
        //ajouter dans la session avec httpSession
        HttpSession session = request.getSession();
        //voir si nom existe dans session
        if (session.getAttribute("nom") != null) {
            //si oui, on recupere le nom depuis la session
            nom = (String) session.getAttribute("nom");
        }
        else {
            session.setAttribute("nom", nom);
        }
        String nomSession = (String) session.getAttribute("nom");
        out.println("<h1>Bonjour depuis session : " + nomSession + "</h1>");
        //formulaire avec un age et un code postal
        out.println("<form method='post' action='troisieme-servlet'>");
        out.println("<label for='age'>Age</label>");
        out.println("<input type='text' name='age' />");
        out.println("<label for='codePostal'>Code postal</label>");
        out.println("<input type='text' name='codePostal' />");
        out.println("<input type='submit' value='Envoyer' />");
        out.println("</form>");
        out.println("</body></html>");
    }
}
