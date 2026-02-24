/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carbonell.melodyseer.models;

import com.carbonell.melody.seer.component.api.Media;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.io.Serializable;

/**
 * Class <code>MyFile</code> manages the information related to the files (local) and media (DB) generated after upload / download. 
 * @author marta
 */
public class MyFile implements Serializable {

    private File file;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate downloadDate; 
    private String downloadedFrom;
    @JsonIgnore
    private Media media;

    /**
     * Constructor for local files
     * @param file <code>File</code> 
     * @param downloadedFrom URL for the original website
     */
    public MyFile(File file, String downloadedFrom) {
        this.file = file;
        this.downloadedFrom = downloadedFrom;
        downloadDate = LocalDate.now();
    }

    /**
     * Constructor for DB files
     * @param media <code>Media</code>
     */
    public MyFile(Media media) {
        this.media = media;
    }
    
    /**
     * No params constructor
     */
    public MyFile() {
        
    }

    @Override
    public String toString() {
        return file.getName();
    }

    public String getFileName() {
        if (file == null) {
            return media.mediaFileName;
        }
        return file.getName();
    }

    public long getSize() {
        if (file == null) {
            return 0;
        }
        return file.length();
    }

    public String getMime() throws IOException {
        if (file == null) {
            return media.mediaMimeType;
        }
        return Files.probeContentType(file.toPath());
    }

    public void setDownloadDate(LocalDate downloadDate) {
        this.downloadDate = downloadDate;
    }

    public LocalDate getDownloadDate() {
        // https://jenkov.com/tutorials/java-internationalization/simpledateformat.html
        
        return downloadDate;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }   

    public String getDownloadedFrom() {
        return downloadedFrom;
    }

    public void setDownloadedFrom(String downloadedFrom) {
        this.downloadedFrom = downloadedFrom;
    }

    /**
     * Deletes a file from computer
     */
    public void delete() {
        if (file == null) {
            return;
        }
        file.delete();
    }

    /**
     * Checks if a file can be uploaded to a DB 
     * To do so, checks that file is found on local machine and that it's not already on the DB
     * @return bool
     */
    public boolean canBeUploaded() {
        return file != null && file.exists() && media == null;
    }

    /**
     * Checks if a file can be downloaded from a DB 
     * To do so, checks that file is not found on local machine and that it's not part of the DB
     * @return bool
     */
    public boolean canBeDownloaded() {
        return media != null && (file == null || !file.exists());
    }
}
