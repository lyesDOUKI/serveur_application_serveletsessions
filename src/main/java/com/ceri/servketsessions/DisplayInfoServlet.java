package com.ceri.servketsessions;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class DisplayInfoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        //recuperation de la session
        String nom = null;
        String age = null;
        String codePostal = null;
        HttpSession session = request.getSession();
        //verification de la presence et rediriger vers la premiere servlet
        if (session.getAttribute("nom") == null
        || session.getAttribute("age") == null ||
        session.getAttribute("codePostal") == null) {
            //si oui, on recupere le nom depuis la session
            response.sendRedirect("hello-servlet");
        }
        else {
            response.setContentType("text/html");
            //affichage des informations
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Informations recupérés depuis la session</h1>");
            out.println("<p>Nom : " + session.getAttribute("nom") + "</p>");
            out.println("<p>Age : " + session.getAttribute("age") + "</p>");
            out.println("<p>Code postal : " + session.getAttribute("codePostal") + "</p>");
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        //recuperation de age et code postal && ajout dans la session
        String age = request.getParameter("age");
        String codePostal = request.getParameter("codePostal");
        HttpSession session = request.getSession();
        //verification de la presence et rediriger vers la premiere servlet
        if (session.getAttribute("age") != null) {
            //si oui, on recupere le nom depuis la session
            age = (String) session.getAttribute("age");
        }
        else {
            if(age == null) {
                //on redirige vers la premiere servlet
                response.sendRedirect("hello-servlet");
            }
            session.setAttribute("age", age);
        }
        if (session.getAttribute("codePostal") != null) {
            //si oui, on recupere le nom depuis la session
            codePostal = (String) session.getAttribute("codePostal");
        }
        else {
            if(codePostal == null) {
                //on redirige vers la premiere servlet
                response.sendRedirect("hello-servlet");
            }
            session.setAttribute("codePostal", codePostal);
        }
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
