package sej.springexample.querydsl;

import java.util.List;

//db 껍데기 커스텀
public interface UserRepositoryCustom {
    List findAllLike(String keyword);

    int maxAge();

    int minAge();
}
