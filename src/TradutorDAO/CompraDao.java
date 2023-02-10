/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TradutorDAO;

import classes.Comprapeq;
import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User1
 */
    public class CompraDao {
    public static int o = 0;
    public static String Nprod;
        
    public boolean inserirComp (Comprapeq comp) {
        
        EstoqueDAO estD = new EstoqueDAO();
        
        CauculadoraDaoChef calChef = new CauculadoraDaoChef();

        //System.out.print(""+SofrendoNaCalculadChef.listNomesAnt.getModel().getElementAt(o));
        estD.PesquisaProdutC();

        comp.setFkestoque(calChef.Fkestoque);
        comp.setPrecoComp(calChef.precoComp);

        String sql = "INSERT INTO comprapeq (`codigo`,`fkdatas`,`fkpessoa`,`fkestoque`,`precoP`,`Quantidade`,`ganho`)VALUES(?,?,?,?,?,?,?);"; 
        boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {

            pst.setString(1,comp.getCodigo());
            pst.setString(2,comp.getFkdatas());
            pst.setString(3,comp.getFkpessoa());
            pst.setInt(4,comp.getFkestoque());
            pst.setFloat(5,calChef.precoC);
            pst.setInt(6,calChef.quantidade);
            pst.setFloat(7,calChef.ganhoC);

            if(pst.executeUpdate()>0){
                retorno= true;
                o++;
            } 
        }
        catch (SQLException e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
            retorno = false;
        }
        return retorno;
    }
      
      
    public int UltResistroComp () {
     
        int valor = 0;
        String sql = "SELECT * FROM comprapeq";
        Comprapeq retorno = null;
      
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
      
        try { 
            ResultSet res = pst.executeQuery();
           
            if (res.next()){
                
                res.last();
                valor = Integer.parseInt(res.getString("codigo"));
                valor++;
            }
            else{  
                valor = 0;
            } 
        } 
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar o ultima compra","ERRO,", JOptionPane.CLOSED_OPTION);
        }
        return valor;
    }
}