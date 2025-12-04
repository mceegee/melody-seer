/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wrapperTemp;

// https://stackoverflow.com/questions/1736234/what-is-meant-by-implement-a-wrapper-method 
import com.carbonell.melodyseer.utilities.ApiClient;
import com.carbonell.melodyseer.utilities.Media;
import com.carbonell.melodyseer.utilities.ServerConfig;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author marta
 */
public class WrapperApiClient extends JPanel implements Serializable, ActionListener {

    private ApiClient apiClient;
    private ServerConfig serverPollingConfig;

    private Timer timer;
    private javax.swing.JLabel lblIcon;

    public WrapperApiClient() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        lblIcon = new javax.swing.JLabel();
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/yt.png")));
        add(lblIcon, BorderLayout.CENTER); // https://stackoverflow.com/questions/5604188/how-to-make-java-swing-components-fill-available-space

        timer = new Timer(serverPollingConfig.getPollingInterval(), this);
    }

    public void loginToApi(String user, String pw) throws Exception {
        String apiUrl = serverPollingConfig.getApiUrl();
        if (apiUrl != null && !apiUrl.isEmpty()) {
            serverPollingConfig.setToken(apiClient.login(user, pw));
        }
    }

    public String getNickName(int id) throws Exception {
        String apiUrl = serverPollingConfig.getApiUrl();
        if (apiUrl != null && !apiUrl.isEmpty()) {
            return apiClient.getNickName(id, serverPollingConfig.getToken());
        }
        return null;
    }

    public List<Media> getAllMedia() throws Exception {
        String apiUrl = serverPollingConfig.getApiUrl();
        if (apiUrl != null && !apiUrl.isEmpty()) {
            return apiClient.getAllMedia(serverPollingConfig.getToken());
        }
        return null;
    }

    public void downloadMedia(int id, File destFile) throws Exception {
        String apiUrl = serverPollingConfig.getApiUrl();
        if (apiUrl != null && !apiUrl.isEmpty()) {
            apiClient.download(id, destFile, serverPollingConfig.getToken());
        }
    }

    public String uploadFileMultipart(File file, String downloadedFromUrl) throws Exception {
        String apiUrl = serverPollingConfig.getApiUrl();
        if (apiUrl != null && !apiUrl.isEmpty()) {
            return apiClient.uploadFileMultipart(file, downloadedFromUrl, serverPollingConfig.getToken());
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}
