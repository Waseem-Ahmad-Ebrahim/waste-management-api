package com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RecyclingTip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String recyclingTips;

    @ManyToOne
    @JoinColumn(name = "waste_category_id", nullable = false)
    @JsonIgnore
    private WasteCategory wasteCategory;
}
