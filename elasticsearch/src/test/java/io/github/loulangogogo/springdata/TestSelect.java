package io.github.loulangogogo.springdata;

import co.elastic.clients.elasticsearch._types.query_dsl.Like;
import co.elastic.clients.elasticsearch._types.query_dsl.MoreLikeThisQuery;
import io.github.loulangogogo.Main;
import io.github.loulangogogo.enitty.DgUser;
import io.github.loulangogogo.water.json.JsonTool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.StringQuery;

import javax.annotation.PostConstruct;

@SpringBootTest(classes = Main.class)
public class TestSelect {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Test
    public void test02() {
        // fixme 2024/9/19(待修改)  
        StringQuery stringQuery = new StringQuery("2");
        SearchHits<DgUser> search = elasticsearchOperations.search(stringQuery, DgUser.class);
        search.stream().forEach(o->{
            System.out.println(JsonTool.toJson(o));
        });

    }

    @Test
    public void test01() {
        DgUser dgUser1 = elasticsearchOperations.get("2", DgUser.class);
        System.out.println(dgUser1);
    }
}
