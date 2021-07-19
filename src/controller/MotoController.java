package controller;

import bean.Moto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MotoController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public MotoController(Connection connection) {
        this.connection = connection;
    }

    public void addMoto(long id, long id_puissance) {
        String req = "INSERT INTO motos(id, id_puissance) VALUES (?, ?) ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, id_puissance);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMoto(long id, long id_puissance) {
        String req = "UPDATE motos SET id_puissance = ? WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_puissance);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeMoto(long id) {
        String req = "DELETE FROM motos WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Moto getMoto(long id) {
        String req = "SELECT * FROM motos WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Moto(resultSet.getLong("id"), resultSet.getLong("id_puissance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Moto> getMotos() {
        String req = "SELECT * FROM usages ";
        try {
            ArrayList<Moto> list = new ArrayList<>();
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Moto(resultSet.getLong("id"), resultSet.getLong("id_puissance")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
