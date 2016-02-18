package org.distributedproficiency.dojo.services;

import org.distributedproficiency.dojo.domain.KataStatus;
import org.distributedproficiency.dojo.domain.KataStatusEvent;

import java.util.Date;

public class KataStatusEventUtils {
    private KataStatusEventUtils() { super(); }

    public static KataStatusEvent createWithFromTo(KataStatus from, KataStatus to, boolean withTimeStamp) {
        KataStatusEvent event = new KataStatusEvent();

        event.setFromStatus(from);
        event.setToStatus(to);
        if (withTimeStamp) {
            event.setStatusChangeDateTime(new Date());
        }

        return event;
    }
}
