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
public class funcionario {
    
    private String fkcpf;
    private String matricula;
    private String turno;
    private float salario;

    public funcionario(String fkcpf, String matricula, String turno, float salario) {
        this.fkcpf = fkcpf;
        this.matricula = matricula;
        this.turno = turno;
        this.salario = salario;
    }

    public funcionario() {
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
     * @return the turno
     */
    public String getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }

    /**
     * @return the salario
     */
    public float getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    
}
