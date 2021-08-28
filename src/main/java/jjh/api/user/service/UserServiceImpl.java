package jjh.api.user.service;

import jjh.api.security.domain.SecurityProvider;
import jjh.api.security.exception.SecurityRuntimeException;
import jjh.api.user.domain.Role;
import jjh.api.user.domain.User;
import jjh.api.user.domain.UserDto;
import jjh.api.user.repository.UserRepository;
import jjh.api.utils.Proxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Log
public class UserServiceImpl extends Proxy implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SecurityProvider securityProvider;
    private final AuthenticationManager manager;
    private final ModelMapper modelMapper;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean existsById(long id) {
        return userRepository.existsById(id);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public String signup(User user) {
        if(!userRepository.existsByUsername(user.getUsername())){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            List<Role> list = new ArrayList<>();
            list.add(Role.USER);
            user.setRoles(list);
            userRepository.save(user);
            log.info("user" + user);
            return securityProvider.createToken(user.getUsername(),user.getRoles());
        } else{
            throw new SecurityRuntimeException("중복된 ID 입니다", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public UserDto signin(User user) {
        try{
            UserDto userDto = modelMapper.map(user, UserDto.class);
            String token = (passwordEncoder.matches(
                    user.getPassword(),
                    userRepository.findByUsername(user.getUsername()).get().getPassword()))
                    ? securityProvider.createToken(user.getUsername(), userRepository.findByUsername(user.getUsername()).get().getRoles())
                    : "Wrong Password";
            ;
            userDto.setToken(token);
            return userDto;
        }catch (Exception e){
            throw  new SecurityRuntimeException("유효하지 않은 아이디 / 비밀번호",HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

}
