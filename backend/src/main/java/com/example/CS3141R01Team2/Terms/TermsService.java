package com.example.CS3141R01Team2.Terms;

import java.util.List;

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

    // addTerm, given a term and definition
    // setTerm, change a term to a given term
    // setDefinition, change a definition of a given term
    // checkDefinition and/or getDefinition (does frontend want a boolean or a terms?) given a term
}
