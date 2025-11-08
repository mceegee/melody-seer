/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carbonell.melodyseer.models;

import com.carbonell.melodyseer.Main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marta
 */
public class MyFileTableModel extends AbstractTableModel {

    private String columns[] = {"Filename", "Size", "MIME type", "Download date"};
    private Main jFrameMain;

    public MyFileTableModel(Main jFrameMain) {
        this.jFrameMain = jFrameMain;
    }

    @Override
    public int getRowCount() {
        return jFrameMain.getMyFiles().size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ArrayList<MyFile> listFiles = jFrameMain.getMyFiles();
        try{
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
    
    

}
