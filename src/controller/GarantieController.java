/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Garantie;
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
public class GarantieController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public GarantieController(Connection connection) {
        this.connection = connection;
    }

    public void addGarantie(String garantie) {
        try {
            String req = "INSERT INTO garanties(garantie) VALUES (?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, garantie);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GarantieController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateGarantie(long id, String garantie) {
        try {
            String req = "UPDATE garanties SET garantie = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, garantie);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GarantieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeGarantie(long id) {
        try {
            String req = "DELETE FROM garanties WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GarantieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Garantie getGarantie(long id) {
        try {
            String req = "SELECT * FROM garanties WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Garantie(resultSet.getLong("id"), resultSet.getString("garantie"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GarantieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Garantie getGarantie(String garantie) {
        try {
            String req = "SELECT * FROM garanties WHERE garantie = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, garantie);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Garantie(resultSet.getLong("id"), resultSet.getString("garantie"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GarantieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Garantie> getGaranties() {
        try {
            ArrayList<Garantie> list = new ArrayList<>();
            String req = "SELECT * FROM garanties ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Garantie(resultSet.getLong("id"), resultSet.getString("garantie")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(GarantieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
