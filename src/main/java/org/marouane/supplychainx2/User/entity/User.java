package org.marouane.supplychainx2.User.entity;


import jakarta.persistence.*;
import lombok.*;
import org.marouane.supplychainx2.User.entity.enume.Role;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true, length = 255)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


}
