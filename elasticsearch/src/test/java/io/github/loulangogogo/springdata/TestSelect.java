package io.github.loulangogogo.springdata;

import io.github.loulangogogo.Main;
import io.github.loulangogogo.enitty.DgUser;
import io.github.loulangogogo.water.json.JsonTool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;

@SpringBootTest(classes = Main.class)
public class TestSelect {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Test
    public void test02() {
        Criteria criteria = new Criteria().and("age").is(12);
        Query query = new CriteriaQuery(criteria);
        SearchHits<DgUser> search = elasticsearchOperations.search(query, DgUser.class);
        search.stream().forEach(o->{

            System.out.println(JsonTool.toJson(o.getContent()));
        });
    }

    @Test
    public void test01() {
        DgUser dgUser1 = elasticsearchOperations.get("30000", DgUser.class);
        System.out.println(dgUser1);
    }
}
