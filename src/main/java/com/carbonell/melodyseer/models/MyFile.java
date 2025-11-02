/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carbonell.melodyseer.models;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author marta
 */
public class MyFile {
    private File file;
    private LocalDate downloadDate;
    
    public MyFile(File file)
    {
        this.file = file;
        downloadDate = LocalDate.now();
    }
    
    
    @Override
    public String toString() {
    return file.getName();
}

    public String getFileName() {
        return file.getName();
    }


    public long getSize() {
        return file.length();
    }


    public String getMime() throws IOException {
        return Files.probeContentType(file.toPath());
    }


    public String getDownloadDate() {
        // https://jenkov.com/tutorials/java-internationalization/simpledateformat.html
        return downloadDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }   
    
}
