package org.distributedproficiency.dojo.repository;

import org.distributedproficiency.dojo.domain.Kata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KataRepository extends JpaRepository<Kata, Long> {

}
