/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;
import java.sql.*;

/**
 *
 * @author ASANI
 */

public class koneksi {

    public static Connection getKoneksi() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private Connection koneksi;

    // Constructor or method to establish connection
    public Connection connect() {
        // Loading the MySQL JDBC Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Berhasil Koneksi Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Gagal Koneksi Driver: " + ex);
        }

        // Setting up the connection URL
        String url = "jdbc:mysql://localhost/db_stomachguard";
        try {
            // Establishing the connection
            koneksi = DriverManager.getConnection(url, "root", "");  // Add password if needed
            System.out.println("Berhasil Koneksi Database");
        } catch (SQLException ex) {
            System.out.println("Gagal Koneksi Database: " + ex);
        }

        return koneksi;
    }
}

