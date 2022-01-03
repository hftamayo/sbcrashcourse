package com.htamayo.sbcrashcourse.lendingengine.domain.repository;

import com.htamayo.sbcrashcourse.lendingengine.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
