package com.example.analysisandrecommendationsystem.entity;

public class Hotspot {
    private String word;
    private float heatRatio;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHeatRatio() {
        return heatRatio;
    }

    public void setHeatRatio(float heatRatio) {
        this.heatRatio = heatRatio;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
