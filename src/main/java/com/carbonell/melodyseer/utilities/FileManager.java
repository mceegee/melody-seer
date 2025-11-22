/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carbonell.melodyseer.utilities;

import com.carbonell.melodyseer.models.MyFile;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author marta
 */
// https://www.geeksforgeeks.org/java/serialization-and-deserialization-in-java/ 
public class FileManager {

    public static ArrayList<MyFile> readFile(String path) {
        try {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        ArrayList<MyFile> newFile = (ArrayList<MyFile>) ois.readObject();
        ois.close();
        return newFile;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("There was a problem loading the file.");
        }
        return null;
    }

    public static void writeFile(ArrayList<MyFile> myFile, String path) {
        try {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(myFile);
        oos.close();
        } catch(IOException ioe) {
            System.out.println("File cannot be saved");
        }
    }

}
