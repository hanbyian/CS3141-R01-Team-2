package com.example.CS3141R01Team2.StudySet;

import java.util.List;
import java.util.Optional;

import com.example.CS3141R01Team2.Users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
public class StudySetService {
    
    private final StudySetRepository studySetRepository;

    @Autowired
    public StudySetService(StudySetRepository studySetRepository) {
        this.studySetRepository = studySetRepository;
    }

    public List<StudySet> showSets() {
        return studySetRepository.findAll();
    }

    /**
     * Takes a username and finds all study sets whose setOwner is "username".
     * Study sets are given as a list.
     *
     * @param   username        username of user whose study sets are to be returned
     * @return  List<StudySet>  list of study sets tied to a given study set's owner
     */
    public List<StudySet> showSetsForUser(String username) {
        Optional<StudySet> outStudySets = studySetRepository.findStudySetsByUser(username);
        if(outStudySets.isEmpty())
            throw new IllegalStateException("no sets for this username!");
        return outStudySets.stream().toList();
    }

    /**
     * Creates a study set with setName being a title of the study set and the setOwner
     * being the user to whom the study set will be "owned" by. The study set will be
     * tied to this user.
     *
     * @param setName   study set's, that is to be created, name
     * @param setOwner  username to whom study set will be connected to
     */
    public void createStudySet(String setName, Users setOwner) {
        studySetRepository.save(new StudySet(setName, setOwner));
    }
//    public void deleteStudySet(Long setID) {  // does deleteStudySet need a findStudySet method to work?
//        studySetRepository.delete(studySetRepository.findById(setID));
//    }
    public void setSetName(StudySet currentSet, String newSetName) {
        currentSet.setSetName(newSetName);
    }
}
