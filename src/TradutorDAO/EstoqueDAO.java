/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TradutorDAO;

import Chefa.SofrendoNaCalculadChef;
import static Chefa.SofrendoNaCalculadChef.listQtddP;
import Entrad.pesquisaCliTud;
import static TradutorDAO.CompraDao.o;
import classes.Categoria;
import classes.Comprapeq;
import classes.estoque;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User1
 */
public class EstoqueDAO {
    Connection com;
    private String comando;
    private ResultSet rs = null;
    public float precoC, ganhoC, precoComp;
    public int Fkestoque, quantidade;
    
    public int controle = 0;
    
    public boolean inserirEstoque (estoque est, String cat) {
        
        String sql = "INSERT INTO estoque (NOMEP,codigo,qtdp,precoPcom,preco,fkcodigo)VALUES(?,?,?,?,?,?);"; //o proprio app estara inserindo dados na tabela pessoa do xamp
        boolean retorno = false; //variavel do tipo verdadeiro ou falso chamada "retorno" esta sendo criada e ela recebe o valor: falso

        PreparedStatement pst = Conexao.getPreparedStatement(sql);//preparar o xamp para receber informação//

        
        try {
          
            pst.setString(1,est.getNOMEP());
            pst.setInt(2,est.getCodigo());
            pst.setInt(3,est.getQtdp());
            pst.setFloat(4,est.getPrecoPcom());
            pst.setFloat(5,est.getPreco());
            pst.setString(6,cat);

            if(pst.executeUpdate()>0){
                retorno= true;
            }
        } 
        catch (SQLException e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null,"ERRO AO INSERIR Estoque","ERRO NA CONEXAO", JOptionPane.ERROR_MESSAGE);

            retorno = false;
        }
        return retorno;
    }
    
    
    public boolean inserirCate(Categoria cat) {
        String sql = "INSERT INTO categoria (ID,CATEGORIA)VALUES(?,?);"; //o proprio app estara inserindo dados na tabela pessoa do xamp
        boolean retorno = false; //variavel do tipo verdadeiro ou falso chamada "retorno" esta sendo criada e ela recebe o valor: falso
        PreparedStatement pst = Conexao.getPreparedStatement(sql);//preparar o xamp para receber informação//
        
        try {
            pst.setInt(1,cat.getID());
            pst.setString(2,cat.getCategoria());

            if(pst.executeUpdate()>0)
                retorno= true;
        } 
        catch (SQLException e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
            retorno = false;
        }
        return retorno;
    }
    
    
    public int UltResistroEstoque () {
     
        int valor = 0;

        String sql = "SELECT * FROM estoque";
        estoque retorno = null;

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
            JOptionPane.showMessageDialog(null,"Erro ao buscar o ultimo estoque","ERRO,", JOptionPane.CLOSED_OPTION);
        }
        return valor;
    }
    
                    //BUSCAR CATEGORIA PELO NOME
    
    public Categoria buscarCategoria (String nome){

        String sql = "SELECT * FROM categoria where CATEGORIA=?";    
        Categoria retorno = null;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();

            if(rs.next()){

                retorno = new Categoria();
                retorno.setID(rs.getInt("ID"));
                retorno.setCategoria(rs.getString("CATEGORIA"));
            }
        }  
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar o ultima Produto","ERRO,", JOptionPane.CLOSED_OPTION);
        }
        return retorno ;
    }
                            // BUSCAR CATEGORIA PELO ID

    public Categoria buscarCategoriaiD (int fkcategoria){
        String sql = "SELECT * FROM categoria where ID=?";    
        Categoria retorno = null;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setInt(1, fkcategoria);
            ResultSet rs = pst.executeQuery();

            if(rs.next()){ 
                pesquisaCliTud.labCate.setText(rs.getString("CATEGORIA"));
                controle = 0;
            }
        }  
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar o ultima Produto","ERRO,", JOptionPane.CLOSED_OPTION);
        }
        return null ;
    }
                            //BUSCAR ESTOQUE

    public estoque buscarEstoque (String cod){  
        String sql = "SELECT * FROM estoque where codigo = ?";  
        estoque retorno = null;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, cod);
            ResultSet rs = pst.executeQuery();

            if(rs.next()){

                if(controle == 1){

                    pesquisaCliTud.labCod.setText(rs.getInt("codigo")+"");
                    pesquisaCliTud.labNomeP.setText(rs.getString("NOMEP"));
                    pesquisaCliTud.labPreCom.setText(rs.getFloat("precoPcom")+"");
                    pesquisaCliTud.labPreVend.setText(rs.getFloat("preco")+"");
                    pesquisaCliTud.labQtdd.setText(rs.getInt("qtdp")+"");
                    pesquisaCliTud.labVenci.setText(rs.getString("Vencimento"));

                    float compra = rs.getFloat("precoPcom") ,venda = rs.getFloat("preco");
                    pesquisaCliTud.labGanho.setText(venda - compra+"");
                    controle = (rs.getInt("fkcodigo"));
                }

                if(controle == 0){
                    retorno = new estoque();

                    retorno.setCodigo(rs.getInt("codigo"));
                    retorno.setNOMEP(rs.getString("NOMEP"));
                    retorno.setPreco(rs.getFloat("preco"));
                    retorno.setPrecoPcom(rs.getFloat("precoPcom"));
                    retorno.setQtdp(rs.getInt("qtdp"));
                    retorno.setFkcodigo(rs.getInt("fkcodigo"));

                }
            }
        }  
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar o estoque","ERRO,", JOptionPane.CLOSED_OPTION);
        }
        return retorno ;
    }

    
    public boolean AtualCat(Categoria cat){

        String sql = "UPDATE produto SET CATEGORIA=? WHERE ID =?";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {

            pst.setString(1, cat.getCategoria());
            pst.setInt(2, cat.getID());

            if(pst.executeUpdate()>0){

                return true ;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao atualizar produto","ERRO,", JOptionPane.CLOSED_OPTION);
        }
        return false ;
    }
    
    
    public boolean AtualEst(estoque est){

        String sqlEs = "UPDATE estoque SET `NOMEP` =?,`qtdp`=?,`preco`=?,`precoPcom`=?, fkcodigo = ?, Vencimento = ? WHERE codigo=?";
        PreparedStatement pstEs = Conexao.getPreparedStatement(sqlEs);

        try {
            pstEs.setString(1,est.getNOMEP());
            pstEs.setFloat(2,est.getQtdp());
            pstEs.setFloat(3,est.getPreco());
            pstEs.setFloat(4,est.getPrecoPcom());
            pstEs.setInt(5,est.getFkcodigo());
            pstEs.setString(6,est.getVencimento());
            pstEs.setInt(7,est.getCodigo());

            if(pstEs.executeUpdate()>0){
                return true ;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao atualizar produto","ERRO,", JOptionPane.CLOSED_OPTION);
        }
        return false ;
    }
    
    public Comprapeq PesquisaProdutC() { 
       
        CompraDao comDa = new CompraDao();
        Comprapeq comp = new Comprapeq();
        EstoqueDAO estD = new EstoqueDAO();
        
        try{

            this.comando = "SELECT* FROM estoque where NOMEP = '"+SofrendoNaCalculadChef.listNomesAnt.getModel().getElementAt(o)+"';";

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

                SofrendoNaCalculadChef.listNomesAnt.setSelectedIndex(o);
                SofrendoNaCalculadChef.listQtddP.setSelectedIndex(o);
                quantidade = Integer.parseInt(listQtddP.getSelectedValue());

                QuanP = QuanP - quantidade;

                if(QuanP>0){
                    EditProd(QuanP);
                }
                else{
                    // Preparar um sistema de erro caso não aja produto no estoque mas lembre-se que esse produto estara sendo vendido fisicamente
                    // talves fazer uma mensagem em uma nova janela pedindo para conferir a compra pois um produto esta contado errado
                    JOptionPane.showMessageDialog(null, "Não tem produto suficiente para fazer a compra","Acesso:", JOptionPane.ERROR_MESSAGE);
                }
            }  
        }
    
           
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar os dados do Produto","ERRO,", JOptionPane.CLOSED_OPTION);
        }
    return comp;
    }
    

    public boolean EditProd(int QuanP) { 
        
        try{

            this.comando = "UPDATE estoque SET qtdp=? WHERE codigo=?";

            PreparedStatement pstAlt = Conexao.getPreparedStatement(comando);

            pstAlt.setInt(1, QuanP);
            pstAlt.setInt(2, Fkestoque);

            System.out.print("\n quantidade de produtos: "+quantidade);
            System.out.print("\n quantidade de estoque sobrante: "+QuanP);
            System.out.print("\n Fkestoque: "+Fkestoque);

            //System.out.print("\n tudo: "+pstAlt.executeUpdate());


            if(pstAlt.executeUpdate()>0){
       
                System.out.print("\n\n alteração da quantidade do produto feita com sucessso \n");
                return true ;
            }

            else{
                // Preparar um sistema de erro caso não aja produto no estoque mas lembre-se que esse produto estara sendo vendido fisicamente
                // talves fazer uma mensagem em uma nova janela pedindo para conferir a compra pois um produto esta contado errado
                JOptionPane.showMessageDialog(null, "Não tem produto suficiente para fazer a compra","Acesso:", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar os dados do Produto","ERRO,", JOptionPane.CLOSED_OPTION);
        }
        return false;
    }
    

    public boolean DropEst(int est){

        String sql = "DELETE FROM `estoque` WHERE codigo = ?"; 
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        Boolean retorno = false;

        try {
            pst.setInt(1, est);
            while(pst.executeUpdate()>0 ){
                retorno = true ;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao excluir Cliente completo","ERRO,", JOptionPane.CLOSED_OPTION);
        }
        return retorno;
    }
    
    
    public List<Categoria> ListaCate(){
        
        List<Categoria>listaCate = new ArrayList <Categoria>();
        boolean retorno;
        String sql = " select CATEGORIA FROM categoria";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        
        try {
            ResultSet res = pst.executeQuery();

            while (res.next()){
                Categoria linha = new Categoria ();
                linha.setCategoria(res.getString("CATEGORIA"));
                listaCate.add(linha);
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar categoria","ERRO,", JOptionPane.CLOSED_OPTION);
        }
        return listaCate;
    }

    
    public int UltResistroCatego () {

        int valor = 0;
        String sql = "SELECT * FROM categoria";
        Categoria retorno = null;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try { 
            ResultSet res = pst.executeQuery();
            res.last();
            valor = Integer.parseInt(res.getString("ID"));
            valor++;
        } 
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar o ultimo Id da categoria","ERRO,", JOptionPane.CLOSED_OPTION);
        }
        return valor;
    }

    public boolean inserirCategoria(Categoria pro) {
        String sql = "INSERT INTO categoria (ID,CATEGORIA)VALUES(?,?);"; 
        boolean retorno = false; 
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        
        try {
            pst.setInt(1,pro.getID());
            pst.setString(2,pro.getCategoria());

            if(pst.executeUpdate()>0)
                retorno= true;
        }
        
        catch (SQLException e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
            retorno = false;
        }
        return retorno;
    }

}
