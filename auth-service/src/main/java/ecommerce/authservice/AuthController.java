package ecommerce.authservice;

import ecommerce.authservice.dto.LoginRequest;
import ecommerce.authservice.dto.RegisterDto;
import ecommerce.authservice.service.AuthService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController
{
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/test")
    public String test()
    {
        return "test basarili";
    }
    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody LoginRequest loginRequest)
    {
        System.out.println(loginRequest);
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto reg)     {

        authService.registerUserWithUserRequestDtoParameter(reg);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("{\"message\": \"Kayıt başarılı\"}");
    }
    }
