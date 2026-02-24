/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.carbonell.melodyseer;

import com.carbonell.melody.seer.component.MelodySeerComponent;
import com.carbonell.melodyseer.utilities.PersistentData;
import com.carbonell.melodyseer.models.MyFile;
import java.util.ArrayList;
import com.carbonell.melodyseer.utilities.FileManager;
import java.awt.CardLayout;

/**
 * Class that manages the different views for our app
 * It also includes any variable that has to be used across the different windows
 * Objects from this main class will be instantiated on different views from our app to do so
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

    private LogIn logInPanel;

    private javax.swing.JMenuItem mniLogout;
    private javax.swing.JMenuItem mniExit;

    private CardLayout cl;

    /**
     * Constructor: Creates new form Main
     * It first checks if there's any metadata saved
     * Has a Panel with <code>CardLayout</code> and deals with initial view of subpanels
     * 
     * Creation and methods for Logout and Exit Menu Items
     */
    public Main() {

        persistentData = FileManager.readFile(downloadedMediaInfoPath);
        myFiles = persistentData.getFiles();

        if (myFiles == null) {
            myFiles = new ArrayList<>();
            persistentData.setFiles(myFiles);
        }
        
        cleanLocalFiles();
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

        mniExit = new javax.swing.JMenuItem();
        mniExit.setText("Exit");
        mniExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniExitActionPerformed(evt);
            }
        });
        mnuFile.add(mniExit);

        downloadPanel = new DownloadPanel(this);
        pnlContent.add(downloadPanel, "downloadPanel");

        preferencesPanel = new PreferencesPanel(this);
        pnlContent.add(preferencesPanel, "preferencesPanel");

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

    /**
     * Adds a new <code>MyFile</code> item to the variable with local files
     * Checks that the information on saved items is up to date. 
     * Saves the information to a json metadata document
     * Refreshes the information
     * 
     * @param file <code>MyFile</code>
     */
    public void addNewFile(MyFile file) {
        myFiles.add(file);
        cleanLocalFiles();
        savePersistentData();

        downloadPanel.refreshFiles();
    }
    
    /**
     * Checks that local file information is up to date. If not, deletes any mismatched item. 
     */
    private void cleanLocalFiles() {
        ArrayList<MyFile> missingFiles = new ArrayList<>();
        for(MyFile file: myFiles){
            if(!file.canBeUploaded()){
                missingFiles.add(file);
            }
        }
        myFiles.removeAll(missingFiles);
    }

    /**
     * Creates a metadata document with persistent information on a given path
     */
    public void savePersistentData() {
        FileManager.writeFile(persistentData, downloadedMediaInfoPath);
    }

    /**
     * Deletes a given file
     * @param i row of the file to be deleted
     */
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

    /**
     * Changes view to Preferences Panel
     */    
    public void showPreferencesPanel() {
        cl.show(pnlContent, "preferencesPanel");
    }

    /**
    * Changes view to Download Panel
    */
    public void showDownloadPanel() {
        cl.show(pnlContent, "downloadPanel");
    }

    /**
     * Changes view to LogIn Panel
     */
    public void showLogInPanel() {
        cl.show(pnlContent, "loginPanel");
    }

    /**
     * 
     * @return <code>MelodySeerComponent</code> the component for the different interactions with the API
     */
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

    /**
     * Cleans token information to logout, updates metadata information and goes back to login panel
     * 
     * @param evt Click on menu item Logout
     */
    private void mniLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        persistentData.setSavedToken(null);
        savePersistentData();
        showLogInPanel();
    }

    /**
     * Closes the application
     * @param evt click on menu item Exit
     */
    // https://stackoverflow.com/questions/33017359/how-to-make-window-close-on-clicking-exit-menuitem
    private void mniExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniExitActionPerformed
        System.exit(NORMAL);
    }//GEN-LAST:event_mniExitActionPerformed

    /**
     * Shows preferences panel 
     * @param evt click on menu item Preferences
     */
    private void mniPreferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPreferencesActionPerformed

        showPreferencesPanel();
    }//GEN-LAST:event_mniPreferencesActionPerformed

    /**
     * Shows about <code>JDialog</code>
     * @param evt click on menu item About
     */
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
    private javax.swing.JMenuItem mniPreferences;
    private javax.swing.JMenu mnuEdit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuHelp;
    private com.carbonell.melody.seer.component.MelodySeerComponent msComponent;
    private javax.swing.JPanel pnlContent;
    // End of variables declaration//GEN-END:variables

}
