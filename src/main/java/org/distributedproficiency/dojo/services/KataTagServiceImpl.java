package org.distributedproficiency.dojo.services;

import org.distributedproficiency.dojo.domain.KataTag;
import org.distributedproficiency.dojo.repository.KataTagRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class KataTagServiceImpl implements KataTagService {

    @Autowired
    private KataTagRepository kataTagRepository;

    @Override
    public void createKataTag(String name) throws KataTagAlreadyExists {
        KataTag maybeKataTag = kataTagRepository.findByTagName(name);
        if (maybeKataTag != null) throw new KataTagAlreadyExists("tag already exists with name: " + name);
        else kataTagRepository.save(new KataTag(name));
    }

    @Override
    public Collection<KataTag> getAllTags() {
        return kataTagRepository.findAll();
    }

    @Override
    public KataTag getTagByName(String name) {
        return kataTagRepository.findByTagName(name);
    }

    @Override
    public KataTag getTagByTagId(Long id) {
        return kataTagRepository.getOne(id);
    }
}
