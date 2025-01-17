package com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.controller;

import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.model.WasteCategory;
import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService wasteCategoryService;

    @GetMapping
    public List<WasteCategory> getAllCategories() {
        return wasteCategoryService.getAllCategories();
    }

    @PostMapping
    public WasteCategory createCategory(@RequestBody @Valid WasteCategory wasteCategory) {
        return wasteCategoryService.createCategory(wasteCategory);
    }

    @PutMapping("/{id}")
    public WasteCategory updateCategory(@PathVariable Long id, @RequestBody @Valid WasteCategory updatedCategory) {
        return wasteCategoryService.updateCategory(id, updatedCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteCategory(id);
    }
}

