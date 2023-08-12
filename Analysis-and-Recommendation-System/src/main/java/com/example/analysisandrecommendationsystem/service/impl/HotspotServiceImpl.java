package com.example.analysisandrecommendationsystem.service.impl;

import com.example.analysisandrecommendationsystem.dao.HotspotDao;
import com.example.analysisandrecommendationsystem.dao.impl.HotspotDaoImpl;
import com.example.analysisandrecommendationsystem.entity.Hotspot;
import com.example.analysisandrecommendationsystem.service.HotspotService;

import java.util.List;

public class HotspotServiceImpl implements HotspotService {

    private HotspotDao hotspotDao = new HotspotDaoImpl();
    @Override
    public List<Hotspot> getHotspotList() {
        return hotspotDao.getHotspotList();
    }

    @Override
    public Hotspot getHotspotInfo(String name, String word) {
        return hotspotDao.getHotsotInfo(name, word);
    }

    @Override
    public void deleteHotspot(String name, String word) {
        hotspotDao.deleteHotspot(name,word);
    }

    @Override
    public void updateHotspotInfo(String name, String word, float heatRatio) {
        hotspotDao.updateHotspotInfo(name,word,heatRatio);
    }

    @Override
    public void insertHotspotInfo(String name, String word, float heatRatio) {
        hotspotDao.insertHotspotInfo(name,word,heatRatio);
    }
}
