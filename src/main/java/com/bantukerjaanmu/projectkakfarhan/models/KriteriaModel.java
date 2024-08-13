package com.bantukerjaanmu.projectkakfarhan.models;

public class KriteriaModel {

    private Integer id;
    private Object data_kriteria;
    private String created_at;
    private String updated_at;
    private String kriteria;
    private String keterangan;
    private Float bobot;
    private String group;
    private String type;

    public KriteriaModel(Integer id, String kriteria, String keterangan, Float bobot, String group, String type, String updated_at) {
        this.id = id;
        this.kriteria = kriteria;
        this.keterangan = keterangan;
        this.bobot = bobot;
        this.group = group;
        this.type = type;
        this.created_at = updated_at;
    }

    public KriteriaModel(Object data_kriteria) {
        this.id = id;
        this.data_kriteria = data_kriteria;
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
     * @return the data_kriteria
     */
    public Object getData_kriteria() {
        return data_kriteria;
    }

    /**
     * @param data_kriteria the data_kriteria to set
     */
    public void setData_kriteria(Object data_kriteria) {
        this.data_kriteria = data_kriteria;
    }

    /**
     * @return the created_at
     */
    public String getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at the created_at to set
     */
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    /**
     * @return the updated_at
     */
    public String getUpdated_at() {
        return updated_at;
    }

    /**
     * @param updated_at the updated_at to set
     */
    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
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

    /**
     * @return the keterangan
     */
    public String getKeterangan() {
        return keterangan;
    }

    /**
     * @param keterangan the keterangan to set
     */
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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
     * @return the bobot
     */
    public Float getBobot() {
        return bobot;
    }

    /**
     * @param bobot the bobot to set
     */
    public void setBobot(Float bobot) {
        this.bobot = bobot;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

}
