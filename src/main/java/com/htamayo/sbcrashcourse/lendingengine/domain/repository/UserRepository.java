package com.htamayo.sbcrashcourse.lendingengine.domain.repository;

import com.htamayo.sbcrashcourse.lendingengine.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
