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
public class Comprapeq {
    private String codigo;
    private String fkpessoa;
    private String fkdatas;
    private int fkestoque;
    private int quantidade;
    private float ganho;
    private float precoP;
    private float precoComp;
    
    public Comprapeq() {
    }

    public Comprapeq(String codigo, String fkpessoa, String fkdatas, int fkestoque, int quantidade, float ganho, float precoP, float precoComp) {
        this.codigo = codigo;
        this.fkpessoa = fkpessoa;
        this.fkdatas = fkdatas;
        this.fkestoque = fkestoque;
        this.quantidade = quantidade;
        this.ganho = ganho;
        this.precoP = precoP;
        this.precoComp = precoComp;
       
    }
    
    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the fkpessoa
     */
    public String getFkpessoa() {
        return fkpessoa;
    }

    /**
     * @param fkpessoa the fkpessoa to set
     */
    public void setFkpessoa(String fkpessoa) {
        this.fkpessoa = fkpessoa;
    }

    /**
     * @return the fkdatas
     */
    public String getFkdatas() {
        return fkdatas;
    }

    /**
     * @param fkdatas the fkdatas to set
     */
    public void setFkdatas(String fkdatas) {
        this.fkdatas = fkdatas;
    }

    /**
     * @return the fkestoque
     */
    public int getFkestoque() {
        return fkestoque;
    }

    /**
     * @param fkestoque the fkestoque to set
     */
    public void setFkestoque(int fkestoque) {
        this.fkestoque = fkestoque;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the ganho
     */
    public float getGanho() {
        return ganho;
    }

    /**
     * @param ganho the ganho to set
     */
    public void setGanho(float ganho) {
        this.ganho = ganho;
    }

    /**
     * @return the precoP
     */
    public float getPrecoP() {
        return precoP;
    }

    /**
     * @param precoP the precoP to set
     */
    public void setPrecoP(float precoP) {
        this.precoP = precoP;
    }

    /**
     * @return the precoComp
     */
    public float getPrecoComp() {
        return precoComp;
    }

    /**
     * @param precoComp the precoComp to set
     */
    public void setPrecoComp(float precoComp) {
        this.precoComp = precoComp;
    }
    
    
}
