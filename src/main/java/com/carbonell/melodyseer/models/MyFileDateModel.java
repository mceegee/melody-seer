/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carbonell.melodyseer.models;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author marta
 */
public class MyFileDateModel {
   
    MyFile file;
    
    public MyFileDateModel(MyFile file){
        this.file = file;
    }

    @Override
    public String toString() {
        return file.getDownloadDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
    
    
    
}
