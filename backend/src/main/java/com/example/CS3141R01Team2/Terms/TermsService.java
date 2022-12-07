package com.example.CS3141R01Team2.Terms;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.CS3141R01Team2.StudySet.StudySet;
import com.example.CS3141R01Team2.StudySet.StudySetRepository;
import com.example.CS3141R01Team2.Users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wmisip
 * @author eljones
 * @author mykelly
 *
 * Service method for the Terms Controller allowing the api to make calls to the repository
 */
@Service
public class TermsService {

    private final TermsRepository termsRepository;

    private final StudySetRepository studySetRepository;

    @Autowired
    public TermsService(TermsRepository termsRepository, StudySetRepository studySetRepository) {
        this.termsRepository = termsRepository;
        this.studySetRepository = studySetRepository;
    }

    /**
     * Shows all terms in the system, not including their parent set
     *
     * @return a List of ArrayLists for each term containing their term ID, term name, and definition
     */
    public List<ArrayList<?>> showTerms(){
        return termsRepository.showAllTerms();
    }

    /**
     * Adds a term to a given study set
     *
     * @param studySetID the parent study set which the term will be added to
     * @param term the term name
     * @param definition the definition of the term
     */
    public void addTerm(Long studySetID, String term, String definition) {
        Optional<StudySet> getStudySetByID = studySetRepository.findById(studySetID);
        if(!getStudySetByID.isPresent()) {
            throw new IllegalStateException("give me a valid study set! NOW!");
        } else {
            termsRepository.save(new Terms(getStudySetByID.get(), term, definition));
        }
    }

    /**
     * Returns terms of a given study set's id, if the study set's id doesn't exist
     * return an error message
     *
     * @param studySetID
     * @return listOfTerms
     */
    public List<ArrayList<?>> showTermsForStudySet(Long studySetID) {
        Optional<StudySet> getTermsByID = studySetRepository.findById(studySetID);
        if (getTermsByID.isPresent()) {
            List<ArrayList<?>>  listOfTerms= termsRepository.showTermsByStudySet(studySetID);
            return listOfTerms;
        } else {
            throw new IllegalStateException("Study set does not exist!");
        }

    }
    /**
     * Removes a term that is currently stored in the database by their id
     *
     * @param termID, term ID to be removed
     */
    public void delTermByID(Long termID) {
        termsRepository.deleteById(termID);
    }
}
