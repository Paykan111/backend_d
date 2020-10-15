package jspb.demo.service;

import jspb.demo.domain.User;
import jspb.demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    public Map dataForTable() {
        Map response = new HashMap();
        response.put("items", "[{name: 'name 1', PlayerOne: 'john', PlayerTwo: 'Mike'}," +
                " {name: 'name 2', PlayerOne: 'James', PlayerTwo: 'Bill'}," +
                " {name: 'name 3', PlayerOne: 'Jack', PlayerTwo: 'Ben'},]");
        return response;
    }
}
