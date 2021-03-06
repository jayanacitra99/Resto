
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jayana Citra
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btSignUp = new javax.swing.JButton();
        btExit = new javax.swing.JButton();
        btSignIn = new javax.swing.JButton();
        Username = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USERNAME");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 40, 100, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PASSWORD");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 120, 100, 30);

        btSignUp.setText("Sign Up");
        btSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSignUpActionPerformed(evt);
            }
        });
        getContentPane().add(btSignUp);
        btSignUp.setBounds(20, 210, 90, 30);

        btExit.setText("Exit");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });
        getContentPane().add(btExit);
        btExit.setBounds(150, 210, 90, 30);

        btSignIn.setText("Sign In");
        btSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSignInActionPerformed(evt);
            }
        });
        getContentPane().add(btSignIn);
        btSignIn.setBounds(280, 210, 90, 30);
        getContentPane().add(Username);
        Username.setBounds(90, 80, 220, 30);

        Password.setText("jPasswordField1");
        getContentPane().add(Password);
        Password.setBounds(90, 150, 220, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon("D:\\New folder\\Big-Moon-Wallpaper-Water-Reflection-Picture-Desktop-Image.jpg")); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-50, -40, 520, 370);

        setBounds(0, 0, 416, 308);
    }// </editor-fold>//GEN-END:initComponents

    private void btSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSignUpActionPerformed
        // TODO add your handling code here:
        String username = Username.getText();
        String password = Password.getText();

        try {
            try (Statement statement = (Statement) file_koneksi.GetConnection().createStatement()){
                statement.executeUpdate("insert into tb_akun(username, password) VALUES ('"+username+"','"+password+"');");
            }
            JOptionPane.showMessageDialog(null, "Selamat! anda berhasil Sign Up!");
        } catch (Exception t) {
            JOptionPane.showMessageDialog(null, "Mohon maaf, ulangi kembali prosedur");
        }
    }//GEN-LAST:event_btSignUpActionPerformed

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btExitActionPerformed

    private void btSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSignInActionPerformed
        // TODO add your handling code here:
        Connection connection;
        PreparedStatement ps;

        try {
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_resto?zeroDateTimeBehavior=convertToNull","root", "");
            ps = connection.prepareStatement("SELECT * FROM `tb_akun` WHERE `username` = ? AND `password` = ?");
            ps.setString(1, Username.getText());
            ps.setString(2, Password.getText());
            ResultSet result = ps.executeQuery();
            if(result.next()){
                new Welcome().show();
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Salah!");
                Password.setText("");
                Username.requestFocus();
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "gagal");
        }
    }//GEN-LAST:event_btSignInActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField Username;
    private javax.swing.JButton btExit;
    private javax.swing.JButton btSignIn;
    private javax.swing.JButton btSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
