package com.ceri.servketsessions;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        //formulaire avec un nom
        //question 2 : Attention il faut desactiver les cookies du navigateur pour que cela fonctionne
        out.println("<form method='post' action=" + response.encodeURL("second-servlet") + ">");
        out.println("<label for='nom'>Nom</label>");
        out.println("<input type='text' name='nom' />");
        out.println("<input type='submit' value='Envoyer' />");
        out.println("</form>");
        out.println("</body></html>");
    }

}