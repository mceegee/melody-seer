/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carbonell.melodyseer;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author marta
 */
public class LogIn extends JPanel {

    private javax.swing.JTextField txtUser;
    private javax.swing.JPasswordField pwdPwd; // https://stackoverflow.com/questions/19755259/hide-show-password-in-a-jtextfield-java-swing 
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblPwd;
    private javax.swing.JCheckBox chkRememberMe;
    private javax.swing.JLabel lblRememberMe;
    private javax.swing.JButton btnLogIn;

    private Main jFrameMain;

    public LogIn(Main jFrameMain) {
        initComponents();
        this.jFrameMain = jFrameMain;
    }

    private void initComponents() {
        txtUser = new javax.swing.JTextField();
        pwdPwd = new javax.swing.JPasswordField();
        lblUser = new javax.swing.JLabel();
        lblPwd = new javax.swing.JLabel();
        chkRememberMe = new javax.swing.JCheckBox();
        lblRememberMe = new javax.swing.JLabel();
        btnLogIn = new javax.swing.JButton();

        MigLayout layout = new MigLayout(
                "wrap 2, align center center", 
                "[right][fill]",
                "[]10[]10[]10[]20[]"
        );
        setLayout(layout);

        lblUser.setText("Username:");
        //lblUser.setBounds(250, 60, 70, 50);
        add(lblUser);

        //txtUser.setBounds(350, 60, 150, 30);
        add(txtUser);

        //lblPwd.setBounds(250, 150, 70, 50);
        lblPwd.setText("Password:");
        add(lblPwd);

        //pwdPwd.setBounds(350, 150, 150, 30);
        add(pwdPwd);

        //chkRememberMe.setBounds(250, 220, 20, 20);
        add(chkRememberMe);

        //lblRememberMe.setBounds(280, 220, 250, 30);
        lblRememberMe.setText("Remember username and password");
        add(lblRememberMe);

        //btnLogIn.setBounds(410, 250, 75, 40);
        btnLogIn.setText("Log in");
        add(btnLogIn, "span 2, center");

        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnLogInActionPerformed(evt);
                } catch (Exception ex) {
                    System.getLogger(LogIn.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            }
        });

    }

    public void btnLogInActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
        String username = txtUser.getText();
        String pwd = new String(pwdPwd.getPassword());
        String token = null;

        if (username == null || username.isEmpty() || pwd.isEmpty()) {
            throw new IllegalArgumentException("Username or password empty.");
        } else {
            try {
                token = jFrameMain.getMsComponent().loginToApi(username, pwd);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Something went wrong :(", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (token != null && !token.isEmpty()) {
            if (chkRememberMe.isSelected()) {
                jFrameMain.getPersistentData().setSavedToken(token);
                jFrameMain.savePersistentData();
            }
            this.setVisible(false);
            jFrameMain.showDownloadPanel();

        }

    }

}
