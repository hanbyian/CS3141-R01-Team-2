package com.example.CS3141R01Team2.StudySet;

import java.util.List;

import com.example.CS3141R01Team2.Users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
