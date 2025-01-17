package ecommerce.cartservice.model;

import ecommerce.cartservice.Clients.models.ProductFromClientDto;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
public class CartItem
{
    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;
    private int quantity;
    private String ProductId;
    private String ProductName;
    private Double ProductPrice;
    @ManyToOne
    @JoinColumn(name = "Cart_id",nullable = false)

    private CartEntity cartEntity;

    public CartItem(int quantity, String productId, String productName, Double productPrice) {
        this.quantity = quantity;
        ProductId = productId;
        ProductName = productName;
        ProductPrice = productPrice;
    }

    public CartItem(ProductFromClientDto clientDto,Integer Amount , CartEntity cartEntity)
    {
        this.quantity = clientDto.getStockamount();
        this.ProductName = clientDto.getName();
        this.ProductPrice = clientDto.getProductPrice();
        this.ProductId = clientDto.getId();
        this.cartEntity = cartEntity;
    }
    public CartItem() {
    }


    public static CartItem createCartItem(ProductFromClientDto productFromClientDto)
      {
          return new CartItem
                  (
                          productFromClientDto.getStockamount(),
                          productFromClientDto.getId(),
                          productFromClientDto.getName(),
                          productFromClientDto.getProductPrice()
                  );
      }
    public String getId() {
        return id;
    }
    public CartEntity getCartEntity() {
        return cartEntity;
    }
    public void setCartEntity(CartEntity cartEntity) {
        this.cartEntity = cartEntity;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getProductId() {
        return ProductId;
    }
    public void setProductId(String productId) {
        ProductId = productId;
    }
    public String getProductName() {
        return ProductName;
    }
    public void setProductName(String productName) {
        ProductName = productName;
    }
    public Double getProductPrice() {
        return ProductPrice;
    }
    public void setProductPrice(Double productPrice) {
        ProductPrice = productPrice;
    }
}
