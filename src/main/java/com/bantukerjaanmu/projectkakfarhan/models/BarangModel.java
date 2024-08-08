/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bantukerjaanmu.projectkakfarhan.models;

import java.time.LocalDate;
import org.json.simple.JSONArray;

/**
 *
 * @author mochammad.angkasa
 */
public class BarangModel {

    private Integer id;
    private String name;
    private String group;
    private JSONArray dataBarang;
    private String createdAt;

    public BarangModel(Integer id, String name, String group, String createdAt) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.createdAt = createdAt;
    }

    public BarangModel(Integer id, String name, String group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }

    public BarangModel(JSONArray dataBarang, String group) {
        this.dataBarang = dataBarang;
        this.group = group;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the group
     */
    public String getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the dataBarang
     */
    public JSONArray getDataBarang() {
        return dataBarang;
    }

    /**
     * @param dataBarang the dataBarang to set
     */
    public void setDataBarang(JSONArray dataBarang) {
        this.dataBarang = dataBarang;
    }

    /**
     * @return the createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
