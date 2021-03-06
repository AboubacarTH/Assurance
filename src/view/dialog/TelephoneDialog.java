/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dialog;

import bean.Telephone;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static main.Assurances.getController;

/**
 *
 * @author ATH
 */
public class TelephoneDialog extends javax.swing.JDialog {

    /**
     * Creates new form ClasseDialog
     *
     * @param parent
     * @param modal
     */
    public TelephoneDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public TelephoneDialog(java.awt.Frame parent, boolean modal, Telephone telephone) {
        super(parent, modal);
        this.telephone = telephone;
        initComponents();
        textField_telephone.setText(this.telephone.getTelephone());
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
        textField_telephone = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion Numréros de téléphone");
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

        jLabel1.setText("Numéro de téléphone");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 189, Short.MAX_VALUE)
                        .addComponent(btn_ok)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cancel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(textField_telephone)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textField_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        ajouter_telephone();
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
            TelephoneDialog dialog = new TelephoneDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    private Telephone telephone;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_ok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField textField_telephone;
    // End of variables declaration//GEN-END:variables
    private void ajouter_telephone() {
        if (textField_telephone.getText().isBlank()) {
            warning_information();
            return;
        }
        if (getController().getTelephoneController().getTelephone(textField_telephone.getText()) != null) {
            erreur_information();
            return;
        }
        inserInTable(textField_telephone.getText());
        dispose();
    }

    private void warning_information() {
        JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs ", "Champ vide ou manquant !", JOptionPane.WARNING_MESSAGE);
    }

    private void erreur_information() {
        JOptionPane.showMessageDialog(this, "Veuillez mettre de nouvelles données ", "Champ existant ou erroné !", JOptionPane.ERROR_MESSAGE);
    }

    private void inserInTable(String telephone) {
        DefaultTableModel model = (DefaultTableModel) SouscripteurDialog.getTable_telephone().getModel();
        boolean inicity = true;
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 1).toString().equals(telephone)) {
                inicity = false;
            }
        }
        if (inicity) {
            Object colonne[] = new Object[2];
            colonne[0] = SouscripteurDialog.getTable_telephone().getRowCount() + 1;
            colonne[1] = telephone;
            model.addRow(colonne);
            SouscripteurDialog.getTable_telephone().setModel(model);
        } else {
            erreur_information();
        }

    }

}
