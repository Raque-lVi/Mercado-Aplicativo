/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author User1
 */
public class datas {

    public datas(String dataC, int codigo, int dia, int mes, int ano,String hora) {
        this.dataC = dataC;
        this.codigo = codigo;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.hora = hora;
    }
    
    private String dataC;
    
    private int codigo;
    private int dia;
    private int mes;
    private int ano;
    private String hora;

    public datas() {
    }

    
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the dataC
     */
    public String getDataC() {
        return dataC;
    }

    /**
     * @param dataC the dataC to set
     */
    public void setDataC(String dataC) {
        this.dataC = dataC;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
}
