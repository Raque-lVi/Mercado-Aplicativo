/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TradutorDAO;


import classes.Pessoa;
import classes.acessototal;
import conexao.executeSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class AcessoDAO extends executeSQL{

    public AcessoDAO(Connection con) {
        super(con);
    }
    public int g;
    
    public boolean Logar(String login,String senha){
         boolean finalResult = false;
         g =0; // variavel de controle
        try{
            String consulta="SELECT Login,Senha FROM pessoa WHERE Login="
                    + "'"+login+"' AND senha='"+ senha+"'";
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                Pessoa a = new Pessoa();
                a.setLogin(rs.getString(1));
                a.setSenha(rs.getString(2));
                finalResult = true;
 g = 2; // se a pesquisa der certo g = 2
                
            }

        } catch (SQLException ex){
            g=0; // se a pesquisa der ruim g= 0, o que significa que o login ou senha esta errado
            JOptionPane.showMessageDialog(null, "ERRO NO CONSULTAR","ERRO",JOptionPane.ERROR_MESSAGE);
        }
        return finalResult;
    }
     

public boolean Logardesen(String senha, String login){
         boolean finalResult = false;
        try{
            
           String consulta="SELECT Login,Senha FROM acessototal WHERE Login="
                    + "'"+login+"' AND Senha='"+ senha+"'";

            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                acessototal ass = new acessototal();
                ass.setLogin(rs.getString(1));
                ass.setSenha(rs.getString(2));
                finalResult = true;
            }
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERRO NO CONSULTAR","ERRO",JOptionPane.ERROR_MESSAGE);
        }
        return finalResult;
}}

