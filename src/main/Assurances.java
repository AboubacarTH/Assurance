/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bean.User;
import com.formdev.flatlaf.FlatLightLaf;
import controller.Controller;
import database.ConnectorLite;
import java.sql.Connection;
import javax.swing.UIManager;
import view.frame.MainFrame;

/**
 *
 * @author ATH
 */
public class Assurances {

    /**
     * @param args the command line arguments
     */
    private static Controller controller;
    private static Connection connection;
    private static User user;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        UIManager.put("Component.arrowType", "triangle");
        // UIManager.put( "Button.arc", 999 );
        UIManager.put("Button.arc", 0);
        UIManager.put("Component.arc", 999);
        UIManager.put("ProgressBar.arc", 999);
        //UIManager.put("TextComponent.arc", 999);
        connection = new ConnectorLite().getConnection();
        controller = new Controller();
        user = controller.getUserController().getUser("boube");
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }

    public static Controller getController() {
        return controller;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Assurances.user = user;
    }

}
