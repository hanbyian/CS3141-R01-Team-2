package com.example.CS3141R01Team2.Terms;

import java.util.List;

import com.example.CS3141R01Team2.StudySet.StudySet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/terms")
public class TermsController {
    
    private final TermsService termsService;

    @Autowired
    public TermsController(TermsService termsService) {
        this.termsService = termsService;
    }

    @GetMapping
    public List<Terms> getList(){
        return termsService.showTerms();
    }

    @PostMapping
    public void addTerm(StudySet parentSet, String term, String definition) {
        termsService.addTerm(parentSet, term, definition);
    }
}
