package jjh.api.order.service;

import jjh.api.order.domain.Order;
import jjh.api.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public boolean existsById(long id) {
        return orderRepository.existsById(id);
    }

    @Override
    public long count() {
        return orderRepository.count();
    }

    @Override
    public void deleteById(long id) {
        orderRepository.deleteById(id);
    }
}
