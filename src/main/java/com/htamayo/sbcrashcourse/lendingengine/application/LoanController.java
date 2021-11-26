package com.htamayo.sbcrashcourse.lendingengine.application;

import com.htamayo.sbcrashcourse.lendingengine.application.model.LoanRequest;
import com.htamayo.sbcrashcourse.lendingengine.domain.model.User;
import com.htamayo.sbcrashcourse.lendingengine.domain.repository.LoanRequestRepository;
import com.htamayo.sbcrashcourse.lendingengine.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

    private final LoanRequestRepository loanRequestRepository;
    private final UserRepository userRepository;

    @Autowired
    public LoanController(LoanRequestRepository loanRequestRepository, UserRepository userRepository) {
        this.loanRequestRepository = loanRequestRepository;
        this.userRepository = userRepository;
    }

    @PostMapping(value = "/loan/request")
    public void RequestLoan(@RequestBody final LoanRequest loanApplication){
    }

    @GetMapping(value="/users")
    public List<User> findUsers(){
        return userRepository.findAll();
    }
}
