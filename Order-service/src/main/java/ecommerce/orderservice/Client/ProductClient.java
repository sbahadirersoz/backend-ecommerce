package ecommerce.orderservice.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@FeignClient( name = "product-service",url = "http://localhost:8083/api/v1/products/")
public interface ProductClient
{
    @GetMapping("/getAllProducts")
    public List<ProductDtoClient> getAllProducts();

}
