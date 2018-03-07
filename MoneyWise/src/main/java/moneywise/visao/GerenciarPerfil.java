package moneywise.visao;

import moneywise.modelo.Usuario;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import moneywise.dao.UsuarioDao;

public class GerenciarPerfil extends javax.swing.JFrame {

    Usuario usuario;

    public GerenciarPerfil(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpSexo = new javax.swing.ButtonGroup();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        lblEmailUser = new javax.swing.JLabel();
        rbtnMasculino = new javax.swing.JRadioButton();
        rbtnFeminino = new javax.swing.JRadioButton();
        lblNascimento = new javax.swing.JLabel();
        txtNascimento = new javax.swing.JFormattedTextField();
        lblEmail = new javax.swing.JLabel();
        lblSalvar = new javax.swing.JButton();
        lblCancelar = new javax.swing.JButton();
        lblAtualizarDados = new javax.swing.JLabel();
        lblAlterarSenha = new javax.swing.JLabel();
        txtNovaSenha = new javax.swing.JPasswordField();
        lblNovaSenha = new javax.swing.JLabel();
        lblConfNovaSenha = new javax.swing.JLabel();
        txtConfNovaSenha = new javax.swing.JPasswordField();
        lblSenhaAntiga = new javax.swing.JLabel();
        txtConfSenhaAntiga = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        btnAlterarSenha = new javax.swing.JButton();
        btnExcluirConta = new javax.swing.JButton();
        lblExcluirConta = new javax.swing.JLabel();
        lblSenhaExcluir = new javax.swing.JLabel();
        txtSenhaExcluir = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MoneyWise - Gerenciar Perfil");

        lblNome.setText("Nome:");

        txtNome.setText(usuario.getNome());

        lblSexo.setText("Sexo:");

        lblEmailUser.setText(usuario.getEmail());

        grpSexo.add(rbtnMasculino);
        rbtnMasculino.setSelected(usuario.getSexo().equals("M")
        );
        rbtnMasculino.setText("Masculino");

        grpSexo.add(rbtnFeminino);
        rbtnFeminino.setSelected(usuario.getSexo().equals("F")
        );
        rbtnFeminino.setText("Feminino");

        lblNascimento.setText("Nascimento:");

        try {
            txtNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNascimento.setText(getNascimentoString());

        lblEmail.setText("Email:");

        lblSalvar.setText("Salvar Alterações");
        lblSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblSalvarActionPerformed(evt);
            }
        });

        lblCancelar.setText("Cancelar e Voltar");
        lblCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblCancelarActionPerformed(evt);
            }
        });

        lblAtualizarDados.setForeground(new java.awt.Color(255, 0, 0));
        lblAtualizarDados.setText("Atualizar Dados");

        lblAlterarSenha.setForeground(new java.awt.Color(255, 0, 0));
        lblAlterarSenha.setText("Alterar Senha");

        lblNovaSenha.setText("Nova senha:");

        lblConfNovaSenha.setText("Confirmar nova senha:");

        lblSenhaAntiga.setText("Confirmar senha antiga:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnAlterarSenha.setText("Alterar Senha");
        btnAlterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarSenhaActionPerformed(evt);
            }
        });

        btnExcluirConta.setText("Excluir Conta");

        lblExcluirConta.setForeground(new java.awt.Color(255, 0, 0));
        lblExcluirConta.setText("Excluir Conta");

        lblSenhaExcluir.setText("Confirmar senha:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(lblSalvar))
                    .addComponent(lblSexo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtnMasculino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnFeminino))
                    .addComponent(lblNascimento)
                    .addComponent(lblEmailUser)
                    .addComponent(lblEmail)
                    .addComponent(lblNome)
                    .addComponent(lblAtualizarDados)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNascimento, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSenhaExcluir)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSenhaAntiga)
                            .addComponent(lblAlterarSenha)
                            .addComponent(lblNovaSenha)
                            .addComponent(txtNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblConfNovaSenha)
                            .addComponent(txtConfNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConfSenhaAntiga, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblExcluirConta)
                            .addComponent(lblSenhaExcluir))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAlterarSenha, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnExcluirConta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAtualizarDados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEmailUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnMasculino)
                            .addComponent(rbtnFeminino))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNascimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCancelar)
                            .addComponent(lblSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAlterarSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNovaSenha)
                        .addGap(4, 4, 4)
                        .addComponent(txtNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblConfNovaSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtConfNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSenhaAntiga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtConfSenhaAntiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterarSenha)
                        .addGap(18, 18, 18)
                        .addComponent(lblExcluirConta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSenhaExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSenhaExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirConta)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jSeparator1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblCancelarActionPerformed
        voltar();
    }//GEN-LAST:event_lblCancelarActionPerformed

    private void lblSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblSalvarActionPerformed
        String nome = txtNome.getText();
        if (nome.length() == 0) {
            JOptionPane.showMessageDialog(null, "Campo nome vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (nome.length() < 4) {
            JOptionPane.showMessageDialog(null, "Nome muito curto.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (nome.matches(".*\\d+.*")) {
            JOptionPane.showMessageDialog(null, "O nome não pode conter números.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sexo = getSexo();

        Date nascimento;
        try {
            nascimento = getNascimento();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            UsuarioDao userDao = new UsuarioDao();

            usuario.setNome(nome);
            usuario.setSexo(sexo);
            usuario.setNascimento(nascimento);

            userDao.atualizar(usuario);
            userDao.close();

            JOptionPane.showMessageDialog(null, "Atualização concluida.", "Concluido", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexao com o banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_lblSalvarActionPerformed

    private void btnAlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarSenhaActionPerformed
        String novaSenha = Arrays.toString(txtNovaSenha.getPassword());
        String confNovaSenha = Arrays.toString(txtConfNovaSenha.getPassword());
        String confSenhaAntiga = Arrays.toString(txtConfSenhaAntiga.getPassword());

        if (novaSenha.length() == 0 || confNovaSenha.length() == 0 || confSenhaAntiga.length() == 0) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!novaSenha.equals(confNovaSenha)) {
            JOptionPane.showMessageDialog(null, "As senhas não coincidem", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (novaSenha.length() < 12) {
            JOptionPane.showMessageDialog(null, "Senha muito curta.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!usuario.getSenha().equals(confSenhaAntiga)) {
            JOptionPane.showMessageDialog(null, "Senha antiga errada.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            UsuarioDao userDao = new UsuarioDao();

            usuario.setSenha(novaSenha);

            userDao.atualizar(usuario);
            userDao.close();

            JOptionPane.showMessageDialog(null, "Atualização concluida.", "Concluido", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexao com o banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnAlterarSenhaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarSenha;
    private javax.swing.JButton btnExcluirConta;
    private javax.swing.ButtonGroup grpSexo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAlterarSenha;
    private javax.swing.JLabel lblAtualizarDados;
    private javax.swing.JButton lblCancelar;
    private javax.swing.JLabel lblConfNovaSenha;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailUser;
    private javax.swing.JLabel lblExcluirConta;
    private javax.swing.JLabel lblNascimento;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNovaSenha;
    private javax.swing.JButton lblSalvar;
    private javax.swing.JLabel lblSenhaAntiga;
    private javax.swing.JLabel lblSenhaExcluir;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JRadioButton rbtnFeminino;
    private javax.swing.JRadioButton rbtnMasculino;
    private javax.swing.JPasswordField txtConfNovaSenha;
    private javax.swing.JPasswordField txtConfSenhaAntiga;
    private javax.swing.JFormattedTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtNovaSenha;
    private javax.swing.JPasswordField txtSenhaExcluir;
    // End of variables declaration//GEN-END:variables

    private String getNascimentoString() {
        LocalDate nascimento = usuario.getNascimento().toLocalDate();

        int dia = nascimento.getDayOfMonth();
        String diaS = "";
        if (dia < 10) {
            diaS += "0";
        }
        diaS += dia;

        int mes = nascimento.getMonthValue();
        String mesS = "";
        if (mes < 10) {
            mesS += "0";
        }
        mesS += mes;

        int ano = nascimento.getYear();

        String result = diaS + "" + mesS + "" + ano;
        return result;
    }

    private Date getNascimento() throws Exception {
        String dataOriginal = txtNascimento.getText();
        String campoVazio = "  /  /    ";
        Date dataLimite = Date.valueOf("1900-01-01");

        if (dataOriginal.equals(campoVazio)) {
            return null;
        }

        DateTimeFormatter formatoOriginal = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoNovo = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dataFormatada = formatoNovo.format(formatoOriginal.parse(dataOriginal));
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Date data = Date.valueOf(dataFormatada);

        if (data.before(dataLimite)) {
            throw new Exception();
        }

        return data;
    }

    private String getSexo() {
        if (rbtnMasculino.isSelected()) {
            return "M";
        }
        if (rbtnFeminino.isSelected()) {
            return "F";
        }
        return null;
    }

    private void voltar() {
        Home home = new Home(usuario);
        home.setLocation(this.getX(), this.getY());
        this.dispose();
    }

}
