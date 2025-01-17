package com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.service;

import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.model.RecyclingTip;
import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.model.WasteCategory;
import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingTipRepository recyclingTipRepository;

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    public List<RecyclingTip> getAllTips() {
        return recyclingTipRepository.findAll();
    }

    public RecyclingTip createTip(Long wasteCategoryId, RecyclingTip tip) {
        WasteCategory category = wasteCategoryRepository.findById(wasteCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory not found"));
        tip.setWasteCategory(category);
        return recyclingTipRepository.save(tip);
    }

    public RecyclingTip updateRecyclingTip(Long id, RecyclingTip updatedTip) {
        RecyclingTip tip = recyclingTipRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecyclingTip not found"));
        tip.setRecyclingTips(updatedTip.getRecyclingTips());
        return recyclingTipRepository.save(tip);
    }

    public void deleteTip(Long id) {
        recyclingTipRepository.deleteById(id);
    }
}

