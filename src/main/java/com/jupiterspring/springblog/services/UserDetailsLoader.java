package com.jupiterspring.springblog.services;

import com.jupiterspring.springblog.model.User;
import com.jupiterspring.springblog.model.UserWithRoles;
import com.jupiterspring.springblog.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {

    private final UserRepository userDao;

    public UserDetailsLoader(UserRepository userDao){
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userDao.findByUsername(userName);
        if(user == null){
            throw new UsernameNotFoundException("No user found with username " + userName);
        }
        return new UserWithRoles(user); // the enhanced UserDetails copy user
    }
}
