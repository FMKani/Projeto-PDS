package moneywise.visao;

import java.sql.Date;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import javax.swing.JOptionPane;
import moneywise.dao.UsuarioDao;
import moneywise.modelo.Usuario;

public class Cadastro extends javax.swing.JFrame {

    public Cadastro() {
        initComponents();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        grpSexo = new javax.swing.ButtonGroup();
        lblNome = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblConfSenha = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblNascimento = new javax.swing.JLabel();
        txtConfSenha = new javax.swing.JPasswordField();
        txtSenha = new javax.swing.JPasswordField();
        txtEmail = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        rbtnMasculino = new javax.swing.JRadioButton();
        rbtnFeminino = new javax.swing.JRadioButton();
        txtNascimento = new javax.swing.JFormattedTextField();
        btnCadastrar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        lblSenhaObrigatorio = new javax.swing.JLabel();
        lblEmailObrigatorio = new javax.swing.JLabel();
        lblNomeObrigatorio = new javax.swing.JLabel();
        lblConfSenhaObrigatorio = new javax.swing.JLabel();
        lblCampoObrigatorio = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MoneyWise");
        setLocationByPlatform(true);
        setResizable(false);

        lblNome.setText("Nome:");

        lblEmail.setText("E-mail:");

        lblSenha.setText("Senha:");

        lblConfSenha.setText("Confirmar Senha:");

        lblSexo.setText("Sexo:");

        lblNascimento.setText("Nascimento:");

        grpSexo.add(rbtnMasculino);
        rbtnMasculino.setText("Masculino");

        grpSexo.add(rbtnFeminino);
        rbtnFeminino.setText("Feminino");

        try {
            txtNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        lblSenhaObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        lblSenhaObrigatorio.setText("*");

        lblEmailObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        lblEmailObrigatorio.setText("*");

        lblNomeObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        lblNomeObrigatorio.setText("*");

        lblConfSenhaObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        lblConfSenhaObrigatorio.setText("*");

        lblCampoObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        lblCampoObrigatorio.setText("* Campo obrigatório.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSenha)
                    .addComponent(txtNome)
                    .addComponent(txtEmail)
                    .addComponent(txtConfSenha)
                    .addComponent(txtNascimento)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSenhaObrigatorio))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEmailObrigatorio))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNomeObrigatorio))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblConfSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblConfSenhaObrigatorio))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCampoObrigatorio))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtnMasculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnFeminino))
                            .addComponent(lblNascimento))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addComponent(btnCadastrar)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCadastrar, btnVoltar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(lblNomeObrigatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(lblEmailObrigatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(lblSenhaObrigatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfSenha)
                    .addComponent(lblConfSenhaObrigatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSexo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnMasculino)
                    .addComponent(rbtnFeminino))
                .addGap(18, 18, 18)
                .addComponent(lblNascimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCampoObrigatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnVoltar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        voltar();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        String nome = txtNome.getText();
        String email = txtEmail.getText();
        String senha = Arrays.toString(txtSenha.getPassword());
        String confSenha = Arrays.toString(txtConfSenha.getPassword());
        if (nome.length() == 0 || email.length() == 0 || senha.length() == 2 || confSenha.length() == 0) {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (nome.length() < 4) {
            JOptionPane.showMessageDialog(null, "Nome muito curto.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (nome.matches(".*\\d+.*")) {
            JOptionPane.showMessageDialog(null, "O nome não pode conter números.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (email.length() < 4) {
            JOptionPane.showMessageDialog(null, "Email muito curto.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!senha.equals(confSenha)) {
            JOptionPane.showMessageDialog(null, "As senhas não coincidem", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (senha.length() < 12) {
            JOptionPane.showMessageDialog(null, "Senha muito curta.", "Erro", JOptionPane.ERROR_MESSAGE);
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

        Usuario user = new Usuario(email, senha, nome, sexo, nascimento);
        try {
            UsuarioDao userDao = new UsuarioDao();

            if (userDao.buscar(user.getEmail()) != null) {
                JOptionPane.showMessageDialog(null, "E-mail ja cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (!userDao.salvar(user)) {
                JOptionPane.showMessageDialog(null, "Erro no cadastro.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cadastro concluido.", "Concluido", JOptionPane.INFORMATION_MESSAGE);
            }
            
            userDao.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexao com o banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        voltar();

    }//GEN-LAST:event_btnCadastrarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.ButtonGroup grpSexo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblCampoObrigatorio;
    private javax.swing.JLabel lblConfSenha;
    private javax.swing.JLabel lblConfSenhaObrigatorio;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailObrigatorio;
    private javax.swing.JLabel lblNascimento;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeObrigatorio;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSenhaObrigatorio;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JRadioButton rbtnFeminino;
    private javax.swing.JRadioButton rbtnMasculino;
    private javax.swing.JPasswordField txtConfSenha;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JFormattedTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables

    private void voltar() {
        Login login = new Login();
        login.setLocation(this.getX(), this.getY());
        this.dispose();
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
}
