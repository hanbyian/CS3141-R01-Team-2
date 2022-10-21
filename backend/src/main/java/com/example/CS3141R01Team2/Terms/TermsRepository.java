package com.example.CS3141R01Team2.Terms;

import com.example.CS3141R01Team2.Users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TermsRepository 
    extends JpaRepository<Terms, Long>{
    // check set is present, check

    @Query("SELECT t.termID, t.term, t.definition FROM terms t")
    public List<ArrayList<?>> showAllTerms();

}
