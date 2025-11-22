/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carbonell.melodyseer.utilities;

import com.carbonell.melodyseer.models.MyFile;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author marta
 */
public class PersistentData implements Serializable{
    
    private String savedToken = null;
    private ArrayList<MyFile> files;

    public String getSavedToken() {
        return savedToken;
    }

    public void setSavedToken(String savedToken) {
        this.savedToken = savedToken;
    }

    public ArrayList<MyFile> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<MyFile> files) {
        this.files = files;
    }

    
}
