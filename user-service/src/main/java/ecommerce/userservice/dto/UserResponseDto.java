package ecommerce.userservice.dto;

import ecommerce.userservice.Model.UserEntity;

public record UserResponseDto
        (
                  String username,
                  String password,
                  String firstName,
                  String lastName,
                  String email
        )
{
    public static UserResponseDto UserEntityToDto(UserEntity user)
    {
        return new UserResponseDto
                (
                        user.getUsername(),
                        user.getPassword(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail()
                );
    }
}
