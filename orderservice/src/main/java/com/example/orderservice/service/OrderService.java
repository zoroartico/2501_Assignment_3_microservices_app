package com.example.orderservice.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    private final RestTemplate restTemplate;

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<?> placeBookOrder(String bookTitle) {
        //utilizes other microservice api to gather book details
        String bookServiceUrl = "http://localhost:8080/api/books/" + bookTitle;
        String bookDetails = restTemplate.getForObject(bookServiceUrl, String.class);
        System.out.println("bookDetails: " + bookDetails);
        if (bookDetails == null) {
            return new ResponseEntity<>("Book Not found!", HttpStatus.NOT_FOUND);
        }
        System.out.println("Book found!");
        return new ResponseEntity<>("Order placed for Book:\n"+bookDetails, HttpStatus.OK);
    }
}
