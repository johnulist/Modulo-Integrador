/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.ui;

import br.com.atsinformatica.erp.dao.ListaPedidoDAO;
import br.com.atsinformatica.erp.entity.ListaPedidoERPBean;
import br.com.atsinformatica.midler.components.renderer.DateCellRenderer;
import br.com.atsinformatica.midler.components.renderer.MoneyCellRenderer;
import br.com.atsinformatica.midler.components.renderer.StatusPedidoCellRenderer;
import br.com.atsinformatica.utils.Funcoes;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.table.TableColumn;
import org.apache.log4j.Logger;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

/**
 *
 * @author GregoryPacheco
 */
public class PanelListaPedidos extends javax.swing.JPanel {

    private AnnotationResolver resolver = new AnnotationResolver(ListaPedidoERPBean.class);
    private String fields = "codPedidoResulth,codPedidoEcom,cliente,valor,status,dataPedido,formaPagamento,horaIntegracao";
    private ObjectTableModel objTableModelListaPedido = new ObjectTableModel(resolver, fields);
    private static Logger logger = Logger.getLogger(PanelListaPedidos.class);
    //Linha da Tabela selecionada, vai ser capturada no evento MousePressed
    private int linhaSelecionada = -1;
//            

    /**
     * Creates new form PanelListaPedidos
     */
    public PanelListaPedidos() {
        initComponents();
        carregarGridListaPedido();
        refleshGrid();
        criandoMenuPopUp();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbListaPedido = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jBfechar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        tDtIni = new javax.swing.JFormattedTextField();
        tDtFim = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        btFiltra = new javax.swing.JButton();

        jTbListaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jTbListaPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTbListaPedidoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTbListaPedido);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Listagem de pedidos em aberto");

        jBfechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/door_out.png"))); // NOI18N
        jBfechar.setText("Fechar");
        jBfechar.setToolTipText("Fechar");
        jBfechar.setFocusable(false);
        jBfechar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBfechar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBfechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBfecharActionPerformed(evt);
            }
        });

        jLabel2.setText("Filtragem de pedidos");

        jLabel3.setText("Status:");

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Aguardando confirmação do pagamento", "Pagamento aceito", "Emissão nota fiscal", "Pedido enviado", "Pedido entregue", "Pedido finalizado", "Pedido cancelado", "Pagamento recusado", "Pagamento estornado", "Pedido devolvido" }));
        cbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusActionPerformed(evt);
            }
        });

        jLabel4.setText("Período de:");

        try {
            tDtIni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tDtFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("a");

        btFiltra.setText("Filtra");
        btFiltra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFiltraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tDtIni, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tDtFim, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btFiltra)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tDtIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tDtFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btFiltra)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBfechar)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 997, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)))
                        .addGap(0, 29, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBfechar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBfecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBfecharActionPerformed
        //fecha tudo
        this.removeAll();
        //atualiza ui
        this.updateUI();

        setBorder(null);

    }//GEN-LAST:event_jBfecharActionPerformed

    private void jTbListaPedidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbListaPedidoMousePressed
        //Seleciona a linha no ponto em que o mouse é clicado
        Point point = evt.getPoint();
        linhaSelecionada = jTbListaPedido.rowAtPoint(point);
        //jTbListaPedido.setRowSelectionInterval(linhaSelecionada, linhaSelecionada);


    }//GEN-LAST:event_jTbListaPedidoMousePressed

    private void cbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusActionPerformed
        System.out.println("ss" + cbStatus.getSelectedItem());

    }//GEN-LAST:event_cbStatusActionPerformed

    private void btFiltraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFiltraActionPerformed

        refleshGridFiltros(Funcoes.getCodStatus(cbStatus.getSelectedItem().toString()), null, null);
        
