package io.github.loulangogogo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/*********************************************************
 ** 测试方法
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
@Component
@Slf4j
public class MyUser {

    @EnableAspect
    public String business01() {
        System.out.println("buginess01执行了");
        return "business01";
    }

    public String business02() {
        System.out.println("buginess02执行了");
        return "business02";
    }

    public String business03(String name,int age ) {
        System.out.println("buginess03执行了; name=" + name + ";age=" + age);
        return "business03";
    }
}
