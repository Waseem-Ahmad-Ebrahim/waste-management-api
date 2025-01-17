package com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api;

import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.controller.WasteCategoryController;
import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.model.WasteCategory;
import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.service.WasteCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(WasteCategoryController.class)
public class WasteCategoryServiceTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WasteCategoryService wasteCategoryService;

    @Test
    void shouldGetAllWasteCategories() throws Exception {
        WasteCategory category1 = new WasteCategory();
        category1.setId(1L);
        category1.setName("Plastic");

        WasteCategory category2 = new WasteCategory();
        category2.setId(2L);
        category2.setName("Metal");

        when(wasteCategoryService.getAllCategories()).thenReturn(Arrays.asList(category1, category2));

        mockMvc.perform(get("/api/waste-categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Plastic"))
                .andExpect(jsonPath("$[1].name").value("Metal"));
    }

    @Test
    void shouldCreateWasteCategory() throws Exception {
        WasteCategory category = new WasteCategory();
        category.setId(1L);
        category.setName("Plastic");

        when(wasteCategoryService.createCategory(any())).thenReturn(category);

        mockMvc.perform(post("/api/waste-categories")
                        .contentType("application/json")
                        .content("{\"name\":\"Plastic\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Plastic"));
    }

    @Test
    void shouldUpdateWasteCategory() throws Exception {
        WasteCategory category = new WasteCategory();
        category.setId(1L);
        category.setName("Plastic");

        when(wasteCategoryService.updateCategory(eq(1L), any())).thenReturn(category);

        mockMvc.perform(put("/api/waste-categories/1")
                        .contentType("application/json")
                        .content("{\"name\":\"Plastic Updated\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Plastic"));
    }

    @Test
    void shouldDeleteWasteCategory() throws Exception {
        doNothing().when(wasteCategoryService).deleteCategory(1L);

        mockMvc.perform(delete("/api/waste-categories/1"))
                .andExpect(status().isOk());
    }
}

