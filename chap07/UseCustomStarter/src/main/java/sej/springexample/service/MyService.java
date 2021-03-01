package sej.springexample.service;

import sej.springexample.config.MyAnnotation;

public class MyService {
    @MyAnnotation(strValue = "hi", intValue = 0301)
    public void printSomething() {
        System.out.println("test my annotation");
    }
}
