package kr.nor.spring.rest.controllers;

import kr.nor.spring.rest.dao.MappingDao;
import kr.nor.spring.rest.services.Messenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SendController {
    @Autowired
    private Messenger messenger;


    @Autowired
    private MappingDao mappingDao;


}
