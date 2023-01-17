

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author EEQS Lab02
 */
public class Pessoa {
    private String cpf;
    private String nome;
    private String Datanasc;
    private String Login;
    private String Senha;
    private String telefone;
    private int CPFFalce;
    
    
    public Pessoa() {
    }

    public Pessoa(String cpf, String nome, String Datanasc, String Login, String Senha, String telefone,  int CPFFalce) {
        this.cpf = cpf;
        this.nome = nome;
        this.Datanasc = Datanasc;
        this.Login = Login;
        this.Senha = Senha;
        this.telefone = telefone;
       this.CPFFalce = CPFFalce;
    }
    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the Datanasc
     */
    public String getDatanasc() {
        return Datanasc;
    }

    /**
     * @param Datanasc the Datanasc to set
     */
    public void setDatanasc(String Datanasc) {
        this.Datanasc = Datanasc;
    }

    /**
     * @return the Login
     */
    public String getLogin() {
        return Login;
    }

    /**
     * @param Login the Login to set
     */
    public void setLogin(String Login) {
        this.Login = Login;
    }

    /**
     * @return the Senha
     */
    public String getSenha() {
        return Senha;
    }

    /**
     * @param Senha the Senha to set
     */
    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the CPFFalce
     */
    public int getCPFFalce() {
        return CPFFalce;
    }

    /**
     * @param CPFFalce the CPFFalce to set
     */
    public void setCPFFalce(int CPFFalce) {
        this.CPFFalce = CPFFalce;
    }

    

    
}
