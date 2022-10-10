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
    
}
