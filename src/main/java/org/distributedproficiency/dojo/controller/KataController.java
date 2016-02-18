package org.distributedproficiency.dojo.controller;


import org.distributedproficiency.dojo.domain.Kata;
import org.distributedproficiency.dojo.domain.User;
import org.distributedproficiency.dojo.services.KataService;
import org.distributedproficiency.dojo.swagger.DojoApiDocoWorthy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@DojoApiDocoWorthy
@RestController
public class KataController {

    @Autowired
    private KataService kataService;

    @RequestMapping(value = "/kata", method= RequestMethod.POST)
    public Kata initiateCreateNewKata() {
        return kataService.initiateCreateKata(User.create("gsoertsz"));
    }

    @RequestMapping(value= "/kata", method=RequestMethod.PUT)
    public Kata saveKata(@RequestBody Kata kataToSave) {
        return kataService.saveKataPrePublish(kataToSave);
    }
}
