package ru.itis.school.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Parent extends User{
    @JsonManagedReference
    @OneToMany(mappedBy = "parent",fetch = FetchType.EAGER)
    private List<Student> children;

    @PreRemove
    private void preRemove(){
        for(Student student:children){
            student.setParent(null);
        }
    }
}
