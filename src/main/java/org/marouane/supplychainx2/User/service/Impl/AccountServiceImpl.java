package org.marouane.supplychainx2.User.service.Impl;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.marouane.supplychainx2.User.entity.User;
import org.marouane.supplychainx2.User.entity.enume.Role;
import org.marouane.supplychainx2.User.repository.UserRepository;
import org.marouane.supplychainx2.User.service.IAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class AccountServiceImpl implements IAccountService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;




    public  User loadUserByUserEmail(String email){
        return userRepository.findUserByEmail(email);
    }




}
