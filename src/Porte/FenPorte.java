/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Porte;

import Accueil.FenConnexionAccueil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modEntreesSortiesZones.AutorisationInconnue;
import modEntreesSortiesZones.EmpreinteInconnue;
import modEntreesSortiesZones.ServiceAuthentification;
import modEntreesSortiesZones.ServiceAutorisation;
import modEntreesSortiesZones.ServiceEmpreinte;
import modEntreesSortiesZones.Utilisateur;
import modEntreesSortiesZones.UtilisateurInconnu;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 *
 * @author Fabien
 */
public class FenPorte extends javax.swing.JFrame {

    private final ServiceAuthentification monServAuth;
    private final ServiceAutorisation monServAuto;
    private final int idPorte;
    private final int idZone;
    /**
     * Creates new form FenPorte
     */
    public FenPorte(ServiceAuthentification monServAuth, ServiceAutorisation monServAuto, int idPorte, int idZone) {
        initComponents();
        this.monServAuth = monServAuth;
        this.monServAuto = monServAuto;
        this.idPorte = idPorte;
        this.idZone = idZone;
        jLabelPorteZone.setText("Porte " + idPorte + " / Accès zone " + idZone);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelPorteZone = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPhoto = new javax.swing.JTextField();
        jTextFieldEmpreinte = new javax.swing.JTextField();
        jButtonValider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelPorteZone.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabelPorteZone.setText("Porte  / Accès zone ");

        jLabel2.setText("Photo : ");

        jLabel3.setText("Empreinte :");

        jButtonValider.setText("Valider");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPorteZone)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonValider, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldEmpreinte, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                .addComponent(jTextFieldPhoto)))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabelPorteZone)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldEmpreinte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonValider)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        try {
            Utilisateur usr = monServAuth.verifierAuthentificationPorte(jTextFieldEmpreinte.getText(), jTextFieldPhoto.getText(), idZone);
            if(monServAuto.verifierAutorisation(usr.matricule, idZone))
                JOptionPane.showMessageDialog(this,
                "Bienvenue " + usr.preUsr + " " +usr.nomUsr);    
        } catch (UtilisateurInconnu ex) {
            JOptionPane.showMessageDialog(this,
            "Accès interdit : vous n'êtes pas reconnu.",
            "Erreur lors de la prise de la photo",
            JOptionPane.ERROR_MESSAGE);
        } catch (EmpreinteInconnue ex) {
            JOptionPane.showMessageDialog(this,
            "Accès interdit : votre empreinte n'est pas reconnue.",
            "Erreur d'empreinte",
            JOptionPane.ERROR_MESSAGE);
        } catch (AutorisationInconnue ex) {
            JOptionPane.showMessageDialog(this,
            "Accès interdit : vous n'avez pas l'autorisation d'accèder à cette zone",
            "Erreur d'autorisation",
            JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonValiderActionPerformed

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
            java.util.logging.Logger.getLogger(FenPorte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenPorte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenPorte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenPorte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                // Intialisation de l'orb
                org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
                // Recuperation du naming service
                NamingContext nameRoot =
                        org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
                // SERVICE AUTHENTIFICATION
                // ************************
                // Nom de l'objet
                String idObj = "SAUTH";
                // Construction du nom a rechercher
                org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
                nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");
                // Recherche aupres du naming service
                org.omg.CORBA.Object distantSAuth = nameRoot.resolve(nameToFind);
                // Casting de l'objet CORBA au type ServiceAuthentification
                ServiceAuthentification monSAuth = modEntreesSortiesZones.ServiceAuthentificationHelper.narrow(distantSAuth);
                
                // SERVICE AUTORISATION
                // ************************
                // Nom de l'objet
                idObj = "SAUTO";
                // Construction du nom a rechercher
                nameToFind = new org.omg.CosNaming.NameComponent[1];
                nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");
                // Recherche aupres du naming service
                org.omg.CORBA.Object distantSAuto = nameRoot.resolve(nameToFind);
                // Casting de l'objet CORBA au type ServiceAuthentification
                ServiceAutorisation monSAuto= modEntreesSortiesZones.ServiceAutorisationHelper.narrow(distantSAuto);
                
                // Appel de l'interface graphique
                int idPorte = Integer.parseInt(args[0]);
                /*int idZone = monSAuto.getZone(idPorte);
                FenPorte myFen = new FenPorte(monSAuth, monSAuto, idPorte, idZone);
                myFen.setVisible(true);
                myFen.setLocationRelativeTo(null);*/
            }
            catch (InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName e) {
                Logger.getLogger(FenConnexionAccueil.class.getName()).log(Level.SEVERE, null, e);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonValider;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelPorteZone;
    private javax.swing.JTextField jTextFieldEmpreinte;
    private javax.swing.JTextField jTextFieldPhoto;
    // End of variables declaration//GEN-END:variables
}
