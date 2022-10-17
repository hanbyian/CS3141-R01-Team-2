package com.example.CS3141R01Team2.StudySet;

import java.util.List;

import com.example.CS3141R01Team2.Users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/studysets")
public class StudySetController {
    
    private final StudySetService studySetService;

    @Autowired
    public StudySetController(StudySetService studySetService) {
        this.studySetService = studySetService;
    }

    @GetMapping
    public List<StudySet> showSets(){
        return studySetService.showSets();
    }

    @PostMapping
    public void createStudySet(String setName, Users setOwner) {
        studySetService.createStudySet(setName, setOwner);
    }
    @DeleteMapping
//    public void deleteStudySet(Long setID) {
//        studySetService.deleteStudySet(setID);
//    }
    @PutMapping   // no clue what kind of mapping is needed here
    public void setSetName(StudySet currentSet, String newSetName) {
        studySetService.setSetName(currentSet, newSetName);
    }
    // getSetOwner

}
