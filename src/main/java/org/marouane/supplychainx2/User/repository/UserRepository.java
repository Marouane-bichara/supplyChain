package org.marouane.supplychainx2.User.repository;

import org.marouane.supplychainx2.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long> {
    User findUserByFirstName(String name);
    User findUserByEmail(String email);
    Optional<User> findByKeycloakId(String keycloakId);

}
