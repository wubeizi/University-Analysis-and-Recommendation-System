package com.example.analysisandrecommendationsystem.dao;

import com.example.analysisandrecommendationsystem.entity.Hotspot;

import java.util.List;

public interface HotspotDao {
    List<Hotspot> getHotspotList();

    Hotspot getHotsotInfo(String name, String word);

    void deleteHotspot(String name, String word);

    void updateHotspotInfo(String name, String word, float heatRatio);

    void insertHotspotInfo(String name, String word, float heatRatio);
}
