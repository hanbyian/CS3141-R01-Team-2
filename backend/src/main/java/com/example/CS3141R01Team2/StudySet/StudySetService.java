package com.example.CS3141R01Team2.StudySet;

import java.util.List;
import java.util.Optional;

import com.example.CS3141R01Team2.Users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
public class StudySetService {
    
    private final StudySetRepository studySetRepository;

    @Autowired
    public StudySetService(StudySetRepository studySetRepository) {
        this.studySetRepository = studySetRepository;
    }

    public List<StudySet> showSets(){
        return studySetRepository.findAll();
    }

    public List<StudySet> showSetsForUser(String username){
        Optional<StudySet> outStudySets = studySetRepository.findStudySetsByUser(username);
        return outStudySets.stream().toList();
    }
    @PostMapping
    public void createStudySet(String setName, Users setOwner) {
        studySetRepository.save(new StudySet(setName, setOwner));
    }
//    public void deleteStudySet(Long setID) {  // does deleteStudySet need a findStudySet method to work?
//        studySetRepository.delete(studySetRepository.findById(setID));
//    }
    @PutMapping
    public void setSetName(StudySet currentSet, String newSetName) {
        currentSet.setSetName(newSetName);
    }
}
