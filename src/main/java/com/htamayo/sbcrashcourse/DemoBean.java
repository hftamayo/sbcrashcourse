package com.htamayo.sbcrashcourse;
/*
ejemplo de un bean dentro del contexto spring
 */
import org.springframework.stereotype.Component;

@Component
public class DemoBean {

    public DemoBean(){
        System.out.println("first bean created on Spring Context");
    }
}
