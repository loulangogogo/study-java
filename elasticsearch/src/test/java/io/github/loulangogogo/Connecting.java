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
     * 这个方法用于建立到Elasticsearch服务器的连接。
     * 它首先创建一个带有服务器详细信息和默认头的RestClient实例。
     * 然后，它创建一个带有RestClient和JacksonJsonpMapper的RestClientTransport实例。
     * 最后，它用RestClientTransport初始化ElasticsearchClient和ElasticsearchAsyncClient实例。
     *
     * @Before注解表示这个方法应该在JUnit的每个测试之前运行。
     *
     * @author loulan
     */
    @Before
    public void connect() {
        // 创建一个带有服务器详细信息和默认头的RestClient实例
        RestClient restClient = RestClient
                .builder(new HttpHost("192.168.2.82", 9200, "http"))
                .setDefaultHeaders(new Header[]{new BasicHeader("Authorization", "ApiKey ZkVMelpvOEJmZk9ldWtBZnUyZFQ6M0NSaFZ2OWFUd0tMNjNWV3N1RlhXUQ==")})
                .build();

        // 创建一个带有RestClient和JacksonJsonpMapper的RestClientTransport实例
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        // 用RestClientTransport初始化ElasticsearchClient实例
        esClient = new ElasticsearchClient(transport);

        // 用RestClientTransport初始化ElasticsearchAsyncClient实例
        esAsyncClient = new ElasticsearchAsyncClient(transport);
    }
}
