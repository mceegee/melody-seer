/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wrapperTemp;

// https://stackoverflow.com/questions/1736234/what-is-meant-by-implement-a-wrapper-method 
import com.carbonell.melodyseer.utilities.ApiClient;
import com.carbonell.melodyseer.utilities.Media;
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author marta
 */
public class WrapperApiClient extends JPanel implements Serializable {

    private String apiUrl;
    private boolean isRunning;
    private int pollingInterval;
    private String token;
    private String lastChecked;

    private ApiClient apiClient;

    private javax.swing.JLabel lblIcon;

    public WrapperApiClient() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        lblIcon = new javax.swing.JLabel();
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/yt.png")));
        add(lblIcon, BorderLayout.CENTER); // https://stackoverflow.com/questions/5604188/how-to-make-java-swing-components-fill-available-space
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
        apiClient = new ApiClient(apiUrl);
    }

    public boolean isIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public int getPollingInterval() {
        return pollingInterval;
    }

    public void setPollingInterval(int pollingInterval) {
        this.pollingInterval = pollingInterval;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(String lastChecked) {
        this.lastChecked = lastChecked;
    }

    public void loginToApi(String user, String pw) throws Exception {
        if (apiUrl != null && !apiUrl.isEmpty()) {
            token = apiClient.login(user, pw);
        }
    }

    public String getNickName(int id) throws Exception {
        if (apiUrl != null && !apiUrl.isEmpty()) {
            return apiClient.getNickName(id, token);
        }
        return null;
    }

    public List<Media> getAllMedia() throws Exception {
        if (apiUrl != null && !apiUrl.isEmpty()) {
            return apiClient.getAllMedia(token);
        }
        return null;
    }

    public void downloadMedia(int id, File destFile) throws Exception {
        if (apiUrl != null && !apiUrl.isEmpty()) {
            apiClient.download(id, destFile, token);
        }
    }

    public String uploadFileMultipart(File file, String downloadedFromUrl) throws Exception {
        if (apiUrl != null && !apiUrl.isEmpty()) {
            return apiClient.uploadFileMultipart(file, downloadedFromUrl, token);
        }
        return null;
    }

}
