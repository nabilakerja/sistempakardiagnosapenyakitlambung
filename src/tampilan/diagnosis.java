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
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
/**
 *
 * @author ASANI
 */
public class diagnosis extends javax.swing.JFrame {
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    /**
     * Creates new form diagnosis
     */
    public diagnosis() {
        initComponents();
        setVisible(true);
        loadNamaPasien();
        loadGejala1();
        loadGejala2();
        loadGejala3();
        loadGejala4();
        loadGejala5();
        loadGejala6();
        datatable();
    }
    
    
    private void loadNamaPasien() {
        try {
        String sql = "SELECT pasien_id, nama_pasien FROM pasien";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        list_pasien.removeAllItems(); // Hapus item sebelumnya
        list_pasien.addItem("Pilih Pasien"); // Tambahkan placeholder

        while (rs.next()) {
            int idPasien = rs.getInt("pasien_id");
            String namaPasien = rs.getString("nama_pasien");
            // Tambahkan ke ComboBox dalam format "pasien_id - nama_pasien"
            list_pasien.addItem(idPasien + " - " + namaPasien);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal memuat data pasien!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    private void loadGejala1() {
       try {
        // Query untuk mengambil nama gejala dari tabel
        String sql = "SELECT nama_gejala FROM gejala";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        // Hapus semua item yang ada di ComboBox sebelum menambahkan item baru
        gejala_1.removeAllItems();
        gejala_1.addItem("pilih");
        // Loop melalui hasil query dan tambahkan ke ComboBox
        while (rs.next()) {
            String namaGejala1 = rs.getString("nama_gejala");
            gejala_1.addItem(namaGejala1);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal memuat data gejala!");
    }
    }
    
    private void loadGejala2() {
        try {
        // Query untuk mengambil nama gejala dari tabel
        String sql = "SELECT nama_gejala FROM gejala";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        // Hapus semua item yang ada di ComboBox sebelum menambahkan item baru
        gejala_2.removeAllItems();
        gejala_2.addItem("pilih");

        // Loop melalui hasil query dan tambahkan ke ComboBox
        while (rs.next()) {
            String namaGejala2 = rs.getString("nama_gejala");
            gejala_2.addItem(namaGejala2);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal memuat data gejala!");
    }
    }
    
    private void loadGejala3() {
    try {
        // Query untuk mengambil nama gejala dari tabel
        String sql = "SELECT nama_gejala FROM gejala";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        // Hapus semua item yang ada di ComboBox sebelum menambahkan item baru
        gejala_3.removeAllItems();
        gejala_3.addItem("pilih");

        // Loop melalui hasil query dan tambahkan ke ComboBox
        while (rs.next()) {
            String namaGejala3 = rs.getString("nama_gejala");
            gejala_3.addItem(namaGejala3);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal memuat data gejala!");
    }
}

    
    private void loadGejala4() {
        try {
        // Query untuk mengambil nama gejala dari tabel
        String sql = "SELECT nama_gejala FROM gejala";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        // Hapus semua item yang ada di ComboBox sebelum menambahkan item baru
        gejala_4.removeAllItems();
        gejala_4.addItem("pilih");

        // Loop melalui hasil query dan tambahkan ke ComboBox
        while (rs.next()) {
            String namaGejala4 = rs.getString("nama_gejala");
            gejala_4.addItem(namaGejala4);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal memuat data gejala!");
    }
    }
    
    private void loadGejala5() {
        try {
        // Query untuk mengambil nama gejala dari tabel
        String sql = "SELECT nama_gejala FROM gejala";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        // Hapus semua item yang ada di ComboBox sebelum menambahkan item baru
        gejala_5.removeAllItems();
        gejala_5.addItem("pilih");

        // Loop melalui hasil query dan tambahkan ke ComboBox
        while (rs.next()) {
            String namaGejala5 = rs.getString("nama_gejala");
            gejala_5.addItem(namaGejala5);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal memuat data gejala!");
    }
    }
    
    private void loadGejala6() {
       try {
        // Query untuk mengambil nama gejala dari tabel
        String sql = "SELECT nama_gejala FROM gejala";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        // Hapus semua item yang ada di ComboBox sebelum menambahkan item baru
        gejala_6.removeAllItems();
        gejala_6.addItem("pilih");

        // Loop melalui hasil query dan tambahkan ke ComboBox
        while (rs.next()) {
            String namaGejala6 = rs.getString("nama_gejala");
            gejala_6.addItem(namaGejala6);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal memuat data gejala!");
    }
    }
    
    private Integer diagnosaPenyakit(Integer gejala1, Integer gejala2, Integer gejala3, Integer gejala4, Integer gejala5, Integer gejala6) {
    try {
        // Query untuk mencocokkan gejala dengan penyakit
        String sql = "SELECT penyakit_id FROM aturan WHERE " +
                     "gejala_1 = ? AND (gejala_2 = ? OR gejala_2 IS NULL) AND " +
                     "(gejala_3 = ? OR gejala_3 IS NULL) AND (gejala_4 = ? OR gejala_4 IS NULL) AND " +
                     "(gejala_5 = ? OR gejala_5 IS NULL) AND (gejala_6 = ? OR gejala_6 IS NULL)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, gejala1);
        stmt.setObject(2, gejala2, java.sql.Types.INTEGER);
        stmt.setObject(3, gejala3, java.sql.Types.INTEGER);
        stmt.setObject(4, gejala4, java.sql.Types.INTEGER);
        stmt.setObject(5, gejala5, java.sql.Types.INTEGER);
        stmt.setObject(6, gejala6, java.sql.Types.INTEGER);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getInt("penyakit_id"); // Kembalikan ID penyakit sebagai Integer
        } else {
            return null; // Tidak ditemukan penyakit
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return null; // Kesalahan dalam diagnosa
    }
}





    private Integer getGejalaId(String gejalaName) {
    try {
        String sql = "SELECT id_gejala FROM gejala WHERE nama_gejala = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, gejalaName);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("id_gejala");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal mendapatkan ID gejala! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return null;
    }

    private String getGejalaName(Integer idGejala) {
    String gejalaName = "Tidak Diketahui";
    
    if (idGejala != null) {
        String sql = "SELECT nama_gejala FROM gejala WHERE id_gejala = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idGejala);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                gejalaName = rs.getString("nama_gejala");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return gejalaName;
    }


    private String getNamaPenyakitById(Integer penyakitId) {
    try {
        String sql = "SELECT nama_penyakit FROM penyakit WHERE penyakit_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, penyakitId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getString("nama_penyakit");
        } else {
            return "Tidak ditemukan nama penyakit.";
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return "Kesalahan dalam mengambil nama penyakit.";
    }
}

    
    private void saveRiwayatDiagnosa(int pasienId, Integer gejala1, Integer gejala2, Integer gejala3, 
                                 Integer gejala4, Integer gejala5, Integer gejala6, Integer penyakitId) {
    try {
        // Query untuk menyimpan riwayat diagnosa
        String sql = "INSERT INTO riwayat_diagnosa (pasien_id, gejala_1, gejala_2, gejala_3, gejala_4, gejala_5, gejala_6, penyakit_id, tanggal_diagnosa) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW())";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, pasienId);
        stmt.setObject(2, gejala1, java.sql.Types.INTEGER);
        stmt.setObject(3, gejala2, java.sql.Types.INTEGER);
        stmt.setObject(4, gejala3, java.sql.Types.INTEGER);
        stmt.setObject(5, gejala4, java.sql.Types.INTEGER);
        stmt.setObject(6, gejala5, java.sql.Types.INTEGER);
        stmt.setObject(7, gejala6, java.sql.Types.INTEGER);
        stmt.setObject(8, penyakitId, java.sql.Types.INTEGER);

        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Riwayat diagnosa berhasil disimpan.");
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal menyimpan riwayat diagnosa! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    protected void datatable() {
    Object[] Baris = {"ID", "Nama Pasien", "Tanggal Diagnosa", "Riwayat Penyakit", "Definisi", "Solusi"};
    tabmode = new DefaultTableModel(null, Baris);
    tbldiagnosa.setModel(tabmode);

    // SQL untuk JOIN tabel riwayat_diagnosa dengan tabel penyakit
    var sql = "SELECT rd.id_diagnosa, p.nama_pasien AS nama_pasien, tanggal_diagnosa ,py.nama_penyakit, py.definisi, py.solusi FROM riwayat_diagnosa rd JOIN pasien p ON rd.pasien_id = p.pasien_id JOIN penyakit py ON rd.penyakit_id = py.penyakit_id ORDER BY rd.id_diagnosa ASC ";

    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()) {
            String a = hasil.getString("id_diagnosa"); // ID diagnosa
            String b = hasil.getString("nama_pasien"); // Nama pasien
            String c = hasil.getString("tanggal_diagnosa"); // Riwayat penyakit (nama penyakit)
            String d = hasil.getString("nama_penyakit"); // Riwayat penyakit (nama penyakit)
            String e = hasil.getString("definisi"); // Definisi penyakit
            String f = hasil.getString("solusi"); // Solusi penyakit
            String[] data = {a, b, c, d, e, f};
            tabmode.addRow(data);
        }
    } catch (Exception e) {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        list_pasien = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        gejala_1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        gejala_2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        gejala_3 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        gejala_4 = new javax.swing.JComboBox<>();
        btn_diagnosa = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        gejala_5 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        gejala_6 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbldiagnosa = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DIAGNOSA PENYAKIT LAMBUNG");

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
                .addContainerGap(228, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(167, 167, 167)
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

        jLabel2.setText("Nama Pasien");

        jLabel3.setText("Gejala 1");

        jLabel4.setText("Gejala 2");

        jLabel5.setText("Gejala 3");

        jLabel6.setText("Gejala 4");

        btn_diagnosa.setBackground(new java.awt.Color(0, 102, 102));
        btn_diagnosa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_diagnosa.setForeground(new java.awt.Color(255, 255, 255));
        btn_diagnosa.setText("Diagnosa");
        btn_diagnosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_diagnosaActionPerformed(evt);
            }
        });

        jLabel12.setText("Gejala 5");

        jLabel13.setText("Gejala 6");

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/logors.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        tbldiagnosa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbldiagnosa);

        jLabel9.setText("Kata Kunci");

        btncari.setBackground(new java.awt.Color(255, 255, 102));
        btncari.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(list_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(gejala_1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(gejala_3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gejala_2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(gejala_4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(18, 18, 18)
                                    .addComponent(gejala_5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addGap(18, 18, 18)
                                    .addComponent(gejala_6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addComponent(btn_diagnosa))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btncari)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(list_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(gejala_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(gejala_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(gejala_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createSequentialGroup()
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
                                    .addComponent(jLabel13)))
                            .addComponent(btn_diagnosa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(btncari))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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

    private void btn_diagnosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_diagnosaActionPerformed
     try {
        // Ambil data pasien
        String selectedItem = list_pasien.getSelectedItem().toString();
        if ("Pilih Pasien".equals(selectedItem)) {
            JOptionPane.showMessageDialog(null, "Harap pilih pasien!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String namaPasien = selectedItem.split(" - ")[1];
        int pasienId = Integer.parseInt(selectedItem.split(" - ")[0]);

        // Ambil data gejala
        String namaGejala1 = gejala_1.getSelectedItem().toString();
        String namaGejala2 = gejala_2.getSelectedItem().toString();
        String namaGejala3 = gejala_3.getSelectedItem().toString();
        String namaGejala4 = gejala_4.getSelectedItem().toString();
        String namaGejala5 = gejala_5.getSelectedItem().toString();
        String namaGejala6 = gejala_6.getSelectedItem().toString();

        Integer idGejala1 = getGejalaId(namaGejala1);
        Integer idGejala2 = getGejalaId(namaGejala2);
        Integer idGejala3 = getGejalaId(namaGejala3);
        Integer idGejala4 = getGejalaId(namaGejala4);
        Integer idGejala5 = getGejalaId(namaGejala5);
        Integer idGejala6 = getGejalaId(namaGejala6);

        // Diagnosa penyakit
        Integer penyakitId = diagnosaPenyakit(idGejala1, idGejala2, idGejala3, idGejala4, idGejala5, idGejala6);

        if (penyakitId == null) {
            JOptionPane.showMessageDialog(null, "Tidak ditemukan penyakit berdasarkan gejala yang dipilih.", "Hasil Diagnosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Ambil nama penyakit dari database berdasarkan ID
            String namaPenyakit = getNamaPenyakitById(penyakitId);

            // Tampilkan informasi diagnosa
            StringBuilder gejalaTerpilih = new StringBuilder();
            if (idGejala1 != null) gejalaTerpilih.append("- ").append(namaGejala1).append("\n");
            if (idGejala2 != null) gejalaTerpilih.append("- ").append(namaGejala2).append("\n");
            if (idGejala3 != null) gejalaTerpilih.append("- ").append(namaGejala3).append("\n");
            if (idGejala4 != null) gejalaTerpilih.append("- ").append(namaGejala4).append("\n");
            if (idGejala5 != null) gejalaTerpilih.append("- ").append(namaGejala5).append("\n");
            if (idGejala6 != null) gejalaTerpilih.append("- ").append(namaGejala6).append("\n");

            String message = String.format(
                "Diagnosa berhasil!\n\nNama Pasien: %s\n\nGejala yang dipilih:\n%s\nNama Penyakit: %s",
                namaPasien,
                gejalaTerpilih.toString(),
                namaPenyakit
            );
            JOptionPane.showMessageDialog(null, message, "Hasil Diagnosa", JOptionPane.INFORMATION_MESSAGE);

            // Tampilkan hasil di tampilan
            /**pasien_pilih.setText(namaPasien); // Field untuk nama pasien
            hasilpenyakit.setText(namaPenyakit); // Field untuk hasil diagnosa penyakit
            if (idGejala1 != null) hasil1.setText(namaGejala1);
            if (idGejala2 != null) hasil2.setText(namaGejala2);
            if (idGejala3 != null) hasil3.setText(namaGejala3);
            if (idGejala4 != null) hasil4.setText(namaGejala4);
            if (idGejala5 != null) hasil5.setText(namaGejala5);
            if (idGejala6 != null) hasil6.setText(namaGejala6);**/

            // Simpan ke riwayat diagnosa
            saveRiwayatDiagnosa(pasienId, idGejala1, idGejala2, idGejala3, idGejala4, idGejala5, idGejala6, penyakitId);
            datatable();
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam proses diagnosa! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btn_diagnosaActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
    // TODO add your handling code here:
    Object[] Baris = {"ID", "Nama Pasien", "Tanggal Diagnosa", "Riwayat Penyakit", "Definisi", "Solusi"};
    tabmode = new DefaultTableModel(null, Baris);
    tbldiagnosa.setModel(tabmode);

    // Validasi input pencarian
    String keyword = tcari.getText().trim();
    if (keyword.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Masukkan nama pasien untuk mencari!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    return;
    }

    // Query untuk mencari data berdasarkan nama pasien
    String sql = "SELECT rd.id_diagnosa, p.nama_pasien, rd.tanggal_diagnosa, py.nama_penyakit, py.definisi, py.solusi " +
             "FROM riwayat_diagnosa rd " +
             "JOIN pasien p ON rd.pasien_id = p.pasien_id " +
             "JOIN penyakit py ON rd.penyakit_id = py.penyakit_id " +
             "WHERE p.nama_pasien LIKE ? " +
             "ORDER BY rd.id_diagnosa ASC";

    try {
    PreparedStatement stat = conn.prepareStatement(sql);
    stat.setString(1, keyword + "%"); // Gunakan wildcard untuk mencocokkan huruf depan
    ResultSet hasil = stat.executeQuery();

    boolean dataDitemukan = false;
    while (hasil.next()) {
        dataDitemukan = true;
        String a = hasil.getString("id_diagnosa");
        String b = hasil.getString("nama_pasien");
        String c = hasil.getString("tanggal_diagnosa");
        String d = hasil.getString("nama_penyakit");
        String e = hasil.getString("definisi");
        String f = hasil.getString("solusi");
        
        String[] data = {a, b, c, d, e, f};
        tabmode.addRow(data);
    }

    // Jika tidak ada data ditemukan
    if (!dataDitemukan) {
        JOptionPane.showMessageDialog(null, "Data riwayat diagnosa tidak ditemukan!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
    }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btncariActionPerformed

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
            java.util.logging.Logger.getLogger(diagnosis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(diagnosis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(diagnosis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(diagnosis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new diagnosis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_diagnosa;
    private javax.swing.JButton btncari;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
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
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> list_pasien;
    private javax.swing.JTable tbldiagnosa;
    private javax.swing.JTextField tcari;
    // End of variables declaration//GEN-END:variables
}
