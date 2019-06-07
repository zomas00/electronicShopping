package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *  测试业务性能
 *  （创建普通切面的环绕通知）
 */

@Component
@Aspect //@Aspect:作用是把当前类标识为一个切面供容器读取
public class ServiceLogger {
    @Pointcut("within(com.services..*)")
    private void pointCut(){}
    //创建环绕通知（环绕通知括号中需要指明切入点）
    @Around(value = "pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("目标业务的执行方法耗费"+(end-start)+"毫秒");
        return obj;
    }
}
