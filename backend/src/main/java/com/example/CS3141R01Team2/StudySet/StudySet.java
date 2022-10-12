package com.example.CS3141R01Team2.StudySet;

import java.util.Set;

import com.example.CS3141R01Team2.Terms.Terms;
import com.example.CS3141R01Team2.Users.Users;


import javax.persistence.*;

@Entity(name="studyset")
@Table(name="studyset")
public class StudySet {
    @Id
    @SequenceGenerator(
        name = "studySetSequence",
        sequenceName = "studySetSequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "studySetSequence"
    )

    @Column(updatable = false)
    private Long setID;

    @Column(nullable = false)
    private String setName;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="setOwner", nullable = false)
    private Users setOwner;

    @OneToMany(mappedBy ="parentSet")
    private Set<Terms> terms;
    
    public String getSetName() {
        return setName;
    }
    public void setSetName(String setName) {
        this.setName = setName;
    }
    public Users getSetOwner() {
        return setOwner;
    }
    public void setSetOwner(Users setOwner) {
        this.setOwner = setOwner;
    }
    public Long getSetID() {
        return setID;
    }
    
    public StudySet(String setName, Users setOwner) {
        this.setName = setName;
        this.setOwner = setOwner;
    }
    public StudySet() {
    }
    
    
}
