/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TradutorDAO;

import classes.cliente;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author User1
 */
public class ClienteDAO {
    private DefaultListModel modelo,porq;
    private String comando;
    private ResultSet rs = null;
  
    public ClienteDAO(){
       this.modelo = new DefaultListModel();
       this.porq = new DefaultListModel();
    }
 
    Connection com;

    public boolean ExcluirPessoa (String CPF){

        String sqlEnd= "DELETE FROM endereco WHERE fkcpf = ?";   
        String sqlCl = "DELETE FROM cliente WHERE fkcpf = ?" ; 
        String sqlFun = "DELETE FROM funcionario WHERE fkcpf = ?" ;
        String sql = "DELETE FROM `pessoa` WHERE cpf = ?";


        PreparedStatement pstEnd = Conexao.getPreparedStatement(sqlEnd);
        PreparedStatement pstCl = Conexao.getPreparedStatement(sqlCl);
        PreparedStatement pstFun = Conexao.getPreparedStatement(sqlFun);
        PreparedStatement pst = Conexao.getPreparedStatement(sql);

        Boolean retorno = false;

        try {//try é a permição para trabalhar com banco de dados

            pstEnd.setString(1, CPF);
            pstCl.setString(1,CPF);
            pstFun.setString(1,CPF);
            pst.setString(1, CPF); 

            pstEnd.executeUpdate();
            
            if(pstCl.executeUpdate()>0){
                
                if(pstFun.executeUpdate()>0){
                pst.executeUpdate();
                retorno = true ;
                }
                
                pst.executeUpdate();
                retorno = true ;}
                else{pstFun.executeUpdate();pst.executeUpdate();retorno = true ;}
            }
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao excluir pessoa","ERRO,", JOptionPane.CLOSED_OPTION);
        }
         return retorno;
    }

    public boolean AtualisasCli(cliente cli){
    
        String sql = "UPDATE cliente SET credito=? WHERE fkcpf=?";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {
            pst.setFloat(1, cli.getCredito());
            pst.setString(2, cli.getFkcpf());

            if(pst.executeUpdate()>0){
                return true ;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao atualizar o cliente","ERRO,", JOptionPane.CLOSED_OPTION);
        }
    return false ;
    }

    public cliente buscarCliente (String mat){
        String sql = "SELECT * FROM mercado . cliente where matricula=?";    
        cliente retorno = null;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, mat);
            ResultSet res = pst.executeQuery();

            if(res.next()){
                retorno = new cliente();
                retorno.setCredito(res.getInt("credito"));
                retorno.setFkcpf(res.getString("fkcpf"));
            }
        }  
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar o ultimo Cliente","ERRO,", JOptionPane.CLOSED_OPTION);
        }
    return retorno ;
    }
    
    public int UltResistroCliente () {

        int valor = 0;

        String sql = "SELECT * FROM cliente";
        cliente retorno = null;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        
        try { 

            ResultSet res = pst.executeQuery();
            res.last();
            valor = Integer.parseInt(res.getString("matricula"));
            valor++;
        } 
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar o ultimo cliente","ERRO,", JOptionPane.CLOSED_OPTION);
        }
        return valor;
    }
    
    public boolean inserirCliente (cliente cl) {
          
        String sql = "INSERT INTO cliente (matricula,credito,fkcpf)VALUES(?,?,?);";
        boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1,cl.getMatricula());//1
            pst.setFloat(2,cl.getCredito());//2
            pst.setString(3,cl.getFkcpf());//3
         
            if(pst.executeUpdate()>=0)
                retorno= true; 
        } 
        catch (SQLException e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null,"ERRO AO INSERIR","ERRO NA CONEXAO", JOptionPane.ERROR_MESSAGE);
        }
        return retorno;
    }
}
