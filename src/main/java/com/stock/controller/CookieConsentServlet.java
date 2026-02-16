package com.stock.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/cookie")
public class CookieConsentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        String action = request.getParameter("action");

        Cookie consent = new Cookie("cookieConsent", action);

        consent.setMaxAge(60 * 60 * 24 * 30); // 30 jours
        consent.setPath("/");

        response.addCookie(consent);

        response.sendRedirect(
                response.encodeRedirectURL("index.jsp")
        );
    }
}