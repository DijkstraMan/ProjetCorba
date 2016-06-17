/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResponsableZone;

import Util.AutorisationPermModel;
import Util.AutorisationTempModel;
import java.awt.Point;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;
import modEntreesSortiesZones.AutorisationExistante;
import modEntreesSortiesZones.AutorisationInconnue;
import modEntreesSortiesZones.AutorisationPerm;
import modEntreesSortiesZones.AutorisationTemp;
import modEntreesSortiesZones.ServiceAutorisation;

/**
 *
 * @author Fabien
 */
public class FenGestionRespZone extends javax.swing.JFrame {
    private final ServiceAutorisation monServAuto;
    private final int idZone;
    /**
     * Creates new form FenGestion
     * @param servAuto
     */

    /**
     * Creates new form FenGestion
     * @param servAuto
     * @param idZ
     */
    public FenGestionRespZone(ServiceAutorisation servAuto, int idZ) {
        initComponents();
        monServAuto = servAuto;
        idZone =idZ;
        //Récupération des autorisation
        AutorisationPerm[] lesAutorisationPerm = monServAuto.getAutorisationPerm();
        AutorisationTemp[] lesAutorisationTemp = monServAuto.getAutorisationTemp();
        //Remplissage et flitrage des tableau
        AutorisationPermModel modelAutorisationPerm = new AutorisationPermModel(lesAutorisationPerm);
        jTablePerm.setModel(modelAutorisationPerm);
        TableRowSorter<AutorisationPermModel> sorter = new TableRowSorter<>(modelAutorisationPerm);
        jTablePerm.setRowSorter(sorter);


        AutorisationTempModel modelAutorisationTemp = new AutorisationTempModel(lesAutorisationTemp);
        jTableTemp.setModel(modelAutorisationTemp);
        TableRowSorter<AutorisationTempModel> sorterTemp = new TableRowSorter<>(modelAutorisationTemp);
        jTableTemp.setRowSorter(sorterTemp);
        jButtonModifier.setEnabled(false);
        jButtonSupprimer.setEnabled(false);
        
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldMatriculeAjout = new javax.swing.JTextField();
        jButtonAjouter = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jDateDebut = new org.jdesktop.swingx.JXDatePicker();
        jDateFin = new org.jdesktop.swingx.JXDatePicker();
        jHrsDebut = new javax.swing.JFormattedTextField();
        jHrsFin = new javax.swing.JFormattedTextField();
        jpanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jDateDebutModif = new org.jdesktop.swingx.JXDatePicker();
        jDateFinModif = new org.jdesktop.swingx.JXDatePicker();
        jHrsDebutModif = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jHrsFinModif = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButtonModifier = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabelModif = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonSupprimer = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jMatSuppr = new javax.swing.JLabel();
        jHrsDebutSuppr = new javax.swing.JLabel();
        jHrsFinSuppr = new javax.swing.JLabel();
        jDateDebutSuppr = new javax.swing.JLabel();
        jDateFinSuppr = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTemp = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePerm = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Logiciel RH");
        setResizable(false);

        jTabbedPane1.setToolTipText("Ajouter collaborateur permanent");
        jTabbedPane1.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel1.setText("Matricule : ");

        jLabel2.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel2.setText("Heure début");

        jLabel3.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel3.setText("Heure fin");

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel4.setText("Date début");

        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel5.setText("Date fin");

        jButtonAjouter.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jButtonAjouter.setText("Ajouter");
        jButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel11.setText("Nouvelle autorisation");

        try {
            jHrsDebut.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jHrsFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAjouter, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(jTextFieldMatriculeAjout)
                            .addComponent(jDateDebut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jHrsDebut, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jHrsFin, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel11))
                .addContainerGap(83, Short.MAX_VALUE))
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
                    .addComponent(jHrsDebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jHrsFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jDateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jDateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        jTabbedPane1.addTab("Ajouter autorisation", jPanel1);

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel14.setText("Modifier une autorisation");

        try {
            jHrsDebutModif.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel15.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel15.setText("Matricule : ");

        try {
            jHrsFinModif.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel16.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel16.setText("Heure début");

        jLabel17.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel17.setText("Heure fin");

        jLabel18.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel18.setText("Date début");

        jLabel19.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel19.setText("Date fin");

        jButtonModifier.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jButtonModifier.setText("Modifier");
        jButtonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanelLayout = new javax.swing.GroupLayout(jpanel);
        jpanel.setLayout(jpanelLayout);
        jpanelLayout.setHorizontalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelLayout.createSequentialGroup()
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonModifier, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(jDateDebutModif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateFinModif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jHrsDebutModif, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jHrsFinModif, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(jLabelModif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel14))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jpanelLayout.setVerticalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel14)
                .addGap(27, 27, 27)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel20)
                    .addComponent(jLabelModif))
                .addGap(23, 23, 23)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jHrsDebutModif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jHrsFinModif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jDateDebutModif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jDateFinModif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        jTabbedPane1.addTab("Modifier autorisation", jpanel);

