package org.marouane.supplychainx2.User.service;

import org.marouane.supplychainx2.User.entity.User;
import org.marouane.supplychainx2.User.entity.enume.Role;

public interface IAccountService {
    User addNewUser(String firstName , String lastName , String email , String password , Role role);
    User loadUserByUserEmail(String email);

}
