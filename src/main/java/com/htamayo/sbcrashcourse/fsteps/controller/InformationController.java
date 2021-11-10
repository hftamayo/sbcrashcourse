package com.htamayo.sbcrashcourse.fsteps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InformationController {

    private static String SENTENCE = "Hello World";
    private final String propertySentence;

    @Autowired
    public InformationController(@Value("${demo.sentence}") String propertySentence){
        this.propertySentence = propertySentence;
    }

    //esta anotacion habilita el endpoint
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloWorld(){
        return SENTENCE;
    }

    @RequestMapping(value="/update/sentence", method= RequestMethod.POST)
    public void updateSentence(@RequestBody String updateSentence){
        SENTENCE = updateSentence;
    }

    @RequestMapping(value="/property/sentence", method=RequestMethod.GET)
    public String propertySentence(){
        return propertySentence;
    }
}
