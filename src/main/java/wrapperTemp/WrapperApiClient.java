/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wrapperTemp;

// https://stackoverflow.com/questions/1736234/what-is-meant-by-implement-a-wrapper-method 
import com.carbonell.melodyseer.utilities.ApiClient;
import com.carbonell.melodyseer.utilities.Media;
import com.carbonell.melodyseer.utilities.NewMedia;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.swing.JPanel;
import javax.swing.Timer;
import com.carbonell.melodyseer.utilities.OnNewMediaAddedListener;
import java.util.ArrayList;

/**
 *
 * @author marta
 */
public class WrapperApiClient extends JPanel implements Serializable, ActionListener {

    private ApiClient apiClient;
    
    private String apiUrl;
    private boolean isRunning;
    private int pollingInterval = 1000;
    private String token;
    private String lastChecked;

    private Timer timer;
    private javax.swing.JLabel lblIcon;

    private List<OnNewMediaAddedListener> myListeners;

    public WrapperApiClient() {
        initComponents();
        myListeners = new ArrayList<>();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        lblIcon = new javax.swing.JLabel();
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/yt.png")));
        add(lblIcon, BorderLayout.CENTER); // https://stackoverflow.com/questions/5604188/how-to-make-java-swing-components-fill-available-space

        timer = new Timer(pollingInterval, this);
        timer.start();
        lastChecked = getNowAsIsoString();
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
    
    public String uploadFileMultipart(File file, String downloadedFromUrl) throws Exception {
        if (apiUrl != null && !apiUrl.isEmpty()) {
            return apiClient.uploadFileMultipart(file, downloadedFromUrl, token);
        }
        return null;
    }
    
    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public boolean isIsRunning() {
        return isRunning;
    }

    public int getPollingInterval() {
        return pollingInterval;
    }

    public void setPollingInterval(int pollingInterval) {
        this.pollingInterval = pollingInterval;
    }

    public String getLastChecked() {
        return lastChecked;
    }

    // UNNECESSARY for polling
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

    public List<NewMedia> getMediaSinceLastChecked() throws Exception {
        System.out.println("Holis");
        List<NewMedia> newMedia = new ArrayList<>();
        String timeNowISO = getNowAsIsoString();
        if (apiUrl != null && !apiUrl.isEmpty()) {
            // crear una lista de objetos que contienen media y DateTime
            List<Media> discoveredMedia = apiClient.getMediaAddedSince(lastChecked, token);
            for(Media media : discoveredMedia ) {
                newMedia.add(new NewMedia(media, timeNowISO));
            }           
        }
        lastChecked = timeNowISO;
        return newMedia;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!this.isShowing()) return;
        try {
            List<NewMedia> newMedia = getMediaSinceLastChecked();
            
            
            for(OnNewMediaAddedListener listener: myListeners){
                listener.newMediaAdded(newMedia);
            }
        } catch (Exception ex) {

        }
    }
    
    public void addNewMediaListener(OnNewMediaAddedListener listener){
        myListeners.add(listener);
    }

    // https://stackoverflow.com/questions/3914404/how-to-get-current-moment-in-iso-8601-format-with-date-hour-and-minute
    private String getNowAsIsoString() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());
        return nowAsISO;
    }

}
