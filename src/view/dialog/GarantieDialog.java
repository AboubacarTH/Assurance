/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dialog;

import bean.Garantie;
import javax.swing.JOptionPane;
import static main.Assurances.getController;

/**
 *
 * @author ATH
 */
public class GarantieDialog extends javax.swing.JDialog {

    /**
     * Creates new form ClasseDialog
     *
     * @param parent
     * @param modal
     */
    public GarantieDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public GarantieDialog(java.awt.Frame parent, boolean modal, Garantie garantie) {
        super(parent, modal);
        this.garantie = garantie;
        initComponents();
        textField_garantie.setText(this.garantie.getGarantie());
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
        textField_garantie = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion Garanties");
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

        jLabel1.setText("Garantie");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 254, Short.MAX_VALUE)
                        .addComponent(btn_ok)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cancel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(textField_garantie)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textField_garantie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        ajouter_garantie();
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
            GarantieDialog dialog = new GarantieDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    private Garantie garantie;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_ok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField textField_garantie;
    // End of variables declaration//GEN-END:variables
    private void ajouter_garantie() {
        if (textField_garantie.getText().isBlank()) {
            warning_information();
            return;
        }
        if (garantie == null) {
            if (getController().getGarantieController().getGarantie(textField_garantie.getText()) != null) {
                erreur_information();
                return;
            }
            getController().getGarantieController().addGarantie(textField_garantie.getText());
        } else {
            getController().getGarantieController().updateGarantie(garantie.getId(), textField_garantie.getText());
        }
        success_information();
        dispose();
    }

    private void success_information() {
        JOptionPane.showMessageDialog(this, "Opération effectuée avec success ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }

    private void warning_information() {
        JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs ", "Champ vide ou manquant !", JOptionPane.WARNING_MESSAGE);
    }

    private void erreur_information() {
        JOptionPane.showMessageDialog(this, "Veuillez mettre de nouvelles données ", "Champ existant ou erroné !", JOptionPane.ERROR_MESSAGE);
    }
}
