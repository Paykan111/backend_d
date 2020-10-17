package jspb.demo.service;

import jspb.demo.domain.User;
import jspb.demo.dto.DataDTO;
import jspb.demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

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

    public List<DataDTO> dataForTable() {
        List<DataDTO> dataDTOList = List.of(new DataDTO("Frozen Yogurt", 159, 6, 24, 4.0, "1%"),
                new DataDTO("Ice cream sandwich", 237, 9.0, 37, 4.3, "1%"),
                new DataDTO("Eclair", 262, 16.0, 23, 6.0, "7%"),
                new DataDTO("Cupcake", 305, 3.7, 67, 4.3, "8%"),
                new DataDTO("Gingerbread", 356, 16.0, 49, 3.9, "16%"),
                new DataDTO("Jelly bean", 375, 0.0, 94, 0.0, "0%"));
        return dataDTOList;
    }
}
