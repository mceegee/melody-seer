/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carbonell.melodyseer.models;

import java.io.IOException;

/**
 *
 * @author marta
 */
public class MyFileMimeModel {

    MyFile file;

    public MyFileMimeModel(MyFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        try {
        return file.getMime() + ": " + file.getFileName().substring(0,20);
        } catch (IOException ioe) {
            System.out.println("Something went wrong with MIME type :(");
        }
        return "";
    }

}
