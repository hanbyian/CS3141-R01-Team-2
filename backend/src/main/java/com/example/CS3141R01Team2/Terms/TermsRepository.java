package com.example.CS3141R01Team2.Terms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermsRepository 
    extends JpaRepository<Terms, Long>{
    // check set is present, check
}
