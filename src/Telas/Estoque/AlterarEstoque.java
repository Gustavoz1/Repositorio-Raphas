/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas.Estoque;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AlterarEstoque extends javax.swing.JFrame {

    /**
     * Creates new form AlterarEstoque
     */
    public AlterarEstoque() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jsConsulta = new javax.swing.JScrollPane();
        tbConsulta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCod_Prod = new javax.swing.JTextField();
        txtQtdProd = new javax.swing.JTextField();
        txtNomeProd = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        txtPrecoProd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        tbConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Quantidade", "Preço"
            }
        ));
        jsConsulta.setViewportView(tbConsulta);

        getContentPane().add(jsConsulta);
        jsConsulta.setBounds(20, 80, 600, 240);

        jLabel1.setText("Código:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 20, 50, 30);

        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 350, 50, 30);

        txtCod_Prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_ProdActionPerformed(evt);
            }
        });
        getContentPane().add(txtCod_Prod);
        txtCod_Prod.setBounds(80, 20, 80, 30);

        txtQtdProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdProdActionPerformed(evt);
            }
        });
        getContentPane().add(txtQtdProd);
        txtQtdProd.setBounds(300, 350, 130, 30);

        txtNomeProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeProdActionPerformed(evt);
            }
        });
        getContentPane().add(txtNomeProd);
        txtNomeProd.setBounds(80, 350, 130, 30);

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultar);
        btnConsultar.setBounds(510, 20, 90, 30);

        btnAlterar.setText("Alterar!");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(510, 350, 90, 30);

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletar);
        btnDeletar.setBounds(510, 390, 90, 30);
        getContentPane().add(txtPrecoProd);
        txtPrecoProd.setBounds(80, 400, 130, 30);

        jLabel3.setText("Preço:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 410, 80, 16);

        jLabel4.setText("Quantidade:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(230, 360, 150, 16);

        setSize(new java.awt.Dimension(717, 511));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtQtdProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdProdActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed

        Connection conexao;
        PreparedStatement st;
        ResultSet rs;
        //Conexão com o BD
        DefaultTableModel defTable;
        defTable = (DefaultTableModel) tbConsulta.getModel();
        defTable.setRowCount(0);
        if (txtCod_Prod.getText().isEmpty() == true) //txtNomeProd.setText("*");
        {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_raphas", "root", "admin123");
                st = conexao.prepareStatement("SELECT * FROM tb_estoque");
                //st.setString(1, txtCod_Prod.getText());
                rs = st.executeQuery();

                while (rs.next()) {

                    //for(int i = 1; i < 10; i++);{
                    Object[] dados = {rs.getString("id_prod"), rs.getString("nome_prod"),
                        rs.getString("qtd_prod"), rs.getString("preco_prod")};
                    defTable.addRow(dados);
                    //}

                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "id invalido");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Você não tem o driver na biblioteca " + ex);
                return;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Algum parâmetro do BD está incorreto " + ex);
                return;
            }
        }
        if (txtCod_Prod.getText().isEmpty() == false) {
            try {

                int codigo = Integer.parseInt(txtCod_Prod.getText());

                if (codigo < 1) {
                    JOptionPane.showMessageDialog(null, "Código Invalido");
                    return;
                } else {
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Campo código invalido");
                return;
            }
    }//GEN-LAST:event_btnConsultarActionPerformed
    }
    private void txtCod_ProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_ProdActionPerformed

        try {

            DefaultTableModel defTable;
            Connection conexao;
            PreparedStatement st;
            ResultSet rs;
            //Conexão com o BD

            defTable = (DefaultTableModel) tbConsulta.getModel();
            defTable.setRowCount(0);

            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_raphas", "root", "admin123");
            //Busca o item na tabela do BD
            st = conexao.prepareStatement("SELECT * FROM tb_estoque WHERE id_prod = ?;");
            st.setString(1, txtCod_Prod.getText());
            rs = st.executeQuery();

            while (rs.next()) {

                //for(int i = 1; i < 10; i++);{
                Object[] dados = {rs.getString("id_prod"), rs.getString("nome_prod"),
                    rs.getString("qtd_prod"), rs.getString("preco_prod")};
                defTable.addRow(dados);
                //}
 
                txtNomeProd.setText(rs.getString("nome_prod"));
                txtPrecoProd.setText(rs.getString("preco_prod"));
                txtQtdProd.setText(rs.getString("qtd_prod"));
                txtCod_Prod.requestFocus();

            }
        
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "id invalido");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Você não tem o driver na biblioteca " + ex);
            return;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algum parâmetro do BD está incorreto " + ex);
            return;
        }
    }//GEN-LAST:event_txtCod_ProdActionPerformed
    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed

        int resposta = JOptionPane.showConfirmDialog(null, "Realmente deseja Exlcuir esse campo?");
        if (resposta == JOptionPane.YES_OPTION) {
            try {
                Connection conexao;
                PreparedStatement st;
                ResultSet rs;
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_raphas", "root", "admin123");
                st = conexao.prepareStatement("DELETE FROM tb_estoque WHERE id_prod = ?");
                st.setString(1, txtCod_Prod.getText());
                //rs = st.executeUpdate();
                int res = st.executeUpdate();
                if (res == 1)// res == 1
                {
                    JOptionPane.showMessageDialog(null, "Produto excluído com sucesso");
                    txtCod_Prod.setText("");
                    txtNomeProd.setText("");
                    txtPrecoProd.setText("");
                    txtQtdProd.setText("");
                    txtCod_Prod.requestFocus();

                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível excluir o produtos com este código");
                }
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Você não tem o driver na biblioteca " + ex.getMessage());

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Algum Parâmetro do BD está incorreto " + ex.getMessage());
            }
        }
        if (resposta == JOptionPane.NO_OPTION) {
            return;
        }

    }//GEN-LAST:event_btnDeletarActionPerformed

    private void txtNomeProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeProdActionPerformed
    }//GEN-LAST:event_txtNomeProdActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            Connection conexao;
            PreparedStatement st;
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_raphas", "root", "admin123");
            st = conexao.prepareStatement("UPDATE tb_estoque SET nome_prod = ?, preco_prod  = ?,  qtd_prod= ? WHERE id_prod = ?");
            st.setString(1, txtNomeProd.getText());
            st.setDouble(2, Double.parseDouble(txtPrecoProd.getText()));
            st.setString(3, txtQtdProd.getText());
            st.setString(4, txtCod_Prod.getText());
            st.executeUpdate(); //Executa o comando SQL UPDATE

            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso");

            txtNomeProd.setText("");
            txtPrecoProd.setText("");
            txtQtdProd.setText("");
            txtCod_Prod.setText("");
            txtCod_Prod.requestFocus();

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Você não tem o driver na biblioteca " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algum parâmetro do BD está incorreto" + ex.getMessage());
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlterarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jsConsulta;
    private javax.swing.JTable tbConsulta;
    private javax.swing.JTextField txtCod_Prod;
    private javax.swing.JTextField txtNomeProd;
    private javax.swing.JTextField txtPrecoProd;
    private javax.swing.JTextField txtQtdProd;
    // End of variables declaration//GEN-END:variables
}
