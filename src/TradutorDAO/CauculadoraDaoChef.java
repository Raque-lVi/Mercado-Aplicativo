/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TradutorDAO;

import Chefa.SofrendoNaCalculadChef;
import static Chefa.SofrendoNaCalculadChef.listQtddP;
import static TradutorDAO.CompraDao.o;
import classes.Comprapeq;
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
public class CauculadoraDaoChef {
    private DefaultListModel modelo,porq, quantP, sos;
    private String comando;
    private ResultSet rs = null;
    public float precoC, ganhoC, precoComp;
    public int Fkestoque, quantidade;
    
    
    public CauculadoraDaoChef(){
    this.modelo = new DefaultListModel();
    this.porq = new DefaultListModel();
    this.quantP = new DefaultListModel();
    this.sos = new DefaultListModel();
    }
    
    Connection com;
    ResultSet res;
    Comprapeq comC = new Comprapeq ();
    float precoNomep, TodoC;
        
    public void calcularTodo () {
        
        try{
            float Calculardo = (Float.parseFloat(SofrendoNaCalculadChef.txCalculo.getText()));
            int digitadoQTDD = (Integer.parseInt(SofrendoNaCalculadChef.txQtddP.getText()));
            
            if(Calculardo == precoNomep){

            Calculardo = precoNomep;
            }
            else{
                Calculardo = precoNomep + Calculardo;  
           }
           
            this.quantP.addElement(digitadoQTDD+"");
            
            SofrendoNaCalculadChef.txCalculo.setText(Calculardo+"");
            SofrendoNaCalculadChef.txQtddP.setText("1");
            SofrendoNaCalculadChef.listQtddP.setModel(quantP);
       
        }  
        catch (NumberFormatException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar o nome do Produto","ERRO,", JOptionPane.CLOSED_OPTION);
      }
    
    }
    public void calcularQProd () {

        try{
            int Nremov = Integer.parseInt(SofrendoNaCalculadChef.labNuList.getText());
            Nremov = Nremov -1;
            
            if( Nremov >-1){

                this.quantP.remove(Nremov);
                SofrendoNaCalculadChef.listQtddP.setModel(quantP);
            }

            float Calculardo = (Float.parseFloat(SofrendoNaCalculadChef.txCalculo.getText()));
            int digitadoQTDD = (Integer.parseInt(SofrendoNaCalculadChef.txQtddP.getText()));

            TodoC = precoNomep * digitadoQTDD; 
    
            if(Calculardo == precoNomep){

                Calculardo = TodoC;

            }
            else{

                TodoC = TodoC - precoNomep;
                Calculardo = TodoC + Calculardo;  

           }
            this.quantP.addElement(digitadoQTDD+"");
        

        //Prestar ATENÇÃO pois se o programa ja tiver rolado 1 vez com "Maracujar"  por exemplo
        //Então se botar para ele para calcular a quantidade denovo no mesmo produto sem pesquisar outro produto
        // o presso sairá errado (o sistema "comera" 1 produto)
        // portanto tera de pesquisar o mesmo produto para que se possa adicionar mais uma quantidade ao preço

            SofrendoNaCalculadChef.txCalculo.setText(Calculardo+"");
            SofrendoNaCalculadChef.txQtddP.setText("1");
            SofrendoNaCalculadChef.listQtddP.setModel(quantP);
        }  
        catch (NumberFormatException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar o nome do Produto","ERRO,", JOptionPane.CLOSED_OPTION);
        }
    }
       

