package com.advantest.logExecTime.execTime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;

@Target (ElementType.METHOD) // This means the annotation can only be applied to methods
@Retention (RetentionPolicy.RUNTIME) // This means the annotation will be available at runtime
public @interface LogExecTime {

}