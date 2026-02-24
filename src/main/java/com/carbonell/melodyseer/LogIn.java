/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carbonell.melodyseer;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 * Class to deal with the Log In process 
 * 
 * @author marta
 */
public class LogIn extends JPanel {

    private JTextField txtUser;
    private JPasswordField pwdPwd; // https://stackoverflow.com/questions/19755259/hide-show-password-in-a-jtextfield-java-swing 
    private JLabel lblUser;
    private JLabel lblPwd;
    private JCheckBox chkRememberMe;
    private JLabel lblRememberMe;
    private JButton btnLogIn;
    private JLabel lblErrorMessage;

    private Main jFrameMain;
/**
 * Constructor, initiates components and sets information from Main
 * 
 * @param jFrameMain object from <code>Main</code> class where variables use throughout the app are stored
 */
    public LogIn(Main jFrameMain) {
        initComponents();
        this.jFrameMain = jFrameMain;
    }

    /**
     * Initializes components
     * Adds them to a <code>MigLayout</code>
     * Adds listener to login button
     * Includes <code>KeyListener</code> which makes sure that login button is disabled until both username and password textfields have text on them
     * 
     */
    private void initComponents() {
        txtUser = new JTextField();
        pwdPwd = new JPasswordField();
        lblUser = new JLabel();
        lblPwd = new JLabel();
        chkRememberMe = new JCheckBox();
        lblRememberMe = new JLabel();
        btnLogIn = new JButton();
        lblErrorMessage = new JLabel();

        MigLayout layout = new MigLayout(
                "wrap 2, align center top",
                "[right][fill]",
                "[]10[]10[]10[]10[]20[]"
        );
        setLayout(layout);
        lblErrorMessage.setText("Username and password do not match. Try again.");
        lblErrorMessage.setForeground(Color.RED);
        add(lblErrorMessage, "span 2, center");
        lblErrorMessage.setVisible(false);

        lblUser.setText("Username:");
        add(lblUser);

        add(txtUser);

        lblPwd.setText("Password:");
        add(lblPwd);

        add(pwdPwd);

        add(chkRememberMe);

        lblRememberMe.setText("Remember username and password");
        add(lblRememberMe);

        btnLogIn.setText("Log in");
        add(btnLogIn, "span 2, center");
        btnLogIn.setEnabled(false);

        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnLogInActionPerformed(evt);
                } catch (Exception ex) {
                    System.getLogger(LogIn.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            }
        });

        KeyAdapter keyListener = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (txtUser.getText().isEmpty() || pwdPwd.getPassword().length == 0) {
                    btnLogIn.setEnabled(false);
                } else {
                    btnLogIn.setEnabled(true);
                }
            }
        };

        txtUser.addKeyListener(keyListener);
        pwdPwd.addKeyListener(keyListener);

    }
/**
 * Log in user by calling component and sending information on username and pwd textfields
 * If a valid token is returned, and user has selected the corresponding checkbox, token is saved to metadata document
 * If log in is successful, Download Panel is shown
 * If not, message error is shown
 * 
 * @param evt click on Login button
 * @throws Exception in case username / password combination is not correct
 */
    public void btnLogInActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
        String username = txtUser.getText();
        String pwd = new String(pwdPwd.getPassword());
        String token = null;

        if (username == null || username.isEmpty() || pwd.isEmpty()) {
            lblErrorMessage.setVisible(true);
            throw new IllegalArgumentException("Username or password empty.");
        } else {
            try {
                token = jFrameMain.getMsComponent().loginToApi(username, pwd);
            } catch (Exception e) {
                lblErrorMessage.setVisible(true);
            }
        }
        if (token != null && !token.isEmpty()) {
            if (chkRememberMe.isSelected()) {
                jFrameMain.getPersistentData().setSavedToken(token);
                jFrameMain.savePersistentData();
            }
            this.setVisible(false);
            lblErrorMessage.setVisible(false);
            jFrameMain.showDownloadPanel();
        } else {
            lblErrorMessage.setVisible(true);
        }

    }

}
