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
public class cliente {

    public cliente() {
    }

    public cliente( String fkcpf, String matricula, float credito) {

        this.fkcpf = fkcpf;
        this.matricula = matricula;
        this.credito = credito;
    }
    

    private String fkcpf;
    private String matricula;
    private float credito;

    /**
     * @return the compra
     */

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

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the credito
     */
    public float getCredito() {
        return credito;
    }

    /**
     * @param credito the credito to set
     */
    public void setCredito(float credito) {
        this.credito = credito;
    }
    
    
    
}
