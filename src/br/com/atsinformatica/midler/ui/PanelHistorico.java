/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.ui;

/**
 *
 * @author AlexsanderPimenta
 */
public class PanelHistorico extends javax.swing.JPanel {

    /**
     * Creates new form PanelHistorico
     */
    public PanelHistorico() {
        initComponents();
        // jToolBar1.setFloatable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        guia_sincronizar = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        scroll_tabela_historico = new javax.swing.JScrollPane();
        tabela_historico = new javax.swing.JTable();
        btn_sincronizar = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        scroll_tabela_historico2 = new javax.swing.JScrollPane();
        tabela_historico2 = new javax.swing.JTable();
        btn_refresh2 = new javax.swing.JButton();
        title_historico = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jPanel1.setMinimumSize(new java.awt.Dimension(300, 288));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 288));

        tabela_historico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tipo", "Nome", "Servidor", "Sincronizar?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_historico.setMaximumSize(new java.awt.Dimension(23564, 384));
        tabela_historico.setMinimumSize(new java.awt.Dimension(300, 288));
        tabela_historico.setPreferredSize(new java.awt.Dimension(300, 288));
        tabela_historico.setSurrendersFocusOnKeystroke(true);
        scroll_tabela_historico.setViewportView(tabela_historico);

        btn_sincronizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/icon-synchronize.png"))); // NOI18N
        btn_sincronizar.setToolTipText("Sincronizar");
        btn_sincronizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sincronizarActionPerformed(evt);
            }
        });

        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/refresh.png"))); // NOI18N
        btn_refresh.setToolTipText("Atualizar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll_tabela_historico, javax.swing.GroupLayout.DEFAULT_SIZE, 1161, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_refresh)
                        .addGap(10, 10, 10)
                        .addComponent(btn_sincronizar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sincronizar))
                .addGap(11, 11, 11)
                .addComponent(scroll_tabela_historico, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        guia_sincronizar.addTab("Sincronizador", jPanel1);

        jPanel3.setMinimumSize(new java.awt.Dimension(300, 288));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 288));

        tabela_historico2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tipo", "Nome", "Servidor", "Sincronizado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_historico2.setMaximumSize(new java.awt.Dimension(23564, 384));
        tabela_historico2.setMinimumSize(new java.awt.Dimension(300, 288));
        tabela_historico2.setPreferredSize(new java.awt.Dimension(300, 288));
        scroll_tabela_historico2.setViewportView(tabela_historico2);

        btn_refresh2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/refresh.png"))); // NOI18N
        btn_refresh2.setToolTipText("Atualizar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll_tabela_historico2, javax.swing.GroupLayout.DEFAULT_SIZE, 1161, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 1137, Short.MAX_VALUE)
                        .addComponent(btn_refresh2)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(btn_refresh2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll_tabela_historico2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        guia_sincronizar.addTab("Histórico", jPanel3);

        title_historico.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        title_historico.setText("Fila de sincronização:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(guia_sincronizar, javax.swing.GroupLayout.DEFAULT_SIZE, 1185, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title_historico)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title_historico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guia_sincronizar, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_sincronizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sincronizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_sincronizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_refresh2;
    private javax.swing.JButton btn_sincronizar;
    private javax.swing.JTabbedPane guia_sincronizar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane scroll_tabela_historico;
    private javax.swing.JScrollPane scroll_tabela_historico2;
    private javax.swing.JTable tabela_historico;
    private javax.swing.JTable tabela_historico2;
    private javax.swing.JLabel title_historico;
    // End of variables declaration//GEN-END:variables
}