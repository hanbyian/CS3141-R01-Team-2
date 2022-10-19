package com.example.CS3141R01Team2.StudySet;

import java.util.List;
import java.util.Optional;

import com.example.CS3141R01Team2.Users.Users;
import com.example.CS3141R01Team2.Users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudySetService {
    
    private final StudySetRepository studySetRepository;

    private final UsersRepository usersRepository;

    @Autowired
    public StudySetService(StudySetRepository studySetRepository, UsersRepository usersRepository) {
        this.studySetRepository = studySetRepository;
        this.usersRepository = usersRepository;
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
    public void setSetName(StudySet currentSet, String newSetName) {
        currentSet.setSetName(newSetName);
    }
}
