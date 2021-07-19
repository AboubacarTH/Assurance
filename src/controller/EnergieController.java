package controller;

import bean.Energie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnergieController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public EnergieController(Connection connection) {
        this.connection = connection;
    }

    public void addEnergie(String energie) {
        String req = "INSERT INTO energies(energie) VALUES (?) ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, energie);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEnergie(long id, String energie) {
        String req = "UPDATE energies SET energie = ? WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, energie);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeEnergie(long id) {
        String req = "DELETE FROM energies WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Energie getEnergie(long id) {
        String req = "SELECT * FROM energies WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Energie(resultSet.getLong("id"), resultSet.getString("energie"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Energie getEnergie(String energie) {
        String req = "SELECT * FROM energies WHERE energie = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, energie);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Energie(resultSet.getLong("id"), resultSet.getString("energie"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Energie> getEnergies() {
        String req = "SELECT * FROM energies ";
        try {
            ArrayList<Energie> list = new ArrayList<>();
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Energie(resultSet.getLong("id"), resultSet.getString("energie")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
