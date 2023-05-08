package com.example.CS3141R01Team2.Terms;

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

@ContextConfiguration(classes = {TermsController.class})
@ExtendWith(SpringExtension.class)
class TermsControllerTest {
    @Autowired
    private TermsController termsController;

    @MockBean
    private TermsService termsService;

    /**
     * Method under test: {@link TermsController#addTerm(TermsController.Request)}
     */
    @Test
    void testAddTerm() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/addTerm")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new TermsController.Request(1L, "Term", "Definition")));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(termsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link TermsController#delTermByID(Long)}
     */
    @Test
    void testDelTermByID() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/delTermByID/{termID}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(termsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link TermsController#getList()}
     */
    @Test
    void testGetList() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getTerms");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(termsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TermsController.Request#Request(Long, String, String)}
     *   <li>{@link TermsController.Request#setDefinition(String)}
     *   <li>{@link TermsController.Request#setParentSet(Long)}
     *   <li>{@link TermsController.Request#setTerm(String)}
     *   <li>{@link TermsController.Request#getDefinition()}
     *   <li>{@link TermsController.Request#getParentSetID()}
     *   <li>{@link TermsController.Request#getTerm()}
     * </ul>
     */
    @Test
    void testRequestConstructor() {
        TermsController.Request actualRequest = new TermsController.Request(1L, "Term", "Definition");
        actualRequest.setDefinition("Definition");
        actualRequest.setParentSet(1L);
        actualRequest.setTerm("Term");
        assertEquals("Definition", actualRequest.getDefinition());
        assertEquals(1L, actualRequest.getParentSetID().longValue());
        assertEquals("Term", actualRequest.getTerm());
    }

    /**
     * Method under test: {@link TermsController#showTermsForStudySet(Long)}
     */
    @Test
    void testShowTermsForStudySet() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/showTermsForStudySet/{studySetID}",
                1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(termsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

