/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.erp.dao.ProdutoDAO;
import br.com.atsinformatica.erp.entity.ProdutoERPBean;
import br.com.atsinformatica.prestashop.controller.ProdutoController;

/**
 * Controladora de sincronização do produto do ERP
 *
 * @author AlexsanderPimenta
 */
public class ProdutoERPController extends SincERPController<ProdutoERPBean>{
    //controladora do produto no prestashop

    private ProdutoController prodController;
    
    public ProdutoERPController(){ 
        prodController = new ProdutoController();
    }

    @Override
    public void post(ProdutoERPBean obj) throws Exception {
        
            int codProdEcom = prodController.createProductPrestashop(obj);
            if (codProdEcom != 0) {
                obj.setIdProdutoEcom(codProdEcom);
                ProdutoDAO dao = new ProdutoDAO();
                dao.alterar(obj);
            }
//        } catch (Exception e) {
//            System.out.println("Erro: "+e);
//        }
    }

    @Override
    public void update(ProdutoERPBean obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}