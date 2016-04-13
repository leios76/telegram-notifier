package kr.nor.spring.rest.controllers.api;

import kr.nor.spring.rest.dao.FieldDao;
import kr.nor.spring.rest.dao.MessengerGroupDao;
import kr.nor.spring.rest.models.Field;
import kr.nor.spring.rest.models.MessengerGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FieldController {

    @Autowired
    private FieldDao fieldDao;

    @RequestMapping(value = "/api/field", method = RequestMethod.GET)
    public Iterable<Field> getFields() {
        return fieldDao.findAll();
    }

    @RequestMapping(value = "/api/field", method = RequestMethod.PUT)
    public void putMessengerGroup(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name) {
        fieldDao.save(new Field(id, name));
    }

}
