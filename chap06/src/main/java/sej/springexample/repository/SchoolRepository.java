package sej.springexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sej.springexample.model.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
}
