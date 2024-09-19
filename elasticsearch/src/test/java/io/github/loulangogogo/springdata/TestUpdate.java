package io.github.loulangogogo.springdata;


import io.github.loulangogogo.Main;
import io.github.loulangogogo.enitty.DgUser;
import io.github.loulangogogo.water.json.JsonTool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.UpdateResponse;

@SpringBootTest(classes = Main.class)
public class TestUpdate {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;


    @Test
    public void test01() {
        DgUser dgUser = new DgUser();
        dgUser.setId(3L);
        dgUser.setAge(12);
        dgUser.setName("loulan");
        dgUser.setPhone("123456789");
        dgUser.setAddress("china shanxi taiyuan");

        UpdateResponse update = elasticsearchOperations.update(dgUser);
        System.out.println(JsonTool.toJson(update));
    }
}
