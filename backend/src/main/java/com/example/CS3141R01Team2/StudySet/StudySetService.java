package com.example.CS3141R01Team2.StudySet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.CS3141R01Team2.Users.Users;
import com.example.CS3141R01Team2.Users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author wmisip
 * @author eljones
 * @author mykelly
 *
 * Service method for the StudySet Controller allowing the api to make calls to the repository
 */
@Service
public class StudySetService {
    
    private final StudySetRepository studySetRepository;

    private final UsersRepository usersRepository;

    /**
     *
     * @param studySetRepository
     * @param usersRepository
     */
    @Autowired
    public StudySetService(StudySetRepository studySetRepository, UsersRepository usersRepository) {
        this.studySetRepository = studySetRepository;
        this.usersRepository = usersRepository;
    }

    public List<ArrayList<?>> showSets() {
        return studySetRepository.showAllSets();
    }

    /**
     * Takes a username and finds all study sets whose setOwner is "username".
     * Study sets are given as a list.
     *
     * @param   username        username of user whose study sets are to be returned
     * @return  List<StudySet>  list of study sets tied to a given study set's owner
     */
    public List<ArrayList<?>> showSetsForUser(String username) {
        Optional<Users> getUserByUsername = usersRepository.findByUsername(username);
        if (getUserByUsername.isPresent()){
            List<ArrayList<?>>  listOfSets= studySetRepository.findStudySetsByUser(getUserByUsername.get());
            return listOfSets;
        } else{
            throw new IllegalStateException("user does not exist");
        }
    }

    /**
     * Creates a study set with setName being a title of the study set and the setOwner
     * being the user to whom the study set will be "owned" by. The study set will be
     * tied to this user.
     *
     * @param setName
     * @param setOwner
     */
    public void createStudySet(String setName, String setOwner) {
        Optional<Users> getUserByUsername = usersRepository.findByUsername(setOwner);

        if(getUserByUsername.isPresent()){
            studySetRepository.save(new StudySet(setName, getUserByUsername.get()));
        } else{
            throw new IllegalStateException("user " + setOwner + " does not exist!");
        }

    }

//    public void deleteStudySet(Long setID) {  // does deleteStudySet need a findStudySet method to work?
//        studySetRepository.delete(studySetRepository.findById(setID));
//    }

//    public void setSetName(StudySet currentSet, String newSetName) {
//        currentSet.setSetName(newSetName);
//    }
}
