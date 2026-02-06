package com.stock.controller;

import com.stock.dao.IProduitDAO;
import com.stock.dao.ProduitDAOImpl;
import com.stock.model.Produit;

import com.stock.service.ProduitService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/catalogue")
public class CatalogueServlet extends HttpServlet {
    private IProduitDAO produitDAO = new ProduitDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 🔹 Lecture du cookie lastVisit
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

        // 🔹 Création / mise à jour du cookie
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss");
        String now = LocalDateTime.now().format(formatter);

        Cookie cookie = new Cookie("lastVisit", now);
        cookie.setMaxAge(24 * 60 * 60); // 24 heures
        response.addCookie(cookie);

        ProduitService service = new ProduitService();
        List<Produit> produits = service.getProduits();

        request.setAttribute("listeProduits", produits);


        request.setAttribute("listeProduits", produits);
        request.setAttribute("lastVisit", lastVisit);

        request.getRequestDispatcher("/WEB-INF/vues/catalogue.jsp")
                .forward(request, response);
        request.setAttribute("produits", produitDAO.findAll());
        request.getRequestDispatcher("/catalogue.jsp")
                .forward(request, response);
    }

}