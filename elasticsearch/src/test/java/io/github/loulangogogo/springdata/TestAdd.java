package io.github.loulangogogo.springdata;


import io.github.loulangogogo.Main;
import io.github.loulangogogo.enitty.DgUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

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
}
