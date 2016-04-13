package kr.nor.spring.rest.dao;

import kr.nor.spring.rest.models.Mapping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingDao extends CrudRepository<Mapping, Long> {

}