//        //Se for valida entra no IF
//        if ((Funcoes.validarData(tDtIni.getText())) && (Funcoes.validarData(tDtFim.getText()))) {
//
//            System.out.println("Data Valida");
//
//            if ((Funcoes.comparaDatas(new Date(tDtIni.getText()), new Date(tDtFim.getText())))) {
//                System.out.println("nao compara");
//            } else {
//
//            }
//
//        } else {
//            System.out.println("saindo");
//            return;
//        }
//        System.out.println("sss");


    }//GEN-LAST:event_btFiltraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFiltra;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbStatus;
    private javax.swing.JButton jBfechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbListaPedido;
    private javax.swing.JFormattedTextField tDtFim;
    private javax.swing.JFormattedTextField tDtIni;
    // End of variables declaration//GEN-END:variables

    private void carregarGridListaPedido() {
        jTbListaPedido.setModel(objTableModelListaPedido);
        jTbListaPedido.setAutoCreateRowSorter(true);
        objTableModelListaPedido.clear();
        for (int i = 0; i < 19; i++) {
            objTableModelListaPedido.add(null);
        }
        //Fazendo referencia a campo do Grid
        TableColumn colStatus = jTbListaPedido.getColumnModel().getColumn(4);
        TableColumn colDtPedido = jTbListaPedido.getColumnModel().getColumn(5);
        TableColumn colDtIntegracao = jTbListaPedido.getColumnModel().getColumn(7);
        TableColumn colValor = jTbListaPedido.getColumnModel().getColumn(3);

        //Renderizando valores do Grid
        colStatus.setCellRenderer(new StatusPedidoCellRenderer());
        colDtPedido.setCellRenderer(new DateCellRenderer());
        colDtIntegracao.setCellRenderer(new DateCellRenderer());
        colValor.setCellRenderer(new MoneyCellRenderer());

    }

    private void refleshGrid() {
        try {
            objTableModelListaPedido.clear();
            ListaPedidoDAO dao = new ListaPedidoDAO();
            //Lista de Pedidos com Status diferente de Finalizado e Cancelado
            List<ListaPedidoERPBean> listaPedidos = dao.listaTodos();

            if (!listaPedidos.isEmpty()) {
                objTableModelListaPedido.addAll(listaPedidos);
            }

        } catch (Exception e) {
            logger.error("Erro ao caregar lista de pedidos: " + e);
        }
    }

    private void refleshGridFiltros(int codStatus, Date dtIni, Date dtFim) {
        try {
            objTableModelListaPedido.clear();
            ListaPedidoDAO dao = new ListaPedidoDAO();

            List<ListaPedidoERPBean> listaPedidos = dao.listaTodosComFiltro(codStatus, null, null);

            if (!listaPedidos.isEmpty()) {
                objTableModelListaPedido.addAll(listaPedidos);
            }

        } catch (Exception e) {
            logger.error("Erro ao caregar lista de pedidos: " + e);
        }
    }


    public void criandoMenuPopUp() {

        //Declarando MenuPopUp
        JPopupMenu popupMenu = new JPopupMenu();

        //Criando itens do menu
        JMenuItem menuItemFinalizarPedido = new JMenuItem("Finalizar Pedido");
        JMenuItem menuItemCancelarPedido = new JMenuItem("Cancelar Pedido");

        //Criando Menu para sub menu de Status
        JMenu menuAtualizarStatusPedido = new JMenu("Atualizar o status do pedido");

        //Criando menu de status
        JMenuItem SubItemAguardandoConfirmacaoPagamento = new JMenuItem("Aguardando confirmação do pagamento");
        JMenuItem subItemPagamentoRecusado = new JMenuItem("Pagamento recusado");
        JMenuItem subItemPagamentoAceito = new JMenuItem("Pagamento aceito");
        JMenuItem subItemNotaFiscal = new JMenuItem("Nota fiscal");
        JMenuItem subItemEnviado = new JMenuItem("Enviado");
        JMenuItem subItemPagamentoEstornado = new JMenuItem("Pagamento estornado");
        JMenuItem subItemEntregue = new JMenuItem("Entregue");
        JMenuItem subItemPedidoDevolvido = new JMenuItem("Pedido devolvido");

        //Adicionando o menu no subMenu Status
        menuAtualizarStatusPedido.add(SubItemAguardandoConfirmacaoPagamento);
        menuAtualizarStatusPedido.addSeparator();
        menuAtualizarStatusPedido.add(subItemPagamentoRecusado);
        menuAtualizarStatusPedido.addSeparator();
        menuAtualizarStatusPedido.add(subItemPagamentoAceito);
        menuAtualizarStatusPedido.addSeparator();
        menuAtualizarStatusPedido.add(subItemNotaFiscal);
        menuAtualizarStatusPedido.addSeparator();
        menuAtualizarStatusPedido.add(subItemEnviado);
        menuAtualizarStatusPedido.addSeparator();
        menuAtualizarStatusPedido.add(subItemPagamentoEstornado);
        menuAtualizarStatusPedido.addSeparator();
        menuAtualizarStatusPedido.add(subItemEntregue);
        menuAtualizarStatusPedido.addSeparator();
        menuAtualizarStatusPedido.add(subItemPedidoDevolvido);

        //Adicionado o MenuItem no Menu
        popupMenu.add(menuItemFinalizarPedido);
        popupMenu.addSeparator();
        popupMenu.add(menuItemCancelarPedido);
        popupMenu.addSeparator();
        popupMenu.add(menuAtualizarStatusPedido);

        //Adicionando o MenuPopUP na Grid
        jTbListaPedido.setComponentPopupMenu(popupMenu);

        //Crianco ação ao clicar no MenuPopUp (Finalizar Pedido).
        menuItemFinalizarPedido.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int yes;
                yes = JOptionPane.showConfirmDialog(null, "Deseja finalizar o pedido?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (yes == JOptionPane.YES_OPTION) {
                    //Chamdndo a função que finaliza o pedido
                    finalizarPedido();
                }
            }
        });

        //Crianco ação ao clicar no MenuPopUp (Cancelar Pedido).
        menuItemCancelarPedido.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int yes;
                yes = JOptionPane.showConfirmDialog(null, "Deseja cancelar o pedido?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (yes == JOptionPane.YES_OPTION) {
                    //Chamdndo a função
                    cancelarPedido();
                }
            }
        });

        //Criando ação ao clicar no SubMenu (Aguardando confirmação do pagamento)
        SubItemAguardandoConfirmacaoPagamento.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int yes;
                yes = JOptionPane.showConfirmDialog(null, "Deseja alterar o status do pedido para \n(Aguardando confirmação do pagamento)?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (yes == JOptionPane.YES_OPTION) {
                    //Chamdndo a função
                    statusAguadandoPagamento();
                }

            }
        });

        //Criando ação ao clicar no SubMenu (Pagamento Recusado)
        subItemPagamentoRecusado.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int yes;
                yes = JOptionPane.showConfirmDialog(null, "Deseja alterar o status do pedido para (Pagamento Recusado)?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (yes == JOptionPane.YES_OPTION) {

                    statusPagamentoRecusado();
                }
            }
        });

        //Criando ação ao clicar no SubMenu (Pagamento Aceito)
        subItemPagamentoAceito.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int yes;
                yes = JOptionPane.showConfirmDialog(null, "Deseja alterar o status do pedido para (Pagamento aceito)?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (yes == JOptionPane.YES_OPTION) {
                    //Chamdndo a função
                    statusPagamentoAceito();
                }
            }
        });

        //Criando ação ao clicar no SubMenu (Nota Fiscal)
        subItemNotaFiscal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int yes;
                yes = JOptionPane.showConfirmDialog(null, "Deseja alterar o status do pedido para (Nota Fiscal)?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (yes == JOptionPane.YES_OPTION) {
                    //Chamdndo a função
                    statusNotaFiscal();
                }
            }
        });

        //Criando ação ao clicar no SubMenu (Enviado)
        subItemEnviado.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String codPedidoEcom = String.valueOf(jTbListaPedido.getValueAt(linhaSelecionada, 1));
                String codPedidoResulth = String.valueOf(jTbListaPedido.getValueAt(linhaSelecionada, 0));

                InformacoesEnvioPedido janelaInformacoesEnvioPedido = new InformacoesEnvioPedido(null, true, codPedidoResulth, codPedidoEcom);

                //Atualizando Grid
                refleshGrid();
                janelaInformacoesEnvioPedido.setVisible(true);

            }
        });

        //Criando ação ao clicar no SubMenu (Pagamento Estornado)
        subItemPagamentoEstornado.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int yes;
                yes = JOptionPane.showConfirmDialog(null, "Deseja alterar o status do pedido para (Pagamento Estornado)?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (yes == JOptionPane.YES_OPTION) {
                    //Chamdndo a função
                    statusPagamentoEstornado();
                }

            }
        });

        //Criando ação ao clicar no SubMenu (Entregue)
        subItemEntregue.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        String codPedidoEcom = String.valueOf(jTbListaPedido.getValueAt(linhaSelecionada, 1));
                        String codPedidoResulth = String.valueOf(jTbListaPedido.getValueAt(linhaSelecionada, 0));

                        InformacoesEnvioPedido janelaInformacoesEnvioPedido = new InformacoesEnvioPedido(null, true, codPedidoResulth, codPedidoEcom);

                        //Atualizando Grid
                        refleshGrid();
                        janelaInformacoesEnvioPedido.setVisible(true);

                    }
                }
        );

        //Criando ação ao clicar no SubMenu (Pedido devolvido)
        subItemPedidoDevolvido.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        int yes;
                        yes = JOptionPane.showConfirmDialog(null, "Deseja alterar o status do pedido para (Pedido devolvido)?", "Confirmação", JOptionPane.YES_NO_OPTION);
                        if (yes == JOptionPane.YES_OPTION) {
                            //Chamado a função
                            statusPedidoDevolvido();

                        }
                    }
                }
        );

    }

    public void finalizarPedido() {
        try {

            ListaPedidoERPBean listaPedidoERPBean = new ListaPedidoERPBean();
            listaPedidoERPBean.setCodPedidoResulth((int) jTbListaPedido.getValueAt(linhaSelecionada, 0));
            listaPedidoERPBean.setCodPedidoEcom((int) jTbListaPedido.getValueAt(linhaSelecionada, 1));

            listaPedidoERPBean.setDataFinalizacaoPedido(new Date());

            ListaPedidoDAO listaPedidoDAO = new ListaPedidoDAO();
            if (listaPedidoDAO.validacaoFinalizarPedido(listaPedidoERPBean)) {
                if (listaPedidoDAO.finalizarPedido(listaPedidoERPBean)) {
                    //Atualizando Grid
                    refleshGrid();
                    JOptionPane.showMessageDialog(null, "Pedido finalizado com sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Esse pedido não pode ser finalizado!");
            }

        } catch (Exception e) {
            logger.error("Erro ao finalizar pedidos: " + e);
        }
    }

    public void cancelarPedido() {
        try {

            ListaPedidoERPBean listaPedidoERPBean = new ListaPedidoERPBean();
            listaPedidoERPBean.setCodPedidoResulth((int) jTbListaPedido.getValueAt(linhaSelecionada, 0));
            listaPedidoERPBean.setCodPedidoEcom((int) jTbListaPedido.getValueAt(linhaSelecionada, 1));
            listaPedidoERPBean.setDataFinalizacaoPedido(new Date());

            ListaPedidoDAO listaPedidoDAO = new ListaPedidoDAO();
            if (listaPedidoDAO.validacaoCancelarPedido(listaPedidoERPBean)) {
                if (listaPedidoDAO.cancelarPedido(listaPedidoERPBean)) {
                    //Atualizando Grid
                    refleshGrid();
                    JOptionPane.showMessageDialog(null, "Pedido cancelado com sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Esse pedido não pode ser cancelado!");
            }

        } catch (Exception e) {
            logger.error("Erro ao cancelar pedidos: " + e);
        }
    }

    public void statusAguadandoPagamento() {
        try {
            ListaPedidoERPBean listaPedidoERPBean = new ListaPedidoERPBean();
            listaPedidoERPBean.setCodPedidoResulth((int) jTbListaPedido.getValueAt(linhaSelecionada, 0));
            listaPedidoERPBean.setCodPedidoEcom((int) jTbListaPedido.getValueAt(linhaSelecionada, 1));

            ListaPedidoDAO listaPedidoDAO = new ListaPedidoDAO();
            if (listaPedidoDAO.validacaoStatusAguadandoPagamento(listaPedidoERPBean)) {
                if (listaPedidoDAO.StatusAguadandoPagamento(listaPedidoERPBean)) {
                    //Atualizando Grid
                    refleshGrid();
                    JOptionPane.showMessageDialog(null, "Status (AguadandoPagamento) do pedido alterado com sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Esse pedido não pode ser alterado o status!");
            }

        } catch (Exception e) {
            logger.error("Erro ao mudar status do pedidos para (Aguardando Pagamento): " + e);
        }
    }

    public void statusPagamentoRecusado() {
        try {
            ListaPedidoERPBean listaPedidoERPBean = new ListaPedidoERPBean();
            listaPedidoERPBean.setCodPedidoResulth((int) jTbListaPedido.getValueAt(linhaSelecionada, 0));
            listaPedidoERPBean.setCodPedidoEcom((int) jTbListaPedido.getValueAt(linhaSelecionada, 1));

            ListaPedidoDAO listaPedidoDAO = new ListaPedidoDAO();
            if (listaPedidoDAO.validacaoStatusPagamentoRecusado(listaPedidoERPBean)) {
                if (listaPedidoDAO.StatusPagamentoRecusado(listaPedidoERPBean)) {
                    //Atualizando Grid
                    refleshGrid();
                    JOptionPane.showMessageDialog(null, "Status (Pagamento recusado) do pedido alterado com sucesso!");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Esse pedido não pode ser alterado o status!");
            }

        } catch (Exception e) {
            logger.error("Erro ao mudar status do pedidos para (Pagemento recusado): " + e);
        }
    }

    public void statusPagamentoAceito() {
        try {
            ListaPedidoERPBean listaPedidoERPBean = new ListaPedidoERPBean();
            listaPedidoERPBean.setCodPedidoResulth((int) jTbListaPedido.getValueAt(linhaSelecionada, 0));
            listaPedidoERPBean.setCodPedidoEcom((int) jTbListaPedido.getValueAt(linhaSelecionada, 1));

            ListaPedidoDAO listaPedidoDAO = new ListaPedidoDAO();
            if (listaPedidoDAO.validacaoStatusPagamentoAceito(listaPedidoERPBean)) {
                if (listaPedidoDAO.StatusPagamentoAceito(listaPedidoERPBean)) {
                    //Atualizando Grid
                    refleshGrid();
                    JOptionPane.showMessageDialog(null, "Status (Pagamento aceito) do pedido alterado com sucesso!");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Esse pedido não pode ser alterado o status!");
            }

        } catch (Exception e) {
            logger.error("Erro ao mudar status do pedidos para (Pagemento aceito): " + e);
        }
    }

    public void statusNotaFiscal() {
        try {
            ListaPedidoERPBean listaPedidoERPBean = new ListaPedidoERPBean();
            listaPedidoERPBean.setCodPedidoResulth((int) jTbListaPedido.getValueAt(linhaSelecionada, 0));
            listaPedidoERPBean.setCodPedidoEcom((int) jTbListaPedido.getValueAt(linhaSelecionada, 1));

            ListaPedidoDAO listaPedidoDAO = new ListaPedidoDAO();
            if (listaPedidoDAO.validacaoStatusNotaFiscal(listaPedidoERPBean)) {
                if (listaPedidoDAO.StatusNotaFiscal(listaPedidoERPBean)) {
                    //Atualizando Grid
                    refleshGrid();
                    JOptionPane.showMessageDialog(null, "Status (Nota Fiscal) do pedido alterado com sucesso!");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Esse pedido não pode ser alterado o status!");
            }

        } catch (Exception e) {
            logger.error("Erro ao mudar status do pedidos para (Nota Fiscal): " + e);
        }
    }

    public void statusPedidoDevolvido() {
        try {
            ListaPedidoERPBean listaPedidoERPBean = new ListaPedidoERPBean();
            listaPedidoERPBean.setCodPedidoResulth((int) jTbListaPedido.getValueAt(linhaSelecionada, 0));
            listaPedidoERPBean.setCodPedidoEcom((int) jTbListaPedido.getValueAt(linhaSelecionada, 1));

            ListaPedidoDAO listaPedidoDAO = new ListaPedidoDAO();
            if (listaPedidoDAO.validacaoStatusPedidoDevolvido(listaPedidoERPBean)) {
                if (listaPedidoDAO.StatusPedidoDevolvido(listaPedidoERPBean)) {
                    //Atualizando Grid
                    refleshGrid();
                    JOptionPane.showMessageDialog(null, "Status (Pedido devolvido) do pedido alterado com sucesso!");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Esse pedido não pode ser alterado o status!");
            }

        } catch (Exception e) {
            logger.error("Erro ao mudar status do pedidos para (Pedido devolvido): " + e);
        }
    }

    public void statusPagamentoEstornado() {
        try {
            ListaPedidoERPBean listaPedidoERPBean = new ListaPedidoERPBean();
            listaPedidoERPBean.setCodPedidoResulth((int) jTbListaPedido.getValueAt(linhaSelecionada, 0));
            listaPedidoERPBean.setCodPedidoEcom((int) jTbListaPedido.getValueAt(linhaSelecionada, 1));

            ListaPedidoDAO listaPedidoDAO = new ListaPedidoDAO();
            if (listaPedidoDAO.validacaoStatusPagamentoEstornado(listaPedidoERPBean)) {
                if (listaPedidoDAO.StatusPagamentoEstornado(listaPedidoERPBean)) {

                    //Atualizando Grid
                    refleshGrid();
                    JOptionPane.showMessageDialog(null, "Status (Pagamanto estornado) do pedido alterado com sucesso!");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Esse pedido não pode ser alterado o status!");
            }

        } catch (Exception e) {
            logger.error("Erro ao mudar status do pedidos para (Pagamento estornado): " + e);
        }
    }

}
