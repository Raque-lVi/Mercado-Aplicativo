/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TradutorDAO;

import Janelas.SofrendoNaCalculadora;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
/**
 *
 * @author User1
 */

public class CauculadoraDAO {
    private DefaultListModel modelo,porq;
    private String comando;
    private ResultSet rs = null;
    
    public CauculadoraDAO(){
    this.modelo = new DefaultListModel();
    this.porq = new DefaultListModel();
    }
    
    Connection com;
    ResultSet res;
        
    float precoNomep, TodoC;

    int p = 0;
        
    public void calcularTodo () {
        
        try{
   
            float Calculardo = (Float.parseFloat(SofrendoNaCalculadora.txCalculo.getText()));
           // Calculardo= 7.99

            if(Calculardo == precoNomep){
                Calculardo = precoNomep;
            }
            else{

                Calculardo = precoNomep + Calculardo;  
            }
            SofrendoNaCalculadora.txCalculo.setText(Calculardo+"");
            SofrendoNaCalculadora.txQtddP.setText(null);
        }
        catch (NumberFormatException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar o nome do Produto","ERRO,", JOptionPane.CLOSED_OPTION);
        }
    }
    
    public void calcularQProd () {
        
        try{
        
            float Calculardo = (Float.parseFloat(SofrendoNaCalculadora.txCalculo.getText()));
            int digitadoQTDD = (Integer.parseInt(SofrendoNaCalculadora.txQtddP.getText()));
            
            TodoC = precoNomep * digitadoQTDD; 

            if(Calculardo == precoNomep){

                Calculardo = TodoC;
            }
            else{

                TodoC = TodoC - precoNomep;
                Calculardo = TodoC + Calculardo;  
            }
        //aqui cima

        //Prestar ATENÇÃO pois se o programa ja tiver rolado 1 vez com "Maracujar"  por exemplo
        //Então se botar para ele para calcular a quantidade denovo no mesmo produto sem pesquisar outro produto
        // o presso sairá errado (o sistema "comera" 1 produto)
        // portanto tera de pesquisar o mesmo produto para que se possa adicionar mais uma quantidade ao preço
        
            SofrendoNaCalculadora.txCalculo.setText(Calculardo+"");
            SofrendoNaCalculadora.txQtddP.setText(null);
       
        }  
        catch (NumberFormatException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar o nome do Produto","ERRO,", JOptionPane.CLOSED_OPTION);
        }
    }
       

    public void Pesquisa(){
        
        try{
        
            this.comando = "SELECT * FROM mercado . estoque where NOMEP LIKE '%"+SofrendoNaCalculadora.txNomep.getText().toUpperCase().trim()+"%'";  
            this.modelo.removeAllElements();
            int v = 0;
    
            PreparedStatement pst = Conexao.getPreparedStatement(comando);
            rs = pst.executeQuery();
    
            while(rs.next() & v <= 4 ){ //quantidade de dados na lista 
                
                this.modelo.addElement(rs.getString("NOMEP"));
                 v++;          
            }
            SofrendoNaCalculadora.ListaNomes.setModel(modelo);
            
            if(v>=1){
                SofrendoNaCalculadora.ListaNomes.setVisible(true);
            }
            else{
                SofrendoNaCalculadora.ListaNomes.setVisible(false);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar o nome do Produto","ERRO,", JOptionPane.CLOSED_OPTION);
        }
    }
    
    
    public void LinhaClicada(){
        
        try{
           //this.porq.removeAllElements();
            int linha = SofrendoNaCalculadora.ListaNomes.getSelectedIndex();
           
            if(linha>=0){
                linha++;
                this.comando = "SELECT* FROM estoque where NOMEP = '"+SofrendoNaCalculadora.ListaNomes.getSelectedValue()+"';";

                PreparedStatement pst = Conexao.getPreparedStatement(comando);
                rs = pst.executeQuery(comando);
                
                if(rs.next()){
                    //this.modelo.addElement(rs.getString("NOMEP"));

                    SofrendoNaCalculadora.txpreco1.setText(rs.getString("preco"));
                    SofrendoNaCalculadora.ListaNomes.setModel(modelo);
                    SofrendoNaCalculadora.txNomep.setText(rs.getString("NOMEP"));
                    precoNomep = (rs.getFloat("preco"));
                    this.porq.addElement(rs.getString("NOMEP"));
                    SofrendoNaCalculadora.listNomesAnt.setModel(porq);

                    float cauculo = (Float.parseFloat(SofrendoNaCalculadora.txCalculo.getText()));

                    if(cauculo== 0){
                        SofrendoNaCalculadora.txCalculo.setText(rs.getString("preco"));
                    } 
                }
            }
        }
        catch (SQLException ex) {
             Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,"Erro ao buscar os dados do Produto","ERRO,", JOptionPane.CLOSED_OPTION);
        }
    } 
}
