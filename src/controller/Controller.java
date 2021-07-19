/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.ConnectorDB;
import java.sql.Connection;

/**
 *
 * @author ATH
 */
public class Controller {

    private final ClasseController classeController;
    private final GroupeController groupeController;
    private final ZoneController zoneController;
    private final VehiculeMoteurController vehiculeMoteurController;
    private final EnergieController energieController;
    private final MotoMoteurController motoMoteurController;
    private final UsageController usageController;
    private final AutomobileController automobileController;
    private final TarifController tarifController;
    private final SouscripteurController souscripteurController;
    private final TelephoneController telephoneController;
    private final PoliceController policeController;
    private final CompagnieController compagnieController;
    private final CompagnieGarantieController compagnieGarantieController;
    private final GarantieController garantieController;
    private final UserController userController;
    private final DroitController droitController;
    private final Connection connection;

    public Controller() {
        connection = new ConnectorDB().getConnection();
        classeController = new ClasseController(connection);
        energieController = new EnergieController(connection);
        groupeController = new GroupeController(connection);
        vehiculeMoteurController = new VehiculeMoteurController(connection);
        zoneController = new ZoneController(connection);
        motoMoteurController = new MotoMoteurController(connection);
        usageController = new UsageController(connection);
        automobileController = new AutomobileController(connection);
        tarifController = new TarifController(connection);
        souscripteurController = new SouscripteurController(connection);
        telephoneController = new TelephoneController(connection);
        policeController = new PoliceController(connection);
        compagnieController = new CompagnieController(connection);
        compagnieGarantieController = new CompagnieGarantieController(connection);
        garantieController = new GarantieController(connection);
        userController = new UserController(connection);
        droitController = new DroitController(connection);
    }

    public UserController getUserController() {
        return userController;
    }

    public DroitController getDroitController() {
        return droitController;
    }

    public PoliceController getPoliceController() {
        return policeController;
    }

    public CompagnieController getCompagnieController() {
        return compagnieController;
    }

    public CompagnieGarantieController getCompagnieGarantieController() {
        return compagnieGarantieController;
    }

    public GarantieController getGarantieController() {
        return garantieController;
    }

    public SouscripteurController getSouscripteurController() {
        return souscripteurController;
    }

    public TelephoneController getTelephoneController() {
        return telephoneController;
    }

    public TarifController getTarifController() {
        return tarifController;
    }

    public ClasseController getClasseController() {
        return classeController;
    }

    public GroupeController getGroupeController() {
        return groupeController;
    }

    public ZoneController getZoneController() {
        return zoneController;
    }

    public VehiculeMoteurController getVehiculeMoteurController() {
        return vehiculeMoteurController;
    }

    public EnergieController getEnergieController() {
        return energieController;
    }

    public MotoMoteurController getMotoMoteurController() {
        return motoMoteurController;
    }

    public UsageController getUsageController() {
        return usageController;
    }

    public AutomobileController getAutomobileController() {
        return automobileController;
    }

}
