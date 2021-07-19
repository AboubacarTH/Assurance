package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			createTable();
			ConnectorLite connectorLite = new ConnectorLite();
			String req = "SELECT * FROM adresses ";
			PreparedStatement preparedStatement = connectorLite.getConnection().prepareStatement(req);
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				System.out.println("id " + resultSet.getInt("id") + " nom " + resultSet.getString("nom"));
			}

		} catch (SQLException ex) {
			Logger.getLogger(ConnectorLite.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

//	private static void createTable() {
//
//		ConnectorLite connectorLite = new ConnectorLite();
//		String req = "CREATE TABLE adresses (\r\n" + "                id INT NOT NULL,\r\n"
//				+ "                nom VARCHAR(255) NOT NULL,\r\n" + "                PRIMARY KEY (id)\r\n"
//				+ "                );";
//		PreparedStatement preparedStatement;
//		try {
//			preparedStatement = connectorLite.getConnection().prepareStatement(req);
//			preparedStatement.execute();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

}
