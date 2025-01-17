//package com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api;
//
//import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.model.WasteCategory;
//import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.repository.WasteCategoryRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class WasteCategoryTests {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private WasteCategoryRepository repository;
//
//    @Test
//    public void testCreateWasteCategory() throws Exception {
//        String json = "{\"name\": \"Plastic\", \"description\": \"Non-biodegradable materials\"}";
//
//        mockMvc.perform(post("/api/waste-categories")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.name").value("Plastic"));
//    }
//
//    @Test
//    public void testGetWasteCategories() throws Exception {
//        repository.save(new WasteCategory("Plastic", "Non-biodegradable materials"));
//
//        mockMvc.perform(get("/api/waste-categories"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].name").value("Plastic"));
//    }
//}
//
