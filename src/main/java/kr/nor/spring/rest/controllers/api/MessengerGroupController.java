package kr.nor.spring.rest.controllers.api;

import kr.nor.spring.rest.dao.MessengerGroupDao;
import kr.nor.spring.rest.models.MessengerGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessengerGroupController {

    @Autowired
    private MessengerGroupDao messengerGroupDao;

    @RequestMapping(value = "/api/group", method = RequestMethod.GET)
    public Iterable<MessengerGroup> getMessengerGroup() {
        return messengerGroupDao.findAll();
    }

    @RequestMapping(value = "/api/group", method = RequestMethod.PUT)
    public void putMessengerGroup(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name) {
        messengerGroupDao.save(new MessengerGroup(id, name));
    }

}
