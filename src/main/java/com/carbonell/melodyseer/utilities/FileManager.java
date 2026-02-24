/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carbonell.melodyseer.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import tools.jackson.databind.ObjectMapper;

/**
 * Class to read and write <code>PersistentData</code>
 * 
 * @author marta
 */
// https://www.geeksforgeeks.org/java/serialization-and-deserialization-in-java/ 
public class FileManager {

    /**
     * Reads metadata about files that have been downloaded to computer to a certain path
     * Where metadata has been saved to
     * 
     * @param path Path of the file we're trying to read
     * @return newFile, a <code>PersistentData</code> object 
     */
    public static PersistentData readFile(String path) {
        try {
            ObjectMapper om = new ObjectMapper();
            
            PersistentData newFile = om.readValue(new BufferedReader(new FileReader(path)), PersistentData.class);
            return newFile;
        } catch (IOException e) {
            System.out.println("There was a problem loading the file.");
        }
        return new PersistentData();
    }

    /**
     * Writes metadata information about files that have been downloaded to computer to a given path
     * 
     * @param myFile a <code>PersistentData</code> object
     * @param path to where the file is going to be written into
     */
    public static void writeFile(PersistentData myFile, String path) {
        try {
            ObjectMapper om = new ObjectMapper();
            om.writeValue(new BufferedWriter(new FileWriter(path)), myFile);
        } catch (IOException ioe) {
            System.out.println("File cannot be saved");
        }
    }

}
