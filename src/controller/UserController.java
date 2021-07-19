/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.User;
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
public class UserController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public UserController(Connection connection) {
        this.connection = connection;
    }

    public void addUser(String nom_prenom, String pseudo, String password) {
        try {
            String req = "INSERT INTO users(nom_prenom, pseudo, password) VALUES (?, ?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nom_prenom);
            preparedStatement.setString(2, pseudo);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateUser(long id, String nom_prenom, String pseudo, String password) {
        try {
            String req = "UPDATE users SET nom_prenom = ?, pseudo = ?, password = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nom_prenom);
            preparedStatement.setString(2, pseudo);
            preparedStatement.setString(3, password);
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeUser(long id) {
        try {
            String req = "DELETE FROM users WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getUser(long id) {
        try {
            String req = "SELECT * FROM users WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new User(resultSet.getLong("id"), resultSet.getString("nom_prenom"), resultSet.getString("pseudo"), resultSet.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User getUser(String pseudo) {
        try {
            String req = "SELECT * FROM users WHERE pseudo = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, pseudo);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new User(resultSet.getLong("id"), resultSet.getString("nom_prenom"), resultSet.getString("pseudo"), resultSet.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        try {
            ArrayList<User> list = new ArrayList<>();
            String req = "SELECT * FROM users ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new User(resultSet.getLong("id"), resultSet.getString("nom_prenom"), resultSet.getString("pseudo"), resultSet.getString("password")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
