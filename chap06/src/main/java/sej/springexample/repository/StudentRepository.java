package sej.springexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sej.springexample.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
