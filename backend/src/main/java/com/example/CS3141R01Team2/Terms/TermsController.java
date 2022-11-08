package com.example.CS3141R01Team2.Terms;

import java.util.ArrayList;
import java.util.List;

import com.example.CS3141R01Team2.StudySet.StudySet;
import com.example.CS3141R01Team2.StudySet.StudySetController;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wmisip
 * @author eljones
 * @author mykelly
 *
 * TermsController includes all endpoint CRUD mapping for the API for the Terms Entity
 */
@RestController
@RequestMapping(path="terms")
public class TermsController {

    /**
     * Request Class acts as a wrapper for some of the Controller methods,
     * used to allow a method to take a json request without need for some inputs
     */
    public static class Request{
        @JsonProperty
        private String term;
        @JsonProperty
        private String definition;
        @JsonProperty
        private Long parentSetID;

        public Long getParentSetID() {
            return parentSetID;
        }
        public void setParentSet(Long parentSetID) {
            this.parentSetID = parentSetID;
        }
        public String getTerm() {
            return term;
        }
        public void setTerm(String term) {
            this.term = term;
        }
        public String getDefinition() {
            return definition;
        }
        public void setDefinition(String definition) {
            this.definition = definition;
        }

        public Request(Long parentSetID, String term, String definition) {
            this.parentSetID = parentSetID;
            this.term = term;
            this.definition = definition;
        }
    }

    private final TermsService termsService;

    @Autowired
    public TermsController(TermsService termsService) {
        this.termsService = termsService;
    }

    /**
     * Get Request gets a List of all terms in the system
     *
     * @return a List of ArrayLists for each term in our system and the terms name and definition
     */
    @GetMapping("/getTerms")
    public List<ArrayList<?>> getList(){
        return termsService.showTerms();
    }

    /**
     * Post Request to create a new term for a given studyset
     *
     * @param request the Request Wrapper class containing the specific info we'd need to create a term
     */
    @PostMapping("/addTerm")
    public void addTerm(@RequestBody Request request) {
        termsService.addTerm(request.getParentSetID(), request.getTerm(), request.getDefinition());
    }
}
