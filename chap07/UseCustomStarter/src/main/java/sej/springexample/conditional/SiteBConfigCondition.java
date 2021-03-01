package sej.springexample.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class SiteBConfigCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return "siteb".equals(context.getEnvironment().getProperty("env", "siteb")); //환경변수 key 값이 sitea인지 판별
    }
}
