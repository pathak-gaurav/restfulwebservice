package com.spring.restfulwebservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="USERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "users.get_all_users",query = "select u from Users u")
public class Users {

    @Id
    @GeneratedValue
    private Long userId;

    @Size(min = 3,max=25,message = "username can be between 3 to 25 character")
    private String username;

    @Size(min = 2,max=20,message = "First Name can be between 2 to 20 character")
    private String firstName;

    @Size(min = 2,max=20,message = "Last Name can be between 2 to 20 character")
    private String lastName;

    @Past(message = "DOB can be a past date")
    private LocalDate dob;

    @CreationTimestamp
    private LocalDateTime creationDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public Users(String username, String firstName, String lastName, LocalDate dob) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }
}
