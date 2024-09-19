package io.github.loulangogogo;

import io.github.loulangogogo.entity.DgUser;
import io.github.loulangogogo.mapper.DgUserMapper;
import io.github.loulangogogo.water.json.JsonTool;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Test {

    @Autowired
    private DgUserMapper userMapper;

//    @PostConstruct
    public void test() {
        DgUser user = new DgUser();
        user.setId(1L);
        user.setName("yxq");
        user.setAge(22);
        user.setAddress("中国山西太原");
        user.setPhone("18509376997");
        DgUser save = userMapper.save(user);
        System.out.println(JsonTool.toJson(save));
    }

    @PostConstruct
    public void test02() {
        userMapper.findAll().forEach(o->{
            System.out.println(JsonTool.toJson(o));
        });
    }
}
