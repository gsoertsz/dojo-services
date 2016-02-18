package org.distributedproficiency.dojo.services;

import org.distributedproficiency.dojo.domain.KataAttempt;

public interface KataAttemptService {

    void saveKataAttempt(KataAttempt k);

    void submitKataAttempt(KataAttempt k);
}
