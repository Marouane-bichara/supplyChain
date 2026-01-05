package org.marouane.supplychainx2.User.service;

import lombok.AllArgsConstructor;
import org.marouane.supplychainx2.User.entity.User;
import org.marouane.supplychainx2.User.entity.enume.Role;
import org.marouane.supplychainx2.User.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;



    public User findOrCreate(String keycloakId, String email, String firstName, String lastName, List<String> roles) {

        return userRepository.findByKeycloakId(keycloakId)
                .orElseGet(() -> {
                    User user = new User();
                    user.setKeycloakId(keycloakId);
                    user.setEmail(email);
                    user.setFirstName(firstName != null ? firstName : email);
                    user.setLastName(lastName != null ? lastName : "");
                    if (roles != null && !roles.isEmpty()) {
                        user.setRole(Role.valueOf(roles.get(0)));
                    } else {
                        user.setRole(Role.GESTIONNAIRE_APPROVISIONNEMENT);
                    }
                    return userRepository.save(user);
                });
    }
}
