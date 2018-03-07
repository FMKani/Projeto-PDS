package moneywise.visao;

import java.math.RoundingMode;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.JOptionPane;
import javax.swing.text.InternationalFormatter;
import moneywise.dao.MovimentacaoDao;
import moneywise.modelo.Movimentacao;
import moneywise.modelo.Usuario;

public class CadastrarMovimentacao extends javax.swing.JFrame {

    Usuario usuario;

    public CadastrarMovimentacao(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boxVazio = new javax.swing.JComboBox<>();
        lblDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        lblData = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        txtValor = new javax.swing.JFormattedTextField();
        boxTipo = new javax.swing.JComboBox<>();
        lblCategoria = new javax.swing.JLabel();
        boxCategoria = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        lblLimpar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MoneyWise - Cadastrar Movimentção");

        lblDescricao.setText("Descrição:");

        lblData.setText("Data:");

        lblValor.setText("Valor:");

        lblTipo.setText("Tipo");

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        boxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Saída" }));

        lblCategoria.setText("Categoria");

        boxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alimentação", "Aluguel", "Água", "Luz", "Saúde", "Pessoal", "Outro" }));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblLimpar.setText("Limpar Formulário");
        lblLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblLimparActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescricao)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDescricao)
                                    .addComponent(lblData))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValor)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblValor)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(boxCategoria, 0, 129, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(46, 46, 46)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCategoria)
                        .addGap(92, 92, 92))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLimpar)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(lblValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(lblCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(lblLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnVoltar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtValor.setFormatterFactory(new AbstractFormatterFactory() {

            @Override
            public AbstractFormatter getFormatter(JFormattedTextField tf) {
                NumberFormat format = DecimalFormat.getInstance();
                format.setMinimumFractionDigits(2);
                format.setMaximumFractionDigits(2);
                format.setRoundingMode(RoundingMode.HALF_UP);
                InternationalFormatter formatter = new InternationalFormatter(format);
                formatter.setAllowsInvalid(false);
                formatter.setMinimum(0.0);
                formatter.setMaximum(10000.00);
                return formatter;
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String descricao = txtDescricao.getText();
        Date data;
        try {
            data = getData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        float valor;

        try {
            valor = getValor();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Campo valor vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String tipo = String.valueOf(boxTipo.getSelectedItem());
        String categoria = String.valueOf(boxCategoria.getSelectedItem());
        
        try{
            MovimentacaoDao movDao = new MovimentacaoDao();
            
            Movimentacao mov = new Movimentacao (-1, usuario.getEmail(), descricao, valor, data, tipo, categoria);
            
            if(!movDao.salvar(mov)){
                JOptionPane.showMessageDialog(null, "Erro no cadastro.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cadastro de movimentação concluido.", "Concluido", JOptionPane.INFORMATION_MESSAGE);
            }
            
            movDao.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarMovimentacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        limparFormulario();

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        Home home = new Home(usuario);
        home.setLocation(this.getX(), this.getY());
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void lblLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblLimparActionPerformed
        limparFormulario();
    }//GEN-LAST:event_lblLimparActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxCategoria;
    private javax.swing.JComboBox<String> boxTipo;
    private javax.swing.JComboBox<String> boxVazio;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JButton lblLimpar;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblValor;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables

    private Date getData() throws Exception {
        String dataOriginal = txtData.getText();
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

    private float getValor() throws NumberFormatException {
        String strValor = txtValor.getText();
        strValor = strValor.replace(".", "");
        strValor = strValor.replace(",", ".");

        float result = Float.parseFloat(strValor);
        return result;
    }

    private void limparFormulario(){
        txtDescricao.setText("");
        txtData.setText("");
        txtValor.setText("0");
        boxTipo.setSelectedIndex(0);
        boxCategoria.setSelectedIndex(0);
    }
    
}
