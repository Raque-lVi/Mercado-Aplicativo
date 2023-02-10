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
public class Categoria {

private int ID; 
private String categoria;        
    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }
    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }
    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }
    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public Categoria(int ID, String categoria) {
        this.ID = ID;
        this.categoria = categoria;
    }
    public Categoria() {
    }
}
