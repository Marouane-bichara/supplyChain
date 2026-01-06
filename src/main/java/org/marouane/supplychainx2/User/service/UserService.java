package org.marouane.supplychainx2.User.service;

import lombok.AllArgsConstructor;
import org.marouane.supplychainx2.User.entity.User;
import org.marouane.supplychainx2.User.entity.enume.Role;
import org.marouane.supplychainx2.User.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findOrCreate(String keycloakId, String email, String firstName, String lastName, List<String> jwtRoles) {

        return userRepository.findByKeycloakId(keycloakId)
                .orElseGet(() -> {
                    if (jwtRoles == null || jwtRoles.isEmpty()) {
                        throw new IllegalArgumentException("User roles are missing in JWT");
                    }

                    Set<Role> roles = jwtRoles.stream()
                            .map(role -> {
                                try {
                                    return Role.valueOf(role);
                                } catch (IllegalArgumentException e) {
                                    throw new IllegalArgumentException("Invalid role from JWT: " + role);
                                }
                            })
                            .collect(Collectors.toSet());

                    User user = new User();
                    user.setKeycloakId(keycloakId);
                    user.setEmail(email);
                    user.setFirstName(firstName != null ? firstName : email);
                    user.setLastName(lastName != null ? lastName : "");
                    user.setRoles(roles);

                    return userRepository.save(user);
                });
    }
}
