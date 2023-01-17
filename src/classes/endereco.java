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
public class endereco {
    
    private String codigo;//1
    private String ur;//2
    private String NumerResiden;//3
    private String cidade;//4
    private String endereco;//5
    private String bairro;//6
    private String cep;//7
    private String fkcpf;//8

    public endereco() {
    }

    public endereco(String codigo, String ur, String NumerResiden, String cidade, String endereco, String bairro, String cep, String fkcpf) {
        this.codigo = codigo;
        this.ur = ur;
        this.NumerResiden = NumerResiden;
        this.cidade = cidade;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.fkcpf = fkcpf;
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
     * @return the ur
     */
    public String getUr() {
        return ur;
    }

    /**
     * @param ur the ur to set
     */
    public void setUr(String ur) {
        this.ur = ur;
    }

    /**
     * @return the NumerResiden
     */
    public String getNumerResiden() {
        return NumerResiden;
    }

    /**
     * @param NumerResiden the NumerResiden to set
     */
    public void setNumerResiden(String NumerResiden) {
        this.NumerResiden = NumerResiden;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the fkcpf
     */
    public String getFkcpf() {
        return fkcpf;
    }

    /**
     * @param fkcpf the fkcpf to set
     */
    public void setFkcpf(String fkcpf) {
        this.fkcpf = fkcpf;
    }
    
    
    
    
}
