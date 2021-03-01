package sej.springexample.service;

public class ConsoleHello implements HelloService {
    @Override
    public void hi() {
        System.out.println("hello in console");
    }
}
