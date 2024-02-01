package com.ceri.servketsessions;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class FinSessionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        //detruires la session
        HttpSession session = request.getSession();
        session.invalidate();
        //redirection vers HelloServlet
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Session détruite</h1>");
        out.println("<a href='hello-servlet'>Retour à la premiere servlet</a>");
    }
}
