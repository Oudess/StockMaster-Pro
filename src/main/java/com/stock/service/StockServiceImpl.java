package com.stock.service;


import com.stock.dao.IProduitDAO;
import com.stock.dao.ProduitDAOImpl;
import com.stock.model.Produit;

import java.util.List;

public class StockServiceImpl implements IStockService {

    // Le service dépend de l'interface DAO (bonne pratique)
    private IProduitDAO dao = new ProduitDAOImpl();

    @Override
    public List<Produit> recupererCatalogueFiltre() {

        // Logique métier possible ici (filtrage, règles, etc.)
        return dao.findAll();
    }
}
