/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TradutorDAO;

import Chefa.CauculadoraDaoChef;
import Chefa.SofrendoNaCalculadChef;
import static Chefa.SofrendoNaCalculadChef.listNomesAnt;
import classes.Compra;
import classes.Comprapeq;
import classes.datas;
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
public int o = 0;
        public boolean inserirCompra (Compra com) {
          
      String sql = "INSERT INTO compra (codigo,fkpessoa,fkdata, fkcodigoEst1, QuantProd1, fkcodigoEst2, QuantProd2, fkcodigoEst3, QuantProd3, fkcodigoEst4,"
              + " QuantProd4, fkcodigoEst5, QuantProd5, fkcodigoEst6, QuantProd6, fkcodigoEst7, QuantProd7, fkcodigoEst8, QuantProd8, fkcodigoEst9,"
              + " QuantProd9, fkcodigoEst10, QuantProd10, fkcodigoEst11, QuantProd11, fkcodigoEst12, QuantProd12, fkcodigoEst13, QuantProd13,"
              + " fkcodigoEst14, QuantProd14, fkcodigoEst15, QuantProd15, fkcodigoEst16, QuantProd16, fkcodigoEst17, QuantProd17, fkcodigoEst18,"
              + " QuantProd18, fkcodigoEst19, QuantProd19, fkcodigoEst20, QuantProd20, fkcodigoEst21, QuantProd21, fkcodigoEst22, QuantProd22,"
              + " fkcodigoEst23, QuantProd23, fkcodigoEst24, QuantProd24, fkcodigoEst25, QuantProd25, fkcodigoEst26, QuantProd26, fkcodigoEst27,"
              + " QuantProd27, fkcodigoEst28, QuantProd28, fkcodigoEst29, QuantProd29, fkcodigoEst30, QuantProd30, fkcodigoEst31, QuantProd31,"
              + " fkcodigoEst32, QuantProd32, fkcodigoEst33, QuantProd33, fkcodigoEst34, QuantProd34, fkcodigoEst35, QuantProd35, fkcodigoEst36,"
              + " QuantProd36, fkcodigoEst37, QuantProd37, fkcodigoEst38, QuantProd38, fkcodigoEst39, QuantProd39, fkcodigoEst40, QuantProd40 ) "
              + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
              + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,);";
      
      
      boolean retorno = false;
      PreparedStatement pst = Conexao.getPreparedStatement(sql);
       try {

           

          pst.setString(1,com.getCodigo());//1
          pst.setString(2,com.getFkpessoa());//2
          pst.setInt(3,com.getFkdata());//3
          pst.setInt(4,com.getFkcodigoEst1 ());//4 
          pst.setInt(5,com.getQuantProd1 ());//5 
          pst.setInt(6,com.getFkcodigoEst2 ());//6 
          pst.setInt(7,com.getQuantProd2 ());//7 
          pst.setInt(8,com.getFkcodigoEst3 ());//8 
          pst.setInt(9,com.getQuantProd3 ());//9 
          pst.setInt(10,com.getFkcodigoEst4 ());//10 
          pst.setInt(11,com.getQuantProd4 ());//11 
          pst.setInt(12,com.getFkcodigoEst5 ());//12 
          pst.setInt(13,com.getQuantProd5 ());//13 
          pst.setInt(14,com.getFkcodigoEst6 ());//14 
          pst.setInt(15,com.getQuantProd6 ());//15 
          pst.setInt(16,com.getFkcodigoEst7 ());//16 
          pst.setInt(17,com.getQuantProd7 ());//17 
          pst.setInt(18,com.getFkcodigoEst8 ());//18 
          pst.setInt(19,com.getQuantProd8 ());//19 
          pst.setInt(20,com.getFkcodigoEst9 ());//20 
          pst.setInt(21,com.getQuantProd9 ());//21 
          pst.setInt(22,com.getFkcodigoEst10 ());//22 
          pst.setInt(23,com.getQuantProd10 ());//23 
          pst.setInt(24,com.getFkcodigoEst11 ());//24 
          pst.setInt(25,com.getQuantProd11 ());//25 
          pst.setInt(26,com.getFkcodigoEst12 ());//26 
          pst.setInt(27,com.getQuantProd12 ());//27 
          pst.setInt(28,com.getFkcodigoEst13 ());//28 
          pst.setInt(29,com.getQuantProd13 ());//29 
          pst.setInt(30,com.getFkcodigoEst14 ());//30 
          pst.setInt(31,com.getQuantProd14 ());//31 
          pst.setInt(32,com.getFkcodigoEst15 ());//32 
          pst.setInt(33,com.getQuantProd15 ());//33 
          pst.setInt(34,com.getFkcodigoEst16 ());//34 
          pst.setInt(35,com.getQuantProd16 ());//35 
          pst.setInt(36,com.getFkcodigoEst17 ());//36 
          pst.setInt(37,com.getQuantProd17 ());//37 
          pst.setInt(38,com.getFkcodigoEst18 ());//38 
          pst.setInt(39,com.getQuantProd18 ());//39 
          pst.setInt(40,com.getFkcodigoEst19 ());//40 
          pst.setInt(41,com.getQuantProd19 ());//41 
          pst.setInt(42,com.getFkcodigoEst20 ());//42 
          pst.setInt(43,com.getQuantProd20 ());//43 
          pst.setInt(44,com.getFkcodigoEst21 ());//44 
          pst.setInt(45,com.getQuantProd21 ());//45 
          pst.setInt(46,com.getFkcodigoEst22 ());//46 
          pst.setInt(47,com.getQuantProd22 ());//47 
          pst.setInt(48,com.getFkcodigoEst23 ());//48 
          pst.setInt(49,com.getQuantProd23 ());//49 
          pst.setInt(50,com.getFkcodigoEst24 ());//50 
          pst.setInt(51,com.getQuantProd24 ());//51 
          pst.setInt(52,com.getFkcodigoEst25 ());//52 
          pst.setInt(53,com.getQuantProd25 ());//53 
          pst.setInt(54,com.getFkcodigoEst26 ());//54 
          pst.setInt(55,com.getQuantProd26 ());//55 
          pst.setInt(56,com.getFkcodigoEst27 ());//56 
          pst.setInt(57,com.getQuantProd27 ());//57 
          pst.setInt(58,com.getFkcodigoEst28 ());//58 
          pst.setInt(59,com.getQuantProd28 ());//59 
          pst.setInt(60,com.getFkcodigoEst29 ());//60 
          pst.setInt(61,com.getQuantProd29 ());//61 
          pst.setInt(62,com.getFkcodigoEst30 ());//62 
          pst.setInt(63,com.getQuantProd30 ());//63 
          pst.setInt(64,com.getFkcodigoEst31 ());//64 
          pst.setInt(65,com.getQuantProd31 ());//65 
          pst.setInt(66,com.getFkcodigoEst32 ());//66 
          pst.setInt(67,com.getQuantProd32 ());//67 
          pst.setInt(68,com.getFkcodigoEst33 ());//68 
          pst.setInt(69,com.getQuantProd33 ());//69 
          pst.setInt(70,com.getFkcodigoEst34 ());//70 
          pst.setInt(71,com.getQuantProd34 ());//71 
          pst.setInt(72,com.getFkcodigoEst35 ());//72 
          pst.setInt(73,com.getQuantProd35 ());//73 
          pst.setInt(74,com.getFkcodigoEst36 ());//74 
          pst.setInt(75,com.getQuantProd36 ());//75 
          pst.setInt(76,com.getFkcodigoEst37 ());//76 
          pst.setInt(77,com.getQuantProd37 ());//77 
          pst.setInt(78,com.getFkcodigoEst38 ());//78 
          pst.setInt(79,com.getQuantProd38 ());//79 
          pst.setInt(80,com.getFkcodigoEst39 ());//80 
          pst.setInt(81,com.getQuantProd39 ());//81 
          pst.setInt(82,com.getFkcodigoEst40 ());//82 
          pst.setInt(83,com.getQuantProd40 ());//83 
          
          if(pst.executeUpdate()>=0)
              retorno= true;
              
      } catch (SQLException e) {
           Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
         JOptionPane.showMessageDialog(null,"ERRO AO INSERIR","ERRO NA CONEXAO", JOptionPane.ERROR_MESSAGE);
      }
   return retorno;
        }
    
    
      public boolean inserirComp (Comprapeq comp) {
          
        CauculadoraDaoChef calChef = new CauculadoraDaoChef();
          
        calChef.PesquisaProdutC(SofrendoNaCalculadChef.listNomesAnt.getModel().getElementAt(o));
          
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
              
      } }catch (SQLException e) {
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
           
           }else{  
               
           valor = 0;
           
           }    
      } catch (SQLException ex) {
          Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"Erro ao buscar o ultima compra","ERRO,", JOptionPane.CLOSED_OPTION);
      }
  
       return valor;
 }

}