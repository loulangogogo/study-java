package io.github.loulangogogo.aspect;

import java.lang.annotation.*;

/*********************************************************
 ** 使能当前jar包中的所有配置
 ** <br><br>
 ** Date: Created in 2022/6/27 12:47
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
@Target(value = {ElementType.METHOD})  //作用与类
@Retention(RetentionPolicy.RUNTIME)  //运行时注解
@Documented                          //可以被javadoc识别处理
public @interface EnableAspect {
}
