package ecommerce.cartservice.dto;

import ecommerce.cartservice.model.CartItem;
public record AddToCartDto

        (
                String Id,
                Integer quantity
        )
{

}
