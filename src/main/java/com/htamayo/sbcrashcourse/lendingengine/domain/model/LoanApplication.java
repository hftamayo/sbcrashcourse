package com.htamayo.sbcrashcourse.lendingengine.domain.model;

import javax.persistence.*;
import java.time.Duration;
import java.util.Objects;

@Entity
@Table(name="loansapplication")
public final class LoanApplication {

    @Id
    @Column(name="id")
    private long id;
    @Column(name="amount")
    private int amount;
    @Column(name="repaymentindays")
    private int repaymentTermInDays;
    @Column(name="interestrate")
    private double interestRate;
    @ManyToOne
    private User borrower;

    public LoanApplication() {
    }

    public LoanApplication(int amount, User borrower, int repaymentTermInDays, double interestRate) {
        this.amount = amount;
        this.borrower = borrower;
        this.repaymentTermInDays = repaymentTermInDays;
        this.interestRate = interestRate;
    }

    public int getAmount() {
        return amount;
    }

    public User getBorrower() {
        return borrower;
    }

    public int getRepaymentTermInDays() {
        return repaymentTermInDays;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanApplication that = (LoanApplication) o;
        //verificar este return puesto que cuando cambiamos a int el metodo equals ya no era valido
        //return amount == that.amount && Double.compare(that.interestRate, interestRate) == 0 && borrower.equals(that.borrower) && repaymentTerm.equals(that.repaymentTerm);
        return amount == that.amount && Double.compare(that.interestRate, interestRate) == 0 && borrower.equals(that.borrower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, borrower, repaymentTermInDays, interestRate);
    }

    @Override
    public String toString() {
        return "LoanRequest{" +
                "amount=" + amount +
                ", borrower=" + borrower +
                ", repaymentTerm=" + repaymentTermInDays +
                ", interestRate=" + interestRate +
                '}';
    }
}
