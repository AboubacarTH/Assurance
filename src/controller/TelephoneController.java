/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Telephone;
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
public class TelephoneController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public TelephoneController(Connection connection) {
        this.connection = connection;
    }

    public void addTelephone(long id_souscripteur, String telephone) {
        try {
            String req = "INSERT INTO telephones(id_souscripteur, telephone) VALUES (?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_souscripteur);
            preparedStatement.setString(2, telephone);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TelephoneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateTelephone(long id, long id_souscripteur, String telephone) {
        try {
            String req = "UPDATE telephones SET id_souscripteur = ?, telephone = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_souscripteur);
            preparedStatement.setString(2, telephone);
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TelephoneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeTelephone(long id) {
        try {
            String req = "DELETE FROM telephones WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TelephoneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeAllTelephone(long id_souscripteur) {
        try {
            String req = "DELETE FROM telephones WHERE id_souscripteur = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_souscripteur);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TelephoneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Telephone getTelephone(long id) {
        try {
            String req = "SELECT * FROM telephones WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Telephone(resultSet.getLong("id"), resultSet.getLong("id_souscripteur"), resultSet.getString("telephone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelephoneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Telephone getTelephone(String telephone) {
        try {
            String req = "SELECT * FROM telephones WHERE telephone = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, telephone);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Telephone(resultSet.getLong("id"), resultSet.getLong("id_souscripteur"), resultSet.getString("telephone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelephoneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Telephone> getTelephones(long id_souscripteur) {
        try {
            ArrayList<Telephone> list = new ArrayList<>();
            String req = "SELECT * FROM telephones WHERE id_souscripteur = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_souscripteur);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Telephone(resultSet.getLong("id"), resultSet.getLong("id_souscripteur"), resultSet.getString("telephone")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(TelephoneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Telephone> getTelephones() {
        try {
            ArrayList<Telephone> list = new ArrayList<>();
            String req = "SELECT * FROM telephones ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Telephone(resultSet.getLong("id"), resultSet.getLong("id_souscripteur"), resultSet.getString("telephone")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(TelephoneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
