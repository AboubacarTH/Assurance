/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.SaisieGarantie;
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
public class SaisieGarantieController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public SaisieGarantieController(Connection connection) {
        this.connection = connection;
    }

    public void addSaisieGarantie(long id_saisie, long id_compagnie_garantie) {
        try {
            String req = "INSERT INTO saisie_garanties(id_saisie, id_compagnie_garantie) VALUES (?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_saisie);
            preparedStatement.setLong(2, id_compagnie_garantie);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SaisieGarantieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateSaisieGarantie(long id, long id_saisie, long id_compagnie_garantie) {
        try {
            String req = "UPDATE saisie_garanties SET id_saisie = ?, id_compagnie_garantie = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_saisie);
            preparedStatement.setLong(2, id_compagnie_garantie);
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SaisieGarantieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeSaisieGarantie(long id) {
        try {
            String req = "DELETE FROM saisie_garanties WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SaisieGarantieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public SaisieGarantie getSaisieGarantie(long id) {
        try {
            String req = "SELECT * FROM saisie_garanties WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new SaisieGarantie(resultSet.getLong("id"), resultSet.getLong("id_saisie"), resultSet.getLong("id_compagnie_garantie"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaisieGarantieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<SaisieGarantie> getSaisieGaranties() {
        try {
            ArrayList<SaisieGarantie> list = new ArrayList<>();
            String req = "SELECT * FROM saisie_garanties ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new SaisieGarantie(resultSet.getLong("id"), resultSet.getLong("id_saisie"), resultSet.getLong("id_compagnie_garantie")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(SaisieGarantieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
