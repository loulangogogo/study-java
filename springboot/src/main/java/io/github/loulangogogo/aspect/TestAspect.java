package io.github.loulangogogo.aspect;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;

@SpringBootTest
@SpringBootApplication
public class TestAspect {

    @Autowired
    private MyUser myUser;

    @Test
    public void test02() {
        myUser.business01();
    }

    @Test
    public void test01() {
        myUser.business03("asdf",12);
    }
}
