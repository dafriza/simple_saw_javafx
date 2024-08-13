/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bantukerjaanmu.projectkakfarhan.models;

import java.time.LocalDate;
import org.json.simple.JSONObject;

/**
 *
 * @author mochammad.angkasa
 */
public class KriteriaDetailModel {

    private Integer id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String jenisKriteria;
    private String kategori;
    private Integer nilai;
    private JSONObject rawKriteria;

    public KriteriaDetailModel(Integer id, String jenisKriteria, String kategori, Integer nilai, LocalDate updatedAt) {
        this.id = id;
        this.jenisKriteria = jenisKriteria;
        this.kategori = kategori;
        this.nilai = nilai;
        this.updatedAt = updatedAt;
    }
    
    public KriteriaDetailModel(Integer id, JSONObject rawKriteria){
        this.id = id;
        this.rawKriteria = rawKriteria;
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
     * @return the createdAt
     */
    public LocalDate getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the updatedAt
     */
    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return the jenisKriteria
     */
    public String getJenisKriteria() {
        return jenisKriteria;
    }

    /**
     * @param jenisKriteria the jenisKriteria to set
     */
    public void setJenisKriteria(String jenisKriteria) {
        this.jenisKriteria = jenisKriteria;
    }

    /**
     * @return the kategori
     */
    public String getKategori() {
        return kategori;
    }

    /**
     * @param kategori the kategori to set
     */
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    /**
     * @return the nilai
     */
    public Integer getNilai() {
        return nilai;
    }

    /**
     * @param nilai the nilai to set
     */
    public void setNilai(Integer nilai) {
        this.nilai = nilai;
    }

    /**
     * @return the rawKriteria
     */
    public JSONObject getRawKriteria() {
        return rawKriteria;
    }

    /**
     * @param rawKriteria the rawKriteria to set
     */
    public void setRawKriteria(JSONObject rawKriteria) {
        this.rawKriteria = rawKriteria;
    }
}
