package TradutorDAO;



import Atualisas.AtuFuncionario;
import Entrad.pesquisaCliTud;
import classes.Pessoa;
import classes.endereco;
import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;




/**
 * @author Vivian Raquel Batista Dantas de casa, cama.
 *
 * 
 */
public class PessoaDAO {
   // private DefaultListModel modelo,porq;
    public int controle = 0;
    
    
    /* public PessoaDAO(){
    //this.modelo = new DefaultListModel();
    
    }*/


     public boolean inserirPessoa (Pessoa ps) {
      String sql = "INSERT INTO pessoa (cpf,nome,Datanasc,Login,Senha, telefone)VALUES(?,?,?,?,?,?);"; //o proprio app estara inserindo dados na tabela pessoa do xamp
      boolean retorno = false; //variavel do tipo verdadeiro ou falso chamada "retorno" esta sendo criada e ela recebe o valor: falso
        PreparedStatement pst = Conexao.getPreparedStatement(sql);//preparar o xamp para receber informação//
        
      try {
          pst.setString(1,ps.getCpf());
          pst.setString(2,ps.getNome());
          pst.setString(3,ps.getDatanasc());
          pst.setString(4,ps.getLogin());
          pst.setString(5,ps.getSenha());
          pst.setString(6,ps.getTelefone());
          
          
          if(pst.executeUpdate()>0)
              retorno= true;
              
      } catch (SQLException e) {
           Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
          retorno = false;
      }
      
      return retorno;
        
        

        
    } 
    
      public boolean inserirEndereco (endereco end) {
          
      String sql = "INSERT INTO endereco (codigo,bairro,cep,cidade,endereco,fkcpf, NumerResiden,ur)VALUES(?,?,?,?,?,?,?,?);";
      boolean retorno = false;
      PreparedStatement pst = Conexao.getPreparedStatement(sql);
       try {
           
          pst.setString(1,end.getCodigo());
          pst.setString(2,end.getBairro());
          pst.setString(3,end.getCep());
          pst.setString(4,end.getCidade());
          pst.setString(5,end.getEndereco());
          pst.setString(6,end.getFkcpf());
          pst.setString(7,end.getNumerResiden());
          pst.setString(8,end.getUr());
          
          
          
          if(pst.executeUpdate()>0)
              retorno= true;
              
          
      } catch (SQLException e) {
           Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
         JOptionPane.showMessageDialog(null,"ERRO AO INSERIR","ERRO NA CONEXAO", JOptionPane.ERROR_MESSAGE);
      }
   return retorno;
      
}
 public int UltResistroEndereco () {
     
 int valor = 0;
 
      String sql = "SELECT * FROM endereco";
      endereco retorno = null;
      
      PreparedStatement pst = Conexao.getPreparedStatement(sql);
       try { 
          
           ResultSet res = pst.executeQuery();
           res.last();
           valor = Integer.parseInt(res.getString("codigo"));
           valor++;
         
              
      } catch (SQLException ex) {
          Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"Erro ao buscar o ultimo endereco","ERRO,", JOptionPane.CLOSED_OPTION);
      }
  
       return valor;


 }


public int UltResistroPessoa () {
     
 int valor = 0;
 
      String sql = "SELECT * FROM pessoa";
       Pessoa retorno = null;
      
      PreparedStatement pst = Conexao.getPreparedStatement(sql);
      
       try { 
          
           ResultSet res = pst.executeQuery();
           res.last();
           valor = Integer.parseInt(res.getString("cpf"));
           valor++;
         
              
      } catch (SQLException ex) {
          Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"Erro ao buscar a ultima pessoa","ERRO,", JOptionPane.CLOSED_OPTION);
      }
  
       return valor;
 }


public Pessoa buscarPessoa (String cpf)
        
{
    String sql = "SELECT * FROM mercado . pessoa where cpf=?";    
   Pessoa retorno = null;

   PreparedStatement pst = Conexao.getPreparedStatement(sql);
   try {
       pst.setString(1, cpf);
       ResultSet res = pst.executeQuery();
       
       if(res.next())
       {
           
           if (controle == 1){
               
           pesquisaCliTud.labCpf.setText(res.getString("cpf"));
           pesquisaCliTud.labNome.setText(res.getString("nome"));
           pesquisaCliTud.labNas.setText(res.getString("Datanasc"));
           pesquisaCliTud.labTelef.setText(res.getString("telefone"));
           
           controle =0;
       }
           else {
       
               retorno = new Pessoa();
           retorno.setCpf(res.getString("cpf"));
           retorno.setLogin(res.getString("Login"));
           retorno.setSenha(res.getString("Senha"));
           retorno.setDatanasc(res.getString("Datanasc"));
           retorno.setNome(res.getString("nome"));
           retorno.setTelefone(res.getString("telefone"));
       }}
   }  
      catch (SQLException ex) {
          Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"Erro ao buscar a ultima pessoa","ERRO,", JOptionPane.CLOSED_OPTION);
      }
  
       return retorno ;
}

public endereco buscarEnderecoPes (String end)
        
