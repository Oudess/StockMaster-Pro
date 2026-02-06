package com.stock.dao;

import com.stock.model.Produit;
import java.util.List;

public interface IProduitDAO {
    List<Produit> findAll();
}