
package view;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

public class TelaCadastro extends javax.swing.JFrame {

    Connection con;
    PreparedStatement st;
    PreparedStatement st2;
    ResultSet rs;

    public TelaCadastro() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Tipo_Sexo1 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        TipoCidade = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        TipoVirus = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        TipoAndamentoCaso = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        txtData = new javax.swing.JFormattedTextField();
        txtCPF = new javax.swing.JFormattedTextField();
        txtID = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIDBusca = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtRetornoBusca = new javax.swing.JTextField();
        btnBuscaCpf = new javax.swing.JButton();
        txtCPFBusca = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 800));
        setPreferredSize(new java.awt.Dimension(780, 400));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Cadastro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(780, 900));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Nome:");

        txtNome.setBackground(new java.awt.Color(204, 204, 204));
        txtNome.setForeground(new java.awt.Color(0, 0, 0));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Idade:");

        txtIdade.setBackground(new java.awt.Color(204, 204, 204));
        txtIdade.setForeground(new java.awt.Color(0, 0, 0));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Sexo:");

        Tipo_Sexo1.setBackground(new java.awt.Color(204, 204, 204));
        Tipo_Sexo1.setForeground(new java.awt.Color(0, 0, 0));
        Tipo_Sexo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Masculino", "Feminino", "Transgênero" }));
        Tipo_Sexo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tipo_Sexo1ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("CPF:");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Cidade:");

        TipoCidade.setBackground(new java.awt.Color(204, 204, 204));
        TipoCidade.setForeground(new java.awt.Color(0, 0, 0));
        TipoCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Santo André", "São Bernardo do Campo", "São Caetano do Sul" }));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Tipo do Virus:");

        TipoVirus.setBackground(new java.awt.Color(204, 204, 204));
        TipoVirus.setForeground(new java.awt.Color(0, 0, 0));
        TipoVirus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Covid-19", "Dengue", "H1N1" }));

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Data da ocorrência:");

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Andamento do caso:");

        TipoAndamentoCaso.setBackground(new java.awt.Color(204, 204, 204));
        TipoAndamentoCaso.setForeground(new java.awt.Color(0, 0, 0));
        TipoAndamentoCaso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Curado", "Tratando", "ÓbIto" }));

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("ID do caso:");

        btnSalvar.setBackground(new java.awt.Color(0, 0, 0));
        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(204, 255, 204));
        btnSalvar.setText("SALVAR");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtData.setBackground(new java.awt.Color(204, 204, 204));
        txtData.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtCPF.setBackground(new java.awt.Color(204, 204, 204));
        txtCPF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCPF.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtID.setBackground(new java.awt.Color(204, 204, 204));
        txtID.setForeground(new java.awt.Color(0, 0, 0));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Busca ocorrências ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("I.D do caso:");

        btnBuscar.setBackground(new java.awt.Color(0, 0, 0));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(153, 255, 255));
        btnBuscar.setText("BUSCAR");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtRetornoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRetornoBuscaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtRetornoBusca)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtRetornoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnBuscaCpf.setBackground(new java.awt.Color(0, 0, 0));
        btnBuscaCpf.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscaCpf.setForeground(new java.awt.Color(153, 255, 255));
        btnBuscaCpf.setText("BUSCAR");
        btnBuscaCpf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscaCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaCpfActionPerformed(evt);
            }
        });

        try {
            txtCPFBusca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CPF:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtIDBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtCPFBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscaCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtIDBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnBuscaCpf)
                    .addComponent(txtCPFBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAlterar.setBackground(new java.awt.Color(0, 0, 0));
        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(204, 204, 255));
        btnAlterar.setText("ALTERAR");
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(0, 0, 0));
        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 51, 51));
        btnExcluir.setText("EXCLUIR");
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(new java.awt.Color(0, 0, 0));
        btnLimpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpar.setForeground(new java.awt.Color(255, 255, 204));
        btnLimpar.setText("LIMPAR");
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TipoAndamentoCaso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TipoCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tipo_Sexo1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TipoVirus, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15)
                    .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(Tipo_Sexo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(TipoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(TipoVirus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(TipoAndamentoCaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtNomeActionPerformed

    private void Tipo_Sexo1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Tipo_Sexo1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_Tipo_Sexo1ActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalvarActionPerformed
        // Botão salvar , quando ele for precionado ira pegar os dados do cadastro e
        // salvar as informações no banco de dados
        Cadastros cadastros = new Cadastros();

        CadastroDao dao;
        boolean status;
        int resp;

        String datainvertida = txtData.getText();
        String datacorreta = "";

        String[] partes = new String[3];
        partes = datainvertida.split("/");
        datacorreta = partes[2] + "-" + partes[1] + "-" + partes[0];

        cadastros.setNome(txtNome.getText());
        cadastros.setCPF(txtCPF.getText());
        cadastros.setIdade(txtIdade.getText());
        cadastros.setSexo((String) Tipo_Sexo1.getSelectedItem());
        cadastros.setCidade((String) TipoCidade.getSelectedItem());
        cadastros.setVirus((String) TipoVirus.getSelectedItem());
        cadastros.setData(datacorreta);
        cadastros.setAndamento((String) TipoAndamentoCaso.getSelectedItem());
        cadastros.setID(txtID.getText());

        dao = new CadastroDao();
        status = dao.conectar();
        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados.");
        } else {
            resp = dao.salvar(cadastros);
            if (resp == 1) {
                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso !");
                LimparCampos();
            } else if (resp == 1062) {
                JOptionPane.showMessageDialog(null, "Este I.D já esta sendo usado tente outro numero");
            } else {
                JOptionPane.showMessageDialog(null, "Verifique se todos os dados foram inseridos corretamente!" + resp);
            }
            dao.desconectar();

        }

    }// GEN-LAST:event_btnSalvarActionPerformed

    private void LimparCampos() {
        txtNome.setText("");
        txtCPF.setText("");
        txtData.setText("");
        txtID.setText("");
        txtIdade.setText("");
        TipoAndamentoCaso.setSelectedItem("Selecione");
        TipoCidade.setSelectedItem("Selecione");
        Tipo_Sexo1.setSelectedItem("Selecione");
        TipoVirus.setSelectedItem("Selecione");
        txtRetornoBusca.setText("");
        txtCPFBusca.setText("");
        txtIDBusca.setText("");
        txtNome.requestFocus();

    }

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtIDActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:

        Cadastros cadastros;
        CadastroDao dao;
        boolean status;
        int resp;

        String datainvertida = txtData.getText();
        String datacorreta = "";

        String[] partes = new String[3];
        partes = datainvertida.split("/");
        datacorreta = partes[2] + "-" + partes[1] + "-" + partes[0];

        cadastros = new Cadastros();
        cadastros.setNome(txtNome.getText());
        cadastros.setCPF(txtCPF.getText());
        cadastros.setIdade(txtIdade.getText());
        cadastros.setSexo((String) Tipo_Sexo1.getSelectedItem());
        cadastros.setCidade((String) TipoCidade.getSelectedItem());
        cadastros.setVirus((String) TipoVirus.getSelectedItem());
        cadastros.setData(datacorreta);
        cadastros.setAndamento((String) TipoAndamentoCaso.getSelectedItem());
        cadastros.setID(txtID.getText());

        dao = new CadastroDao();
        status = dao.conectar();
        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados.");
        } else {
            resp = dao.alterar(cadastros);
            if (resp == 1) {
                JOptionPane.showMessageDialog(null, "Dados alterados com sucesso !");
                LimparCampos();
            } else if (resp == 1062) {
                JOptionPane.showMessageDialog(null, "Este I.D já esta sendo usado tente outro numero");
            } else {
                JOptionPane.showMessageDialog(null,
                        "Erro ao salvar os dados verifique se todos campos foram preenchidos corretamente");
            }
            dao.desconectar();
        }

    }// GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExcluirActionPerformed
        CadastroDao dao = new CadastroDao();
        boolean status = dao.conectar();
        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados");
        } else {
            status = dao.excluir(txtID.getText(), txtCPF.getText());
            if (status == true) {
                JOptionPane.showMessageDialog(null, "Dados excluídos com sucesso");
                LimparCampos();
                btnExcluir.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Erro na exclusão dos dados !");

            }
            dao.desconectar();
        }

    }// GEN-LAST:event_btnExcluirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String ID;
        ID = txtIDBusca.getText();

        CadastroDao dao = new CadastroDao();
        boolean status = dao.conectar();
        if (status == true) {
            Cadastros cadastros = dao.buscar(ID);

            if (cadastros == null) {
                JOptionPane.showMessageDialog(null, "ID não localizado no banco de dados");

            } else {

                System.out.println(cadastros.getData());
                txtID.setText(cadastros.getID());
                txtData.setText(cadastros.getData());
                txtNome.setText(cadastros.getNome());
                TipoVirus.setSelectedItem(cadastros.getVirus());
                txtCPF.setText(cadastros.getCPF());
                txtIdade.setText(cadastros.getIdade());
                TipoCidade.setSelectedItem(cadastros.getCidade());
                Tipo_Sexo1.setSelectedItem(cadastros.getSexo());
                TipoAndamentoCaso.setSelectedItem(cadastros.getAndamento());

                txtRetornoBusca.setText("Verifique os dados acima !");
                btnExcluir.setEnabled(true);
            }
            dao.desconectar();
        } else {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados");
        }

    }// GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscaCpfActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscaCpfActionPerformed
        //
        String CPF;
        CPF = txtCPFBusca.getText();

        CadastroDao dao = new CadastroDao();
        boolean status = dao.conectar();
        if (status == true) {
            Cadastros cadastros = dao.buscar2(CPF);
            if (cadastros == null) {
                JOptionPane.showMessageDialog(null, "ID não localizado no banco de dados");

            } else {


                txtData.setText(cadastros.getData());
                txtNome.setText(cadastros.getNome());
                txtCPF.setText(cadastros.getCPF());
                txtIdade.setText(cadastros.getIdade());
                txtID.setText(cadastros.getID());
                TipoCidade.setSelectedItem(cadastros.getCidade());
                TipoVirus.setSelectedItem(cadastros.getVirus());
                Tipo_Sexo1.setSelectedItem(cadastros.getSexo());
                TipoAndamentoCaso.setSelectedItem(cadastros.getAndamento());

                txtRetornoBusca.setText("Verifique os dados acima !");
                btnExcluir.setEnabled(true);
            }
            dao.desconectar();
        } else {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados");
        }

    }// GEN-LAST:event_btnBuscaCpfActionPerformed

    private void txtRetornoBuscaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtRetornoBuscaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtRetornoBuscaActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        LimparCampos();
        btnExcluir.setEnabled(false);
    }// GEN-LAST:event_btnLimparActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> TipoAndamentoCaso;
    private javax.swing.JComboBox<String> TipoCidade;
    private javax.swing.JComboBox<String> TipoVirus;
    private javax.swing.JComboBox<String> Tipo_Sexo1;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscaCpf;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JFormattedTextField txtCPFBusca;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDBusca;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRetornoBusca;
    // End of variables declaration//GEN-END:variables
}
