package controller;

import bean.Zone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ZoneController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ZoneController(Connection connection) {
        this.connection = connection;
    }

    public void addZone(String zone) {
        String req = "INSERT INTO zones(zone) VALUES (?) ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, zone);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateZone(long id, String zone) {
        String req = "UPDATE zones SET zone = ? WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, zone);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeZone(long id) {
        String req = "DELETE FROM zones WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Zone getZone(long id) {
        String req = "SELECT * FROM zones WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Zone(resultSet.getLong("id"), resultSet.getString("zone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Zone getZone(String zone) {
        String req = "SELECT * FROM zones WHERE zone = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, zone);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Zone(resultSet.getLong("id"), resultSet.getString("zone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Zone> getZones() {
        String req = "SELECT * FROM zones ";
        try {
            ArrayList<Zone> list = new ArrayList<>();
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Zone(resultSet.getLong("id"), resultSet.getString("zone")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
