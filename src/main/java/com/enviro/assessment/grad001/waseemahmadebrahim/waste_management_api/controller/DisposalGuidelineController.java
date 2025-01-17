package com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.controller;

import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.model.DisposalGuideline;
import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.model.WasteCategory;
import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidelineService disposalGuidelineService;
    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    @GetMapping
    public List<DisposalGuideline> getAllGuidelines() {
        return disposalGuidelineService.getAllGuidelines();
    }

    @PostMapping
    public DisposalGuideline createGuideline(
            @RequestParam Long wasteCategoryId,
            @RequestBody @Valid DisposalGuideline guideline) {
        WasteCategory category = wasteCategoryRepository.findById(wasteCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory not found"));
        guideline.setWasteCategory(category);
        return disposalGuidelineService.createGuideline(wasteCategoryId, guideline);
    }

    @PutMapping("/{id}")
    public DisposalGuideline updateDisposalGuideline(@PathVariable Long id, @RequestBody @Valid DisposalGuideline updatedGuideline) {
        return disposalGuidelineService.updateDisposalGuideline(id, updatedGuideline);
    }

    @DeleteMapping("/{id}")
    public void deleteGuideline(@PathVariable Long id) {
        disposalGuidelineService.deleteGuideline(id);
    }
}
