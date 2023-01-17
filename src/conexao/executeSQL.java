/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;

/**
 *
 * @author  Vivian Raquel Batista Dantas de casa, cama.
 */
public class executeSQL {
     private Connection con;
     
     
    public executeSQL() {
    }

    public executeSQL(Connection con) {
        this.con = con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }
}