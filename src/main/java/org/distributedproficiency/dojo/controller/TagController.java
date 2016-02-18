package org.distributedproficiency.dojo.controller;

import org.distributedproficiency.dojo.domain.KataTag;
import org.distributedproficiency.dojo.services.KataTagAlreadyExists;
import org.distributedproficiency.dojo.services.KataTagService;
import org.distributedproficiency.dojo.swagger.DojoApiDocoWorthy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@DojoApiDocoWorthy
@RestController
public class TagController {

    @Autowired
    private KataTagService kataTagService;

    @RequestMapping(value = "/tag", method = RequestMethod.POST)
    public void createTag(@RequestBody String name) throws KataTagAlreadyExists {
        kataTagService.createKataTag(name);
    }

    @RequestMapping(value = "/tag", method = RequestMethod.GET)
    public Collection<KataTag> getAllTags() {
        return kataTagService.getAllTags();
    }
}
