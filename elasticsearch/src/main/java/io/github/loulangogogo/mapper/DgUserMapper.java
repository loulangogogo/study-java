package io.github.loulangogogo.mapper;

import io.github.loulangogogo.entity.DgUser;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DgUserMapper extends ElasticsearchRepository<DgUser, Long> {
}
