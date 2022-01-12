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
    private int amount;
    @Column(name="interestrate")
    private double interestRate;
    @Column(name="datelent")
    private LocalDate dateLent;
    @Column(name="datedue")
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

    public long getId() {
        return id;
    }

    public User getBorrower() {
        return borrower;
    }

    public User getLender() {
        return lender;
    }

    public int getAmount() {
        return amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public LocalDate getDateLent() {
        return dateLent;
    }

    public LocalDate getDateDue() {
        return dateDue;
    }
}
