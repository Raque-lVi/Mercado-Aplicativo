/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TradutorDAO;

import classes.funcionario;
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
public class funcionarioDAO {
    public int UltResistroFuncionario () {
     
 int valor = 0;
 
      String sql = "SELECT * FROM funcionario";
       funcionario retorno = null;
      
      PreparedStatement pst = Conexao.getPreparedStatement(sql);
      
       try { 
          
           ResultSet res = pst.executeQuery();
           res.last();
           valor = Integer.parseInt(res.getString("matricula"));
           valor++;
         
              
      } catch (SQLException ex) {
          Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"Erro ao buscar o ultimo funcionario","ERRO,", JOptionPane.CLOSED_OPTION);
      }
  
       return valor;
 }
public funcionario buscarFuncionario (String mat)
        
{//mat = matricula
    String sql = "SELECT * FROM funcionario where fkcpf=?";    
   funcionario retorno = null;

   PreparedStatement pst = Conexao.getPreparedStatement(sql);
   try {
       pst.setString(1, mat);
       ResultSet res = pst.executeQuery();
       
       if(res.next())
       {
           
           retorno = new funcionario();
           
           retorno.setFkcpf(res.getString("fkcpf"));
           retorno.setMatricula(res.getString("matricula"));
           retorno.setSalario(res.getFloat("salario"));
           retorno.setTurno(res.getString("turno"));
       }
   }  
      catch (SQLException ex) {
          Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"Erro ao buscar o ultimo funcionario","ERRO,", JOptionPane.CLOSED_OPTION);
      }
  
       return retorno ;

}
    public boolean inserirFuncionario (funcionario fun) {
          
      String sql = "INSERT INTO funcionario (matricula,turno,salario,fkcpf)VALUES(?,?,?,?);";
      boolean retorno = false;
      PreparedStatement pst = Conexao.getPreparedStatement(sql);
       try {
           //String fkcpf, String matricula, String turno, float salario
           

          pst.setString(1,fun.getMatricula());//1
          pst.setString(2,fun.getTurno());//2
          pst.setFloat(3,fun.getSalario());//3
          pst.setString(4,fun.getFkcpf());//4
         
          
          
          
          if(pst.executeUpdate()>0)
              retorno= true;
              
      } catch (SQLException e) {
           Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
         JOptionPane.showMessageDialog(null,"ERRO AO INSERIR","ERRO NA CONEXAO", JOptionPane.ERROR_MESSAGE);
      }
   return retorno;
        }
        
public boolean AtualFuncio(funcionario fun){
    
    String sql = "UPDATE funcionario SET salario=?, turno=?, matricula=? WHERE fkcpf=?";
    
    PreparedStatement pst = Conexao.getPreparedStatement(sql);

  try {
     
     pst.setFloat (1, fun.getSalario());
     pst.setString(2, fun.getTurno());
     pst.setString(3, fun.getMatricula());
     pst.setString(4, fun.getFkcpf());
    
if(pst.executeUpdate()>0){
       
       return true ;
}}
    catch (SQLException ex) {
           Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"Erro ao atualizar funcionario","ERRO,", JOptionPane.CLOSED_OPTION);
      }
  
       return false ;

}



public boolean ExcluirFincio(String CPF){

 
 String sqlEnd = "DELETE FROM endereco WHERE fkcpf = ?";   
 String sqlfun = "DELETE FROM funcionario WHERE fkcpf = ?" ; 
 String sql = "DELETE FROM `pessoa` WHERE cpf = ?";

 PreparedStatement pstEnd = Conexao.getPreparedStatement(sqlEnd);
 PreparedStatement pstfun = Conexao.getPreparedStatement(sqlfun);
 PreparedStatement pst = Conexao.getPreparedStatement(sql);
 
 
Boolean retorno = false;
 try {//try é a permição para trabalhar com banco de dados
     
     
     pstEnd.setString(1, CPF);
     pstfun.setString(1,CPF);
     pst.setString(1, CPF); 
     
     while(  pstEnd.executeUpdate()>0 && pstfun.executeUpdate()>0 && pst.executeUpdate()>0 )
       retorno = true ;
     
}
    catch (SQLException ex) {
           Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"Erro ao excluir funcionario completo","ERRO,", JOptionPane.CLOSED_OPTION);
      }
        return retorno;
}
}
