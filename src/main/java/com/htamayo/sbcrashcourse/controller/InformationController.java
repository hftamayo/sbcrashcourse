package com.htamayo.sbcrashcourse.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InformationController {

    private static String SENTENCE = "Hello World";

    //esta anotacion habilita el endpoint
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloWorld(){
        return SENTENCE;
    }

    @RequestMapping(value="/update/sentence", method= RequestMethod.POST)
    public void updateSentence(@RequestBody String updateSentence){
        SENTENCE = updateSentence;


    }

}
