/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.ui;

import br.com.atsinformatica.erp.dao.ListaPedidoDAO;
import br.com.atsinformatica.erp.entity.ListaPedidoERPBean;
import br.com.atsinformatica.midler.ui.PanelListaPedidos;
import br.com.atsinformatica.prestashop.controller.OrderCarriersTrackingNumberController;
import br.com.atsinformatica.prestashop.controller.OrderController;
import br.com.atsinformatica.utils.Funcoes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author kennedimalheiros
 */
public class InformacoesEnvioPedido extends javax.swing.JDialog {

    /**
     * Creates new form InformacoesEnvioPedido
     */
    public InformacoesEnvioPedido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    public InformacoesEnvioPedido(java.awt.Frame parent, boolean modal, String codPedidoResulth, String codPedidoEcom) {
        super(parent, modal);
        initComponents();
        this.lCodPedidoResulth.setText(codPedidoResulth);
        this.codPedidoResulth = codPedidoResulth;
        this.codPedidoEcom = codPedidoEcom;

    }
    private String codPedidoResulth;
    private String codPedidoEcom;
    private static Logger logger = Logger.getLogger(PanelListaPedidos.class);
//    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
//    Date date = new Date();
//    dateFormat.format(date)

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tCodigoRastreio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        bCancelar = new javax.swing.JButton();
        bConfirmar = new javax.swing.JButton();
        lCodPedidoResulth = new javax.swing.JLabel();
        jDataEnvioPedidoEcom = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informações do Envio do Pedido.");
        setModal(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código do Pedido:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Código de rastreio:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data Envio:");

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        bConfirmar.setText("Confirmar");
        bConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConfirmarActionPerformed(evt);
            }
        });

        lCodPedidoResulth.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lCodPedidoResulth.setText("0000000000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(tCodigoRastreio, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lCodPedidoResulth)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jDataEnvioPedidoEcom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lCodPedidoResulth))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tCodigoRastreio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataEnvioPedidoEcom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancelar)
                    .addComponent(bConfirmar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConfirmarActionPerformed
        int yes;
        yes = JOptionPane.showConfirmDialog(null, "Deseja alterar o status do pedido para (Enviado)?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (yes == JOptionPane.YES_OPTION) {
            statusEnviado(codPedidoEcom, codPedidoResulth, tCodigoRastreio.getText(), new Date(jDataEnvioPedidoEcom.getDate().getTime()));
        }
        //Fechando a janela.
        this.dispose();

    }//GEN-LAST:event_bConfirmarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(InformacoesEnvioPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacoesEnvioPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacoesEnvioPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacoesEnvioPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InformacoesEnvioPedido dialog = new InformacoesEnvioPedido(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bConfirmar;
    private org.jdesktop.swingx.JXDatePicker jDataEnvioPedidoEcom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JLabel lCodPedidoResulth;
    private javax.swing.JTextField tCodigoRastreio;
    // End of variables declaration//GEN-END:variables

    public void statusEnviado(String codPedidoEcom, String codPedidoResulth, String codRastreiamento, Date dataEnvioPedidoEcom) {
        try {
            ListaPedidoERPBean listaPedidoERPBean = new ListaPedidoERPBean();
            listaPedidoERPBean.setCodPedidoResulth(Integer.valueOf(codPedidoResulth));
            listaPedidoERPBean.setCodPedidoEcom(Integer.valueOf(codPedidoEcom));
            listaPedidoERPBean.setCodRastreiaEcom(codRastreiamento);
            listaPedidoERPBean.setDataEnvioPedidoEcom(dataEnvioPedidoEcom);

            ListaPedidoDAO listaPedidoDAO = new ListaPedidoDAO();
            if (listaPedidoDAO.validacaoStatusEnviado(listaPedidoERPBean)) {
                if (listaPedidoDAO.StatusEnviado(listaPedidoERPBean)) {
                    //Iniciando - Alterando Status na loja prestashop
                    OrderController orderController = new OrderController();
                    orderController.updateStatusOrder(Integer.valueOf(codPedidoEcom), 4, codRastreiamento);
                    //Fim - Alterando Status na loja prestashop                         
                   //Iniciando - Alterando Codigo Rastreamento 
                    OrderCarriersTrackingNumberController carriersTrackingNumberController = new OrderCarriersTrackingNumberController();
                    carriersTrackingNumberController.updateOrderCarriersTrackingNumber(Integer.valueOf(codPedidoEcom), codRastreiamento);
                    //FIM - Alterando Codigo Rastreamento
                    JOptionPane.showMessageDialog(null, "Status (Enviado) do pedido alterado com sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Esse pedido não pode ser alterado o status!");
            }

        } catch (Exception e) {
            logger.error("Erro ao mudar status do pedidos para (Enviado): " + e);
        }
    }

}
