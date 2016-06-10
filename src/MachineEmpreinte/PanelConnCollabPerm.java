/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MachineEmpreinte;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import modEntreesSortiesZones.ServiceAuthentification;
import modEntreesSortiesZones.UtilisateurInconnu;

/**
 *
 * @author Romain
 */
public class PanelConnCollabPerm extends JPanel {
    
    private final ServiceAuthentification mServAuth;
    /**
     * Creates new form PanelTest
     * @param pServAuth
     */
    public PanelConnCollabPerm(ServiceAuthentification pServAuth) {
        initComponents();
        this.mServAuth = pServAuth;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mConCollabPerm = new javax.swing.JLabel();
        FlowPanelConnInfos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        mMatUsrLbl = new javax.swing.JLabel();
        mMatUsrInputField = new javax.swing.JTextField();
        mPwdLbl = new javax.swing.JLabel();
        mPwdField = new javax.swing.JPasswordField();
        FlowPanelConnBtn = new javax.swing.JPanel();
        mConnexionBtn = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        mConCollabPerm.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mConCollabPerm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mConCollabPerm.setText("Connexion collaborateur permanent");
        mConCollabPerm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(mConCollabPerm, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.GridLayout(2, 2));

        mMatUsrLbl.setLabelFor(mMatUsrInputField);
        mMatUsrLbl.setText("Matricule utilisateur :");
        jPanel1.add(mMatUsrLbl);

        mMatUsrInputField.setText("Saisir votre matricule");
        mMatUsrInputField.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel1.add(mMatUsrInputField);

        mPwdLbl.setLabelFor(mPwdField);
        mPwdLbl.setText("Mot de passe :");
        jPanel1.add(mPwdLbl);

        mPwdField.setText("jPasswordField1");
        jPanel1.add(mPwdField);

        FlowPanelConnInfos.add(jPanel1);

        add(FlowPanelConnInfos, java.awt.BorderLayout.CENTER);

        mConnexionBtn.setText("Connexion");
        mConnexionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mConnexionBtnActionPerformed(evt);
            }
        });
        FlowPanelConnBtn.add(mConnexionBtn);

        add(FlowPanelConnBtn, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void mConnexionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mConnexionBtnActionPerformed
        String lMatCollabPerm = mMatUsrInputField.getText();
        String lPwdCollabPerm = String.valueOf(mPwdField.getPassword());
        
        try {
            if(mServAuth.verifierAuthentificationMachineEmpreinteCollaborateurPerm(lMatCollabPerm, lPwdCollabPerm)) {
                this.setVisible(false);
            }             
        } catch (UtilisateurInconnu ex) {
            Logger.getLogger(FenConnexionCollab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mConnexionBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FlowPanelConnBtn;
    private javax.swing.JPanel FlowPanelConnInfos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mConCollabPerm;
    private javax.swing.JButton mConnexionBtn;
    private javax.swing.JTextField mMatUsrInputField;
    private javax.swing.JLabel mMatUsrLbl;
    private javax.swing.JPasswordField mPwdField;
    private javax.swing.JLabel mPwdLbl;
    // End of variables declaration//GEN-END:variables
}
