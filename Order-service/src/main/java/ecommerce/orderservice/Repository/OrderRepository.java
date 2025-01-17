package ecommerce.orderservice.Repository;

import ecommerce.orderservice.Model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {
}
