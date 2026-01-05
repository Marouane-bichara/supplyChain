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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true, length = 255)
    private String email;

    @Column(unique = true, nullable = false)
    private String keycloakId;

    @Enumerated(EnumType.STRING)
    private Role role;
}
