package com.stock.service;


import com.stock.dao.IProduitDAO;
import com.stock.dao.ProduitDAOImpl;
import com.stock.model.Produit;

import java.util.List;

public class ProduitService {

    private IProduitDAO dao = new ProduitDAOImpl();

    public List<Produit> getProduits() {
        return dao.findAll();
    }
}