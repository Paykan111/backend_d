package jspb.demo.service;

import jspb.demo.domain.User;

public interface UserService {
    User findByUsername(String username);
}
