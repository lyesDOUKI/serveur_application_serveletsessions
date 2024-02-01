package com.ceri.servketsessions;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class DisplayInfoServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        //recuperation de age et code postal && ajout dans la session
        String age = request.getParameter("age");
        String codePostal = request.getParameter("codePostal");
        HttpSession session = request.getSession();
        session.setAttribute("age", age);
        session.setAttribute("codePostal", codePostal);
        //affichage des informations
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Informations recupérés depuis la session</h1>");
        out.println("<p>Nom : " + session.getAttribute("nom") + "</p>");
        out.println("<p>Age : " + session.getAttribute("age") + "</p>");
        out.println("<p>Code postal : " + session.getAttribute("codePostal") + "</p>");
        //liens vers AgeCodePostalServlet
        out.println("<br/>");
        //forms pour retourner en post vers la second servlet
        out.println("<form method='post' action='second-servlet'>");
        //bouton pour retourner en post vers la second servlet
        out.println("<input type='submit' value='Modifier dans la seconde servlet' />");
        out.println("</form>");
        //bouton vers HelloServlet
        out.println("<br/>");
        //le bouton
        out.println("<form method='get' action='hello-servlet'>");
        out.println("<input type='submit' value='Retour à la premiere servlet' />");
        out.println("</form>");
        //proposer de finir la session
        out.println("<br/>");
        out.println("<a href='finSession-servlet'>Fin de la session</a>");
        out.println("</body></html>");
    }
}
