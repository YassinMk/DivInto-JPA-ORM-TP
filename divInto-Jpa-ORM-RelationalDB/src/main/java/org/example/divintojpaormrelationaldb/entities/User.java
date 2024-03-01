package org.example.divintojpaormrelationaldb.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Table(schema = "USERS")
public class User {
    @Id
    private String userId;
    @Column(name = "USER_NAME" ,unique = true, length = 20)
    private String userName;
    private String password;
    @ManyToMany (mappedBy = "users" , fetch = FetchType.EAGER)
    private List<Role> roles =new ArrayList<>();
}
