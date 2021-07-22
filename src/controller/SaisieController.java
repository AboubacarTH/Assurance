/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Saisie;
import java.sql.Connection;
import java.sql.Date;
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
public class SaisieController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public SaisieController(Connection connection) {
        this.connection = connection;
    }

    public void addSaisie(long id_souscripteur, long id_automobile, long id_compagnie, Date date_saisie, Date date_effet, Date date_echeance, double prime_nette, double surprime, double accessoire, double taxe, double prime_totale, String numero_police) {
        try {
            String req = "INSERT INTO saisies(id_souscripteur, id_automobile, id_compagnie, date_saisie, date_effet, date_echeance, prime_nette, surprime, accessoire, taxe, prime_totale, numero_police) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_souscripteur);
            preparedStatement.setLong(2, id_automobile);
            preparedStatement.setLong(3, id_compagnie);
            preparedStatement.setDate(4, date_saisie);
            preparedStatement.setDate(5, date_effet);
            preparedStatement.setDate(6, date_echeance);
            preparedStatement.setDouble(7, prime_nette);
            preparedStatement.setDouble(8, surprime);
            preparedStatement.setDouble(9, accessoire);
            preparedStatement.setDouble(10, taxe);
            preparedStatement.setDouble(11, prime_totale);
            preparedStatement.setString(12, numero_police);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SaisieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateSaisie(long id, long id_souscripteur, long id_automobile, long id_compagnie, Date date_saisie, Date date_effet, Date date_echeance, double prime_nette, double surprime, double accessoire, double taxe, double prime_totale, String numero_police) {
        try {
            String req = "UPDATE saisies SET id_souscripteur = ?, id_automobile = ?, id_compagnie = ?, date_saisie = ?, date_effet = ?, date_echeance = ?, prime_nette = ?, surprime = ?, accessoire = ?, taxe = ?, prime_totale = ?, numero_police = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_souscripteur);
            preparedStatement.setLong(2, id_automobile);
            preparedStatement.setLong(3, id_compagnie);
            preparedStatement.setDate(4, date_saisie);
            preparedStatement.setDate(5, date_effet);
            preparedStatement.setDate(6, date_echeance);
            preparedStatement.setDouble(7, prime_nette);
            preparedStatement.setDouble(8, surprime);
            preparedStatement.setDouble(9, accessoire);
            preparedStatement.setDouble(10, taxe);
            preparedStatement.setDouble(11, prime_totale);
            preparedStatement.setString(12, numero_police);
            preparedStatement.setLong(13, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SaisieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeSaisie(long id) {
        try {
            String req = "DELETE FROM saisies WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SaisieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Saisie getSaisie(long id) {
        try {
            String req = "SELECT * FROM saisies WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Saisie(resultSet.getLong("id"), resultSet.getLong("id_souscripteur"), resultSet.getLong("id_automobile"), resultSet.getLong("id_compagnie"), resultSet.getDate("date_saisie"), resultSet.getDate("date_effet"), resultSet.getDate("date_echeance"), resultSet.getDouble("prime_nette"), resultSet.getDouble("surprime"), resultSet.getDouble("accessoire"), resultSet.getDouble("taxe"), resultSet.getDouble("prime_totale"), resultSet.getString("numero_police"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaisieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public long getMaxID() {
        try {
            String req = "SELECT MAX(id) AS id_max FROM saisies ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return resultSet.getLong("id_max");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaisieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<Saisie> getSaisies(String pseudo) {
        try {
            ArrayList<Saisie> list = new ArrayList<>();
            String req = "SELECT * FROM saisies "
                    + "JOIN user_saisies ON "
                    + "saisies.id = user_saisies.id_saisie "
                    + "JOIN users ON "
                    + "user_saisies.id_user = users.id WHERE saisies.id > '0' ";
            if (pseudo != null && !"Tous".equals(pseudo)) {
                req += "AND users.pseudo ='" + pseudo + "' ";
            }
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Saisie(resultSet.getLong("id"), resultSet.getLong("id_souscripteur"), resultSet.getLong("id_automobile"), resultSet.getLong("id_compagnie"), resultSet.getDate("date_saisie"), resultSet.getDate("date_effet"), resultSet.getDate("date_echeance"), resultSet.getDouble("prime_nette"), resultSet.getDouble("surprime"), resultSet.getDouble("accessoire"), resultSet.getDouble("taxe"), resultSet.getDouble("prime_totale"), resultSet.getString("numero_police")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(SaisieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
