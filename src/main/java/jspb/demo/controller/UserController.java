package jspb.demo.controller;

import jspb.demo.dto.LoginFormDTO;
import jspb.demo.service.RegistrationService;
import jspb.demo.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@CrossOrigin(origins = "*")
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
        return "AAAAAAAAAAAAAAAAA";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String custom() {
        return "custom";
    }
}
