package com.htamayo.sbcrashcourse.lendingengine.domain.model;

import java.util.Objects;

public class LoanRequest {
    private final int amount;
    private final User borrower;
    private final Duration repaymentTerm;
    private final double interestRate;


    public LoanRequest(int amount, User borrower, double interestRate) {
        this.amount = amount;
        this.borrower = borrower;
        this.interestRate = interestRate;
    }

    public int getAmount() {
        return amount;
    }

    public User getBorrower() {
        return borrower;
    }

    public Duration getRepaymentTerm() {
        return repaymentTerm;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanRequest that = (LoanRequest) o;
        return amount == that.amount && Double.compare(that.interestRate, interestRate) == 0 && borrower.equals(that.borrower) && repaymentTerm.equals(that.repaymentTerm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, borrower, repaymentTerm, interestRate);
    }

    @Override
    public String toString() {
        return "LoanRequest{" +
                "amount=" + amount +
                ", borrower=" + borrower +
                ", repaymentTerm=" + repaymentTerm +
                ", interestRate=" + interestRate +
                '}';
    }
}
