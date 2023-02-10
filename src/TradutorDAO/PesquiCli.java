/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TradutorDAO;

import Entrad.pesquisaCliTud;
import classes.Pessoa;
import classes.estoque;
import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User1
 */
public class PesquiCli {
    
    public List<Pessoa> listarTodpessoaS(){
    
        String sql = " select * FROM pessoa";

        List<Pessoa> retorno = new ArrayList <Pessoa>();

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        int v = 0;

        try {
            ResultSet res = pst.executeQuery();

            while (res.next()&& v <= 6){
               v++;
               Pessoa item = new Pessoa ();
               item.setCpf(res.getString("cpf"));
               item.setNome(res.getString("nome"));

               retorno.add(item);
            }
        }  
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar todas as pessoa","ERRO,", JOptionPane.CLOSED_OPTION);
        }
        return retorno;
    }


    public List<Pessoa> listarPessoaNom(){

        String sql = " select * FROM pessoa where nome LIKE '"+pesquisaCliTud.txNomePess.getText().toUpperCase().trim()+"%'";
        List<Pessoa> retorno = new ArrayList <Pessoa>();

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        int v = 0;
        
        try {
            ResultSet res = pst.executeQuery();

            while (res.next()&& v <= 6){ 
                v++;
                Pessoa item = new Pessoa ();
                item.setCpf(res.getString("cpf"));
                item.setNome(res.getString("nome"));

                retorno.add(item);
            }
        }  
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar as pessoa pelo nome","ERRO,", JOptionPane.CLOSED_OPTION);
        }
        return retorno;
    }
  
    public List<Pessoa> listarPessoaCpf(){
    
        String sql = " select * FROM pessoa where cpf LIKE '"+pesquisaCliTud.txNomePess.getText().toUpperCase().trim()+"%'";
        List<Pessoa> retorno = new ArrayList <Pessoa>();
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        int v=0;
        
        try {
            ResultSet res = pst.executeQuery();

            while (res.next()&& v <= 6){ 
                v++;
                Pessoa item = new Pessoa ();
                item.setCpf(res.getString("cpf"));
                item.setNome(res.getString("nome"));

                retorno.add(item);
            }
        }  
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar as pessoa pelo cpf","ERRO,", JOptionPane.CLOSED_OPTION);
        }
        return retorno;
    }
    

    public List<estoque> listarProdNom(){

        String sql = "SELECT * FROM mercado . estoque where NOMEP LIKE '"+pesquisaCliTud.txNomePess.getText().toUpperCase().trim()+"%'";

        List<estoque> retorno = new ArrayList <estoque>();

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        //"Id","Nome do Produto","Valor","Estoque","ganho"
        int v = 0;
        try {
            ResultSet res = pst.executeQuery();

            while (res.next()&& v <= 6){ 
                v++;
                estoque item = new estoque ();
                item.setCodigo(res.getInt("codigo"));
                item.setNOMEP(res.getString("NOMEP"));
                item.setPreco(res.getFloat("preco"));
                item.setQtdp(res.getInt("qtdp"));
                float valorComp = (res.getFloat("precoPcom"));

                float ganho = item.getPreco() - valorComp;
                item.setGanho(ganho);

                retorno.add(item);
            }
        }  
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar os produtos pelo nome","ERRO,", JOptionPane.CLOSED_OPTION);
        }
        return retorno;
    }

    
    public List<estoque> listarProdCod(){

        String sql = "SELECT * FROM mercado . estoque where codigo LIKE '"+pesquisaCliTud.txNomePess.getText().toUpperCase().trim()+"%'";

        List<estoque> retorno = new ArrayList <estoque>();

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        //"Id","Nome do Produto","Valor","Estoque","ganho"
        int v = 0;
        try {
            ResultSet res = pst.executeQuery();

            while (res.next() && v <= 6){ 
                
                estoque item = new estoque ();
                item.setCodigo(res.getInt("codigo"));
                item.setNOMEP(res.getString("NOMEP"));
                item.setPreco(res.getFloat("preco"));
                item.setQtdp(res.getInt("qtdp"));
                float valorComp = (res.getFloat("precoPcom"));

                float ganho = item.getPreco() - valorComp;
                item.setGanho(ganho);

                retorno.add(item);
                v++;
            }
        }  
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar os produtos pelo codigo","ERRO,", JOptionPane.CLOSED_OPTION);
        }
        return retorno;
    }
  
    public List<estoque> listarTodProd(){
    
        String sql = "SELECT * FROM estoque";
        List<estoque> retorno = new ArrayList <estoque>();
        PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {
            ResultSet res = pst.executeQuery();

            while (res.next()){ 
                
                estoque item = new estoque ();
                item.setCodigo(res.getInt("codigo"));
                item.setNOMEP(res.getString("NOMEP"));
                item.setPreco(res.getFloat("preco"));
                item.setQtdp(res.getInt("qtdp"));
                float valorComp = (res.getFloat("precoPcom"));

                float ganho = item.getPreco() - valorComp;
                item.setGanho(ganho);

                retorno.add(item);
            }
        }  
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar todos os produtos","ERRO,", JOptionPane.CLOSED_OPTION);
        }
        return retorno;
    }
}
