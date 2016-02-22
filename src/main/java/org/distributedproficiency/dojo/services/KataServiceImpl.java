package org.distributedproficiency.dojo.services;

import org.distributedproficiency.dojo.domain.*;
import org.distributedproficiency.dojo.repository.KataRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

public class KataServiceImpl implements KataService {

    @Autowired
    private KataAttemptService kataAttemptService;

    @Autowired
    private KataStatusEventService kataStatusEventService;

    @Autowired
    private KataRepository kataRepository;

    @Override
    public Collection<Kata> getAllKatasByAuthor(User u) {
        return kataRepository.findAll().stream().filter(
                (Kata k) -> { return k.getAuthor().getUsername().equalsIgnoreCase(u.getUsername()); }
        ).collect(Collectors.toList());
    }

    @Override
    public Kata getKataById(Long id) {
        return kataRepository.findOne(id);
    }

    @Override
    public Kata initiateCreateKata(User u) {
        // when security comes along, add the user as the author
        Kata newKata = new Kata();
        newKata.setAuthor(u);
        newKata.setStatus(KataStatus.CREATED);

        kataRepository.save(newKata);

        // log the creation event
        kataStatusEventService.appendKataStatusEvent(KataStatusEventUtils.createWithFromTo(null, KataStatus.CREATED, true));

        return newKata;
    }

    @Override
    public Kata saveKataPrePublish(Kata k) {
        k.setLastUpdatedDateTime(new Date());
        kataRepository.save(k);
        return k;
    }

    @Override
    public void publishKataById(Long id) {

    }

    @Override
    public KataAttempt initiateAttemptKata(User u, Long id) throws KataNotFoundException {
        Kata relevantKata = kataRepository.findOne(id);

        if (relevantKata == null) throw new KataNotFoundException("Could not find kata with id: ["+id+"]");

        // create a kata attempt
        KataAttempt attempt = new KataAttempt();
        attempt.setAttemptedTimeStamp(new Date());
        attempt.setAttemptor(u);
        attempt.setKata(relevantKata);
        attempt.setStatus(KataAttemptStatus.INITIATED);
        // TODO need to track an event transition for kata attempts here!
        attempt.setReviewer(relevantKata.getAuthor());
        kataAttemptService.saveKataAttempt(attempt);
        return attempt;
    }

    @Override
    public void editKata(Long id) {

    }

    @Override
    public void archiveKataById(Long id) {

    }
}
