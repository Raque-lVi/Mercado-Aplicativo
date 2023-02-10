/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TradutorDAO;

import classes.datas;
import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User1
 */
public class DataDao {
    
    String dia, mes,ano,hora;
            
    public void data(){
        
        datas dts = new datas();
        Date datas = new Date();

        SimpleDateFormat formato = new SimpleDateFormat ("dd");
        dia = formato.format(datas);
        dts.setDia(Integer.parseInt(dia));
        /* se colocar 1 "y" vai apareser apenas um numero do ano, agora se botar 4"yyyy" vai apareser os 4 numeros do ano
        y   = Ano
        M   = Mes do ano
        D   = Dia do ano (190 dia por Exemplo)
        d   = Dia do mes
        H   = Hora do dia
        h   = Hora em am/pm
        m   = Minuto da hora
        s   = Segundo do minuto
        S   = Número de milissegundos
        */
        SimpleDateFormat format = new SimpleDateFormat ("MM");
        mes = format.format(datas);
        dts.setMes(Integer.parseInt(mes));
        SimpleDateFormat form = new SimpleDateFormat ("yyyy");
        ano = form.format(datas);
        dts.setAno(Integer.parseInt(ano));

        SimpleDateFormat formH = new SimpleDateFormat ("hh:mm");//PUCHA A HORA POREM NÃO A USA PARA NADA
        hora = formH.format(datas);
        dts.setHora(hora);

        String pa = (ano+"/"+mes+"/"+dia);
        dts.setDataC(pa);

        this.buscarData(dts);
    }

    public boolean inserirData (datas dts) {

        String sql = "INSERT INTO datas (`dia`,`mes`,`ano`,`dataC`) VALUES (?,?,?,?);"; //o proprio app estara inserindo dados na tabela pessoa do xamp
        boolean retorno = false; //variavel do tipo verdadeiro ou falso chamada "retorno" esta sendo criada e ela recebe o valor: falso

        PreparedStatement pst = Conexao.getPreparedStatement(sql);//preparar o xamp para receber informação//


        try {

            pst.setInt(1,dts.getDia());
            pst.setInt(2,dts.getMes());
            pst.setInt(3,dts.getAno());
            pst.setString(4,dts.getDataC());

            if(pst.executeUpdate()>0){
                retorno= true;
            }
        } 
        catch (SQLException e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null,"ERRO AO INSERIR data","ERRO NA CONEXAO", JOptionPane.ERROR_MESSAGE);

            retorno = false;
        }
        return retorno;
    }
    

    public boolean buscarData (datas dts){  
        String sql = "SELECT * FROM datas where dataC = ?;";
        boolean retorno = false;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1,dts.getDataC());
            ResultSet res = pst.executeQuery();

            if(res.next()){
                retorno = true; 
            } 
            else {
                this.inserirData(dts);
            }
        }  
        catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar o data","ERRO,", JOptionPane.CLOSED_OPTION);

            retorno = false; 
        }

        return retorno ;
    }
}
