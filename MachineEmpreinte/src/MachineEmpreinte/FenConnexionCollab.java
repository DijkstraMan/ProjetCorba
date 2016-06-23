/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MachineEmpreinte;

import Util.Fonction;
import javax.swing.JOptionPane;
import modEntreesSortiesZones.ServiceAuthentification;
import modEntreesSortiesZones.ServiceEmpreinte;
import modEntreesSortiesZones.UtilisateurInconnu;

/**
 *
 * @author Romain
 */
public class FenConnexionCollab extends javax.swing.JFrame {

    private final ServiceAuthentification mServAuth;
    private final ServiceEmpreinte mServEmp;
    private final String nomServAuth = "SAUTH";
    private final String nomServEmp = "SEMP";

    /**
     * Creates new form FenConnexionCollab
     */
    public FenConnexionCollab() {
        initComponents();
             
        org.omg.CORBA.Object distantSAuth = Fonction.connexionCorba(nomServAuth);
        mServAuth = modEntreesSortiesZones.ServiceAuthentificationHelper.narrow(distantSAuth);

        org.omg.CORBA.Object distantSEmp = Fonction.connexionCorba(nomServEmp);
        mServEmp = modEntreesSortiesZones.ServiceEmpreinteHelper.narrow(distantSEmp);
        
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ConnMachineEmpLbl = new javax.swing.JLabel();
        TabbedPaneMachineEmp = new javax.swing.JTabbedPane();
        PanelConnPerm = new javax.swing.JPanel();
        mConCollabPerm = new javax.swing.JLabel();
        FlowPanelConnInfos = new javax.swing.JPanel();
        PanelConnPermInfos = new javax.swing.JPanel();
        MatriculePermLbl = new javax.swing.JLabel();
        matriculePermField = new javax.swing.JTextField();
        PwdPermLbl = new javax.swing.JLabel();
        pwdPermField = new javax.swing.JPasswordField();
        FlowPanelConnBtn = new javax.swing.JPanel();
        BtnConnPerm = new javax.swing.JButton();
        PanelConnTemp = new javax.swing.JPanel();
        mConCollabPerm1 = new javax.swing.JLabel();
        FlowPanelConnInfos1 = new javax.swing.JPanel();
        FlowPanelConnTempInfos = new javax.swing.JPanel();
        MatTempLbl = new javax.swing.JLabel();
        matriculeTempField = new javax.swing.JTextField();
        FlowPanelConnTemp = new javax.swing.JPanel();
        BtnConnTemp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ConnMachineEmpLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ConnMachineEmpLbl.setText("Connexion Machine Empreinte");

        PanelConnPerm.setLayout(new java.awt.BorderLayout());

        mConCollabPerm.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mConCollabPerm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mConCollabPerm.setText("Connexion collaborateur permanent");
        mConCollabPerm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PanelConnPerm.add(mConCollabPerm, java.awt.BorderLayout.NORTH);

        PanelConnPermInfos.setLayout(new java.awt.GridLayout(2, 2));

        MatriculePermLbl.setText("Matricule utilisateur :");
        PanelConnPermInfos.add(MatriculePermLbl);

        matriculePermField.setPreferredSize(new java.awt.Dimension(150, 20));
        PanelConnPermInfos.add(matriculePermField);

        PwdPermLbl.setText("Mot de passe :");
        PanelConnPermInfos.add(PwdPermLbl);
        PanelConnPermInfos.add(pwdPermField);

        FlowPanelConnInfos.add(PanelConnPermInfos);

        PanelConnPerm.add(FlowPanelConnInfos, java.awt.BorderLayout.CENTER);

        BtnConnPerm.setText("Connexion");
        BtnConnPerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConnPermActionPerformed(evt);
            }
        });
        FlowPanelConnBtn.add(BtnConnPerm);

        PanelConnPerm.add(FlowPanelConnBtn, java.awt.BorderLayout.SOUTH);

        TabbedPaneMachineEmp.addTab("Collaborateur Permanent", PanelConnPerm);

        PanelConnTemp.setLayout(new java.awt.BorderLayout());

        mConCollabPerm1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mConCollabPerm1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mConCollabPerm1.setText("Connexion collaborateur temporaire");
        mConCollabPerm1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PanelConnTemp.add(mConCollabPerm1, java.awt.BorderLayout.NORTH);

        FlowPanelConnTempInfos.setLayout(new java.awt.GridLayout(1, 2));

        MatTempLbl.setText("Matricule utilisateur :");
        MatTempLbl.setPreferredSize(new java.awt.Dimension(80, 14));
        FlowPanelConnTempInfos.add(MatTempLbl);

        matriculeTempField.setPreferredSize(new java.awt.Dimension(150, 25));
        FlowPanelConnTempInfos.add(matriculeTempField);

        FlowPanelConnInfos1.add(FlowPanelConnTempInfos);

        PanelConnTemp.add(FlowPanelConnInfos1, java.awt.BorderLayout.CENTER);

        BtnConnTemp.setText("Connexion");
        BtnConnTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConnTempActionPerformed(evt);
            }
        });
        FlowPanelConnTemp.add(BtnConnTemp);

        PanelConnTemp.add(FlowPanelConnTemp, java.awt.BorderLayout.SOUTH);

        TabbedPaneMachineEmp.addTab("Collaborateur Temporaire", PanelConnTemp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TabbedPaneMachineEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ConnMachineEmpLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ConnMachineEmpLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabbedPaneMachineEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnConnPermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConnPermActionPerformed
        String lMatCollabPerm = matriculePermField.getText();
        String lPwdCollabPerm = String.valueOf(pwdPermField.getPassword());

        if (lMatCollabPerm != null && lMatCollabPerm.length() > 0) {
            if (lPwdCollabPerm != null && lPwdCollabPerm.length() > 0) {
                try {
                    if (mServAuth.verifierAuthentificationMachineEmpreinteCollaborateurPerm(lMatCollabPerm, lPwdCollabPerm)) {
                        if (mServEmp.verifierEmpreintePermExistante(lMatCollabPerm)) {
                            FenModifEmpreinte fenModif = new FenModifEmpreinte(mServEmp, lMatCollabPerm);
                            this.setVisible(false);
                            fenModif.setVisible(true);
                            fenModif.setLocationRelativeTo(null);
                        } else {
                            FenAjoutEmpreinte fenAjout = new FenAjoutEmpreinte(mServEmp, lMatCollabPerm);
                            this.setVisible(false);
                            fenAjout.setVisible(true);
                            fenAjout.setLocationRelativeTo(null);
                        }
                    }
                } catch (UtilisateurInconnu ex) {
                    JOptionPane.showMessageDialog(this,
                            "Le matricule et le mot de passe saisis ne correspondent pas.",
                            "Erreur combinaison matricule/mot de passe",
                            JOptionPane.ERROR_MESSAGE);
                    resetCollabPermFields();
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Champ de saisie de mot de passe vide. Veuillez saisir votre mot de passe",
                        "Erreur saisie mot de passe",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Champ de saisie de mot de passe vide. Veuillez saisir votre matricule",
                    "Erreur saisie matricule",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnConnPermActionPerformed

    private void BtnConnTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConnTempActionPerformed
        String lMatCollabTemp = matriculeTempField.getText();

        //On vérifie d'abord si le champ de saisie n'est pas vide
        if (lMatCollabTemp != null && lMatCollabTemp.length() > 0) {
            try {
                if (mServAuth.verifierAuthentificationMachineEmpreinteCollaborateurTemp(lMatCollabTemp)) {
                    if (mServEmp.verifierEmpreinteTempExistante(lMatCollabTemp)) {
                        //Le collaborateur ne peut rien faire s'il a déjà ajouté son empreinte
                        JOptionPane.showMessageDialog(this,
                                "Erreur : Vous avez déjà ajouté votre empreinte !",
                                "Erreur ajout empreinte",
                                JOptionPane.ERROR_MESSAGE);
                        resetCollabTempFields();
                    } else {
                        FenAjoutEmpreinte fenAjout = new FenAjoutEmpreinte(mServEmp, lMatCollabTemp);
                        this.setVisible(false);
                        fenAjout.setVisible(true);
                        fenAjout.setLocationRelativeTo(null);
                    }
                }
            } catch (UtilisateurInconnu ex) {
                //Logger.getLogger(FenConnexionCollab.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this,
                        "Le matricule que vous avez saisi n'existe pas !",
                        "Erreur saisie matricule",
                        JOptionPane.ERROR_MESSAGE);
                resetCollabTempFields();
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Veuillez saisir votre matricule",
                    "Erreur saisie matricule",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnConnTempActionPerformed

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
            java.util.logging.Logger.getLogger(FenConnexionCollab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenConnexionCollab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenConnexionCollab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenConnexionCollab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FenConnexionCollab().setVisible(true);        
        });
    }

    private void resetCollabTempFields() {
        matriculeTempField.setText("");
        this.repaint();
        this.revalidate();
    }

    private void resetCollabPermFields() {
        matriculePermField.setText("");
        pwdPermField.setText("");
        this.repaint();
        this.revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnConnPerm;
    private javax.swing.JButton BtnConnTemp;
    private javax.swing.JLabel ConnMachineEmpLbl;
    private javax.swing.JPanel FlowPanelConnBtn;
    private javax.swing.JPanel FlowPanelConnInfos;
    private javax.swing.JPanel FlowPanelConnInfos1;
    private javax.swing.JPanel FlowPanelConnTemp;
    private javax.swing.JPanel FlowPanelConnTempInfos;
    private javax.swing.JLabel MatTempLbl;
    private javax.swing.JLabel MatriculePermLbl;
    private javax.swing.JPanel PanelConnPerm;
    private javax.swing.JPanel PanelConnPermInfos;
    private javax.swing.JPanel PanelConnTemp;
    private javax.swing.JLabel PwdPermLbl;
    private javax.swing.JTabbedPane TabbedPaneMachineEmp;
    private javax.swing.JLabel mConCollabPerm;
    private javax.swing.JLabel mConCollabPerm1;
    private javax.swing.JTextField matriculePermField;
    private javax.swing.JTextField matriculeTempField;
    private javax.swing.JPasswordField pwdPermField;
    // End of variables declaration//GEN-END:variables
}