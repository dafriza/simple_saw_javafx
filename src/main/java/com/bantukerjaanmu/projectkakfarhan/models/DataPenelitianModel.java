/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bantukerjaanmu.projectkakfarhan.models;

/**
 *
 * @author mochammad.angkasa
 */
public class DataPenelitianModel {

    private double[] dataResultPenelitian;
    private int[] idDataBarang;

    public DataPenelitianModel(int[] idDataBarang, double[] dataResultPenelitian) {
        this.idDataBarang = idDataBarang;
        this.dataResultPenelitian = dataResultPenelitian;
    }

    /**
     * @return the dataResultPenelitian
     */
    public double[] getDataResultPenelitian() {
        return dataResultPenelitian;
    }

    /**
     * @param dataResultPenelitian the dataResultPenelitian to set
     */
    public void setDataResultPenelitian(double[] dataResultPenelitian) {
        this.dataResultPenelitian = dataResultPenelitian;
    }

    /**
     * @return the idDataBarang
     */
    public int[] getIdDataBarang() {
        return idDataBarang;
    }

    /**
     * @param idDataBarang the idDataBarang to set
     */
    public void setIdDataBarang(int[] idDataBarang) {
        this.idDataBarang = idDataBarang;
    }
}
