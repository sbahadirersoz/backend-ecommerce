package ecommerce.inventoryservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/inventories")
public class Controller
{
    @GetMapping("/test")
    public String a ()
    {
        return "Hello World";
    }
}
