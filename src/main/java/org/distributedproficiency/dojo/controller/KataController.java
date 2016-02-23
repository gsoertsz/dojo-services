package org.distributedproficiency.dojo.controller;


import org.distributedproficiency.dojo.domain.Kata;
import org.distributedproficiency.dojo.domain.User;
import org.distributedproficiency.dojo.dto.KataCreateRequest;
import org.distributedproficiency.dojo.dto.KataCreatedResponse;
import org.distributedproficiency.dojo.dto.KataSaveRequest;
import org.distributedproficiency.dojo.services.KataService;
import org.distributedproficiency.dojo.services.UserService;
import org.distributedproficiency.dojo.swagger.DojoApiDocoWorthy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;

@DojoApiDocoWorthy
@RestController
public class KataController {

    @Autowired
    private KataService kataService;

    @Autowired
    private UserService userService;

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/kata", method= RequestMethod.POST)
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public KataCreatedResponse initiateCreateNewKata(@RequestBody KataCreateRequest createRequest, HttpServletResponse response) {
        try {
            User u = userService.findUserByUsername(createRequest.getAuthorId());
            Kata created = kataService.initiateCreateKata(u);
            KataCreatedResponse createdResponse = new KataCreatedResponse(created.getId(), new Long(created.getCreatedDateTime().getTime()));
            return createdResponse;
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return null;
        }
    }

    @RequestMapping(value="/kata", method = RequestMethod.GET)
    public Collection<Kata> getAllKatasByAuthor(@RequestParam String u, HttpServletResponse response) {
        try {
            User user = userService.findUserByUsername(u);
            if (user != null) {
                return kataService.getAllKatasByAuthor(user);
            } else {
                response.setStatus(HttpStatus.NOT_FOUND.value());
            }
        } catch (Exception e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return null;
        }

        return new ArrayList<Kata>();
    }

    @RequestMapping(value = "/kata/{id}", method = RequestMethod.GET)
    public Kata getKataById(@RequestParam String id) {
        return kataService.getKataById(new Long(id).longValue());
    }

    @RequestMapping(value= "/kata/{id}", method=RequestMethod.PUT)
    public Kata saveKata(@RequestBody KataSaveRequest saveRequest, @RequestParam("id") String id, HttpServletResponse response) {
        Kata kataToUpdate = kataService.getKataById(new Long(id));
        if (kataToUpdate != null) {
            kataToUpdate.setKataContent(saveRequest.getNewContent());
            return kataService.saveKataPrePublish(kataToUpdate);
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }
}
