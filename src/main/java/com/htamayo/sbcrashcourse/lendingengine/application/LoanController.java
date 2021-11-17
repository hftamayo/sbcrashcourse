package com.htamayo.sbcrashcourse.lendingengine.application;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @PostMapping(value = "/loan/request")
    public void RequestLoan(@RequestBody final LoanRequest loanRequest){
        System.out.println(loanRequest);
    }
}
