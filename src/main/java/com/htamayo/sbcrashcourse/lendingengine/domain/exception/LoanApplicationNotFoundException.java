package com.htamayo.sbcrashcourse.lendingengine.domain.exception;

public class LoanApplicationNotFoundException extends RuntimeException{
    public LoanApplicationNotFoundException(long loanApplicationId) {
        super("Loan Application with id: "+loanApplicationId+" was not found");
    }
}
