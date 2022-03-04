package com.htamayo.sbcrashcourse.lendingengine.domain.service;

import com.htamayo.sbcrashcourse.lendingengine.domain.exception.UserNotFoundException;
import com.htamayo.sbcrashcourse.lendingengine.domain.model.Money;
import com.htamayo.sbcrashcourse.lendingengine.domain.model.User;
import com.htamayo.sbcrashcourse.lendingengine.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class BalanceService {
    private final UserRepository userRepository;

    @Autowired
    public BalanceService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void topUpBalance(final Money money, String authToken){
        User user = findUser(authToken);
        user.topUp(money);
    }

    @Transactional
    public void withdrawFromBalance(final Money money, long authToken){
        User user = findUser(authToken);
        user.withDraw(money);
    }

    private User findUser(long authToken) {
        return userRepository.findById(authToken)
                .orElseThrow(() -> new UserNotFoundException(authToken));
    }



}