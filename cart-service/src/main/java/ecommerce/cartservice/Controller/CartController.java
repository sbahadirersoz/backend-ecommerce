package ecommerce.cartservice.Controller;

import ecommerce.cartservice.Clients.ProductClient;
import ecommerce.cartservice.Clients.models.ProductFromClientDto;
import ecommerce.cartservice.dto.AddToCartTOItemDto;
import ecommerce.cartservice.model.CartEntity;
import ecommerce.cartservice.service.CartService;
import ecommerce.cartservice.service.JwtValidatorCart;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {
    private final CartService cartService;
    private final JwtValidatorCart jwtValidatorCart;

    public CartController(CartService cartService, ProductClient productClient, JwtValidatorCart jwtValidatorCart) {
        this.cartService = cartService;
        this.jwtValidatorCart = jwtValidatorCart;
    }

    @PostMapping("/create")
    public ResponseEntity<CartEntity> createCart(@RequestHeader("Authorization") String token)
    {
        return cartService.createCartFromUsername(token);
    }

    @PostMapping("/addToCart")
    public ResponseEntity<String>addToCart(@RequestBody AddToCartTOItemDto addToCartDto)
    {
        cartService.addCartTOItem(addToCartDto);
       return ResponseEntity.ok("Added to Cart");
    }

    @DeleteMapping("/deleteFromCart/")
    public ResponseEntity<String> deleteById(@PathVariable("username")String Username,@RequestBody ProductFromClientDto clientDto,Integer Amount )
    {
        return ResponseEntity.ok("C");
    }
}

