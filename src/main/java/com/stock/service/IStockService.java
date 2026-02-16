package com.stock.service;

import com.stock.model.Produit;
import java.util.List;

public interface IStockService {

    List<Produit> recupererCatalogueFiltre();

}