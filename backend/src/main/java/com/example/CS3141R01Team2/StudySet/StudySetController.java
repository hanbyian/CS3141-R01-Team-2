package com.example.CS3141R01Team2.StudySet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.CS3141R01Team2.Users.Users;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wmisip
 * @author eljones
 * @author mykelly
 *
 * StudySetController includes all endpoint CRUD mapping for the API for the StudySet Entity
 */
@RestController
@RequestMapping(path = "studyset")
public class StudySetController {
    /**
     * Request Class acts as a wrapper for some of the Controller methods,
     * used to allow a method to take a json request without need for some inputs
     */
    public static class Request {
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

    /**
     * Get Request Mapping to get a List of all the Study Sets in the system
     * and the information for each set
     *
     * @return List of ArrayLists for each Study Set containing the Study Set name and ID
     */
    @GetMapping("/showSets")
    public List<ArrayList<?>> showSets() {
        return studySetService.showSets();
    }

    /**
     * Post Request Mapping to create a new study set for a given user
     *
     * @param request Request object for a json taking the required info to create a Study Set
     */
    @PostMapping("/createStudySet")
    public void createStudySet(@RequestBody Request request) {
        studySetService.createStudySet(request.getSetName(), request.getSetOwner());
    }

    /**
     * Get Mapping Request to return all Study Sets owned by a given user
     *
     * @param username
     * @return List<ArrayList>
     */
    @GetMapping("/showSetsForUser/{username}")
    public List<ArrayList<?>> showSetsForUser(@PathVariable String username) {
        return studySetService.showSetsForUser(username);
    }

//    @DeleteMapping
//    public void deleteStudySet(Long setID) {
//        studySetService.deleteStudySet(setID);
//    }

//    @PutMapping
//    public void setSetName(StudySet currentSet, String newSetName) {
//        studySetService.setSetName(currentSet, newSetName);
//    }
}
