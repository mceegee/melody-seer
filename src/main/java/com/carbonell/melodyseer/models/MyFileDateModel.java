/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carbonell.melodyseer.models;

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
        return file.getDownloadDate() + ": " + file.getFileName().substring(0,20);
    }
    
    
    
}
