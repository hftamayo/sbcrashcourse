package com.htamayo.sbcrashcourse.lendingengine.domain.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="user")
public final class User {
    @Id
    @Column(name="id")
    private long id;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name="age")
    private int age;
    @Column(name="occupation")
    private String occupation;
    @OneToOne
    private Balance balance;

    public User() {
    }

    public User(long id, String firstName, String lastName, int age, String occupation, Balance balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.occupation = occupation;
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void topUp(final Money money){
        balance.topUp(money);
    }

    public void withDraw(final Money money){
        balance.withdraw(money);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && firstName.equals(user.firstName) && lastName.equals(user.lastName) && occupation.equals(user.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, occupation);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
