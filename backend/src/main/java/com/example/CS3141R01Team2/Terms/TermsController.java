package com.example.CS3141R01Team2.Terms;

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
        private StudySet parentSet;

        public StudySet getParentSet() {
            return parentSet;
        }
        public void setParentSet(StudySet parentSet) {
            this.parentSet = parentSet;
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

        public Request(StudySet parentSet, String term, String definition) {
            this.parentSet = parentSet;
            this.term = term;
            this.definition = definition;
        }
    }

    @Autowired
    public TermsController(TermsService termsService) {
        this.termsService = termsService;
    }

    @GetMapping
    public List<Terms> getList(){
        return termsService.showTerms();
    }

    @PostMapping
    public void addTerm(@RequestBody Request request) {
        termsService.addTerm(new Terms(request.getParentSet(), request.getTerm(), request.getDefinition()));
    }
}
