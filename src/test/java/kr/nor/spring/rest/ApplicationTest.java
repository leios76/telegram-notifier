package kr.nor.spring.rest;

import kr.nor.spring.rest.dao.FieldDao;
import kr.nor.spring.rest.dao.MappingDao;
import kr.nor.spring.rest.dao.MessengerGroupDao;
import kr.nor.spring.rest.models.Field;
import kr.nor.spring.rest.models.Mapping;
import kr.nor.spring.rest.models.MessengerGroup;
import org.joda.time.LocalTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.Time;

@SpringBootApplication
public class ApplicationTest {

    public static void main(String[] args) {


        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        MappingDao mappingDao = context.getBean(MappingDao.class);
        MessengerGroupDao messengerGroupDao = context.getBean(MessengerGroupDao.class);
        FieldDao fieldDao = context.getBean(FieldDao.class);

        Field field = new Field(1, "B지역");
        fieldDao.save(field);

        MessengerGroup messengerGroup = new MessengerGroup(-113879059, "B지역 - 새벽 근무조");
        messengerGroupDao.save(messengerGroup);

        Mapping mapping = new Mapping();
        mapping.setField(field);
        mapping.setMessengerGroup(messengerGroup);

        mapping.setStart(new Time(0, 0, 0));
        mapping.setEnd(new Time(8, 0, 0));

        mappingDao.save(mapping);
    }
}
