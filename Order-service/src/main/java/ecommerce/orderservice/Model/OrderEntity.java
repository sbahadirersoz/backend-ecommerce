package ecommerce.orderservice.Model;

import ecommerce.orderservice.Client.ProductDtoClient;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
public class OrderEntity
{
    @GeneratedValue
    @UuidGenerator
    @Id
    private String id;

}
