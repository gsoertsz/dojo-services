package org.distributedproficiency.dojo.repository;

import org.distributedproficiency.dojo.domain.KataTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KataTagRepository extends JpaRepository<KataTag, Long> {

    @Query("select k from KataTag k where k.tagName = ?1")
    KataTag findByTagName(String tagName);
}
