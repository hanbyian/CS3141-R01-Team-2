package com.example.CS3141R01Team2.StudySet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
