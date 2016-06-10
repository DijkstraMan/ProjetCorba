/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RH;

import Util.UserTableModel;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;
import modEntreesSortiesZones.ServiceAuthentification;
import modEntreesSortiesZones.Utilisateur;
import modEntreesSortiesZones.UtilisateurExistant;
import modEntreesSortiesZones.UtilisateurInconnu;

/**
 *
 * @author Fabien
 */
public class FenGestionRH extends javax.swing.JFrame {
    
    private ServiceAuthentification monServAuth;

    /**
     * Creates new form FenGestion
     */
    public FenGestionRH() {
        initComponents();
    }

    public FenGestionRH(ServiceAuthentification servAuth) {
        initComponents();
        monServAuth = servAuth;
        //Récupération des collaborateurs permanents 
        Utilisateur[] lesCollabsPerm = monServAuth.getCollaborateursPermanents();
        //Remplissage et flitrage du tableau
        UserTableModel modelCollabsPerm = new UserTableModel(lesCollabsPerm);
        jTableCollab.setModel(modelCollabsPerm);
        TableRowSorter<UserTableModel> sorter = new TableRowSorter<>(modelCollabsPerm);
        jTableCollab.setRowSorter(sorter);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldMatriculeAjout = new javax.swing.JTextField();
        jTextFieldNomAjout = new javax.swing.JTextField();
        jTextFieldPrenomAjout = new javax.swing.JTextField();
        jTextFieldPhotoAjout = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonAjouter = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldNomModif = new javax.swing.JTextField();
        jTextFieldPrenomModif = new javax.swing.JTextField();
        jTextFieldPhotoModif = new javax.swing.JTextField();
        jButtonModifier = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabelMatriculeModif = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCollab = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Logiciel RH");
        setResizable(false);

        jTabbedPane1.setToolTipText("Ajouter collaborateur permanent");
        jTabbedPane1.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel1.setText("Matricule : ");

        jLabel2.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel2.setText("Nom : ");

        jLabel3.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel3.setText("Prénom : ");

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel4.setText("Photo : ");

        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel5.setText("Mot de passe : ");

        jButtonAjouter.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jButtonAjouter.setText("Ajouter");
        jButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel11.setText("Nouveau collaborateur permanent");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAjouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldMatriculeAjout)
                            .addComponent(jTextFieldNomAjout)
                            .addComponent(jTextFieldPrenomAjout)
                            .addComponent(jTextFieldPhotoAjout)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel11)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldMatriculeAjout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNomAjout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldPrenomAjout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldPhotoAjout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        jTabbedPane1.addTab("Ajouter collaborateur permanent", jPanel1);

        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel6.setText("Matricule : ");

        jLabel7.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel7.setText("Nom : ");

        jLabel8.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel8.setText("Prénom : ");

        jLabel9.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel9.setText("Photo : ");

        jButtonModifier.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jButtonModifier.setText("Modifier");
        jButtonModifier.setEnabled(false);
        jButtonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel12.setText("Modifier un collaborateur permanent");

        jLabelMatriculeModif.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonModifier, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(jTextFieldNomModif)
                            .addComponent(jTextFieldPrenomModif)
                            .addComponent(jTextFieldPhotoModif)
                            .addComponent(jLabelMatriculeModif, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(66, 66, 66))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel12)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabelMatriculeModif, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldNomModif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldPrenomModif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldPhotoModif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );

        jTabbedPane1.addTab("Modifier collaborateur permanent", jPanel2);

        jTableCollab.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTableCollab.setToolTipText("");
        jTableCollab.setFillsViewportHeight(true);
        jTableCollab.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTableCollab.setShowHorizontalLines(false);
        jTableCollab.setShowVerticalLines(false);
        jTableCollab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCollabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCollab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Modifier collaborateur permanent");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("Modifier collaborateur permanent");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableCollabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCollabMouseClicked
        JTable table =(JTable) evt.getSource();
        Point p = evt.getPoint();
        int row = table.rowAtPoint(p);
        //On vérifie qu'on a bien double-cliqué sur une ligne de contenu
        if (/*evt.getClickCount() == 2 &&*/ row != -1) {
            UserTableModel modelCollabPerm = (UserTableModel) table.getModel();
            Utilisateur usrTemp = modelCollabPerm.getUserAt(row);
            //Remplissage des champs de modification d'un collab :
            jLabelMatriculeModif.setText(usrTemp.matricule);
            jTextFieldNomModif.setText(usrTemp.nomUsr);
            jTextFieldPrenomModif.setText(usrTemp.preUsr);
            jTextFieldPhotoModif.setText(usrTemp.phoUsr);
            jButtonModifier.setEnabled(true);
        }
    }//GEN-LAST:event_jTableCollabMouseClicked

    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
        String matricule = jTextFieldMatriculeAjout.getText();
        String nomUsr = jTextFieldNomAjout.getText();
        String prenomUsr = jTextFieldPrenomAjout.getText();
        String photoUsr = jTextFieldPhotoAjout.getText();
        String pwdUsr = new String(jPasswordField.getPassword());
        try {
            monServAuth.ajouterCollaborateurPerm(matricule, nomUsr, prenomUsr, photoUsr, pwdUsr);
            Utilisateur newUsr = new Utilisateur(matricule, nomUsr, prenomUsr, photoUsr);
            UserTableModel modelCollabPerm = (UserTableModel) jTableCollab.getModel();
            modelCollabPerm.add(newUsr);
        } catch (UtilisateurExistant ex){
            JOptionPane.showMessageDialog(this,
            "Erreur, ce collaborateur permanent existe déjà.",
            "Erreur lors de l'ajout",
            JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButtonAjouterActionPerformed

    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed
        String matricule = jLabelMatriculeModif.getText();
        String nomUsr = jTextFieldNomModif.getText();
        String prenomUsr = jTextFieldPrenomModif.getText();
        String photoUsr = jTextFieldPhotoModif.getText();
        if(matricule != null && !matricule.isEmpty()) {
            try {
                monServAuth.modifierCollaborateurPerm(matricule, nomUsr, prenomUsr, photoUsr);
                Utilisateur newUsr = new Utilisateur(matricule, nomUsr, prenomUsr, photoUsr);
                UserTableModel modelCollabPerm = (UserTableModel) jTableCollab.getModel();
                modelCollabPerm.majAffichage(newUsr);
            } catch (UtilisateurInconnu ex) {
                JOptionPane.showMessageDialog(this,
                "Erreur, ce collaborateur permanent n'existe pas.",
                "Erreur lors de la modification",
                JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_jButtonModifierActionPerformed

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
            java.util.logging.Logger.getLogger(FenGestionRH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenGestionRH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenGestionRH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenGestionRH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FenGestionRH().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMatriculeModif;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableCollab;
    private javax.swing.JTextField jTextFieldMatriculeAjout;
    private javax.swing.JTextField jTextFieldNomAjout;
    private javax.swing.JTextField jTextFieldNomModif;
    private javax.swing.JTextField jTextFieldPhotoAjout;
    private javax.swing.JTextField jTextFieldPhotoModif;
    private javax.swing.JTextField jTextFieldPrenomAjout;
    private javax.swing.JTextField jTextFieldPrenomModif;
    // End of variables declaration//GEN-END:variables
}
