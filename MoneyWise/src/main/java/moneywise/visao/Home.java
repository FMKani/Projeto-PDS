package moneywise.visao;

import javax.swing.JOptionPane;
import moneywise.modelo.Usuario;

public class Home extends javax.swing.JFrame {
    
    Usuario usuario;
    
    public Home(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGerenciarPerfil = new javax.swing.JButton();
        btnCadastrarMovimentacao = new javax.swing.JButton();
        btnGerenciarFinancas = new javax.swing.JButton();
        lblNomeUser = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MoneyWise - Home");

        btnGerenciarPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon3.png"))); // NOI18N
        btnGerenciarPerfil.setText("<html><center>Gerenciar<br/>Perfil</center></html>");
        btnGerenciarPerfil.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGerenciarPerfil.setIconTextGap(2);
        btnGerenciarPerfil.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGerenciarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarPerfilActionPerformed(evt);
            }
        });

        btnCadastrarMovimentacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon1.png"))); // NOI18N
        btnCadastrarMovimentacao.setText("<html><center>Cadastrar<br/>Movimentação</center></html>");
        btnCadastrarMovimentacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadastrarMovimentacao.setIconTextGap(2);
        btnCadastrarMovimentacao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnGerenciarFinancas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon2.png"))); // NOI18N
        btnGerenciarFinancas.setText("<html><center>Gerenciar<br/>Finanças</center></html>");
        btnGerenciarFinancas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGerenciarFinancas.setIconTextGap(2);
        btnGerenciarFinancas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblNomeUser.setText(usuario.getNome());

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCadastrarMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGerenciarFinancas, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGerenciarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNomeUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(lblNomeUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGerenciarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGerenciarFinancas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrarMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(210, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        
        int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", 
                         "Aviso.", JOptionPane.YES_NO_OPTION);
        
        if(dialogResult == JOptionPane.YES_OPTION){
            Login login = new Login();
            login.setLocation(this.getX(), this.getY());
            this.dispose();
        }
        
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnGerenciarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciarPerfilActionPerformed
        GerenciarPerfil gerenciarPerfil = new GerenciarPerfil(usuario);
        gerenciarPerfil.setLocation(this.getX(), this.getY());
        this.dispose();
    }//GEN-LAST:event_btnGerenciarPerfilActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarMovimentacao;
    private javax.swing.JButton btnGerenciarFinancas;
    private javax.swing.JButton btnGerenciarPerfil;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel lblNomeUser;
    // End of variables declaration//GEN-END:variables
}
