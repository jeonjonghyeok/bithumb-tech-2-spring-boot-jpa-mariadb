package jjh.api.order.controller;

import jjh.api.order.domain.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @GetMapping
    public List<Order> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    public Optional<Order> findById(@PathVariable long id) {
        return Optional.empty();
    }

    @PostMapping
    public void save(Order order) {

    }
    @PutMapping
    public void update(Order order){

    }
    @GetMapping("/exists/{id}")
    public boolean existsById(@PathVariable long id) {
        return false;
    }

    @GetMapping("/count")
    public long count() {
        return 0;
    }

    @DeleteMapping
    public void deleteById(long id) {

    }
}
