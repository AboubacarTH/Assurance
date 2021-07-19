/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Police;
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
public class PoliceController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public PoliceController(Connection connection) {
        this.connection = connection;
    }

    public void addPolice(long id_usage, long id_compagnie, long police) {
        try {
            String req = "INSERT INTO polices(id_usage, id_compagnie, police) VALUES (?, ?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_usage);
            preparedStatement.setLong(2, id_compagnie);
            preparedStatement.setDouble(3, police);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PoliceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePolice(long id, long id_usage, long id_compagnie, long police) {
        try {
            String req = "UPDATE polices SET id_usage = ?, id_compagnie = ?, police = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_usage);
            preparedStatement.setLong(2, id_compagnie);
            preparedStatement.setLong(3, police);
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PoliceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removePolice(long id) {
        try {
            String req = "DELETE FROM polices WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PoliceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Police getPolice(long id) {
        try {
            String req = "SELECT * FROM polices WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Police(resultSet.getLong("id"), resultSet.getLong("id_usage"), resultSet.getLong("id_compagnie"), resultSet.getLong("police"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PoliceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Police getPolice(long id_usage, long id_compagnie) {
        try {
            String req = "SELECT * FROM polices WHERE id_usage = ? AND id_compagnie = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_usage);
            preparedStatement.setLong(2, id_compagnie);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Police(resultSet.getLong("id"), resultSet.getLong("id_usage"), resultSet.getLong("id_compagnie"), resultSet.getLong("police"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PoliceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Police> getPolices() {
        try {
            ArrayList<Police> list = new ArrayList<>();
            String req = "SELECT * FROM polices ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Police(resultSet.getLong("id"), resultSet.getLong("id_usage"), resultSet.getLong("id_compagnie"), resultSet.getLong("police")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(PoliceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
