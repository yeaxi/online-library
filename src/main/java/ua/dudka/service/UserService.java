package ua.dudka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dudka.beans.User;
import ua.dudka.store.DAO.Factory;

/**
 * Created by RASTA on 20.04.2016.
 */

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private Factory factory;

    public UserService() {

    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = factory.userDAO.getUser(s);
        if (user == null) {
            throw new UsernameNotFoundException("user " + s + " not found.");
        }
        return user;
    }
}
