package controller;

import bean.Automobile;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AutomobileController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public AutomobileController(Connection connection) {
        this.connection = connection;
    }

    public void addAutomobile(long id_tarif, int nombre_place, Date date_circulation, String type, String numero_plaque,
            String marque, String numero_chassis, double charge_utile) {
        String req = "INSERT INTO automobiles(id_tarif, nombre_place, date_circulation, type, numero_plaque, marque, numero_chassis, charge_utile) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_tarif);
            preparedStatement.setInt(2, nombre_place);
            preparedStatement.setDate(3, date_circulation);
            preparedStatement.setString(4, type);
            preparedStatement.setString(5, numero_plaque);
            preparedStatement.setString(6, marque);
            preparedStatement.setString(7, numero_chassis);
            preparedStatement.setDouble(8, charge_utile);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAutomobile(long id, long id_tarif, int nombre_place, Date date_circulation, String type, String numero_plaque,
            String marque, String numero_chassis, double charge_utile) {
        String req = "UPDATE automobiles SET id_tarif = ?, nombre_place = ?, date_circulation = ?, type = ?, numero_plaque = ?, marque = ?, numero_chassis = ?, charge_utile = ? WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_tarif);
            preparedStatement.setInt(2, nombre_place);
            preparedStatement.setDate(3, date_circulation);
            preparedStatement.setString(4, type);
            preparedStatement.setString(5, numero_plaque);
            preparedStatement.setString(6, marque);
            preparedStatement.setString(7, numero_chassis);
            preparedStatement.setDouble(8, charge_utile);
            preparedStatement.setLong(9, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeAutomobile(long id) {
        String req = "DELETE FROM automobiles WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Automobile getAutomobile(long id) {
        String req = "SELECT * FROM automobiles WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Automobile(resultSet.getLong("id"), resultSet.getLong("id_tarif"), resultSet.getInt("nombre_place"), resultSet.getDate("date_circulation"), resultSet.getString("type"), resultSet.getString("numero_plaque"), resultSet.getString("marque"), resultSet.getString("numero_chassis"), resultSet.getDouble("charge_utile"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Automobile getAutomobile(String numero_plaque) {
        String req = "SELECT * FROM automobiles WHERE numero_plaque = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, numero_plaque);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Automobile(resultSet.getLong("id"), resultSet.getLong("id_tarif"), resultSet.getInt("nombre_place"), resultSet.getDate("date_circulation"), resultSet.getString("type"), resultSet.getString("numero_plaque"), resultSet.getString("marque"), resultSet.getString("numero_chassis"), resultSet.getDouble("charge_utile"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Automobile> getAutomobiles() {
        String req = "SELECT * FROM automobiles ";
        try {
            ArrayList<Automobile> list = new ArrayList<>();
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Automobile(resultSet.getLong("id"), resultSet.getLong("id_tarif"), resultSet.getInt("nombre_place"), resultSet.getDate("date_circulation"), resultSet.getString("type"), resultSet.getString("numero_plaque"), resultSet.getString("marque"), resultSet.getString("numero_chassis"), resultSet.getDouble("charge_utile")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
