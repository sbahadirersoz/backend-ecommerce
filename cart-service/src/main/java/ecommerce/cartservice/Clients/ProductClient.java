package ecommerce.cartservice.Clients;

import ecommerce.cartservice.Clients.models.ProductFromClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name ="product-service", url = "http://localhost:8083/api/v1/products")
public interface ProductClient {
    @GetMapping("/addtoCard/{id}")
    public ProductFromClientDto addToCart(String id);


    @GetMapping("/getProductById/{id}")
    public ProductFromClientDto getProductById(@PathVariable("id") String id);
}
