package org.marouane.supplychainx2.User.repository;

import org.marouane.supplychainx2.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {
    User findUserByFirstName(String name);
    User findUserByEmail(String email);
}