{String sql = "SELECT * FROM endereco where fkcpf=?";  
    
   
   endereco retorno = null;
   PreparedStatement pst = Conexao.getPreparedStatement(sql);
   try {
       pst.setString(1, end);
       ResultSet res = pst.executeQuery();
       
       if(res.next())
       {

           if (controle == 1){
           
        pesquisaCliTud.labCep.setText(res.getString("cep"));
        pesquisaCliTud.labCidade.setText(res.getString("cidade"));
        pesquisaCliTud.labEnd.setText(res.getString("endereco"));
        pesquisaCliTud.labNresid.setText(res.getString("NumerResiden"));
        pesquisaCliTud.labUR.setText(res.getString("ur"));
             
        controle = 0;
       } 
           else{
               
           retorno = new endereco();

           retorno.setCodigo(res.getString("codigo"));
           retorno.setBairro(res.getString("bairro"));
           retorno.setCep(res.getString("cep"));
           retorno.setCidade(res.getString("cidade"));
           retorno.setEndereco(res.getString("endereco"));
           retorno.setNumerResiden(res.getString("NumerResiden"));
           retorno.setUr(res.getString("ur"));
           retorno.setFkcpf(res.getString("fkcpf"));
           
           }
       
       }
   }  
      catch (SQLException ex) {
          Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"Erro ao buscar o endereço","ERRO,", JOptionPane.CLOSED_OPTION);
        
      }
  
       return retorno ;}

public boolean DropPeso (Pessoa p){

 String sql = "DELETE FROM `pessoa` WHERE cpf = ?";
 String sqlEnd="DELETE FROM endereco WHERE fkcpf = ?";   
 String sqlCl="DELETE FROM cliente WHERE fkcpf = ?";   
 
 PreparedStatement pst = Conexao.getPreparedStatement(sql);
 PreparedStatement pstEnd = Conexao.getPreparedStatement(sqlEnd);
 PreparedStatement pstCl = Conexao.getPreparedStatement(sqlCl);
 
 Boolean retorno = false;
 
 try {
     
     pst.setString(1, p.getCpf());
     pstCl.setString(1, p.getCpf());
     pstEnd.setString(1, p.getCpf());
    
     while(pst.executeUpdate()>0 && pstEnd.executeUpdate()>0 && pstCl.executeUpdate()>0){
       retorno = true ;}
          
}
    catch (SQLException ex) {
           Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"Erro ao excluir Cliente completo","ERRO,", JOptionPane.CLOSED_OPTION);
      }
return retorno;

}

public boolean AtualPessoa(Pessoa p){
    
    String sql = "UPDATE pessoa SET Login=?,Datanasc=?, telefone=?,Senha=?,nome=? WHERE cpf=?";
  
    PreparedStatement pst = Conexao.getPreparedStatement(sql);

  try {
     
    pst.setString(1, p.getLogin());
    pst.setString(2, p.getDatanasc());
    pst.setString(3, p.getTelefone());
    pst.setString(4, p.getSenha());
    pst.setString(5, p.getNome());    
    pst.setString(6, p.getCpf());

if(pst.executeUpdate()>0){
   
       return true ;
}}
    catch (SQLException ex) {
           Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"Erro ao atualizar pessoa e endereco","ERRO,", JOptionPane.CLOSED_OPTION);
      }
  
       return false ;

}public boolean AtualEnd(endereco end){
    
    String sqlEnd = "UPDATE endereco SET `ur`=?,`NumerResiden`=?,`cidade`=?,`endereco`=?,`bairro`=?,`cep`=? WHERE `fkcpf`=?";

    PreparedStatement pstEnd = Conexao.getPreparedStatement(sqlEnd);
  try {

    pstEnd.setString(1, end.getUr());
    pstEnd.setString(2, end.getNumerResiden());
    pstEnd.setString(3, end.getCidade());
    pstEnd.setString(4, end.getEndereco());
    pstEnd.setString(5, end.getBairro());
    pstEnd.setString(6, end.getCep());
    pstEnd.setString(7, end.getFkcpf());
    
if(pstEnd.executeUpdate()>0){
   
       return true ;
}}
    catch (SQLException ex) {
           Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"Erro ao atualizar pessoa e endereco","ERRO,", JOptionPane.CLOSED_OPTION);
      }
  
       return false ;

}}
/*

public boolean ExcluirPessoa (String CPF){

 String sql = "DELETE FROM `pessoa` WHERE CPF = ?";
 String sqlAluno="DELETE FROM aluno WHERE fkcpf = ?";   
   
 PreparedStatement pst = Conexao.getPreparedStatement(sql);
 PreparedStatement pstAl = Conexao.getPreparedStatement(sqlAluno);
Boolean retorno = false;
 try {
     pstAl.setString(1, CPF);
     
     while(pstAl.executeUpdate()>0)
       retorno = true ;
     
      pst.setString(1, CPF);
     
     while(pst.executeUpdate()>0)
       retorno = true ;
     
     
}
    catch (SQLException ex) {
           Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"Erro ao excluir pessoa","ERRO,", JOptionPane.CLOSED_OPTION);
      }


        return retorno;

}}*/



