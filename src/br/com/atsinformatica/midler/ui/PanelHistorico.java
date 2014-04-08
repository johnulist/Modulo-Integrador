
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.ui;

import br.com.atsinformatica.erp.controller.SincERPController;
import br.com.atsinformatica.erp.dao.ClienteERPDAO;
import br.com.atsinformatica.midler.components.renderer.DateCellRenderer;
import br.com.atsinformatica.erp.dao.HistoricoIntegraDAO;
import br.com.atsinformatica.erp.dao.ParaEcomDAO;
import br.com.atsinformatica.erp.dao.PedidoCERPDAO;
import br.com.atsinformatica.erp.dao.PedidoIERPDAO;
import br.com.atsinformatica.erp.dao.ProdutoDAO;
import br.com.atsinformatica.erp.entity.CPFClienteBean;
import br.com.atsinformatica.erp.entity.HistoricoIntegraERPBean;
import br.com.atsinformatica.erp.entity.ParaEcomBean;
import br.com.atsinformatica.erp.entity.ClienteERPBean;
import br.com.atsinformatica.erp.entity.EnderecoERPBean;
import br.com.atsinformatica.erp.entity.EstadoERPBean;
import br.com.atsinformatica.erp.entity.PedidoCERPBean;
import br.com.atsinformatica.erp.entity.PedidoIERPBean;
import br.com.atsinformatica.prestashop.controller.AddressController;
import br.com.atsinformatica.prestashop.controller.CPFModuleDataController;
import br.com.atsinformatica.prestashop.controller.CarrierController;
import br.com.atsinformatica.prestashop.controller.CustomerController;
import br.com.atsinformatica.prestashop.controller.OrderController;
import br.com.atsinformatica.prestashop.controller.StateController;
import br.com.atsinformatica.prestashop.model.node.OrderRowNode;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.table.TableColumn;
import org.apache.log4j.Logger;

/**
 *
 * @author AlexsanderPimenta
 */
public class PanelHistorico extends javax.swing.JPanel {
    //Resolver para grid sincronizar

    private AnnotationResolver resolverSinc = new AnnotationResolver(HistoricoIntegraERPBean.class);
    private String fields = "id,entidade,codEntidade,dataEnt,dataInteg,tipoOperacao";
    //model para grid  sincronizar
    private ObjectTableModel modelSincronizar = new ObjectTableModel(resolverSinc, fields);
    private static Logger logger = Logger.getLogger(PanelHistorico.class);
    
