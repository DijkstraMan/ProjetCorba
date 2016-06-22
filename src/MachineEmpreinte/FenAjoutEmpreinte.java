/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MachineEmpreinte;

import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import modEntreesSortiesZones.EmpreinteExistante;
import modEntreesSortiesZones.ServiceEmpreinte;

/**
 *
 * @author Romain
 */
public class FenAjoutEmpreinte extends javax.swing.JFrame {

    private ServiceEmpreinte mServEmp;
    private String mMatricule;
    
    public FenAjoutEmpreinte() {
        initComponents();
    }
    
    /**
     * Creates new form FenAjoutEmpreinte
     *
     * @param pServEmp
     * @param pMatricule
     */
    public FenAjoutEmpreinte(ServiceEmpreinte pServEmp, String pMatricule) {
        initComponents();
        mServEmp = pServEmp;
        mMatricule = pMatricule;
        matriculeUsrLbl.setText(mMatricule);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BtnAjoutEmpreinte = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        empreinteField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        collabInfoLbl = new javax.swing.JLabel();
        matriculeUsrLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Ajouter une empreinte");
        getContentPane().add(jLabel1, java.awt.BorderLayout.NORTH);

        BtnAjoutEmpreinte.setText("Ajouter cette empreinte");
        BtnAjoutEmpreinte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAjoutEmpreinteActionPerformed(evt);
            }
        });
        jPanel3.add(BtnAjoutEmpreinte);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel1.setLayout(new java.awt.GridLayout(3, 1));

        jLabel2.setText("Veuillez entrer votre empreinte :");
        jPanel1.add(jLabel2);
        jPanel1.add(empreinteField);

        jPanel2.add(jPanel1);

        jPanel4.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        collabInfoLbl.setText("Collaborateur matricule :");
        jPanel5.add(collabInfoLbl);
        jPanel5.add(matriculeUsrLbl);

        jPanel4.add(jPanel5, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAjoutEmpreinteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAjoutEmpreinteActionPerformed
        String empreinteAjoutee = empreinteField.getText();
        if ((empreinteAjoutee != null) && (empreinteAjoutee.length() > 0)) {
            //Custom button text
            int confirmationModif = JOptionPane.showConfirmDialog(
                    this,
                    "Etes-vous sûr d'ajouter cette empreinte :\n" + empreinteAjoutee,
                    "Confirmation empreinte",
                    JOptionPane.YES_NO_OPTION);
            if (confirmationModif == JOptionPane.YES_OPTION) {
                try {
                    mServEmp.ajouterEmpreinte(empreinteAjoutee, mMatricule);
                    JOptionPane.showMessageDialog(this, "Votre empreinte a été enregistrée avec succès !\n"
                            + "Cette fenêtre va maintenant se fermer");
                    closeFenAjout();
                } catch (EmpreinteExistante ex) {
                    JOptionPane.showMessageDialog(this, "Cette empreinte existe déjà.",
                            "Erreur empreinte existante",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }//GEN-LAST:event_BtnAjoutEmpreinteActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        closeFenAjout();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenAjoutEmpreinte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenAjoutEmpreinte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenAjoutEmpreinte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenAjoutEmpreinte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenAjoutEmpreinte().setVisible(true);
            }
        });
    }
    
    private void closeFenAjout(){
        this.setVisible(false);
        dispose();
        FenConnexionCollab.main(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAjoutEmpreinte;
    private javax.swing.JLabel collabInfoLbl;
    private javax.swing.JTextField empreinteField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel matriculeUsrLbl;
    // End of variables declaration//GEN-END:variables
}
