package org.distributedproficiency.dojo.services;

import org.distributedproficiency.dojo.domain.KataStatusEvent;
import org.distributedproficiency.dojo.repository.KataStatusEventRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class KataStatusEventServiceImpl implements KataStatusEventService {

    @Autowired
    private KataStatusEventRepository kataStatusEventRepository;

    @Override
    public void appendKataStatusEvent(KataStatusEvent e) {
        kataStatusEventRepository.save(e);
    }
}
