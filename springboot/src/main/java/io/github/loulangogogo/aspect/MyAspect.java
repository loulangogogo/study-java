package io.github.loulangogogo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

/*********************************************************
 ** 测试切面
 **
 ** @author loulan
 ** @since 17
 *********************************************************/
@Configuration
@Aspect
public class MyAspect {


    @Before("execution(* io.github.loulangogogo.aspect.MyUser.business01())")
    public void before01() {
        System.err.println("before01");
    }

    @After("@annotation(io.github.loulangogogo.aspect.EnableAspect)")
    public void before02() {
        System.err.println("before02");
    }

    @Pointcut("args(name,age)")
    public void before03(String name,int age) {
        System.err.println("name=" + name + ";age=" + age);
        System.err.println("before03");
    }

    @Before("before03(name,age)")
    public void before04(String name,int age) {
        System.err.println("name=" + name + ";age=" + age);
        System.err.println("before04");
    }

    @Around("within(io.github.loulangogogo.aspect.MyUser)")
    public void before05(ProceedingJoinPoint joinPoint) throws Throwable {
        System.err.println("before05-1");
        Object proceed = joinPoint.proceed();
        System.err.println("before05-2-"+proceed);
        System.err.println("before05-3");
    }
}
