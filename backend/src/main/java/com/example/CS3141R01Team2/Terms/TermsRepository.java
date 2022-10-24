package com.example.CS3141R01Team2.Terms;

import com.example.CS3141R01Team2.Users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wmisip
 * @author eljones
 * @author mykelly
 *
 * Repository for the Terms Entity containing all Queries for current Requests
 */
@Repository
public interface TermsRepository 
    extends JpaRepository<Terms, Long>{

    /**
     * Query to show all terms and their given term information
     *
     * @return
     */
    @Query("SELECT t.termID, t.term, t.definition, t.parentSet.setID FROM terms t")
    public List<ArrayList<?>> showAllTerms();

}
