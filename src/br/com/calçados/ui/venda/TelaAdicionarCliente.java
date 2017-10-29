package br.com.calçados.ui.venda;

import br.com.calçados.ui.clientes.*;
import br.com.calçados.cliente.Cliente;
import br.com.calçados.exception.ClienteException;
import br.com.calçados.service.ServicoCliente;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaAdicionarCliente extends javax.swing.JDialog {

    String ultimaPesquisa = null;
    Cliente cliente = null;
    

    public TelaAdicionarCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tabelaCliente.getColumnModel().getColumn(0).setMinWidth(0);
        tabelaCliente.getColumnModel().getColumn(0).setMaxWidth(0);
        tabelaCliente.getColumnModel().getColumn(0).setWidth(0);
        setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoPesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        cancelar = new javax.swing.JButton();
        botaoAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Clientes");

        jLabel1.setText("Pesquisar: ");

        campoPesquisa.setText("Digite o CPF do cliente");
        campoPesquisa.setToolTipText("");
        campoPesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPesquisaFocusGained(evt);
            }
        });
        campoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPesquisaActionPerformed(evt);
            }
        });

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Sobrenome", "CPF", "Telefone", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Short.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaCliente);

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPesquisa))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(campoPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(botaoAdicionar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    public Cliente getCliente(){
        setVisible(true);
        return cliente;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    private void campoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPesquisaActionPerformed
        ultimaPesquisa = campoPesquisa.getText();
        boolean result = false;
        try {
            result = refreshList();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Falha ao exibir lista",
                    "Erro ao abrir detalhe", JOptionPane.ERROR_MESSAGE);
        }
        if (!result) {
            JOptionPane.showMessageDialog(rootPane, "A pesquisa não retornou resultados ",
                    "Sem resultados", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_campoPesquisaActionPerformed

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        try {

            final int row = tabelaCliente.getSelectedRow();

            if (row >= 0) {

                int id = (int) tabelaCliente.getValueAt(row, 0);

                Cliente cliente = ServicoCliente.obterCliente(id);

                setCliente(cliente);
                
                setVisible(false);
                dispose();
            }
        } catch (Exception e) {
            
            e.printStackTrace();

            JOptionPane.showMessageDialog(rootPane, "Não é possível "
                    + "exibir os detalhes deste cliente.",
                    "Erro ao abrir detalhe", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void campoPesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoPesquisaFocusGained
        campoPesquisa.setText("");
    }//GEN-LAST:event_campoPesquisaFocusGained

    public boolean refreshList() throws ClienteException, Exception {
        List<Cliente> resultado = ServicoCliente.procurarCliente(ultimaPesquisa);
        DefaultTableModel model = (DefaultTableModel) tabelaCliente.getModel();
        model.setRowCount(0);
        if (resultado == null || resultado.size() <= 0) {
            return false;
        }
        for (int i = 0; i < resultado.size(); i++) {
            Cliente cliente = resultado.get(i);
            if (cliente != null) {
                Object[] row = new Object[6];
                row[0] = cliente.getID();
                row[1] = cliente.getNome();
                row[2] = cliente.getSobrenome();
                row[3] = cliente.getCPF();
                if (cliente.getTelefone() != 0) {
                    row[4] = cliente.getTelefone();
                }
                row[5] = cliente.getEmail();
                model.addRow(row);
            }
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JTextField campoPesquisa;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaCliente;
    // End of variables declaration//GEN-END:variables

    private void openFrameInCenter(TelaEditarCliente jif) {
        Dimension desktopSize = this.getParent().getSize();
        Dimension jInternalFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jif.setLocation(width, height);
        jif.setVisible(true);
    }
}
