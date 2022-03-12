package com.htamayo.sbcrashcourse.lendingengine.domain.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="loansaccepted")
public class Loan {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User borrower;
    @ManyToOne
    private User lender;
    @Column(name="amount")
    @OneToOne(cascade = CascadeType.ALL)
    private Money loanAmount;
    @Column(name="interestrate")
    private double interestRate;
    @Column(name="datelent")
    private LocalDate dateLent;
    @Column(name="datedue")
    private LocalDate dateDue;
    @OneToOne(cascade = CascadeType.ALL)
    private Money amountRepayed;


    public Loan(){

    }

    public Loan(User lender, LoanApplication loanApplication){
        this.borrower = loanApplication.getBorrower();
        this.lender = lender;
        this.loanAmount = loanApplication.getAmount();
        this.interestRate = loanApplication.getInterestRate();
        this.dateLent = LocalDate.now();
        this.dateDue = LocalDate.now().plusDays(loanApplication.getRepaymentTermInDays());
    }

    public Money getAmountOwned(){
        return loanAmount.times(1 + interestRate/100).decrement(amountRepayed);

    }

    public long getId() {
        return id;
    }

    public User getBorrower() {
        return borrower;
    }

    public User getLender() {
        return lender;
    }

    public Money getAmountRepayed() {
        return amountRepayed;
    }

}
