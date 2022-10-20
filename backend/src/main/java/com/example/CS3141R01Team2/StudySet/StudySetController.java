package com.example.CS3141R01Team2.StudySet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.CS3141R01Team2.Users.Users;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/studyset")
public class StudySetController {
    public static class Request{
        @JsonProperty
        private String setName;

        @JsonProperty
        private String setOwner;

        public String getSetOwner() {
            return setOwner;
        }

        public void setSetOwner(String setOwner) {
            this.setOwner = setOwner;
        }

        public String getSetName() {
            return setName;
        }

        public void setSetName(String setName) {
            this.setName = setName;
        }

        public Request(String setName, String setOwner) {
            this.setName = setName;
            this.setOwner = setOwner;
        }
    }
    
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
    public void createStudySet(@RequestBody Request request) {
        studySetService.createStudySet(request.getSetName(), request.getSetOwner());
    }
//    @DeleteMapping
//    public void deleteStudySet(Long setID) {
//        studySetService.deleteStudySet(setID);
//    }
    @PutMapping
    public void setSetName(StudySet currentSet, String newSetName) {
        studySetService.setSetName(currentSet, newSetName);
    }
    @GetMapping("/showSetsForUser/{username}")
    public List<ArrayList<?>> showSetsForUser(@PathVariable String username) {
        return studySetService.showSetsForUser(username);
    }

}
