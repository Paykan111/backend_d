package jspb.demo.controller;

import jspb.demo.dto.LoginFormDTO;
import jspb.demo.service.RegistrationService;
import jspb.demo.service.UserService;
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

    public UserController(RegistrationService registrationService, UserService userService) {
        this.registrationService = registrationService;
        this.userService = userService;
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
    public ResponseEntity dataToTable() {
        Map response = new HashMap();
        response.put("age", 89);
        response.put("first_name", "Geneva");
        response.put("last_name", "Wilson");
        return ResponseEntity.ok(response);
    }

}
