package ecommerce.userservice.Service;

import ecommerce.userservice.Model.UserEntity;
import ecommerce.userservice.Model.UserRole;
import ecommerce.userservice.Repository.UserRepository;
import ecommerce.userservice.dto.UserRegisterDto;
import ecommerce.userservice.dto.UserResponseDto;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService
{


    private final UserRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserResponseDto getUserWithUsernameParameterResponseWithUserResponseDto(String username)
    {
            return UserResponseDto.UserEntityToDto(repository.findByUsername(username).orElseThrow(()->new RuntimeException("User not found")));
    }
    public ResponseEntity<String> registerUserWithUserRequestDtoParameter(UserRegisterDto userRegisterDto)
    {
        if (!repository.existsByUsername( userRegisterDto.username()))
        {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(userRegisterDto.username());
            userEntity.setPassword(bCryptPasswordEncoder.encode(userRegisterDto.password()));
            userEntity.setFirstName(userRegisterDto.firstName());
             userEntity.setLastName(userRegisterDto.lastName());
             userEntity.setEmail(userRegisterDto.email());
             userEntity.setRoles(UserRole.USER_ROLE);
             repository.save(userEntity);
            return ResponseEntity.ok("User registered successfully");
        }
        throw new RuntimeException("User found");

    }
    public List<UserResponseDto>getAllUsersWithNoParameterResponseWithResponseDto()
    {
        List<UserEntity> users = repository.findAll();
        if (users.isEmpty()) {
            throw new RuntimeException("Users dont exist");
        }
        return users.stream().map(UserResponseDto::UserEntityToDto).toList();
    }
    public UserResponseDto updateUserWithUserRequestDtoParameterResponseWithUserResponseDto(UserRegisterDto userRegisterDto)
    {
         {
             UserEntity user = repository.findById(userRegisterDto.username()).orElseThrow(()->new RuntimeException("User not found"));

            user.setUsername(userRegisterDto.username());
            user.setFirstName(userRegisterDto.firstName());
            user.setLastName(userRegisterDto.lastName());
            user.setEmail(userRegisterDto.email());
            repository.save(user);
            return UserResponseDto.UserEntityToDto(user);
        }
    }
    public String removeUserWithIdParameter(String id)
    {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "User deleted";
        }
        throw new RuntimeException("User not found");
    }
    public UserResponseDto getUserWithIdParameterResponseWithResponseDto(String id)


    {
            return UserResponseDto.UserEntityToDto(repository.findById(id).orElseThrow(()->new RuntimeException("User not found")));
    }
}