        jButtonSupprimer.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jButtonSupprimer.setText("Supprimer");
        jButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel21.setText("Supprimer une autorisation");

        jLabel22.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel22.setText("Matricule : ");

        jLabel23.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel23.setText("Heure début");

        jLabel24.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel24.setText("Heure fin");

        jLabel25.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel25.setText("Date début");

        jLabel26.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel26.setText("Date fin");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSupprimer, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(jMatSuppr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jHrsDebutSuppr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jHrsFinSuppr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateDebutSuppr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateFinSuppr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel21))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel21)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jMatSuppr))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jHrsDebutSuppr))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jHrsFinSuppr))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jDateDebutSuppr))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jDateFinSuppr))
                .addGap(18, 18, 18)
                .addComponent(jButtonSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Supprimer autorisation", jPanel2);

        jTableTemp.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTableTemp.setToolTipText("");
        jTableTemp.setFillsViewportHeight(true);
        jTableTemp.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTableTemp.setShowHorizontalLines(false);
        jTableTemp.setShowVerticalLines(false);
        jTableTemp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTempMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTemp);

        jTablePerm.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTablePerm.setToolTipText("");
        jTablePerm.setFillsViewportHeight(true);
        jTablePerm.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTablePerm.setShowHorizontalLines(false);
        jTablePerm.setShowVerticalLines(false);
        jTablePerm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePermMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePerm);

        jLabel10.setText("Autorisations permanentes");

        jLabel13.setText("Autorisations temporaires");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(471, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(249, Short.MAX_VALUE)))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Modifier collaborateur permanent");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("Modifier collaborateur permanent");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableTempMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTempMouseClicked
        JTable table =(JTable) evt.getSource();
        Point p = evt.getPoint();
        int row = table.rowAtPoint(p);
        if ( row != -1) {
            try {
                AutorisationTempModel modelTemp = (AutorisationTempModel) table.getModel();
                AutorisationTemp autTemp = modelTemp.getAutoTempAt(row);
                //Remplissage des champs de modification d'une autorisation :
                jLabelModif.setText(autTemp.matricule);
                jHrsDebutModif.setText(getHeureFromDate(autTemp.jourDebut));
                jHrsFinModif.setText(getHeureFromDate(autTemp.jourFin));
                jDateDebutModif.setDate(getJourFromDate(autTemp.jourDebut));
                jDateFinModif.setDate(getJourFromDate(autTemp.jourFin));
                
                //Remplissage des champs de suppression d'une autorisation :
                jMatSuppr.setText(autTemp.matricule);
                jHrsDebutSuppr.setText(getHeureFromDate(autTemp.jourDebut));
                jHrsFinSuppr.setText(getHeureFromDate(autTemp.jourFin));
                jDateDebutSuppr.setText(autTemp.jourDebut);
                jDateFinSuppr.setText(autTemp.jourFin);
                
                jButtonModifier.setEnabled(true);
                jButtonSupprimer.setEnabled(true);
                
                jDateDebutModif.setEnabled(true);
                jDateFinModif.setEnabled(true);
            } catch (ParseException ex) {
                Logger.getLogger(FenGestionRespZone.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTableTempMouseClicked
    
    public String getHeureFromDate(String date) throws ParseException
    {
        DateFormat formatFR = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        DateFormat formatHeure = new SimpleDateFormat("HH:mm");
        return formatHeure.format(formatFR.parse(date));
    }
    
    public Date getJourFromDate(String date) throws ParseException
    {
        DateFormat formatFR = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        Calendar cal = Calendar.getInstance();
        cal.setTime(formatFR.parse(date));
        return cal.getTime();
    }
    
    private String setDateFormatFR(Date date, int hrs, int min)
    {
        DateFormat formatFR = new SimpleDateFormat("MM/dd/yyyy HH:mm");         
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY,hrs);
        cal.set(Calendar.MINUTE,min);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);
        return formatFR.format(cal.getTime());
    }
    
    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
        try{
            String matricule = jTextFieldMatriculeAjout.getText();
            String[] tabHrsDebut=jHrsDebut.getText().split(":");
            String[] tabHrsFin=jHrsFin.getText().split(":");
             
            //ajout d'une autorisation temporaire
            if(jDateDebut.getDate()!=null && jDateFin.getDate()!=null)
            {
                String dateDebut = setDateFormatFR(jDateDebut.getDate(), Integer.parseInt(tabHrsDebut[0]), Integer.parseInt(tabHrsDebut[1]));
                String dateFin = setDateFormatFR(jDateFin.getDate(), Integer.parseInt(tabHrsFin[0]), Integer.parseInt(tabHrsFin[1]));
                monServAuto.ajouterAutorisationTemp(matricule, idZone, dateDebut, dateFin);
                AutorisationTemp newAuto = new AutorisationTemp(matricule, Integer.toString(idZone), dateDebut, dateFin);
                AutorisationTempModel modelAutoTemp =  (AutorisationTempModel) jTableTemp.getModel();
                modelAutoTemp.add(newAuto);
            }
            else //ajout d'une autorisation permanente
            {
                int hrsDebut=Integer.parseInt(tabHrsDebut[0]+tabHrsDebut[1]);
                int hrsFin=Integer.parseInt(tabHrsFin[0]+tabHrsFin[1]);
                monServAuto.ajouterAutorisationPerm(matricule, idZone, hrsDebut, hrsFin);
                AutorisationPerm newAuto = new AutorisationPerm(matricule, Integer.toString(idZone), jHrsDebut.getText(), jHrsFin.getText());
                AutorisationPermModel modelAutoPerm =  (AutorisationPermModel) jTablePerm.getModel();
                modelAutoPerm.add(newAuto);
                
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this,
                "Veuillez renseigner les champs d'heures",
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
        } catch (AutorisationExistante ex) {
             JOptionPane.showMessageDialog(this,
                ex.raison,
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAjouterActionPerformed

    private void jTablePermMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePermMouseClicked
        JTable table =(JTable) evt.getSource();
        Point p = evt.getPoint();
        int row = table.rowAtPoint(p);
        if ( row != -1) {
            AutorisationPermModel modelPerm = (AutorisationPermModel) table.getModel();
            AutorisationPerm autPerm = modelPerm.getAutoPermAt(row);
            //Remplissage des champs de modification d'une autorisation :
            jLabelModif.setText(autPerm.matricule);
            jHrsDebutModif.setText(autPerm.hrDebut);
            jHrsFinModif.setText(autPerm.hrFin);
            
            //Remplissage des champs de suppression d'une autorisation :
            jMatSuppr.setText(autPerm.matricule);
            jHrsDebutSuppr.setText(autPerm.hrDebut);
            jHrsFinSuppr.setText(autPerm.hrFin);

            jButtonModifier.setEnabled(true);
            jButtonSupprimer.setEnabled(true);
            
            jDateDebutModif.setDate(null);
            jDateFinModif.setDate(null);
            jDateDebutSuppr.setText("");
            jDateFinSuppr.setText("");
            
            jDateDebutModif.setEnabled(false);
            jDateFinModif.setEnabled(false);
        }
    }//GEN-LAST:event_jTablePermMouseClicked

    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed
        try{
            String matricule = jLabelModif.getText();
            String[] tabHrsDebut=jHrsDebutModif.getText().split(":");
            String[] tabHrsFin=jHrsFinModif.getText().split(":");
             
            //modif d'une autorisation temporaire
            if(jDateDebutModif.getDate()!=null && jDateFinModif.getDate()!=null)
            {
                String dateDebut = setDateFormatFR(jDateDebutModif.getDate(), Integer.parseInt(tabHrsDebut[0]), Integer.parseInt(tabHrsDebut[1]));
                String dateFin = setDateFormatFR(jDateFinModif.getDate(), Integer.parseInt(tabHrsFin[0]), Integer.parseInt(tabHrsFin[1]));
                monServAuto.modifierAutorisationTemp(matricule, idZone, dateDebut, dateFin);
                AutorisationTemp newAuto = new AutorisationTemp(matricule, Integer.toString(idZone), dateDebut, dateFin);
                AutorisationTempModel modelAutoTemp =  (AutorisationTempModel) jTableTemp.getModel();
                modelAutoTemp.majAffichage(newAuto);
            }
            else //modif d'une autorisation permanente
            {
                int hrsDebut=Integer.parseInt(tabHrsDebut[0]+tabHrsDebut[1]);
                int hrsFin=Integer.parseInt(tabHrsFin[0]+tabHrsFin[1]);
                monServAuto.modifierAutorisationPerm(matricule, idZone, hrsDebut, hrsFin);
                AutorisationPerm newAuto = new AutorisationPerm(matricule, Integer.toString(idZone), jHrsDebutModif.getText(), jHrsFinModif.getText());
                AutorisationPermModel modelAutoPerm =  (AutorisationPermModel) jTablePerm.getModel();
                modelAutoPerm.majAffichage(newAuto);
            }
           
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this,
                "Veuillez renseigner les champs d'heures",
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
        } catch (AutorisationInconnue ex) {
            JOptionPane.showMessageDialog(this,
                ex.raison,
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
        try {
            String matricule = jMatSuppr.getText();
            //autorisationTemp
            if(!jDateDebutSuppr.getText().isEmpty())
            {
                monServAuto.supprimerAutorisationTemp(matricule, idZone);
                AutorisationTempModel modelAutoTemp =  (AutorisationTempModel) jTableTemp.getModel();
                modelAutoTemp.delete(jTableTemp.getSelectedRow());
            }
            else //autorisationPerm
            {
                monServAuto.supprimerAutorisationPerm(matricule, idZone);
                AutorisationPermModel modelAutoPerm =  (AutorisationPermModel) jTablePerm.getModel();
                modelAutoPerm.delete(jTablePerm.getSelectedRow());
            }
        } catch (AutorisationInconnue ex) {
            JOptionPane.showMessageDialog(this,
                ex.raison,
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButtonSupprimerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonSupprimer;
    private org.jdesktop.swingx.JXDatePicker jDateDebut;
    private org.jdesktop.swingx.JXDatePicker jDateDebutModif;
    private javax.swing.JLabel jDateDebutSuppr;
    private org.jdesktop.swingx.JXDatePicker jDateFin;
    private org.jdesktop.swingx.JXDatePicker jDateFinModif;
    private javax.swing.JLabel jDateFinSuppr;
    private javax.swing.JFormattedTextField jHrsDebut;
    private javax.swing.JFormattedTextField jHrsDebutModif;
    private javax.swing.JLabel jHrsDebutSuppr;
    private javax.swing.JFormattedTextField jHrsFin;
    private javax.swing.JFormattedTextField jHrsFinModif;
    private javax.swing.JLabel jHrsFinSuppr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelModif;
    private javax.swing.JLabel jMatSuppr;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTablePerm;
    private javax.swing.JTable jTableTemp;
    private javax.swing.JTextField jTextFieldMatriculeAjout;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JPanel jpanel;
    // End of variables declaration//GEN-END:variables
}
