package io.github.loulangogogo.springdata;

import io.github.loulangogogo.Main;
import io.github.loulangogogo.enitty.DgUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import javax.annotation.PostConstruct;

@SpringBootTest(classes = Main.class)
public class TestSelect {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;


    @Test
    public void test01() {
        DgUser dgUser1 = elasticsearchOperations.get("2", DgUser.class);
        System.out.println(dgUser1);
    }
}
