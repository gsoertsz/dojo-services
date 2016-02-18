package org.distributedproficiency.dojo.repository;

import org.distributedproficiency.dojo.domain.KataAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KataAttemptRepository extends JpaRepository<KataAttempt, Long> {

}
