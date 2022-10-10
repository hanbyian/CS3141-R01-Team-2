package com.example.CS3141R01Team2.StudySet;

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
    private Long setID;

    @Column(nullable = false)
    private String setName;
    
    @Column(nullable=false)
    private String setOwner;
    
    public String getSetName() {
        return setName;
    }
    public void setSetName(String setName) {
        this.setName = setName;
    }
    public String getSetOwner() {
        return setOwner;
    }
    public void setSetOwner(String setOwner) {
        this.setOwner = setOwner;
    }
    public Long getSetID() {
        return setID;
    }
    
    public StudySet(String setName, String setOwner) {
        this.setName = setName;
        this.setOwner = setOwner;
    }
    public StudySet() {
    }
    
    
}
