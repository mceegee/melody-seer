/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carbonell.melodyseer.utilities;

// Created by Github Copilot
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Maps to the API Usuari JSON. Unknown JSON properties will be ignored.
 * Note: API byte[] fields (picture) are expected as base64 strings and Jackson will decode into byte[].
 * If you prefer typed date handling, register JavaTimeModule on your ObjectMapper and change date fields to LocalDate/OffsetDateTime.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuari {
    @JsonProperty("id")
    public int id;

    @JsonProperty("email")
    public String email = "";

    @JsonProperty("passwordHash")
    public String passwordHash;

    @JsonProperty("nickName")
    public String nickName;

    // API sends binary as base64 string — Jackson will decode into byte[]
    @JsonProperty("picture")
    public byte[] picture;

    @JsonProperty("pictureFileName")
    public String pictureFileName;

    // Keep as String to avoid needing JavaTimeModule; change to LocalDate if you register the module.
    @JsonProperty("dateOfBirth")
    public String dateOfBirth;

    // Keep as String (ISO8601) or change to OffsetDateTime with JavaTimeModule
    @JsonProperty("registeredAt")
    public String registeredAt;

    @Override
    public String toString() {
        return String.format("Usuari{id=%d, email=%s, nickName=%s}", id, email, nickName);
    }
}
