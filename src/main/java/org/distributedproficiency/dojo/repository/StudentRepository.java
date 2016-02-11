package org.distributedproficiency.dojo.repository;

import org.distributedproficiency.dojo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
