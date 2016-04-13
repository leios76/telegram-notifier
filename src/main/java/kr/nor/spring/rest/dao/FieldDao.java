package kr.nor.spring.rest.dao;

import kr.nor.spring.rest.models.Field;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldDao extends CrudRepository<Field, Long> {

}
