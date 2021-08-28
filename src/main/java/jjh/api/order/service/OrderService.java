package jjh.api.order.service;

import jjh.api.order.domain.Order;
import jjh.api.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface OrderService {
    List<Order> findAll();
    Optional<Order> findById(long id);
    void save(Order order);
    boolean existsById(long id);
    long count();
    void deleteById(long id);

}
