package com.htamayo.sbcrashcourse.lendingengine.application;

import com.htamayo.sbcrashcourse.lendingengine.application.service.TokenValidationService;
import com.htamayo.sbcrashcourse.lendingengine.domain.model.User;
import com.htamayo.sbcrashcourse.lendingengine.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {

    private final TokenValidationService tokenValidationService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(TokenValidationService tokenValidationService, UserRepository userRepository) {
        this.tokenValidationService = tokenValidationService;
        this.userRepository = userRepository;
    }

    @GetMapping(value="/users")
    public List<User> findUsers(HttpServletRequest request){
        tokenValidationService.validateTokenAndGetUser(request.getHeader(HttpHeaders.AUTHORIZATION));
        return userRepository.findAll();
    }
}
