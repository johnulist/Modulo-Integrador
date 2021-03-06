/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.ParaEcomBean;
import br.com.atsinformatica.erp.entity.ProdutoERPBean;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import br.com.atsinformatica.utils.Funcoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author AlexsanderPimenta
 */
public class ProdutoDAO implements IGenericDAO<ProdutoERPBean> {

    private Logger logger = Logger.getLogger(ProdutoERPBean.class);
    private Connection conn;

    @Override
    public void gravar(ProdutoERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(ProdutoERPBean object) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn = ConexaoATS.conectaERP();
            String querie = "UPDATE produto set idprodutoecom = ?    "
                    + "where codprod = ?                       ";
            pstmt = conn.prepareStatement(querie);
            pstmt.setInt(1, object.getIdProdutoEcom());
            pstmt.setString(2, object.getCodProd());
            pstmt.executeUpdate();
            logger.info("Produto alterado com sucesso!");
        } catch (Exception e) {
            logger.error("Erro ao alterar produto: " + e);
        }
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProdutoERPBean abrir(String id) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = ConexaoATS.conectaERP();
            String sql = "SELECT produto.codprod,                                                                    "
                    + "dadosadicecom.nomeprod, dadosadicecom.precocheio, dadosadicecom.precofinal,                   "
                    + "dadosadicecom.codcategoria, dadosadicecom.condicao, dadosadicecom.codbarras,                  "
                    + "dadosadicecom.altura, dadosadicecom.largura, dadosadicecom.profundidade,                      "
                    + "dadosadicecom.codatributo1, dadosadicecom.codatributo2, dadosadicecom.palavraschave,          "
                    + "dadosadicecom.metadescricao, dadosadicecom.descricaocompleta, produto.grade,                  "
                    + "produto.codfabric, produto.idprodutoecom, produto.peso, produto.ativo                         "
                    + "FROM produto                                                                                  "
                    + "JOIN dadosadicecom on dadosadicecom.codprod = produto.codprod                                 "
                    + "and produto.codprod = ?                                                                       ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            ProdutoERPBean prodBean = null;
            while (rs.next()) {
                prodBean = new ProdutoERPBean(rs);
                //se produto possui grade
                prodBean.setEstoqueDisponivel(this.retornaEstoqueProd(id));
            }
            logger.info("Produto retornado com sucesso.");
            return prodBean;
        } catch (Exception e) {
            logger.error("Erro ao retornar produto: " + e);
            return null;
        } finally {
            conn.close();
            rs.close();
        }
    }

    public double retornaEstoqueProd(String codProd) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ParaEcomDAO paraEcom = new ParaEcomDAO();
        try {
            conn = ConexaoATS.conectaERP();
            String sql = "SELECT (compprod.estoque - compprod.quantbloqueada) AS estoquedisponivel  "
                    + "FROM compprod                                                             "
                    + "WHERE compprod.codprod = ? AND compprod.codempresa = ?                    ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codProd);
            pstmt.setString(2, paraEcom.listaTodos().get(0).getCodEmpresaEcom());
            rs = pstmt.executeQuery();
            double estoque = 0;
            while (rs.next()) {
                estoque = rs.getDouble("estoquedisponivel");
            }
            return estoque;
        } catch (Exception e) {
            logger.error("Erro ao retornar estoque do produto: " + e);
            return 0;
        } finally {
            rs.close();
            conn.close();
            pstmt.close();
        }
    }

    @Override
    public List<ProdutoERPBean> listaTodos() throws SQLException {
        List<ProdutoERPBean> listaProdutos = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            ParaEcomBean paraBean = new ParaEcomDAO().listaTodos().get(0);
            conn = ConexaoATS.conectaERP();
            String sql = " SELECT FIRST " + paraBean.getQtdeRegistros() + "  produto.codprod, (compprod.estoque - compprod.quantbloqueada) AS estoquedisponivel, produto.descricao, "
                    + " produto.descricao2, produto.descricao3, sub.descgrupo, sub.descsub, "
                    + " produto.referencia, produto.reffabricante, "
                    + "        produto.unidadeent, produto.unidadesaida, produto.preco, produto.preco2, "
                    + "        produto.preco3, produto.preco4, compprod.precocusto, produto.grade,compprod.codgrade "
                    + " FROM produto, "
                    + " ( "
                    + "    select gruprod.codgrupo codgrupo, subgrup.codsubgrupo codsubgrupo,  gruprod.descricao descgrupo, "
                    + "    subgrup.descricao descsub from subgrup "
                    + "    join gruprod on gruprod.codgrupo = subgrup.codgrupo "
                    + " ) sub "
                    + " JOIN compprod ON produto.codprod = compprod.codprod "
                    + " WHERE  produto.codgrupo = sub.codgrupo and produto.codsubgrupo = sub.codsubgrupo ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ProdutoERPBean bean = new ProdutoERPBean(rs);
                listaProdutos.add(bean);
            }
            logger.info("Lista de produtos a serem sincronizados, retornada com sucesso!");
            return listaProdutos;
        } catch (Exception e) {
            logger.error("Erro ao retornar lista de produtos a serem sincronizados: " + e);
            return null;
        } finally {
            conn.close();
            rs.close();
            stmt.close();
        }
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Atualiza status de importação do produto
     *
     * @param codProd código do produto
     * @param codStatus código do status do produto
     */
    public void atualizaStatusImportacao(String codProd, int codStatus) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn = ConexaoATS.conectaERP();
            conn.setAutoCommit(false);
            String querie = "update produto set importaproduto =? where codprod = ?";
            pstmt = conn.prepareStatement(querie);
            pstmt.setInt(1, codStatus);
            pstmt.setString(2, codProd);
            pstmt.executeUpdate();
            conn.commit();
            logger.info("Status de importação do produto, atualizado com sucesso!");
        } catch (Exception e) {
            logger.error("Erro ao atualizar status de importação do produto: " + e);
        } finally {
            conn.close();
            pstmt.close();
        }

    }

    public String retornaCodProdutoERP(String codProdutoEcom) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String codProdutoERP = null;
        try {
            conn = ConexaoATS.conectaERP();

            String sql = "SELECT P.CODPROD FROM PRODUTO  P "
                    + "                       WHERE P.IDPRODUTOECOM = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codProdutoEcom);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                if (rs.getString("CODPROD") != null) {
                    codProdutoERP = rs.getString("CODPROD");
                }
            }
            return Funcoes.preencheCom(codProdutoERP, "0", 6, Funcoes.LEFT);
        } catch (Exception e) {
            logger.error("Erro ao retornaCodProdutoERP do produtoEcom " + codProdutoEcom + ": " + e);
            return null;
        } finally {
            pstmt.close();
            rs.close();
        }
    }

    public String retornaUnidadeSaidaProdutoERP(String codProdutoERP) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String unidadeSaida = null;
        try {
            conn = ConexaoATS.conectaERP();
            String sql = "SELECT P.UNIDADESAIDA FROM PRODUTO  P "
                    + "                       WHERE P.CODPROD = ? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codProdutoERP);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                if (rs.getString("UNIDADESAIDA") != null) {
                    unidadeSaida = rs.getString("UNIDADESAIDA");
                }
            }
            return unidadeSaida;
        } catch (Exception e) {
            logger.error("Erro ao retornaUnidadeSaidaProdutoERP do produto " + codProdutoERP + ": " + e);
            return null;
        } finally {
            pstmt.close();
            rs.close();
        }
    }
}
