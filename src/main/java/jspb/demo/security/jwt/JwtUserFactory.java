package jspb.demo.security.jwt;

import jspb.demo.domain.User;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getUsername(),
                user.getPassword(),
                user.getId()
        );
    }


}