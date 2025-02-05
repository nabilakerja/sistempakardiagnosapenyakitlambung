/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tampilan;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ASANI
 */
public class rule extends javax.swing.JFrame {
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    private Map<String, Integer> penyakitMap = new HashMap<>();
    private Map<String, Integer> gejalaMap = new HashMap<>();

    /**
     * Creates new form rule
     */
    public rule() {
        initComponents();
        datatable();
        setVisible(true);
        autoIDRule();
        loadComboBoxData();
    }
    
    protected void aktif(){
        tid.setEnabled(true);
        tid.requestFocus();
    }
    protected void kosong(){
        tcari.setText("");  
    }
    
    private void autoIDRule() {
    try {
        // Query untuk mendapatkan ID gejala terakhir
        String sql = "SELECT id_aturan FROM aturan ORDER BY id_aturan DESC LIMIT 1";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        if (rs.next()) {
            // Mengambil ID terakhir dan menambahkan 1 untuk ID baru
            int idTerakhir = rs.getInt("id_aturan");
            int idBaru = idTerakhir + 1;
            tid.setText(String.valueOf(idBaru)); // Menampilkan ID baru pada field
        } else {
            // Jika tabel kosong, mulai dari ID 1
            tid.setText("1");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal membuat ID Aturan: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    protected void datatable() {
    Object[] Baris = {"ID", "Nama Penyakit", "G1", "G2", "G3", "G4", "G5", "G6"};
    tabmode = new DefaultTableModel(null, Baris);
    tblrule.setModel(tabmode);

    String sql = "SELECT aturan.id_aturan, penyakit.nama_penyakit, " +
                 "aturan.gejala_1, aturan.gejala_2, aturan.gejala_3, " +
                 "aturan.gejala_4, aturan.gejala_5, aturan.gejala_6 " +
                 "FROM aturan " +
                 "INNER JOIN penyakit ON aturan.penyakit_id = penyakit.penyakit_id";

    try {
        Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()) {
            String a = hasil.getString("id_aturan");
            String b = hasil.getString("nama_penyakit");
            String c = hasil.getString("gejala_1");
            String d = hasil.getString("gejala_2");
            String e = hasil.getString("gejala_3");
            String f = hasil.getString("gejala_4");
            String g = hasil.getString("gejala_5");
            String h = hasil.getString("gejala_6");
            String[] data = {a, b, c, d, e, f, g, h};
            tabmode.addRow(data);
        }

        // Atur ukuran panjang per kolom
        tblrule.getColumnModel().getColumn(0).setPreferredWidth(50);  // ID Aturan
        tblrule.getColumnModel().getColumn(1).setPreferredWidth(300); // Nama Penyakit
        tblrule.getColumnModel().getColumn(2).setPreferredWidth(80); // G1
        tblrule.getColumnModel().getColumn(3).setPreferredWidth(80); // G2
        tblrule.getColumnModel().getColumn(4).setPreferredWidth(80); // G3
        tblrule.getColumnModel().getColumn(5).setPreferredWidth(80); // G4
        tblrule.getColumnModel().getColumn(6).setPreferredWidth(80); // G5
        tblrule.getColumnModel().getColumn(7).setPreferredWidth(80); // G6

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error saat memuat data tabel: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    private void loadComboBoxData() {
    try {
        // Load data penyakit
        String sqlPenyakit = "SELECT penyakit_id, nama_penyakit FROM penyakit";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sqlPenyakit);
        while (rs.next()) {
            String namaPenyakit = rs.getString("nama_penyakit");
            int idPenyakit = rs.getInt("penyakit_id");
            penyakitMap.put(namaPenyakit, idPenyakit);
            penyakit_list.addItem(namaPenyakit); // Tampilkan nama di JComboBox
        }

        // Load data gejala
        String sqlGejala = "SELECT id_gejala, nama_gejala FROM gejala";
        rs = stmt.executeQuery(sqlGejala);
        while (rs.next()) {
            String namaGejala = rs.getString("nama_gejala");
            int idGejala = rs.getInt("id_gejala");
            gejalaMap.put(namaGejala, idGejala);
            gejala_1.addItem(namaGejala);
            gejala_2.addItem(namaGejala);
            gejala_3.addItem(namaGejala);
            gejala_4.addItem(namaGejala);
            gejala_5.addItem(namaGejala);
            gejala_6.addItem(namaGejala);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        }
    }


    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        gejala_1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        gejala_2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        gejala_3 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        gejala_4 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        gejala_5 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        gejala_6 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tid = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblrule = new javax.swing.JTable();
        btnsave = new javax.swing.JButton();
        penyakit_list = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Gejala 1");

        gejala_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gejala_1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Gejala 2");

        jLabel5.setText("Gejala 3");

        jLabel6.setText("Gejala 4");

        jLabel12.setText("Gejala 5");

        jLabel13.setText("Gejala 6");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FORMULIR DATA RULE");

        exit.setBackground(new java.awt.Color(255, 0, 0));
        exit.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("Close");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
        });
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exit)
                    .addComponent(jLabel1))
                .addGap(16, 16, 16))
        );

        jLabel7.setText("Nama Penyakit");

        jLabel2.setText("ID Rule");

        tid.setEnabled(false);
        tid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidActionPerformed(evt);
            }
        });

        jLabel9.setText("Kata Kunci");

        btncari.setBackground(new java.awt.Color(255, 255, 102));
        btncari.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        tblrule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblrule);

        btnsave.setBackground(new java.awt.Color(0, 102, 102));
        btnsave.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnsave.setForeground(new java.awt.Color(255, 255, 255));
        btnsave.setText("SAVE");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        penyakit_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penyakit_listActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(gejala_4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(gejala_5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(gejala_6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(gejala_1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(gejala_3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gejala_2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(penyakit_list, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btncari)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(penyakit_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gejala_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gejala_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gejala_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gejala_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gejala_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gejala_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addComponent(btnsave))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(btncari))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_exitMouseExited

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void tidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tidActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        // TODO add your handling code here:
        Object[] Baris = {"ID Aturan", "Nama Penyakit", "G1", "G2","G3","G4","G5","G6"};
        tabmode = new DefaultTableModel(null, Baris);
        tblrule.setModel(tabmode);

        // Validasi input pencarian
        String keyword = tcari.getText().trim();
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Masukkan nama rule untuk mencari!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Query untuk mencari data penyakit berdasarkan huruf depan nama
        String sql = "SELECT * FROM aturan WHERE penyakit_id LIKE ?";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, keyword + "%"); // Menambahkan wildcard untuk mencocokkan huruf depan
            ResultSet hasil = stat.executeQuery();

            // Ambil data dari ResultSet
            boolean dataDitemukan = false;
            while (hasil.next()) {
                dataDitemukan = true;
                String a = hasil.getString("id_aturan");
                String b = hasil.getString("penyakit_id");
                String c = hasil.getString("gejala_1");
                String d = hasil.getString("gejala_2");
                String e = hasil.getString("gejala_3");
                String f = hasil.getString("gejala_4");
                String g = hasil.getString("gejala_5");
                String h = hasil.getString("gejala_6");
                String[] data = {a, b, c, d, e, f, g, h};
                tabmode.addRow(data);
            }

            // Jika tidak ada data ditemukan
            if (!dataDitemukan) {
                JOptionPane.showMessageDialog(null, "Data rule tidak ditemukan!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btncariActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
    String id = tid.getText();
    String namaPenyakit = (String) penyakit_list.getSelectedItem();
    String gejala1 = (String) gejala_1.getSelectedItem();
    String gejala2 = (String) gejala_2.getSelectedItem();
    String gejala3 = (String) gejala_3.getSelectedItem();
    String gejala4 = (String) gejala_4.getSelectedItem();
    String gejala5 = (String) gejala_5.getSelectedItem();
    String gejala6 = (String) gejala_6.getSelectedItem();

    if (id.isEmpty() || namaPenyakit == null || gejala1 == null || gejala2 == null || 
        gejala3 == null || gejala4 == null || gejala5 == null || gejala6 == null) {
        JOptionPane.showMessageDialog(null, "Semua field harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    } else {
        try {
            String sql = "INSERT INTO aturan (id_aturan, gejala_1, gejala_2, gejala_3, gejala_4, gejala_5, gejala_6, penyakit_id) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setString(1, id);
            stat.setInt(2, gejalaMap.get(gejala1)); // Ambil ID dari Map
            stat.setInt(3, gejalaMap.get(gejala2));
            stat.setInt(4, gejalaMap.get(gejala3));
            stat.setInt(5, gejalaMap.get(gejala4));
            stat.setInt(6, gejalaMap.get(gejala5));
            stat.setInt(7, gejalaMap.get(gejala6));
            stat.setInt(8, penyakitMap.get(namaPenyakit)); // Ambil ID penyakit dari Map

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
            kosong(); // Metode untuk mengosongkan semua field setelah menyimpan data
            autoIDRule(); // Update the auto-generated ID, if necessary
            datatable();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void penyakit_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penyakit_listActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_penyakit_listActionPerformed

    private void gejala_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gejala_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gejala_1ActionPerformed

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
            java.util.logging.Logger.getLogger(rule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton exit;
    private javax.swing.JComboBox<String> gejala_1;
    private javax.swing.JComboBox<String> gejala_2;
    private javax.swing.JComboBox<String> gejala_3;
    private javax.swing.JComboBox<String> gejala_4;
    private javax.swing.JComboBox<String> gejala_5;
    private javax.swing.JComboBox<String> gejala_6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> penyakit_list;
    private javax.swing.JTable tblrule;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tid;
    // End of variables declaration//GEN-END:variables
}
