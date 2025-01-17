package ecommerce.cartservice.dto;

public record UserDtoForCartService
        (
                String username,
                String password,
                String firstName,
                String lastName,
                String email
        )
{
}
