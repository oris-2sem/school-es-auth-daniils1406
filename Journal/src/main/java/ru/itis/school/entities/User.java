package ru.itis.school.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import ru.itis.school.entities.enums.Role;
import ru.itis.school.entities.enums.Status;
//import org.hibernate.annotations.UuidGenerator;

import javax.persistence.*;
import java.util.UUID;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "journal_user")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String password;


    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Status status;

    private int age;

    public boolean isBanned(){
        if(status.equals(Status.BANNED)){
            return true;
        }else {
            return false;
        }
    }

    public boolean isConfirmed(){
        if(status.equals(Status.VERIFIED)){
            return true;
        }else {
            return false;
        }
    }
}
