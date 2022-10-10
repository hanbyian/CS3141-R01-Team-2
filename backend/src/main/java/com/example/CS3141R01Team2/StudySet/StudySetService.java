package com.example.CS3141R01Team2.StudySet;

import java.util.List;

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
}
