/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bantukerjaanmu.projectkakfarhan.models;

import org.json.simple.JSONArray;

/**
 *
 * @author mochammad.angkasa
 */
public class SawBobotKriteriaModel {

    private JSONArray rawData;

    public SawBobotKriteriaModel(JSONArray rawData) {
        this.rawData = rawData;
    }

    /**
     * @return the rawData
     */
    public JSONArray getRawData() {
        return rawData;
    }

    /**
     * @param rawData the rawData to set
     */
    public void setRawData(JSONArray rawData) {
        this.rawData = rawData;
    }
}
