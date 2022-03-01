package com.htamayo.sbcrashcourse.lendingengine.domain.model;

import java.util.Objects;

public final class Money {
    private final Currency currency;
    private final double amount;

    public Money(double amount, Currency currency) {
        this.currency = currency;
        this.amount = amount;
    }

    public Money increment(final Money money){
        if(currency != money.getCurrency()){
            throw new IllegalArgumentException();
        }
        return new Money(amount+ money.getAmount(), currency);
    }

    public Money decrement(final Money money){
        if(currency != money.getCurrency() || amount < money.getAmount()){
            throw new IllegalArgumentException();
        }
        return new Money(amount - money.getAmount(), currency);

    }

    public Currency getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(money.amount, amount) == 0 && currency == money.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }

    @Override
    public String toString() {
        return "Money{" +
                "currency=" + currency +
                ", amount=" + amount +
                '}';
    }
}
