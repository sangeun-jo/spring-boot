package sej.springexample.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionApp {
    public static void main(String arg[]) {
        Package pack = ConditionApp.class.getPackage();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan(pack.getName());
        context.refresh();
        MsgBean bean = context.getBean(MsgBean.class);
        bean.printMsg();
    }
}
