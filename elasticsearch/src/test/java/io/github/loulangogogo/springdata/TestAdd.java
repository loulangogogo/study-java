package io.github.loulangogogo.springdata;


import io.github.loulangogogo.Main;
import io.github.loulangogogo.enitty.DgUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = Main.class)
public class TestAdd {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;


    @Test
    public void test01() {
        DgUser dgUser = new DgUser();
        dgUser.setId(3L);
        dgUser.setAge(12L);
        dgUser.setName("loulan");
        dgUser.setPhone("18509376997");
        dgUser.setAddress("china shanxi taiyuan");

        DgUser save = elasticsearchOperations.save(dgUser);
        System.out.println(save);
    }

    @Test
    public void test02() {
        List<Long> list = new ArrayList<>();
        for (long i = 0; i < 30000; i++) {
            list.add(i);
        }

        list.parallelStream().forEach(i->{
            DgUser dgUser = new DgUser();
            dgUser.setId(i);
            dgUser.setAge(i);
            dgUser.setName("loulan");
            dgUser.setPhone(""+i);
            dgUser.setAddress("china shanxi taiyuan" + i);
            elasticsearchOperations.save(dgUser);
            dgUser = null;
        });
    }
}
