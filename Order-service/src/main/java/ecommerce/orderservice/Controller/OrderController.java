package ecommerce.orderservice.Controller;

import ecommerce.orderservice.Client.ProductDtoClient;
import ecommerce.orderservice.Client.ProductDtoClient1;
import ecommerce.orderservice.Service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController
{
private final OrderService service;
    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("getproductsByOrderController")
    public ResponseEntity<List<ProductDtoClient1>> getProductsByOrderService()
    {
 List<ProductDtoClient1> list=
     service.getAllProductsFromOrderService().stream().map(ProductDtoClient1::convertToClient1).collect(Collectors.toList());
        return  ResponseEntity.ok().body(list);
    }
}
