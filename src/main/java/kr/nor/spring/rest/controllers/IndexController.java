package kr.nor.spring.rest.controllers;

import kr.nor.spring.rest.dao.MappingDao;
import kr.nor.spring.rest.models.Mapping;
import kr.nor.spring.rest.models.MessengerGroup;
import kr.nor.spring.rest.services.Messenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private Messenger messenger;

    @Autowired
    private MappingDao mappingDao;

    @RequestMapping("/")
    public String index(Model model) {
        List<Mapping> registered_group = new ArrayList<>();
        List<MessengerGroup> unregistered_group = messenger.getGroups();

        Iterator<Mapping> iterator = mappingDao.findAll().iterator();
        while (iterator.hasNext()) {
            registered_group.add(iterator.next());
        }

        model.addAttribute("registered_groups", registered_group);
        model.addAttribute("unregistered_groups", unregistered_group);

        return "index";
    }
}