    /**
     * Creates new form PanelHistorico
     */
    public PanelHistorico() {
        initComponents();
        carregaGridSincronizar();
        setaTimer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timerCadastro = new org.netbeans.examples.lib.timerbean.Timer();
        timerMov = new org.netbeans.examples.lib.timerbean.Timer();
        title_historico = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbSincronizar = new javax.swing.JTable();
        jBtRefresh = new javax.swing.JButton();

        timerCadastro.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                timerCadastroOnTime(evt);
            }
        });

        timerMov.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                timerMovOnTime(evt);
            }
        });

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        title_historico.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        title_historico.setText("Histórico de sincronização ");

        jTbSincronizar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Entidade", "XML", "Data entrada", "Tipo da operação", "Data importacao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTbSincronizar);

        jBtRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/refresh.png"))); // NOI18N
        jBtRefresh.setToolTipText("Atualizar");
        jBtRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title_historico)
                        .addGap(556, 556, 556)
                        .addComponent(jBtRefresh)))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title_historico)
                .addGap(16, 16, 16)
                .addComponent(jBtRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    ///Timer para movimentações
    private void timerMovOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timerMovOnTime
        sincPedidos();
    }//GEN-LAST:event_timerMovOnTime

    ///Timer para cadastro 
    private void timerCadastroOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timerCadastroOnTime
        refreshSincCad();
    }//GEN-LAST:event_timerCadastroOnTime

    //Botão de atualizar
    private void jBtRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRefreshActionPerformed
        refreshSincCad();

    }//GEN-LAST:event_jBtRefreshActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbSincronizar;
    private org.netbeans.examples.lib.timerbean.Timer timerCadastro;
    private org.netbeans.examples.lib.timerbean.Timer timerMov;
    private javax.swing.JLabel title_historico;
    // End of variables declaration//GEN-END:variables

    private void carregaGridSincronizar() {
        //TableColumn colInt = jTbSincronizar.getColumnModel().getColumn(4);   
        //colInt.setCellRenderer(new DateCellRenderer());
        jTbSincronizar.setModel(modelSincronizar);
        //
        jTbSincronizar.setAutoCreateRowSorter(true);
        modelSincronizar.clear();
        for (int i = 0; i < 19; i++) {
            modelSincronizar.add(null);
        }
        TableColumn colSinc = jTbSincronizar.getColumnModel().getColumn(0);
        TableColumn colEnt = jTbSincronizar.getColumnModel().getColumn(3);
        TableColumn colInt = jTbSincronizar.getColumnModel().getColumn(4);
        colSinc.setPreferredWidth(10);
        colEnt.setCellRenderer(new DateCellRenderer());
        colInt.setCellRenderer(new DateCellRenderer());
    }

    /**
     * Seta timer de sincronização
     */
    private void setaTimer() {
        ParaEcomDAO dao = new ParaEcomDAO();
        try {
            ParaEcomBean bean = dao.listaTodos().get(0);
            if (bean != null) {
                //cadastro
                if (bean.getAtivaSincronizacao() == 1) {
                    long minutesCad = TimeUnit.SECONDS.toMillis(bean.getMinutoscadastrados()) * 60;
                    timerCadastro.setDelay(minutesCad);
                    timerCadastro.start();
                    //movimentação
                    long minutesMov = TimeUnit.SECONDS.toMillis(bean.getMinutosmov()) * 60;
                    timerMov.setDelay(minutesMov);
                    timerMov.start();
                }
            }
        } catch (Exception e) {
            logger.error("Erro ao setar timer de sincronização: " + e);
        }
    }

    /**
     * Inicia processo de preparação de ítens para sincronização
     */
    private void refreshSincCad() {
        List<HistoricoIntegraERPBean> listaPend = null;
        List<HistoricoIntegraERPBean> listaUltimos = null;
        try {
            modelSincronizar.clear();
            ///lista de itens pendentes de sincronização
            listaPend = new HistoricoIntegraDAO().listaPendentes();
            //lista de ultimos itens sincronizados na loja virtual
            listaUltimos = new HistoricoIntegraDAO().listaUltimosInteg();
            SincERPController controller = null;
            if (listaPend.isEmpty() && !listaUltimos.isEmpty()) {
                modelSincronizar.addAll(listaUltimos);
            } else {
                for (HistoricoIntegraERPBean bean : listaPend) {
                    controller = new SincERPController(bean);
                    if (bean.getTipoOperacao().equals("insert")) {
                        controller.post(bean.getObjectSinc());
                    }
                    if (bean.getTipoOperacao().equals("update")) {
                        controller.update(bean.getObjectSinc());
                    }
                    if (bean.getTipoOperacao().equals("delete")) {
                        controller.delete(bean.getCodEntidade());
                    }
                }
                modelSincronizar.addAll(new HistoricoIntegraDAO().listaUltimosInteg());
            }
        } catch (Exception e) {
            logger.error("Erro ao atualizar lista de ítens a serem sincronizados: " + e);
        }
    }

    private void sincPedidos() {
        OrderController orderController = new OrderController();
        PedidoCERPDAO pedidoERPDAO = new PedidoCERPDAO();
        List<PedidoCERPBean> listoPedido = null;
        try {
            //Buscando a lista de Pedidos que ainda não esta no banco de dados.
            listoPedido = orderController.syncListaOrder();
            /*
             Vefificando se a lista de pedido esta vazia, se estiver vazia sai da função.
             */
            if (listoPedido.isEmpty()) {
                logger.info("Nenhum pedido pendente para sincronizar. ");
                return;
            }
        } catch (SQLException ex) {

            logger.error("Erro ao efetuar sincronização de Pedidos da loja virtual: " + ex);
        }

        /**
         * Chamando o metodo sincGetPedido, que com o numero do pedido, busca o
         * cliente, busca o endereço, busca o CPF. se tiver no banco ERP os
         * dados do cliente apenas atualiza, se não tiver no banco ERP vai
         * inserir os dados.
         */
        for (PedidoCERPBean pedido : listoPedido) {
            sincGetPedido(pedido);
        }

    }

    private void sincGetPedido(PedidoCERPBean pedido) {
        OrderController orderController = new OrderController();
        CustomerController customerController = new CustomerController();
        AddressController addressController = new AddressController();
        CPFModuleDataController cPFModuleDataController = new CPFModuleDataController();
        StateController stateController = new StateController();
        CarrierController carrierController = new CarrierController();

        ClienteERPBean beanCliente;
        EnderecoERPBean beanEndereco;
        CPFClienteBean beanCPF;
        ClienteERPDAO clienteERPDAO = new ClienteERPDAO();
        EstadoERPBean estadoERPBean = new EstadoERPBean();
        EstadoERPBean estadoCobracaoERPBean = new EstadoERPBean();
        PedidoCERPDAO pedidoERPDAO = new PedidoCERPDAO();

        try {
            beanCliente = customerController.syncCustomerPrestashop(Integer.valueOf(pedido.getId_customer()));
            beanEndereco = addressController.syncAddressControllerPrestashop(Integer.valueOf(pedido.getId_address_delivery()), Integer.valueOf(pedido.getId_address_invoice()));

            beanCPF = cPFModuleDataController.sysncCPDModuleData(Integer.valueOf(pedido.getId_customer()));

            pedido.setObservacao(carrierController.syncCarrierControllerPrestashop(Integer.valueOf(pedido.getId_carrier())));

            if (Integer.valueOf(beanEndereco.getId_state()) > 0) {
                estadoERPBean = stateController.syncStateControllerPrestashop(Integer.valueOf(beanEndereco.getId_state()), Integer.valueOf(beanEndereco.getEstadoCob()));
            }

            if (clienteERPDAO.verificacaoClienteEcomExiste(beanCliente.getId())) {  //Verificando se o cliente já foi sincronizado.
                //Cliente já existe - Vai atualizar
                if (!clienteERPDAO.atualizarClienteComEndereco(beanCliente, beanEndereco, beanCPF, estadoERPBean)) {
                    //se o retorno de Aualizar Cliente for FALSE ele sai da função
                    return;
                }

            } else {
                //Cliente não existe - Vai inserir
                if (!clienteERPDAO.gravarClienteComEndereco(beanCliente, beanEndereco, beanCPF, estadoERPBean)) {
                    //se o retorno de Gravar Cliente for FALSE ele sai da função
                    return;
                }
            }

            /**
             * Chamando o gravar pedido, que tem como retorno o numero do pedido
             * se gravou com sucesso, ou NULL se deu erro.
             */
            String codPedido = pedidoERPDAO.gravarPedido(pedido, clienteERPDAO.retornaCodClienteERP(pedido.getId_customer()));
            if (codPedido != null) {
                String codEmpresa = new ParaEcomDAO().listaTodos().get(0).getCodEmpresaEcom();
                PedidoIERPBean pedidoIERPBean = new PedidoIERPBean();
                PedidoIERPDAO pedidoIERPDAO = new PedidoIERPDAO();
                ProdutoDAO produtoDAO = new ProdutoDAO();

                for (OrderRowNode orderRowNode : pedido.getListItensPedido()) {
                    /*
                     Pegando o codigo do produtoERP
                     */
                    String codProdutoERP = produtoDAO.retornaCodProdutoERP(String.valueOf(orderRowNode.getProductId()));

                    pedidoIERPBean.setCodEmpresa(codEmpresa);
                    pedidoIERPBean.setCodPedido(codPedido);
                    pedidoIERPBean.setCodClienteERP(clienteERPDAO.retornaCodClienteERP(pedido.getId_customer()));
                    pedidoIERPBean.setCodProdERP(codProdutoERP);
                    pedidoIERPBean.setQuantidade(orderRowNode.getProductQuantity());
                    pedidoIERPBean.setPrecoUnit(orderRowNode.getUnitPriceTaxIncl());
                    pedidoIERPBean.setCodGradERP(String.valueOf(orderRowNode.getProductAttributeId()));
                    pedidoIERPBean.setUnidadeSaida(produtoDAO.retornaUnidadeSaidaProdutoERP(codProdutoERP));

                    pedidoIERPDAO.gravar(pedidoIERPBean);
                }

            }

        } catch (Exception e) {
            logger.error("Erro ao efetuar sincronização de cliente da loja virtual: " + e);
        }

    }

    //Desbilitado porque esta rotina foi movida para o controle genérico, habilitar caso for precisar da mesma 
    //e não for usar o controle genérico
//    /**
//     * Atualiza data de integração 
//     * @param obj
//     * @throws SQLException 
//     */
//    private void atualizaDataInt(HistoricoIntegraERPBean obj) throws SQLException {
//        try {
//            HistoricoIntegraDAO dao = new HistoricoIntegraDAO();
//            new HistoricoIntegraDAO().alteraDataInt(obj.getId());
//        } catch (Exception e) {
//            Logger.getLogger(PanelHistorico.class).error("Erro ao atualizar data de integração: " + e);
//        }
//
//    }
}
