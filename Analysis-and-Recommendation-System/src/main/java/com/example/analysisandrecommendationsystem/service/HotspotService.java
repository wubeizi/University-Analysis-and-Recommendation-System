package com.example.analysisandrecommendationsystem.service;

import com.example.analysisandrecommendationsystem.entity.Hotspot;

import java.util.List;

public interface HotspotService {
    List<Hotspot> getHotspotList();

    Hotspot getHotspotInfo(String name, String word);

    void deleteHotspot(String name, String word);

    void updateHotspotInfo(String name, String word, float heatRatio);

    void insertHotspotInfo(String name, String word, float heatRatio);
}
