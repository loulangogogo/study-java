package io.github.loulangogogo.springdata;

import io.github.loulangogogo.Main;
import io.github.loulangogogo.enitty.DgUser;
import io.github.loulangogogo.water.json.JsonTool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.*;

@SpringBootTest(classes = Main.class)
public class TestDelete {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;


    @Test
    public void test01() {
        String delete = elasticsearchOperations.delete("2", DgUser.class);
        System.out.println(delete);
    }

    @Test
    public void test02() {
        Criteria criteria = new Criteria();
        Query query = new CriteriaQuery(criteria);
        ByQueryResponse delete = elasticsearchOperations.delete(DeleteQuery.builder(query).build(), DgUser.class);
        System.out.println(JsonTool.toJson(delete));
    }
}
