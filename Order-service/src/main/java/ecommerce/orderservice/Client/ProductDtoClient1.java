package ecommerce.orderservice.Client;

import ecommerce.orderservice.Model.ProductCategory;

public record ProductDtoClient1
        (
                String name,
                String desc,
                Double price,
                ProductCategory productCategory
        )
{
    public static ProductDtoClient1 convertToClient1(ProductDtoClient productDtoClient)
    {
        return new ProductDtoClient1
                (
                        productDtoClient.name,
                        productDtoClient.description,
                        productDtoClient.price,
                        productDtoClient.productCategory
                );
    }
}
