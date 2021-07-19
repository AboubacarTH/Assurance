package database;

import controller.AdresseController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import main.Assurances;
import view.dialog.AdresseDialog;

public class ConnectorDB {
	private Connection connection;
	private String url;
	private String user;
	private String password;
	private final AdresseController adresseController;

	public ConnectorDB() {
		adresseController = new AdresseController(Assurances.getConnection());
		String nom = "default";
		if (adresseController.getAdresse(1) != null) {
			nom = adresseController.getAdresse(1).getNom();
		}
		url = "jdbc:mysql://" + nom + "/assurance";
		user = "assurance";
		password = "assurance";
		try {
                    Class.forName("com.mysql.jdbc.Driver");
                    this.connection = DriverManager.getConnection(url, user, password);
                    System.out.println("Connection to SQL has been established.");
		} catch (ClassNotFoundException | SQLException e) {
			// JOptionPane.showMessageDialog(null, "connexion non etablie" +
			// e.getMessage());
			AdresseDialog adresseDialog = new AdresseDialog(null, true);
			adresseDialog.setVisible(true);
			System.exit(0);
		}
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}
}
