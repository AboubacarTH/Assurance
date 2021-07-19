/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Souscripteur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ATH
 */
public class SouscripteurController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public SouscripteurController(Connection connection) {
        this.connection = connection;
    }

    public void addSouscripteur(String numero_assure, String nom_prenom, String type_piece, String numero_piece, String adresse, String profession, String personnalite, boolean exempter_taxe) {
        String req = "INSERT INTO souscripteurs(numero_assure, nom_prenom, type_piece, numero_piece, adresse, profession, personnalite, exempter_taxe) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, numero_assure);
            preparedStatement.setString(2, nom_prenom);
            preparedStatement.setString(3, type_piece);
            preparedStatement.setString(4, numero_piece);
            preparedStatement.setString(5, adresse);
            preparedStatement.setString(6, profession);
            preparedStatement.setString(7, personnalite);
            preparedStatement.setBoolean(8, exempter_taxe);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updateSouscripteur(long id, String numero_assure, String nom_prenom, String type_piece, String numero_piece, String adresse, String profession, String personnalite, boolean exempter_taxe) {
        String req = "UPDATE souscripteurs SET numero_assure = ?, nom_prenom = ?, type_piece = ?, numero_piece = ?, adresse = ?, profession = ?, personnalite = ?, exempter_taxe = ? WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, numero_assure);
            preparedStatement.setString(2, nom_prenom);
            preparedStatement.setString(3, type_piece);
            preparedStatement.setString(4, numero_piece);
            preparedStatement.setString(5, adresse);
            preparedStatement.setString(6, profession);
            preparedStatement.setString(7, personnalite);
            preparedStatement.setBoolean(8, exempter_taxe);
            preparedStatement.setLong(9, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void removeSouscripteur(long id) {
        String req = "DELETE FROM souscripteurs WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Souscripteur getSouscripteur(long id) {
        String req = "SELECT * FROM souscripteurs WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Souscripteur(resultSet.getLong("id"), resultSet.getString("numero_assure"), resultSet.getString("nom_prenom"), resultSet.getString("type_piece"), resultSet.getString("numero_piece"), resultSet.getString("adresse"), resultSet.getString("profession"), resultSet.getString("personnalite"), resultSet.getBoolean("exempter_taxe"));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public Souscripteur getSouscripteur(String numero_assure) {
        String req = "SELECT * FROM souscripteurs WHERE numero_assure = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, numero_assure);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Souscripteur(resultSet.getLong("id"), resultSet.getString("numero_assure"), resultSet.getString("nom_prenom"), resultSet.getString("type_piece"), resultSet.getString("numero_piece"), resultSet.getString("adresse"), resultSet.getString("profession"), resultSet.getString("personnalite"), resultSet.getBoolean("exempter_taxe"));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public long getMaxID() {
        String req = "SELECT MAX(id) AS id_max FROM souscripteurs ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return resultSet.getLong("id_max");
            }
        } catch (SQLException e) {
        }
        return 0;
    }

    public ArrayList<Souscripteur> getSouscripteurs() {
        String req = "SELECT * FROM souscripteurs ";
        try {
            ArrayList<Souscripteur> list = new ArrayList<>();
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Souscripteur(resultSet.getLong("id"), resultSet.getString("numero_assure"), resultSet.getString("nom_prenom"), resultSet.getString("type_piece"), resultSet.getString("numero_piece"), resultSet.getString("adresse"), resultSet.getString("profession"), resultSet.getString("personnalite"), resultSet.getBoolean("exempter_taxe")));
            }
            return list;
        } catch (SQLException e) {
        }
        return null;
    }
}
