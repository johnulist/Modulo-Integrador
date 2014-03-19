/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.prestashop.model.node.Name;
import br.com.atsinformatica.prestashop.model.node.LinkRewrite;
import br.com.atsinformatica.prestashop.model.node.Language;
import br.com.atsinformatica.erp.entity.CategoriaERPBean;
import br.com.atsinformatica.erp.dao.CategoriaEcomDAO;
import br.com.atsinformatica.erp.entity.CategoriaEcomBean;
import br.com.atsinformatica.prestashop.clientDAO.CategoryPrestashopDAO;
import br.com.atsinformatica.prestashop.model.node.Description;
import br.com.atsinformatica.prestashop.model.root.Category;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author ricardosilva
 */
public class CategoriaController {

    List<CategoriaERPBean> categoriesNotRegistered;

    /**
     * Cria uma lista de Categoria no prestashop
     *
     * @param cat Categoria
     * @return
     */
    public int createCategoryPrestashop(CategoriaEcomBean cat) {
        return new CategoryPrestashopDAO().postCategory(Category.URLCATEGORY, addCategoryPrestashop(cat));
    }
    
    public boolean updateCategoryPrestashop(CategoriaEcomBean cat){
       try{
           CategoryPrestashopDAO dao = new CategoryPrestashopDAO();
           Category category = addCategoryPrestashop(cat);
           category.setId(String.valueOf(cat.getIdCategoriaEcom()));
           dao.put(Category.URLCATEGORY, category);
           Logger.getLogger(CategoriaController.class).info("Categoria atualizada na loja virtual com sucesso.");
           return true;
       }catch(Exception e){
           Logger.getLogger(CategoriaController.class).error("Erro ao atualizar categoria na loja virtual: "+e);  
           return false;
          
       }
    }
    
     public boolean deleteCategoryPrestashop(String idCategorie){
       try{
           CategoryPrestashopDAO dao = new CategoryPrestashopDAO();
          // Category category = addCategoryPrestashop(cat);
          // category.setId(String.valueOf(cat.getIdCategoriaEcom()));
           dao.delete(Category.URLCATEGORY, idCategorie);
           Logger.getLogger(CategoriaController.class).info("Categoria deletada na loja virtual com sucesso.");
           return true;
       }catch(Exception e){
           Logger.getLogger(CategoriaController.class).error("Erro ao deletar categoria na loja virtual: "+e);  
           return false;
          
       }
    }
    
    

    private Category addCategoryPrestashop(CategoriaEcomBean cat) {
        Category category = new Category();
        category.setDataAdd(new Date());
        category.setDataUpd(new Date());
        category.setIdErp(Integer.parseInt(cat.getCodCategoria()));
        LinkRewrite linkRewrite = new LinkRewrite();
        linkRewrite.getLanguage().add(new Language(cat.getDescricao().toLowerCase()));
        if (cat.getCodCategoriaSuperior() != null) {
            try {
                CategoriaEcomDAO dao = new CategoriaEcomDAO();
                CategoriaEcomBean sub = dao.abrir(cat.getCodCategoriaSuperior());
                category.setIdParent(sub.getIdCategoriaEcom());
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaController.class).error("Erro ao retornar categoria superior: " + ex);
            }
        }
        category.setLinkRewrite(linkRewrite);
        category.setDescription(new Description(cat.getDescricaoCompleta()));
        category.setName(new Name(cat.getDescricao()));
        return category;
    }
}
