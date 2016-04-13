package kr.nor.spring.rest.dao;

import kr.nor.spring.rest.models.MessengerGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessengerGroupDao extends CrudRepository<MessengerGroup, Long> {

}
