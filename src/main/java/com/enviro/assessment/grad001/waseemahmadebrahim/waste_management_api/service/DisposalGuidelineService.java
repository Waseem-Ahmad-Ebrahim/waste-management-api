package com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.service;

import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.model.DisposalGuideline;
import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.model.WasteCategory;
import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalGuidelineService {

    @Autowired
    private DisposalGuidelineRepository disposalGuidelineRepository;

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    public List<DisposalGuideline> getAllGuidelines() {
        return disposalGuidelineRepository.findAll();
    }

    public DisposalGuideline createGuideline(Long wasteCategoryId, DisposalGuideline guideline) {
        WasteCategory category = wasteCategoryRepository.findById(wasteCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory not found"));
        guideline.setWasteCategory(category);
        return disposalGuidelineRepository.save(guideline);
    }

    public DisposalGuideline updateDisposalGuideline(Long id, DisposalGuideline updatedGuideline) {
        DisposalGuideline guideline = disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DisposalGuideline not found"));
        guideline.setDisposalGuidelines(updatedGuideline.getDisposalGuidelines());
        return disposalGuidelineRepository.save(guideline);
    }

    public void deleteGuideline(Long id) {
        disposalGuidelineRepository.deleteById(id);
    }
}

