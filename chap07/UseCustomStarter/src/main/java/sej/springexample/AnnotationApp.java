package sej.springexample;

import sej.springexample.config.MyAnnotation;
import sej.springexample.service.MyService;

import java.lang.reflect.Method;

public class AnnotationApp {
    public static void main(String arg[]) throws Exception {
        Method[] methods = Class.forName(MyService.class.getName()).getMethods();

        for (int i=0; i<methods.length; i++) {
            if(methods[i].isAnnotationPresent(MyAnnotation.class)){
                MyAnnotation an = methods[i].getAnnotation(MyAnnotation.class);
                System.out.println("my annotation str value: " + an.strValue());
                System.out.println("my annotation int value: " + an.intValue());
            }
        }

    }
}
