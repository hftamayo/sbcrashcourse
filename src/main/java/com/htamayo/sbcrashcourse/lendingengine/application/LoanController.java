package com.htamayo.sbcrashcourse.lendingengine.application;

import com.htamayo.sbcrashcourse.lendingengine.application.model.LoanRequest;
import com.htamayo.sbcrashcourse.lendingengine.domain.model.LoanApplication;
import com.htamayo.sbcrashcourse.lendingengine.domain.model.User;
import com.htamayo.sbcrashcourse.lendingengine.domain.repository.LoanApplicationRepository;
import com.htamayo.sbcrashcourse.lendingengine.domain.repository.UserRepository;
import com.htamayo.sbcrashcourse.lendingengine.domain.service.LoanApplicationAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

    private final LoanApplicationRepository loanApplicationRepository;
    private final UserRepository userRepository;
    private final LoanApplicationAdapter loanApplicationAdapter;

    @Autowired
    public LoanController(LoanApplicationRepository loanApplicationRepository, UserRepository userRepository, LoanApplicationAdapter loanApplicationAdapter) {
        this.loanApplicationRepository = loanApplicationRepository;
        this.userRepository = userRepository;
        this.loanApplicationAdapter = loanApplicationAdapter;
    }

    @PostMapping(value = "/loan/request", consumes={"application/json"})
    public void RequestLoan(@RequestBody final LoanRequest loanRequest){
        loanApplicationRepository.save(loanApplicationAdapter.transform(loanRequest));
    }

    @GetMapping(value = "/loan/requests")
    public List<LoanApplication> findAllLoanApplications(){
        return (List<LoanApplication>)loanApplicationRepository.findAll();

    }

    @GetMapping(value="/users")
    public List<User> findUsers(){
        return (List<User>) userRepository.findAll();
    }
}
