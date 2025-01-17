package ecommerce.orderservice.Service;

import ecommerce.orderservice.Client.ProductClient;
import ecommerce.orderservice.Client.ProductDtoClient;
import ecommerce.orderservice.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService
{
    private final  OrderRepository repository;
    private final ProductClient productClient;

    public OrderService(OrderRepository repository, ProductClient productClient) {
        this.repository = repository;
        this.productClient = productClient;
    }

    public List<ProductDtoClient>getAllProductsFromOrderService()
    {
        List<ProductDtoClient> productEntityDtos = productClient.getAllProducts();
        return productEntityDtos;
    }
}
