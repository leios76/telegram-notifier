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

        model.addAttribute("mappings", mappingDao.findAll());
        model.addAttribute("messenger_groups", messenger.getGroups());

        //messenger.sendMessage("Sent from java spring");

        return "index";
    }
}
