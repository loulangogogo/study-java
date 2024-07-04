package io.github.loulangogogo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/*********************************************************
 ** 应用启动类
 ** <br><br>
 ** Date: Created in 2022/6/13 11:05
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
@SpringBootApplication
@Slf4j
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
        log.info("\r\n" +
                "**********************************************************************\r\n" +
                "*********                                                    *********\r\n" +
                "*********                     start over                     *********\r\n" +
                "*********                                                    *********\r\n" +
                "**********************************************************************"
        );
    }
}
