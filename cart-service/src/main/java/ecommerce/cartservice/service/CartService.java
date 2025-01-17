package ecommerce.cartservice.service;

import ecommerce.cartservice.Clients.ProductClient;
import ecommerce.cartservice.Clients.UserServiceClient;
import ecommerce.cartservice.Clients.models.ProductFromClientDto;
import ecommerce.cartservice.dto.AddToCartTOItemDto;
import ecommerce.cartservice.model.CartEntity;
import ecommerce.cartservice.model.CartItem;
import ecommerce.cartservice.repository.CartRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CartService {
    private final CartRepository repository;
    private final ProductClient productClient;
    private final UserServiceClient userServiceClient;
    private final JwtValidatorCart jwtValidatorCart;


    public CartService(CartRepository repository, ProductClient productClient, UserServiceClient userServiceClient, JwtValidatorCart jwtValidatorCart) {
        this.repository = repository;
        this.productClient = productClient;
        this.userServiceClient = userServiceClient;
        this.jwtValidatorCart = jwtValidatorCart;
    }

    public ResponseEntity<CartEntity> getCartFromUserId(@RequestHeader("Authorization") String token) {
        String jwt = token.substring(7);
        String username = jwtValidatorCart.getUsernameFromToken(jwt);
        CartEntity C = repository.findCartEntityByUsername(username).orElseThrow(() -> new NullPointerException("Does Not Exist"));
        return ResponseEntity.ok(C);
    }

    public ResponseEntity<CartEntity> createCartFromUsername(@RequestHeader("Authorization") String token) {
        String jwt = token.substring(7);
        String username = jwtValidatorCart.getUsernameFromToken(jwt);
        if (repository.findCartEntityByUsername(username).isEmpty()) {
            CartEntity C = new CartEntity(new Date(), username,new ArrayList<>());
            repository.save(C);
            return ResponseEntity.ok(C);
        }
        throw new RuntimeException("Cart Already Exist");
    }
// task Completed
    public ResponseEntity<String> addCartTOItem(AddToCartTOItemDto addToCartDto) {
//  Cart var mı diye kontrol et Cart Yoksa Cart Oluştur +
//  Urunun adeti var mi diye kontrol et eğer varsa +
//  Cart varsa Cartın içinde bu ürün var mı diye kontrol et +
// eğer bu ürün var ise şu anki istek ve sonraki isteğin toplamının stoktan fazla olup olmadığını kontrol et+
// eger kontrol ettiğinde büyük cıkıyorsa hata ver çıkmıyorsa ekleyerek devam ettir +

        CartItem newItem = CartItem.createCartItem(new  ProductFromClientDto(addToCartDto.name(), addToCartDto.Stockamount(), addToCartDto.productPrice(), addToCartDto.id()));

        if (repository.findCartEntityByUsername(addToCartDto.username())
               .isEmpty()&&addToCartDto.Stockamount()> addToCartDto.amount())
        {
              CreateCartEntityByUsernameAndAddItem(addToCartDto.username(),newItem) ;
        }

        CartEntity cart =  repository.findCartEntityByUsername(addToCartDto.username()).orElseThrow();
        if (cart.getItems() != null) {
            List<CartItem> Items = cart.getItems();
            for (CartItem item : Items) {
                if (item.getProductId().equals(addToCartDto.id())) {
                    if (item.getQuantity() + addToCartDto.amount() > addToCartDto.Stockamount()) {
                        throw new RuntimeException("Not Enough Quantity");
                    }
                    item.setQuantity(item.getQuantity() + addToCartDto.amount());
                    repository.save(cart);
                    return ResponseEntity.ok("Başarı  ile eklendi") ;
                }
            }
        }
        cart.setItems(new ArrayList<>());
        cart.getItems().add(newItem);
        repository.save(cart);
        return ResponseEntity.ok("Başarı ile eklendi");
    }

    private CartEntity CreateCartEntityByUsername(String Username) {
        CartEntity cartEntity = new CartEntity(new Date(), Username);
        repository.save(cartEntity);
        return cartEntity;
    }    private CartEntity CreateCartEntityByUsernameAndAddItem(String Username ,CartItem i) {
        CartEntity cartEntity = new CartEntity(new Date(), Username,new ArrayList<>());
        cartEntity.getItems().add(i);
        repository.save(cartEntity);
        return cartEntity;
    }
}
