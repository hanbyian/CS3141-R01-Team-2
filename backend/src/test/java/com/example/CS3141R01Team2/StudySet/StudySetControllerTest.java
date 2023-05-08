package com.example.CS3141R01Team2.StudySet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {StudySetController.class})
@ExtendWith(SpringExtension.class)
class StudySetControllerTest {
    @Autowired
    private StudySetController studySetController;

    @MockBean
    private StudySetService studySetService;

    /**
     * Method under test: {@link StudySetController#createStudySet(StudySetController.Request)}
     */
    @Test
    void testCreateStudySet() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/createStudySet")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new StudySetController.Request("Set Name", "Set Owner")));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(studySetController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link StudySetController#delStudySetByID(Long)}
     */
    @Test
    void testDelStudySetByID() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/delStudySetByID/{studySetID}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(studySetController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StudySetController.Request#Request(String, String)}
     *   <li>{@link StudySetController.Request#setSetName(String)}
     *   <li>{@link StudySetController.Request#setSetOwner(String)}
     *   <li>{@link StudySetController.Request#getSetName()}
     *   <li>{@link StudySetController.Request#getSetOwner()}
     * </ul>
     */
    @Test
    void testRequestConstructor() {
        StudySetController.Request actualRequest = new StudySetController.Request("Set Name", "Set Owner");
        actualRequest.setSetName("Set Name");
        actualRequest.setSetOwner("Set Owner");
        assertEquals("Set Name", actualRequest.getSetName());
        assertEquals("Set Owner", actualRequest.getSetOwner());
    }

    /**
     * Method under test: {@link StudySetController#showSets()}
     */
    @Test
    void testShowSets() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/showSets");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(studySetController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link StudySetController#showSetsForUser()}
     */
    @Test
    void testShowSetsForUser() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/showSetsForUser");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(studySetController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

