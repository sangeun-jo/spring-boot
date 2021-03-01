package sej.springexample.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

//환경변수를 읽어서 판별하는 클래스
public class SiteAConfigCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return "sitea".equals(context.getEnvironment().getProperty("env", "sitea")); //환경변수 key 값이 sitea인지 판별
    }
}
