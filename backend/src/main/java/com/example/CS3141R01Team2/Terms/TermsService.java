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

//    /**
//     *
//     * @param delTerm
//     */
//    public void deleteTerm(Terms delTerm) {
//        termsRepository.delete(delTerm);
//    }
    // setTerm, change a term to a given term
    // setDefinition, change a definition of a given term
    // checkDefinition and/or getDefinition (does frontend want a boolean or a terms?) given a term

}
