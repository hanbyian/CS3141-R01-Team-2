package com.example.CS3141R01Team2.Registration.token;

import com.example.CS3141R01Team2.Users.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {

    @Id //classifies the upcoming variable will be treated at thew Primary Key
    @SequenceGenerator( //Sequence Generator lets us customize the sequence for the ID generation, increments by 1
            name = "tokenSequence",
            sequenceName = "tokenSequence",
            allocationSize = 1
    )
    @GeneratedValue( //tells us to use the generator we created
            strategy = GenerationType.SEQUENCE,
            generator = "tokenSequence"
    )
    private Long id;
    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime expiresAt;
    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name="user_id"
    )
    private Users users;

    public ConfirmationToken(String token,
                             LocalDateTime createdAt,
                             LocalDateTime expiresAt,
                             Users users) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.users = users;
    }
}
