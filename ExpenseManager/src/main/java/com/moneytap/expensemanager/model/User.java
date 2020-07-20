package com.moneytap.expensemanager.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "user_seq")
    @SequenceGenerator(
            name = "user_seq",
            sequenceName = "users_seq",
            allocationSize = 1
    )
    @Column(name = "user_id")
    private int userId;

    @Column(name = "first_name")
    @NotNull(message = "fill the first name")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "fill the first name")
    private String lastName;

    @Column(name = "email",unique=true)
    @NotNull(message = "fill the email")
    @Email(message="Invaild email")
    private String email;

    @Column(name = "password")
    @NotNull(message="fill the password")
    @Length(min=4,message="min 4 characters")
    private String password;

}
