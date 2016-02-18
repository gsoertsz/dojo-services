package org.distributedproficiency.dojo.repository;

import org.distributedproficiency.dojo.domain.KataStatusEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KataStatusEventRepository extends JpaRepository<KataStatusEvent, Long> {
}
