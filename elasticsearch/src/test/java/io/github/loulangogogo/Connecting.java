package io.github.loulangogogo;

import co.elastic.clients.elasticsearch.ElasticsearchAsyncClient;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.junit.Before;

public abstract class Connecting {

    // 定义一个 ElasticsearchClient 客户端
    protected ElasticsearchClient esClient = null;

    protected ElasticsearchAsyncClient esAsyncClient = null;

    /**
     * @description: 连接es
     * @param
     * @return
     * @exception
     * @author     :loulan
     * */
    @Before
    public void connect() {
        RestClient restClient = RestClient
                .builder(new HttpHost("192.168.2.82", 9200, "http"))
                .setDefaultHeaders(new Header[]{new BasicHeader("Authorization", "ApiKey ZkVMelpvOEJmZk9ldWtBZnUyZFQ6M0NSaFZ2OWFUd0tMNjNWV3N1RlhXUQ==")})
                .build();

        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        esClient = new ElasticsearchClient(transport);
        esAsyncClient = new ElasticsearchAsyncClient(transport);
    }
}
