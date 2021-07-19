package controller;

import bean.VehiculeMoteur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehiculeMoteurController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public VehiculeMoteurController(Connection connection) {
        this.connection = connection;
    }

    public void addVehiculeMoteur(String puissance, long id_energie) {
        String req = "INSERT INTO vehicule_moteurs(puissance, id_energie) VALUES (?, ?) ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, puissance);
            preparedStatement.setLong(2, id_energie);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateVehiculeMoteur(long id, String puissance, long id_energie) {
        String req = "UPDATE vehicule_moteurs SET puissance = ?, id_energie = ? WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, puissance);
            preparedStatement.setLong(2, id_energie);
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeVehiculeMoteur(long id) {
        String req = "DELETE FROM vehicule_moteurs WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public VehiculeMoteur getVehiculeMoteur(long id) {
        String req = "SELECT * FROM vehicule_moteurs WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new VehiculeMoteur(resultSet.getLong("id"), resultSet.getString("puissance"), resultSet.getLong("id_energie"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public VehiculeMoteur getVehiculeMoteur(String puissance) {
        String req = "SELECT * FROM vehicule_moteurs WHERE puissance = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, puissance);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new VehiculeMoteur(resultSet.getLong("id"), resultSet.getString("puissance"), resultSet.getLong("id_energie"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public VehiculeMoteur getVehiculeMoteur(String puissance, long id_energie) {
        String req = "SELECT * FROM vehicule_moteurs WHERE puissance = ? AND id_energie = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, puissance);
            preparedStatement.setLong(2, id_energie);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new VehiculeMoteur(resultSet.getLong("id"), resultSet.getString("puissance"), resultSet.getLong("id_energie"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<VehiculeMoteur> getVehiculeMoteurs(long id_energie) {
        String req = "SELECT * FROM vehicule_moteurs WHERE id > '0' ";
        if (id_energie != 0) {
            req += "AND id_energie ='" + id_energie + "' ";
        }
        try {
            ArrayList<VehiculeMoteur> list = new ArrayList<>();
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new VehiculeMoteur(resultSet.getLong("id"), resultSet.getString("puissance"), resultSet.getLong("id_energie")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
