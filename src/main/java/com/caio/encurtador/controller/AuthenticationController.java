package com.caio.encurtador.controller;

import com.caio.encurtador.dto.AuthenticationDTO;
import com.caio.encurtador.dto.RegisterDTO;
import com.caio.encurtador.model.User;
import com.caio.encurtador.repository.UserRepository;
import com.caio.encurtador.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthenticationDTO authenticationDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.email(), authenticationDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated RegisterDTO registerDTO){
    if (this.userRepository.findByEmail(registerDTO.email()) != null)
        return ResponseEntity.badRequest().build();

    String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
    User user = new User(registerDTO.name(), registerDTO.email(), registerDTO.password());

    userService.create(user);

    return ResponseEntity.ok().build();
    }
}
