package sej.springexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sej.springexample.model.UserEntity;

//db 쿼리 조작하는 부분
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserName(@Param("userName") String userName);
}
