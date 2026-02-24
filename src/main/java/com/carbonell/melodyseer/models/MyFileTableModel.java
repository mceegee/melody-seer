/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carbonell.melodyseer.models;

import java.awt.Color;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 * Class that implements <code>AbstractTableModel</code>
 * Used to populate information about existing media on the app
 * 
 * @author marta
 */
public class MyFileTableModel extends AbstractTableModel {

    private String columns[] = {"Status", "Filename", "Size", "MIME type", "Download date"};
    private ArrayList<MyFile> listFiles;

    /**
     * Constructor
     * @param listFiles an <code>ArrayList</code> of <code>MyFile</code>
     */
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
                    return getStatusIcon(listFiles.get(rowIndex));
                case 1:
                    return listFiles.get(rowIndex).getFileName();
                case 2:
                    return listFiles.get(rowIndex).getSize();
                case 3:
                    return listFiles.get(rowIndex).getMime();
                case 4:
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
        switch (c) {
            case 0: 
                return ImageIcon.class;
            case 2:
                return Long.class;
            case 4:
                return LocalDate.class;
            default:
                return String.class;
        }
        
    }

    /**
     * Checks if selected item is stored on the cloud, locally or on both places
     * 
     * @param file <code>MyFile</code> 
     * @return <code>ImageIcon</code> assigned icon for each situation where media can be found
     */
    private ImageIcon getStatusIcon(MyFile file) {
        if (file.canBeDownloaded()) {
            return new javax.swing.ImageIcon(getClass().getResource("/images/cloud.png"));
        } else if (file.canBeUploaded()) {
            return new javax.swing.ImageIcon(getClass().getResource("/images/local.png"));
        }
        return new javax.swing.ImageIcon(getClass().getResource("/images/cloud-storage.png"));
    }

}
