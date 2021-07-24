/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.CompagnieGarantie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ATH
 */
public class CompagnieGarantieController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public CompagnieGarantieController(Connection connection) {
        this.connection = connection;
    }

    public void addCompagnieGarantie(long id_compagnie, long id_garantie, double montant) {
        try {
            String req = "INSERT INTO compagnie_garanties(id_compagnie, id_garantie, montant) VALUES (?, ?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_compagnie);
            preparedStatement.setLong(2, id_garantie);
            preparedStatement.setDouble(3, montant);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieGarantieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCompagnieGarantie(long id, long id_compagnie, long id_garantie, double montant) {
        try {
            String req = "UPDATE compagnie_garanties SET id_compagnie = ?, id_garantie = ?, montant = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_compagnie);
            preparedStatement.setLong(2, id_garantie);
            preparedStatement.setDouble(3, montant);
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieGarantieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeCompagnieGarantie(long id) {
        try {
            String req = "DELETE FROM compagnie_garanties WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieGarantieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CompagnieGarantie getCompagnieGarantie(long id) {
        try {
            String req = "SELECT * FROM compagnie_garanties WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new CompagnieGarantie(resultSet.getLong("id"), resultSet.getLong("id_compagnie"), resultSet.getLong("id_garantie"), resultSet.getDouble("montant"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieGarantieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public CompagnieGarantie getCompagnieGarantie(long id_compagnie, long id_garantie) {
        try {
            String req = "SELECT * FROM compagnie_garanties WHERE id_compagnie = ? AND id_garantie = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_compagnie);
            preparedStatement.setLong(2, id_garantie);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new CompagnieGarantie(resultSet.getLong("id"), resultSet.getLong("id_compagnie"), resultSet.getLong("id_garantie"), resultSet.getDouble("montant"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieGarantieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<CompagnieGarantie> getCompagnieGaranties(long id_compagnie) {
        try {
            ArrayList<CompagnieGarantie> list = new ArrayList<>();
            String req = "SELECT * FROM compagnie_garanties WHERE id > '0' ";
            if (id_compagnie != 0) {
                req += "AND id_compagnie = '" + id_compagnie + "' ";
            }
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new CompagnieGarantie(resultSet.getLong("id"), resultSet.getLong("id_compagnie"), resultSet.getLong("id_garantie"), resultSet.getDouble("montant")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieGarantieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
