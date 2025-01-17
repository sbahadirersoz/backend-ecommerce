package ecommerce.cartservice.dto;

public record AddToCartTOItemDto
        (

                Integer amount,
                String name,
                Integer Stockamount,
                Double productPrice,
                String id,
                String username
        ) {
}
