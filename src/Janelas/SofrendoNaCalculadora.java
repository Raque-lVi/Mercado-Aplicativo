

package Janelas;

import static Janelas.SofrendoNaCalculadora.listNomesAnt;
import TradutorDAO.CauculadoraDAO;
import TradutorDAO.DataDao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;






/**
 *
 * @author Vivian Raquel
 */
public class SofrendoNaCalculadora extends javax.swing.JFrame {

    private CauculadoraDAO cal;
    int enter = 0;

    
    /**
     * Creates new form SofrendoNaCalculadora
     */
    public SofrendoNaCalculadora() {
        initComponents();
        DataDao ddao = new DataDao();
        ddao.data();
        setLocationRelativeTo(null);
        ListaNomes.setVisible(false);
        this.cal = new CauculadoraDAO();
        float i = 0;
        txCalculo.setText(i+"");
                }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txNomep = new javax.swing.JTextField();
        txCalculo = new javax.swing.JTextField();
        ListaNomes = new javax.swing.JList<>();
        txQtddP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txpreco1 = new javax.swing.JTextField();
        listNomesAnt = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Calcular");
        setBackground(new java.awt.Color(255, 102, 102));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 2000, 2000));
        setMinimumSize(new java.awt.Dimension(2000, 2000));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(null);

        txNomep.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txNomep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txNomep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txNomepMouseClicked(evt);
            }
        });
        txNomep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNomepActionPerformed(evt);
            }
        });
        txNomep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txNomepKeyReleased(evt);
            }
        });
        getContentPane().add(txNomep);
        txNomep.setBounds(40, 20, 860, 60);

        txCalculo.setEditable(false);
        txCalculo.setBackground(new java.awt.Color(255, 255, 255));
        txCalculo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txCalculo);
        txCalculo.setBounds(840, 560, 450, 60);

        ListaNomes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ListaNomes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ListaNomes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaNomesMouseClicked(evt);
            }
        });
        getContentPane().add(ListaNomes);
        ListaNomes.setBounds(40, 80, 860, 220);

        txQtddP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txQtddP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txQtddPActionPerformed(evt);
            }
        });
        getContentPane().add(txQtddP);
        txQtddP.setBounds(80, 100, 60, 40);

        jLabel1.setText("+ Quantos?");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 110, 60, 14);

        txpreco1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txpreco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txpreco1ActionPerformed(evt);
            }
        });
        getContentPane().add(txpreco1);
        txpreco1.setBounds(1070, 630, 220, 40);

        listNomesAnt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listNomesAnt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listNomesAnt.setAutoscrolls(false);
        getContentPane().add(listNomesAnt);
        listNomesAnt.setBounds(840, 330, 450, 230);

        jPanel1.setLayout(null);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1300, 690);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    

    private void txNomepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNomepActionPerformed
        ListaNomes.setVisible(false);
        enter=1;
        
        if(txNomep.isEditable()){
        this.cal.Pesquisa();
       // this.cal.calcularTodo();
            
        }else {
       enter = 0;
       ListaNomes.setVisible(false);
       }
    }//GEN-LAST:event_txNomepActionPerformed

    private void txNomepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNomepKeyReleased
       if(enter==0){
       this.cal.Pesquisa();
       }else {
       enter = 0;
       ListaNomes.setVisible(false);
       }   
    }//GEN-LAST:event_txNomepKeyReleased

    private void ListaNomesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaNomesMouseClicked
        this.cal.LinhaClicada();
        this.cal.calcularTodo();
        ListaNomes.setVisible(false);

    }//GEN-LAST:event_ListaNomesMouseClicked

    private void txQtddPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txQtddPActionPerformed
        this.cal.calcularQProd();
    }//GEN-LAST:event_txQtddPActionPerformed

    private void txNomepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txNomepMouseClicked

    }//GEN-LAST:event_txNomepMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
       ListaNomes.setVisible(false);
    }//GEN-LAST:event_formMouseClicked

    private void txpreco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txpreco1ActionPerformed

    }//GEN-LAST:event_txpreco1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SofrendoNaCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SofrendoNaCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SofrendoNaCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SofrendoNaCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SofrendoNaCalculadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JList<String> ListaNomes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JList<String> listNomesAnt;
    public static javax.swing.JTextField txCalculo;
    public static javax.swing.JTextField txNomep;
    public static javax.swing.JTextField txQtddP;
    public static javax.swing.JTextField txpreco1;
    // End of variables declaration//GEN-END:variables
}
