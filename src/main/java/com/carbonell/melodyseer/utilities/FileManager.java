/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carbonell.melodyseer.utilities;

import com.carbonell.melodyseer.models.MyFile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import tools.jackson.databind.ObjectMapper;

/**
 *
 * @author marta
 */
// https://www.geeksforgeeks.org/java/serialization-and-deserialization-in-java/ 
public class FileManager {

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

    public static void writeFile(PersistentData myFile, String path) {
        try {
            ObjectMapper om = new ObjectMapper();
            om.writeValue(new BufferedWriter(new FileWriter(path)), myFile);
        } catch (IOException ioe) {
            System.out.println("File cannot be saved");
        }
    }

}
