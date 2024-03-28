package com.example.orderservice.controller;

import com.example.orderservice.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")

public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/book")
    @Operation(summary = "Placing book order using title")
    public ResponseEntity<?> placeBookOrder(@RequestBody String bookTitle) {
        return orderService.placeBookOrder(bookTitle);
    }

    @GetMapping("/shop")
    @Operation(summary = "Grabbing list of all books for displaying in a viewable manner")
    public ResponseEntity<?> shopBooks(){
        return orderService.shopAll();
    }
}
