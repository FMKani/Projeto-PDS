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
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        lblConfSenha = new javax.swing.JLabel();
        txtConfSenha = new javax.swing.JPasswordField();
        lblSexo = new javax.swing.JLabel();
        rbtnFeminino = new javax.swing.JRadioButton();
        rbtnMasculino = new javax.swing.JRadioButton();
        lblNascimento = new javax.swing.JLabel();
        txtNascimento = new javax.swing.JFormattedTextField();
        btnVoltar = new javax.swing.JButton();
        lblCampoObrigatorio = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        lblSenhaObrigatorio = new javax.swing.JLabel();
        lblConfSenhaObrigatorio = new javax.swing.JLabel();
        lblEmailObrigatorio = new javax.swing.JLabel();
        lblNomeObrigatorio = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblConfSenhaObrigatorio1 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MoneyWise");
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblNome.setText("Nome:");

        lblEmail.setText("E-mail:");

        lblSenha.setText("Senha:");

        lblConfSenha.setText("Confirmar Senha:");

        lblSexo.setText("Sexo:");

        rbtnFeminino.setBackground(new java.awt.Color(255, 255, 255));
        grpSexo.add(rbtnFeminino);
        rbtnFeminino.setText("Feminino");

        rbtnMasculino.setBackground(new java.awt.Color(255, 255, 255));
        grpSexo.add(rbtnMasculino);
        rbtnMasculino.setText("Masculino");

        lblNascimento.setText("Nascimento:");

        try {
            txtNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnVoltar.setBackground(new java.awt.Color(41, 168, 73));
        btnVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        lblCampoObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        lblCampoObrigatorio.setText("* Campo obrigatório.");

        btnCadastrar.setBackground(new java.awt.Color(41, 168, 73));
        btnCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        lblSenhaObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        lblSenhaObrigatorio.setText("*");

        lblConfSenhaObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        lblConfSenhaObrigatorio.setText("*");

        lblEmailObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        lblEmailObrigatorio.setText("*");

        lblNomeObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        lblNomeObrigatorio.setText("*");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Cadastro");

        lblConfSenhaObrigatorio1.setForeground(new java.awt.Color(255, 0, 0));
        lblConfSenhaObrigatorio1.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblConfSenha)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtConfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60))
                        .addComponent(btnVoltar, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblCampoObrigatorio)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(lblSenhaObrigatorio))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSenha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(lblEmailObrigatorio))
                            .addComponent(lblConfSenhaObrigatorio)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSexo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnFeminino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnMasculino)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNascimento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(lblConfSenhaObrigatorio1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(lblNomeObrigatorio)))
                        .addComponent(btnCadastrar))
                    .addComponent(jLabel2)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCadastrar, btnVoltar});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtEmail, txtNome, txtSenha});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeObrigatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenhaObrigatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSenha)
                    .addComponent(lblEmailObrigatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfSenha)
                    .addComponent(txtConfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConfSenhaObrigatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNascimento)
                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConfSenhaObrigatorio1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(rbtnFeminino)
                    .addComponent(rbtnMasculino))
                .addGap(18, 18, 18)
                .addComponent(lblCampoObrigatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnCadastrar))
                .addGap(30, 30, 30))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtEmail, txtNome});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblCampoObrigatorio;
    private javax.swing.JLabel lblConfSenha;
    private javax.swing.JLabel lblConfSenhaObrigatorio;
    private javax.swing.JLabel lblConfSenhaObrigatorio1;
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
