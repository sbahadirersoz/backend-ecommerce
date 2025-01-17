package ecommerce.orderservice.Client;

import ecommerce.orderservice.Model.OrderEntity;
import ecommerce.orderservice.Model.ProductCategory;
import jakarta.persistence.ManyToOne;
import jakarta.transaction.Transactional;

import ecommerce.orderservice.Model.ProductCategory;
@Transactional
public class ProductDtoClient
{   String name;
    String description;
    double price;
    ProductCategory productCategory;
    @ManyToOne
    OrderEntity product;

    public ProductDtoClient(String name, String description, double price, ProductCategory productCategory) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.productCategory = productCategory;
    }
}

