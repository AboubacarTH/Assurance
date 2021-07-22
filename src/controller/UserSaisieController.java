/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.UserSaisie;
import java.sql.Connection;
import java.sql.Date;
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
public class UserSaisieController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public UserSaisieController(Connection connection) {
        this.connection = connection;
    }

    public void addUserSaisie(long id_saisie, long id_user, Date date) {
        try {
            String req = "INSERT INTO user_saisies(id_saisie, id_user, date) VALUES(?, ?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_saisie);
            preparedStatement.setLong(2, id_user);
            preparedStatement.setDate(3, date);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserSaisieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateUserSaisie(long id, long id_saisie, long id_user, Date date) {
        try {
            String req = "UPDATE user_saisies SET id_saisie = ?, id_user = ?, date = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_saisie);
            preparedStatement.setLong(2, id_user);
            preparedStatement.setDate(3, date);
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserSaisieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeUserSaisie(long id) {
        try {
            String req = "DELETE FROM user_saisies WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserSaisieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public UserSaisie getUserSaisie(long id) {
        try {
            String req = "SELECT * FROM user_saisies WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new UserSaisie(resultSet.getLong("id"), resultSet.getLong("id_saisie"), resultSet.getLong("id_user"), resultSet.getDate("date"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserSaisieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<UserSaisie> getUserSaisies() {
        try {
            ArrayList<UserSaisie> list = new ArrayList<>();
            String req = "SELECT * FROM user_saisies ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new UserSaisie(resultSet.getLong("id"), resultSet.getLong("id_saisie"), resultSet.getLong("id_user"), resultSet.getDate("date")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UserSaisieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
