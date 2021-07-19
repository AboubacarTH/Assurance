/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Compagnie;
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
public class CompagnieController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public CompagnieController(Connection connection) {
        this.connection = connection;
    }

    public void addCompagnie(String compagnie) {
        try {
            String req = "INSERT INTO compagnies(compagnie) VALUES (?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, compagnie);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateCompagnie(long id, String compagnie) {
        try {
            String req = "UPDATE compagnies SET compagnie = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, compagnie);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeCompagnie(long id) {
        try {
            String req = "DELETE FROM compagnies WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Compagnie getCompagnie(long id) {
        try {
            String req = "SELECT * FROM compagnies WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Compagnie(resultSet.getLong("id"), resultSet.getString("compagnie"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Compagnie getCompagnie(String compagnie) {
        try {
            String req = "SELECT * FROM compagnies WHERE compagnie = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, compagnie);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Compagnie(resultSet.getLong("id"), resultSet.getString("compagnie"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Compagnie> getCompagnies() {
        try {
            ArrayList<Compagnie> list = new ArrayList<>();
            String req = "SELECT * FROM compagnies ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Compagnie(resultSet.getLong("id"), resultSet.getString("compagnie")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
