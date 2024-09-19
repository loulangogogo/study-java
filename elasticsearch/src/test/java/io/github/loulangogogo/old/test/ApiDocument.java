package io.github.loulangogogo.old.test;

import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.github.loulangogogo.old.Connecting;
import io.github.loulangogogo.old.domain.User;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public class ApiDocument extends Connecting {

    public void test06() {
    }

    @Test
    public void test05() throws IOException {
        SearchResponse<Void> search = esClient.search(b -> b
                        .index("dg_user")
                        .size(0)
                        .aggregations("test",
                                o -> o.avg(fn -> fn.field("age")))
                , Void.class);
        System.out.println(search);
    }

    @Test
    public void test04() throws IOException {
        GetResponse<ObjectNode> dgUser = esClient.get(
                o -> o.index("dg_user")
                        .id("10"),
                ObjectNode.class
        );
        ObjectNode source = dgUser.source();
        System.out.println(dgUser.source());
    }

    @Test
    public void test03() throws IOException {
        GetResponse<User> dgUser = esClient.get(
                o -> o.index("dg_user")
                        .id("10"),
                User.class
        );
        System.out.println(dgUser.source());
    }

    @Test
    public void test02() throws IOException {
        BulkRequest.Builder br = new BulkRequest.Builder();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(10+i);
            user.setName("yyy+i");
            user.setEmail("xxx@163.com");
            user.setPhone("15902645896");
            user.setIdCard("" + i);
            br.operations(
                    o -> o.index(
                            op -> op.index("dg_user")
                                    .id(user.getAge().toString())
                                    .document(user)
                    ));
        }

        BulkResponse bulk = esClient.bulk(br.build());
        System.out.println(bulk);
    }

    @Test
    public void test01() throws IOException {

        User user = new User();
        user.setAge(10);
        user.setName("hahah");
        user.setEmail("xxx@163.com");
        user.setPhone("15902645896");
        user.setIdCard("333333333333333333");

        IndexResponse response = esClient.index(i -> i
                .index("dg_user")
                .id("20")
                .document(user)
        );

        System.out.println(response);
    }

    /**
     * 创建索引
     * @param
     * @return
     * @exception
     * @author     :loulan
     * */
    @Test
    public void createIndex2 () throws IOException {
        String index = "{\n" +
                "  \"mappings\": {\n" +
                "    \"properties\": {\n" +
                "      \"field1\": { \"type\": \"text\" }\n" +
                "    }\n" +
                "  }\n" +
                "}";
        CreateIndexResponse createTest = esClient.indices().create(CreateIndexRequest.of(
                b -> b.index("create_test2")
                        .withJson(new ByteArrayInputStream(index.getBytes()))
        ));
        System.out.println(createTest);
    }

    /**
     * 创建索引
     * @param
     * @return
     * @exception
     * @author     :loulan
     * */
    @Test
    public void createIndex() throws IOException {
        CreateIndexResponse createTest = esClient.indices().create(
                o -> o.index("create_test")
        );
        System.out.println(createTest);
    }

    /**
     * 第一个测试案例
     *
     * @param
     * @return
     * @throws
     * @author :loulan
     */
    @Test
    public void first() throws IOException {
        // 阻塞方式查询
        SearchResponse<User> dgUserSearch = esClient.search(
                o -> o.index("dg_user"),
                User.class);
        List<User> list = dgUserSearch.hits().hits().parallelStream().map(o -> o.source()).toList();
        System.out.println(list);
    }

    /**
     * 第二个测试案例
     *
     * @param
     * @return
     * @throws
     * @author :loulan
     */
    @Test
    public void second() throws IOException, InterruptedException {
        // 异步方式查询
        esAsyncClient.search(
                o -> o.index("dg_user"),
                User.class)
                .whenComplete(((userSearchResponse, throwable) -> {
                    List<User> list = userSearchResponse.hits().hits().parallelStream().map(o -> o.source()).toList();
                    System.out.println(list);
                }));
        Thread.sleep(10000);
    }
}
