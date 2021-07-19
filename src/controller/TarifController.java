/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Moto;
import bean.Tarif;
import bean.Vehicule;
import java.sql.Connection;
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
public class TarifController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final VehiculeController vehiculeController;
    private final MotoController motoController;

    public TarifController(Connection connection) {
        this.connection = connection;
        vehiculeController = new VehiculeController(connection);
        motoController = new MotoController(connection);
    }

    public long getMaxID() {
        try {
            String req = "SELECT MAX(id) AS id_max FROM tarifs ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return resultSet.getLong("id_max");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TarifController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void addTarif(long id_classe, long id_groupe, long id_zone, long id_usage, double tarif, Vehicule vehicule) {
        try {
            String req = "INSERT INTO tarifs(id_classe, id_groupe, id_zone, id_usage, tarif) VALUES (?, ?, ?, ?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_classe);
            preparedStatement.setLong(2, id_groupe);
            preparedStatement.setLong(3, id_zone);
            preparedStatement.setLong(4, id_usage);
            preparedStatement.setDouble(5, tarif);
            preparedStatement.executeUpdate();
            vehiculeController.addVehicule(getMaxID(), vehicule.getId_puissance());
        } catch (SQLException ex) {
            Logger.getLogger(TarifController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addTarif(long id_classe, long id_groupe, long id_zone, long id_usage, double tarif, Moto moto) {
        try {
            String req = "INSERT INTO tarifs(id_classe, id_groupe, id_zone, id_usage, tarif) VALUES (?, ?, ?, ?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_classe);
            preparedStatement.setLong(2, id_groupe);
            preparedStatement.setLong(3, id_zone);
            preparedStatement.setLong(4, id_usage);
            preparedStatement.setDouble(5, tarif);
            preparedStatement.executeUpdate();
            motoController.addMoto(getMaxID(), moto.getId_puissance());
        } catch (SQLException ex) {
            Logger.getLogger(TarifController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateTarif(long id, long id_classe, long id_groupe, long id_zone, long id_usage, double tarif, Vehicule vehicule) {
        try {
            String req = "UPDATE tarifs SET id_classe = ?, id_groupe = ?, id_zone = ?, id_usage = ?, tarif = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_classe);
            preparedStatement.setLong(2, id_groupe);
            preparedStatement.setLong(3, id_zone);
            preparedStatement.setLong(4, id_usage);
            preparedStatement.setDouble(5, tarif);
            preparedStatement.setLong(6, id);
            preparedStatement.executeUpdate();
            vehiculeController.updateVehicule(id, vehicule.getId_puissance());
        } catch (SQLException ex) {
            Logger.getLogger(TarifController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateTarif(long id, long id_classe, long id_groupe, long id_zone, long id_usage, double tarif, Moto moto) {
        try {
            String req = "UPDATE tarifs SET id_classe = ?, id_groupe = ?, id_zone = ?, id_usage = ?, tarif = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_classe);
            preparedStatement.setLong(2, id_groupe);
            preparedStatement.setLong(3, id_zone);
            preparedStatement.setLong(4, id_usage);
            preparedStatement.setDouble(5, tarif);
            preparedStatement.setLong(6, id);
            preparedStatement.executeUpdate();
            motoController.updateMoto(id, moto.getId_puissance());
        } catch (SQLException ex) {
            Logger.getLogger(TarifController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeTarif(long id) {
        try {
            String req = "DELETE FROM tarifs WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TarifController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Tarif getTarif(long id) {
        try {
            String req = "SELECT * FROM tarifs WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Tarif(resultSet.getLong("id"), resultSet.getLong("id_classe"), resultSet.getLong("id_groupe"), resultSet.getLong("id_zone"), resultSet.getLong("id_usage"), resultSet.getDouble("tarif"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TarifController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Tarif getTarif(long id_classe, long id_groupe, long id_zone, long id_usage, long id_puissance, long id_energie) {
        try {
            String req = "SELECT * FROM tarifs "
                    + "JOIN vehicules ON "
                    + "tarifs.id = vehicules.id "
                    + "JOIN vehicule_moteurs ON "
                    + "vehicules.id_puissance = vehicule_moteurs.id "
                    + "WHERE id_classe = ? "
                    + "AND id_groupe = ? "
                    + "AND id_zone = ? "
                    + "AND id_usage = ? "
                    + "AND id_puissance = ? "
                    + "AND id_energie = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_classe);
            preparedStatement.setLong(2, id_groupe);
            preparedStatement.setLong(3, id_zone);
            preparedStatement.setLong(4, id_usage);
            preparedStatement.setLong(5, id_puissance);
            preparedStatement.setLong(6, id_energie);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Tarif(resultSet.getLong("id"), resultSet.getLong("id_classe"), resultSet.getLong("id_groupe"), resultSet.getLong("id_zone"), resultSet.getLong("id_usage"), resultSet.getDouble("tarif"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TarifController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Tarif getTarif(long id_classe, long id_groupe, long id_zone, long id_usage, long id_puissance) {
        try {
            String req = "SELECT * FROM tarifs "
                    + "JOIN motos ON "
                    + "tarifs.id = motos.id "
                    + "WHERE id_classe = ? "
                    + "AND id_groupe = ? "
                    + "AND id_zone = ? "
                    + "AND id_usage = ? "
                    + "AND id_puissance = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_classe);
            preparedStatement.setLong(2, id_groupe);
            preparedStatement.setLong(3, id_zone);
            preparedStatement.setLong(4, id_usage);
            preparedStatement.setLong(5, id_puissance);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Tarif(resultSet.getLong("id"), resultSet.getLong("id_classe"), resultSet.getLong("id_groupe"), resultSet.getLong("id_zone"), resultSet.getLong("id_usage"), resultSet.getDouble("tarif"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TarifController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Tarif> getTarifs(long id_classe, long id_groupe, long id_zone, long id_usage, long id_puissance, long id_energie, int type) {
        try {
            ArrayList<Tarif> list = new ArrayList<>();
            String req = "SELECT * FROM tarifs ";
            if (type == 1) {
                req += "JOIN vehicules ON "
                        + "tarifs.id = vehicules.id "
                        + "JOIN vehicule_moteurs ON "
                        + "vehicules.id_puissance = vehicule_moteurs.id "
                        + "WHERE tarifs.id > '0' ";
                if (id_puissance != 0) {
                    req += "AND vehicule_moteurs.id = '" + id_puissance + "' ";
                }
                if (id_energie != 0) {
                    req += "AND vehicule_moteurs.id_energie = '" + id_energie + "' ";
                }
            }
            if (type == 2) {
                req += "JOIN motos ON "
                        + "tarifs.id = motos.id "
                        + "WHERE tarifs.id > '0' ";
                if (id_puissance != 0) {
                    req += "AND motos.id_puissance = '" + id_puissance + "' ";
                }
            }
            if (type == 0) {
                req += "WHERE tarifs.id > '0' ";
            }
            if (id_classe != 0) {
                req += "AND tarifs.id_classe = '" + id_classe + "' ";
            }
            if (id_groupe != 0) {
                req += "AND tarifs.id_groupe = '" + id_groupe + "' ";
            }
            if (id_zone != 0) {
                req += "AND tarifs.id_zone = '" + id_zone + "' ";
            }
            if (id_usage != 0) {
                req += "AND tarifs.id_usage = '" + id_usage + "' ";
            }

            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Tarif(resultSet.getLong("id"), resultSet.getLong("id_classe"), resultSet.getLong("id_groupe"), resultSet.getLong("id_zone"), resultSet.getLong("id_usage"), resultSet.getDouble("tarif")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(TarifController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public VehiculeController getVehiculeController() {
        return vehiculeController;
    }

    public MotoController getMotoController() {
        return motoController;
    }

}
