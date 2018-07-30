package com.example.demo;

/**
 * @author scl.BlueOcean
 * @version 1.0
 * @date 2018年07月30 14:13
 * @description
 */
public class CountryNode {
    private String name;
    private Double proportion;

    public CountryNode() {
    }

    public CountryNode(String name, Double proportion) {
        this.name = name;
        this.proportion = proportion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getProportion() {
        return proportion;
    }

    public void setProportion(Double proportion) {
        this.proportion = proportion;
    }
}
