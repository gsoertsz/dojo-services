package org.distributedproficiency.dojo.services;

import org.distributedproficiency.dojo.domain.KataTag;

import java.util.Collection;

public interface KataTagService {

    void createKataTag(String name) throws KataTagAlreadyExists;

    Collection<KataTag> getAllTags();

    KataTag getTagByName(String name);

    KataTag getTagByTagId(Long id);
}
