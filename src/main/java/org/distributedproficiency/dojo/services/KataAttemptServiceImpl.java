package org.distributedproficiency.dojo.services;

import org.distributedproficiency.dojo.domain.KataAttempt;
import org.distributedproficiency.dojo.repository.KataAttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class KataAttemptServiceImpl implements KataAttemptService {

    @Autowired
    private KataAttemptRepository kataAttemptRepository;

    @Override
    public void saveKataAttempt(KataAttempt k) {
        // pretty crude - need to add some business logic around this.
        kataAttemptRepository.save(k);
    }

    @Override
    public void submitKataAttempt(KataAttempt k) {

    }
}
