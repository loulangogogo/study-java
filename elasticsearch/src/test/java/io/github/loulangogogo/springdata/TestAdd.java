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
        dgUser.setAge(12);
        dgUser.setName("loulan");
        dgUser.setPhone("18509376997");
        dgUser.setAddress("china shanxi taiyuan");

        DgUser save = elasticsearchOperations.save(dgUser);
        System.out.println(save);
    }

    @Test
    public void test02() {
        List<DgUser> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            DgUser dgUser = new DgUser();
            dgUser.setId((long)i);
            dgUser.setAge(i);
            dgUser.setName("loulan"+i);
            dgUser.setPhone(""+i);
            dgUser.setAddress("china shanxi taiyuan" + i);
            list.add(dgUser);
        }

        elasticsearchOperations.save(list);
    }
}
