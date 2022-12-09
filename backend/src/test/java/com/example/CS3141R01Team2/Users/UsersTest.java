package com.example.CS3141R01Team2.Users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.CS3141R01Team2.StudySet.StudySet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

class UsersTest {
    /**
     * Method under test: {@link Users#isAccountNonLocked()}
     */
    @Test
    void testIsAccountNonLocked() {
        assertTrue((new Users()).isAccountNonLocked());
    }

    /**
     * Method under test: {@link Users#isAccountNonLocked()}
     */
    @Test
    void testIsAccountNonLocked2() {
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
        assertFalse(users.isAccountNonLocked());
    }

    /**
     * Method under test: {@link Users#isEnabled()}
     */
    @Test
    void testIsEnabled() {
        assertFalse((new Users()).isEnabled());
    }

    /**
     * Method under test: {@link Users#isEnabled()}
     */
    @Test
    void testIsEnabled2() {
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
        assertTrue(users.isEnabled());
    }

    /**
     * Method under test: {@link Users#getAuthorities()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAuthorities() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.example.CS3141R01Team2.Users.UserRole.name()" because "this.userRole" is null
        //       at com.example.CS3141R01Team2.Users.Users.getAuthorities(Users.java:124)
        //   See https://diff.blue/R013 to resolve this issue.

        (new Users()).getAuthorities();
    }

    /**
     * Method under test: {@link Users#getAuthorities()}
     */
    @Test
    void testGetAuthorities2() {
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
        Collection<? extends GrantedAuthority> actualAuthorities = users.getAuthorities();
        assertEquals(1, actualAuthorities.size());
        assertEquals("USER", ((List<? extends GrantedAuthority>) actualAuthorities).get(0).getAuthority());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Users#Users(String, String, String, String)}
     *   <li>{@link Users#setEmail(String)}
     *   <li>{@link Users#setName(String)}
     *   <li>{@link Users#setPassword(String)}
     *   <li>{@link Users#setStudySets(List)}
     *   <li>{@link Users#setUsername(String)}
     *   <li>{@link Users#getEmail()}
     *   <li>{@link Users#getName()}
     *   <li>{@link Users#getPassword()}
     *   <li>{@link Users#getStudySets()}
     *   <li>{@link Users#getUserID()}
     *   <li>{@link Users#getUsername()}
     *   <li>{@link Users#isAccountNonExpired()}
     *   <li>{@link Users#isCredentialsNonExpired()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Users actualUsers = new Users("janedoe", "iloveyou", "jane.doe@example.org", "Name");
        actualUsers.setEmail("jane.doe@example.org");
        actualUsers.setName("Name");
        actualUsers.setPassword("iloveyou");
        ArrayList<StudySet> studySetList = new ArrayList<>();
        actualUsers.setStudySets(studySetList);
        actualUsers.setUsername("janedoe");
        assertEquals("jane.doe@example.org", actualUsers.getEmail());
        assertEquals("Name", actualUsers.getName());
        assertEquals("iloveyou", actualUsers.getPassword());
        assertSame(studySetList, actualUsers.getStudySets());
        assertNull(actualUsers.getUserID());
        assertEquals("janedoe", actualUsers.getUsername());
        assertTrue(actualUsers.isAccountNonExpired());
        assertTrue(actualUsers.isCredentialsNonExpired());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Users#Users(String, String, String, String, UserRole)}
     *   <li>{@link Users#setEmail(String)}
     *   <li>{@link Users#setName(String)}
     *   <li>{@link Users#setPassword(String)}
     *   <li>{@link Users#setStudySets(List)}
     *   <li>{@link Users#setUsername(String)}
     *   <li>{@link Users#getEmail()}
     *   <li>{@link Users#getName()}
     *   <li>{@link Users#getPassword()}
     *   <li>{@link Users#getStudySets()}
     *   <li>{@link Users#getUserID()}
     *   <li>{@link Users#getUsername()}
     *   <li>{@link Users#isAccountNonExpired()}
     *   <li>{@link Users#isCredentialsNonExpired()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Users actualUsers = new Users("janedoe", "iloveyou", "jane.doe@example.org", "Name", UserRole.USER);
        actualUsers.setEmail("jane.doe@example.org");
        actualUsers.setName("Name");
        actualUsers.setPassword("iloveyou");
        ArrayList<StudySet> studySetList = new ArrayList<>();
        actualUsers.setStudySets(studySetList);
        actualUsers.setUsername("janedoe");
        assertEquals("jane.doe@example.org", actualUsers.getEmail());
        assertEquals("Name", actualUsers.getName());
        assertEquals("iloveyou", actualUsers.getPassword());
        assertSame(studySetList, actualUsers.getStudySets());
        assertNull(actualUsers.getUserID());
        assertEquals("janedoe", actualUsers.getUsername());
        assertTrue(actualUsers.isAccountNonExpired());
        assertTrue(actualUsers.isCredentialsNonExpired());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Users#Users(String, String, String, String, UserRole, Boolean)}
     *   <li>{@link Users#setEmail(String)}
     *   <li>{@link Users#setName(String)}
     *   <li>{@link Users#setPassword(String)}
     *   <li>{@link Users#setStudySets(List)}
     *   <li>{@link Users#setUsername(String)}
     *   <li>{@link Users#getEmail()}
     *   <li>{@link Users#getName()}
     *   <li>{@link Users#getPassword()}
     *   <li>{@link Users#getStudySets()}
     *   <li>{@link Users#getUserID()}
     *   <li>{@link Users#getUsername()}
     *   <li>{@link Users#isAccountNonExpired()}
     *   <li>{@link Users#isCredentialsNonExpired()}
     * </ul>
     */
    @Test
    void testConstructor3() {
        Users actualUsers = new Users("janedoe", "iloveyou", "jane.doe@example.org", "Name", UserRole.USER, true);
        actualUsers.setEmail("jane.doe@example.org");
        actualUsers.setName("Name");
        actualUsers.setPassword("iloveyou");
        ArrayList<StudySet> studySetList = new ArrayList<>();
        actualUsers.setStudySets(studySetList);
        actualUsers.setUsername("janedoe");
        assertEquals("jane.doe@example.org", actualUsers.getEmail());
        assertEquals("Name", actualUsers.getName());
        assertEquals("iloveyou", actualUsers.getPassword());
        assertSame(studySetList, actualUsers.getStudySets());
        assertNull(actualUsers.getUserID());
        assertEquals("janedoe", actualUsers.getUsername());
        assertTrue(actualUsers.isAccountNonExpired());
        assertTrue(actualUsers.isCredentialsNonExpired());
    }
}

