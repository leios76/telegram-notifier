package kr.nor.spring.rest;

import kr.nor.spring.rest.dao.MappingDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApplicationTest {

    public static void main(String[] args) {


        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        MappingDao mappingDao = context.getBean(MappingDao.class);

    }
}
