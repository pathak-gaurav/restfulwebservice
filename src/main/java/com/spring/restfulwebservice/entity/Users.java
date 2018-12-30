package com.spring.restfulwebservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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

    private String username;

    private String firstName;

    private String lastName;

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
