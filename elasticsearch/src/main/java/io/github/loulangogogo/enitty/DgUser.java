package io.github.loulangogogo.enitty;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "dg_user")
public class DgUser {
    @Id
    private Long id;

    @Field(type = FieldType.Long)
    private Long age;

    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String address;

    @Field(type = FieldType.Text)
    private String phone;

}
