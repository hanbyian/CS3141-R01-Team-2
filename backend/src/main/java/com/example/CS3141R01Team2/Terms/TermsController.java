package com.example.CS3141R01Team2.Terms;

import java.util.ArrayList;
import java.util.List;

import com.example.CS3141R01Team2.StudySet.StudySet;
import com.example.CS3141R01Team2.StudySet.StudySetController;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/terms")
public class TermsController {

    private final TermsService termsService;

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

    @Autowired
    public TermsController(TermsService termsService) {
        this.termsService = termsService;
    }

    @GetMapping
    public List<ArrayList<?>> getList(){
        return termsService.showTerms();
    }

    @PostMapping("/addTerm")
    public void addTerm(@RequestBody Request request) {
        termsService.addTerm(request.getParentSetID(), request.getTerm(), request.getDefinition());
    }
}
