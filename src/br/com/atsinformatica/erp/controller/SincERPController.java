/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.erp.dao.HistoricoIntegraDAO;
import br.com.atsinformatica.erp.entity.AtributoGradeEcom;
import br.com.atsinformatica.erp.entity.CategoriaEcomErpBean;
import br.com.atsinformatica.erp.entity.HistoricoIntegraERPBean;
import br.com.atsinformatica.erp.entity.ProdutoERPBean;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 * Superclasse generica responsável por gerenciar a sincronização na loja
 * virtual
 *
 * @author AlexsanderPimenta
 */
public class SincERPController<T> implements ISincController<T> {

    private HistoricoIntegraERPBean histInteg;

    public SincERPController() {
    }

    public SincERPController(HistoricoIntegraERPBean histInteg) {
        this.histInteg = histInteg;
    }

    @Override
    public void post(T obj) throws Exception {
        try {
            if(obj.getClass().equals(AtributoGradeEcom.class)){
               new AtributoGradeEcomController().post((AtributoGradeEcom)obj);
            }
            if (obj.getClass().equals(CategoriaEcomErpBean.class)) {
                new CategoriaERPController().post((CategoriaEcomErpBean) obj);
            }
            if (obj.getClass().equals(ProdutoERPBean.class)) {
                new ProdutoERPController().post((ProdutoERPBean) obj);
            }            
            atualizaDataInt(this.histInteg);
        } catch (Exception e) {
            System.out.println("Erro ao efetuar post: " + e);
        }

    }

    @Override
    public void update(T obj) {
        try {
            if(obj.getClass().equals(AtributoGradeEcom.class)){
               new AtributoGradeEcomController().update((AtributoGradeEcom)obj);
            }
            if (obj.getClass().equals(CategoriaEcomErpBean.class)) {
                new CategoriaERPController().update((CategoriaEcomErpBean) obj);
            }
            if (obj.getClass().equals(ProdutoERPBean.class)) {
                new ProdutoERPController().update((ProdutoERPBean) obj);
            }
            atualizaDataInt(histInteg);
        } catch (Exception e) {
            System.out.println("Erro ao efetuar update: " + e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            if (this.histInteg.getEntidade().equals("categoria")) {
                new CategoriaERPController().delete(id);
            }
            if(this.histInteg.getEntidade().equals("produto"))
                new ProdutoERPController().delete(id);
            atualizaDataInt(histInteg);
        } catch (Exception e) {
        }

    }

    public void atualizaDataInt(HistoricoIntegraERPBean histInteg) throws SQLException {
        try {
            new HistoricoIntegraDAO().alteraDataInt(histInteg.getId());
        } catch (Exception e) {
            Logger.getLogger(SincERPController.class).error("Erro ao atualizar data de integração: " + e);
        }

    }
}
