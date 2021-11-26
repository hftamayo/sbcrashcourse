package com.htamayo.sbcrashcourse.lendingengine.domain.repository;

import com.htamayo.sbcrashcourse.lendingengine.domain.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRequestRepository extends JpaRepository<LoanApplication, Long> {


}
