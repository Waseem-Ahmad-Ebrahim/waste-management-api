package com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.repository;

import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.model.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {}
