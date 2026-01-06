package org.marouane.supplychainx2.User.controller;

import lombok.AllArgsConstructor;
import org.marouane.supplychainx2.User.entity.User;
import org.marouane.supplychainx2.User.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public Map<String,Object> getCurrentUser(@AuthenticationPrincipal Jwt jwt) {
        String keycloakId = jwt.getSubject();
        String email = jwt.getClaim("email");
        String firstName = jwt.getClaim("given_name");
        String lastName = jwt.getClaim("family_name");
        List<String> roles = jwt.getClaimAsStringList("realm_access.roles");

        User user = userService.findOrCreate(keycloakId, email, firstName, lastName, roles);

        Map<String,Object> response = new HashMap<>();
        response.put("id", user.getId());
        response.put("keycloakId", user.getKeycloakId());
        response.put("email", user.getEmail());
        response.put("firstName", user.getFirstName());
        response.put("lastName", user.getLastName());
        response.put("roles", user.getRoles());

        return response;
    }
}
