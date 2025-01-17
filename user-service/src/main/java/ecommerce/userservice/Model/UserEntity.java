package ecommerce.userservice.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.stereotype.Service;

@Service
@Entity
public class UserEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;
    @Column(unique=true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    @Column(unique=true)
    private String email;
    @Enumerated(EnumType.STRING)
    private UserRole roles;

    public UserEntity(String username, String password, String firstName, String lastName, String email, UserRole roles) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
    }

    public UserEntity(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UserEntity() {

    }

    public void setRoles(UserRole roles) {
        this.roles = roles;
    }

    public UserRole getRoles() {
        return roles;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
