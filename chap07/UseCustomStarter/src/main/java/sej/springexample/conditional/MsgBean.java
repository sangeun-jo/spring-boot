package sej.springexample.conditional;

public interface MsgBean {
    default void printMsg () {
        System.out.println("My Bean default is running");
    }
}
