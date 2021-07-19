/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Droit;
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
public class DroitController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public DroitController(Connection connection) {
        this.connection = connection;
    }

    public void addDroit(long id_user, boolean ecriture, boolean lecture, boolean supression, boolean modification, boolean administration) {
        try {
            String req = "INSERT INTO droits(id_user, ecriture, lecture, supression, modification, administration) VALUES (?, ?, ?, ?, ? ,?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_user);
            preparedStatement.setBoolean(2, ecriture);
            preparedStatement.setBoolean(3, lecture);
            preparedStatement.setBoolean(4, supression);
            preparedStatement.setBoolean(5, modification);
            preparedStatement.setBoolean(6, administration);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DroitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateDroit(long id_user, boolean ecriture, boolean lecture, boolean supression, boolean modification, boolean administration) {
        try {
            String req = "UPDATE droits SET id_user = ?, ecriture = ?, lecture = ?, supression = ?, modification = ?, administration = ? WHERE id_user = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, ecriture);
            preparedStatement.setBoolean(2, lecture);
            preparedStatement.setBoolean(3, supression);
            preparedStatement.setBoolean(4, modification);
            preparedStatement.setBoolean(5, administration);
            preparedStatement.setLong(6, id_user);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DroitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeDroit(long id_user) {
        try {
            String req = "DELETE FROM droits WHERE id_user = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_user);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DroitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Droit getDroit(long id_user) {
        try {
            String req = "SELECT * FROM droits WHERE id_user = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_user);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Droit(resultSet.getLong("id_user"), resultSet.getBoolean("ecriture"), resultSet.getBoolean("lecture"), resultSet.getBoolean("supression"), resultSet.getBoolean("modification"), resultSet.getBoolean("administration"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DroitController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Droit> getDroits() {
        try {
            ArrayList<Droit> list = new ArrayList<>();
            String req = "SELECT * FROM droits ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Droit(resultSet.getLong("id_user"), resultSet.getBoolean("ecriture"), resultSet.getBoolean("lecture"), resultSet.getBoolean("supression"), resultSet.getBoolean("modification"), resultSet.getBoolean("administration")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DroitController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
