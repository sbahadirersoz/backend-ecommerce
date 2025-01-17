package ecommerce.userservice.dto;

import ecommerce.userservice.Model.UserEntity;

public record UserRegisterDto
        (
                String username,
                String password,
                String firstName,
                String lastName,
                String email
        )
{
    public static UserEntity toEntity(UserRegisterDto userRegisterDto)
    {
        return new UserEntity
                (
                        userRegisterDto.username(),
                        userRegisterDto.password(),
                        userRegisterDto.firstName(),
                        userRegisterDto.username(),
                        userRegisterDto.lastName()
                );
    }
}
