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

    private Integer age;

    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String name;

    private String address;
    private String phone;

}
