package com.stock.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/connexion")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if ("admin".equals(login) && "123".equals(password)) {

            HttpSession session = request.getSession();
            session.setAttribute("user", login);

            response.sendRedirect("catalogue");

        } else {
            request.setAttribute("erreur", "Login ou mot de passe incorrect");
            request.getRequestDispatcher("login.jsp")
                    .forward(request, response);
        }
    }
}

