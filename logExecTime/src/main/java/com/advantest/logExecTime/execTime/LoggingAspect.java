package com.advantest.logExecTime.execTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect {

    private final ThreadLocal<StopWatch> stopWatchThreadLocal = new ThreadLocal<>();

    @Before("@annotation(LogExecTime)")
    public void startExecutionTime(JoinPoint joinPoint) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatchThreadLocal.set(stopWatch);
    }

    @After("@annotation(LogExecTime)")
    public void endExecutionTime(JoinPoint joinPoint) {
        StopWatch stopWatch = stopWatchThreadLocal.get();
        stopWatch.stop();

        System.out.println("Method " + joinPoint.getSignature().getName() +
                " executed in " + stopWatch.getTotalTimeMillis() + " ms");

        stopWatchThreadLocal.remove();
    }
}