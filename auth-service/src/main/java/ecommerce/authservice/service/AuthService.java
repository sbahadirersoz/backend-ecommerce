package ecommerce.authservice.service;

import ecommerce.authservice.JwtTokenProvider;
import ecommerce.authservice.dto.LoginRequest;
import ecommerce.authservice.dto.RegisterDto;
import ecommerce.authservice.model.UserEntity;
import ecommerce.authservice.model.role.UserRole;
import ecommerce.authservice.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final CustomUserDetailsService customUserDetails;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public AuthService(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, CustomUserDetailsService customUserDetailsService, CustomUserDetailsService customUserDetails, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.customUserDetails = customUserDetails;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public ResponseEntity<?> login( LoginRequest loginRequest)
    {
        UserEntity user = userRepository.findByUsername(loginRequest.username()).orElseThrow(()->new RuntimeException("user not found"));
        if (!bCryptPasswordEncoder.matches(loginRequest.password(),user.getPassword()))
        {
            throw new RuntimeException("not found");
        }
        Authentication authentication = new UsernamePasswordAuthenticationToken(customUserDetails.loadUserByUsername(user.getUsername()),null);
        String jwtToken = jwtTokenProvider.generateJwtToken(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Map<String, String> response = new HashMap<>();
        response.put("token", jwtToken);
        return ResponseEntity.ok(response);
    }
    public ResponseEntity<String> registerUserWithUserRequestDtoParameter(RegisterDto userRegisterDto)
    {
        if (!userRepository.existsByUsername( userRegisterDto.username()))
        {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(userRegisterDto.username());
            userEntity.setPassword(bCryptPasswordEncoder.encode(userRegisterDto.password()));
            userEntity.setFirstName(userRegisterDto.firstName());
            userEntity.setLastName(userRegisterDto.lastName());
            userEntity.setEmail(userRegisterDto.email());
            userEntity.setRoles(UserRole.USER_ROLE);
            userRepository.save(userEntity);
            return ResponseEntity.ok("User registered successfully");
        }
        throw new RuntimeException("User found");

    }
}
