package com.htamayo.sbcrashcourse.lendingengine.domain.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="loan")
public class Loan {

    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;
    @ManyToOne
    private User borrower;
    @ManyToOne
    private User lender;
    @Column(name="amount")
    private int amount;
    @Column(name="interestrate")
    private double interestRate;
    private LocalDate dateLent;
    private LocalDate dateDue;

    public Loan(){

    }

    public Loan(User lender, LoanApplication loanApplication){
        this.borrower = loanApplication.getBorrower();
        this.lender = lender;
        this.amount = loanApplication.getAmount();
        this.interestRate = loanApplication.getInterestRate();
        this.dateLent = LocalDate.now();
        this.dateDue = LocalDate.now().plusDays(loanApplication.getRepaymentTermInDays());

    }

}
