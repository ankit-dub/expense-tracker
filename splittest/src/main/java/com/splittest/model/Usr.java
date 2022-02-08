package splittest.src.main.java.com.splittest.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usr")
public class Usr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "first_name")
    @NotNull(message = "fill the first name")
    private String name;

    @Column(name = "last_name")
    @NotNull(message = "fill the last name")
    private String lastName;

    @Column(name = "email",unique=true)
    @NotNull(message = "fill the email")
    @Email(message="Invaild email")
    private String email;

    @Column(name = "password")
    @NotNull(message="fill the password")
    @Length(min=4,message="min 4 characters")
    private String password;

    @Column(name = "status")
    private String status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private Collection<Expense> expense=new ArrayList<Expense>();


}

