package com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.service;

import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.model.WasteCategory;
import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.repository.WasteCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    public List<WasteCategory> getAllCategories() {
        return wasteCategoryRepository.findAll();
    }

    public WasteCategory createCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }

    public WasteCategory updateCategory(Long id, WasteCategory updatedCategory) {
        WasteCategory category = wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory not found"));
        category.setName(updatedCategory.getName());
        return wasteCategoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        wasteCategoryRepository.deleteById(id);
    }
}
