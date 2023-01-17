/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author  Vivian Raquel Batista Dantas de casa, cama.
 */
public class conexaoBanco {
     public static Connection AbrirConexao(){
         
    Connection con = null;
    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            String url="jdbc:mysql://localhost:3306/mercado";
            
            con = DriverManager.getConnection(url,"root","");
            
            JOptionPane.showMessageDialog(null,"Banco de Dados Conectado com Sucesso", "SOBRE CONEXÃO", JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception e){
                   JOptionPane.showMessageDialog(null,"Não é Possível Conectar ao Banco de Dados","ERRO NA CONEXAO", JOptionPane.ERROR_MESSAGE); 
            }
            return con;
            
    }
        
}
