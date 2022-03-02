package com.htamayo.sbcrashcourse.lendingengine.application;

import com.htamayo.sbcrashcourse.lendingengine.domain.model.Money;
import com.htamayo.sbcrashcourse.lendingengine.domain.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    private final BalanceService balanceService;

    @Autowired
    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @PostMapping("/topup")
    public void topUp(final @RequestBody Money money, @RequestHeader String authorization){
        balanceService.topUpBalance(money, authorization);
    }

    @PostMapping("/withdraw")
    public void withdraw(final @RequestBody Money money, @RequestHeader String authorization){

    }
}
