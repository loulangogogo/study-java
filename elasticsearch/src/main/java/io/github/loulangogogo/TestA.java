package io.github.loulangogogo;

import io.github.loulangogogo.enitty.DgUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.mapping.model.CachingValueExpressionEvaluatorFactory;

import javax.annotation.PostConstruct;

@Configuration
public class TestA {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @PostConstruct
    public void test() {
        DgUser dgUser = new DgUser();
        dgUser.setId(2L);
        dgUser.setAge(12);
        dgUser.setName("loulan");
        dgUser.setPhone("18509376997");
        dgUser.setAddress("china shanxi taiyuan");

//        DgUser save = elasticsearchOperations.save(dgUser);

        DgUser dgUser1 = elasticsearchOperations.get("2", DgUser.class);
        System.out.println(dgUser1);
    }
}
