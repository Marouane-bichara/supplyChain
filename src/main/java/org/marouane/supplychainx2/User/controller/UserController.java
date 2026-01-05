package org.marouane.supplychainx2.User.controller;

import lombok.AllArgsConstructor;
import org.marouane.supplychainx2.User.entity.User;
import org.marouane.supplychainx2.User.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public User getCurrentUser(@AuthenticationPrincipal Jwt jwt) {

        String keycloakId = jwt.getSubject();
        String email = jwt.getClaim("email");
        String firstName = jwt.getClaim("given_name");
        String lastName = jwt.getClaim("family_name");
        List<String> roles = jwt.getClaimAsStringList("realm_access.roles");


        return userService.findOrCreate(keycloakId, email, firstName, lastName, roles);
    }
}
