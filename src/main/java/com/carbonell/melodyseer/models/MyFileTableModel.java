/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carbonell.melodyseer.models;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marta
 */
public class MyFileTableModel extends AbstractTableModel {

    private String columns[] = {"Filename", "Size", "MIME type", "Download date"};
    private ArrayList<MyFile> listFiles;

    public MyFileTableModel(ArrayList<MyFile> listFiles) {
        this.listFiles = listFiles;
    }

    @Override
    public int getRowCount() {
        return listFiles.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            switch (columnIndex) {
                case 0:
                    return listFiles.get(rowIndex).getFileName();
                case 1:
                    return listFiles.get(rowIndex).getSize();
                case 2:
                    return listFiles.get(rowIndex).getMime();
                case 3:
                    return listFiles.get(rowIndex).getDownloadDate();
                default:
                    System.out.println("S'ha produit una errada");
            }
        } catch (IOException ioe) {

        }
        return null;

    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Class getColumnClass(int c) {

        return String.class;
    }

    public Color getRowColor(int row) {
        MyFile currentFile = listFiles.get(row);
        if (currentFile.canBeDownloaded()) {
            return Color.LIGHT_GRAY;
        } else if (currentFile.canBeUploaded()) {
            return Color.MAGENTA;
        }
        return Color.ORANGE;
    }

}
