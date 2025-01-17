//package com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api;
//
//import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.controller.DisposalGuidelineController;
//import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.model.DisposalGuideline;
//import com.enviro.assessment.grad001.waseemahmadebrahim.waste_management_api.service.DisposalGuidelineService;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Arrays;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//@WebMvcTest(DisposalGuidelineController.class)
//public class DisposalGuidelinesServiceTests {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private DisposalGuidelineService disposalGuidelineService;
//
//    @Test
//    void shouldGetAllDisposalGuidelines() throws Exception {
//        DisposalGuideline guideline1 = new DisposalGuideline();
//        guideline1.setId(1L);
//        guideline1.setDisposalGuidelines("Dispose in the recycling bin");
//
//        DisposalGuideline guideline2 = new DisposalGuideline();
//        guideline2.setId(2L);
//        guideline2.setDisposalGuidelines("Do not mix with organic waste");
//
//        when(disposalGuidelineService.getAllGuidelines()).thenReturn(Arrays.asList(guideline1, guideline2));
//
//        mockMvc.perform(get("/api/disposal-guidelines"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].disposalGuidelines").value("Dispose in the recycling bin"))
//                .andExpect(jsonPath("$[1].disposalGuidelines").value("Do not mix with organic waste"));
//    }
//
//    @Test
//    void shouldCreateDisposalGuideline() throws Exception {
//        DisposalGuideline guideline = new DisposalGuideline();
//        guideline.setId(1L);
//        guideline.setDisposalGuidelines("Dispose in the recycling bin");
//
//        when(disposalGuidelineService.createGuideline(anyLong(), any())).thenReturn(guideline);
//
//        mockMvc.perform(post("/api/disposal-guidelines?wasteCategoryId=1")
//                        .contentType("application/json")
//                        .content("{\"disposalGuidelines\":\"Dispose in the recycling bin\"}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.disposalGuidelines").value("Dispose in the recycling bin"));
//    }
//
//    @Test
//    void shouldDeleteDisposalGuideline() throws Exception {
//        doNothing().when(disposalGuidelineService).deleteGuideline(1L);
//
//        mockMvc.perform(delete("/api/disposal-guidelines/1"))
//                .andExpect(status().isOk());
//    }
//}
