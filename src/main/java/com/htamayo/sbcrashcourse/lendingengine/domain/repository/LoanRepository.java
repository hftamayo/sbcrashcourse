package com.htamayo.sbcrashcourse.lendingengine.domain.repository;

import com.htamayo.sbcrashcourse.lendingengine.domain.model.Loan;
import com.htamayo.sbcrashcourse.lendingengine.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findAllByBorrower(User borrower);
    List<Loan> findAllByLender(User lender);
    Optional<Loan> findOneByIdAndBorrower(Long id, User borrower);

}
