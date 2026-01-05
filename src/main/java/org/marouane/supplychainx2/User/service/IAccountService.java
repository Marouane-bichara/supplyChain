package org.marouane.supplychainx2.User.service;

import org.marouane.supplychainx2.User.entity.User;
import org.marouane.supplychainx2.User.entity.enume.Role;

public interface IAccountService {
    User loadUserByUserEmail(String email);

}
