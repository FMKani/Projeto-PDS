package moneywise.visao;

import java.awt.Toolkit;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.InternationalFormatter;
import moneywise.dao.MovimentacaoDao;
import moneywise.modelo.Movimentacao;
import moneywise.modelo.Usuario;

public class GerenciarFinancas extends javax.swing.JFrame {

    Usuario usuario;

    public GerenciarFinancas(Usuario usuario) {
        this.usuario = usuario;
        initComponents();

        buscarEListar();
        setIcon();
        setVisible(true);

        ListSelectionModel selectionModel = tabela.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (!selectionModel.isSelectionEmpty()) {

                    int selectedRow = selectionModel.getMinSelectionIndex();
                    setCampoMovimentacao(getMovimentacao(selectedRow));

                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDataInicial = new javax.swing.JLabel();
        txtDataInicial = new javax.swing.JFormattedTextField();
        lblDataFinal = new javax.swing.JLabel();
        txtDataFinal = new javax.swing.JFormattedTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        lblCampoID = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblID = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JFormattedTextField();
        txtData = new javax.swing.JFormattedTextField();
        boxTipo = new javax.swing.JComboBox<>();
        boxCategoria = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        lblFiltroTipo = new javax.swing.JLabel();
        boxEntrada = new javax.swing.JCheckBox();
        boxSaida = new javax.swing.JCheckBox();
        boxAlimentacao = new javax.swing.JCheckBox();
        lblFiltroCategoria = new javax.swing.JLabel();
        boxAluguel = new javax.swing.JCheckBox();
        boxAgua = new javax.swing.JCheckBox();
        boxLuz = new javax.swing.JCheckBox();
        boxSaude = new javax.swing.JCheckBox();
        boxPessoal = new javax.swing.JCheckBox();
        boxOutro = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDataInicial.setText("Data Inicial");

        try {
            txtDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblDataFinal.setText("Data Final");

        try {
            txtDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data", "Descrição", "Tipo", "Categoria", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        lblCampoID.setText("ID:");

        lblID.setText("-");

        lblData.setText("Data:");

        lblDescricao.setText("Descrição");

        lblTipo.setText("Tipo");

        lblCategoria.setText("Categoria");

        lblValor.setText("Valor:");

        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        boxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Saída" }));

        boxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alimentação", "Aluguel", "Água", "Luz", "Saúde", "Pessoal", "Outro" }));

        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblFiltroTipo.setText("Tipo:");

        boxEntrada.setSelected(true);
        boxEntrada.setText("Entrada");

        boxSaida.setSelected(true);
        boxSaida.setText("Saída");

        boxAlimentacao.setSelected(true);
        boxAlimentacao.setText("Alimentação");

        lblFiltroCategoria.setText("Categoria:");

        boxAluguel.setSelected(true);
        boxAluguel.setText("Aluguel");

        boxAgua.setSelected(true);
        boxAgua.setText("Água");

        boxLuz.setSelected(true);
        boxLuz.setText("Luz");

        boxSaude.setSelected(true);
        boxSaude.setText("Saúde");

        boxPessoal.setSelected(true);
        boxPessoal.setText("Pessoal");

        boxOutro.setSelected(true);
        boxOutro.setText("Outro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricao))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCampoID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblID)
                        .addGap(41, 41, 41)
                        .addComponent(lblData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValor))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boxAlimentacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxAluguel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxAgua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxLuz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxSaude)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boxPessoal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxOutro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDataInicial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDataFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFiltroCategoria)
                            .addComponent(lblFiltroTipo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boxEntrada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(boxSaida)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataInicial)
                    .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataFinal)
                    .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(lblFiltroTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxEntrada)
                    .addComponent(boxSaida))
                .addGap(18, 18, 18)
                .addComponent(lblFiltroCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxAlimentacao)
                    .addComponent(boxAluguel)
                    .addComponent(boxAgua)
                    .addComponent(boxLuz)
                    .addComponent(boxSaude)
                    .addComponent(boxPessoal)
                    .addComponent(boxOutro)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCampoID)
                    .addComponent(lblID)
                    .addComponent(lblData)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(lblCategoria)
                    .addComponent(lblValor)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnExcluir)
                    .addComponent(btnAtualizar))
                .addContainerGap())
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

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        voltar();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        int rowIndex = tabela.getSelectedRow();
        if (rowIndex < 0) {
            return;
        }
        int idColumnIndex = 0;
        int id = (Integer) tabela.getValueAt(rowIndex, idColumnIndex);

        int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir essa movimentação?",
                "Aviso.", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {

            try {
                MovimentacaoDao movDao = new MovimentacaoDao();

                movDao.remover(id);
                movDao.close();

                JOptionPane.showMessageDialog(null, "Movimentação excluida.", "Concluido", JOptionPane.INFORMATION_MESSAGE);

                buscarEListar();
                limpaCampoMovimentacao();

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(GerenciarFinancas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed

        int dialogResult = JOptionPane.showConfirmDialog(null, "Salvar modificações?",
                "Aviso.", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.NO_OPTION) {
            return;
        }

        int id = Integer.parseInt(lblID.getText());
        String descricao = txtDescricao.getText();
        Date data;
        try {
            data = getData(txtData);
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

        try {
            MovimentacaoDao movDao = new MovimentacaoDao();

            Movimentacao mov = new Movimentacao(id, usuario.getEmail(), descricao, valor, data, tipo, categoria);

            if (!movDao.atualizar(id, mov)) {
                JOptionPane.showMessageDialog(null, "Erro na atualização.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Movimentação atualizada.", "Concluido", JOptionPane.INFORMATION_MESSAGE);
            }

            movDao.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarMovimentacao.class.getName()).log(Level.SEVERE, null, ex);
        }

        buscarEListar();
        

    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarEListar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtDataInicial.setText(null);
        txtDataFinal.setText(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox boxAgua;
    private javax.swing.JCheckBox boxAlimentacao;
    private javax.swing.JCheckBox boxAluguel;
    private javax.swing.JComboBox<String> boxCategoria;
    private javax.swing.JCheckBox boxEntrada;
    private javax.swing.JCheckBox boxLuz;
    private javax.swing.JCheckBox boxOutro;
    private javax.swing.JCheckBox boxPessoal;
    private javax.swing.JCheckBox boxSaida;
    private javax.swing.JCheckBox boxSaude;
    private javax.swing.JComboBox<String> boxTipo;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCampoID;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDataFinal;
    private javax.swing.JLabel lblDataInicial;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblFiltroCategoria;
    private javax.swing.JLabel lblFiltroTipo;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTable tabela;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtDataFinal;
    private javax.swing.JFormattedTextField txtDataInicial;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables

    private void listarTudo() {
        try {
            MovimentacaoDao movDao = new MovimentacaoDao();
            List<Movimentacao> movimentacoes = movDao.listarTudo(usuario);

            listaTabela(movimentacoes);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GerenciarFinancas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void limpaTabela(){
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setRowCount(0);
    }

    private void listaTabela(List<Movimentacao> lista) {
        limpaTabela();
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();        

        for (int i = 0; i < lista.size(); i++) {
            Movimentacao mov = lista.get(i);

            model.addRow(new Object[]{
                mov.getCod(),
                dataToString(mov.getData()),
                mov.getDescricao(),
                mov.getTipo(),
                mov.getCategoria(),
                String.format("%,.2f", mov.getValor())
            });
        }

    }
    
    private void buscarEListar(){
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("SELECT * FROM Movimentacao WHERE Usuario LIKE '" + usuario.getEmail() + "'");
                
        //Datas
        Date inicio;
        Date fim;
        try {
            inicio = getData(txtDataInicial);
            fim = getData(txtDataFinal);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (inicio != null){
            sqlBuilder.append(" and data>= '" + inicio.toString() + "'");
        }
        if (fim != null){
            sqlBuilder.append(" and data<= '" + fim.toString() + "'");
        }
        
        //Tipos
        if (!boxEntrada.isSelected()){
            sqlBuilder.append(" and Tipo NOT LIKE 'Entrada'");
        }
        if (!boxSaida.isSelected()){
            sqlBuilder.append(" and Tipo NOT LIKE 'Saída'");
        }
        
        //Categorias
        if (!boxAlimentacao.isSelected()){
            sqlBuilder.append(" and Categoria NOT LIKE 'Alimentação'");
        }
        if (!boxAluguel.isSelected()){
            sqlBuilder.append(" and Categoria NOT LIKE 'Aluguel'");
        }
        if (!boxAgua.isSelected()){
            sqlBuilder.append(" and Categoria NOT LIKE 'Água'");
        }
        if (!boxLuz.isSelected()){
            sqlBuilder.append(" and Categoria NOT LIKE 'Luz'");
        }
        if (!boxSaude.isSelected()){
            sqlBuilder.append(" and Categoria NOT LIKE 'Saúde'");
        }
        if (!boxPessoal.isSelected()){
            sqlBuilder.append(" and Categoria NOT LIKE 'Pessoal'");
        }
        if (!boxOutro.isSelected()){
            sqlBuilder.append(" and Categoria NOT LIKE 'Outro'");
        }
                
        //Efetua busca
        List<Movimentacao> lista = null;
        try {
            MovimentacaoDao movDao = new MovimentacaoDao();
            System.out.println(sqlBuilder.toString());
            lista = movDao.listarSQL(sqlBuilder.toString());
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o Banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        listaTabela(lista);
    }

    private Movimentacao getMovimentacao(int rowIndex) {

        Movimentacao mov = new Movimentacao(
                (Integer) tabela.getValueAt(rowIndex, 0),
                usuario.getEmail(),
                (String) tabela.getValueAt(rowIndex, 2),
                valorToFloat((String) tabela.getValueAt(rowIndex, 5)),
                dataToDate((String) tabela.getValueAt(rowIndex, 1)),
                (String) tabela.getValueAt(rowIndex, 3),
                (String) tabela.getValueAt(rowIndex, 4));

        return mov;

    }

    private void limpaCampoMovimentacao() {

        lblID.setText("-");
        txtData.setText("");
        txtDescricao.setText("");
        boxTipo.setSelectedIndex(0);
        boxCategoria.setSelectedIndex(0);
        txtValor.setText("0000,00");
    }

    private void setCampoMovimentacao(Movimentacao mov) {

        lblID.setText(Integer.toString(mov.getCod()));
        txtData.setText(dataToString(mov.getData()));
        txtDescricao.setText(mov.getDescricao());
        boxTipo.setSelectedItem(mov.getTipo());
        boxCategoria.setSelectedItem(mov.getCategoria());
        txtValor.setText(formatValor(Float.toString(mov.getValor())));
    }

    private String formatValor(String valor) {
        valor = valor.replace(".", ",");
        return valor;
    }

    private Date getData(JFormattedTextField campo) throws Exception {
        String dataOriginal = campo.getText();
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

    private Date dataToDate(String dataOriginal) {
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
            //
        }

        return data;
    }

    private float valorToFloat(String valor) throws NumberFormatException {
        valor = valor.replace(".", "");
        valor = valor.replace(",", ".");

        float result = Float.parseFloat(valor);
        return result;
    }

    private String dataToString(Date data) {
        if (data == null) {
            return "";
        }

        LocalDate localDate = data.toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return localDate.format(formatter);
    }

    private void voltar() {
        Home home = new Home(usuario);
        home.setLocation(this.getX(), this.getY());
        this.dispose();
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/mw.png")));
    }

}
