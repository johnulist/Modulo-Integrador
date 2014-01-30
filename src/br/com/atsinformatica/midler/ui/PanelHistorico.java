/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.ui;

import br.com.atsinformatica.midler.components.renderer.DateCellRenderer;
import br.com.atsinformatica.erp.dao.HistoricoIntegraDAO;
import br.com.atsinformatica.erp.dao.ParaEcomDAO;
import br.com.atsinformatica.erp.entity.HistoricoIntegraERPBean;
import br.com.atsinformatica.erp.entity.ParaEcomBean;
import br.com.atsinformatica.erp.entity.ProdutoERPBean;
import br.com.atsinformatica.midler.dao.ProdutoDAO;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import java.util.ArrayList;
import java.util.Date;
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
    private String fields = "id,entidade,codEntidade,dataEnt,dataInteg";
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

        setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        title_historico.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        title_historico.setText("Histórico de sincronização ");

        jTbSincronizar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Entidade", "XML", "Data entrada", "Data importacao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(title_historico))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(881, 881, 881)
                            .addComponent(jBtRefresh))))
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
        return;
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
        TableColumn colEnt = jTbSincronizar.getColumnModel().getColumn(3);
        //TableColumn colInt = jTbSincronizar.getColumnModel().getColumn(4);

        colEnt.setCellRenderer(new DateCellRenderer());
        //colInt.setCellRenderer(new DateCellRenderer());
        jTbSincronizar.setModel(modelSincronizar);
        jTbSincronizar.setAutoCreateRowSorter(true);
        modelSincronizar.clear();
        for (int i = 0; i < 19; i++) {
            modelSincronizar.add(null);
        }
        TableColumn colSinc = jTbSincronizar.getColumnModel().getColumn(0);
        colSinc.setPreferredWidth(10);

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
     * Recebe lista de itens a serem sincronizados e inicia processo de
     * sincronização
     *
     * @param lista Lista de itens a serem sincronizados no ERP ou na loja
     * virtual
     */
    private void iniciaSincronizacaoLoja(List lista) {
        try {
            if (lista.isEmpty()) {
                return;
            }
            // ProdutoController controller = new ProdutoController();
            // controller.createProductPrestashop((List<ProdutoERPBean>) lista);            
            atualizaDataInt(lista);
            logger.info("Sincronização na loja virtual, efetuada com sucesso!");
        } catch (Exception e) {
            logger.error("Erro ao efetuar sincronização: " + e);
        }
    }

    /**
     * Inicia processo de preparação de ítens para sincronização
     */
    private void refreshSincCad() {
        try {
            ///lista de itens pendentes de sincronização
            List<HistoricoIntegraERPBean> listaPend = new HistoricoIntegraDAO().listaPendentes();
            List<HistoricoIntegraERPBean> listaUltimos = new HistoricoIntegraDAO().listaUltimosInteg();
            //Lista de itens a sincronizar na loja virtual
            List itens = new ArrayList();
            if (listaPend.isEmpty() && !listaUltimos.isEmpty()) {
                modelSincronizar.clear();
                modelSincronizar.addAll(listaUltimos);
            } else {
                for (HistoricoIntegraERPBean bean : listaPend) {
                    itens.add(retornaItensSinc(bean));
                    modelSincronizar.add(bean);
                }
                iniciaSincronizacaoLoja(itens);
            }
        } catch (Exception e) {
            logger.error("Erro ao atualizar lista de ítens a serem sincronizados: " + e);
        }
    }

    /**
     * Retorna item a serem sincronizados na loja virtual
     *
     * @param bean
     * @return item ser sincronizado na loja virtual
     */
    private Object retornaItensSinc(HistoricoIntegraERPBean bean) {
        try {
            Object obj = null;
            if (bean != null) {
                //TODO: Pesquisar algum padrão de projeto que torna este processo automático
                if (bean.getEntidade().equals("produto")) {
                    obj = new ProdutoDAO().abrir(bean.getCodEntidade());
                }
            }
            return obj;
        } catch (Exception e) {
            logger.error("Erro ao retornar ítens: " + e);
            return null;
        }
    }

    /**
     * Atualiza data de integração de itens pendentes na tabela de historico de
     * sincronizacao
     *
     * @param lista lista de itens
     */
    private void atualizaDataInt(List lista) {
        try {
            HistoricoIntegraDAO dao = new HistoricoIntegraDAO();
            modelSincronizar.clear();
            if (!lista.isEmpty()) {
                for (ProdutoERPBean prodBean : (List<ProdutoERPBean>) lista) {
                    HistoricoIntegraERPBean bean = null;
                    // if(prodBean.isImportadoLoja()){
                    bean = new HistoricoIntegraERPBean();
                    bean.setCodEntidade(prodBean.getCodProd());
                    bean.setDataInteg(new Date());
                    dao.alterar(bean);
                }
            }
            //lista ultimos registros
            List<HistoricoIntegraERPBean> listaUltimos = dao.listaUltimosInteg();
            if (!listaUltimos.isEmpty()) {
                modelSincronizar.addAll(listaUltimos);
            }
        } catch (Exception e) {
        }
    }
}
