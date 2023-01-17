/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chefa;

import Chefa.SofrendoNaCalculadChef;
import Janelas.InformaçõesCompra;
import static Chefa.SofrendoNaCalculadChef.listNomesAnt;
import TradutorDAO.*;
import classes.Compra;
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
    private DefaultListModel modelo,porq;
    private String comando;
    private ResultSet rs = null;
    public float precoC, ganhoC, precoComp;
    public int Fkestoque, quantidade;
    
    
    public CauculadoraDaoChef(){
    this.modelo = new DefaultListModel();
    this.porq = new DefaultListModel();
    
    }
    
    Connection com;
        ResultSet res;
        Comprapeq comC = new Comprapeq ();
        
        float precoNomep, TodoC;
        int p = 0;
        int p1 = 0,p2,p3,p4,p5,p6;
        
    public void calcularTodo () {
        
        try{
            
            float Calculardo = (Float.parseFloat(SofrendoNaCalculadChef.txCalculo.getText()));
           
           if(Calculardo == precoNomep){

        Calculardo = precoNomep;

           }else{
               
              Calculardo = precoNomep + Calculardo;  
           }
       SofrendoNaCalculadChef.txCalculo.setText(Calculardo+"");
       SofrendoNaCalculadChef.txQtddP.setText(null);
       
        }  catch (NumberFormatException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar o nome do Produto","ERRO,", JOptionPane.CLOSED_OPTION);
      }
    
    }
        public void calcularQProd () {
        
        try{

        float Calculardo = (Float.parseFloat(SofrendoNaCalculadChef.txCalculo.getText()));
        int digitadoQTDD = (Integer.parseInt(SofrendoNaCalculadChef.txQtddP.getText()));
       
        TodoC = precoNomep * digitadoQTDD; 
//aqui baixo
        if(Calculardo == precoNomep){

        Calculardo = TodoC;

           }else{
            
              TodoC = TodoC - precoNomep;
              
              Calculardo = TodoC + Calculardo;  
              
           }
        //aqui cima

        //Prestar ATENÇÃO pois se o programa ja tiver rolado 1 vez com "Maracujar"  por exemplo
        //Então se botar para ele para calcular a quantidade denovo no mesmo produto sem pesquisar outro produto
        // o presso sairá errado (o sistema "comera" 1 produto)
        // portanto tera de pesquisar o mesmo produto para que se possa adicionar mais uma quantidade ao preço

       SofrendoNaCalculadChef.txCalculo.setText(Calculardo+"");
       SofrendoNaCalculadChef.txQtddP.setText(null);
       
        }  catch (NumberFormatException ex) {
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
    
            while(rs.next() & v <= 4 //quantidade de dados na lista 
                    ){
                
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
        
    //pegar o valor e fazas a pesquisa
        
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

    public void PesquisaProdut(String NomePrAnt) {
       
       // Compra com = new Compra();
        Compra comp = new Compra();
        
    try{
        String arica = (SofrendoNaCalculadChef.listNomesAnt.getModel().getElementAt(pat));
        
    this.comando = "SELECT* FROM estoque where NOMEP = '"+arica+"';";

                PreparedStatement pst = Conexao.getPreparedStatement(comando);
                rs = pst.executeQuery(comando);
                
                    if(rs.next()){
                      //  int s = Integer.parseInt(SofrendoNaCalculadChef.labNuList.getText());
                        pat++;
                        
                            if ( pat == 1){ comp.setFkcodigoEst1(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 2){ comp.setFkcodigoEst2(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 3){ comp.setFkcodigoEst3(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 4){ comp.setFkcodigoEst4(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 5){ comp.setFkcodigoEst5(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 6){ comp.setFkcodigoEst6(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 7){ comp.setFkcodigoEst7(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 8){ comp.setFkcodigoEst8(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 9){ comp.setFkcodigoEst9(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 10){ comp.setFkcodigoEst10(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 11){ comp.setFkcodigoEst11(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 12){ comp.setFkcodigoEst12(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 13){ comp.setFkcodigoEst13(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 14){ comp.setFkcodigoEst14(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 15){ comp.setFkcodigoEst15(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 16){ comp.setFkcodigoEst16(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 17){ comp.setFkcodigoEst17(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 18){ comp.setFkcodigoEst18(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 19){ comp.setFkcodigoEst19(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 20){ comp.setFkcodigoEst20(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 21){ comp.setFkcodigoEst21(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 22){ comp.setFkcodigoEst22(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 23){ comp.setFkcodigoEst23(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 24){ comp.setFkcodigoEst24(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 25){ comp.setFkcodigoEst25(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 26){ comp.setFkcodigoEst26(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 27){ comp.setFkcodigoEst27(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 28){ comp.setFkcodigoEst28(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 29){ comp.setFkcodigoEst29(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 30){ comp.setFkcodigoEst30(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 31){ comp.setFkcodigoEst31(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 32){ comp.setFkcodigoEst32(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 33){ comp.setFkcodigoEst33(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 34){ comp.setFkcodigoEst34(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 35){ comp.setFkcodigoEst35(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 36){ comp.setFkcodigoEst36(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 37){ comp.setFkcodigoEst37(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 38){ comp.setFkcodigoEst38(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 39){ comp.setFkcodigoEst39(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
                            if ( pat == 40){ comp.setFkcodigoEst40(rs.getInt("codigo")); System.out.print(rs.getInt("NOMEP"));}
 
                        if (pat >= 40){
                            
                            InformaçõesCompra inCom = new InformaçõesCompra ();
                            CompraDao comD = new CompraDao();
                            
                            inCom.setVisible(true);
                            
                            comD.inserirCompra(comp);
                            
                            pat = 0;

                        }
                        /*  if(p1== 0)    {
                        p1 = (Integer.parseInt(rs.getString("codigo")));}
                        if(p2== 0)    {
                        p2 = (Integer.parseInt(rs.getString("codigo")));}
                        if(p3== 0)    {
                        p3 = (Integer.parseInt(rs.getString("codigo")));}*/
               //????????? 

// SO SALVA UM :() VAI TER QUE SALVAR COMPRA POR COMPRA NO BANCO DE DADOS
              }
  
    }
           
        catch (SQLException ex) {
             Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,"Erro ao buscar os dados do Produto","ERRO,", JOptionPane.CLOSED_OPTION);
      }
    
    }
    
    public void PesquisaClient(){
        
        try{
        
            this.comando = "SELECT * FROM mercado . pessoa where nome LIKE '%"+SofrendoNaCalculadChef.txNomeC.getText().toUpperCase().trim()+"%'";  
            this.modelo.removeAllElements();
            int v = 0;
    
            PreparedStatement pst = Conexao.getPreparedStatement(comando);
            rs = pst.executeQuery();
    
            while(rs.next() & v <= 4 //quantidade de dados na lista 
                    ){
                
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
    //pegar o valor e fazas a pesquisa
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
    
    
    public Comprapeq PesquisaProdutC(String NomePrAnt) {
       
        CompraDao comDa = new CompraDao();
        Comprapeq comp = new Comprapeq();

        
    try{
        String alter = "UPDATE estoque SET qtdp=? WHERE codigo=?";
        
    this.comando = "SELECT* FROM estoque where NOMEP = '"+NomePrAnt+"';";

                PreparedStatement pstAlt = Conexao.getPreparedStatement(alter);
                PreparedStatement pst = Conexao.getPreparedStatement(comando);
                rs = pst.executeQuery(comando);
                
                    if(rs.next()){
                        
                        Fkestoque = (Integer.parseInt(rs.getString("codigo")));
                        comp.setPrecoP(Float.parseFloat(rs.getString("preco")));

                        precoC = (Float.parseFloat(rs.getString("preco")));
                        precoComp = (Float.parseFloat(rs.getString("precoPcom")));
                        ganhoC = precoC - precoComp;
                        int QuanP = (Integer.parseInt(rs.getString("qtdp")));
                        
                        comp.setGanho(ganhoC);
                        
                        quantidade = 1;
                        
                        /* SISTEMA DE BAIXA NO ESTOQUE ERRO NA QUANTIDADE
                        
                        ESSE SISTEMA NÃO CAPTURA A QUANTIDADE DE PRODUTOS PELO PRODUTO ESCOLIDO PORTANTO ELE SO VAI FUNCIONAR 
                        CASO VOCÊ QUEIRA COMPRAR A MESMA QUANTIDADE DE PRODUTOS PARA CADA PRODUTO
                        TALVEZ UMA MANEIRA DE RESOLVER ISSO SEJA ADICIONANDO UMA NOVA LISTA AO LADO DA LISTA DE
                        NOMES ANTIGOS QUE SEJA CAPAZ DE CAPTURAR AS QUANTIDADES DO TXQTDDP AO TEMPO QUE ADD OS NOMES DOS PRODUTOS
                        ANTIGOS NA LISTA DELES E CALCULA O VALOR TOTAL.
                        
                        
                        if(SofrendoNaCalculadChef.txQtddP.getText() == null){
                        
                        quantidade = 1;
                        
                        } else {
                        
                        quantidade = Integer.parseInt(SofrendoNaCalculadChef.txQtddP.getText());
                        
                        }
                        
                        QuanP = QuanP-quantidade; // O ERRO É POR AQUI
                        
                        pstAlt.setString(1, QuanP+"");
                        pstAlt.setString(2,Fkestoque +"" );
                        
                        rs = pst.executeQuery(alter);
                        
                        if(rs.next()){
                        return comp;}
                        else{
                        JOptionPane.showMessageDialog(null,"Erro ao alterar a quantidade de produto","ERRO,", JOptionPane.CLOSED_OPTION);
                        }*/
                             
                    }else {quantidade = 0;}
    }
           
        catch (SQLException ex) {
             Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,"Erro ao buscar os dados do Produto","ERRO,", JOptionPane.CLOSED_OPTION);
      }
        return comp;
    
    }
  
    
    
}
