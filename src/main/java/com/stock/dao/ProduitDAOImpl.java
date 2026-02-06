package com.stock.dao;

import com.stock.model.Produit;
import com.stock.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAOImpl implements IProduitDAO {

    @Override
    public List<Produit> findAll() {

        List<Produit> produits = new ArrayList<>();
        String sql = "SELECT * FROM produit";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Produit p = new Produit(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getDouble("prix")
                );
                produits.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return produits;
    }
}
