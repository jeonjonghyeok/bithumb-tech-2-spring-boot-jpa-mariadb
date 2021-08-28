package jjh.api.user.controller;

import io.swagger.annotations.*;
import jjh.api.user.domain.User;
import jjh.api.user.domain.UserDto;
import jjh.api.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = "users") @RequiredArgsConstructor
@RestController
//table명 (꼭 일치하지 않아도 됨.)
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;
    private final ModelMapper modelMapper;

    @PostMapping("/signup")
    //swagger yaml
    @ApiOperation(value = "${UserController.signup}")
    @ApiResponses(value={
            @ApiResponse(code=400, message = "something wrong"),
            @ApiResponse(code=403, message = "승인거절"),
            @ApiResponse(code=422, message = "중복된 username")})
    public ResponseEntity<String> signup(@ApiParam("Signup User")
                                         @RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.signup(modelMapper.map(userDto,User.class)));
    }

    @PostMapping("/signin")
    @ApiOperation(value = "${UserController.signin}")
    @ApiResponses(value={
            @ApiResponse(code=400, message = "something wrong"),
            @ApiResponse(code=422, message = "유효하지 않은 아이디 / 비밀번호")})
    public ResponseEntity<UserDto> signin(@ApiParam("Signin User")
                                         @RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.signin(modelMapper.map(userDto,User.class)));
    }

    public List<User> findAll() {
        return null;
    }

    public Optional<User> findById(@PathVariable long id) {
        return Optional.empty();
    }

    public void save(User user) {

    }
    public void update(User user){

    }

    public boolean existsById(@PathVariable long id) {
        return false;
    }

    public long count() {
        return 0;
    }

    public void deleteById(long id) {

    }
}
