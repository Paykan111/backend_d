package jspb.demo.controller;

import jspb.demo.dto.LoginFormDTO;
import jspb.demo.service.RegistrationService;
import jspb.demo.service.UserService;
import jspb.demo.service.UserServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    private RegistrationService registrationService;
    private UserService userService;
    private UserServiceImp userServiceImp;

    public UserController(RegistrationService registrationService, UserService userService, UserServiceImp userServiceImp) {
        this.registrationService = registrationService;
        this.userService = userService;
        this.userServiceImp = userServiceImp;
    }

    @PostMapping(path = "/registration")
    public ResponseEntity registration(@RequestBody LoginFormDTO loginFormDTO) {
        Boolean result = this.registrationService.registerUser(loginFormDTO);
        HttpStatus status = result ? HttpStatus.CREATED : HttpStatus.CONFLICT;
        return ResponseEntity.status(status).build();
    }

    @GetMapping(value = "/test")
    public String test() {
        return "You can see this message";
    }

    @GetMapping(value = "/table")
    public ResponseEntity getData() {
        return ResponseEntity.ok(userServiceImp.dataForTable());
    }
}
