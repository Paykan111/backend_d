package jspb.demo.service;

import jspb.demo.domain.User;
import jspb.demo.dto.LoginFormDTO;
import jspb.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Boolean registerUser(LoginFormDTO loginFormDTO) {
        User user = new User();
        user.setUsername(loginFormDTO.getLogin());
        user.setPassword(passwordEncoder.encode(loginFormDTO.getPassword()));
        userRepository.save(user);
        return true;
    }
}


