/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResponsableZone;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import modEntreesSortiesZones.SQLERROR;
import modEntreesSortiesZones.ServiceAutorisation;
import modEntreesSortiesZones.ServiceAutorisationHelper;
import modEntreesSortiesZones.Zone;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;


/**
 *
 * @author Nico
 */
public class fenConnexion extends javax.swing.JFrame {

    private final String nomCorbaServAuthentification;
    private final String nomCorbaServAutorisation;
    public fenConnexion() {
        initComponents();
        nomCorbaServAuthentification="CQUOISONNOM?";
        nomCorbaServAutorisation="SAUTH";
        jSelectZone.removeAllItems();
        getZoneA();
    }
    
    public final JComboBox<ComboItem> getZoneA()
    {
        try {
            org.omg.CORBA.Object distantServAuto = connexionCorba(nomCorbaServAutorisation);
            ServiceAutorisation servAuto= ServiceAutorisationHelper.narrow(distantServAuto);
            Zone[] lesZones=servAuto.getZone();
            
            int nbZone=lesZones.length;;
            for (int i = 0; i < nbZone; i++) {
                jSelectZone.addItem(new ComboItem(lesZones[i].idZne,lesZones[i].nomZne));
            }
            return null;
        } catch (SQLERROR ex) {
            System.out.println("lsdhfj");
            Logger.getLogger(fenConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception e){
            System.out.println("JE COMPRENDS PASDJVSDGUFIV");
            e.printStackTrace();
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
       //connexion(jTMatricule.getText(),new String(jMdp.getPassword()),idZone);
    }//GEN-LAST:event_btnValidActionPerformed
    
    public void connexionServAuto(String matricule, String mdp, int idZone)
    {
        /*
        org.omg.CORBA.Object distantServAuth=connexionCorba(String nomCorbaServAuthentification);
        ServiceAuthentification servAuth= ServiceAuthentificationHelper.narrow(distantServAuth);
        if(verifierAuthentificationLogicielResp(matricule,mdp))
        {

        }
        else
        {

        }
        */
        if(true)
        {

        }
        else
        {

        }
    }
    
    public org.omg.CORBA.Object connexionCorba(String nomServiceCorba)
    {
        try {
            String[] args=null;
            // Intialisation de l'orb
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            // Recuperation du naming service
            org.omg.CosNaming.NamingContext nameRoot
                    = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

            // Construction du nom a rechercher
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
            nameToFind[0] = new org.omg.CosNaming.NameComponent(nomServiceCorba, "");

            // Recherche aupres du naming service
            org.omg.CORBA.Object distantServ = nameRoot.resolve(nameToFind);
            System.out.println("Objet '" + nomServiceCorba + "' trouve aupres du service de noms. IOR de l'objet :");
            System.out.println(orb.object_to_string(distantServ));
            
            return distantServ;           
            
        } catch (InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName e) {
            e.printStackTrace();
        }
        return null;
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
            java.util.logging.Logger.getLogger(fenConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fenConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fenConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fenConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new fenConnexion().setVisible(true);
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
