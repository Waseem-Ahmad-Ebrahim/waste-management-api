package com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.controller;

import org.springframework.web.bind.annotation.*;
import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.model.RecyclingTip;
import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.service.RecyclingTipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    @Autowired
    private RecyclingTipService recyclingTipService;

    @GetMapping
    public List<RecyclingTip> getAllTips() {
        return recyclingTipService.getAllTips();
    }

    @PostMapping
    public RecyclingTip createTip(@RequestParam Long wasteCategoryId, @RequestBody @Valid RecyclingTip tip) {
        return recyclingTipService.createTip(wasteCategoryId, tip);
    }

    @PutMapping("/{id}")
    public RecyclingTip updateRecyclingTip(@PathVariable Long id, @RequestBody @Valid RecyclingTip updatedTip) {
        return recyclingTipService.updateRecyclingTip(id, updatedTip);
    }

    @DeleteMapping("/{id}")
    public void deleteTip(@PathVariable Long id) {
        recyclingTipService.deleteTip(id);
    }
}