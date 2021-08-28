package jjh.api.user.service;

import jjh.api.user.domain.User;
import jjh.api.user.domain.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

//@Deprecated: 사용하지 않음.
@Component
public interface UserService {
    List<User> findAll();
    Optional<User> findById(long id);
    void save(User user);
    boolean existsById(long id);
    long count();
    void deleteById(long id);
    String signup(User user);
    UserDto signin(User user);
}
