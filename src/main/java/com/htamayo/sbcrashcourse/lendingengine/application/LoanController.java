package com.htamayo.sbcrashcourse.lendingengine.application;

import com.htamayo.sbcrashcourse.lendingengine.domain.model.LoanRequest;
import com.htamayo.sbcrashcourse.lendingengine.domain.repository.LoanRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    private final LoanRequestRepository loanRequestRepository;

    @Autowired
    public LoanController(LoanRequestRepository loanRequestRepository) {
        this.loanRequestRepository = loanRequestRepository;
    }

    @PostMapping(value = "/loan/request")
    public void RequestLoan(@RequestBody final LoanRequest loanRequest){
        System.out.println(loanRequest);
    }
}
