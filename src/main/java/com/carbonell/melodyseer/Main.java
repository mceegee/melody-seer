/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.carbonell.melodyseer;

import com.carbonell.melody.seer.component.MelodySeerComponent;
import com.carbonell.melodyseer.utilities.PersistentData;
import com.carbonell.melodyseer.models.MyFile;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.carbonell.melodyseer.utilities.FileManager;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author marta
 */
public class Main extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Main.class.getName());

    private String ytdlp_path = System.getProperty("user.home") + "\\yt-dlp\\yt-dlp.exe";
    private String saveToPath = System.getenv("APPDATA");
    private String saveToPathTemp = saveToPath;
    private String downloadedMediaInfoPath = System.getenv("APPDATA") + "\\" + "metadata.json";
    private String lastSavedFile;
    private String selectedSpeed = "";
    private ArrayList<MyFile> myFiles;
    private PersistentData persistentData;
    private String format = "mp4";

    private DownloadPanel downloadPanel;
    private PreferencesPanel preferencesPanel;
    private MediaPanel mediaPanel;
    private LogIn logInPanel;

    private javax.swing.JMenuItem mniLogout;
    
    private CardLayout cl;

    /**
     * Creates new form Main
     */
    public Main() {

        persistentData = FileManager.readFile(downloadedMediaInfoPath);
        myFiles = persistentData.getFiles();

        if (myFiles == null) {
            myFiles = new ArrayList<>();
            persistentData.setFiles(myFiles);
        }

        boolean isLoggedIn = persistentData.getSavedToken() != null;

        initComponents();
        setSize(800, 800);
        setLocationRelativeTo(null);
        cl = new CardLayout();
        pnlContent.setLayout(cl);
        

        mniLogout = new javax.swing.JMenuItem();
        mniLogout.setText("Log out");
        mniLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLogoutActionPerformed(evt);
            }
        });
        mnuFile.add(mniLogout);

        downloadPanel = new DownloadPanel(this);
        pnlContent.add(downloadPanel, "downloadPanel");

        preferencesPanel = new PreferencesPanel(this);
        pnlContent.add(preferencesPanel, "preferencesPanel");

        mediaPanel = new MediaPanel(this);
        pnlContent.add(mediaPanel, "mediaPanel");

        logInPanel = new LogIn(this);
        pnlContent.add(logInPanel, "loginPanel");

        if (!isLoggedIn) {
            showLogInPanel();
        } else {
            msComponent.setToken(persistentData.getSavedToken());
            showDownloadPanel();
        }

    }

    public ArrayList<MyFile> getMyFiles() {
        return myFiles;
    }

    public void addNewFile(MyFile file) {
        myFiles.add(file);

        savePersistentData();

        mediaPanel.refreshModel();
    }

    public void savePersistentData() {
        FileManager.writeFile(persistentData, downloadedMediaInfoPath);
    }

    public void deleteFile(int i) {
        myFiles.remove(i);
    }

    public String getYtdlp_path() {
        return ytdlp_path;
    }

    public void setYtdlp_path(String ytdlp_path) {
        this.ytdlp_path = ytdlp_path;
    }

    public String getSaveToPath() {
        return saveToPath;
    }

    public void setSaveToPath(String saveToPath) {
        this.saveToPath = saveToPath;
    }

    public void setSaveToPathTemp(String saveToPathTemp) {
        this.saveToPathTemp = saveToPathTemp;
    }

    public String getSaveToPathTemp() {
        return saveToPathTemp;
    }

    public String getSelectedSpeed() {
        return selectedSpeed;
    }

    public void setSelectedSpeed(String selectedSpeed) {
        this.selectedSpeed = selectedSpeed;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public PersistentData getPersistentData() {
        return persistentData;
    }

    public void showPreferencesPanel() {
        //downloadPanel.setVisible(false);
        //mediaPanel.setVisible(false);
        //preferencesPanel.setVisible(true);
        cl.show(pnlContent, "preferencesPanel");
    }

    public void showDownloadPanel() {
        //downloadPanel.setVisible(true);
        //preferencesPanel.setVisible(false);
        //mediaPanel.setVisible(false);
        cl.show(pnlContent, "downloadPanel");
    }

    public void showMediaPanel() {
        //downloadPanel.setVisible(false);
        //preferencesPanel.setVisible(false);
        //mediaPanel.setVisible(true);
        cl.show(pnlContent, "mediaPanel");
    }

    public void showLogInPanel() {
//        downloadPanel.setVisible(false);
//        preferencesPanel.setVisible(false);
//        mediaPanel.setVisible(false);
//        logInPanel.setVisible(true);
        cl.show(pnlContent, "loginPanel");
    }

    public MelodySeerComponent getMsComponent() {
        return msComponent;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        msComponent = new com.carbonell.melody.seer.component.MelodySeerComponent();
        pnlContent = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mniExit = new javax.swing.JMenuItem();
        mnuEdit = new javax.swing.JMenu();
        mniPreferences = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        mniAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Melody Seer");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(800, 800));
        setName("MainFrame"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(800, 800));
        getContentPane().setLayout(null);

        msComponent.setApiUrl("https://difreenet9.azurewebsites.net");
        getContentPane().add(msComponent);
        msComponent.setBounds(710, 700, 16, 16);

        pnlContent.setLayout(null);
        getContentPane().add(pnlContent);
        pnlContent.setBounds(0, 0, 800, 800);

        mnuFile.setText("File");
        mnuFile.setName("file"); // NOI18N

        mniExit.setText("Exit");
        mniExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniExitActionPerformed(evt);
            }
        });
        mnuFile.add(mniExit);

        jMenuBar1.add(mnuFile);

        mnuEdit.setText("Edit");
        mnuEdit.setName("edit"); // NOI18N

        mniPreferences.setText("Preferences");
        mniPreferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPreferencesActionPerformed(evt);
            }
        });
        mnuEdit.add(mniPreferences);

        jMenuBar1.add(mnuEdit);

        mnuHelp.setText("Help");
        mnuHelp.setName("help"); // NOI18N

        mniAbout.setText("About");
        mniAbout.setToolTipText("");
        mniAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAboutActionPerformed(evt);
            }
        });
        mnuHelp.add(mniAbout);

        jMenuBar1.add(mnuHelp);
        mnuHelp.getAccessibleContext().setAccessibleDescription("");

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // FILE - EXIT
    // https://stackoverflow.com/questions/33017359/how-to-make-window-close-on-clicking-exit-menuitem
    private void mniExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniExitActionPerformed
        JOptionPane.showMessageDialog(null, "Closing Melody Seer...");
        System.exit(NORMAL);
    }//GEN-LAST:event_mniExitActionPerformed

    // FILE - LOG OUT
    private void mniLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        persistentData.setSavedToken(null);
        savePersistentData();
        showLogInPanel();
    }

    // EDIT - PREFERENCES
    private void mniPreferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPreferencesActionPerformed
//        Preferences openPreferences = new Preferences((file) -> onDownloadedFile(file));
//        openPreferences.setVisible(true);
        showPreferencesPanel();
    }//GEN-LAST:event_mniPreferencesActionPerformed

    // HELP - ABOUT
    private void mniAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAboutActionPerformed
        About openAbout = new About(this, true);
        openAbout.setVisible(true);
    }//GEN-LAST:event_mniAboutActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Main().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mniAbout;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniPreferences;
    private javax.swing.JMenu mnuEdit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuHelp;
    private com.carbonell.melody.seer.component.MelodySeerComponent msComponent;
    private javax.swing.JPanel pnlContent;
    // End of variables declaration//GEN-END:variables
}
