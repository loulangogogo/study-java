package io.github.loulangogogo;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import io.github.loulangogogo.domain.User;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ApiDocument extends Connecting {

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
