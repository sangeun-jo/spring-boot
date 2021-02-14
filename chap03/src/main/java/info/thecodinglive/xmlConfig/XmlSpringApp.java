package info.thecodinglive.xmlConfig;

import basic.WorkService;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlSpringApp {
    public static void main(String arg[]){
        GenericXmlApplicationContext context = new GenericXmlApplicationContext(
                "classpath:applicationContext.xml" //리소스 폴더 밑에 파일 가져올 때
        );

        WorkService myWorkService = context.getBean("myWorkService", WorkService.class);
        myWorkService.askWork();

        WorkService yourWorkService = context.getBean("yourWorkService", WorkService.class);
        yourWorkService.askWork();

        context.close();
    }
}








