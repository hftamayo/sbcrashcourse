package com.htamayo.sbcrashcourse.lendingengine.domain.repository;

import com.htamayo.sbcrashcourse.lendingengine.domain.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
