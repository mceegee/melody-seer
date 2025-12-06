/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carbonell.melodyseer.utilities;

/**
 *
 * @author marta
 */
public class NewMedia {
    private final Media media;    
    private final String discoveredTime;
    
    public NewMedia(Media media, String discoveredTime) {
        this.media = media;
        this.discoveredTime = discoveredTime;
    }

    public Media getMedia() {
        return media;
    }

    public String getDiscoveredTime() {
        return discoveredTime;
    }
}
