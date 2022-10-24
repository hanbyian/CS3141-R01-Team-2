package com.example.CS3141R01Team2.Terms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.CS3141R01Team2.StudySet.StudySet;
import com.example.CS3141R01Team2.StudySet.StudySetRepository;
import com.example.CS3141R01Team2.Users.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TermsService.class})
@ExtendWith(SpringExtension.class)
class TermsServiceTest {
    @MockBean
    private StudySetRepository studySetRepository;

    @MockBean
    private TermsRepository termsRepository;

    @Autowired
    private TermsService termsService;

    /**
     * Method under test: {@link TermsService#showTerms()}
     */
    @Test
    void testShowTerms() {
        ArrayList<ArrayList<?>> arrayListList = new ArrayList<>();
        when((List<ArrayList<?>>) termsRepository.showAllTerms()).thenReturn(arrayListList);
        List<ArrayList<?>> actualShowTermsResult = termsService.showTerms();
        assertSame(arrayListList, actualShowTermsResult);
        assertTrue(actualShowTermsResult.isEmpty());
        verify(termsRepository).showAllTerms();
    }

    /**
     * Method under test: {@link TermsService#showTerms()}
     */
    @Test
    void testShowTerms2() {
        when((List<ArrayList<?>>) termsRepository.showAllTerms()).thenThrow(new IllegalStateException("foo"));
        assertThrows(IllegalStateException.class, () -> termsService.showTerms());
        verify(termsRepository).showAllTerms();
    }

    /**
     * Method under test: {@link TermsService#addTerm(Long, String, String)}
     */
    @Test
    void testAddTerm() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setStudySets(new ArrayList<>());
        users.setUsername("janedoe");

        StudySet studySet = new StudySet();
        studySet.setSetName("Set Name");
        studySet.setSetOwner(users);

        Terms terms = new Terms();
        terms.setDefinition("Definition");
        terms.setParentSet(studySet);
        terms.setTerm("Term");
        when(termsRepository.save((Terms) any())).thenReturn(terms);

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setName("Name");
        users1.setPassword("iloveyou");
        users1.setStudySets(new ArrayList<>());
        users1.setUsername("janedoe");

        StudySet studySet1 = new StudySet();
        studySet1.setSetName("Set Name");
        studySet1.setSetOwner(users1);
        Optional<StudySet> ofResult = Optional.of(studySet1);
        when(studySetRepository.findById((Long) any())).thenReturn(ofResult);
        termsService.addTerm(1L, "Term", "Definition");
        verify(termsRepository).save((Terms) any());
        verify(studySetRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link TermsService#addTerm(Long, String, String)}
     */
    @Test
    void testAddTerm2() {
        when(termsRepository.save((Terms) any())).thenThrow(new IllegalStateException("foo"));

        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setStudySets(new ArrayList<>());
        users.setUsername("janedoe");

        StudySet studySet = new StudySet();
        studySet.setSetName("Set Name");
        studySet.setSetOwner(users);
        Optional<StudySet> ofResult = Optional.of(studySet);
        when(studySetRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(IllegalStateException.class, () -> termsService.addTerm(1L, "Term", "Definition"));
        verify(termsRepository).save((Terms) any());
        verify(studySetRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link TermsService#addTerm(Long, String, String)}
     */
    @Test
    void testAddTerm3() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setStudySets(new ArrayList<>());
        users.setUsername("janedoe");

        StudySet studySet = new StudySet();
        studySet.setSetName("Set Name");
        studySet.setSetOwner(users);

        Terms terms = new Terms();
        terms.setDefinition("Definition");
        terms.setParentSet(studySet);
        terms.setTerm("Term");
        when(termsRepository.save((Terms) any())).thenReturn(terms);
        when(studySetRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(IllegalStateException.class, () -> termsService.addTerm(1L, "Term", "Definition"));
        verify(studySetRepository).findById((Long) any());
    }
}

