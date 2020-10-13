package jspb.demo.service;

import jspb.demo.domain.User;
import jspb.demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    private UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

}
