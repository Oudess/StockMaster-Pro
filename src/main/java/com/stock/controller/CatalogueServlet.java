package com.stock.controller;

import com.stock.model.Produit;
import com.stock.service.IStockService;
import com.stock.service.StockServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/catalogue")
public class CatalogueServlet extends HttpServlet {

    private IStockService service;

    @Override
    public void init() {
        service = new StockServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // ==============================
        // 1️⃣ Lecture du cookie lastVisit
        // ==============================

        String lastVisit = "Première visite";

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("lastVisit".equals(c.getName())) {
                    lastVisit = c.getValue();
                    break;
                }
            }
        }

        // ==============================
        // 2️⃣ Vérification du consentement
        // ==============================

        boolean consentGiven = false;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("cookieConsent".equals(c.getName())
                        && "accept".equals(c.getValue())) {
                    consentGiven = true;
                    break;
                }
            }
        }

        // ==============================
        // 3️⃣ Création du cookie si accepté
        // ==============================

        if (consentGiven) {

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss");

            String now = LocalDateTime.now().format(formatter);

            Cookie newCookie = new Cookie("lastVisit", now);
            newCookie.setMaxAge(24 * 60 * 60); // 24h
            newCookie.setPath("/");

            response.addCookie(newCookie);
        }

        // ==============================
        // 4️⃣ Récupération des produits
        // ==============================

        List<Produit> produits =
                service.recupererCatalogueFiltre();

        request.setAttribute("listeProduits", produits);
        request.setAttribute("lastVisit", lastVisit);

        // ==============================
        // 5️⃣ Forward UNIQUE vers JSP
        // ==============================

        request.getRequestDispatcher("/WEB-INF/vues/catalogue.jsp")
                .forward(request, response);
    }
}
