package ecommerce.cartservice.Clients;

import ecommerce.cartservice.dto.UserDtoForCartService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "user-service" , url = "localhost:8081/api/v1/users/" )
public interface UserServiceClient
{
    @GetMapping("/getuserby/username")
    UserDtoForCartService getuserbyusername(String username);
}
