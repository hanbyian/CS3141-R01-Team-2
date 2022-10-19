package com.example.CS3141R01Team2.Terms;

import java.util.List;

import com.example.CS3141R01Team2.StudySet.StudySet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TermsService {

    private final TermsRepository termsRepository;

    @Autowired
    public TermsService(TermsRepository termsRepository) {
        this.termsRepository = termsRepository;
    }

    public List<Terms> showTerms(){
        return termsRepository.findAll();
    }

    public void addTerm(Terms term) {
        termsRepository.save(term);
    }
    public void deleteTerm(Terms delTerm) {
        termsRepository.delete(delTerm);
    }
    // setTerm, change a term to a given term
    // setDefinition, change a definition of a given term
    // checkDefinition and/or getDefinition (does frontend want a boolean or a terms?) given a term
}
