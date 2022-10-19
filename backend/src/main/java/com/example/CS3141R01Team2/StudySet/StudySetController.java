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

    @GetMapping("/showSets")
    public List<StudySet> showSets(){
        return studySetService.showSets();
    }

    @PostMapping("/createStudySet")
    public void createStudySet(@RequestBody StudySet set) {
        studySetService.createStudySet(set);
    }
//    @DeleteMapping
//    public void deleteStudySet(Long setID) {
//        studySetService.deleteStudySet(setID);
//    }
    @PutMapping   // no clue what kind of mapping is needed here
    public void setSetName(StudySet currentSet, String newSetName) {
        studySetService.setSetName(currentSet, newSetName);
    }
    @GetMapping("/showSetsForUser")
    public List<StudySet> showSetsForUser(String username) {
        return studySetService.showSetsForUser(username);
    }

}
