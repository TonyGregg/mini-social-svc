package com.genil.learning.minisocialsvc.configs;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by Antony Genil Gregory on 4/25/2020 6:15 PM
 * For project : mini-social-svc
 **/
public class MangoDbSqlDatabaseCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return "MySql".equalsIgnoreCase(System.getProperty("dbType"));
    }
}
