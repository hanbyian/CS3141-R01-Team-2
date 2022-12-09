package com.example.CS3141R01Team2.StudySet;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.CS3141R01Team2.Users.UserRole;
import com.example.CS3141R01Team2.Users.Users;
import com.example.CS3141R01Team2.Users.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StudySetService.class})
@ExtendWith(SpringExtension.class)
class StudySetServiceTest {
    @MockBean
    private StudySetRepository studySetRepository;

    @Autowired
    private StudySetService studySetService;

    @MockBean
    private UsersRepository usersRepository;

    /**
     * Method under test: {@link StudySetService#showSets()}
     */
    @Test
    void testShowSets() {
        ArrayList<ArrayList<?>> arrayListList = new ArrayList<>();
        when((List<ArrayList<?>>) studySetRepository.showAllSets()).thenReturn(arrayListList);
        List<ArrayList<?>> actualShowSetsResult = studySetService.showSets();
        assertSame(arrayListList, actualShowSetsResult);
        assertTrue(actualShowSetsResult.isEmpty());
        verify(studySetRepository).showAllSets();
    }

    /**
     * Method under test: {@link StudySetService#showSets()}
     */
    @Test
    void testShowSets2() {
        when((List<ArrayList<?>>) studySetRepository.showAllSets()).thenThrow(new IllegalStateException());
        assertThrows(IllegalStateException.class, () -> studySetService.showSets());
        verify(studySetRepository).showAllSets();
    }

    /**
     * Method under test: {@link StudySetService#showSetsForUser(String)}
     */
    @Test
    void testShowSetsForUser() {
        ArrayList<ArrayList<?>> arrayListList = new ArrayList<>();
        when((List<ArrayList<?>>) studySetRepository.findStudySetsByUser((Users) any())).thenReturn(arrayListList);

        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setEnabled(true);
        users.setLocked(true);
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setStudySets(new ArrayList<>());
        users.setUserID(1L);
        users.setUserRole(UserRole.USER);
        users.setUsername("janedoe");
        Optional<Users> ofResult = Optional.of(users);
        when(usersRepository.findByUsername((String) any())).thenReturn(ofResult);
        List<ArrayList<?>> actualShowSetsForUserResult = studySetService.showSetsForUser("janedoe");
        assertSame(arrayListList, actualShowSetsForUserResult);
        assertTrue(actualShowSetsForUserResult.isEmpty());
        verify(studySetRepository).findStudySetsByUser((Users) any());
        verify(usersRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link StudySetService#showSetsForUser(String)}
     */
    @Test
    void testShowSetsForUser2() {
        when((List<ArrayList<?>>) studySetRepository.findStudySetsByUser((Users) any()))
                .thenThrow(new IllegalStateException());

        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setEnabled(true);
        users.setLocked(true);
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setStudySets(new ArrayList<>());
        users.setUserID(1L);
        users.setUserRole(UserRole.USER);
        users.setUsername("janedoe");
        Optional<Users> ofResult = Optional.of(users);
        when(usersRepository.findByUsername((String) any())).thenReturn(ofResult);
        assertThrows(IllegalStateException.class, () -> studySetService.showSetsForUser("janedoe"));
        verify(studySetRepository).findStudySetsByUser((Users) any());
        verify(usersRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link StudySetService#showSetsForUser(String)}
     */
    @Test
    void testShowSetsForUser3() {
        when((List<ArrayList<?>>) studySetRepository.findStudySetsByUser((Users) any()))
                .thenReturn(new ArrayList<>());
        when(usersRepository.findByUsername((String) any())).thenReturn(Optional.empty());
        assertThrows(IllegalStateException.class, () -> studySetService.showSetsForUser("janedoe"));
        verify(usersRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link StudySetService#createStudySet(String, String)}
     */
    @Test
    void testCreateStudySet() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setEnabled(true);
        users.setLocked(true);
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setStudySets(new ArrayList<>());
        users.setUserID(1L);
        users.setUserRole(UserRole.USER);
        users.setUsername("janedoe");

        StudySet studySet = new StudySet();
        studySet.setSetName("Set Name");
        studySet.setSetOwner(users);
        when(studySetRepository.save((StudySet) any())).thenReturn(studySet);

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setEnabled(true);
        users1.setLocked(true);
        users1.setName("Name");
        users1.setPassword("iloveyou");
        users1.setStudySets(new ArrayList<>());
        users1.setUserID(1L);
        users1.setUserRole(UserRole.USER);
        users1.setUsername("janedoe");
        Optional<Users> ofResult = Optional.of(users1);
        when(usersRepository.findByUsername((String) any())).thenReturn(ofResult);
        studySetService.createStudySet("Set Name", "Set Owner");
        verify(studySetRepository).save((StudySet) any());
        verify(usersRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link StudySetService#createStudySet(String, String)}
     */
    @Test
    void testCreateStudySet2() {
        when(studySetRepository.save((StudySet) any())).thenThrow(new IllegalStateException());

        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setEnabled(true);
        users.setLocked(true);
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setStudySets(new ArrayList<>());
        users.setUserID(1L);
        users.setUserRole(UserRole.USER);
        users.setUsername("janedoe");
        Optional<Users> ofResult = Optional.of(users);
        when(usersRepository.findByUsername((String) any())).thenReturn(ofResult);
        assertThrows(IllegalStateException.class, () -> studySetService.createStudySet("Set Name", "Set Owner"));
        verify(studySetRepository).save((StudySet) any());
        verify(usersRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link StudySetService#createStudySet(String, String)}
     */
    @Test
    void testCreateStudySet3() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setEnabled(true);
        users.setLocked(true);
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setStudySets(new ArrayList<>());
        users.setUserID(1L);
        users.setUserRole(UserRole.USER);
        users.setUsername("janedoe");

        StudySet studySet = new StudySet();
        studySet.setSetName("Set Name");
        studySet.setSetOwner(users);
        when(studySetRepository.save((StudySet) any())).thenReturn(studySet);
        when(usersRepository.findByUsername((String) any())).thenReturn(Optional.empty());
        assertThrows(IllegalStateException.class, () -> studySetService.createStudySet("Set Name", "Set Owner"));
        verify(usersRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link StudySetService#delStudySetByID(Long)}
     */
    @Test
    void testDelStudySetByID() {
        doNothing().when(studySetRepository).deleteById((Long) any());
        studySetService.delStudySetByID(1L);
        verify(studySetRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link StudySetService#delStudySetByID(Long)}
     */
    @Test
    void testDelStudySetByID2() {
        doThrow(new IllegalStateException()).when(studySetRepository).deleteById((Long) any());
        assertThrows(IllegalStateException.class, () -> studySetService.delStudySetByID(1L));
        verify(studySetRepository).deleteById((Long) any());
    }
}

