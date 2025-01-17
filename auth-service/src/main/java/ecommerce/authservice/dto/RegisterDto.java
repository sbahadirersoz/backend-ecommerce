package ecommerce.authservice.dto;

import ecommerce.authservice.model.UserEntity;

public record RegisterDto
        (
                String username,
                String password,
                String firstName,
                String lastName,
                String email
        ) {
    public static UserEntity toEntity(RegisterDto userRegisterDto) {
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
