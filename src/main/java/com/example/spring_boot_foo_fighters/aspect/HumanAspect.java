package com.example.spring_boot_foo_fighters.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class HumanAspect {

    @Pointcut("within(com.example.spring_boot_foo_fighters.service.*)") // = @Pointcut("execution(* com.example.spring_boot_foo_fighters.service..*(..))")
    public void allMethodPointcut() {}         // вызывает логги на все методы пакета service (getAllHumans, getHumanById, saveServ, deleteServ)

    @Pointcut("execution(* com.example.spring_boot_foo_fighters.service.HumanService.saveServ(..))")
    public void getAllHumanMethodPointcut() {}                     // вызывает метод saveServ(c любыми параметрами)

    @Before("allMethodPointcut()")
    public void loggingBeforeAdvice(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());     // показывает какой метод сработал
        log.info("Логирование before method execution - 1");
    }

    @After("getAllHumanMethodPointcut()")
    public void loggingAfterAdvice(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println(args[0]);                               // выводит сохраненного humana
        log.info("Логирование after method execution - 2");
    }

    /*@Around("within(com.example.spring_boot_foo_fighters.service.*)")      // *** @Pointcut + @Before + @After ***
    public void loggingAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Логирование Around method execution - 3 ");
        System.out.println(joinPoint.proceed());                  // выводит всех humanov из списка
    }*/
}
