/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bantukerjaanmu.projectkakfarhan.models;

import java.time.LocalDate;

/**
 *
 * @author mochammad.angkasa
 */
public class KriteriaDetailModel {

    private Integer id;
    private Object dataKriteria;
    private LocalDate createdAt;

    public KriteriaDetailModel(Integer id, Object dataKriteria, LocalDate createdAt) {
        this.id = id;
        this.dataKriteria = dataKriteria;
        this.createdAt = createdAt;
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
     * @return the dataKriteria
     */
    public Object getDataKriteria() {
        return dataKriteria;
    }

    /**
     * @param dataKriteria the dataKriteria to set
     */
    public void setDataKriteria(Object dataKriteria) {
        this.dataKriteria = dataKriteria;
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
}
