package org.distributedproficiency.dojo.services;

import org.distributedproficiency.dojo.domain.KataStatusEvent;

public interface KataStatusEventService {
    void appendKataStatusEvent(KataStatusEvent e);
}
