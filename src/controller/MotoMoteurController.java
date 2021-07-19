package controller;

import bean.MotoMoteur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MotoMoteurController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public MotoMoteurController(Connection connection) {
        this.connection = connection;
    }

    public void addMotoMoteur(String puissance) {
        String req = "INSERT INTO moto_moteurs(puissance) VALUES (?) ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, puissance);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMotoMoteur(long id, String puissance) {
        String req = "UPDATE moto_moteurs SET puissance = ? WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, puissance);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeMotoMoteur(long id) {
        String req = "DELETE FROM moto_moteurs WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public MotoMoteur getMotoMoteur(long id) {
        String req = "SELECT * FROM moto_moteurs WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new MotoMoteur(resultSet.getLong("id"), resultSet.getString("puissance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MotoMoteur getMotoMoteur(String puissance) {
        String req = "SELECT * FROM moto_moteurs WHERE puissance = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, puissance);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new MotoMoteur(resultSet.getLong("id"), resultSet.getString("puissance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<MotoMoteur> getMotoMoteurs() {
        String req = "SELECT * FROM moto_moteurs ";
        try {
            ArrayList<MotoMoteur> list = new ArrayList<>();
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new MotoMoteur(resultSet.getLong("id"), resultSet.getString("puissance")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
