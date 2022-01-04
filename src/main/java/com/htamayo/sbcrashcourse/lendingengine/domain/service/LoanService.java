package com.htamayo.sbcrashcourse.lendingengine.domain.service;

import com.htamayo.sbcrashcourse.lendingengine.domain.exception.LoanApplicationNotFoundException;
import com.htamayo.sbcrashcourse.lendingengine.domain.exception.UserNotFoundException;
import com.htamayo.sbcrashcourse.lendingengine.domain.model.Loan;
import com.htamayo.sbcrashcourse.lendingengine.domain.model.LoanApplication;
import com.htamayo.sbcrashcourse.lendingengine.domain.model.User;
import com.htamayo.sbcrashcourse.lendingengine.domain.repository.LoanApplicationRepository;
import com.htamayo.sbcrashcourse.lendingengine.domain.repository.LoanRepository;
import com.htamayo.sbcrashcourse.lendingengine.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanService {

    private final LoanApplicationRepository loanApplicationRepository;
    private final UserRepository userRepository;
    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanApplicationRepository loanApplicationRepository, UserRepository userRepository, LoanRepository loanRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
        this.userRepository = userRepository;
        this.loanRepository = loanRepository;
    }

    public void acceptLoan(final long loanApplicationId, final long lenderId){
        User lender = userRepository.findById(lenderId).orElseThrow(() -> new UserNotFoundException(lenderId
        ));
        LoanApplication loanApplication = loanApplicationRepository.findById(loanApplicationId)
                .orElseThrow(() -> new LoanApplicationNotFoundException(loanApplicationId));
        loanRepository.save(new Loan(lender, loanApplication));
    }
}
