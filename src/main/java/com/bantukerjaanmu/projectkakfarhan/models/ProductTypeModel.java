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
public class ProductTypeModel {

    private Integer id;
    private String jenisKriteria;
    private String kategori;
    private Integer nilai;
    private String group;
    private String kriteria;
    private String updatedAt;

    public ProductTypeModel(Integer id) {
        this.id = id;
    }

    public ProductTypeModel(Integer id, String jenisKriteria, String kategori, Integer nilai, String group, String updatedAt) {
        this.id = id;
        this.jenisKriteria = jenisKriteria;
        this.kategori = kategori;
        this.nilai = nilai;
        this.group = group;
        this.updatedAt = updatedAt;
    }

    public ProductTypeModel(Integer id, String jenisKriteria, String kategori, Integer nilai, String group, String kriteria, String updatedAt) {
        this.id = id;
        this.jenisKriteria = jenisKriteria;
        this.kategori = kategori;
        this.nilai = nilai;
        this.group = group;
        this.kriteria = kriteria;
        this.updatedAt = updatedAt;
    }

    public ProductTypeModel(Integer id, String jenisKriteria, String kategori, Integer nilai) {
        this.id = id;
        this.jenisKriteria = jenisKriteria;
        this.kategori = kategori;
        this.nilai = nilai;
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
     * @return the updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return the kriteria
     */
    public String getKriteria() {
        return kriteria;
    }

    /**
     * @param kriteria the kriteria to set
     */
    public void setKriteria(String kriteria) {
        this.kriteria = kriteria;
    }

}
