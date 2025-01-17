package ecommerce.userservice.Controller;

import ecommerce.userservice.Service.UserService;
import ecommerce.userservice.dto.UserRegisterDto;
import ecommerce.userservice.dto.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController
{
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/getall/users")
    public ResponseEntity<List<UserResponseDto>> getAllUsersWithNoParameterResponseWithResponseDtoController ()
    {
        List<UserResponseDto> u =  userService.getAllUsersWithNoParameterResponseWithResponseDto();
        return ResponseEntity.ok().body(u);
    }
    @GetMapping("/getuserby/{id}")
    public ResponseEntity<UserResponseDto> getUserWithIdParameterResponseWithResponseDtoController (@PathVariable String userId)
    {
        UserResponseDto u = (userService.getUserWithIdParameterResponseWithResponseDto(userId));
        return ResponseEntity.ok().body(u);
    }
    @GetMapping("/getuserby/username")
    public ResponseEntity<UserResponseDto> getUserWithUsernameParameterResponseWithResponseDtoController (@PathVariable String username)
    {
        UserResponseDto u = (userService.getUserWithUsernameParameterResponseWithUserResponseDto(username));
        return ResponseEntity.ok().body(u);
    }
    @PutMapping("/update/user")
    public ResponseEntity<UserResponseDto> updateUserWithUserRequestDtoParameterResponseWithUserResponseDtoController(@RequestBody UserRegisterDto userRegisterDto)
    {
        UserResponseDto u=  userService.updateUserWithUserRequestDtoParameterResponseWithUserResponseDto(userRegisterDto);
        return ResponseEntity.ok().body(u);
    }
      @DeleteMapping("/deleteuserby/{id}")
    public ResponseEntity<String> removeUserWithIdParameter(@PathVariable String userId)
    {
        String msg =  userService.removeUserWithIdParameter(userId);
        return ResponseEntity.ok().body(msg);
    }
    @PostMapping("/registeruser")
    public ResponseEntity<String>register(@RequestBody UserRegisterDto userRegisterDto)
    {
        return userService.registerUserWithUserRequestDtoParameter(userRegisterDto);
    }
}