    public void Pesquisa(){
        
        try{
        
            this.comando = "SELECT * FROM mercado . estoque where NOMEP LIKE '%"+SofrendoNaCalculadChef.txNomep.getText().toUpperCase().trim()+"%'";  
            this.modelo.removeAllElements();
            int v = 0;
    
            PreparedStatement pst = Conexao.getPreparedStatement(comando);
            rs = pst.executeQuery();
    
            while(rs.next() & v <= 4 ){ //quantidade de dados na lista 
                
                this.modelo.addElement(rs.getString("NOMEP"));
                 v++;          
            }
            
            SofrendoNaCalculadChef.ListaNomes.setModel(modelo);
            
            if(v>=1){
                SofrendoNaCalculadChef.ListaNomes.setVisible(true);
            }else{
                SofrendoNaCalculadChef.ListaNomes.setVisible(false);
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
            int linha = SofrendoNaCalculadChef.ListaNomes.getSelectedIndex();
           
            if(linha>=0){
                linha++;
                this.comando = "SELECT* FROM estoque where NOMEP = '"+SofrendoNaCalculadChef.ListaNomes.getSelectedValue()+"';";

                PreparedStatement pst = Conexao.getPreparedStatement(comando);
                rs = pst.executeQuery(comando);
                
                if(rs.next()){

                    //this.modelo.addElement(rs.getString("NOMEP"));

                    SofrendoNaCalculadChef.txpreco1.setText(rs.getString("preco"));
                    SofrendoNaCalculadChef.ListaNomes.setModel(modelo);
                    SofrendoNaCalculadChef.txNomep.setText(rs.getString("NOMEP"));
                    precoNomep = (rs.getFloat("preco"));
                    this.porq.addElement(rs.getString("NOMEP"));
                    SofrendoNaCalculadChef.listNomesAnt.setModel(porq);

                    int j = Integer.parseInt(SofrendoNaCalculadChef.labNuList.getText());
                    j++;
                    SofrendoNaCalculadChef.labNuList.setText(j+"");

                    float cauculo = (Float.parseFloat(SofrendoNaCalculadChef.txCalculo.getText()));

                    if(cauculo== 0){

                        SofrendoNaCalculadChef.txCalculo.setText(rs.getString("preco"));
                    } 


                    }
            }}
        catch (SQLException ex) {
             Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,"Erro ao buscar os dados do Produto","ERRO,", JOptionPane.CLOSED_OPTION);
      }
    
    }
    
    int pat = 0;
    
    public void PesquisaClient(){
        
        try{
        
            this.comando = "SELECT * FROM mercado . pessoa where nome LIKE '%"+SofrendoNaCalculadChef.txNomeC.getText().toUpperCase().trim()+"%'";  
            this.modelo.removeAllElements();
            int v = 0;
    
            PreparedStatement pst = Conexao.getPreparedStatement(comando);
            rs = pst.executeQuery();
    
            while(rs.next() & v <= 4){ //quantidade de dados na lista
                
                this.modelo.addElement(rs.getString("nome"));
                 v++;          
            }
            
            SofrendoNaCalculadChef.ListaNomesCli.setModel(modelo);
            
            if(v>=1){
                SofrendoNaCalculadChef.ListaNomesCli.setVisible(true);
 
            }else{
                SofrendoNaCalculadChef.ListaNomesCli.setVisible(false);
                }
            }
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar o nome da pessoa","ERRO,", JOptionPane.CLOSED_OPTION);
      }
    
    }

    
    public String LinhaClicadaClient(){
        String fk = null;
        try{
            int linha = SofrendoNaCalculadChef.ListaNomesCli.getSelectedIndex();
           
            if(linha>=0){
                linha++;
                this.comando = "SELECT* FROM pessoa where nome = '"+SofrendoNaCalculadChef.ListaNomesCli.getSelectedValue()+"';";

                PreparedStatement pst = Conexao.getPreparedStatement(comando);
                rs = pst.executeQuery(comando);
                
                if(rs.next()){

                    SofrendoNaCalculadChef.ListaNomesCli.setModel(modelo);
                    SofrendoNaCalculadChef.txNomeC.setText(rs.getString("nome"));


                    comC.setFkpessoa(rs.getString("cpf"));

                    SofrendoNaCalculadChef.ListaNomesCli.setVisible(false);
                     fk = (rs.getString("cpf"));

                    }
            }}
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar os dados do Produto","ERRO,", JOptionPane.CLOSED_OPTION);
      }
        return fk;
    }
}
