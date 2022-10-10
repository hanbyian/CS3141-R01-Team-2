package com.example.CS3141R01Team2.Terms;

import javax.persistence.*;

@Entity(name="terms")
@Table(name="terms")
public class Terms {
    @Id
    @SequenceGenerator(
        name = "termSequence",
        sequenceName = "termSequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "termSequence"
    )
    private Long termID;

    private Long parentSet;
    private Long term;
    private Long definition;
    
    public Long getParentSet() {
        return parentSet;
    }
    public void setParentSet(Long parentSet) {
        this.parentSet = parentSet;
    }
    public Long getTerm() {
        return term;
    }
    public void setTerm(Long term) {
        this.term = term;
    }
    public Long getDefinition() {
        return definition;
    }
    public void setDefinition(Long definition) {
        this.definition = definition;
    }
    public Long getTermID() {
        return termID;
    }
    
    public Terms(Long parentSet, Long term, Long definition) {
        this.parentSet = parentSet;
        this.term = term;
        this.definition = definition;
    }
    public Terms() {
    }

    
}
