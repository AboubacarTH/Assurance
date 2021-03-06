/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dialog;

import bean.VehiculeMoteur;
import javax.swing.JOptionPane;
import static main.Assurances.getController;

/**
 *
 * @author ATH
 */
public class VehiculeMoteurDialog extends javax.swing.JDialog {

    /**
     * Creates new form ClasseDialog
     *
     * @param parent
     * @param modal
     */
    public VehiculeMoteurDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initCbEnergie();
    }

    public VehiculeMoteurDialog(java.awt.Frame parent, boolean modal, VehiculeMoteur vehiculeMoteur) {
        super(parent, modal);
        this.vehiculeMoteur = vehiculeMoteur;
        initComponents();
        initCbEnergie();
        textField_puissance.setText(this.vehiculeMoteur.getPuissance());
        combo_energie.setSelectedItem(getController().getEnergieController().getEnergie(this.vehiculeMoteur.getId_energie()).getEnergie());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_cancel = new javax.swing.JButton();
        btn_ok = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        textField_puissance = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        combo_energie = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion Puissances");
        setModal(true);
        setResizable(false);

        btn_cancel.setText("CANCEL");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        btn_ok.setText("OK");
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });

        jLabel1.setText("Puissance");

        jLabel2.setText("Energie");

        combo_energie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 179, Short.MAX_VALUE)
                        .addComponent(btn_ok)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textField_puissance)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(combo_energie, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textField_puissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(combo_energie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancel)
                    .addComponent(btn_ok))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
        ajouter_zone();
    }//GEN-LAST:event_btn_okActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            VehiculeMoteurDialog dialog = new VehiculeMoteurDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    private VehiculeMoteur vehiculeMoteur;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_ok;
    private javax.swing.JComboBox<String> combo_energie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField textField_puissance;
    // End of variables declaration//GEN-END:variables
    private void ajouter_zone() {
        if (textField_puissance.getText().isBlank() || combo_energie.getSelectedIndex() < 0) {
            warning_information();
            return;
        }

        if (vehiculeMoteur == null) {
            if (getController().getVehiculeMoteurController().getVehiculeMoteur(textField_puissance.getText()) != null) {
                erreur_information();
                return;
            }
            getController().getVehiculeMoteurController().addVehiculeMoteur(textField_puissance.getText(), getController().getEnergieController().getEnergie(combo_energie.getSelectedItem().toString()).getId());
        } else {
            getController().getVehiculeMoteurController().updateVehiculeMoteur(vehiculeMoteur.getId(), textField_puissance.getText(), getController().getEnergieController().getEnergie(combo_energie.getSelectedItem().toString()).getId());
        }
        success_information();
        dispose();
    }

    private void initCbEnergie() {
        combo_energie.removeAllItems();
        getController().getEnergieController().getEnergies().forEach((e) -> {
            combo_energie.addItem(e.getEnergie());
        });
    }

    private void success_information() {
        JOptionPane.showMessageDialog(this, "Op??ration effectu??e avec success ", "R??ussie !", JOptionPane.INFORMATION_MESSAGE);
    }

    private void warning_information() {
        JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs ", "Champ vide ou manquant !", JOptionPane.WARNING_MESSAGE);
    }

    private void erreur_information() {
        JOptionPane.showMessageDialog(this, "Veuillez mettre de nouvelles donn??es ", "Champ existant ou erron?? !", JOptionPane.ERROR_MESSAGE);
    }
}
