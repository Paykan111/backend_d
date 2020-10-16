package jspb.demo.service;

import jspb.demo.domain.User;
import jspb.demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        List<Map<String, String>> addressComponents = new ArrayList<>();

        Map<String, String> dessertsVal = new HashMap<>();
        dessertsVal.put("name", "Frozen Yogurt");
        dessertsVal.put("calories", "159");
        dessertsVal.put("fat", "6");
        dessertsVal.put("carbs", "24");
        dessertsVal.put("protein", "4.0");
        dessertsVal.put("iron", "1%");
        addressComponents.add(dessertsVal);

        Map<String, String> dessertsVal2 = new HashMap<>();
        dessertsVal2.put("name", "Ice cream sandwich");
        dessertsVal2.put("calories", "237");
        dessertsVal2.put("fat", "9.0");
        dessertsVal2.put("carbs", "37");
        dessertsVal2.put("protein", "4.3");
        dessertsVal2.put("iron", "1%");
        addressComponents.add(dessertsVal2);

        Map<String, String> dessertsVal3 = new HashMap<>();
        dessertsVal3.put("name", "Eclair");
        dessertsVal3.put("calories", "262");
        dessertsVal3.put("fat", "16.0");
        dessertsVal3.put("carbs", "23");
        dessertsVal3.put("protein", "6.0");
        dessertsVal3.put("iron", "7%");
        addressComponents.add(dessertsVal3);

        Map<String, String> dessertsVal4 = new HashMap<>();
        dessertsVal4.put("name", "Cupcake");
        dessertsVal4.put("calories", "305");
        dessertsVal4.put("fat", "3.7");
        dessertsVal4.put("carbs", "67");
        dessertsVal4.put("protein", "4.3");
        dessertsVal4.put("iron", "8%");
        addressComponents.add(dessertsVal4);

        Map<String, String> dessertsVal5 = new HashMap<>();
        dessertsVal5.put("name", "Gingerbread");
        dessertsVal5.put("calories", "356");
        dessertsVal5.put("fat", "16.0");
        dessertsVal5.put("carbs", "49");
        dessertsVal5.put("protein", "3.9");
        dessertsVal5.put("iron", "16%");
        addressComponents.add(dessertsVal5);

        Map<String, String> dessertsVal6 = new HashMap<>();
        dessertsVal6.put("name", "Jelly bean");
        dessertsVal6.put("calories", "375");
        dessertsVal6.put("fat", "0.0");
        dessertsVal6.put("carbs", "94");
        dessertsVal6.put("protein", "0.0");
        dessertsVal6.put("iron", "0%");
        addressComponents.add(dessertsVal6);

        List<Map<String, List<Map<String, String>>>> results = new ArrayList<>();
        Map<String, List<Map<String, String>>> desserts = new HashMap<>();
        desserts.put("desserts", addressComponents);
        results.add(desserts);
        return desserts;
    }
}
