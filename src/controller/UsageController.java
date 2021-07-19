package controller;

import bean.Usage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsageController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public UsageController(Connection connection) {
        this.connection = connection;
    }

    public void addUsage(String nom) {
        String req = "INSERT INTO usages(nom) VALUES (?) ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nom);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUsage(long id, String nom) {
        String req = "UPDATE usages SET nom = ? WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nom);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUsage(long id) {
        String req = "DELETE FROM usages WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usage getUsage(long id) {
        String req = "SELECT * FROM usages WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Usage(resultSet.getLong("id"), resultSet.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Usage getUsage(String nom) {
        String req = "SELECT * FROM usages WHERE nom = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nom);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Usage(resultSet.getLong("id"), resultSet.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Usage> getUsages() {
        String req = "SELECT * FROM usages ";
        try {
            ArrayList<Usage> list = new ArrayList<>();
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Usage(resultSet.getLong("id"), resultSet.getString("nom")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
