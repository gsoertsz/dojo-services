package org.distributedproficiency.dojo.services;

import org.distributedproficiency.dojo.domain.Kata;
import org.distributedproficiency.dojo.domain.KataAttempt;
import org.distributedproficiency.dojo.domain.User;

import java.util.Collection;

public interface KataService {

    public Collection<Kata> getAllKatasByAuthor(User u);

    public Kata getKataById(Long id);

    public Kata initiateCreateKata(User creator);

    public Kata saveKataPrePublish(Kata k);

    public void publishKataById(Long id);

    public KataAttempt initiateAttemptKata(User u, Long id) throws KataNotFoundException;

    public void editKata(Long id);

    public void archiveKataById(Long id);
}
