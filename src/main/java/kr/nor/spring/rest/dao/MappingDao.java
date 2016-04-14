package kr.nor.spring.rest.dao;

import kr.nor.spring.rest.models.Field;
import kr.nor.spring.rest.models.Mapping;
import kr.nor.spring.rest.models.MessengerGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingDao extends CrudRepository<Mapping, Long> {

    public Mapping findByField(Field field);
    public Mapping findByMessengerGroup(MessengerGroup messengerGroup);
}
