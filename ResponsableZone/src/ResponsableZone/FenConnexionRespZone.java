/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResponsableZone;

import Util.ComboItem;
import Util.Fonction;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modEntreesSortiesZones.ServiceAuthentification;
import modEntreesSortiesZones.ServiceAuthentificationHelper;
import modEntreesSortiesZones.ServiceAutorisation;
import modEntreesSortiesZones.ServiceAutorisationHelper;
import modEntreesSortiesZones.UtilisateurInconnu;
import modEntreesSortiesZones.Zone;


/**
 *
 * @author Nico
 */
public class FenConnexionRespZone extends javax.swing.JFrame {

    private final String nomCorbaServAuthentification="SAUTH";
    private final String nomCorbaServAutorisation="SAUTO";
    private ServiceAutorisation servAuto;
    public FenConnexionRespZone() {
        
        initComponents();
        jSelectZone.removeAllItems();
        getZoneA();
        setLocationRelativeTo(null);
    }
    
    public final JComboBox<ComboItem> getZoneA()
    {
      
        org.omg.CORBA.Object distantServAuto = Fonction.connexionCorba(nomCorbaServAutorisation);
        servAuto= ServiceAutorisationHelper.narrow(distantServAuto);
        Zone[] lesZones=servAuto.getZone();

        int nbZone=lesZones.length;
        for (int i = 0; i < nbZone; i++) {
            jSelectZone.addItem(new ComboItem(lesZones[i].idZne,lesZones[i].nomZne));
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTMatricule = new javax.swing.JTextField();
        btnValid = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMdp = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jSelectZone = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTMatricule.setText("RZ001");
        jTMatricule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTMatriculeActionPerformed(evt);
            }
        });

        btnValid.setText("Connexion");
        btnValid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidActionPerformed(evt);
            }
        });

        jLabel1.setText("Matricule");

        jLabel2.setText("Mot de passe");

        jMdp.setText("mdpRZ001");

        jLabel3.setText("Nom de la zone");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jTMatricule)
                    .addComponent(jMdp)
                    .addComponent(jSelectZone, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnValid, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(16, 16, 16)
                .addComponent(jMdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSelectZone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnValid)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTMatriculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTMatriculeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTMatriculeActionPerformed

    private void btnValidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidActionPerformed

        try {
            connexionServAuto(jTMatricule.getText(),new String(jMdp.getPassword()),((ComboItem)jSelectZone.getSelectedItem()).getValue(),((ComboItem)jSelectZone.getSelectedItem()).getLabel());
        } catch (UtilisateurInconnu ex) {
            JOptionPane.showMessageDialog(this,
                ex.raison,
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnValidActionPerformed
    
    public void connexionServAuto(String matricule, String mdp, int idZone, String nomZone) throws UtilisateurInconnu
    {
        org.omg.CORBA.Object distantServAuth=Fonction.connexionCorba(nomCorbaServAuthentification);
        ServiceAuthentification servAuth= ServiceAuthentificationHelper.narrow(distantServAuth);
        if(servAuth.verifierAuthentificationLogicielResp(matricule,mdp,idZone))
        {
            FenGestionRespZone fenGest = new FenGestionRespZone(servAuto,idZone,nomZone);
            this.setVisible(false);
            fenGest.setVisible(true);
            fenGest.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        else
        {
            JOptionPane.showMessageDialog(this,
                "Utilisateur non autorisé",
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
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
            java.util.logging.Logger.getLogger(FenConnexionRespZone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenConnexionRespZone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenConnexionRespZone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenConnexionRespZone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FenConnexionRespZone().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnValid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jMdp;
    private javax.swing.JComboBox jSelectZone;
    private javax.swing.JTextField jTMatricule;
    // End of variables declaration//GEN-END:variables
}
