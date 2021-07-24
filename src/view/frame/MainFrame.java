/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.frame;

import java.awt.EventQueue;
import view.dialog.AdresseDialog;
import view.panel.ConfigurationPanel;
import view.panel.MainPanel;

/**
 *
 * @author ATH
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        mainPanel = new MainPanel();
        initPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_menu_items = new javax.swing.ButtonGroup();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu_item_accueil = new javax.swing.JMenuItem();
        menu_item_compte = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menu_item_deconnecter = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menu_item_mono = new javax.swing.JRadioButtonMenuItem();
        menu_item_flotte = new javax.swing.JRadioButtonMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menu_item_db = new javax.swing.JMenuItem();
        menu_item_saisie = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion des Assurances");
        setMinimumSize(new java.awt.Dimension(1090, 700));

        jMenu1.setText("File");

        menu_item_accueil.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menu_item_accueil.setText("Accueil");
        menu_item_accueil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_accueilActionPerformed(evt);
            }
        });
        jMenu1.add(menu_item_accueil);

        menu_item_compte.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menu_item_compte.setText("Mon compte");
        jMenu1.add(menu_item_compte);
        jMenu1.add(jSeparator1);

        menu_item_deconnecter.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menu_item_deconnecter.setText("Se déconnecter");
        jMenu1.add(menu_item_deconnecter);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edition");
        buttonGroup_menu_items.add(jMenu2);

        buttonGroup_menu_items.add(menu_item_mono);
        menu_item_mono.setSelected(true);
        menu_item_mono.setText("Mono");
        jMenu2.add(menu_item_mono);

        buttonGroup_menu_items.add(menu_item_flotte);
        menu_item_flotte.setText("Flotte");
        jMenu2.add(menu_item_flotte);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Configuration");

        menu_item_db.setText("Base de données");
        menu_item_db.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_dbActionPerformed(evt);
            }
        });
        jMenu3.add(menu_item_db);

        menu_item_saisie.setText("Saisie");
        menu_item_saisie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_saisieActionPerformed(evt);
            }
        });
        jMenu3.add(menu_item_saisie);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menu_item_saisieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_saisieActionPerformed
        setContentPane(new ConfigurationPanel());
        revalidate();
        repaint();
    }//GEN-LAST:event_menu_item_saisieActionPerformed

    private void menu_item_dbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_dbActionPerformed
        AdresseDialog adresseDialog = new AdresseDialog(this, true);
        adresseDialog.setVisible(true);
    }//GEN-LAST:event_menu_item_dbActionPerformed

    private void menu_item_accueilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_accueilActionPerformed
        initPanel();
    }//GEN-LAST:event_menu_item_accueilActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            try {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            } catch (Exception e) {
            }
        });
    }
    private final MainPanel mainPanel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_menu_items;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem menu_item_accueil;
    private javax.swing.JMenuItem menu_item_compte;
    private javax.swing.JMenuItem menu_item_db;
    private javax.swing.JMenuItem menu_item_deconnecter;
    private static javax.swing.JRadioButtonMenuItem menu_item_flotte;
    private static javax.swing.JRadioButtonMenuItem menu_item_mono;
    private javax.swing.JMenuItem menu_item_saisie;
    // End of variables declaration//GEN-END:variables

    private void initPanel() {
        setContentPane(mainPanel);
    }

    public static boolean getMono() {
        return menu_item_mono.isSelected();
    }

    public static boolean getFlotte() {
        return menu_item_flotte.isSelected();
    }
}
