/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadas;

import Entrad.menuprincipal;
import TradutorDAO.AcessoDAO;
import TradutorDAO.PessoaDAO;
import TradutorDAO.funcionarioDAO;
import classes.Pessoa;
import classes.endereco;
import classes.funcionario;
import conexao.conexaoBanco;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author User1
 */
public class CadastroFuncionario extends javax.swing.JFrame {
    ArrayList<Pessoa> Pessoa = new ArrayList<>();//transformar a tabela pessoa em lista//
    ArrayList<funcionario>funcionario  = new ArrayList<>();//transformar a tabela funcionario (que é separada em dados) em lista//
    ArrayList<endereco> endereco = new ArrayList<>();//transformar a tabela endereco (que é separada em dados) em lista//

    /**
     * Creates new form Fonercedor
     */
    public CadastroFuncionario() {
        initComponents();
        endereco end = new endereco();
        
        PessoaDAO pdao = new PessoaDAO();
        
        end.setCodigo(pdao.UltResistroEndereco()+"");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        painelcadastro = new javax.swing.JPanel();
        labelcadastrocliente = new javax.swing.JLabel();
        labelnomeclient = new javax.swing.JLabel();
        lab = new javax.swing.JLabel();
        labelcpf = new javax.swing.JLabel();
        labeltelefone = new javax.swing.JLabel();
        labelcidade = new javax.swing.JLabel();
        labelUR = new javax.swing.JLabel();
        labelEndere = new javax.swing.JLabel();
        labelBairr = new javax.swing.JLabel();
        labelNumeResi = new javax.swing.JLabel();
        btsalvar = new javax.swing.JButton();
        txnome = new javax.swing.JTextField();
        txdatadn = new javax.swing.JTextField();
        txcpf = new javax.swing.JTextField();
        txtc = new javax.swing.JTextField();
        txur = new javax.swing.JTextField();
        txbairro = new javax.swing.JTextField();
        txcidade = new javax.swing.JTextField();
        txendereco = new javax.swing.JTextField();
        txnr = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txcep = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txsalario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txturno = new javax.swing.JTextField();
        txSenha = new javax.swing.JTextField();
        txLogin1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txMatricula = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        painelcadastro.setBackground(new java.awt.Color(255, 255, 204));
        painelcadastro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelcadastrocliente.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        labelcadastrocliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelcadastrocliente.setText("CADASTRO DE FUNCIONARIO");

        labelnomeclient.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelnomeclient.setText("NOME:");

        lab.setText("DATA DE NASCIMENTO:");

        labelcpf.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelcpf.setText("CPF/CNPJ:");

        labeltelefone.setText("TELEFONE CELULAR:");

        labelcidade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelcidade.setText("CIDADE:");

        labelUR.setText("UR:");

        labelEndere.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelEndere.setText("ENDEREÇO:");

        labelBairr.setText("BAIRRO:");

        labelNumeResi.setText("NUMERO RESIDENCIAL:");

        btsalvar.setBackground(new java.awt.Color(153, 0, 153));
        btsalvar.setText("SALVAR");
        btsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsalvarActionPerformed(evt);
            }
        });

        txnome.setBackground(new java.awt.Color(255, 153, 153));

        txdatadn.setBackground(new java.awt.Color(255, 153, 153));
        txdatadn.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                txdatadnCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        txcpf.setBackground(new java.awt.Color(255, 153, 153));

        txtc.setBackground(new java.awt.Color(255, 153, 153));

        txur.setBackground(new java.awt.Color(255, 153, 153));

        txbairro.setBackground(new java.awt.Color(255, 153, 153));

        txcidade.setBackground(new java.awt.Color(255, 153, 153));
        txcidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txcidadeActionPerformed(evt);
            }
        });

        txendereco.setBackground(new java.awt.Color(255, 153, 153));

        txnr.setBackground(new java.awt.Color(255, 153, 153));

        jLabel2.setText("CEP:");

        txcep.setBackground(new java.awt.Color(255, 153, 153));

        jLabel3.setText("salario:");

        txsalario.setBackground(new java.awt.Color(255, 153, 153));

        jLabel4.setText("Turno:");

        txturno.setBackground(new java.awt.Color(255, 153, 153));

        txSenha.setBackground(new java.awt.Color(255, 153, 153));

        txLogin1.setBackground(new java.awt.Color(255, 153, 153));

        jLabel5.setText("Login:");

        jLabel6.setText("Senha:");

        jLabel7.setText("Matricula:");

        txMatricula.setBackground(new java.awt.Color(255, 153, 153));

        javax.swing.GroupLayout painelcadastroLayout = new javax.swing.GroupLayout(painelcadastro);
        painelcadastro.setLayout(painelcadastroLayout);
        painelcadastroLayout.setHorizontalGroup(
            painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelcadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelcadastrocliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelcadastroLayout.createSequentialGroup()
                        .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(labelEndere, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lab, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelnomeclient, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelcpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelcidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelBairr)
                                    .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txendereco)
                            .addGroup(painelcadastroLayout.createSequentialGroup()
                                .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelcadastroLayout.createSequentialGroup()
                                        .addComponent(txcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelUR)
                                        .addGap(9, 9, 9)
                                        .addComponent(txur, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelNumeResi)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txnr, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txcidade, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txnome, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(painelcadastroLayout.createSequentialGroup()
                                        .addComponent(txdatadn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labeltelefone)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtc, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 64, Short.MAX_VALUE))
                            .addGroup(painelcadastroLayout.createSequentialGroup()
                                .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txsalario, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                    .addComponent(txcep, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txbairro, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txturno))
                                .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelcadastroLayout.createSequentialGroup()
                                        .addGap(118, 118, 118)
                                        .addComponent(btsalvar))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelcadastroLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(painelcadastroLayout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(painelcadastroLayout.createSequentialGroup()
                                                .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel6))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                                    .addComponent(txMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))))
                                        .addGap(40, 40, 40)))))))
                .addContainerGap())
        );
        painelcadastroLayout.setVerticalGroup(
            painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelcadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelcadastrocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelnomeclient)
                    .addComponent(txnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab)
                    .addComponent(txdatadn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labeltelefone)
                    .addComponent(txtc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelcpf)
                    .addComponent(txcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUR)
                    .addComponent(txur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNumeResi)
                    .addComponent(txnr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelcidade)
                    .addComponent(txcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEndere)
                    .addComponent(txendereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBairr)
                    .addComponent(txLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txcep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelcadastroLayout.createSequentialGroup()
                        .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(btsalvar)
                        .addGap(28, 28, 28))
                    .addGroup(painelcadastroLayout.createSequentialGroup()
                        .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txsalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txturno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(57, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(545, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(painelcadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addContainerGap(404, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(painelcadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txdatadnCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txdatadnCaretPositionChanged

        

    }//GEN-LAST:event_txdatadnCaretPositionChanged

    private void btsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsalvarActionPerformed
        
        Connection con = conexaoBanco.AbrirConexao();
        AcessoDAO ac = new AcessoDAO (con);
        Pessoa ps  = new Pessoa();
        funcionario fun  = new funcionario();
        endereco end = new endereco();
        funcionarioDAO fudao  = new funcionarioDAO();
        PessoaDAO psd = new PessoaDAO();

        ps.setCpf(txcpf.getText());//1
        ps.setDatanasc(txdatadn.getText());//2
        ps.setNome(txnome.getText());//3
        ps.setTelefone(txtc.getText());//4
        ps.setLogin(txLogin1.getText());//5
        ps.setSenha(txSenha.getText());//6

        end.setCodigo(psd.UltResistroEndereco()+"");//1
        end.setFkcpf(txcpf.getText());//2
        end.setCep(txcep.getText());//3
        end.setBairro(txbairro.getText());//4
        end.setEndereco(txendereco.getText());//5
        end.setCidade(txcidade.getText());//6
        end.setNumerResiden(txnr.getText());//7
        end.setUr(txur.getText());//8

        fun.setFkcpf(txcpf.getText());
        fun.setMatricula(txMatricula.getText());
        fun.setTurno(txturno.getText());
        fun.setSalario(Float.parseFloat(txsalario.getText()));

        funcionario.add(fun);//cria uma "lista" com todos os dados p.set{...}
        Pessoa.add(ps);
        endereco.add(end);

        psd.inserirPessoa(ps);
        fudao.inserirFuncionario(fun);
        psd.inserirEndereco(end);

        menuprincipal mp = new menuprincipal();
        mp.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btsalvarActionPerformed

    private void txcidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txcidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txcidadeActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btsalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lab;
    private javax.swing.JLabel labelBairr;
    private javax.swing.JLabel labelEndere;
    private javax.swing.JLabel labelNumeResi;
    private javax.swing.JLabel labelUR;
    private javax.swing.JLabel labelcadastrocliente;
    private javax.swing.JLabel labelcidade;
    private javax.swing.JLabel labelcpf;
    private javax.swing.JLabel labelnomeclient;
    private javax.swing.JLabel labeltelefone;
    private javax.swing.JPanel painelcadastro;
    private javax.swing.JTextField txLogin1;
    private javax.swing.JTextField txMatricula;
    private javax.swing.JTextField txSenha;
    private javax.swing.JTextField txbairro;
    private javax.swing.JTextField txcep;
    private javax.swing.JTextField txcidade;
    private javax.swing.JTextField txcpf;
    private javax.swing.JTextField txdatadn;
    private javax.swing.JTextField txendereco;
    private javax.swing.JTextField txnome;
    private javax.swing.JTextField txnr;
    private javax.swing.JTextField txsalario;
    private javax.swing.JTextField txtc;
    private javax.swing.JTextField txturno;
    private javax.swing.JTextField txur;
    // End of variables declaration//GEN-END:variables
}
