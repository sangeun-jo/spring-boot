package sej.springexample.querydsl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//db 기본 껍데기
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom{
    UserEntity findByUserName(@Param("username") String username);
}


