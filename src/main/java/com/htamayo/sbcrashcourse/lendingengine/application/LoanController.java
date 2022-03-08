package com.htamayo.sbcrashcourse.lendingengine.application;

import com.htamayo.sbcrashcourse.lendingengine.application.model.LoanRequest;
import com.htamayo.sbcrashcourse.lendingengine.application.service.TokenValidationService;
import com.htamayo.sbcrashcourse.lendingengine.domain.model.AppUser;
import com.htamayo.sbcrashcourse.lendingengine.domain.model.Loan;
import com.htamayo.sbcrashcourse.lendingengine.domain.model.LoanApplication;
import com.htamayo.sbcrashcourse.lendingengine.domain.model.User;
import com.htamayo.sbcrashcourse.lendingengine.domain.repository.LoanApplicationRepository;
import com.htamayo.sbcrashcourse.lendingengine.domain.repository.UserRepository;
import com.htamayo.sbcrashcourse.lendingengine.domain.service.LoanApplicationAdapter;
import com.htamayo.sbcrashcourse.lendingengine.domain.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class LoanController {

    private final LoanApplicationRepository loanApplicationRepository;
    private final LoanApplicationAdapter loanApplicationAdapter;
    private final LoanService loanService;
    private final TokenValidationService tokenValidationService;

    @Autowired
    public LoanController(LoanApplicationRepository loanApplicationRepository, LoanApplicationAdapter loanApplicationAdapter, LoanService loanService, TokenValidationService tokenValidationService) {
        this.loanApplicationRepository = loanApplicationRepository;
        this.loanApplicationAdapter = loanApplicationAdapter;
        this.loanService = loanService;
        this.tokenValidationService = tokenValidationService;
    }

    @PostMapping(value = "/loan/request", consumes={"application/json"})
    public void RequestLoan(@RequestBody final LoanRequest loanRequest, HttpServletRequest request){
        AppUser borrower = tokenValidationService.validateTokenAndGetUser(request.getHeader(HttpHeaders.AUTHORIZATION));
        loanApplicationRepository.save(loanApplicationAdapter.transform(loanRequest, borrower));
    }

    @GetMapping(value = "/loan/requests")
    public List<LoanApplication> findAllLoanApplications(HttpServletRequest request){
        tokenValidationService.validateTokenAndGetUser(request.getHeader(HttpHeaders.AUTHORIZATION));
        return (List<LoanApplication>)loanApplicationRepository.findAll();

    }

    @GetMapping(value = "/loan/borrowed")
    public List<Loan> findBorrowedLoans(@RequestHeader String authorizarion){
        User borrower = tokenValidationService.validateTokenAndGetUser(authorizarion);
        return loanService.findAllBorrowedLoans(borrower);
    }

    @GetMapping(value="/loan/lent")
    public List<Loan> findLentLoans(@RequestHeader String authorizarion){
        User lender = tokenValidationService.validateTokenAndGetUser(authorizarion);
        return loanService.findAllBorrowedLoans(lender);
    }

    @PostMapping(value="/loan/repay")
    public void re

    @PostMapping(value="/loan/accept/{loanApplicationId}")
    public void acceptLoan(@PathVariable final String loanApplicationId,
                           HttpServletRequest request){
        AppUser lender = tokenValidationService.validateTokenAndGetUser(request.getHeader(HttpHeaders.AUTHORIZATION));
        loanService.acceptLoan(Long.parseLong(loanApplicationId), lender.getId());

    }

    @GetMapping(value="/loans")
    public List<Loan> getLoans(){
        return loanService.getLoans();
    }
}
