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
public class estoque {
    private String NOMEP;
    private int codigo;
    private int qtdp; //qtdp = quantidade de produtos
    private float precoPcom; // precoPcom = preço de compra; preco= preço de venda
    private float preco;
    private int fkcodigo;
    private float ganho;
    private String Vencimento;

    public estoque() {
    }
    public estoque(String NOMEP, int codigo, int qtdp, float precoPcom, float preco, int fkcodigo, float ganho, String Vencimento) {
        this.NOMEP = NOMEP;
        this.codigo = codigo;
        this.qtdp = qtdp;
        this.precoPcom = precoPcom;
        this.preco = preco;
        this.fkcodigo = fkcodigo;
        this.ganho = ganho;
        this.Vencimento = Vencimento;
    }
    
    public String getVencimento() {
        return Vencimento;
    }

    public void setVencimento(String Vencimento) {
        this.Vencimento = Vencimento;
    }
    

    /**
     * @return the NOMEP
     */
    public String getNOMEP() {
        return NOMEP;
    }

    /**
     * @param NOMEP the NOMEP to set
     */
    public void setNOMEP(String NOMEP) {
        this.NOMEP = NOMEP;
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
     * @return the qtdp
     */
    public int getQtdp() {
        return qtdp;
    }

    /**
     * @param qtdp the qtdp to set
     */
    public void setQtdp(int qtdp) {
        this.qtdp = qtdp;
    }

    /**
     * @return the precoPcom
     */
    public float getPrecoPcom() {
        return precoPcom;
    }

    /**
     * @param precoPcom the precoPcom to set
     */
    public void setPrecoPcom(float precoPcom) {
        this.precoPcom = precoPcom;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * @return the fkcodigo
     */
    public int getFkcodigo() {
        return fkcodigo;
    }

    /**
     * @param fkcodigo the fkcodigo to set
     */
    public void setFkcodigo(int fkcodigo) {
        this.fkcodigo = fkcodigo;
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
}
