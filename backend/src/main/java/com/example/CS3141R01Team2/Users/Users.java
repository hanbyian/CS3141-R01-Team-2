package com.example.CS3141R01Team2.Users;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.example.CS3141R01Team2.StudySet.StudySet;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

/**
 * @author wmisip
 * @author eljones
 * @author mykelly
 *
 * Users Entity Class holds the actual Users Object and generates it as a table in the database
 * has variables pertaining to the columns of the DB and any relationships corresponding to Entities
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity(name="users") //Entity tag used for HQL (hibernate queries)
@Table(
    name="users",
    uniqueConstraints = {
        @UniqueConstraint(name="userEmailUnique", columnNames="email")
    }
    ) //Table tag used for JPQL (Java Persistence)
public class Users implements UserDetails {

    @Id //classifies the upcoming variable will be treated at thew Primary Key
    @SequenceGenerator( //Sequence Generator lets us customize the sequence for the ID generation, increments by 1
        name = "userSequence",
        sequenceName = "userSequence",
        allocationSize = 1
    )
    @GeneratedValue( //tells us to use the generator we created
        strategy = GenerationType.SEQUENCE,
        generator = "userSequence"
    )
    
    @Column(updatable = false)
    @NonNull      // unique?
    private Long userID;

    @Column(unique = true)
    @NonNull
    private String username;

    @Column()
    @NonNull
    private String password;    //NOTE: change password data type to hash for security

    @Column(unique = true)
    @NonNull     // unique?, or multiple accounts ok?
    private String email;

    @Column()
    @NonNull
    private String name;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private Boolean locked = false;
    private Boolean enabled = false;
//
//    public List<StudySet> getStudySets() {
//        return studySets;
//    }
//
//    public void setStudySets(List<StudySet> studySets) {
//        this.studySets = studySets;
//    }
//
//    @OneToMany(mappedBy="setID")
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    private List<StudySet> studySets;

    @NonNull
    public Long getUserID() {
        return userID;
    }
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //Default constructor, missing userID since that is automatically generated
    public Users(String username, String password, String email, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public Users(@NonNull String username,
                 @NonNull String password,
                 @NonNull String email,
                 @NonNull String name,
                 UserRole userRole) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.userRole = userRole;
    }

    public Users(@NonNull String username,
                 @NonNull String password,
                 @NonNull String email,
                 @NonNull String name,
                 UserRole userRole,
                 Boolean enabled) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.userRole = userRole;
        this.enabled = enabled;
    }
}
