package com.developermobile.course.resources;

import com.developermobile.course.entities.Order;
import com.developermobile.course.entities.User;
import com.developermobile.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderResources {
    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> userList = service.findAll();
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
